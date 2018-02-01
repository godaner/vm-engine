/*
Navicat MySQL Data Transfer

Source Server         : 120.78.191.94_root
Source Server Version : 50633
Source Host           : 120.78.191.94:3306
Source Database       : course

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2018-01-31 17:37:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '唯一用户名',
  `password` varchar(40) COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码，md5加密',
  `sex` tinyint(2) unsigned NOT NULL DEFAULT '3' COMMENT '性别，1为男，2为女，3未设置',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of admins
-- ----------------------------

-- ----------------------------
-- Table structure for course_sources
-- ----------------------------
DROP TABLE IF EXISTS `course_sources`;
CREATE TABLE `course_sources` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  `course_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of course_sources
-- ----------------------------
INSERT INTO `course_sources` VALUES ('1', '1', '1', '1', '1', '第一节', '/courses/src/1', '1', '这是第一节');
INSERT INTO `course_sources` VALUES ('2', '1', '1', '1', '1', '第二节', '/courses/src/1', '1', '这是第二节');

-- ----------------------------
-- Table structure for course_tag_realations
-- ----------------------------
DROP TABLE IF EXISTS `course_tag_realations`;
CREATE TABLE `course_tag_realations` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  `tag_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of course_tag_realations
-- ----------------------------
INSERT INTO `course_tag_realations` VALUES ('1', '1', '1', '1', '1', '1');
INSERT INTO `course_tag_realations` VALUES ('2', '1', '1', '1', '2', '1');
INSERT INTO `course_tag_realations` VALUES ('3', '1', '1', '1', '3', '1');
INSERT INTO `course_tag_realations` VALUES ('4', '1', '1', '1', '1', '2');
INSERT INTO `course_tag_realations` VALUES ('5', '1', '1', '1', '2', '2');
INSERT INTO `course_tag_realations` VALUES ('6', '1', '1', '1', '3', '2');
INSERT INTO `course_tag_realations` VALUES ('7', '1', '1', '1', '4', '2');

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  `img_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户头像url',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `download_number` int(11) DEFAULT NULL,
  `learn_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11250 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES ('1', '1', '1', '1', '/courses/img/1', 'java学习', 'java学习java学习ja真的学习', '0', '1');
INSERT INTO `courses` VALUES ('2', '1', '1', '1', '/courses/img/1471513730333', 'cc学习', '学习不好', '1', '888');
INSERT INTO `courses` VALUES ('3', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('4', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('11', '1', '1', '1', '/courses/img/1', 'java学习', 'java学习java学习ja真的学习', '4564', '1');
INSERT INTO `courses` VALUES ('12', '1', '1', '1', '/courses/img/1471513730333', 'cc学习', '学习不好', '1', '888');
INSERT INTO `courses` VALUES ('13', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('14', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('15', '1', '1', '1', '/courses/img/1471513730333', 'cc学习', '学习不好', '1', '888');
INSERT INTO `courses` VALUES ('16', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('17', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('18', '1', '1', '1', '/courses/img/1471513730333', 'cc学习', '学习不好', '1', '888');
INSERT INTO `courses` VALUES ('121', '1', '1', '1', '/courses/img/1', 'java学习', 'java学习java学习ja真的学习', '4564', '1');
INSERT INTO `courses` VALUES ('122', '1', '1', '1', '/courses/img/1471513730333', 'cc学习', '学习不好', '1', '888');
INSERT INTO `courses` VALUES ('123', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('124', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('125', '1', '1', '1', '/courses/img/1471513730333', 'cc学习', '学习不好', '1', '888');
INSERT INTO `courses` VALUES ('126', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('128', '1', '1', '1', '/courses/img/1471513730333', 'cc学习', '学习不好', '1', '888');
INSERT INTO `courses` VALUES ('139', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('149', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('217', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('1123', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('1124', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('1126', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('1217', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('1239', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('1249', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('11239', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');
INSERT INTO `courses` VALUES ('11249', '1', '1', '1', '/courses/img/1471513730333', 'unity3d入门到放弃', '学习不好', '888', '222');

-- ----------------------------
-- Table structure for tag_group_realations
-- ----------------------------
DROP TABLE IF EXISTS `tag_group_realations`;
CREATE TABLE `tag_group_realations` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  `tag_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tag_group_realations
-- ----------------------------
INSERT INTO `tag_group_realations` VALUES ('1', '1', '1', '1', '1', '1');
INSERT INTO `tag_group_realations` VALUES ('2', '1', '2', '2', '2', '1');
INSERT INTO `tag_group_realations` VALUES ('3', '1', '1', '1', '3', '2');
INSERT INTO `tag_group_realations` VALUES ('4', '1', '1', '1', '4', '2');

-- ----------------------------
-- Table structure for tag_groups
-- ----------------------------
DROP TABLE IF EXISTS `tag_groups`;
CREATE TABLE `tag_groups` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tag_groups
-- ----------------------------
INSERT INTO `tag_groups` VALUES ('1', '1', '1', '1', '类型');
INSERT INTO `tag_groups` VALUES ('2', '1', '1', '1', '难度');

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tags
-- ----------------------------
INSERT INTO `tags` VALUES ('1', '1', '1', '1', 'java');
INSERT INTO `tags` VALUES ('2', '1', '1', '1', 'c');
INSERT INTO `tags` VALUES ('3', '1', '1', '1', '初级');
INSERT INTO `tags` VALUES ('4', '1', '1', '1', '中级');

-- ----------------------------
-- Table structure for user_collect_course
-- ----------------------------
DROP TABLE IF EXISTS `user_collect_course`;
CREATE TABLE `user_collect_course` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  `course_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user_collect_course
-- ----------------------------

-- ----------------------------
-- Table structure for user_download_course
-- ----------------------------
DROP TABLE IF EXISTS `user_download_course`;
CREATE TABLE `user_download_course` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  `course_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user_download_course
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '唯一用户名',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码，md5加密',
  `sex` tinyint(2) unsigned NOT NULL DEFAULT '3' COMMENT '性别，1为男，2为女，3未设置',
  `birthday` int(10) unsigned DEFAULT NULL COMMENT '用户生日',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '' COMMENT '用户描述',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户头像url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='前端用户表';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'root', '123', '3', '1389919238', 'wowwo', '1', '1500443357', '1516323693', '/user/img/288');
INSERT INTO `users` VALUES ('2', 'root4', '123', '3', '1515060597', '6666', '1', '1515060503', '1515060503', '/user/img/-1');
INSERT INTO `users` VALUES ('3', 'root1', '123', '3', '1515060691', '6666', '1', '1515060691', '1515060691', '/user/img/-1');
