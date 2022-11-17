package com.bigData.service.email.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.email.api.dto.EmailDto;
import com.bigData.service.email.api.entity.EmailEntity;
import com.bigData.service.email.api.vo.EmailVo;
import org.mapstruct.Mapper;

/**
 * <p>
 * 数据集信息表 Mapper 实体映射
 * </p>
 *
 * @author yuwei
 * @since 2020-03-20
 */
@Mapper(componentModel = "spring")
public interface EmailMapper extends EntityMapper<EmailDto, EmailEntity, EmailVo> {

}
