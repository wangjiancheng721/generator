package com.wms.basic.entity;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author wjc
 * @since 2022-03-22
 */
@Data
public class Prts extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private String code;

    private String rev;

    private String chggrp;

    private String kcode;

    private Integer keda;

    private String bumo;

    private String opt;

    private Double siyou;

    private Double siyouw;

    private Double siyouf;

    private Double furyou;

    private String sdate;

    private String edate;

    private Integer nokanri;

    private String note;

    private String sysnote;

    private Double inputdate;

    private String inputuser;


}
