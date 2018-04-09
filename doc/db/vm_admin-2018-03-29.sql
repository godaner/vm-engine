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

 Date: 29/03/2018 16:49:50
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
INSERT INTO `vm_admins` VALUES (1, 'guest', '123', 'aaaaaaaaaaaaaaaaaaaaaaaa', 1522293645, 1, 1, 1, 2);
INSERT INTO `vm_admins` VALUES (6, 'root', '123', 'root管理员，拥有superman角色', 1522288016, 1, 1, 1, 1);
INSERT INTO `vm_admins` VALUES (7, 'rootback', '123', '这是root', 1522293404, 1522042268, 1, 1, 2);
INSERT INTO `vm_admins` VALUES (8, '123', '123', '123', 1522155159, 1522153697, 2, 1, 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '后端管理员登录表' ROW_FORMAT = Compact;

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
INSERT INTO `vm_admins_login_logs` VALUES (79, 6, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522288039, 1, 1522288039, 1522288039, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (80, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522291567, 1, 1522291567, 1522291567, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (81, 1, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522293648, 1, 1522293648, 1522293648, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (82, 6, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522298463, 1, 1522298463, 1522298463, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (83, 6, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522298471, 1, 1522298471, 1522298471, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (84, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522301920, 1, 1522301920, 1522301920, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (85, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522302386, 1, 1522302386, 1522302386, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (86, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522302519, 1, 1522302519, 1522302519, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (87, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522302694, 1, 1522302694, 1522302694, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (88, 1, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522302708, 1, 1522302708, 1522302708, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (89, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522302812, 1, 1522302812, 1522302812, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (90, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522302818, 1, 1522302818, 1522302818, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (91, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522302828, 1, 1522302828, 1522302828, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (92, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522302860, 1, 1522302860, 1522302860, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (93, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522302869, 1, 1522302869, 1522302869, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (94, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522302872, 1, 1522302872, 1522302872, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (95, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522302879, 1, 1522302879, 1522302879, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (99, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522310751, 1, 1522310751, 1522310751, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (100, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522310753, 1, 1522310753, 1522310753, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (103, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522312039, 1, 1522312039, 1522312039, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (104, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522312049, 1, 1522312049, 1522312049, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (105, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522312177, 1, 1522312177, 1522312177, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (106, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522312247, 1, 1522312247, 1522312247, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (107, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522312252, 1, 1522312252, 1522312252, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (108, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522312265, 1, 1522312265, 1522312265, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (109, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522312271, 1, 1522312271, 1522312271, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (110, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522312277, 1, 1522312277, 1522312277, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (111, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522312283, 1, 1522312283, 1522312283, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (112, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522312367, 1, 1522312367, 1522312367, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (113, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522312909, 1, 1522312909, 1522312909, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (114, 6, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522312921, 1, 1522312921, 1522312921, 1, 1);
INSERT INTO `vm_admins_login_logs` VALUES (115, 1, '171.221.141.10', 'Windows 7', '1920*1080', 'firefox 59.0', '中国', '四川', '成都', 1522313224, 1, 1522313224, 1522313224, 1, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_admins_roles_realation
-- ----------------------------
INSERT INTO `vm_admins_roles_realation` VALUES (1, 1522050494, 1522050494, 2, 1, 1, 7);
INSERT INTO `vm_admins_roles_realation` VALUES (2, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (3, 1522050494, 1522050494, 2, 1, 3, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (4, 1522050494, 1522050494, 2, 1, 1, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (5, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (6, 1522050494, 1522050494, 2, 1, 1, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (7, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (8, 1522050494, 1522050494, 2, 1, 3, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (9, 1522050494, 1522050494, 2, 1, 1, 1);
INSERT INTO `vm_admins_roles_realation` VALUES (10, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (11, 1522050494, 1522050494, 2, 1, 3, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (12, 1522050494, 1522050494, 2, 1, 1, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (13, 1522050494, 1522050494, 2, 1, 1, 8);
INSERT INTO `vm_admins_roles_realation` VALUES (14, 1522050494, 1522050494, 2, 1, 2, 8);
INSERT INTO `vm_admins_roles_realation` VALUES (15, 1522050494, 1522050494, 2, 1, 1, 8);
INSERT INTO `vm_admins_roles_realation` VALUES (16, 1522050494, 1522050494, 2, 1, 2, 8);
INSERT INTO `vm_admins_roles_realation` VALUES (17, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (18, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (19, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (20, 1522050494, 1522050494, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (21, 1522287943, 1522287943, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (22, 1522287991, 1522287991, 2, 1, 1, 7);
INSERT INTO `vm_admins_roles_realation` VALUES (23, 1522287998, 1522287998, 2, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (24, 1522288016, 1522288016, 1, 1, 2, 6);
INSERT INTO `vm_admins_roles_realation` VALUES (25, 1522291346, 1522291346, 2, 1, 1, 1);
INSERT INTO `vm_admins_roles_realation` VALUES (26, 1522291346, 1522291346, 2, 1, 2, 1);
INSERT INTO `vm_admins_roles_realation` VALUES (27, 1522291346, 1522291346, 2, 1, 3, 1);
INSERT INTO `vm_admins_roles_realation` VALUES (28, 1522293267, 1522293267, 2, 1, 1, 7);
INSERT INTO `vm_admins_roles_realation` VALUES (29, 1522293404, 1522293404, 1, 1, 1, 7);
INSERT INTO `vm_admins_roles_realation` VALUES (30, 1522293619, 1522293619, 2, 1, 3, 1);
INSERT INTO `vm_admins_roles_realation` VALUES (31, 1522293646, 1522293646, 1, 1, 3, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

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
INSERT INTO `vm_auths` VALUES (15, '电影人添加', 'filmmaker:add', '电影人添加', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (16, '电影人删除', 'filmmaker:delete', '电影人删除', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (17, '电影人查询', 'filmmaker:select', '电影人查询', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (18, '电影人修改', 'filmmaker:edit', '电影人修改', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (19, '电影添加', 'movie:add', '电影添加', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (20, '电影删除', 'movie:delete', '电影删除', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (21, '电影查询', 'movie:select', '电影查询', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (22, '电影修改', 'movie:edit', '电影修改', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (23, '电影资源添加', 'movieVersion:add', '电影资源添加', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (24, '电影资源删除', 'movieVersion:delete', '电影资源删除', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (25, '电影资源查询', 'movieVersion:select', '电影资源查询', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (26, '电影资源修改', 'movieVersion:edit', '电影资源修改', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (27, '标签分组添加', 'tagGroup:add', '标签分组添加', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (28, '标签分组删除', 'tagGroup:delete', '标签分组删除', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (29, '标签分组查询', 'tagGroup:select', '标签分组查询', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (30, '标签分组修改', 'tagGroup:edit', '标签分组修改', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (31, '标签添加', 'tag:add', '标签添加', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (32, '标签删除', 'tag:delete', '标签删除', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (33, '标签查询', 'tag:select', '标签查询', 1522050494, 1522050494, 1, 1);
INSERT INTO `vm_auths` VALUES (34, '标签修改', 'tag:edit', '标签修改', 1522050494, 1522050494, 1, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_roles
-- ----------------------------
INSERT INTO `vm_roles` VALUES (1, '超级管理员组', '超级管理员组', 1522050494, 1522312940, 1, 1, 2);
INSERT INTO `vm_roles` VALUES (2, 'superman', 'superman，拥有所有权限和菜单的角色', 1522050494, 1522287911, 1, 1, 1);
INSERT INTO `vm_roles` VALUES (3, 'guest', 'guest', 1522050494, 1522302795, 1, 1, 2);
INSERT INTO `vm_roles` VALUES (4, '123', '123', 1522294127, 1522294133, 2, 1, 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 446 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_roles_auths_realation
-- ----------------------------
INSERT INTO `vm_roles_auths_realation` VALUES (1, 1522050494, 1522050494, 2, 1, 1, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (2, 1522050494, 1522050494, 2, 1, 1, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (3, 1522050494, 1522050494, 2, 1, 1, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (4, 1522050494, 1522050494, 2, 1, 1, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (5, 1522050494, 1522050494, 2, 1, 1, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (6, 1522050494, 1522050494, 2, 1, 1, 6);
INSERT INTO `vm_roles_auths_realation` VALUES (7, 1522050494, 1522050494, 2, 1, 1, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (8, 1522050494, 1522050494, 2, 1, 1, 8);
INSERT INTO `vm_roles_auths_realation` VALUES (9, 1522050494, 1522050494, 2, 1, 1, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (10, 1522050494, 1522050494, 2, 1, 1, 10);
INSERT INTO `vm_roles_auths_realation` VALUES (11, 1522050494, 1522050494, 2, 1, 1, 11);
INSERT INTO `vm_roles_auths_realation` VALUES (12, 1522050494, 1522050494, 2, 1, 1, 12);
INSERT INTO `vm_roles_auths_realation` VALUES (13, 1522050494, 1522050494, 2, 1, 1, 13);
INSERT INTO `vm_roles_auths_realation` VALUES (14, 1522050494, 1522050494, 2, 1, 1, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (62, 1522243747, 1522243747, 2, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (63, 1522243769, 1522243769, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (64, 1522244243, 1522244243, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (65, 1522244360, 1522244360, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (66, 1522245095, 1522245095, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (67, 1522246428, 1522246428, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (68, 1522246428, 1522246428, 2, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (69, 1522246428, 1522246428, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (70, 1522246428, 1522246428, 2, 1, 2, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (71, 1522246428, 1522246428, 2, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (72, 1522246428, 1522246428, 2, 1, 2, 6);
INSERT INTO `vm_roles_auths_realation` VALUES (73, 1522246428, 1522246428, 2, 1, 2, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (74, 1522246428, 1522246428, 2, 1, 2, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (75, 1522246428, 1522246428, 2, 1, 2, 8);
INSERT INTO `vm_roles_auths_realation` VALUES (76, 1522246428, 1522246428, 2, 1, 2, 10);
INSERT INTO `vm_roles_auths_realation` VALUES (77, 1522246428, 1522246428, 2, 1, 2, 11);
INSERT INTO `vm_roles_auths_realation` VALUES (78, 1522246428, 1522246428, 2, 1, 2, 12);
INSERT INTO `vm_roles_auths_realation` VALUES (79, 1522246428, 1522246428, 2, 1, 2, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (80, 1522246428, 1522246428, 2, 1, 2, 13);
INSERT INTO `vm_roles_auths_realation` VALUES (81, 1522246428, 1522246428, 2, 1, 2, 15);
INSERT INTO `vm_roles_auths_realation` VALUES (82, 1522246428, 1522246428, 2, 1, 2, 16);
INSERT INTO `vm_roles_auths_realation` VALUES (83, 1522246428, 1522246428, 2, 1, 2, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (84, 1522246428, 1522246428, 2, 1, 2, 18);
INSERT INTO `vm_roles_auths_realation` VALUES (85, 1522246428, 1522246428, 2, 1, 2, 19);
INSERT INTO `vm_roles_auths_realation` VALUES (86, 1522246428, 1522246428, 2, 1, 2, 20);
INSERT INTO `vm_roles_auths_realation` VALUES (87, 1522246428, 1522246428, 2, 1, 2, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (88, 1522246428, 1522246428, 2, 1, 2, 24);
INSERT INTO `vm_roles_auths_realation` VALUES (89, 1522246428, 1522246428, 2, 1, 2, 23);
INSERT INTO `vm_roles_auths_realation` VALUES (90, 1522246428, 1522246428, 2, 1, 2, 22);
INSERT INTO `vm_roles_auths_realation` VALUES (91, 1522246428, 1522246428, 2, 1, 2, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (92, 1522246428, 1522246428, 2, 1, 2, 26);
INSERT INTO `vm_roles_auths_realation` VALUES (93, 1522246428, 1522246428, 2, 1, 2, 34);
INSERT INTO `vm_roles_auths_realation` VALUES (94, 1522246428, 1522246428, 2, 1, 2, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (95, 1522246428, 1522246428, 2, 1, 2, 32);
INSERT INTO `vm_roles_auths_realation` VALUES (96, 1522246428, 1522246428, 2, 1, 2, 30);
INSERT INTO `vm_roles_auths_realation` VALUES (97, 1522246428, 1522246428, 2, 1, 2, 31);
INSERT INTO `vm_roles_auths_realation` VALUES (98, 1522246428, 1522246428, 2, 1, 2, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (99, 1522246428, 1522246428, 2, 1, 2, 28);
INSERT INTO `vm_roles_auths_realation` VALUES (100, 1522246428, 1522246428, 2, 1, 2, 27);
INSERT INTO `vm_roles_auths_realation` VALUES (101, 1522246470, 1522246470, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (102, 1522246470, 1522246470, 2, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (103, 1522246470, 1522246470, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (104, 1522246470, 1522246470, 2, 1, 2, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (105, 1522246470, 1522246470, 2, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (106, 1522246470, 1522246470, 2, 1, 2, 6);
INSERT INTO `vm_roles_auths_realation` VALUES (107, 1522246470, 1522246470, 2, 1, 2, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (108, 1522246470, 1522246470, 2, 1, 2, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (109, 1522246470, 1522246470, 2, 1, 2, 8);
INSERT INTO `vm_roles_auths_realation` VALUES (110, 1522246470, 1522246470, 2, 1, 2, 10);
INSERT INTO `vm_roles_auths_realation` VALUES (111, 1522246470, 1522246470, 2, 1, 2, 11);
INSERT INTO `vm_roles_auths_realation` VALUES (112, 1522246470, 1522246470, 2, 1, 2, 12);
INSERT INTO `vm_roles_auths_realation` VALUES (113, 1522246470, 1522246470, 2, 1, 2, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (114, 1522246470, 1522246470, 2, 1, 2, 13);
INSERT INTO `vm_roles_auths_realation` VALUES (115, 1522246470, 1522246470, 2, 1, 2, 15);
INSERT INTO `vm_roles_auths_realation` VALUES (116, 1522246470, 1522246470, 2, 1, 2, 16);
INSERT INTO `vm_roles_auths_realation` VALUES (117, 1522246470, 1522246470, 2, 1, 2, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (118, 1522246470, 1522246470, 2, 1, 2, 18);
INSERT INTO `vm_roles_auths_realation` VALUES (119, 1522246470, 1522246470, 2, 1, 2, 19);
INSERT INTO `vm_roles_auths_realation` VALUES (120, 1522246470, 1522246470, 2, 1, 2, 20);
INSERT INTO `vm_roles_auths_realation` VALUES (121, 1522246470, 1522246470, 2, 1, 2, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (122, 1522246470, 1522246470, 2, 1, 2, 24);
INSERT INTO `vm_roles_auths_realation` VALUES (123, 1522246470, 1522246470, 2, 1, 2, 23);
INSERT INTO `vm_roles_auths_realation` VALUES (124, 1522246470, 1522246470, 2, 1, 2, 22);
INSERT INTO `vm_roles_auths_realation` VALUES (125, 1522246470, 1522246470, 2, 1, 2, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (126, 1522246470, 1522246470, 2, 1, 2, 26);
INSERT INTO `vm_roles_auths_realation` VALUES (127, 1522246470, 1522246470, 2, 1, 2, 34);
INSERT INTO `vm_roles_auths_realation` VALUES (128, 1522246470, 1522246470, 2, 1, 2, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (129, 1522246470, 1522246470, 2, 1, 2, 32);
INSERT INTO `vm_roles_auths_realation` VALUES (130, 1522246470, 1522246470, 2, 1, 2, 30);
INSERT INTO `vm_roles_auths_realation` VALUES (131, 1522246470, 1522246470, 2, 1, 2, 31);
INSERT INTO `vm_roles_auths_realation` VALUES (132, 1522246470, 1522246470, 2, 1, 2, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (133, 1522246470, 1522246470, 2, 1, 2, 28);
INSERT INTO `vm_roles_auths_realation` VALUES (134, 1522246470, 1522246470, 2, 1, 2, 27);
INSERT INTO `vm_roles_auths_realation` VALUES (135, 1522246848, 1522246848, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (136, 1522246848, 1522246848, 2, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (137, 1522246848, 1522246848, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (138, 1522246848, 1522246848, 2, 1, 2, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (139, 1522246848, 1522246848, 2, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (140, 1522246848, 1522246848, 2, 1, 2, 6);
INSERT INTO `vm_roles_auths_realation` VALUES (141, 1522246848, 1522246848, 2, 1, 2, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (142, 1522246848, 1522246848, 2, 1, 2, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (143, 1522246848, 1522246848, 2, 1, 2, 8);
INSERT INTO `vm_roles_auths_realation` VALUES (144, 1522246848, 1522246848, 2, 1, 2, 10);
INSERT INTO `vm_roles_auths_realation` VALUES (145, 1522246848, 1522246848, 2, 1, 2, 11);
INSERT INTO `vm_roles_auths_realation` VALUES (146, 1522246848, 1522246848, 2, 1, 2, 12);
INSERT INTO `vm_roles_auths_realation` VALUES (147, 1522246848, 1522246848, 2, 1, 2, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (148, 1522246848, 1522246848, 2, 1, 2, 13);
INSERT INTO `vm_roles_auths_realation` VALUES (149, 1522246848, 1522246848, 2, 1, 2, 15);
INSERT INTO `vm_roles_auths_realation` VALUES (150, 1522246848, 1522246848, 2, 1, 2, 16);
INSERT INTO `vm_roles_auths_realation` VALUES (151, 1522246848, 1522246848, 2, 1, 2, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (152, 1522246848, 1522246848, 2, 1, 2, 18);
INSERT INTO `vm_roles_auths_realation` VALUES (153, 1522246848, 1522246848, 2, 1, 2, 19);
INSERT INTO `vm_roles_auths_realation` VALUES (154, 1522246848, 1522246848, 2, 1, 2, 20);
INSERT INTO `vm_roles_auths_realation` VALUES (155, 1522246848, 1522246848, 2, 1, 2, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (156, 1522246848, 1522246848, 2, 1, 2, 24);
INSERT INTO `vm_roles_auths_realation` VALUES (157, 1522246848, 1522246848, 2, 1, 2, 23);
INSERT INTO `vm_roles_auths_realation` VALUES (158, 1522246848, 1522246848, 2, 1, 2, 22);
INSERT INTO `vm_roles_auths_realation` VALUES (159, 1522246848, 1522246848, 2, 1, 2, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (160, 1522246848, 1522246848, 2, 1, 2, 26);
INSERT INTO `vm_roles_auths_realation` VALUES (161, 1522246848, 1522246848, 2, 1, 2, 34);
INSERT INTO `vm_roles_auths_realation` VALUES (162, 1522246848, 1522246848, 2, 1, 2, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (163, 1522246848, 1522246848, 2, 1, 2, 32);
INSERT INTO `vm_roles_auths_realation` VALUES (164, 1522246848, 1522246848, 2, 1, 2, 30);
INSERT INTO `vm_roles_auths_realation` VALUES (165, 1522246848, 1522246848, 2, 1, 2, 31);
INSERT INTO `vm_roles_auths_realation` VALUES (166, 1522246848, 1522246848, 2, 1, 2, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (167, 1522246848, 1522246848, 2, 1, 2, 28);
INSERT INTO `vm_roles_auths_realation` VALUES (168, 1522246848, 1522246848, 2, 1, 2, 27);
INSERT INTO `vm_roles_auths_realation` VALUES (169, 1522246871, 1522246871, 2, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (170, 1522246871, 1522246871, 2, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (171, 1522246871, 1522246871, 2, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (172, 1522246871, 1522246871, 2, 1, 2, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (173, 1522246871, 1522246871, 2, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (174, 1522246871, 1522246871, 2, 1, 2, 6);
INSERT INTO `vm_roles_auths_realation` VALUES (175, 1522246871, 1522246871, 2, 1, 2, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (176, 1522246871, 1522246871, 2, 1, 2, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (177, 1522246871, 1522246871, 2, 1, 2, 8);
INSERT INTO `vm_roles_auths_realation` VALUES (178, 1522246871, 1522246871, 2, 1, 2, 10);
INSERT INTO `vm_roles_auths_realation` VALUES (179, 1522246871, 1522246871, 2, 1, 2, 11);
INSERT INTO `vm_roles_auths_realation` VALUES (180, 1522246871, 1522246871, 2, 1, 2, 12);
INSERT INTO `vm_roles_auths_realation` VALUES (181, 1522246871, 1522246871, 2, 1, 2, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (182, 1522246871, 1522246871, 2, 1, 2, 13);
INSERT INTO `vm_roles_auths_realation` VALUES (183, 1522246871, 1522246871, 2, 1, 2, 15);
INSERT INTO `vm_roles_auths_realation` VALUES (184, 1522246871, 1522246871, 2, 1, 2, 16);
INSERT INTO `vm_roles_auths_realation` VALUES (185, 1522246871, 1522246871, 2, 1, 2, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (186, 1522246871, 1522246871, 2, 1, 2, 18);
INSERT INTO `vm_roles_auths_realation` VALUES (187, 1522246871, 1522246871, 2, 1, 2, 19);
INSERT INTO `vm_roles_auths_realation` VALUES (188, 1522246871, 1522246871, 2, 1, 2, 20);
INSERT INTO `vm_roles_auths_realation` VALUES (189, 1522246871, 1522246871, 2, 1, 2, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (190, 1522246871, 1522246871, 2, 1, 2, 24);
INSERT INTO `vm_roles_auths_realation` VALUES (191, 1522246871, 1522246871, 2, 1, 2, 23);
INSERT INTO `vm_roles_auths_realation` VALUES (192, 1522246871, 1522246871, 2, 1, 2, 22);
INSERT INTO `vm_roles_auths_realation` VALUES (193, 1522246871, 1522246871, 2, 1, 2, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (194, 1522246871, 1522246871, 2, 1, 2, 26);
INSERT INTO `vm_roles_auths_realation` VALUES (195, 1522246871, 1522246871, 2, 1, 2, 34);
INSERT INTO `vm_roles_auths_realation` VALUES (196, 1522246871, 1522246871, 2, 1, 2, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (197, 1522246871, 1522246871, 2, 1, 2, 32);
INSERT INTO `vm_roles_auths_realation` VALUES (198, 1522246871, 1522246871, 2, 1, 2, 30);
INSERT INTO `vm_roles_auths_realation` VALUES (199, 1522246871, 1522246871, 2, 1, 2, 31);
INSERT INTO `vm_roles_auths_realation` VALUES (200, 1522246871, 1522246871, 2, 1, 2, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (201, 1522246871, 1522246871, 2, 1, 2, 28);
INSERT INTO `vm_roles_auths_realation` VALUES (202, 1522246871, 1522246871, 2, 1, 2, 27);
INSERT INTO `vm_roles_auths_realation` VALUES (203, 1522287910, 1522287910, 1, 1, 2, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (204, 1522287910, 1522287910, 1, 1, 2, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (205, 1522287910, 1522287910, 1, 1, 2, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (206, 1522287910, 1522287910, 1, 1, 2, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (207, 1522287910, 1522287910, 1, 1, 2, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (208, 1522287910, 1522287910, 1, 1, 2, 6);
INSERT INTO `vm_roles_auths_realation` VALUES (209, 1522287910, 1522287910, 1, 1, 2, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (210, 1522287910, 1522287910, 1, 1, 2, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (211, 1522287910, 1522287910, 1, 1, 2, 8);
INSERT INTO `vm_roles_auths_realation` VALUES (212, 1522287910, 1522287910, 1, 1, 2, 10);
INSERT INTO `vm_roles_auths_realation` VALUES (213, 1522287910, 1522287910, 1, 1, 2, 11);
INSERT INTO `vm_roles_auths_realation` VALUES (214, 1522287910, 1522287910, 1, 1, 2, 12);
INSERT INTO `vm_roles_auths_realation` VALUES (215, 1522287910, 1522287910, 1, 1, 2, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (216, 1522287910, 1522287910, 1, 1, 2, 13);
INSERT INTO `vm_roles_auths_realation` VALUES (217, 1522287910, 1522287910, 1, 1, 2, 15);
INSERT INTO `vm_roles_auths_realation` VALUES (218, 1522287910, 1522287910, 1, 1, 2, 16);
INSERT INTO `vm_roles_auths_realation` VALUES (219, 1522287910, 1522287910, 1, 1, 2, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (220, 1522287910, 1522287910, 1, 1, 2, 18);
INSERT INTO `vm_roles_auths_realation` VALUES (221, 1522287910, 1522287910, 1, 1, 2, 19);
INSERT INTO `vm_roles_auths_realation` VALUES (222, 1522287910, 1522287910, 1, 1, 2, 20);
INSERT INTO `vm_roles_auths_realation` VALUES (223, 1522287910, 1522287910, 1, 1, 2, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (224, 1522287910, 1522287910, 1, 1, 2, 24);
INSERT INTO `vm_roles_auths_realation` VALUES (225, 1522287910, 1522287910, 1, 1, 2, 23);
INSERT INTO `vm_roles_auths_realation` VALUES (226, 1522287910, 1522287910, 1, 1, 2, 22);
INSERT INTO `vm_roles_auths_realation` VALUES (227, 1522287910, 1522287910, 1, 1, 2, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (228, 1522287910, 1522287910, 1, 1, 2, 26);
INSERT INTO `vm_roles_auths_realation` VALUES (229, 1522287910, 1522287910, 1, 1, 2, 34);
INSERT INTO `vm_roles_auths_realation` VALUES (230, 1522287910, 1522287910, 1, 1, 2, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (231, 1522287910, 1522287910, 1, 1, 2, 32);
INSERT INTO `vm_roles_auths_realation` VALUES (232, 1522287910, 1522287910, 1, 1, 2, 30);
INSERT INTO `vm_roles_auths_realation` VALUES (233, 1522287910, 1522287910, 1, 1, 2, 31);
INSERT INTO `vm_roles_auths_realation` VALUES (234, 1522287910, 1522287910, 1, 1, 2, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (235, 1522287910, 1522287910, 1, 1, 2, 28);
INSERT INTO `vm_roles_auths_realation` VALUES (236, 1522287910, 1522287910, 1, 1, 2, 27);
INSERT INTO `vm_roles_auths_realation` VALUES (237, 1522288491, 1522288491, 2, 1, 1, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (238, 1522288491, 1522288491, 2, 1, 1, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (239, 1522288491, 1522288491, 2, 1, 1, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (240, 1522288491, 1522288491, 2, 1, 1, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (241, 1522288491, 1522288491, 2, 1, 1, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (242, 1522288491, 1522288491, 2, 1, 1, 6);
INSERT INTO `vm_roles_auths_realation` VALUES (243, 1522288491, 1522288491, 2, 1, 1, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (244, 1522288491, 1522288491, 2, 1, 1, 8);
INSERT INTO `vm_roles_auths_realation` VALUES (245, 1522288491, 1522288491, 2, 1, 1, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (246, 1522288491, 1522288491, 2, 1, 1, 10);
INSERT INTO `vm_roles_auths_realation` VALUES (247, 1522288491, 1522288491, 2, 1, 1, 11);
INSERT INTO `vm_roles_auths_realation` VALUES (248, 1522288491, 1522288491, 2, 1, 1, 12);
INSERT INTO `vm_roles_auths_realation` VALUES (249, 1522288491, 1522288491, 2, 1, 1, 13);
INSERT INTO `vm_roles_auths_realation` VALUES (250, 1522288491, 1522288491, 2, 1, 1, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (251, 1522288491, 1522288491, 2, 1, 1, 16);
INSERT INTO `vm_roles_auths_realation` VALUES (252, 1522288491, 1522288491, 2, 1, 1, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (253, 1522288491, 1522288491, 2, 1, 1, 15);
INSERT INTO `vm_roles_auths_realation` VALUES (254, 1522288491, 1522288491, 2, 1, 1, 18);
INSERT INTO `vm_roles_auths_realation` VALUES (255, 1522288491, 1522288491, 2, 1, 1, 19);
INSERT INTO `vm_roles_auths_realation` VALUES (256, 1522288491, 1522288491, 2, 1, 1, 20);
INSERT INTO `vm_roles_auths_realation` VALUES (257, 1522288491, 1522288491, 2, 1, 1, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (258, 1522288491, 1522288491, 2, 1, 1, 22);
INSERT INTO `vm_roles_auths_realation` VALUES (259, 1522288491, 1522288491, 2, 1, 1, 23);
INSERT INTO `vm_roles_auths_realation` VALUES (260, 1522288491, 1522288491, 2, 1, 1, 24);
INSERT INTO `vm_roles_auths_realation` VALUES (261, 1522288491, 1522288491, 2, 1, 1, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (262, 1522288491, 1522288491, 2, 1, 1, 26);
INSERT INTO `vm_roles_auths_realation` VALUES (263, 1522288491, 1522288491, 2, 1, 1, 27);
INSERT INTO `vm_roles_auths_realation` VALUES (264, 1522288491, 1522288491, 2, 1, 1, 28);
INSERT INTO `vm_roles_auths_realation` VALUES (265, 1522288491, 1522288491, 2, 1, 1, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (266, 1522288491, 1522288491, 2, 1, 1, 30);
INSERT INTO `vm_roles_auths_realation` VALUES (267, 1522288491, 1522288491, 2, 1, 1, 31);
INSERT INTO `vm_roles_auths_realation` VALUES (268, 1522288491, 1522288491, 2, 1, 1, 32);
INSERT INTO `vm_roles_auths_realation` VALUES (269, 1522288491, 1522288491, 2, 1, 1, 34);
INSERT INTO `vm_roles_auths_realation` VALUES (270, 1522288491, 1522288491, 2, 1, 1, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (271, 1522293483, 1522293483, 2, 1, 1, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (272, 1522293483, 1522293483, 2, 1, 1, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (273, 1522293483, 1522293483, 2, 1, 1, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (274, 1522293483, 1522293483, 2, 1, 1, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (275, 1522293483, 1522293483, 2, 1, 1, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (276, 1522293483, 1522293483, 2, 1, 1, 6);
INSERT INTO `vm_roles_auths_realation` VALUES (277, 1522293483, 1522293483, 2, 1, 1, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (278, 1522293483, 1522293483, 2, 1, 1, 8);
INSERT INTO `vm_roles_auths_realation` VALUES (279, 1522293483, 1522293483, 2, 1, 1, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (280, 1522293483, 1522293483, 2, 1, 1, 10);
INSERT INTO `vm_roles_auths_realation` VALUES (281, 1522293483, 1522293483, 2, 1, 1, 11);
INSERT INTO `vm_roles_auths_realation` VALUES (282, 1522293483, 1522293483, 2, 1, 1, 12);
INSERT INTO `vm_roles_auths_realation` VALUES (283, 1522293483, 1522293483, 2, 1, 1, 13);
INSERT INTO `vm_roles_auths_realation` VALUES (284, 1522293483, 1522293483, 2, 1, 1, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (285, 1522293483, 1522293483, 2, 1, 1, 16);
INSERT INTO `vm_roles_auths_realation` VALUES (286, 1522293483, 1522293483, 2, 1, 1, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (287, 1522293483, 1522293483, 2, 1, 1, 15);
INSERT INTO `vm_roles_auths_realation` VALUES (288, 1522293483, 1522293483, 2, 1, 1, 18);
INSERT INTO `vm_roles_auths_realation` VALUES (289, 1522293483, 1522293483, 2, 1, 1, 19);
INSERT INTO `vm_roles_auths_realation` VALUES (290, 1522293483, 1522293483, 2, 1, 1, 20);
INSERT INTO `vm_roles_auths_realation` VALUES (291, 1522293483, 1522293483, 2, 1, 1, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (292, 1522293483, 1522293483, 2, 1, 1, 22);
INSERT INTO `vm_roles_auths_realation` VALUES (293, 1522293483, 1522293483, 2, 1, 1, 23);
INSERT INTO `vm_roles_auths_realation` VALUES (294, 1522293483, 1522293483, 2, 1, 1, 24);
INSERT INTO `vm_roles_auths_realation` VALUES (295, 1522293483, 1522293483, 2, 1, 1, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (296, 1522293483, 1522293483, 2, 1, 1, 26);
INSERT INTO `vm_roles_auths_realation` VALUES (297, 1522293483, 1522293483, 2, 1, 1, 27);
INSERT INTO `vm_roles_auths_realation` VALUES (298, 1522293483, 1522293483, 2, 1, 1, 28);
INSERT INTO `vm_roles_auths_realation` VALUES (299, 1522293483, 1522293483, 2, 1, 1, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (300, 1522293483, 1522293483, 2, 1, 1, 30);
INSERT INTO `vm_roles_auths_realation` VALUES (301, 1522293483, 1522293483, 2, 1, 1, 31);
INSERT INTO `vm_roles_auths_realation` VALUES (302, 1522293483, 1522293483, 2, 1, 1, 32);
INSERT INTO `vm_roles_auths_realation` VALUES (303, 1522293483, 1522293483, 2, 1, 1, 34);
INSERT INTO `vm_roles_auths_realation` VALUES (304, 1522293483, 1522293483, 2, 1, 1, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (305, 1522293567, 1522293567, 2, 1, 3, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (306, 1522293567, 1522293567, 2, 1, 3, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (307, 1522293567, 1522293567, 2, 1, 3, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (308, 1522293567, 1522293567, 2, 1, 3, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (309, 1522293567, 1522293567, 2, 1, 3, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (310, 1522293567, 1522293567, 2, 1, 3, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (311, 1522293567, 1522293567, 2, 1, 3, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (312, 1522293567, 1522293567, 2, 1, 3, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (313, 1522293567, 1522293567, 2, 1, 3, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (314, 1522293602, 1522293602, 2, 1, 3, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (315, 1522293602, 1522293602, 2, 1, 3, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (316, 1522293602, 1522293602, 2, 1, 3, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (317, 1522293602, 1522293602, 2, 1, 3, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (318, 1522293602, 1522293602, 2, 1, 3, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (319, 1522293602, 1522293602, 2, 1, 3, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (320, 1522293602, 1522293602, 2, 1, 3, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (321, 1522293602, 1522293602, 2, 1, 3, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (322, 1522293602, 1522293602, 2, 1, 3, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (323, 1522293754, 1522293754, 2, 1, 3, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (324, 1522293754, 1522293754, 2, 1, 3, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (325, 1522293754, 1522293754, 2, 1, 3, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (326, 1522293754, 1522293754, 2, 1, 3, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (327, 1522293754, 1522293754, 2, 1, 3, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (328, 1522293754, 1522293754, 2, 1, 3, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (329, 1522293754, 1522293754, 2, 1, 3, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (330, 1522293754, 1522293754, 2, 1, 3, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (331, 1522293754, 1522293754, 2, 1, 3, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (332, 1522294245, 1522294245, 2, 1, 3, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (333, 1522294245, 1522294245, 2, 1, 3, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (334, 1522294245, 1522294245, 2, 1, 3, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (335, 1522294245, 1522294245, 2, 1, 3, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (336, 1522294245, 1522294245, 2, 1, 3, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (337, 1522294245, 1522294245, 2, 1, 3, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (338, 1522294245, 1522294245, 2, 1, 3, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (339, 1522294245, 1522294245, 2, 1, 3, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (340, 1522298398, 1522298398, 2, 1, 3, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (341, 1522298398, 1522298398, 2, 1, 3, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (342, 1522298398, 1522298398, 2, 1, 3, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (343, 1522298398, 1522298398, 2, 1, 3, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (344, 1522298398, 1522298398, 2, 1, 3, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (345, 1522298398, 1522298398, 2, 1, 3, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (346, 1522298398, 1522298398, 2, 1, 3, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (347, 1522298398, 1522298398, 2, 1, 3, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (348, 1522298431, 1522298431, 2, 1, 3, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (349, 1522298431, 1522298431, 2, 1, 3, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (350, 1522298431, 1522298431, 2, 1, 3, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (351, 1522298431, 1522298431, 2, 1, 3, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (352, 1522298431, 1522298431, 2, 1, 3, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (353, 1522298431, 1522298431, 2, 1, 3, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (354, 1522298431, 1522298431, 2, 1, 3, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (355, 1522298431, 1522298431, 2, 1, 3, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (356, 1522302748, 1522302748, 2, 1, 3, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (357, 1522302748, 1522302748, 2, 1, 3, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (358, 1522302748, 1522302748, 2, 1, 3, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (359, 1522302748, 1522302748, 2, 1, 3, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (360, 1522302748, 1522302748, 2, 1, 3, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (361, 1522302748, 1522302748, 2, 1, 3, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (362, 1522302748, 1522302748, 2, 1, 3, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (363, 1522302781, 1522302781, 2, 1, 3, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (364, 1522302781, 1522302781, 2, 1, 3, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (365, 1522302781, 1522302781, 2, 1, 3, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (366, 1522302781, 1522302781, 2, 1, 3, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (367, 1522302781, 1522302781, 2, 1, 3, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (368, 1522302781, 1522302781, 2, 1, 3, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (369, 1522302781, 1522302781, 2, 1, 3, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (370, 1522302781, 1522302781, 2, 1, 3, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (371, 1522302795, 1522302795, 1, 1, 3, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (372, 1522302795, 1522302795, 1, 1, 3, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (373, 1522302795, 1522302795, 1, 1, 3, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (374, 1522302795, 1522302795, 1, 1, 3, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (375, 1522302795, 1522302795, 1, 1, 3, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (376, 1522302795, 1522302795, 1, 1, 3, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (377, 1522302795, 1522302795, 1, 1, 3, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (378, 1522312930, 1522312930, 2, 1, 1, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (379, 1522312930, 1522312930, 2, 1, 1, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (380, 1522312930, 1522312930, 2, 1, 1, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (381, 1522312930, 1522312930, 2, 1, 1, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (382, 1522312930, 1522312930, 2, 1, 1, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (383, 1522312930, 1522312930, 2, 1, 1, 6);
INSERT INTO `vm_roles_auths_realation` VALUES (384, 1522312930, 1522312930, 2, 1, 1, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (385, 1522312930, 1522312930, 2, 1, 1, 8);
INSERT INTO `vm_roles_auths_realation` VALUES (386, 1522312930, 1522312930, 2, 1, 1, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (387, 1522312930, 1522312930, 2, 1, 1, 10);
INSERT INTO `vm_roles_auths_realation` VALUES (388, 1522312930, 1522312930, 2, 1, 1, 11);
INSERT INTO `vm_roles_auths_realation` VALUES (389, 1522312930, 1522312930, 2, 1, 1, 12);
INSERT INTO `vm_roles_auths_realation` VALUES (390, 1522312930, 1522312930, 2, 1, 1, 13);
INSERT INTO `vm_roles_auths_realation` VALUES (391, 1522312930, 1522312930, 2, 1, 1, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (392, 1522312930, 1522312930, 2, 1, 1, 16);
INSERT INTO `vm_roles_auths_realation` VALUES (393, 1522312930, 1522312930, 2, 1, 1, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (394, 1522312930, 1522312930, 2, 1, 1, 15);
INSERT INTO `vm_roles_auths_realation` VALUES (395, 1522312930, 1522312930, 2, 1, 1, 18);
INSERT INTO `vm_roles_auths_realation` VALUES (396, 1522312930, 1522312930, 2, 1, 1, 19);
INSERT INTO `vm_roles_auths_realation` VALUES (397, 1522312930, 1522312930, 2, 1, 1, 20);
INSERT INTO `vm_roles_auths_realation` VALUES (398, 1522312930, 1522312930, 2, 1, 1, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (399, 1522312930, 1522312930, 2, 1, 1, 22);
INSERT INTO `vm_roles_auths_realation` VALUES (400, 1522312930, 1522312930, 2, 1, 1, 23);
INSERT INTO `vm_roles_auths_realation` VALUES (401, 1522312930, 1522312930, 2, 1, 1, 24);
INSERT INTO `vm_roles_auths_realation` VALUES (402, 1522312930, 1522312930, 2, 1, 1, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (403, 1522312930, 1522312930, 2, 1, 1, 26);
INSERT INTO `vm_roles_auths_realation` VALUES (404, 1522312930, 1522312930, 2, 1, 1, 27);
INSERT INTO `vm_roles_auths_realation` VALUES (405, 1522312930, 1522312930, 2, 1, 1, 28);
INSERT INTO `vm_roles_auths_realation` VALUES (406, 1522312930, 1522312930, 2, 1, 1, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (407, 1522312930, 1522312930, 2, 1, 1, 30);
INSERT INTO `vm_roles_auths_realation` VALUES (408, 1522312930, 1522312930, 2, 1, 1, 31);
INSERT INTO `vm_roles_auths_realation` VALUES (409, 1522312930, 1522312930, 2, 1, 1, 32);
INSERT INTO `vm_roles_auths_realation` VALUES (410, 1522312930, 1522312930, 2, 1, 1, 34);
INSERT INTO `vm_roles_auths_realation` VALUES (411, 1522312930, 1522312930, 2, 1, 1, 33);
INSERT INTO `vm_roles_auths_realation` VALUES (412, 1522312940, 1522312940, 1, 1, 1, 1);
INSERT INTO `vm_roles_auths_realation` VALUES (413, 1522312940, 1522312940, 1, 1, 1, 2);
INSERT INTO `vm_roles_auths_realation` VALUES (414, 1522312940, 1522312940, 1, 1, 1, 3);
INSERT INTO `vm_roles_auths_realation` VALUES (415, 1522312940, 1522312940, 1, 1, 1, 4);
INSERT INTO `vm_roles_auths_realation` VALUES (416, 1522312940, 1522312940, 1, 1, 1, 5);
INSERT INTO `vm_roles_auths_realation` VALUES (417, 1522312940, 1522312940, 1, 1, 1, 6);
INSERT INTO `vm_roles_auths_realation` VALUES (418, 1522312940, 1522312940, 1, 1, 1, 7);
INSERT INTO `vm_roles_auths_realation` VALUES (419, 1522312940, 1522312940, 1, 1, 1, 8);
INSERT INTO `vm_roles_auths_realation` VALUES (420, 1522312940, 1522312940, 1, 1, 1, 9);
INSERT INTO `vm_roles_auths_realation` VALUES (421, 1522312940, 1522312940, 1, 1, 1, 10);
INSERT INTO `vm_roles_auths_realation` VALUES (422, 1522312940, 1522312940, 1, 1, 1, 11);
INSERT INTO `vm_roles_auths_realation` VALUES (423, 1522312940, 1522312940, 1, 1, 1, 12);
INSERT INTO `vm_roles_auths_realation` VALUES (424, 1522312940, 1522312940, 1, 1, 1, 13);
INSERT INTO `vm_roles_auths_realation` VALUES (425, 1522312940, 1522312940, 1, 1, 1, 14);
INSERT INTO `vm_roles_auths_realation` VALUES (426, 1522312940, 1522312940, 1, 1, 1, 16);
INSERT INTO `vm_roles_auths_realation` VALUES (427, 1522312940, 1522312940, 1, 1, 1, 17);
INSERT INTO `vm_roles_auths_realation` VALUES (428, 1522312940, 1522312940, 1, 1, 1, 15);
INSERT INTO `vm_roles_auths_realation` VALUES (429, 1522312940, 1522312940, 1, 1, 1, 18);
INSERT INTO `vm_roles_auths_realation` VALUES (430, 1522312940, 1522312940, 1, 1, 1, 19);
INSERT INTO `vm_roles_auths_realation` VALUES (431, 1522312940, 1522312940, 1, 1, 1, 20);
INSERT INTO `vm_roles_auths_realation` VALUES (432, 1522312940, 1522312940, 1, 1, 1, 21);
INSERT INTO `vm_roles_auths_realation` VALUES (433, 1522312940, 1522312940, 1, 1, 1, 22);
INSERT INTO `vm_roles_auths_realation` VALUES (434, 1522312940, 1522312940, 1, 1, 1, 23);
INSERT INTO `vm_roles_auths_realation` VALUES (435, 1522312940, 1522312940, 1, 1, 1, 24);
INSERT INTO `vm_roles_auths_realation` VALUES (436, 1522312940, 1522312940, 1, 1, 1, 25);
INSERT INTO `vm_roles_auths_realation` VALUES (437, 1522312940, 1522312940, 1, 1, 1, 26);
INSERT INTO `vm_roles_auths_realation` VALUES (438, 1522312940, 1522312940, 1, 1, 1, 27);
INSERT INTO `vm_roles_auths_realation` VALUES (439, 1522312940, 1522312940, 1, 1, 1, 28);
INSERT INTO `vm_roles_auths_realation` VALUES (440, 1522312940, 1522312940, 1, 1, 1, 29);
INSERT INTO `vm_roles_auths_realation` VALUES (441, 1522312940, 1522312940, 1, 1, 1, 30);
INSERT INTO `vm_roles_auths_realation` VALUES (442, 1522312940, 1522312940, 1, 1, 1, 31);
INSERT INTO `vm_roles_auths_realation` VALUES (443, 1522312940, 1522312940, 1, 1, 1, 32);
INSERT INTO `vm_roles_auths_realation` VALUES (444, 1522312940, 1522312940, 1, 1, 1, 34);
INSERT INTO `vm_roles_auths_realation` VALUES (445, 1522312940, 1522312940, 1, 1, 1, 33);

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
) ENGINE = InnoDB AUTO_INCREMENT = 272 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_roles_menus_realation
-- ----------------------------
INSERT INTO `vm_roles_menus_realation` VALUES (5, 1522050494, 1522050494, 2, 1, 1, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (6, 1522050494, 1522050494, 2, 1, 1, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (7, 1522050494, 1522050494, 2, 1, 1, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (8, 1522050494, 1522050494, 2, 1, 1, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (9, 1522050494, 1522050494, 2, 1, 1, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (10, 1522050494, 1522050494, 2, 1, 1, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (12, 1522050494, 1522050494, 2, 1, 1, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (13, 1522050494, 1522050494, 2, 1, 1, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (14, 1522050494, 1522050494, 2, 1, 1, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (15, 1522050494, 1522050494, 2, 1, 1, 15);
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
INSERT INTO `vm_roles_menus_realation` VALUES (80, 1522050494, 1522050494, 2, 1, 3, 4);
INSERT INTO `vm_roles_menus_realation` VALUES (81, 1522050494, 1522050494, 2, 1, 3, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (82, 1522050494, 1522050494, 2, 1, 3, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (83, 1522050494, 1522050494, 2, 1, 3, 3);
INSERT INTO `vm_roles_menus_realation` VALUES (84, 1522050494, 1522050494, 2, 1, 3, 5);
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
INSERT INTO `vm_roles_menus_realation` VALUES (97, 1522244243, 1522244243, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (98, 1522244243, 1522244243, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (99, 1522244243, 1522244243, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (100, 1522244243, 1522244243, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (101, 1522244360, 1522244360, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (102, 1522244360, 1522244360, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (103, 1522244360, 1522244360, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (104, 1522244360, 1522244360, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (105, 1522245096, 1522245096, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (106, 1522245096, 1522245096, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (107, 1522245096, 1522245096, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (108, 1522245096, 1522245096, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (109, 1522246428, 1522246428, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (110, 1522246428, 1522246428, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (111, 1522246428, 1522246428, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (112, 1522246428, 1522246428, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (113, 1522246470, 1522246470, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (114, 1522246470, 1522246470, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (115, 1522246470, 1522246470, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (116, 1522246470, 1522246470, 2, 1, 2, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (117, 1522246470, 1522246470, 2, 1, 2, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (118, 1522246470, 1522246470, 2, 1, 2, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (119, 1522246470, 1522246470, 2, 1, 2, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (120, 1522246470, 1522246470, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (121, 1522246470, 1522246470, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (122, 1522246470, 1522246470, 2, 1, 2, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (123, 1522246470, 1522246470, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (124, 1522246848, 1522246848, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (125, 1522246848, 1522246848, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (126, 1522246848, 1522246848, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (127, 1522246848, 1522246848, 2, 1, 2, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (128, 1522246848, 1522246848, 2, 1, 2, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (129, 1522246848, 1522246848, 2, 1, 2, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (130, 1522246848, 1522246848, 2, 1, 2, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (131, 1522246848, 1522246848, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (132, 1522246848, 1522246848, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (133, 1522246848, 1522246848, 2, 1, 2, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (134, 1522246848, 1522246848, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (135, 1522246871, 1522246871, 2, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (136, 1522246871, 1522246871, 2, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (137, 1522246871, 1522246871, 2, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (138, 1522246871, 1522246871, 2, 1, 2, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (139, 1522246871, 1522246871, 2, 1, 2, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (140, 1522246871, 1522246871, 2, 1, 2, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (141, 1522246871, 1522246871, 2, 1, 2, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (142, 1522246871, 1522246871, 2, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (143, 1522246871, 1522246871, 2, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (144, 1522246871, 1522246871, 2, 1, 2, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (145, 1522246871, 1522246871, 2, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (146, 1522287911, 1522287911, 1, 1, 2, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (147, 1522287911, 1522287911, 1, 1, 2, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (148, 1522287911, 1522287911, 1, 1, 2, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (149, 1522287911, 1522287911, 1, 1, 2, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (150, 1522287911, 1522287911, 1, 1, 2, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (151, 1522287911, 1522287911, 1, 1, 2, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (152, 1522287911, 1522287911, 1, 1, 2, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (153, 1522287911, 1522287911, 1, 1, 2, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (154, 1522287911, 1522287911, 1, 1, 2, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (155, 1522287911, 1522287911, 1, 1, 2, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (156, 1522287911, 1522287911, 1, 1, 2, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (157, 1522288491, 1522288491, 2, 1, 1, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (158, 1522288491, 1522288491, 2, 1, 1, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (159, 1522288491, 1522288491, 2, 1, 1, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (160, 1522288491, 1522288491, 2, 1, 1, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (161, 1522288491, 1522288491, 2, 1, 1, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (162, 1522288491, 1522288491, 2, 1, 1, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (163, 1522288491, 1522288491, 2, 1, 1, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (164, 1522288491, 1522288491, 2, 1, 1, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (165, 1522288491, 1522288491, 2, 1, 1, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (166, 1522288491, 1522288491, 2, 1, 1, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (167, 1522293483, 1522293483, 2, 1, 1, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (168, 1522293483, 1522293483, 2, 1, 1, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (169, 1522293483, 1522293483, 2, 1, 1, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (170, 1522293483, 1522293483, 2, 1, 1, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (171, 1522293483, 1522293483, 2, 1, 1, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (172, 1522293483, 1522293483, 2, 1, 1, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (173, 1522293483, 1522293483, 2, 1, 1, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (174, 1522293483, 1522293483, 2, 1, 1, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (175, 1522293483, 1522293483, 2, 1, 1, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (176, 1522293483, 1522293483, 2, 1, 1, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (177, 1522293602, 1522293602, 2, 1, 3, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (178, 1522293602, 1522293602, 2, 1, 3, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (179, 1522293602, 1522293602, 2, 1, 3, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (180, 1522293602, 1522293602, 2, 1, 3, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (181, 1522293602, 1522293602, 2, 1, 3, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (182, 1522293602, 1522293602, 2, 1, 3, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (183, 1522293602, 1522293602, 2, 1, 3, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (184, 1522293602, 1522293602, 2, 1, 3, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (185, 1522293602, 1522293602, 2, 1, 3, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (186, 1522293754, 1522293754, 2, 1, 3, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (187, 1522293754, 1522293754, 2, 1, 3, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (188, 1522293754, 1522293754, 2, 1, 3, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (189, 1522293754, 1522293754, 2, 1, 3, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (190, 1522293754, 1522293754, 2, 1, 3, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (191, 1522293754, 1522293754, 2, 1, 3, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (192, 1522293754, 1522293754, 2, 1, 3, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (193, 1522293754, 1522293754, 2, 1, 3, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (194, 1522293754, 1522293754, 2, 1, 3, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (195, 1522293754, 1522293754, 2, 1, 3, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (196, 1522293754, 1522293754, 2, 1, 3, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (197, 1522294245, 1522294245, 2, 1, 3, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (198, 1522294245, 1522294245, 2, 1, 3, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (199, 1522294245, 1522294245, 2, 1, 3, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (200, 1522294245, 1522294245, 2, 1, 3, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (201, 1522294245, 1522294245, 2, 1, 3, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (202, 1522294245, 1522294245, 2, 1, 3, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (203, 1522294245, 1522294245, 2, 1, 3, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (204, 1522294245, 1522294245, 2, 1, 3, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (205, 1522294245, 1522294245, 2, 1, 3, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (206, 1522294245, 1522294245, 2, 1, 3, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (207, 1522294245, 1522294245, 2, 1, 3, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (208, 1522298431, 1522298431, 2, 1, 3, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (209, 1522298431, 1522298431, 2, 1, 3, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (210, 1522298431, 1522298431, 2, 1, 3, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (211, 1522298431, 1522298431, 2, 1, 3, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (212, 1522298431, 1522298431, 2, 1, 3, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (213, 1522298431, 1522298431, 2, 1, 3, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (214, 1522298431, 1522298431, 2, 1, 3, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (215, 1522298431, 1522298431, 2, 1, 3, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (216, 1522298431, 1522298431, 2, 1, 3, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (217, 1522298431, 1522298431, 2, 1, 3, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (218, 1522298431, 1522298431, 2, 1, 3, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (219, 1522302748, 1522302748, 2, 1, 3, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (220, 1522302748, 1522302748, 2, 1, 3, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (221, 1522302748, 1522302748, 2, 1, 3, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (222, 1522302748, 1522302748, 2, 1, 3, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (223, 1522302748, 1522302748, 2, 1, 3, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (224, 1522302748, 1522302748, 2, 1, 3, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (225, 1522302748, 1522302748, 2, 1, 3, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (226, 1522302748, 1522302748, 2, 1, 3, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (227, 1522302748, 1522302748, 2, 1, 3, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (228, 1522302748, 1522302748, 2, 1, 3, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (229, 1522302748, 1522302748, 2, 1, 3, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (230, 1522302782, 1522302782, 2, 1, 3, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (231, 1522302782, 1522302782, 2, 1, 3, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (232, 1522302782, 1522302782, 2, 1, 3, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (233, 1522302782, 1522302782, 2, 1, 3, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (234, 1522302782, 1522302782, 2, 1, 3, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (235, 1522302782, 1522302782, 2, 1, 3, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (236, 1522302782, 1522302782, 2, 1, 3, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (237, 1522302782, 1522302782, 2, 1, 3, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (238, 1522302782, 1522302782, 2, 1, 3, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (239, 1522302782, 1522302782, 2, 1, 3, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (240, 1522302782, 1522302782, 2, 1, 3, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (241, 1522302795, 1522302795, 1, 1, 3, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (242, 1522302795, 1522302795, 1, 1, 3, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (243, 1522302795, 1522302795, 1, 1, 3, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (244, 1522302795, 1522302795, 1, 1, 3, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (245, 1522302795, 1522302795, 1, 1, 3, 11);
INSERT INTO `vm_roles_menus_realation` VALUES (246, 1522302795, 1522302795, 1, 1, 3, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (247, 1522302795, 1522302795, 1, 1, 3, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (248, 1522302795, 1522302795, 1, 1, 3, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (249, 1522302795, 1522302795, 1, 1, 3, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (250, 1522302795, 1522302795, 1, 1, 3, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (251, 1522302795, 1522302795, 1, 1, 3, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (252, 1522312930, 1522312930, 2, 1, 1, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (253, 1522312930, 1522312930, 2, 1, 1, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (254, 1522312930, 1522312930, 2, 1, 1, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (255, 1522312930, 1522312930, 2, 1, 1, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (256, 1522312930, 1522312930, 2, 1, 1, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (257, 1522312930, 1522312930, 2, 1, 1, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (258, 1522312930, 1522312930, 2, 1, 1, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (259, 1522312930, 1522312930, 2, 1, 1, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (260, 1522312930, 1522312930, 2, 1, 1, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (261, 1522312930, 1522312930, 2, 1, 1, 12);
INSERT INTO `vm_roles_menus_realation` VALUES (262, 1522312940, 1522312940, 1, 1, 1, 6);
INSERT INTO `vm_roles_menus_realation` VALUES (263, 1522312940, 1522312940, 1, 1, 1, 7);
INSERT INTO `vm_roles_menus_realation` VALUES (264, 1522312940, 1522312940, 1, 1, 1, 9);
INSERT INTO `vm_roles_menus_realation` VALUES (265, 1522312940, 1522312940, 1, 1, 1, 10);
INSERT INTO `vm_roles_menus_realation` VALUES (266, 1522312940, 1522312940, 1, 1, 1, 13);
INSERT INTO `vm_roles_menus_realation` VALUES (267, 1522312940, 1522312940, 1, 1, 1, 14);
INSERT INTO `vm_roles_menus_realation` VALUES (268, 1522312940, 1522312940, 1, 1, 1, 15);
INSERT INTO `vm_roles_menus_realation` VALUES (269, 1522312940, 1522312940, 1, 1, 1, 5);
INSERT INTO `vm_roles_menus_realation` VALUES (270, 1522312940, 1522312940, 1, 1, 1, 8);
INSERT INTO `vm_roles_menus_realation` VALUES (271, 1522312940, 1522312940, 1, 1, 1, 12);

SET FOREIGN_KEY_CHECKS = 1;
