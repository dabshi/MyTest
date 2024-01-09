package com.example.mt.tenant.service.impl;

import com.example.mt.tenant.entity.TenantFunction;
import com.example.mt.tenant.mapper.TenantFunctionMapper;
import com.example.mt.tenant.service.ITenantFunctionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.example.mt.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
* <p>
* 租户功能表 服务实现类
* </p>
*
* @author hl
* @since 2023-12-28
*/
@Service
public class TenantFunctionServiceImpl extends ServiceImpl<TenantFunctionMapper, TenantFunction>
    implements ITenantFunctionService {

    @Autowired
    private PageUtils pageUtils;

    /**
    * 租户功能表分页列表
    * @param param 根据需要进行传值
    * @return
    */
    @Override
    public IPage<TenantFunction> page(TenantFunction param) {

        QueryWrapper<TenantFunction> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
            // 租户功能id
                    .eq(param.getTenantFunctionId() != null, TenantFunction::getTenantFunctionId, param.getTenantFunctionId())
                    // 业务菜单编码（1001 准入管理，1002 档案管理）
                    .eq(StringUtils.hasText(param.getBusinessCode()), TenantFunction::getBusinessCode, param.getBusinessCode())
                    // 业务菜单描述
                    .eq(StringUtils.hasText(param.getBusinessDesc()), TenantFunction::getBusinessDesc, param.getBusinessDesc())
                    // 功能编码（10001 基本视图，10002 销售视图）
                    .eq(StringUtils.hasText(param.getFunctionCode()), TenantFunction::getFunctionCode, param.getFunctionCode())
                    // 功能描述
                    .eq(StringUtils.hasText(param.getFunctionDesc()), TenantFunction::getFunctionDesc, param.getFunctionDesc())
                    // 功能级别
                    .eq(param.getFunctionLevel() != null, TenantFunction::getFunctionLevel, param.getFunctionLevel())
                    // 父级功能编码
                    .eq(StringUtils.hasText(param.getParentFunctionCode()), TenantFunction::getParentFunctionCode, param.getParentFunctionCode())
                    // 是否子节点（0 否，1 是）
                    .eq(param.getIsLeaf() != null, TenantFunction::getIsLeaf, param.getIsLeaf())
                    // 删除状态（0：有效，1：删除）
                    .eq(param.getDeleteFlag() != null, TenantFunction::getDeleteFlag, param.getDeleteFlag())
                    // 创建人编号
                    .eq(param.getCreatorId() != null, TenantFunction::getCreatorId, param.getCreatorId())
                    // 创建人
                    .eq(StringUtils.hasText(param.getCreator()), TenantFunction::getCreator, param.getCreator())
                    // 创建时间
                    .eq(param.getCreateTime() != null, TenantFunction::getCreateTime, param.getCreateTime())
                    // 修改人编号
                    .eq(param.getEditorId() != null, TenantFunction::getEditorId, param.getEditorId())
                    // 修改人
                    .eq(StringUtils.hasText(param.getEditor()), TenantFunction::getEditor, param.getEditor())
                    // 修改时间
                    .eq(param.getEditTime() != null, TenantFunction::getEditTime, param.getEditTime())
                    // 备注
                    .eq(StringUtils.hasText(param.getRemark()), TenantFunction::getRemark, param.getRemark())
                    // 租户ID
                    .eq(StringUtils.hasText(param.getTenantId()), TenantFunction::getTenantId, param.getTenantId())
        ;

        IPage<TenantFunction> page = page(pageUtils.page(), queryWrapper);

        return page;
    }

    /**
    * 租户功能表详情
    * @param id
    * @return
    */
    @Override
    public TenantFunction info(Long id) {
        return getById(id);
    }

    /**
    * 租户功能表新增
    * @param param 根据需要进行传值
    * @return
    */
    @Override
    public void add(TenantFunction param) {
        save(param);
    }

    /**
    * 租户功能表修改
    * @param param 根据需要进行传值
    * @return
    */
    @Override
    public void modify(TenantFunction param) {
        updateById(param);
    }

    /**
    * 租户功能表删除(单个条目)
    * @param id
    * @return
    */
    @Override
    public void remove(Long id) {
        removeById(id);
    }

    /**
    * 租户功能表删除(多个条目)
    * @param ids
    * @return
    */
    @Override
    public void removes(List<Long> ids) {
        removeByIds(ids);
    }
}
