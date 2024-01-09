package com.example.mt.tenant.service.impl;

import com.example.mt.tenant.entity.Tenant;
import com.example.mt.tenant.entity.TenantFunction;
import com.example.mt.tenant.mapper.TenantMapper;
import com.example.mt.tenant.service.ITenantFunctionService;
import com.example.mt.tenant.service.ITenantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.example.mt.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
* <p>
* 租户信息表 服务实现类
* </p>
*
* @author hl
* @since 2023-12-28
*/
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant>
    implements ITenantService {

    @Autowired
    private PageUtils pageUtils;

    @Autowired
    private ITenantFunctionService tenantFunctionService;

    /**
    * 租户信息表分页列表
    * @param param 根据需要进行传值
    * @return
    */
    @Override
    public IPage<Tenant> page(Tenant param) {

        QueryWrapper<Tenant> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
            // 租户ID
                    .eq(param.getTenantId() != null, Tenant::getTenantId, param.getTenantId())
                    // 租户编码
                    .eq(StringUtils.hasText(param.getTenantCode()), Tenant::getTenantCode, param.getTenantCode())
                    // 租户名称
                    .eq(StringUtils.hasText(param.getTenantName()), Tenant::getTenantName, param.getTenantName())
                    // 有效状态(0:有效，1:无效)
                    .eq(StringUtils.hasText(param.getState()), Tenant::getState, param.getState())
                    // 创建人ID
                    .eq(param.getCreatorId() != null, Tenant::getCreatorId, param.getCreatorId())
                    // 创建人
                    .eq(StringUtils.hasText(param.getCreator()), Tenant::getCreator, param.getCreator())
                    // 创建时间
                    .eq(param.getCreateDate() != null, Tenant::getCreateDate, param.getCreateDate())
                    // 修改人ID
                    .eq(param.getEditorId() != null, Tenant::getEditorId, param.getEditorId())
                    // 修改人
                    .eq(StringUtils.hasText(param.getEditor()), Tenant::getEditor, param.getEditor())
                    // 修改时间
                    .eq(param.getEditDate() != null, Tenant::getEditDate, param.getEditDate())
                    // 备注
                    .eq(StringUtils.hasText(param.getRemark()), Tenant::getRemark, param.getRemark())
        ;

        IPage<Tenant> page = page(pageUtils.page(), queryWrapper);

        return page;
    }

    /**
    * 租户信息表详情
    * @param id
    * @return
    */
    @Override
    public Tenant info(Long id) {
        return getById(id);
    }

    /**
    * 租户信息表新增
    * @param param 根据需要进行传值
    * @return
    */
    @Override
    public void add(Tenant param) {
        save(param);
    }

    /**
    * 租户信息表修改
    * @param param 根据需要进行传值
    * @return
    */
    @Override
    public void modify(Tenant param) {
        updateById(param);
    }

    /**
    * 租户信息表删除(单个条目)
    * @param id
    * @return
    */
    @Override
    public void remove(Long id) {
        removeById(id);
    }

    /**
    * 租户信息表删除(多个条目)
    * @param ids
    * @return
    */
    @Override
    public void removes(List<Long> ids) {
        removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer transactionalTest() {
        this.lambdaUpdate()
                .set(Tenant::getEditDate, LocalDateTime.now())
                .update();

        this.updateTenantFunction();
        return 1;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void updateTenantFunction(){
        tenantFunctionService.lambdaUpdate()
                .set(TenantFunction::getEditTime, LocalDateTime.now())
                .update();
        int a = 1/0;
    }
}
