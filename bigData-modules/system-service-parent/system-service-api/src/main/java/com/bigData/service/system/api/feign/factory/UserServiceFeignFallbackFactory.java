package com.bigData.service.system.api.feign.factory;

import com.bigData.service.system.api.feign.UserServiceFeign;
import com.bigData.service.system.api.feign.fallback.UserServiceFeignFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFeignFallbackFactory implements FallbackFactory<UserServiceFeign> {

    @Override
    public UserServiceFeign create(Throwable throwable) {
        UserServiceFeignFallbackImpl userServiceFeignFallback = new UserServiceFeignFallbackImpl();
        userServiceFeignFallback.setCause(throwable);
        return userServiceFeignFallback;
    }
}
