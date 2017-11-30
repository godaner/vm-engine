/*
Navicat MySQL Data Transfer

Source Server         : wzy_root_act_dev_192.168.0.187
Source Server Version : 50635
Source Host           : 192.168.0.187:3306
Source Database       : wztdb

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-11-28 13:49:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wzt_customized_group
-- ----------------------------
DROP TABLE IF EXISTS `wzt_customized_group`;
CREATE TABLE `wzt_customized_group` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否被逻辑删除 0-否， 1-是',
  `account_id` bigint(11) NOT NULL COMMENT '微政云管理账户ID',
  `type` tinyint(2) NOT NULL COMMENT '分组类型',
  `group_name` varchar(45) NOT NULL COMMENT '分组名',
  `gzh_total_cnt` int(5) NOT NULL COMMENT '公众号计数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `act_type_grp_unique` (`account_id`,`type`,`group_name`),
  KEY `c_time_idx` (`create_time`),
  KEY `account_idx` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=385 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='微政云自定义分组表';
