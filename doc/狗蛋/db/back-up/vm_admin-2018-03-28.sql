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

 Date: 28/03/2018 21:37:12
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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '后端管理员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_admins
-- ----------------------------
INSERT INTO `vm_admins` VALUES (1, 'aaa0', 'aaaa', 'aaaaaaaaaaaaaaaaaaaaaaaa', 1522152364, 1, 1, 1, 2);
INSERT INTO `vm_admins` VALUES (6, 'admin', '123', 'asdadad', 1522201860, 1, 1, 1, 2);
INSERT INTO `vm_admins` VALUES (7, 'root', '123', '这是root', 1522042749, 1522042268, 1, 1, 1);
INSERT INTO `vm_admins` VALUES (8, '123', '123', '123', 1522155159, 1522153697, 1, 1, 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '后端管理员登录表' ROW_FORMAT = Compact;

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
INSERT INTO `vm_admins_login_logs` VALUES (32, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 58.0', '中国', '四川', '成都', 1522149167, 1, 1522149167, 1522149167, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (33, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522150151, 1, 1522150151, 1522150151, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (34, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522153674, 1, 1522153674, 1522153674, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (35, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522156745, 1, 1522156745, 1522156745, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (36, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522156760, 1, 1522156760, 1522156760, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (37, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522156782, 1, 1522156782, 1522156782, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (38, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522206468, 1, 1522206468, 1522206468, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (39, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522206519, 1, 1522206519, 1522206519, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (40, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522207227, 1, 1522207227, 1522207227, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (41, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522212048, 1, 1522212048, 1522212048, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (42, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522212369, 1, 1522212369, 1522212369, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (43, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522212389, 1, 1522212389, 1522212389, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (44, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522212452, 1, 1522212452, 1522212452, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (45, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522212487, 1, 1522212487, 1522212487, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (46, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522213398, 1, 1522213398, 1522213398, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (47, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522213625, 1, 1522213625, 1522213625, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (48, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522213631, 1, 1522213631, 1522213631, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (49, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522213646, 1, 1522213646, 1522213646, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (50, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522214008, 1, 1522214008, 1522214008, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (51, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522214105, 1, 1522214105, 1522214105, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (52, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522214112, 1, 1522214112, 1522214112, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (53, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522215468, 1, 1522215468, 1522215468, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (54, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522216076, 1, 1522216076, 1522216076, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (55, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522216516, 1, 1522216516, 1522216516, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (56, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522216752, 1, 1522216752, 1522216752, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (57, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522217020, 1, 1522217020, 1522217020, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (58, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522218393, 1, 1522218393, 1522218393, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (59, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522218670, 1, 1522218670, 1522218670, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (60, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522218678, 1, 1522218678, 1522218678, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (61, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522218684, 1, 1522218684, 1522218684, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (62, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522218751, 1, 1522218751, 1522218751, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (63, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522218769, 1, 1522218769, 1522218769, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (64, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522218889, 1, 1522218889, 1522218889, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (65, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522218917, 1, 1522218917, 1522218917, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (66, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522218937, 1, 1522218937, 1522218937, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (67, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522220661, 1, 1522220661, 1522220661, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (68, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522220695, 1, 1522220695, 1522220695, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (69, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522220914, 1, 1522220914, 1522220914, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (70, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522220985, 1, 1522220985, 1522220985, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (71, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522221035, 1, 1522221035, 1522221035, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (72, 7, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522221052, 1, 1522221052, 1522221052, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (73, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522221071, 1, 1522221071, 1522221071, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (74, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522221408, 1, 1522221408, 1522221408, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (76, 7, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522243485, 1, 1522243485, 1522243485, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (78, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522243703, 1, 1522243703, 1522243703, 1, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_admins_roles_realation
-- ----------------------------
INSERT INTO `vm_admins_roles_realation` VALUES (1, 1522050494, 1522050494, 1, 1, 1, 7);
INSERT INTO `vm_admins_roles_realation` VALUES (2, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (3, 1522050494, 1522050494, 2, 1, 3, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (4, 1522050494, 1522050494, 2, 1, 1, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (5, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (6, 1522050494, 1522050494, 2, 1, 1, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (7, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (8, 1522050494, 1522050494, 2, 1, 3, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (9, 1522050494, 1522050494, 1, 1, 1, 1);
INSERT INTO `vm_admins_roles_realation` VALUES (10, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (11, 1522050494, 1522050494, 2, 1, 3, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (12, 1522050494, 1522050494, 2, 1, 1, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (13, 1522050494, 1522050494, 1, 1, 1, 8);
INSERT INTO `vm_admins_roles_realation` VALUES (14, 1522050494, 1522050494, 1, 1, 2, 8);
INSERT INTO `vm_admins_roles_realation` VALUES (15, 1522050494, 1522050494, 1, 1, 1, 8);
INSERT INTO `vm_admins_roles_realation` VALUES (16, 1522050494, 1522050494, 1, 1, 2, 8);
INSERT INTO `vm_admins_roles_realation` VALUES (17, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (18, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (19, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (20, 1522050494, 1522050494, 1, 1, 2, 6);

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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_auths
-- ----------------------------
INSERT INTO `vm_auths` VALUES (1, '角色添加', 'role:add', '角色添加', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (2, '角色删除', 'role:delete', '角色删除', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (3, '角色查询', 'role:select', '角色查询', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (4, '角色修改', 'role:edit', '角色修改', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (5, '管理员添加', 'admin:add', '管理员添加', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (6, '管理员删除', 'admin:delete', '管理员删除', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (7, '管理员查询', 'admin:select', '管理员查询', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (8, '管理员修改', 'admin:edit', '管理员修改', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (9, '管理员登录记录查询', 'adminLoginLogs:select', '管理员登录记录查询', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (10, '用户添加', 'user:add', '用户添加', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (11, '用户删除', 'user:delete', '用户删除', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (12, '用户查询', 'user:select', '用户查询', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (13, '用户修改', 'user:edit', '用户修改', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (14, '用户登录记录查询', 'userLoginLogs:select', '用户登录记录查询', 1522050494, 1522050494, 1, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_roles
-- ----------------------------
INSERT INTO `vm_roles` VALUES (1, '超级管理员组', '超级管理员组', 1522050494, 1522050494, 1, 1, 1);
INSERT INTO `vm_roles` VALUES (2, 'admin', 'aaaaaaaaaaaaaaaaaaaaaa', 1522050494, 1522244243, 1, 1, 2);
INSERT INTO `vm_roles` VALUES (3, 'admin01', 'admin', 1522050494, 1522050494, 1, 1, 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_roles_auths_realation
-- ----------------------------
INSERT INTO `vm_roles_auths_realation` VALUES (1, 1522050494, 1522050494, 1, 1, 1, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (2, 1522050494, 1522050494, 1, 1, 1, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (3, 1522050494, 1522050494, 1, 1, 1, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (4, 1522050494, 1522050494, 1, 1, 1, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (5, 1522050494, 1522050494, 1, 1, 1, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (6, 1522050494, 1522050494, 1, 1, 1, 6);
INSERT INTO `vm_roles_auths_realation` VALUES (7, 1522050494, 1522050494, 1, 1, 1, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (8, 1522050494, 1522050494, 1, 1, 1, 8);
INSERT INTO `vm_roles_auths_realation` VALUES (9, 1522050494, 1522050494, 1, 1, 1, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (10, 1522050494, 1522050494, 1, 1, 1, 10);
INSERT INTO `vm_roles_auths_realation` VALUES (11, 1522050494, 1522050494, 1, 1, 1, 11);
INSERT INTO `vm_roles_auths_realation` VALUES (12, 1522050494, 1522050494, 1, 1, 1, 12);
INSERT INTO `vm_roles_auths_realation` VALUES (13, 1522050494, 1522050494, 1, 1, 1, 13);
INSERT INTO `vm_roles_auths_realation` VALUES (14, 1522050494, 1522050494, 1, 1, 1, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (62, 1522243747, 1522243747, 2, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (63, 1522243769, 1522243769, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (64, 1522244243, 1522244243, 1, 1, 2, 3);

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
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_roles_menus_realation
-- ----------------------------
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
INSERT INTO `vm_roles_menus_realation` VALUES (16, 1522050494, 1522050494, 2, 1, 2, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (17, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (18, 1522050494, 1522050494, 2, 1, 2, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (19, 1522050494, 1522050494, 2, 1, 2, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (20, 1522050494, 1522050494, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (21, 1522050494, 1522050494, 2, 1, 2, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (22, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (23, 1522050494, 1522050494, 2, 1, 2, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (24, 1522050494, 1522050494, 2, 1, 2, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (25, 1522050494, 1522050494, 2, 1, 2, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (26, 1522050494, 1522050494, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (27, 1522050494, 1522050494, 2, 1, 2, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (28, 1522050494, 1522050494, 2, 1, 2, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (29, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (30, 1522050494, 1522050494, 2, 1, 2, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (31, 1522050494, 1522050494, 2, 1, 2, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (32, 1522050494, 1522050494, 2, 1, 2, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (33, 1522050494, 1522050494, 2, 1, 2, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (34, 1522050494, 1522050494, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (35, 1522050494, 1522050494, 2, 1, 2, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (36, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (39, 1522050494, 1522050494, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (40, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (41, 1522050494, 1522050494, 2, 1, 2, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (42, 1522050494, 1522050494, 2, 1, 2, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (43, 1522050494, 1522050494, 2, 1, 2, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (44, 1522050494, 1522050494, 2, 1, 2, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (45, 1522050494, 1522050494, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (46, 1522050494, 1522050494, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (47, 1522050494, 1522050494, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (48, 1522050494, 1522050494, 2, 1, 2, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (50, 1522050494, 1522050494, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (51, 1522050494, 1522050494, 2, 1, 2, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (52, 1522050494, 1522050494, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (54, 1522050494, 1522050494, 2, 1, 2, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (55, 1522050494, 1522050494, 2, 1, 2, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (56, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (57, 1522050494, 1522050494, 2, 1, 2, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (59, 1522050494, 1522050494, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (61, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (62, 1522050494, 1522050494, 2, 1, 2, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (63, 1522050494, 1522050494, 2, 1, 2, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (64, 1522050494, 1522050494, 2, 1, 2, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (65, 1522050494, 1522050494, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (66, 1522050494, 1522050494, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (67, 1522050494, 1522050494, 2, 1, 2, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (68, 1522050494, 1522050494, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (69, 1522050494, 1522050494, 2, 1, 2, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (70, 1522050494, 1522050494, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (71, 1522050494, 1522050494, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (72, 1522050494, 1522050494, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (73, 1522050494, 1522050494, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (74, 1522050494, 1522050494, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (75, 1522050494, 1522050494, 2, 1, 3, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (76, 1522050494, 1522050494, 2, 1, 3, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (77, 1522050494, 1522050494, 2, 1, 3, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (78, 1522050494, 1522050494, 2, 1, 3, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (79, 1522050494, 1522050494, 2, 1, 3, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (80, 1522050494, 1522050494, 1, 1, 3, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (81, 1522050494, 1522050494, 1, 1, 3, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (82, 1522050494, 1522050494, 1, 1, 3, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (83, 1522050494, 1522050494, 1, 1, 3, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (84, 1522050494, 1522050494, 1, 1, 3, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (85, 1522050494, 1522050494, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (86, 1522050494, 1522050494, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (87, 1522050494, 1522050494, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (88, 1522050494, 1522050494, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (89, 1522243748, 1522243748, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (90, 1522243748, 1522243748, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (91, 1522243748, 1522243748, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (92, 1522243748, 1522243748, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (93, 1522243769, 1522243769, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (94, 1522243769, 1522243769, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (95, 1522243769, 1522243769, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (96, 1522243769, 1522243769, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (97, 1522244243, 1522244243, 1, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (98, 1522244243, 1522244243, 1, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (99, 1522244243, 1522244243, 1, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (100, 1522244243, 1522244243, 1, 1, 2, 12);

SET FOREIGN_KEY_CHECKS = 1;
