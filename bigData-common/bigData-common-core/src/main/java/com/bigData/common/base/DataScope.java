package com.bigData.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据权限查询参数
 *
 * @NoArgsConstructor 作用于类，用于生成无参 构造方法
 * @AllArgsConstructor 作用于类，生成含有所有已声明字段属性参数的构造方法
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataScope {

    /**
     * 表的部门字段
     */
    private String deptScopeName = "create_dept";

    /**
     * 表的用户字段
     */
    private String userScopeName = "create_by";
}
