/*
Navicat MySQL Data Transfer

Source Server         : wzy_root_act_dev_192.168.0.187
Source Server Version : 50635
Source Host           : 192.168.0.187:3306
Source Database       : wztdb

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-11-28 13:51:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wzy_content_tag
-- ----------------------------
DROP TABLE IF EXISTS `wzy_content_tag`;
CREATE TABLE `wzy_content_tag` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '最后一次更新时间',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否被逻辑删除 0 -否 1-是',
  `account_id` bigint(11) DEFAULT NULL COMMENT '账户id',
  `use_times` int(10) DEFAULT NULL COMMENT '标签的使用次数',
  `tag_name` varchar(100) DEFAULT NULL COMMENT '标签名字',
  `is_system` tinyint(2) DEFAULT NULL COMMENT '是否为系统默认标签 0 -否 1-是',
  PRIMARY KEY (`id`),
  KEY `create_time_idx` (`create_time`),
  KEY `idx_account_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='素材标签';
