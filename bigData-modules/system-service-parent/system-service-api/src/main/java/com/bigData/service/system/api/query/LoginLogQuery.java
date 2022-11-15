package com.bigData.service.system.api.query;

import com.bigData.common.base.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 登录日志信息表 查询实体
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LoginLogQuery extends BaseQueryParams {

    private static final long serialVersionUID=1L;

    /**
     * 登录用户名称
     */
    private String userName;
}
