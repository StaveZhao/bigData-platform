package com.bigData.service.quartz.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.quartz.api.entity.QrtzJobEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 定时任务信息表 Mapper 接口
 * </p>
 *
 * @author yuwei
 * @since 2020-05-14
 */
@Mapper
public interface QrtzJobDao extends BaseDao<QrtzJobEntity> {

}
