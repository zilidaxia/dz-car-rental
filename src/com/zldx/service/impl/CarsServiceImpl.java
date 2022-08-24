package com.zldx.service.impl;

import com.zldx.dao.CarDao;
import com.zldx.dao.impl.CarDaoImpl;
import com.zldx.pojo.Car;
import com.zldx.pojo.PageBean;
import com.zldx.service.CarsService;
import com.zldx.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class CarsServiceImpl implements CarsService {
    private CarDao carDao = new CarDaoImpl();
    @Override
    public List<Car> selectAll() {
        try {
            return carDao.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insertCar(Car car) {
        try {
            JDBCUtils.begin();
            int count = carDao.insertCar(car);
            JDBCUtils.commit();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCUtils.rollback();
        }
        return 0;
    }

    @Override
    public int updateCar(Car car) {
        try {
            JDBCUtils.begin();
            int count = carDao.updateCar(car);
            JDBCUtils.commit();
            return count;
        }catch (SQLException e) {
            e.printStackTrace();
            JDBCUtils.rollback();
        }
        return 0;
    }

    @Override
    public PageBean selectPage(String pNum, String pSize) {
        //处理参数
        int pageNum =1;//默认参数
        if (pNum!=null){
            pageNum = Integer.parseInt(pNum);
        }
        int pageSize =3;
        if(pSize != null){
            pageSize = Integer.parseInt(pSize);
        }

        try {
            List<Car> carList = carDao.selectPage(pageNum,pageSize);
            int totalSize = carDao.selectCount();
            //页数满一页？不满就只有一页
            int totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;

            //封装分页查询的数据结果
            PageBean pageBean = new PageBean();
            pageBean.setTotalSize(totalSize);
            pageBean.setTotalPages(totalPage);
            pageBean.setPageSize(pageSize);
            pageBean.setPageNum(pageNum);
            pageBean.setData(carList);
            return pageBean;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
