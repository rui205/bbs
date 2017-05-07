package com.rui.service.impl.login;

import com.rui.dao.base.UserMapper;
import com.rui.dao.login.UserDao;
import com.rui.dto.login.UserDTO;
import com.rui.entity.base.User;
import com.rui.entity.login.UserCustom;
import com.rui.service.login.RegisterService;
import com.rui.util.Base;
import com.rui.util.MD5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/2.
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserDao userDao;
    public void register(UserDTO userDTO) {
        UserCustom userCustom = userDTO.getUserCustom();
        userCustom.getUser().setCreateDate(new Date());
        userCustom.getUser().setUpdateDate(new Date());
        try {
            //this.userMapper.insert(userCustom.getUser());
            this.userMapper.insertSelective(userCustom.getUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public Account getUser(int id) {
        Account acct = new Account();
        try {
            //acct = this.userDao.getUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acct;
    }*/

    public User isLogin(UserDTO userDTO) {
        UserCustom userCustom = new UserCustom();
        try{
            userCustom = this.userDao.getUserByUsername(userDTO.getUserCustom());
            if(userDTO.getUserCustom().getUser().getUsername().equals(userCustom.getUser().getUsername())&&
                    Base.encryptBASE(MD5.getResult(userDTO.getUserCustom().getUser().getPassword()).getBytes())
                            .equals(userCustom.getUser().getPassword())){
                return userCustom.getUser();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
