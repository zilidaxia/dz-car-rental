package com.zldx.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JacksonUtils {
      private  static final ObjectMapper MAPPER = new ObjectMapper();

      //将java对象转换成json字符串
    public static String objToString(Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //将json字符串转换成java对象
    public static <T> T jsonToObj(String json,Class<T> c){

        try {
            return MAPPER.readValue(json,c);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("属性不一致");
        }
        return null;
    }
    //将json字符串转换成java集合
    public static <T> T jsonToList(String json,Class<T> c){
        try {
            return MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(List.class,c));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("属性不一致");
        }
        return null;
    }

}


