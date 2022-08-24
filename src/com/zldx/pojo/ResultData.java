package com.zldx.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T> {
    //自定义响应码 0表示成功  1失败 2表示xxx失败

    private Integer code;//响应码

    private String msg;//响应信息

    private T data;//响应数据

    private Long count;//分页数据个数

    //不包含多跳数据，返回单个数据时
    public ResultData(Integer code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //仅返回响应码数据时
    public ResultData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
