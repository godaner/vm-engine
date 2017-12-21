/*
Navicat MySQL Data Transfer

Source Server         : root_120.78.191.94
Source Server Version : 50633
Source Host           : 120.78.191.94:3306
Source Database       : vm

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-12-06 16:51:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for vm_admins
-- ----------------------------
DROP TABLE IF EXISTS `vm_admins`;
CREATE TABLE `vm_admins` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '唯一用户名',
  `password` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '用户密码，md5加密',
  `status` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='后端管理员表';

-- ----------------------------
-- Table structure for vm_admins_login_logs
-- ----------------------------
DROP TABLE IF EXISTS `vm_admins_login_logs`;
CREATE TABLE `vm_admins_login_logs` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `admin_id` bigint(20) unsigned NOT NULL COMMENT '登录的管理员id',
  `login_ip` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '登录ip',
  `system` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '电脑系统',
  `dpi` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '电脑分辨率',
  `brower` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '使用的浏览器',
  `country` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '登录国家',
  `province` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '登录省份',
  `city` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '登录城市',
  `login_time` int(6) unsigned NOT NULL COMMENT '登陆时间',
  `result` smallint(5) unsigned NOT NULL COMMENT '登录结果，1位成功，2位失败',
  `status` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='后端管理员登录表';

-- ----------------------------
-- Table structure for vm_countrys
-- ----------------------------
DROP TABLE IF EXISTS `vm_countrys`;
CREATE TABLE `vm_countrys` (
  `id` smallint(3) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(16) COLLATE utf8_bin NOT NULL,
  `name_chinese` varchar(128) COLLATE utf8_bin NOT NULL,
  `name_english` varchar(128) COLLATE utf8_bin NOT NULL,
  `status` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='国家表';

-- ----------------------------
-- Table structure for vm_filmmakers
-- ----------------------------
DROP TABLE IF EXISTS `vm_filmmakers`;
CREATE TABLE `vm_filmmakers` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '演员名',
  `alias` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '别名',
  `profession` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '职业',
  `blood_type` smallint(5) unsigned NOT NULL COMMENT '血型，1，为未知',
  `constellation` smallint(5) unsigned NOT NULL COMMENT '星座，1，为未知',
  `sex` smallint(6) unsigned NOT NULL DEFAULT '3' COMMENT '性别，1为男，1为女，3未设置',
  `birthday` int(10) unsigned NOT NULL COMMENT '演员生日',
  `country` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '演员国家',
  `description` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '演员描述',
  `img_url` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '图片地址',
  `status` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='电影人基本信息表(包括演员，导演等)';

-- ----------------------------
-- Table structure for vm_movies
-- ----------------------------
DROP TABLE IF EXISTS `vm_movies`;
CREATE TABLE `vm_movies` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `alias` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '别名',
  `description` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '描述',
  `director_id` bigint(20) unsigned NOT NULL COMMENT '导演id（指向电影人表：vm_filmmakers）',
  `release_time` int(10) unsigned NOT NULL COMMENT '上映时间',
  `score` float unsigned NOT NULL COMMENT '评分',
  `watch_num` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '观看数量',
  `movie_time` int(10) unsigned NOT NULL COMMENT '电影时长',
  `src_url` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '资源url',
  `img_url` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '图片url',
  `status` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='电影表';

-- ----------------------------
-- Table structure for vm_movies_filmmakers_realation
-- ----------------------------
DROP TABLE IF EXISTS `vm_movies_filmmakers_realation`;
CREATE TABLE `vm_movies_filmmakers_realation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `movie_id` bigint(20) unsigned NOT NULL COMMENT '电影id',
  `filmmaker_id` bigint(20) unsigned NOT NULL COMMENT '电影人id',
  `status` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='关系表-电影及其电影人表';

-- ----------------------------
-- Table structure for vm_movies_tags_realation
-- ----------------------------
DROP TABLE IF EXISTS `vm_movies_tags_realation`;
CREATE TABLE `vm_movies_tags_realation` (
  `id` bigint(20) unsigned NOT NULL COMMENT '自增主键',
  `movie_id` bigint(20) unsigned NOT NULL COMMENT '电影id',
  `tag_id` bigint(20) unsigned NOT NULL COMMENT '类型id',
  `status` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='关系表-电影标签表';

-- ----------------------------
-- Table structure for vm_tags
-- ----------------------------
DROP TABLE IF EXISTS `vm_tags`;
CREATE TABLE `vm_tags` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '类型名',
  `tag_group_id` bigint(20) unsigned NOT NULL COMMENT '所属标签组',
  `status` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='电影标签';

-- ----------------------------
-- Table structure for vm_tags_groups
-- ----------------------------
DROP TABLE IF EXISTS `vm_tags_groups`;
CREATE TABLE `vm_tags_groups` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '标签组名',
  `status` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='标签组';

-- ----------------------------
-- Table structure for vm_users
-- ----------------------------
DROP TABLE IF EXISTS `vm_users`;
CREATE TABLE `vm_users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '唯一用户名',
  `password` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '用户密码，md5加密',
  `sex` smallint(1) unsigned NOT NULL DEFAULT '3' COMMENT '性别，1为男，1为女，3未设置',
  `birthday` int(10) unsigned NOT NULL COMMENT '用户生日',
  `description` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '用户描述',
  `status` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='前端用户表';

-- ----------------------------
-- Table structure for vm_users_login_logs
-- ----------------------------
DROP TABLE IF EXISTS `vm_users_login_logs`;
CREATE TABLE `vm_users_login_logs` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `login_ip` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '登录ip',
  `system` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '系统',
  `dpi` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '分辨率',
  `brower` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '浏览器',
  `country` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '登录国家',
  `province` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '登录省份',
  `city` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '登陆城市',
  `login_time` int(10) unsigned NOT NULL COMMENT '登录时间',
  `result` smallint(5) unsigned NOT NULL COMMENT '登录结果，1位成功，2位失败',
  `status` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='前端用户登录记录';
