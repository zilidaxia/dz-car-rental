package com.zldx.dao.impl;

import com.zldx.dao.CarDao;
import com.zldx.pojo.Car;
import com.zldx.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class CarDaoImpl implements CarDao {
    @Override
    public List<Car> selectAll(int pageNum,int pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Object[] args = {(pageNum-1)*pageSize,pageSize};
        String sql ="select * from t_car limit ?,?";
        return qr.query(sql,new BeanListHandler<>(Car.class),args);
    }

    @Override
    public int deleteCar(int id) throws SQLException {
        QueryRunner qr = new QueryRunner();
        return qr.update(JDBCUtils.getConnection(),"delete from t_car where id =?",id);
    }

    @Override
    public int updateCar(Car car) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Object[] args={car.getImage(), car.getCar_number(),car.getBrand_id(),car.getModel(),car.getColor(),car.getCategory_id(), car.getT_comments(),car.getPrice(),car.getRent(),car.getStatus(),car.getUseable(),car.getId()};
        return qr.update(JDBCUtils.getConnection(),"update t_car set image=?, car_number=?,brand_id=?,model=?,color=?,category_id=?,t_comments=?,price=?,rent=?,status=?,useable=? where id=?",args );
    }

    @Override
    public int insertCar(Car car) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Object[] args={car.getId(),car.getImage(),car.getCar_number(),car.getBrand_id(),car.getModel(),car.getColor(),car.getCategory_id(), car.getT_comments(),car.getPrice(),car.getRent(),car.getStatus(),car.getUseable()};
        return qr.update(JDBCUtils.getConnection(),"insert into t_car values (?,?,?,?,?,?,?,?,?,?,?,?)",args);
    }

    @Override
    public int selectCount() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select count(*) from t_car";
        return qr.query(sql,new ScalarHandler<Long>()).intValue();

    }

    @Override
    public List<Car> selectByCateId(int category_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql ="select * from t_car where category_id = ?";
        return qr.query(sql,new BeanListHandler<>(Car.class),category_id);

    }

    @Override
    public List<Car> selectByBrandId(int brand_id) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql ="select * from t_car where brand_id = ?";
        return qr.query(sql,new BeanListHandler<>(Car.class),brand_id);
    }
}
