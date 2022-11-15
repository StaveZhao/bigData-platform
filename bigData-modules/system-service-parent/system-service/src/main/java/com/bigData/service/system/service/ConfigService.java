package com.bigData.service.system.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.system.api.dto.ConfigDto;
import com.bigData.service.system.api.entity.ConfigEntity;

import java.util.List;

/**
 * <p>
 * 系统参数配置信息表 服务类
 * </p>
 */
public interface ConfigService extends BaseService<ConfigEntity> {

    ConfigEntity saveConfig(ConfigDto sysConfig);

    ConfigEntity updateConfig(ConfigDto sysConfig);

    ConfigEntity getConfigById(String id);

    void deleteConfigById(String id);

    void deleteConfigBatch(List<String> ids);

    String getConfig(String key);

    void refreshConfig();
}
