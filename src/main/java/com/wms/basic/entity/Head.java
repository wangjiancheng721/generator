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
@TableName("BASIC_XHEAD")
public class Head implements Serializable {

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
