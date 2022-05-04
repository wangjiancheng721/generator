package com.wms.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wjc
 * @since 2022-03-22
 */
@Getter
@Setter
@TableName("BASIC_XBAIK")
public class Baik extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer bid;

    private String code;

    private String ccode;

    private String cust;

    private String tdate;

    private String edate;

    private Double tvol;

    private Double price;

    private Double aprice;

    private Double taxrate;

    private Integer taxkubu;

    private Double sousuuout;

    private Double sououtkingaku;

    private String fdate;

    private String hokan;

    private String note;

    private String sysnote;

    private Double inputdate;

    private String inputuser;


}
