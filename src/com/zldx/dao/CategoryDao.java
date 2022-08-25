package com.zldx.dao;

import com.zldx.pojo.Category;

import java.sql.SQLException;

public interface CategoryDao {
    Category selectAll(int id)throws SQLException;
}
