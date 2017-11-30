/*
Navicat MySQL Data Transfer

Source Server         : wzy_root_act_dev_192.168.0.187
Source Server Version : 50635
Source Host           : 192.168.0.187:3306
Source Database       : wztdb

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-11-28 13:51:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wzy_account_gj
-- ----------------------------
DROP TABLE IF EXISTS `wzy_account_gj`;
CREATE TABLE `wzy_account_gj` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(2) NOT NULL COMMENT '是否被删除 0-否，1-是',
  `manager_account_id` bigint(11) NOT NULL COMMENT '管家管理员ID',
  `manager_account_name` varchar(40) NOT NULL COMMENT '管家管理员账户名',
  `account_id` bigint(11) NOT NULL COMMENT 'accountID',
  `account_name` varchar(40) NOT NULL COMMENT 'account名字',
  `role_id` bigint(11) NOT NULL COMMENT '角色ID',
  `status` tinyint(2) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `idx_c_time` (`create_time`),
  KEY `idx_act_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='管家普通账户表';
