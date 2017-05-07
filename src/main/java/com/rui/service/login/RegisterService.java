package com.rui.service.login;

import com.rui.dto.login.UserDTO;
import com.rui.entity.base.User;

/**
 * Created by Administrator on 2017/3/2.
 */
public interface RegisterService {
    public void register(UserDTO userDTO);
    /*public Account getUser(int id);*/
    public User isLogin(UserDTO userDTO);
}
