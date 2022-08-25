package com.zldx.service;

import com.zldx.pojo.Car;
import com.zldx.pojo.ResultData;

import java.util.List;

public interface CarsService {
    //管理员查看所有汽车信息

    ResultData selectAll(String pageNum, String pageSize);

    //管理员添加汽车
    ResultData insertCar(Car car);
    //管理员修改汽车信息
    ResultData selectCarByCid(String cate_id);
    ResultData selectCarByBid(String brand_id);

    //分页查询
}
