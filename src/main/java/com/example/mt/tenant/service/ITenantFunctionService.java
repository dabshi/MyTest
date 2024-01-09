package com.example.mt.tenant.service;

import com.example.mt.tenant.entity.TenantFunction;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
* <p>
* 租户功能表 服务类
* </p>
*
* @author hl
* @since 2023-12-28
*/
public interface ITenantFunctionService extends IService<TenantFunction> {

       /**
       * 租户功能表分页列表
       * @param param 根据需要进行传值
       * @return
       */
       IPage<TenantFunction> page(TenantFunction param);

       /**
       * 租户功能表详情
       * @param id
       * @return
       */
       TenantFunction info(Long id);

       /**
       * 租户功能表新增
       * @param param 根据需要进行传值
       * @return
       */
       void add(TenantFunction param);

       /**
       * 租户功能表修改
       * @param param 根据需要进行传值
       * @return
       */
       void modify(TenantFunction param);

       /**
       * 租户功能表删除(单个条目)
       * @param id
       * @return
       */
       void remove(Long id);

       /**
       * 删除(多个条目)
       * @param ids
       * @return
       */
       void removes(List<Long> ids);
}
