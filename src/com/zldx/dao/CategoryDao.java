package com.zldx.dao;

import com.zldx.pojo.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    Category selectOne(int id)throws SQLException;

    List<Category> selectAll()throws SQLException;
}
