package com.rui.controller.login;

import com.rui.dto.login.UserDTO;
import com.rui.entity.base.User;
import com.rui.service.login.RegisterService;
import com.rui.util.Base;
import com.rui.util.MD5;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/28.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static Log logger = LogFactory.getLog(LoginController.class);
    @Resource
    private HttpServletRequest request;
    @Resource
    private RegisterService registerService;
    @RequestMapping("/toRegister")
    public String toRegister(Model model){
        model.addAttribute("userFormBean",new UserFormBean());
        return "login/register";
    }

    @RequestMapping("/init")
    public String init(Model model){
        model.addAttribute("userFormBean",new UserFormBean());
        return "login/login";
    }

    @RequestMapping("/isLogin")
    public String isLogin(Model model,@ModelAttribute UserFormBean userFormBean){
        UserDTO userDTO = new UserDTO();
        User user = new User();
        BeanUtils.copyProperties(userFormBean.getUser(),user);
        userDTO.getUserCustom().setUser(user);
        logger.info("------"+userDTO.getUserCustom().getUser().getUsername()+"------");
        user = this.registerService.isLogin(userDTO);
        if(user == null){
            model.addAttribute("userFormBean",userFormBean);
            return "login/login";
        }

        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        if(context.getAttribute("userMap") == null){
            context.setAttribute("userMap",new HashMap<String,User>());
        }
        Map<String,User> userMap = (Map<String,User>) context.getAttribute("userMap");
        userMap.put(session.getId(),user);
        return "login/loginSuccess";
    }

    @RequestMapping("/register")
    public String register(Model model, @ModelAttribute UserFormBean userFormBean) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.getUserCustom().setUser(userFormBean.getUser());
        userDTO.getUserCustom().getUser().setPassword(
                Base.encryptBASE(MD5.getResult(userDTO.getUserCustom().getUser().getPassword()).getBytes()));
        this.registerService.register(userDTO);
        model.addAttribute("userFormBean",userFormBean);
        return "login/login";
    }

    @RequestMapping("logout")
    public String logout(Model model){
        ServletContext context = request.getServletContext();
        Map userMap = (Map) context.getAttribute("userMap");
        userMap.remove(request.getSession().getId());
        request.getSession().invalidate();
        logger.info("用户已注销");
        return "function/head";
    }

   /* public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
    }*/

}
