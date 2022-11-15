package com.bigData.service.system.api.feign;

import com.bigData.service.system.api.dto.LogDto;
import com.bigData.service.system.api.feign.factory.LogServiceFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "logServiceFeign", value = "bigData-service-system", fallbackFactory = LogServiceFeignFallbackFactory.class)
public interface LogServiceFeign {

    @PostMapping("/inner/logs")
    void saveLog(@RequestBody LogDto logDto);
}
