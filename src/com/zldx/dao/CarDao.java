package com.zldx.dao;

import com.zldx.pojo.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDao {
    List<Car> selectAll() throws SQLException;

    int deleteCar(int id) throws SQLException;

    int updateCar(Car car) throws SQLException;

    int insertCar(Car car) throws SQLException;

    List<Car> selectPage(int pageNum,int pageSize) throws SQLException;

    int selectCount() throws SQLException;


}
