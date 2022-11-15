package com.bigData.service.system.service.impl;

import com.bigData.common.base.BaseServiceImpl;
import com.bigData.service.system.api.dto.DictItemDto;
import com.bigData.service.system.api.entity.DictItemEntity;
import com.bigData.service.system.dao.DictItemDao;
import com.bigData.service.system.mapstruct.DictItemMapper;
import com.bigData.service.system.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 字典项信息表 服务实现类
 * </p>
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictItemServiceImpl extends BaseServiceImpl<DictItemDao, DictItemEntity> implements DictItemService {

    @Autowired
    private DictItemDao dictItemDao;

    @Autowired
    private DictItemMapper dictItemMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DictItemEntity saveDictItem(DictItemDto dictItemDto) {
        DictItemEntity dictItem = dictItemMapper.toEntity(dictItemDto);
        dictItemDao.insert(dictItem);
        return dictItem;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DictItemEntity updateDictItem(DictItemDto dictItemDto) {
        DictItemEntity dictItem = dictItemMapper.toEntity(dictItemDto);
        dictItemDao.updateById(dictItem);
        return dictItem;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDictItemById(String id) {
        dictItemDao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDictItemBatch(List<String> ids) {
        dictItemDao.deleteBatchIds(ids);
    }
}
