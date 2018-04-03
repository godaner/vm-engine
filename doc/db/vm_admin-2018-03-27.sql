/*
 Navicat Premium Data Transfer

 Source Server         : 120.78.191.94_root
 Source Server Type    : MySQL
 Source Server Version : 50633
 Source Host           : 120.78.191.94:3306
 Source Schema         : vm_admin

 Target Server Type    : MySQL
 Target Server Version : 50633
 File Encoding         : 65001

 Date: 27/03/2018 17:48:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for vm_admins
-- ----------------------------
DROP TABLE IF EXISTS `vm_admins`;
CREATE TABLE `vm_admins`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '唯一用户名',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码，md5加密',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码，md5加密',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  `immutable` tinyint(5) NOT NULL COMMENT '是否为内置不可变对象，1为是，2为否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '后端管理员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_admins
-- ----------------------------
INSERT INTO `vm_admins` VALUES (1, 'aaa0', 'aaaa', 'aaaaaaaaaaaaaaaaaaaaaaaa', 1522042722, 1, 1, 1, 2);
INSERT INTO `vm_admins` VALUES (6, 'admin', '123', 'asdadad', 1522043584, 1, 1, 1, 2);
INSERT INTO `vm_admins` VALUES (7, 'root', '123', '这是root', 1522042749, 1522042268, 1, 1, 1);

-- ----------------------------
-- Table structure for vm_admins_login_logs
-- ----------------------------
DROP TABLE IF EXISTS `vm_admins_login_logs`;
CREATE TABLE `vm_admins_login_logs`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `admin_id` bigint(20) UNSIGNED NOT NULL COMMENT '登录的管理员id',
  `login_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登录ip',
  `system` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '电脑系统',
  `dpi` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '电脑分辨率',
  `brower` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '使用的浏览器',
  `country` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登录国家',
  `province` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登录省份',
  `city` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录城市',
  `login_time` int(6) UNSIGNED NOT NULL COMMENT '登陆时间',
  `result` tinyint(5) UNSIGNED NOT NULL COMMENT '登录结果，1位成功，2位失败',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '后端管理员登录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_admins_login_logs
-- ----------------------------
INSERT INTO `vm_admins_login_logs` VALUES (1, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522050494, 1, 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (2, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522052387, 1, 1522052387, 1522052387, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (3, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522052636, 1, 1522052636, 1522052636, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (4, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522052682, 1, 1522052682, 1522052682, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (5, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522052728, 1, 1522052728, 1522052728, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (6, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522054709, 1, 1522054709, 1522054709, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (7, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522055227, 1, 1522055227, 1522055227, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (8, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522055234, 1, 1522055234, 1522055234, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (9, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522055262, 1, 1522055262, 1522055262, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (10, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522055349, 1, 1522055349, 1522055349, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (11, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522055552, 1, 1522055552, 1522055552, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (12, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522055562, 1, 1522055562, 1522055562, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (13, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522055673, 1, 1522055673, 1522055673, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (14, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522055732, 1, 1522055732, 1522055732, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (15, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522055767, 1, 1522055767, 1522055767, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (16, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522055834, 1, 1522055834, 1522055834, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (18, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522059384, 1, 1522059384, 1522059384, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (19, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522059480, 1, 1522059480, 1522059480, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (20, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522119747, 1, 1522119747, 1522119747, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (21, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522119777, 1, 1522119777, 1522119777, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (22, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522119784, 1, 1522119784, 1522119784, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (23, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522119909, 1, 1522119909, 1522119909, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (24, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522119917, 1, 1522119917, 1522119917, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (25, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522126030, 1, 1522126030, 1522126030, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (26, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522128944, 1, 1522128944, 1522128944, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (27, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522133774, 1, 1522133774, 1522133774, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (28, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522133784, 1, 1522133784, 1522133784, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (29, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522135968, 1, 1522135968, 1522135968, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (30, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522143711, 1, 1522143711, 1522143711, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (31, 6, '171.221.141.10', 'Windows 7', '1920*1080', 'firefox 58.0', '中国', '四川', '成都', 1522144056, 1, 1522144056, 1522144056, 1, 1);

-- ----------------------------
-- Table structure for vm_admins_roles_realation
-- ----------------------------
DROP TABLE IF EXISTS `vm_admins_roles_realation`;
CREATE TABLE `vm_admins_roles_realation`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `admin_id` bigint(20) NOT NULL COMMENT '管理员id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_admins_roles_realation
-- ----------------------------
INSERT INTO `vm_admins_roles_realation` VALUES (1, 1522050494, 1522050494, 1, 1, 1, 7);
INSERT INTO `vm_admins_roles_realation` VALUES (2, 1522050494, 1522050494, 1, 1, 2, 6);

-- ----------------------------
-- Table structure for vm_auths
-- ----------------------------
DROP TABLE IF EXISTS `vm_auths`;
CREATE TABLE `vm_auths`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `auth_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '资源名',
  `auth_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '权限码,如user:add',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码，md5加密',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_auths
-- ----------------------------
INSERT INTO `vm_auths` VALUES (1, '角色添加', 'role:add', '角色添加', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (2, '角色查询', 'role:select', '角色查询', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (3, '角色编辑', 'role:edit', '角色编辑', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (4, '角色删除', 'role:delete', '角色删除', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (5, '管理员查询', 'admin:select', '管理员查询', 1522050494, 1522050494, 1, 1);

-- ----------------------------
-- Table structure for vm_menus
-- ----------------------------
DROP TABLE IF EXISTS `vm_menus`;
CREATE TABLE `vm_menus`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `menu_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '资源名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户密码，md5加密',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  `key_prop` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单key',
  `pid` bigint(20) DEFAULT NULL COMMENT '上级菜单的id',
  `is_leaf` tinyint(5) NOT NULL COMMENT '是否为叶子节点',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_menus
-- ----------------------------
INSERT INTO `vm_menus` VALUES (3, '主页', NULL, 1522050494, 1522050494, 1, 1, 'homeMenu', NULL, 2, 'home');
INSERT INTO `vm_menus` VALUES (4, '主页', NULL, 1522050494, 1522050494, 1, 1, '/', 3, 1, NULL);
INSERT INTO `vm_menus` VALUES (5, '用户管理', NULL, 1522050494, 1522050494, 1, 1, 'userMenu', NULL, 2, 'user');
INSERT INTO `vm_menus` VALUES (6, '用户管理', NULL, 1522050494, 1522050494, 1, 1, '/user', 5, 1, '');
INSERT INTO `vm_menus` VALUES (7, '登录记录', NULL, 1522050494, 1522050494, 1, 1, '/user/login/logs', 5, 1, '');
INSERT INTO `vm_menus` VALUES (8, '电影管理', NULL, 1522050494, 1522050494, 1, 1, 'movieMenu', NULL, 2, 'play-circle-o');
INSERT INTO `vm_menus` VALUES (9, '电影管理', NULL, 1522050494, 1522050494, 1, 1, '/movie', 8, 1, NULL);
INSERT INTO `vm_menus` VALUES (10, '电影人管理', NULL, 1522050494, 1522050494, 1, 1, '/movie/filmmaker', 8, 1, NULL);
INSERT INTO `vm_menus` VALUES (11, '标签分组管理', NULL, 1522050494, 1522050494, 1, 1, '/movie/tagGroup', 8, 1, NULL);
INSERT INTO `vm_menus` VALUES (12, '管理员管理', NULL, 1522050494, 1522050494, 1, 1, 'adminMenu', NULL, 2, 'lock');
INSERT INTO `vm_menus` VALUES (13, '管理员管理', '', 1522050494, 1522050494, 1, 1, '/admin', 12, 1, NULL);
INSERT INTO `vm_menus` VALUES (14, '登录记录', NULL, 1522050494, 1522050494, 1, 1, '/admin/login/logs', 12, 1, NULL);
INSERT INTO `vm_menus` VALUES (15, '角色管理', NULL, 1522050494, 1522050494, 1, 1, '/admin/role', 12, 1, NULL);

-- ----------------------------
-- Table structure for vm_roles
-- ----------------------------
DROP TABLE IF EXISTS `vm_roles`;
CREATE TABLE `vm_roles`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `role_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '唯一用户名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码，md5加密',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  `immutable` tinyint(5) NOT NULL COMMENT '是否为内置不可变对象，1为是，2为否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_roles
-- ----------------------------
INSERT INTO `vm_roles` VALUES (1, '超级管理员组', '超级管理员组', 1522050494, 1522050494, 1, 1, 1);
INSERT INTO `vm_roles` VALUES (2, 'admin', 'aaaaaaaaaaaaaaaaaaaaaa', 1522050494, 1522144100, 1, 1, 2);

-- ----------------------------
-- Table structure for vm_roles_auths_realation
-- ----------------------------
DROP TABLE IF EXISTS `vm_roles_auths_realation`;
CREATE TABLE `vm_roles_auths_realation`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `auth_id` bigint(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_roles_auths_realation
-- ----------------------------
INSERT INTO `vm_roles_auths_realation` VALUES (1, 1522050494, 1522050494, 1, 1, 1, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (2, 1522050494, 1522050494, 1, 1, 1, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (3, 1522050494, 1522050494, 1, 1, 1, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (4, 1522050494, 1522050494, 1, 1, 1, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (5, 1522050494, 1522050494, 1, 1, 1, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (6, 2, 1, 2, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (7, 1522136047, 1522136047, 2, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (8, 1522136047, 1522136047, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (9, 1522136047, 1522136047, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (10, 1522136150, 1522136150, 2, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (11, 1522136167, 1522136167, 2, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (12, 1522136167, 1522136167, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (13, 1522136167, 1522136167, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (14, 1522136167, 1522136167, 2, 1, 2, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (15, 1522136167, 1522136167, 2, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (16, 1522136516, 1522136516, 2, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (17, 1522136516, 1522136516, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (18, 1522136602, 1522136602, 2, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (19, 1522136602, 1522136602, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (20, 1522136602, 1522136602, 2, 1, 2, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (21, 1522136602, 1522136602, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (22, 1522136602, 1522136602, 2, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (23, 1522136611, 1522136611, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (24, 1522136617, 1522136617, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (25, 1522136617, 1522136617, 2, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (32, 1522143473, 1522143473, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (33, 1522143473, 1522143473, 2, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (34, 1522143485, 1522143485, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (35, 1522143485, 1522143485, 2, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (36, 1522143930, 1522143930, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (37, 1522143930, 1522143930, 2, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (38, 1522143943, 1522143943, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (39, 1522143943, 1522143943, 2, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (40, 1522144077, 1522144077, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (41, 1522144077, 1522144077, 2, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (42, 1522144100, 1522144100, 1, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (43, 1522144100, 1522144100, 1, 1, 2, 5);

-- ----------------------------
-- Table structure for vm_roles_menus_realation
-- ----------------------------
DROP TABLE IF EXISTS `vm_roles_menus_realation`;
CREATE TABLE `vm_roles_menus_realation`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_roles_menus_realation
-- ----------------------------
INSERT INTO `vm_roles_menus_realation` VALUES (3, 1522050494, 1522050494, 1, 1, 1, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (4, 1522050494, 1522050494, 1, 1, 1, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (5, 1522050494, 1522050494, 1, 1, 1, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (6, 1522050494, 1522050494, 1, 1, 1, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (7, 1522050494, 1522050494, 1, 1, 1, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (8, 1522050494, 1522050494, 1, 1, 1, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (9, 1522050494, 1522050494, 1, 1, 1, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (10, 1522050494, 1522050494, 1, 1, 1, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (12, 1522050494, 1522050494, 1, 1, 1, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (13, 1522050494, 1522050494, 1, 1, 1, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (14, 1522050494, 1522050494, 1, 1, 1, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (15, 1522050494, 1522050494, 1, 1, 1, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (16, 1522143473, 1522143473, 2, 1, 2, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (17, 1522143473, 1522143473, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (18, 1522143473, 1522143473, 2, 1, 2, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (19, 1522143473, 1522143473, 2, 1, 2, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (20, 1522143473, 1522143473, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (21, 1522143485, 1522143485, 2, 1, 2, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (22, 1522143485, 1522143485, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (23, 1522143485, 1522143485, 2, 1, 2, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (24, 1522143485, 1522143485, 2, 1, 2, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (25, 1522143485, 1522143485, 2, 1, 2, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (26, 1522143485, 1522143485, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (27, 1522143485, 1522143485, 2, 1, 2, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (28, 1522143930, 1522143930, 2, 1, 2, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (29, 1522143930, 1522143930, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (30, 1522143930, 1522143930, 2, 1, 2, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (31, 1522143930, 1522143930, 2, 1, 2, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (32, 1522143930, 1522143930, 2, 1, 2, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (33, 1522143930, 1522143930, 2, 1, 2, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (34, 1522143930, 1522143930, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (35, 1522143930, 1522143930, 2, 1, 2, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (36, 1522143944, 1522143944, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (37, 1522143944, 1522143944, 2, 1, 2, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (38, 1522143944, 1522143944, 2, 1, 2, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (39, 1522143944, 1522143944, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (40, 1522144077, 1522144077, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (41, 1522144077, 1522144077, 2, 1, 2, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (42, 1522144077, 1522144077, 2, 1, 2, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (43, 1522144077, 1522144077, 2, 1, 2, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (44, 1522144077, 1522144077, 2, 1, 2, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (45, 1522144077, 1522144077, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (46, 1522144077, 1522144077, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (47, 1522144077, 1522144077, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (48, 1522144077, 1522144077, 2, 1, 2, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (49, 1522144077, 1522144077, 2, 1, 2, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (50, 1522144077, 1522144077, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (51, 1522144077, 1522144077, 2, 1, 2, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (52, 1522144077, 1522144077, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (53, 1522144100, 1522144100, 1, 1, 2, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (54, 1522144100, 1522144100, 1, 1, 2, 3);

SET FOREIGN_KEY_CHECKS = 1;
