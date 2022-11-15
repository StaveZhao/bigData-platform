package com.bigData.service.system.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.system.api.dto.DeptDto;
import com.bigData.service.system.api.entity.DeptEntity;
import com.bigData.service.system.api.vo.DeptVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeptMapper extends EntityMapper<DeptDto, DeptEntity, DeptVo> {
}
