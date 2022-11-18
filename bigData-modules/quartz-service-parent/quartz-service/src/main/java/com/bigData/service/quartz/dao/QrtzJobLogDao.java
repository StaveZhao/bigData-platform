package com.bigData.service.quartz.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.quartz.api.entity.QrtzJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 定时任务日志信息表 Mapper 接口
 * </p>
 */
@Mapper
public interface QrtzJobLogDao extends BaseDao<QrtzJobLogEntity> {

}
