package com.bigData.service.system.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.system.api.dto.PostDto;
import com.bigData.service.system.api.entity.PostEntity;
import com.bigData.service.system.api.vo.PostVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper extends EntityMapper<PostDto, PostEntity, PostVo> {
}
