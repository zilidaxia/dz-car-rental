package com.zldx.dao.impl;

import com.zldx.dao.CategoryDao;
import com.zldx.pojo.Category;
import com.zldx.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CateDaoImpl implements CategoryDao {
    @Override
    public Category selectOne(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query("select * from t_category where id=?",new BeanHandler<>(Category.class),id);
    }

    @Override
    public List<Category> selectAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return qr.query("select * from t_category",new BeanListHandler<>(Category.class));

    }
}
