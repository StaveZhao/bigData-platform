package com.bigData.service.system.controller;

import com.bigData.common.base.BaseController;
import com.bigData.common.core.R;
import com.bigData.common.security.annotation.DataInner;
import com.bigData.service.system.api.vo.UserInfo;
import com.bigData.service.system.service.UserService;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenStore tokenStore;

    @DataInner
    @GetMapping("/login/username/{username}")
    public UserInfo loginByUsername(@PathVariable String username) {
        UserInfo userInfo = userService.getUserByUsername(username);
        return userInfo;
    }

    @DeleteMapping("/logout/{token}")
    public R logout(@PathVariable("token") String token) {
        if (StrUtil.isBlank(token)) {
            return R.error("退出失败，Token为空");
        }
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
        if (accessToken == null || StrUtil.isBlank(accessToken.getValue())) {
            return R.ok();
        }
        tokenStore.removeAccessToken(accessToken);
        OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
        tokenStore.removeRefreshToken(refreshToken);
        return R.ok();
    }
}
