package com.wjc.generator.entity;


import lombok.Data;

@Data
public class BaseEntity {

    private Integer pageNo;

    private Integer pageSize;

    private Object entity;

}
