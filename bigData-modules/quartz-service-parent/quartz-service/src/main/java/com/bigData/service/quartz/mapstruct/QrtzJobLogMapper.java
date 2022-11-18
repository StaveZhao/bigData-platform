package com.bigData.service.quartz.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.quartz.api.dto.QrtzJobLogDto;
import com.bigData.service.quartz.api.entity.QrtzJobLogEntity;
import com.bigData.service.quartz.api.vo.QrtzJobLogVo;
import org.mapstruct.Mapper;

/**
 * <p>
 * 定时任务日志信息表 Mapper 实体映射
 * </p>
 */
@Mapper(componentModel = "spring")
public interface QrtzJobLogMapper extends EntityMapper<QrtzJobLogDto, QrtzJobLogEntity, QrtzJobLogVo> {

}
