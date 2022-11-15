package com.bigData.service.system.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.system.api.dto.LogDto;
import com.bigData.service.system.api.entity.LogEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface LogService extends BaseService<LogEntity> {

    void saveLog(LogDto log);

    LogEntity getLogById(String id);

    void deleteLogById(String id);

    void deleteLogBatch(List<String> ids);
}
