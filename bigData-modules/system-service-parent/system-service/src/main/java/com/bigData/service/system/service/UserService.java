package com.bigData.service.system.service;

import com.bigData.common.base.BaseService;
import com.bigData.common.base.DataScope;
import com.bigData.service.system.api.dto.UserDto;
import com.bigData.service.system.api.dto.UserPasswordDto;
import com.bigData.service.system.api.entity.UserEntity;
import com.bigData.service.system.api.vo.UserInfo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface UserService extends BaseService<UserEntity> {

    UserEntity saveUser(UserDto user);

    UserEntity updateUser(UserDto user);

    void deleteUserById(String id);

    void deleteUserBatch(List<String> ids);

    UserInfo getUserByUsername(String username);

    IPage<UserEntity> pageDataScope(IPage<UserEntity> page, Wrapper<UserEntity> queryWrapper, DataScope dataScope);

    void updateUserPassword(UserPasswordDto user);

    void resetUserPassword(UserPasswordDto user);

    Map<String, Object> getRouteById();

    List<UserEntity> getAuditUsers();
}
