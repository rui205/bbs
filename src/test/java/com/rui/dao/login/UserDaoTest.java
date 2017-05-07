package com.rui.dao.login;

import com.rui.dto.login.UserDTO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/3/6.
 */
public class UserDaoTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        UserDao userDao = (UserDao) context.getBean("userCustomDao");
        UserDTO userDTO = new UserDTO();

    }
}
