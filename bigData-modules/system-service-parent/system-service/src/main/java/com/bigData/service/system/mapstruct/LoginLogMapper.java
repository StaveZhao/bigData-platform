package com.bigData.service.system.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.system.api.dto.LoginLogDto;
import com.bigData.service.system.api.entity.LoginLogEntity;
import com.bigData.service.system.api.vo.LoginLogVo;
import org.mapstruct.Mapper;

/**
 * <p>
 * 登录日志信息表 Mapper 实体映射
 * </p>
 */
@Mapper(componentModel = "spring")
public interface LoginLogMapper extends EntityMapper<LoginLogDto, LoginLogEntity, LoginLogVo> {

}
