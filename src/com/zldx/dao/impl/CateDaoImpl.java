package com.zldx.dao.impl;

import com.zldx.dao.CategoryDao;
import com.zldx.pojo.Category;
import com.zldx.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class CateDaoImpl implements CategoryDao {
    @Override
    public Category selectAll(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query("select * from t_category where id=?",new BeanHandler<>(Category.class),id);
    }
}
