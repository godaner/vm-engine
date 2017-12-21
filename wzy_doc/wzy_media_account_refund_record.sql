/*
Navicat MySQL Data Transfer

Source Server         : wzy_root_act_dev_192.168.0.187
Source Server Version : 50635
Source Host           : 192.168.0.187:3306
Source Database       : wztdb

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-12-06 16:45:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wzy_media_account_refund_record
-- ----------------------------
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
