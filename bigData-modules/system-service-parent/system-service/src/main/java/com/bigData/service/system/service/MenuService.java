package com.bigData.service.system.service;

import com.bigData.common.base.BaseService;
import com.bigData.service.system.api.dto.MenuDto;
import com.bigData.service.system.api.entity.MenuEntity;

/**
 * <p>
 *  服务类
 * </p>1.0.0
 */
public interface MenuService extends BaseService<MenuEntity> {

    MenuEntity saveMenu(MenuDto menu);

    MenuEntity updateMenu(MenuDto menu);

    void deleteMenuById(String id);
}
