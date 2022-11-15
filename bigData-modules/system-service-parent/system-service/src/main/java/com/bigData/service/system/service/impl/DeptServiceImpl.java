package com.bigData.service.system.service.impl;

import com.bigData.common.base.BaseServiceImpl;
import com.bigData.common.exception.DataException;
import com.bigData.service.system.api.dto.DeptDto;
import com.bigData.service.system.api.entity.DeptEntity;
import com.bigData.service.system.api.entity.DeptRelationEntity;
import com.bigData.service.system.dao.DeptDao;
import com.bigData.service.system.dao.DeptRelationDao;
import com.bigData.service.system.mapstruct.DeptMapper;
import com.bigData.service.system.service.DeptService;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeptServiceImpl extends BaseServiceImpl<DeptDao, DeptEntity> implements DeptService {
    
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private DeptRelationDao deptRelationDao;
    @Autowired
    private DeptMapper deptMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DeptEntity saveDept(DeptDto deptDto) {
        DeptEntity dept = deptMapper.toEntity(deptDto);
        int n = deptDao.selectCount(Wrappers.<DeptEntity>lambdaQuery().eq(DeptEntity::getDeptName, dept.getDeptName()));
        if(n > 0){
            throw new DataException("该部门名已存在");
        }
        deptDao.insert(dept);
        insertBatchRelation(dept);
        return dept;
    }

    private void insertBatchRelation(DeptEntity dept) {
        List<DeptRelationEntity> relationList = deptRelationDao
                .selectList(Wrappers.<DeptRelationEntity>lambdaQuery()
                        .eq(DeptRelationEntity::getDescendant, dept.getParentId()))
                .stream().map(relation -> {
                    relation.setDescendant(dept.getId());
                    return relation;
                }).collect(Collectors.toList());
        DeptRelationEntity own = new DeptRelationEntity();
        own.setDescendant(dept.getId());
        own.setAncestor(dept.getId());
        relationList.add(own);
        if (CollUtil.isNotEmpty(relationList)) {
            deptRelationDao.insertBatch(relationList);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DeptEntity updateDept(DeptDto deptDto) {
        DeptEntity dept = deptMapper.toEntity(deptDto);
        deptDao.updateById(dept);
        deptRelationDao.delete(Wrappers.<DeptRelationEntity>lambdaQuery()
                .eq(DeptRelationEntity::getAncestor, dept.getId()));
        insertBatchRelation(dept);
        return dept;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDeptById(String id) {
        int n = deptDao.selectCount(Wrappers.<DeptEntity>lambdaQuery().eq(DeptEntity::getParentId, id));
        if(n > 0){
            throw new DataException("该部门下存在子部门数据");
        }
        deptDao.deleteById(id);
        deptRelationDao.deleteByAncestor(id);
    }
}
