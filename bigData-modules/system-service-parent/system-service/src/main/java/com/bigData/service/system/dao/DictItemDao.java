package com.bigData.service.system.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.system.api.entity.DictItemEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 字典项信息表 Mapper 接口
 * </p>
 */
@Mapper
public interface DictItemDao extends BaseDao<DictItemEntity> {

}
