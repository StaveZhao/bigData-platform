package com.bigData.service.system.api.query;

import com.bigData.common.base.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LogQuery extends BaseQueryParams {

    private static final long serialVersionUID=1L;

    /**
     * 日志标题
     */
    private String title;

    /**
     * 所属模块
     */
    private String module;

    /**
     * 用户名称
     */
    private String userName;
}
