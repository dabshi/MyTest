create table tycrm_uat.crm_tenant
(
    tenantId   bigint auto_increment comment '租户ID'
        primary key,
    tenantCode varchar(50)      not null comment '租户编码',
    tenantName varchar(100)     not null comment '租户名称',
    state      char default '0' not null comment '有效状态(0:有效，1:无效)',
    creatorId  bigint           not null comment '创建人ID',
    creator    varchar(20)      not null comment '创建人',
    createDate datetime         not null comment '创建时间',
    editorId   bigint           null comment '修改人ID',
    editor     varchar(20)      null comment '修改人',
    editDate   datetime         null comment '修改时间',
    remark     varchar(50)      null comment '备注'
)
    comment '租户信息表';

create table tycrm_uat.crm_tenant_function
(
    tenantFunctionId   bigint auto_increment comment '租户功能id'
        primary key,
    businessCode       varchar(20)           not null comment '业务菜单编码（1001 准入管理，1002 档案管理）',
    businessDesc       varchar(50)           not null comment '业务菜单描述',
    functionCode       varchar(30)           not null comment '功能编码（10001 基本视图，10002 销售视图）',
    functionDesc       varchar(50)           not null comment '功能描述',
    functionLevel      smallint(1)           not null comment '功能级别',
    parentFunctionCode varchar(20)           not null comment '父级功能编码',
    isLeaf             smallint(1)           not null comment '是否子节点（0 否，1 是）',
    deleteFlag         smallint(1) default 0 not null comment '删除状态（0：有效，1：删除）',
    creatorId          bigint                not null comment '创建人编号',
    creator            varchar(40)           not null comment '创建人',
    createTime         datetime              not null comment '创建时间',
    editorId           bigint                null comment '修改人编号',
    editor             varchar(20)           null comment '修改人',
    editTime           datetime              null comment '修改时间',
    remark             varchar(255)          null comment '备注',
    tenantId           varchar(50)           not null comment '租户ID'
)
    comment '租户功能表' charset = utf8mb4;

create table tycrm_uat.flow_approve_info
(
    processId       bigint auto_increment comment '主键id'
        primary key,
    processCode     varchar(50)              not null comment '流程编码',
    processName     varchar(100)             not null comment '流程名称',
    formCode        varchar(40)              not null comment '表单编码',
    approveJson     longtext                 null comment '储存前端传的流程json数据，用于回显',
    sendMessageFlag smallint(1) default 0    null comment '是否发消息(0 不发，1 发)',
    sendMessageType varchar(10)              null comment '消息类型(0短信 1邮件 2系统消息  可以多选中间英文逗号连接)',
    retractable     smallint(1) default 0    not null comment '是否可撤回(0 不可撤回，1 可撤回)',
    status          smallint(1)              not null comment '状态（0 启用，1 不启用，2 暂存）',
    remark          varchar(200)             null comment '备注',
    tenantId        varchar(32)              not null comment '租户id',
    tenantName      varchar(100)             not null comment '租户名称',
    appId           varchar(10)              not null comment '应用程序id',
    deleteFlag      smallint(1) default 0    not null comment '删除标识（0:有效,1:删除）',
    creatorId       bigint                   not null comment '创建人id',
    creator         varchar(30) charset utf8 not null comment '创建人',
    createTime      datetime                 not null comment '创建时间',
    editorId        bigint                   not null comment '修改人id',
    editor          varchar(30) charset utf8 not null comment '修改人',
    editTime        datetime                 not null comment '修改时间'
)
    comment '审批流程' charset = utf8mb4;

create index auto_shard_key_tenantid
    on tycrm_uat.flow_approve_info (tenantId);


git remote set-url origin https://dabsh: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@github.com/dabshi/MyTest.git
