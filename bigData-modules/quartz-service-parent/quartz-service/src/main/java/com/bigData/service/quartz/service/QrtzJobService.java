package com.bigData.service.quartz.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.quartz.api.dto.QrtzJobDto;
import com.bigData.service.quartz.api.entity.QrtzJobEntity;

/**
 * <p>
 * 定时任务信息表 服务类
 * </p>
 */
public interface QrtzJobService extends BaseService<QrtzJobEntity> {

    void saveQrtzJob(QrtzJobDto qrtzJob);

    void updateQrtzJob(QrtzJobDto qrtzJob);

    QrtzJobEntity getQrtzJobById(String id);

    void deleteQrtzJobById(String id);

    void pauseById(String id);

    void resumeById(String id);

    void runById(String id);
}
