package com.zldx.dao;

import com.zldx.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    int insertUser(User user) throws SQLException;

    int updateUser(User user) throws SQLException;

    int deleteUser(User user) throws SQLException;

    List<User> selectAll(User user);

    User selectOne(int id) throws SQLException;
    User selectName(String username) throws SQLException;
}
