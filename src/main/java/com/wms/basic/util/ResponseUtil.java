package com.wms.basic.util;

import com.wms.basic.entity.ResponseEntity;

import java.util.List;

public class ResponseUtil {

    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    public static <T> ResponseEntity<T> responseSuccess(T entity){
        ResponseEntity<T> response = new ResponseEntity<T>();
        response.setEntity(entity);
        response.setMsg(SUCCESS);
        return response;
    }

    public static <T> ResponseEntity<T> responseSuccess(List<T> data){
        ResponseEntity<T> response = new ResponseEntity<T>();
        response.setData(data);
        response.setCount(data.size());
        response.setMsg(SUCCESS);
        return response;
    }

    public static <T> ResponseEntity<T> responseSuccess(Integer count){
        ResponseEntity<T> response = new ResponseEntity<T>();
        response.setCount(count);
        response.setMsg(SUCCESS);
        return response;
    }

    public static <T> ResponseEntity<T> responseError(Integer count){
        ResponseEntity<T> response = new ResponseEntity<T>();
        response.setMsg(ERROR);
        return response;
    }

}
