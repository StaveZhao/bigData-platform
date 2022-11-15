package com.bigData.service.system.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 登录日志信息表
 * </p>
 */
@Data
@Accessors(chain = true)
@TableName("sys_login_log")
public class LoginLogEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 操作系统
     */
    private String opOs;

    /**
     * 浏览器类型
     */
    private String opBrowser;

    /**
     * 登录IP地址
     */
    private String opIp;

    /**
     * 登录时间
     */
    private LocalDateTime opDate;

    /**
     * 登录用户ID
     */
    private String userId;

    /**
     * 登录用户名称
     */
    private String userName;
}
