package com.zldx.dao;

import com.zldx.pojo.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDao {
    List<Car> selectAll(int pageNum,int pageSize) throws SQLException;

    int deleteCar(int id) throws SQLException;

    int updateCar(Car car) throws SQLException;

    int insertCar(Car car) throws SQLException;

    int selectCount() throws SQLException;

    List<Car> selectByCateId(int category_id)throws SQLException;
    List<Car> selectByBrandId(int brand_id)throws SQLException;


}
