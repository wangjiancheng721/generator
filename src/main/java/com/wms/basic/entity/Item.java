package com.wms.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wjc
 * @since 2022-03-21
 */
@Getter
@Setter
@TableName("BASIC_XITEM")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String bunr;

    private String bumo;

    private String vendor;

    private Integer fixlevel;

    private Double dkaku;

    private Double kaku;

    private Integer koteim;

    private Double stzaik;

    private Double lead;

    private Double kouki;

    private Integer hojyuu;

    private Integer kuriage;

    private String jcode;

    private Integer kouthiki;

    private String hokan;

    private String nextbumo;

    private Integer loth;

    private Double lots;

    private Double lots2;

    private Integer himoku;

    private Double furyou;

    private Double lead2;

    private Double tanikouki;

    private Double kouki2;

    private Integer linkslip;

    private Integer nokanri;

    private Integer pickku;

    private Double picklots;

    private Integer spickku;

    private Integer hctenkanri;

    private Integer changekaku;

    private Double maxzaik;

    private Double minzaik;

    private Integer stdcount;

    private Integer emacount;

    private Double zaikmin;

    private Double tempzaikmin;

    private Integer maxloth;

    private Double maxlots;

    private Integer lotht;

    private Double lotkikan;

    private Integer flatjyun;

    private String stzaikend;

    private String uchikiri;

    private Integer matomeh;

    private Integer calem;

    private Integer hikiku;

    private Double hikilots;

    private Integer minasikubu;

    private Double minasigendo;

    private String compo;

    private Integer dolotbunkatu;

    private Double pcapa;

    private Integer tankah;

    private Double ssumprice;

    private Double stumiprice;

    private Integer pket;

    private Integer gakuj;

    private Integer kanzanz;

    private Integer kanzanp;

    private Integer kanzanza;

    private Integer kanzanj;

    private Integer kanzanv;

    private Double kanzank;

    private String tani2;

    private String dfaku;

    private String dfaku2;

    private String dfjku;

    private String dfjku2;

    private Integer kensa;

    private String kdesname;

    private String slnohd;

    private String setgrp;

    private Double setgrpratio;

    private Integer kigenkubu;

    private Integer kigen;

    private Double actlimit;

    private Double hikilimit;

    private String note;

    private String sysnote;

    private Double inputdate;

    private String inputuser;


}
