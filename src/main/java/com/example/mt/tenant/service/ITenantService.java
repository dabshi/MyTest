package com.example.mt.tenant.service;

import com.example.mt.tenant.entity.Tenant;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
* <p>
* 租户信息表 服务类
* </p>
*
* @author hl
* @since 2023-12-28
*/
public interface ITenantService extends IService<Tenant> {

       /**
       * 租户信息表分页列表
       * @param param 根据需要进行传值
       * @return
       */
       IPage<Tenant> page(Tenant param);

       /**
       * 租户信息表详情
       * @param id
       * @return
       */
       Tenant info(Long id);

       /**
       * 租户信息表新增
       * @param param 根据需要进行传值
       * @return
       */
       void add(Tenant param);

       /**
       * 租户信息表修改
       * @param param 根据需要进行传值
       * @return
       */
       void modify(Tenant param);

       /**
       * 租户信息表删除(单个条目)
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

    Integer transactionalTest();
}
