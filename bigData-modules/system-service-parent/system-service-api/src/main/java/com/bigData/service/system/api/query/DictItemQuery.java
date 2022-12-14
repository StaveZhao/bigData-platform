package com.bigData.service.system.api.query;

import com.bigData.common.base.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典项信息表 查询实体
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DictItemQuery extends BaseQueryParams {

    private static final long serialVersionUID=1L;

    /**
     * 字典id
     */
    private String dictId;
    private String itemText;
    private String itemValue;
}
