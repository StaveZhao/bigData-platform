package com.bigData.service.system.service.impl;

import com.bigData.common.base.BaseServiceImpl;
import com.bigData.service.system.api.dto.LogDto;
import com.bigData.service.system.api.entity.LogEntity;
import com.bigData.service.system.dao.LogDao;
import com.bigData.service.system.mapstruct.LogMapper;
import com.bigData.service.system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LogServiceImpl extends BaseServiceImpl<LogDao, LogEntity> implements LogService {

    @Autowired
    private LogDao logDao;
    @Autowired
    private LogMapper logMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveLog(LogDto logDto) {
        LogEntity log = logMapper.toEntity(logDto);
        logDao.insert(log);
    }

    @Override
    public LogEntity getLogById(String id) {
        LogEntity logEntity = super.getById(id);
        return logEntity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteLogById(String id) {
        logDao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteLogBatch(List<String> ids) {
        logDao.deleteBatchIds(ids);
    }
}
