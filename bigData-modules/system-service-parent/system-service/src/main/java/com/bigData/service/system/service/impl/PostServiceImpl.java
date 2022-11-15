package com.bigData.service.system.service.impl;

import com.bigData.common.base.BaseServiceImpl;
import com.bigData.common.exception.DataException;
import com.bigData.service.system.api.dto.PostDto;
import com.bigData.service.system.api.entity.PostEntity;
import com.bigData.service.system.dao.PostDao;
import com.bigData.service.system.mapstruct.PostMapper;
import com.bigData.service.system.service.PostService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>1.0.0
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PostServiceImpl extends BaseServiceImpl<PostDao, PostEntity> implements PostService {

    @Autowired
    private PostDao postDao;
    @Autowired
    private PostMapper postMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PostEntity savePost(PostDto postDto) {
        PostEntity post = postMapper.toEntity(postDto);
        int n = postDao.selectCount(Wrappers.<PostEntity>lambdaQuery().eq(PostEntity::getPostName, post.getPostName()));
        if(n > 0){
            throw new DataException("该岗位名已存在");
        }
        postDao.insert(post);
        return post;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PostEntity updatePost(PostDto postDto) {
        PostEntity post = postMapper.toEntity(postDto);
        postDao.updateById(post);
        return post;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePostById(String id) {
        postDao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePostBatch(List<String> ids) {
        postDao.deleteBatchIds(ids);
    }
}
