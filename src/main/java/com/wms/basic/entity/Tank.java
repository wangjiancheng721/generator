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
@TableName("BASIC_XTANK")
public class Tank extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer tid;

    private String code;

    private String vcode;

    private String vendor;

    private String wcode;

    private String makername;

    private String tdate;

    private String edate;

    private Double tvol;

    private Integer tema;

    private Double sprice;

    private Double price;

    private Double taxrate;

    private Integer taxkubu;

    private Double soukingaku;

    private Double sousuuin;

    private Double aprice;

    private String hokan;

    private String note;

    private String sysnote;

    private Double inputdate;

    private String inputuser;


}
