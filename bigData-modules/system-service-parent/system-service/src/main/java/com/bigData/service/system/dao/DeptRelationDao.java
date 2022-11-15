package com.bigData.service.system.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.system.api.entity.DeptRelationEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 部门关系表 Mapper 接口
 * </p>1.0.0
 */
@Mapper
public interface DeptRelationDao extends BaseDao<DeptRelationEntity> {

    void insertBatch(List<DeptRelationEntity> list);

    void deleteByAncestor(String id);
}
