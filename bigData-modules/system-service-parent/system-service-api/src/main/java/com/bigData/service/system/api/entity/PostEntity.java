package com.bigData.service.system.api.entity;

import com.bigData.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_post")
public class PostEntity extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 岗位名称
     */
    private String postName;

}
