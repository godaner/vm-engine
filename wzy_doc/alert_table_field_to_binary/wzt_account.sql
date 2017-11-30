/*
Navicat MySQL Data Transfer

Source Server         : wzy_root_act_dev_192.168.0.187
Source Server Version : 50635
Source Host           : 192.168.0.187:3306
Source Database       : wztdb

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-11-28 13:50:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wzt_account
-- ----------------------------
DROP TABLE IF EXISTS `wzt_account`;
CREATE TABLE `wzt_account` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `nickname` varchar(255) DEFAULT '' COMMENT '昵称',
  `role_id` bigint(11) unsigned NOT NULL COMMENT '角色代码',
  `username` varchar(40) NOT NULL COMMENT '用户名',
  `passwd` varchar(45) NOT NULL COMMENT '密码',
  `salt` varchar(20) NOT NULL,
  `phone_number` varchar(100) DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  `joinip` varchar(30) DEFAULT NULL COMMENT '注册ip',
  `lastip` varchar(30) DEFAULT NULL COMMENT '最后一次登录ip',
  `last_visit_time` int(10) DEFAULT NULL COMMENT '最后一次访问时间',
  `sex` tinyint(2) DEFAULT NULL COMMENT '性别， 0-未知， 1-男 , 2-女',
  `status` tinyint(4) NOT NULL COMMENT '账户状态， 0-正常， 1-冻结 ',
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '最后一次更新时间',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否被逻辑删除 0 -否 1-是',
  PRIMARY KEY (`id`),
  KEY `role_idx` (`role_id`),
  KEY `create_time_idx` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1352 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='微政通账户表';
