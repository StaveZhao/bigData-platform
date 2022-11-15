package com.bigData.service.system.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.system.api.entity.RoleDeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 角色和部门关联表 Mapper 接口
 * </p>1.0.0
 */
@Mapper
public interface RoleDeptDao extends BaseDao<RoleDeptEntity> {

    void insertBatch(List<RoleDeptEntity> list);

    void deleteByRoleId(String id);

    void deleteByRoleIds(List<String> ids);
}
