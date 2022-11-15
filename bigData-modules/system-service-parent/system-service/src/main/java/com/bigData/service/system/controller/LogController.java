package com.bigData.service.system.controller;

import com.bigData.common.base.BaseController;
import com.bigData.common.core.JsonPage;
import com.bigData.common.core.R;
import com.bigData.service.system.api.entity.LogEntity;
import com.bigData.service.system.api.query.LogQuery;
import com.bigData.service.system.api.vo.LogVo;
import com.bigData.service.system.mapstruct.LogMapper;
import com.bigData.service.system.service.LogService;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 */
@Api(value="系统管理接口", tags = {"系统管理"})
@RestController
@RequestMapping("/logs")
public class LogController extends BaseController {

    @Autowired
    private LogService logService;

    @Autowired
    private LogMapper logMapper;

    /**
     * 通过ID查询信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取详细信息", notes = "根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String", paramType = "path")
    @GetMapping("/{id}")
    public R getLogById(@PathVariable String id) {
        LogEntity logEntity = logService.getLogById(id);
        return R.ok().setData(logMapper.toVO(logEntity));
    }

    @ApiOperation(value = "日志分页查询", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "logQuery", value = "查询实体logQuery", required = true, dataTypeClass = LogQuery.class)
    })
    @GetMapping("/page")
    public R getLogPage(LogQuery logQuery) {
        QueryWrapper<LogEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StrUtil.isNotBlank(logQuery.getTitle()), "title", logQuery.getTitle());
        queryWrapper.like(StrUtil.isNotBlank(logQuery.getModule()), "module", logQuery.getModule());
        queryWrapper.like(StrUtil.isNotBlank(logQuery.getUserName()), "user_name", logQuery.getUserName());
        IPage<LogEntity> page = logService.page(new Page<>(logQuery.getPageNum(), logQuery.getPageSize()), queryWrapper.orderByDesc("id"));
        List<LogVo> collect = page.getRecords().stream().map(logMapper::toVO).collect(Collectors.toList());
        JsonPage<LogVo> jsonPage = new JsonPage<>(page.getCurrent(), page.getSize(), page.getTotal(), collect);
        return R.ok().setData(jsonPage);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ApiOperation(value = "删除", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String", paramType = "path")
    @DeleteMapping("/{id}")
    public R deleteLogById(@PathVariable String id) {
        logService.deleteLogById(id);
        return R.ok();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除角色", notes = "根据url的ids来批量删除对象")
    @ApiImplicitParam(name = "ids", value = "ID集合", required = true, dataType = "List", paramType = "path")
    @DeleteMapping("/batch/{ids}")
    public R deleteLogBatch(@PathVariable List<String> ids) {
        logService.deleteLogBatch(ids);
        return R.ok();
    }
}
