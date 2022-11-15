package com.bigData.service.quartz.service;

import com.bigData.common.base.BaseServiceImpl;
import com.bigData.service.quartz.api.dto.QrtzJobLogDto;
import com.bigData.service.quartz.api.entity.QrtzJobLogEntity;
import com.bigData.service.quartz.dao.QrtzJobLogDao;
import com.bigData.service.quartz.mapstruct.QrtzJobLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 定时任务日志信息表 服务实现类
 * </p>
 *
 * @author yuwei
 * @since 2020-05-14
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class QrtzJobLogServiceImpl extends BaseServiceImpl<QrtzJobLogDao, QrtzJobLogEntity> implements QrtzJobLogService {

    @Autowired
    private QrtzJobLogDao qrtzJobLogDao;

    @Autowired
    private QrtzJobLogMapper qrtzJobLogMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveQrtzJobLog(QrtzJobLogDto qrtzJobLogDto) {
        QrtzJobLogEntity qrtzJobLog = qrtzJobLogMapper.toEntity(qrtzJobLogDto);
        qrtzJobLogDao.insert(qrtzJobLog);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateQrtzJobLog(QrtzJobLogDto qrtzJobLogDto) {
        QrtzJobLogEntity qrtzJobLog = qrtzJobLogMapper.toEntity(qrtzJobLogDto);
        qrtzJobLogDao.updateById(qrtzJobLog);
    }

    @Override
    public QrtzJobLogEntity getQrtzJobLogById(String id) {
        QrtzJobLogEntity qrtzJobLogEntity = super.getById(id);
        return qrtzJobLogEntity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteQrtzJobLogById(String id) {
        qrtzJobLogDao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteQrtzJobLogBatch(List<String> ids) {
        qrtzJobLogDao.deleteBatchIds(ids);
    }
}
