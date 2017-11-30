/*
Navicat MySQL Data Transfer

Source Server         : wzy_root_act_dev_192.168.0.187
Source Server Version : 50635
Source Host           : 192.168.0.187:3306
Source Database       : wztdb

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-11-28 13:51:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wzy_monitor_gzh_group
-- ----------------------------
DROP TABLE IF EXISTS `wzy_monitor_gzh_group`;
CREATE TABLE `wzy_monitor_gzh_group` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '最后一次更新时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否被逻辑删除 0 -否 1-是',
  `name` varchar(100) NOT NULL COMMENT '监测分组的名称',
  `manager_id` bigint(11) NOT NULL COMMENT '微政云管家账户id(当前分组所属的管家账户)',
  `platform` int(10) NOT NULL COMMENT '来源平台',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=243 DEFAULT CHARSET=utf8 COMMENT='监测分组';
