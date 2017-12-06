/*wzy_media_channel_order添加operation_digest字段，附加注释*/
alter TABLE wzy_media_channel_order modify digest VARCHAR(1500) COMMENT '客户备注';
alter TABLE wzy_media_channel_order add (operation_digest VARCHAR(1500) COMMENT '运营人员备注');

/*wzy_media_channel添加media_weight字段，附加注释*/
alter TABLE wzy_media_channel add (media_weight int COMMENT '权重');


/*wzy_media_apply_for添加media_weight字段，附加注释*/
alter TABLE wzy_media_apply_for add (contact_way VARCHAR(255) COMMENT '联系方式');
alter TABLE wzy_media_apply_for add (media_link VARCHAR(255) COMMENT '网站链接');

/*媒体中心运营人员表*/
DROP TABLE IF EXISTS `wzy_media_center_operator_account`;
CREATE TABLE `wzy_media_center_operator_account` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否被逻辑删除 0-否， 1-是',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `salt` varchar(40) DEFAULT NULL COMMENT '盐',
  `last_login_time` int(11) DEFAULT NULL COMMENT '最后登录的时间',
  `last_login_ip` varchar(20) DEFAULT NULL COMMENT '最后登录的ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='媒体中心运营人员表';


/*媒体中心账户流水表*/
CREATE TABLE `wzy_media_account_money_change_record` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否被逻辑删除 0-否， 1-是',
  `type` varchar(255) DEFAULT NULL COMMENT '流水类型',
  `record_id` int(11) DEFAULT NULL COMMENT '指向的流水记录id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='媒体中心账户流水表';


/*退款记录表*/
DROP TABLE IF EXISTS `wzy_media_account_refund_record`;
CREATE TABLE `wzy_media_account_refund_record` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否被逻辑删除 0-否， 1-是',
  `account_id` bigint(20) NOT NULL COMMENT 'wzt账户',
  `time` int(11) NOT NULL COMMENT '操作时间',
  `money` decimal(10,0) NOT NULL COMMENT '金额',
  `digest` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='退款记录表';


/*账户充值记录表*/
DROP TABLE IF EXISTS `wzy_media_account_charge_record`;
CREATE TABLE `wzy_media_account_charge_record` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否被逻辑删除 0-否， 1-是',
  `account_id` bigint(20) NOT NULL COMMENT 'wzt账户',
  `time` int(11) NOT NULL COMMENT '操作时间',
  `money` decimal(10,0) NOT NULL COMMENT '金额',
  `digest` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='账户充值记录表';
