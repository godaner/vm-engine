/*
Navicat MySQL Data Transfer

Source Server         : wzy_root_act_dev_192.168.0.187
Source Server Version : 50635
Source Host           : 192.168.0.187:3306
Source Database       : wztdb

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-11-28 13:52:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wzy_account_audit
-- ----------------------------
DROP TABLE IF EXISTS `wzy_account_audit`;
CREATE TABLE `wzy_account_audit` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `manager_account_id` bigint(11) NOT NULL COMMENT '公众号管理员ID',
  `manager_account_name` varchar(40) NOT NULL COMMENT '公众号管理员账户名',
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(2) NOT NULL COMMENT '是否被删除 0-否，1-是',
  `auditor_account_id` bigint(11) NOT NULL COMMENT '审核人ID',
  `auditor_account_name` varchar(40) NOT NULL COMMENT '审核人名字',
  `role_id` bigint(11) NOT NULL COMMENT '角色ID',
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `status` tinyint(2) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `idx_c_time` (`create_time`),
  KEY `idx_audit_act_id` (`auditor_account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='微政云审核人员账户表';
