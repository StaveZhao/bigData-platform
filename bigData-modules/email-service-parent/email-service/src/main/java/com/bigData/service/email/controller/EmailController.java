package com.bigData.service.email.controller;

import com.bigData.common.base.BaseController;
import com.bigData.common.core.JsonPage;
import com.bigData.common.core.R;
import com.bigData.common.validate.ValidationGroups;
import com.bigData.service.email.api.dto.EmailDto;
import com.bigData.service.email.api.entity.EmailEntity;
import com.bigData.service.email.api.query.EmailQuery;
import com.bigData.service.email.api.vo.EmailVo;
import com.bigData.service.email.mapstruct.EmailMapper;
import com.bigData.service.email.service.EmailService;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = {"邮件信息表"})
@RestController
@RequestMapping("/emails")
public class EmailController extends BaseController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailMapper emailMapper;

    /**
     * 通过ID查询信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取详细信息", notes = "根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String", paramType = "path")
    @GetMapping("/{id}")
    public R getEmailById(@PathVariable String id) {
        EmailEntity dataApiEntity = emailService.getEmailById(id);
        return R.ok().setData(emailMapper.toVO(dataApiEntity));
    }

    /**
     * 分页查询信息
     *
     * @param emailQuery
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "emailQuery", value = "查询实体emailQuery", required = true, dataTypeClass = EmailQuery.class)
    })
    @GetMapping("/page")
    public R getEmailPage(EmailQuery emailQuery) {
        QueryWrapper<EmailEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StrUtil.isNotBlank(emailQuery.getSubject()), "subject", emailQuery.getSubject());
        IPage<EmailEntity> page = emailService.page(new Page<>(emailQuery.getPageNum(), emailQuery.getPageSize()), queryWrapper);
        List<EmailVo> collect = page.getRecords().stream().map(emailMapper::toVO).collect(Collectors.toList());
        JsonPage<EmailVo> jsonPage = new JsonPage<>(page.getCurrent(), page.getSize(), page.getTotal(), collect);
        return R.ok().setData(jsonPage);
    }

    /**
     * 添加
     * @param emailDto
     * @return
     */
    @ApiOperation(value = "添加信息", notes = "根据dataApi对象添加信息")
    @ApiImplicitParam(name = "emailDto", value = "详细实体emailDto", required = true, dataType = "EmailDto")
    @PostMapping()
    public R saveEmail(@RequestBody @Validated({ValidationGroups.Insert.class}) EmailDto emailDto) {
        emailService.saveEmail(emailDto);
        return R.ok();
    }

    /**
     * 修改
     * @param emailDto
     * @return
     */
    @ApiOperation(value = "修改信息", notes = "根据url的id来指定修改对象，并根据传过来的信息来修改详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "emailDto", value = "详细实体emailDto", required = true, dataType = "EmailDto")
    })
    @PutMapping("/{id}")
    public R updateEmail(@PathVariable String id, @RequestBody @Validated({ValidationGroups.Update.class}) EmailDto emailDto) {
        emailService.updateEmail(emailDto);
        return R.ok();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ApiOperation(value = "删除", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String", paramType = "path")
    @DeleteMapping("/{id}")
    public R deleteEmailById(@PathVariable String id) {
        emailService.deleteEmailById(id);
        return R.ok();
    }

    @ApiOperation(value = "批量删除", notes = "根据url的ids来批量删除对象")
    @ApiImplicitParam(name = "ids", value = "ID集合", required = true, dataType = "List", paramType = "path")
    @DeleteMapping("/batch/{ids}")
    public R deleteEmailBatch(@PathVariable List<String> ids) {
        emailService.deleteEmailBatch(ids);
        return R.ok();
    }

    /**
     * 发送邮件
     * @param id
     * @return
     */
    @ApiOperation(value = "发送邮件", notes = "根据url的id来指定发送邮件对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String", paramType = "path")
    @PostMapping("/{id}")
    public R sendEmail(@PathVariable String id) {
        emailService.sendEmail(id);
        return R.ok();
    }
}
