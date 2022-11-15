package com.bigData.service.system.api.feign;

import com.bigData.service.system.api.feign.factory.UserServiceFeignFallbackFactory;
import com.bigData.service.system.api.vo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "userServiceFeign", value = "bigData-service-system", fallbackFactory = UserServiceFeignFallbackFactory.class)
public interface UserServiceFeign {

    @GetMapping("/login/username/{username}")
    UserInfo loginByUsername(@PathVariable("username") String username);
}
