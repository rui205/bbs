package com.rui.dto.login;

import com.rui.entity.login.UserCustom;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/3.
 */
public class UserDTO implements Serializable{
    private static final long serialVersionUID = -6656726313888896577L;
    private UserCustom userCustom = new UserCustom();

    public UserDTO() {
    }

    public UserDTO(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
