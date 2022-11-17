package com.bigData.service.email.dao;

import com.bigData.common.base.BaseDao;
import com.bigData.service.email.api.entity.EmailEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailDao extends BaseDao<EmailEntity> {
}
