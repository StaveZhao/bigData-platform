package com.bigData.common.security.config;


import com.bigData.common.security.annotation.DataInner;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 服务间接口不鉴权处理逻辑
 *
 */
@Slf4j
@Aspect
public class DataSecurityInnerAspect {

    @SneakyThrows
    @Around("@annotation(dataInner)")
    public Object around(ProceedingJoinPoint point, DataInner dataInner) {
        log.info("feign内部接口访问 {} 不鉴权处理", point.getSignature().getName());
        return point.proceed();
    }
}
