package com.bigData.service.system.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.system.api.dto.MenuDto;
import com.bigData.service.system.api.entity.MenuEntity;
import com.bigData.service.system.api.vo.MenuVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuMapper extends EntityMapper<MenuDto, MenuEntity, MenuVo> {
}
