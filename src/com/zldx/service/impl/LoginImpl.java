package com.zldx.service.impl;

import com.zldx.dao.UserDao;
import com.zldx.dao.impl.UserDaoImpl;
import com.zldx.pojo.User;
import com.zldx.service.LoginService;

import java.sql.SQLException;

public class LoginImpl implements LoginService {
        private  UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        try {
            User user = userDao.selectName(username);
            if(user != null){
                if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                    return user;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

