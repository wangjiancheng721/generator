package com.wms.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wjc.generator.entity.BaseEntity;
import java.io.Serializable;
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
@TableName("BASIC_XCURR")
public class Curr extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String curre;

    private String tdate;

    private Double crates;

    private Double cratef;

    private String cope;

    private Integer cpointt;

    private Integer cpointg;

    private String note;

    private String sysnote;

    private Double inputdate;

    private String inputuser;


}
