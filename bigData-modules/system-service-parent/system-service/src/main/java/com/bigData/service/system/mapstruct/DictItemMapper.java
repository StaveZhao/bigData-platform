package com.bigData.service.system.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.system.api.dto.DictItemDto;
import com.bigData.service.system.api.entity.DictItemEntity;
import com.bigData.service.system.api.vo.DictItemVo;
import org.mapstruct.Mapper;

/**
 * <p>
 * 字典项信息表 Mapper 实体映射
 * </p>
 */
@Mapper(componentModel = "spring")
public interface DictItemMapper extends EntityMapper<DictItemDto, DictItemEntity, DictItemVo> {

}
