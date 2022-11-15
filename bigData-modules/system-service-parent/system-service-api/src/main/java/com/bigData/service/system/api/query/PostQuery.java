package com.bigData.service.system.api.query;

import com.bigData.common.base.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PostQuery extends BaseQueryParams {

    private static final long serialVersionUID=1L;

    /**
     * 岗位名称
     */
    private String postName;
}
