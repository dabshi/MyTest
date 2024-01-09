package com.example.mt.tenant.controller;

import com.example.mt.tenant.entity.Tenant;
import com.example.mt.tenant.service.ITenantService;

import com.example.mt.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 * 租户信息表 前端控制器
 * </p>
 *
 * @author hl
 * @since 2023-12-28
 */
@Api(tags = "租户信息表")
@RestController
@RequestMapping("/tenant/tenant")
public class TenantController {

    @Autowired
    private ITenantService iTenantService;

    @ApiOperation(value = "租户信息表分页列表", response = Tenant.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页面", dataType = "Long"),
        @ApiImplicitParam(name = "size", value = "页面数据量", dataType = "Long"),
        @ApiImplicitParam(name = "sort", value = "排序方式排序[true:正序; false:倒序]", dataType = "Boolean"),
        @ApiImplicitParam(name = "sortName", value = "排序字段,参照返回字段", dataType = "String")
    })
    @PostMapping(value = "/page")
    public Object list( @RequestBody Tenant param) {
        Object data = iTenantService.page(param);
        return ResponseResult.okResult(data);
    }

    @ApiOperation(value = "租户信息表详情", response = Tenant.class)
    @GetMapping(value = "/info/{id}")
    public Object info(@PathVariable Long id) {
        Object data = iTenantService.info(id);
        return ResponseResult.okResult(data);
    }

    @ApiOperation(value = "租户信息表新增")
    @PostMapping(value = "/add")
    public Object add( @RequestBody Tenant param) {
        iTenantService.add(param);
        return ResponseResult.okResult();
    }

    @ApiOperation(value = "租户信息表修改")
    @PostMapping(value = "/modify")
    public Object modify( @RequestBody Tenant param) {
        iTenantService.modify(param);
        return ResponseResult.okResult();
    }

    @ApiOperation(value = "租户信息表删除(单个条目)")
    @GetMapping(value = "/remove/{id}")
    public Object remove(@PathVariable Long id) {
        iTenantService.remove(id);
        return ResponseResult.okResult();
    }

    @ApiOperation(value = "租户信息表删除(多个条目)")
    @PostMapping(value = "/removes")
    public Object removes( @RequestBody List<Long> ids) {
        iTenantService.removes(ids);
        return ResponseResult.okResult();
    }


    @PostMapping("transactionalTest")
    public Object transactionalTest(){
        iTenantService.transactionalTest();
        return ResponseResult.okResult();
    }

}
