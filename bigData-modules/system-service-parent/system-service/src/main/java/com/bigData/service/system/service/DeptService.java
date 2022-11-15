package com.bigData.service.system.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.system.api.dto.DeptDto;
import com.bigData.service.system.api.entity.DeptEntity;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface DeptService extends BaseService<DeptEntity> {

    DeptEntity saveDept(DeptDto dept);

    DeptEntity updateDept(DeptDto dept);

    void deleteDeptById(String id);
}
