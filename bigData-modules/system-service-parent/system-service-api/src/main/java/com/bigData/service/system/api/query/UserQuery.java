package com.bigData.service.system.api.query;

import com.bigData.common.base.BaseQueryParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserQuery extends BaseQueryParams {

    private static final long serialVersionUID=1L;

    /**
     * 用户名称
     */
    private String username;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 部门ID
     */
    private String deptId;
}
