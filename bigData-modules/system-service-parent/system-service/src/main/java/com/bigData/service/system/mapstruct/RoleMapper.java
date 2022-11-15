package com.bigData.service.system.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.system.api.dto.RoleDto;
import com.bigData.service.system.api.entity.RoleEntity;
import com.bigData.service.system.api.vo.RoleVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<RoleDto, RoleEntity, RoleVo> {
}
