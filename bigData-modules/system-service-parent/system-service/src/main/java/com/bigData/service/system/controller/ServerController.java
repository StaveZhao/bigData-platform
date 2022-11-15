package com.bigData.service.system.controller;

import com.bigData.common.core.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stave_zhao
 * @title: ServerController
 * @projectName bigData-platform
 * @description: 服务监控
 * @date 2022/11/1514:41
 */
@Api(tags = {"服务监控"})
@RestController
@RequestMapping("/server")
public class ServerController {

    @ApiOperation(value = "获取服务监控", notes = "获取服务监控的详细信息")
    @GetMapping()
    public R getInfo(){
//        Server server = new Server();
//        server.copyTo();
        return R.ok().setData(null);
    }

}
