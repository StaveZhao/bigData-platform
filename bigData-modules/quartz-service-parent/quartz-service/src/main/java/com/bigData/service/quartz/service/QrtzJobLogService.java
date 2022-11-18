package com.bigData.service.quartz.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.quartz.api.dto.QrtzJobLogDto;
import com.bigData.service.quartz.api.entity.QrtzJobLogEntity;

import java.util.List;

/**
 * <p>
 * 定时任务日志信息表 服务类
 * </p>
 */
public interface QrtzJobLogService extends BaseService<QrtzJobLogEntity> {

    void saveQrtzJobLog(QrtzJobLogDto qrtzJobLog);

    void updateQrtzJobLog(QrtzJobLogDto qrtzJobLog);

    QrtzJobLogEntity getQrtzJobLogById(String id);

    void deleteQrtzJobLogById(String id);

    void deleteQrtzJobLogBatch(List<String> ids);
}
