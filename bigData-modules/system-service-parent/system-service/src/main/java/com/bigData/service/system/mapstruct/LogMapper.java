package com.bigData.service.system.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.system.api.dto.LogDto;
import com.bigData.service.system.api.entity.LogEntity;
import com.bigData.service.system.api.vo.LogVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogMapper extends EntityMapper<LogDto, LogEntity, LogVo> {
}
