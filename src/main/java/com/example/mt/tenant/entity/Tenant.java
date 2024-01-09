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
 * 租户信息表
 * </p>
 *
 * @author hl
 * @since 2023-12-28
 */
@Getter
@Setter
@TableName("crm_tenant")
@ApiModel(value = "Tenant对象", description = "租户信息表")
public class Tenant implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("租户ID")
    @TableId(value = "tenantId", type = IdType.AUTO)
    private Long tenantId;

    @ApiModelProperty("租户编码")
    private String tenantCode;

    @ApiModelProperty("租户名称")
    private String tenantName;

    @ApiModelProperty("有效状态(0:有效，1:无效)")
    private String state;

    @ApiModelProperty("创建人ID")
    private Long creatorId;

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty("修改人ID")
    private Long editorId;

    @ApiModelProperty("修改人")
    private String editor;

    @ApiModelProperty("修改时间")
    private LocalDateTime editDate;

    @ApiModelProperty("备注")
    private String remark;
}
