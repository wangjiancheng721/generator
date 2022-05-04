package com.wms.basic.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseEntity<T> {

    private String msg;

    private Integer count;

    private Object entity;

    private List<T> data;
}
