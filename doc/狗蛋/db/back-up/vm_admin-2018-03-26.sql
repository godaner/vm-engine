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

 Date: 26/03/2018 11:49:59
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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '后端管理员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_admins
-- ----------------------------
INSERT INTO `vm_admins` VALUES (1, 'aaa', 'aaaa', '', 1, 1, 1, 1, 0);
INSERT INTO `vm_admins` VALUES (6, 'AAA', 'a', '', 1, 1, 1, 1, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '后端管理员登录表' ROW_FORMAT = Compact;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for vm_auth_menus
-- ----------------------------
DROP TABLE IF EXISTS `vm_auth_menus`;
CREATE TABLE `vm_auth_menus`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `menu_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '资源名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码，md5加密',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '菜单访问路径',
  `pid` bigint(20) DEFAULT NULL COMMENT '上级菜单的id',
  `is_leaf` tinyint(5) NOT NULL COMMENT '是否为叶子节点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
