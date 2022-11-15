package com.bigData.service.system.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.system.api.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>1.0.0
 */
@Mapper
public interface MenuDao extends BaseDao<MenuEntity> {

    List<MenuEntity> selectMenuByRoleIds(@Param("roleIds") List<String> roleIds);

    List<MenuEntity> selectMenuByUserId(@Param("userId") String userId);
}
