package com.rui.dao.login;

import com.rui.entity.login.UserCustom;

/**
 * Created by Administrator on 2017/3/2.
 */
public interface UserDao {
    public UserCustom getUserByUsername(UserCustom userCustom) throws Exception;
}
