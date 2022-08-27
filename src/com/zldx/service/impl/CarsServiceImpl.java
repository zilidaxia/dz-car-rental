package com.zldx.service.impl;

import com.zldx.dao.BrandDao;
import com.zldx.dao.CarDao;
import com.zldx.dao.CategoryDao;
import com.zldx.dao.impl.BrandDaoImpl;
import com.zldx.dao.impl.CarDaoImpl;
import com.zldx.dao.impl.CateDaoImpl;
import com.zldx.pojo.Brand;
import com.zldx.pojo.Car;
import com.zldx.pojo.Category;
import com.zldx.pojo.ResultData;
import com.zldx.service.CarsService;
import com.zldx.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class CarsServiceImpl implements CarsService {
    private CarDao carDao = new CarDaoImpl();
    private BrandDao brandDao = new BrandDaoImpl();
    private CategoryDao categoryDao =new CateDaoImpl();


    @Override
    public ResultData selectAll(String pageNum, String pageSize) {
        try {
            List<Car> carList = carDao.selectAll(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
           if (carList !=null&& carList.size()>0){
               long count = carDao.selectCount();
               for (Car car : carList) {
                   Brand brand = brandDao.selectAll(car.getBrand_id());
                   car.setBrand(brand);
                   Category category = categoryDao.selectOne(car.getCategory_id());
                   car.setCategory(category);
               }
               return new ResultData<>(0,"查询成功",carList,count);
           }else {
               return new ResultData<>(100,"暂无数据");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResultData<>(100,"查询失败");
    }



    @Override
    public ResultData insertCar(Car car) {
        try {
            JDBCUtils.begin();
            int count = carDao.insertCar(car);
            if (selectCarByBid(car.getBrand_id().toString())==null){
                int i = brandDao.insertOne(car.getBrand().getName());
                if (i>0){
                    return new ResultData(0,"添加品牌成功");
                }else {
                    return new ResultData(100,"添加品牌失败");
                }
            }
            if (count>0){
                JDBCUtils.commit();
                return new ResultData(0,"添加成功");
            }else {
            JDBCUtils.commit();
                return new ResultData(100,"添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCUtils.rollback();
            return new ResultData<>(100, "添加出错了");
        }

    }

    @Override
    public ResultData selectCarByCid(String cate_id) {
        return getResultData(cate_id);
    }

    @Override
    public ResultData selectAllCate() {
        try {
            List<Category> categories = categoryDao.selectAll();
            return new ResultData(0,"查询类别成功",categories);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResultData<>(100,"查询类别出错");
    }


    @Override
    public ResultData selectCarByBid(String brand_id) {
        return getResultData(brand_id);
    }

    public ResultData getResultData(String brand_id) {
        if (brand_id!=null){
            try {
                List<Car> carList = carDao.selectByCateId(Integer.parseInt(brand_id));
                if (carList!=null&&carList.size()>0){
                    return new ResultData(0,"按cate查询成功",carList);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return new ResultData(100,"按cateid查询失败");
    }


}
