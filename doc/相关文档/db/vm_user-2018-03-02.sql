/*
 Navicat Premium Data Transfer

 Source Server         : 120.78.191.94_root
 Source Server Type    : MySQL
 Source Server Version : 50633
 Source Host           : 120.78.191.94:3306
 Source Schema         : vm_user

 Target Server Type    : MySQL
 Target Server Version : 50633
 File Encoding         : 65001

 Date: 02/03/2018 15:22:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for vm_users
-- ----------------------------
DROP TABLE IF EXISTS `vm_users`;
CREATE TABLE `vm_users`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '唯一用户名',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码，md5加密',
  `sex` tinyint(2) UNSIGNED NOT NULL DEFAULT 3 COMMENT '性别，1为男，2为女，3未设置',
  `birthday` int(10) UNSIGNED DEFAULT NULL COMMENT '用户生日',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '' COMMENT '用户描述',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户头像url',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为yes，2为no',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '前端用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_users
-- ----------------------------
INSERT INTO `vm_users` VALUES (1, 'root', '123', 3, 1389919238, 'wowwo43535433', 1500443357, 1519894717, '/src/img?fileId=360', 1, 1);
INSERT INTO `vm_users` VALUES (2, 'root4', '123', 3, 1515060597, '6666', 1515060503, 1515060503, '/src/img?fileId=-1', 1, 1);
INSERT INTO `vm_users` VALUES (3, 'root1', '123', 3, 1515060691, '6666', 1515060691, 1515060691, '/src/img?fileId=-1', 1, 1);

-- ----------------------------
-- Table structure for vm_users_login_logs
-- ----------------------------
DROP TABLE IF EXISTS `vm_users_login_logs`;
CREATE TABLE `vm_users_login_logs`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '前端用户登录记录' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
