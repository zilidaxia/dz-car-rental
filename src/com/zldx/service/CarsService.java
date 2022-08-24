package com.zldx.service;

import com.zldx.pojo.Car;
import com.zldx.pojo.PageBean;

import java.util.List;

public interface CarsService {
    //管理员查看汽车信息
    List<Car> selectAll();
    //管理员添加汽车
    int insertCar(Car car);
    //管理员修改汽车信息
    int updateCar(Car car);
    //分页查询
    PageBean selectPage(String pNum, String pSize);
}
