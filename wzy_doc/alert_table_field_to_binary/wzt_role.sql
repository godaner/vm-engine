/*
Navicat MySQL Data Transfer

Source Server         : wzy_root_act_dev_192.168.0.187
Source Server Version : 50635
Source Host           : 192.168.0.187:3306
Source Database       : wztdb

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-11-28 13:51:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wzt_role
-- ----------------------------
DROP TABLE IF EXISTS `wzt_role`;
CREATE TABLE `wzt_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT '' COMMENT '角色的名称',
  `type` tinyint(3) NOT NULL COMMENT '角色类型, 0-系统角色， 1-区域管理员角色， 2-公众号角色 ',
  `create_uid` bigint(11) NOT NULL COMMENT '创建者uid',
  `create_user_name` varchar(50) NOT NULL COMMENT '创建者用户名',
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(2) DEFAULT NULL COMMENT '是否被删除 0-否，1-是',
  PRIMARY KEY (`id`),
  KEY `idx_type` (`type`),
  KEY `idx_c_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='微政通角色表';
