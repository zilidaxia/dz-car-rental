package com.zldx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Integer  id;
    private String car_number;
    private Integer brand_id;
    private String model;
    private String  color;
    private Integer category_id ;
    private String t_comments;
    private Double price;
    private Double rent;
    private Integer status;
    private Integer useable;

    private String image;

    private Category category;

    private Brand brand;

    public Car(Integer id, String car_number, Integer brand_id, String model, String color, Integer category_id, String t_comments, Double price, Double rent, Integer status, Integer useable) {
        this.id = id;
        this.car_number = car_number;
        this.brand_id = brand_id;
        this.model = model;
        this.color = color;
        this.category_id = category_id;
        this.t_comments = t_comments;
        this.price = price;
        this.rent = rent;
        this.status = status;
        this.useable = useable;
    }

}
