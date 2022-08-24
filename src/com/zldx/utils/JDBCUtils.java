package com.zldx.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    //定义数据库连接池
    private static final DataSource  dataSource;

    static {
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            //初始化连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //返回连接池对象
    public static DataSource getDataSource() {
        return dataSource;
    }

    //创建线程集合保证connect唯一
    static ThreadLocal<Connection> tl = new ThreadLocal<>();

    //封装连接
    public static Connection getConnection() {
        Connection conn = tl.get();
        try {
            if (conn == null) {
                //连接池中获取
                conn = dataSource.getConnection();
                tl.set(conn);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    //事务封装
    public static void begin() {
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit() {
        Connection connection = getConnection();
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            tl.remove();
        }
    }

    public static void rollback() {
        Connection connection = getConnection();
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
                tl.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeCo( Connection conn){
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void closePs(PreparedStatement conn){
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void closeRs(ResultSet conn){
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
