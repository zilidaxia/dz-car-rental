package com.zldx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean<T> { //分页实体类
    private Integer totalSize; // 总条数
    private Integer totalPages; //总页数
    private Integer pageNum;  //页码
    private Integer pageSize; //每页条数
    private List<T> data; //每一页的数据
}
