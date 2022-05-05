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
public class Head extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    private String mainbumo;

    private Integer dofukusuu;

    private Integer doseiban;

    private Integer seibhku;

    private Integer dorirekioya;

    private Integer dorirekiko;

    private Integer dolot;

    private Integer projonly;

    private String tani1;

    private Integer oyak;

    private String note;

    private String sysnote;

    private String plantid;

    private Double inputdate;

    private String inputuser;


}
