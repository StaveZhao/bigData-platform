package com.bigData.service.system.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.system.api.dto.PostDto;
import com.bigData.service.system.api.entity.PostEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>1.0.0
 */
public interface PostService extends BaseService<PostEntity> {

    PostEntity savePost(PostDto post);

    PostEntity updatePost(PostDto post);

    void deletePostById(String id);

    void deletePostBatch(List<String> ids);
}
