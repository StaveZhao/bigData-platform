package com.bigData.service.system.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.system.api.dto.DictItemDto;
import com.bigData.service.system.api.entity.DictItemEntity;

import java.util.List;

/**
 * <p>
 * 字典项信息表 服务类
 * </p>
 */
public interface DictItemService extends BaseService<DictItemEntity> {

    DictItemEntity saveDictItem(DictItemDto dictItem);

    DictItemEntity updateDictItem(DictItemDto dictItem);

    void deleteDictItemById(String id);

    void deleteDictItemBatch(List<String> ids);
}
