/*
Navicat MySQL Data Transfer

Source Server         : wzy_root_act_dev_192.168.0.187
Source Server Version : 50635
Source Host           : 192.168.0.187:3306
Source Database       : wztdb

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-11-21 09:23:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wzy_monitor_gzh_group_realation
-- ----------------------------
DROP TABLE IF EXISTS `wzy_monitor_gzh_group_realation`;
CREATE TABLE `wzy_monitor_gzh_group_realation` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '最后一次更新时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否被逻辑删除 0 -否 1-是',
  `gzh_group_id` bigint(11) NOT NULL COMMENT '公众号分组id',
  `gzh_id` bigint(11) NOT NULL COMMENT '微信公众号的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wzy_monitor_gzh_group_realation
-- ----------------------------
