package com.bigData.service.system.async;

import com.bigData.service.system.api.dto.LogDto;
import com.bigData.service.system.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步处理 分布式获取请求头有问题
 */
@Slf4j
@Component
public class AsyncTask {

    @Autowired
    private LogService logService;

    @Async("taskExecutor")
    public void doTask(LogDto logDto) {
        logService.saveLog(logDto);
    }
}
