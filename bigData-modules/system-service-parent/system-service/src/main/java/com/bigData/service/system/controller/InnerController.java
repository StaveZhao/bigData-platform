package com.bigData.service.system.controller;

import com.bigData.common.base.BaseController;
import com.bigData.common.security.annotation.DataInner;
import com.bigData.service.system.api.dto.LogDto;
import com.bigData.service.system.async.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inner")
public class InnerController extends BaseController {

    @Autowired
    private AsyncTask asyncTask;

    @DataInner
    @PostMapping("/logs")
    public void saveLog(@RequestBody LogDto log) {
        asyncTask.doTask(log);
    }
}
