package com.bigData.service.quartz.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.quartz.api.dto.QrtzJobDto;
import com.bigData.service.quartz.api.entity.QrtzJobEntity;
import com.bigData.service.quartz.api.vo.QrtzJobVo;
import org.mapstruct.Mapper;

/**
 * <p>
 * 定时任务信息表 Mapper 实体映射
 * </p>
 */
@Mapper(componentModel = "spring")
public interface QrtzJobMapper extends EntityMapper<QrtzJobDto, QrtzJobEntity, QrtzJobVo> {

}
