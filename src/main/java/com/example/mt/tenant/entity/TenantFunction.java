package com.example.mt.tenant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.io.Serial;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 租户功能表
 * </p>
 *
 * @author hl
 * @since 2023-12-28
 */
@Getter
@Setter
@TableName("crm_tenant_function")
@ApiModel(value = "TenantFunction对象", description = "租户功能表")
public class TenantFunction implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("租户功能id")
    @TableId(value = "tenantFunctionId", type = IdType.AUTO)
    private Long tenantFunctionId;

    @ApiModelProperty("业务菜单编码（1001 准入管理，1002 档案管理）")
    private String businessCode;

    @ApiModelProperty("业务菜单描述")
    private String businessDesc;

    @ApiModelProperty("功能编码（10001 基本视图，10002 销售视图）")
    private String functionCode;

    @ApiModelProperty("功能描述")
    private String functionDesc;

    @ApiModelProperty("功能级别")
    private Integer functionLevel;

    @ApiModelProperty("父级功能编码")
    private String parentFunctionCode;

    @ApiModelProperty("是否子节点（0 否，1 是）")
    private Integer isLeaf;

    @ApiModelProperty("删除状态（0：有效，1：删除）")
    private Integer deleteFlag;

    @ApiModelProperty("创建人编号")
    private Long creatorId;

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改人编号")
    private Long editorId;

    @ApiModelProperty("修改人")
    private String editor;

    @ApiModelProperty("修改时间")
    private LocalDateTime editTime;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("租户ID")
    private String tenantId;
}
