package com.bigData.service.system.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.system.api.dto.RoleDto;
import com.bigData.service.system.api.entity.RoleEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface RoleService extends BaseService<RoleEntity> {

    RoleEntity saveRole(RoleDto role);

    RoleEntity updateRole(RoleDto role);

    void deleteRoleById(String id);

    void deleteRoleBatch(List<String> ids);
}
