package com.bigData.service.system.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.system.api.dto.DictDto;
import com.bigData.service.system.api.entity.DictEntity;
import com.bigData.service.system.api.vo.DictVo;
import org.mapstruct.Mapper;

/**
 * <p>
 * 字典编码信息表 Mapper 实体映射
 * </p>
 */
@Mapper(componentModel = "spring")
public interface DictMapper extends EntityMapper<DictDto, DictEntity, DictVo> {

}
