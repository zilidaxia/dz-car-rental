package com.zldx.service.impl;

import com.zldx.dao.UserDao;
import com.zldx.dao.impl.UserDaoImpl;
import com.zldx.pojo.ResultData;
import com.zldx.pojo.User;
import com.zldx.service.LoginService;

import java.sql.SQLException;

public class LoginImpl implements LoginService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public ResultData checkUserName(String username) {//验证用户名是否存在
        try {
            User user = userDao.selectName(username);
            if (user != null && user.getUsername().equals(username)) { //用户存在
                return new ResultData(0, "用户存在");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ResultData(100, "用户不存在");
    }

    @Override
    public ResultData login(String username, String password) {
        try {
            User user = userDao.selectName(username);
            if (user != null) {
                if (!username.equals(user.getUsername())) {
                    return new ResultData(100, "用户名错误(注意区分大小写)");
                }
                if (!password.equals(user.getPassword())) {
                    return new ResultData(100, "用户密码不正确");
                }
                if (user.getType() == 0) {
                    return new ResultData(100, "你不是管理员");
                }
                //防止密码传入前端，清空密码
                user.setPassword("");
                return new ResultData(0, "登录成功", user);
            } else {
                return new ResultData(100, "用户名错误");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ResultData(100, "登录失败");
    }
}

