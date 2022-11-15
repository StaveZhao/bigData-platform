package com.bigData.service.system.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.system.api.dto.ConfigDto;
import com.bigData.service.system.api.entity.ConfigEntity;
import com.bigData.service.system.api.vo.ConfigVo;
import org.mapstruct.Mapper;

/**
 * <p>
 * 系统参数配置信息表 Mapper 实体映射
 * </p>
 */
@Mapper(componentModel = "spring")
public interface ConfigMapper extends EntityMapper<ConfigDto, ConfigEntity, ConfigVo> {

}
