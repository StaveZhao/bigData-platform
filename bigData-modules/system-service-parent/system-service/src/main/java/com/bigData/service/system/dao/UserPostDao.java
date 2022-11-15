package com.bigData.service.system.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.system.api.entity.UserPostEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>1.0.0
 */
@Mapper
public interface UserPostDao extends BaseDao<UserPostEntity> {

    void insertBatch(List<UserPostEntity> list);

    void deleteByUserId(String id);

    void deleteByUserIds(List<String> ids);
}
