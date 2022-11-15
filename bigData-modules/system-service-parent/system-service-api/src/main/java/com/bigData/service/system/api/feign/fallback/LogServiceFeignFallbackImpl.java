package com.bigData.service.system.api.feign.fallback;

import com.bigData.service.system.api.dto.LogDto;
import com.bigData.service.system.api.feign.LogServiceFeign;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogServiceFeignFallbackImpl implements LogServiceFeign {

    @Setter
    private Throwable cause;

    @Override
    public void saveLog(LogDto logDto) {
        log.error("feign 调用出错", cause);
    }
}
