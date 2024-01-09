package com.example.mt.tenant.controller;

import com.example.mt.tenant.entity.TenantFunction;
import com.example.mt.tenant.service.ITenantFunctionService;

import com.example.mt.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 * 租户功能表 前端控制器
 * </p>
 *
 * @author hl
 * @since 2023-12-28
 */
@Api(tags = "租户功能表")
@RestController
@RequestMapping("/tenant/tenant-function")
public class TenantFunctionController {

    @Autowired
    private ITenantFunctionService iTenantFunctionService;

    @ApiOperation(value = "租户功能表分页列表", response = TenantFunction.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页面", dataType = "Long"),
        @ApiImplicitParam(name = "size", value = "页面数据量", dataType = "Long"),
        @ApiImplicitParam(name = "sort", value = "排序方式排序[true:正序; false:倒序]", dataType = "Boolean"),
        @ApiImplicitParam(name = "sortName", value = "排序字段,参照返回字段", dataType = "String")
    })
    @PostMapping(value = "/page")
    public Object list( @RequestBody TenantFunction param) {
        Object data = iTenantFunctionService.page(param);
        return ResponseResult.okResult(data);
    }

    @ApiOperation(value = "租户功能表详情", response = TenantFunction.class)
    @GetMapping(value = "/info/{id}")
    public Object info(@PathVariable Long id) {
        Object data = iTenantFunctionService.info(id);
        return ResponseResult.okResult(data);
    }

    @ApiOperation(value = "租户功能表新增")
    @PostMapping(value = "/add")
    public Object add( @RequestBody TenantFunction param) {
        iTenantFunctionService.add(param);
        return ResponseResult.okResult();
    }

    @ApiOperation(value = "租户功能表修改")
    @PostMapping(value = "/modify")
    public Object modify( @RequestBody TenantFunction param) {
        iTenantFunctionService.modify(param);
        return ResponseResult.okResult();
    }

    @ApiOperation(value = "租户功能表删除(单个条目)")
    @GetMapping(value = "/remove/{id}")
    public Object remove(@PathVariable Long id) {
        iTenantFunctionService.remove(id);
        return ResponseResult.okResult();
    }

    @ApiOperation(value = "租户功能表删除(多个条目)")
    @PostMapping(value = "/removes")
    public Object removes( @RequestBody List<Long> ids) {
        iTenantFunctionService.removes(ids);
        return ResponseResult.okResult();
    }

}
