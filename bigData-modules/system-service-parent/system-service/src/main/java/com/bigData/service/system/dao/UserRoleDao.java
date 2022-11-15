package com.bigData.service.system.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.system.api.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 */
@Mapper
public interface UserRoleDao extends BaseDao<UserRoleEntity> {

    void insertBatch(List<UserRoleEntity> list);

    void deleteByUserId(String id);

    void deleteByUserIds(List<String> ids);
}
