package com.bigData.service.file.mapstruct;

import com.bigData.common.mapstruct.EntityMapper;
import com.bigData.service.file.api.dto.FileDto;
import com.bigData.service.file.api.entity.FileEntity;
import com.bigData.service.file.api.vo.FileVo;
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
public interface FileMapper extends EntityMapper<FileDto, FileEntity, FileVo> {

}
