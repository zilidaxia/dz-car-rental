package com.zldx.dao.impl;

import com.zldx.dao.UserDao;
import com.zldx.pojo.User;
import com.zldx.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public int insertUser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql="INSERT INTO t_user VALUES(?,?,?,?,?,?,?,?) ";
        Object[] args={user.getId(),user.getUsername(),user.getPassword(),user.getSex(),user.getId_number(),user.getTel(),user.getAddr(),user.getType()};
        return qr.update(JDBCUtils.getConnection(),sql,args);
    }

    @Override
    public int updateUser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql="update t_user set username=?,password=?,sex=?,id_number=?,tel=?,addr=?,type=? where id = ? ";
        Object[] args={user.getUsername(),user.getPassword(),user.getSex(),user.getId_number(),user.getTel(),user.getAddr(),user.getType(),user.getId()};
        return qr.update(JDBCUtils.getConnection(),sql,args);
    }

    @Override
    public int deleteUser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql= "delete from t_user where id =?";
        return qr.update(JDBCUtils.getConnection(),sql,user.getId());
    }

    @Override
    public List<User> selectAll(User user) {
        return null;
    }

    @Override
    public User selectOne(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return qr.query("select * from t_user where id=?", new BeanHandler<User>(User.class),id);
    }

    @Override
    public User selectName(String username) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return qr.query("select * from t_user where username=?", new BeanHandler<User>(User.class),username);
    }

}
