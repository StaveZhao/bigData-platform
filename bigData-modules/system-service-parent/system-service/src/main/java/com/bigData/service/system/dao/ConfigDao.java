package com.bigData.service.system.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.system.api.entity.ConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统参数配置信息表 Mapper 接口
 * </p>
 */
@Mapper
public interface ConfigDao extends BaseDao<ConfigEntity> {

    /**
     * 查询有效参数集合
     *
     * @return
     * @param status
     */
    List<ConfigEntity> queryConfigList(@Param("status") String status);
}
