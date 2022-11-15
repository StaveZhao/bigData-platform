package com.bigData.service.system.api.query;

import com.bigData.common.base.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典编码信息表 查询实体
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DictQuery extends BaseQueryParams {

    private static final long serialVersionUID=1L;

    private String dictName;
    private String dictCode;
}
