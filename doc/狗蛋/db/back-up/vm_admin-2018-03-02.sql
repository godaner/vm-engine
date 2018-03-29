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

 Date: 02/03/2018 15:21:55
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
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为yes，2为no',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '后端管理员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_admins
-- ----------------------------
INSERT INTO `vm_admins` VALUES (1, 'aaa', 'aaaa', 1, 1, 1, 1);
INSERT INTO `vm_admins` VALUES (6, 'AAA', 'a', 1, 1, 1, 1);

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
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为yes，2为no',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '后端管理员登录表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
