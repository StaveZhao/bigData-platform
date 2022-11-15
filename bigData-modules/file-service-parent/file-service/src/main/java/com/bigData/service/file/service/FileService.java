package com.bigData.service.file.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.file.api.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuwei
 * @since 2019-09-17
 */
public interface FileService extends BaseService<FileEntity> {

    FileEntity uploadFile(MultipartFile file);

    void deleteFileById(String id);
}
