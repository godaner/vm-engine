/*
Navicat MySQL Data Transfer

Source Server         : wzy_root_act_dev_192.168.0.187
Source Server Version : 50635
Source Host           : 192.168.0.187:3306
Source Database       : wztdb

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-12-06 16:37:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wzy_media_center_operator_account
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='媒体中心运营人员表';
