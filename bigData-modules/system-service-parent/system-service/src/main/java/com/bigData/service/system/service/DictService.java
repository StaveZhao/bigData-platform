package com.bigData.service.system.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.system.api.dto.DictDto;
import com.bigData.service.system.api.entity.DictEntity;
import com.bigData.service.system.api.entity.DictItemEntity;

import java.util.List;

/**
 * <p>
 * 字典编码信息表 服务类
 * </p>
 */
public interface DictService extends BaseService<DictEntity> {

    DictEntity saveDict(DictDto dict);

    DictEntity updateDict(DictDto dict);

    void deleteDictById(String id);

    void deleteDictBatch(List<String> ids);

    List<DictItemEntity> getDictItems(String code);

    void refreshDict();
}
