package com.bigData.service.system.service.impl;

import com.bigData.common.base.BaseServiceImpl;
import com.bigData.common.core.DataConstant;
import com.bigData.common.core.RedisConstant;
import com.bigData.common.redis.service.RedisService;
import com.bigData.service.system.api.dto.ConfigDto;
import com.bigData.service.system.api.entity.ConfigEntity;
import com.bigData.service.system.dao.ConfigDao;
import com.bigData.service.system.mapstruct.ConfigMapper;
import com.bigData.service.system.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统参数配置信息表 服务实现类
 * </p>
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ConfigServiceImpl extends BaseServiceImpl<ConfigDao, ConfigEntity> implements ConfigService {

    @Autowired
    private ConfigDao configDao;

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private RedisService redisService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ConfigEntity saveConfig(ConfigDto sysConfigDto) {
        ConfigEntity config = configMapper.toEntity(sysConfigDto);
        configDao.insert(config);
        return config;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ConfigEntity updateConfig(ConfigDto sysConfigDto) {
        ConfigEntity config = configMapper.toEntity(sysConfigDto);
        configDao.updateById(config);
        return config;
    }

    @Override
    public ConfigEntity getConfigById(String id) {
        ConfigEntity configEntity = super.getById(id);
        return configEntity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteConfigById(String id) {
        configDao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteConfigBatch(List<String> ids) {
        configDao.deleteBatchIds(ids);
    }

    @Override
    public String getConfig(String key) {
        Object o = redisService.hget(RedisConstant.SYSTEM_CONFIG_KEY, key);
        return (String) Optional.ofNullable(o).orElse("");
    }

    @Override
    public void refreshConfig() {
        String key = RedisConstant.SYSTEM_CONFIG_KEY;
        Boolean hasKey = redisService.hasKey(key);
        if (hasKey) {
            redisService.del(key);
        }
        List<ConfigEntity> configEntityList = configDao.queryConfigList(DataConstant.EnableState.ENABLE.getKey());
        Map<String, Object> map = configEntityList.stream().collect(Collectors.toMap(ConfigEntity::getConfigKey, ConfigEntity::getConfigValue));
        redisService.hmset(key, map);
    }
}
