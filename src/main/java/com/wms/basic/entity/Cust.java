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
public class Cust extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private String cust;

    private Integer skytermsm;

    private Integer skytermsd;

    private Integer taxh;

    private String cname;

    private String desname;

    private String desnamegenp;

    private String desnameskyu;

    private Integer calen;

    private Double ylead;

    private Integer delnaijikikan;

    private Double overtake;

    private Integer hasuugaku;

    private Integer hasuutax;

    private String bunrc;

    private String busho;

    private String hito;

    private String tel;

    private String fax;

    private Integer sime;

    private String lastsimedate;

    private String kamoku;

    private String curre;

    private String zip;

    private String adr1;

    private String adr2;

    private String mail;

    private String note;

    private String sysnote;

    private Integer custku;

    private String linkcust;

    private Double inputdate;

    private String inputuser;


}
