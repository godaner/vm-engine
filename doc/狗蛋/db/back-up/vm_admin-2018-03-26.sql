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

 Date: 26/03/2018 21:33:57
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
INSERT INTO `vm_admins` VALUES (6, 'AAA', 'a', 'asdadad', 1522043584, 1, 1, 1, 2);
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
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '后端管理员登录表' ROW_FORMAT = Compact;

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_admins_roles_realation
-- ----------------------------
INSERT INTO `vm_admins_roles_realation` VALUES (1, 1, 1, 1, 1, 1, 7);

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

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
  `key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单key',
  `pid` bigint(20) DEFAULT NULL COMMENT '上级菜单的id',
  `is_leaf` tinyint(5) NOT NULL COMMENT '是否为叶子节点',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_menus
-- ----------------------------
INSERT INTO `vm_menus` VALUES (1, '管理员管理阿萨德', '管理员管理', 1, 1, 1, 1, '/admin', 2, 1, NULL);
INSERT INTO `vm_menus` VALUES (2, 'guanliyuan', NULL, 1, 1, 1, 1, 'adminSubMenu', NULL, 2, 'lock');

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_roles
-- ----------------------------
INSERT INTO `vm_roles` VALUES (1, '超级管理员组', '超级管理员组', 1, 1, 1, 1, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_roles_menus_realation
-- ----------------------------
INSERT INTO `vm_roles_menus_realation` VALUES (1, 1, 1, 1, 1, 1, 1);
INSERT INTO `vm_roles_menus_realation` VALUES (2, 2, 2, 1, 1, 1, 2);

SET FOREIGN_KEY_CHECKS = 1;
