package com.bigData.service.system.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.system.api.entity.RoleEntity;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 */
@Mapper
public interface RoleDao extends BaseDao<RoleEntity> {

    @Override
    RoleEntity selectById(Serializable id);

    @Override
    <E extends IPage<RoleEntity>> E selectPage(E page, @Param(Constants.WRAPPER) Wrapper<RoleEntity> queryWrapper);
}
