package com.zldx.dao;

import com.zldx.pojo.Brand;

import java.sql.SQLException;

public interface BrandDao {
    Brand selectAll(int id) throws SQLException;

    int insertOne(String name)throws SQLException;
}
