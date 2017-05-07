package com.rui.controller.login;

import com.rui.entity.base.User;

/**
 * Created by Administrator on 2017/3/3.
 */
public class UserFormBean {
    private User user = new User();

    public UserFormBean(User user) {
        this.user = user;
    }

    public UserFormBean() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
