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
@TableName("BASIC_XCURR")
public class Curr implements Serializable {

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
