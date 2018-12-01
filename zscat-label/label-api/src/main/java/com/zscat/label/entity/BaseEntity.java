package com.zscat.label.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseEntity
 *
 * @author zscat
 * Created on 2018/10/11 16:09
 */
@Data
public abstract class BaseEntity implements Serializable {
    protected static final long serialVersionUID = -3596948596278624676L;

    /** 0:未删除，1:已删除 */
    private Integer isDelete = 0;

    /** 创建时间 */
    private Date createTime = new Date();

    /** 创建人。userId */
    private Integer createUserId;

    /** 最后更新时间 */
    private Date lastUpdateTime = new Date();

    /** 最后更新人。userid */
    private Integer lastUpdateUserId;
}
