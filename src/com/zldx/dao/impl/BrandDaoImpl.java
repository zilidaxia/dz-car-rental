package com.zldx.dao.impl;

import com.zldx.dao.BrandDao;
import com.zldx.pojo.Brand;
import com.zldx.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class BrandDaoImpl implements BrandDao {
    @Override
    public Brand selectAll(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return qr.query("select * from t_brand where id =?",new BeanHandler<>(Brand.class),id);
    }
}
