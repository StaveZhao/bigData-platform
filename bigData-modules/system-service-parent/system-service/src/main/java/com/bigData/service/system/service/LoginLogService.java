package com.bigData.service.system.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.system.api.entity.LoginLogEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 登录日志信息表 服务类
 * </p>
 */
public interface LoginLogService extends BaseService<LoginLogEntity> {

    void saveLoginLog(HttpServletRequest request);

    LoginLogEntity getLoginLogById(String id);

    void deleteLoginLogById(String id);

    void deleteLoginLogBatch(List<String> ids);
}
