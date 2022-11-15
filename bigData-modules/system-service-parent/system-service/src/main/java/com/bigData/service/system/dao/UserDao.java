package com.bigData.service.system.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.system.api.entity.UserEntity;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {

    void updateUserPassword(@Param("password") String passwordEncode, @Param("id")String id);

    @Override
    UserEntity selectById(Serializable id);

    @Override
    UserEntity selectOne(@Param(Constants.WRAPPER) Wrapper<UserEntity> queryWrapper);

    @Override
    <E extends IPage<UserEntity>> E selectPage(E page, @Param(Constants.WRAPPER) Wrapper<UserEntity> queryWrapper);

    List<UserEntity> getAuditUsers(@Param("roleCode") String roleCode, @Param("userId") String userId);
}
