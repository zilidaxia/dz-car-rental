package com.zldx.service;

import com.zldx.pojo.ResultData;
import com.zldx.pojo.User;

public interface LoginService {
    ResultData checkUserName(String username);
    ResultData login(String username, String password);

}
