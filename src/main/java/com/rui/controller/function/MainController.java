package com.rui.controller.function;

import com.rui.entity.base.User;
import com.rui.entity.login.TieCustom;
import com.rui.service.login.TieService;
import com.rui.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */
@Controller
@RequestMapping("main")
public class MainController {
    private static Log logger = LogFactory.getLog(MainController.class);
    @Resource
    private HttpServletRequest request;

    @Resource
    private TieService tieService;
    @RequestMapping("init")
    public String init(Model model){
        ServletContext context = request.getServletContext();
        if(context.getAttribute("userMap") == null){
            context.setAttribute("userMap",new HashMap<String,User>());
        }
        return "function/main";
    }

    @RequestMapping("search")
    public String search(){
        return "function/searchTie";
    }

    @RequestMapping("head")
    public String head(){
        return "function/head";
    }

    @RequestMapping("postAjax")
    public String postAjax(HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        List<TieCustom> list = new ArrayList<TieCustom>();
        String offset = request.getParameter("offset");
        String rows = request.getParameter("rows");
        String condition = request.getParameter("condition");
        try {
            Integer p1 = Integer.parseInt(offset);
            Integer p2 = Integer.parseInt(rows);
            list = this.tieService.findByCondition(p1,p2,condition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        for(int i = 0;i < list.size();i ++){
            jsonObject = JSONObject.fromObject(list.get(i),jsonConfig);
            //JSONArray.fromObject()
            jsonArray.add(jsonObject);
        }
        Writer out = null;
        try {
            out = response.getWriter();
            if(list.size() == 0)
                out.write('0');
            else
                out.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("toLast")
    public String toLast(HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        String condition = request.getParameter("condition");
        int count = 0;
        try {
            count = this.tieService.countTie(condition);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Writer out = null;
        try {
            out = response.getWriter();
            out.write((int)Math.ceil(count/20.0)+"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
