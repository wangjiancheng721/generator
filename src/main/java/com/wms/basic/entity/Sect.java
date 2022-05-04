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
@TableName("BASIC_XSECT")
public class Sect extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String bumo;

    private String bname;

    private String desname;

    private String desnamegenp;

    private Integer gku;

    private Integer calen;

    private Integer calepowern;

    private Integer sortorder;

    private String bunrs;

    private String busho;

    private Double power;

    private Double rate;

    private Double arate;

    private Double yrate;

    private Integer doflat;

    private Double bfnorma;

    private Double toujitu;

    private Double norma;

    private Integer countorder;

    private Integer countokure;

    private Integer countsusumi;

    private Integer web;

    private Integer noansterm;

    private Integer mailterm;

    private String denppattern;

    private Integer tanksearchku;

    private Integer hasuugaku;

    private Integer hasuutax;

    private String lastsimedate;

    private String hito;

    private String tel;

    private String fax;

    private Integer sime;

    private String kamoku;

    private String curre;

    private String zip;

    private String adr1;

    private String adr2;

    private String mail;

    private String payeecode;

    private String note;

    private String sysnote;

    private Integer sectku;

    private Double inputdate;

    private String inputuser;


}
