package com.bigData.service.system.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.system.api.entity.RoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>1.0.0
 */
@Mapper
public interface RoleMenuDao extends BaseDao<RoleMenuEntity> {

    void insertBatch(List<RoleMenuEntity> list);

    void deleteByRoleId(String id);

    void deleteByRoleIds(List<String> ids);
}
