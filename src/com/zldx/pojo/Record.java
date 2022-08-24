package com.zldx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private Integer id;
    private Integer user_id;
    private Integer car_id;
    private String start_date;
    private String return_date;
    private Double payment;
}
