package com.bigData.service.system.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.system.api.entity.LoginLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 登录日志信息表 Mapper 接口
 * </p>
 */
@Mapper
public interface LoginLogDao extends BaseDao<LoginLogEntity> {

}
