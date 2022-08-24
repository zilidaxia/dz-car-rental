package com.zldx.dao;

import com.zldx.pojo.Category;
import com.zldx.pojo.Record;

import java.sql.SQLException;

public interface RecordDao {
    int insertRecord(Record record) throws SQLException;

    int updateRecord() throws SQLException;


}
