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

 Date: 14/03/2018 17:23:27
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
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '前端用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_users
-- ----------------------------
INSERT INTO `vm_users` VALUES (1, '张大可aaa', '123456789', 2, 1521538534, '14141阿达撒旦aaaaaaaaaaaa', 1500443357, 1520563814, '/src/img?fileId=620', 1, 2);
INSERT INTO `vm_users` VALUES (2, '1231', '1231', 2, 1606898, '11111111111111111', 1515060503, 1520570591, '/src/img?fileId=619', 1, 2);
INSERT INTO `vm_users` VALUES (3, 'root1', '123', 3, 1520498, '6666', 1515060691, 1520558667, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (4, 'root1', '123', 3, 1520498, '6666', 1515060691, 1520501520, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (5, 'root1', '123', 3, 1515060691, '6666', 1515060691, 1515060691, '/src/img?fileId=-1', 1, 1);
INSERT INTO `vm_users` VALUES (6, 'root1', '123', 3, 1515060691, '6666', 1515060691, 1515060691, '/src/img?fileId=618', 1, 1);
INSERT INTO `vm_users` VALUES (7, '12313', '1231312313', 2, 1519797086, '12313', 1520488388, 1520488388, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (8, '敖德萨多阿萨', '阿斯达多', 1, 1520315995, '阿斯达多', 1520488800, 1520488800, '/src/img?fileId=-1', 1, 1);
INSERT INTO `vm_users` VALUES (9, '阿萨德阿斯达多啊', '阿斯达大所大大大大大大大阿斯', 2, 1520316030, '阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多', 1520488880, 1520488880, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (10, 'zk', '123', 2, 1521698521, '12313', 1520488927, 1520488927, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (11, 'adsad', 'asdad', 2, 1520316597, 'asda', 1520489401, 1520489401, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (12, 'asdad', 'asdad', 2, 1520317554, 'adsad', 1520490358, 1520490358, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (13, 'asda', 'asda', 3, 1520922505, '123', 1520490509, 1520490509, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (14, '12313123', '12313', 1, 1519713316, '1231', 1520490919, 1520490919, '/src/img?fileId=-1', 1, 1);
INSERT INTO `vm_users` VALUES (15, '123131', '12313', 2, 1519799918, '12313', 1520491124, 1520504180, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (16, '1231311111', '1231312313', 1, 1520318630, '12313', 1520491442, 1520491442, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (17, '12313123aaaaa', '12313', 2, 1520318944, '12313', 1520491755, 1520491755, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (18, '12313123aaaaacc', '12313', 2, 1583390944, '12313', 1520491845, 1520491845, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (19, 'asdad1111', 'asda', 2, 1521616041, 'asda', 1520492849, 1520492849, '/src/img?fileId=-1', 1, 1);
INSERT INTO `vm_users` VALUES (20, '12313111111', '1231312313', 2, 1521011291, '12313', 1520492897, 1520492897, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (21, 'adssa', 'asdad', 1, 1519715485, 'asdad', 1520493089, 1520493089, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (22, '12313131313', '11', 1, 1520417681, '1231', 1520504087, 1520504087, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (23, 'zhangdake', '123', 2, 1520471734, '奥士达大厦', 1520558142, 1520558142, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (24, '奥术大师', '阿萨', 1, 1520990251, '阿斯达多所', 1520558256, 1520558256, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (25, '阿萨德', '123', 2, 1519694373, '123', 1520558377, 1520558377, '/src/img?fileId=-1', 1, 1);
INSERT INTO `vm_users` VALUES (26, '1231311111111111', '1231312313', 2, 1521422456, '1231', 1520558462, 1520558462, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (27, '12313111', '12313', 2, 1520817731, '12312', 1520558535, 1520563824, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (28, 'asdsad', 'adsad', 2, 1520904235, 'asda', 1520558641, 1520558641, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (29, '1231111', '123131', 2, 1520300226, '132123', 1520559433, 1520559433, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (30, 'asdad1111111', '1231', 2, 1520218233, '12313', 1520563839, 1520563839, '/src/img?fileId=-1', 1, 1);
INSERT INTO `vm_users` VALUES (31, '阿萨德阿萨', '奥士达大厦多', 1, 1520224855, '阿打算', 1520570458, 1520570458, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (32, '啊啊啊啊', '啊啊', 2, 1520829798, '啊啊啊啊', 1520570602, 1520570602, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (33, '12321332999', '123', 2, 1520225330, '11777', 1520570934, 1520571359, '/src/img?fileId=-1', 1, 2);
INSERT INTO `vm_users` VALUES (34, '111123', 'a', 2, 1520225775, '12313', 1520571379, 1520571596, '/src/img?fileId=617', 1, 2);
INSERT INTO `vm_users` VALUES (35, '123', '123', 2, 1520830805, '123', 1520571608, 1520571608, '/src/img?fileId=616', 1, 2);
INSERT INTO `vm_users` VALUES (36, '1231313', '12313', 2, 1520744444, '123', 1520571649, 1520571649, '/src/img?fileId=615', 1, 2);
INSERT INTO `vm_users` VALUES (37, '1231111111', '123', 2, 1520330835, '123', 1520590044, 1520590044, '/src/img?fileId=636', 1, 2);
INSERT INTO `vm_users` VALUES (38, 'root', '123', 1, 1520335586, 'aabbb', 1520594800, 1520822366, '/src/img?fileId=630', 1, 1);
INSERT INTO `vm_users` VALUES (39, '张可', '123', 3, 1519622574, '123', 1520832179, 1520841750, '/src/img?fileId=634', 1, 1);
INSERT INTO `vm_users` VALUES (40, 'zhangke', '123', 1, 1520932096, 'js定义两个数组。\n\nvar arrA=[1,2,3];\n\nvar arrB=[4,5,6];\n\n要实现[1,2,3,4,5,6]，如果直接arrA.push(arrB); 则arrB只会作为了arrA的一个元素。执行如图：\n\n20170803182733', 1520845708, 1520845713, '/src/img?fileId=-1', 1, 1);
INSERT INTO `vm_users` VALUES (41, 'zhangke', '123', 1, 1520327324, 'www.epfrontier.com/ind...  - 百度快照\n公司简介 - 美食杰\n美食杰 - 中国最优质的美食,食谱,菜谱网。做你最喜爱的美', 1520845762, 1520845821, '/src/img?fileId=639', 1, 1);
INSERT INTO `vm_users` VALUES (42, 'root', '123', 3, 1520411263, '12313sada', 1520929668, 1520930151, '/src/img?fileId=641', 2, 1);

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
  `result` tinyint(5) UNSIGNED NOT NULL COMMENT '登录结果，1位成功，2为失败',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为yes，2为no',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '前端用户登录记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_users_login_logs
-- ----------------------------
INSERT INTO `vm_users_login_logs` VALUES (1, 38, '171.221.142.90', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520822589, 1, 1520822589, 1520822589, 2, 1);
INSERT INTO `vm_users_login_logs` VALUES (2, 38, '171.221.142.90', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520822696, 1, 1520822696, 1520822696, 2, 1);
INSERT INTO `vm_users_login_logs` VALUES (3, 38, '171.221.142.90', 'Windows 7', '1920*1080', 'firefox 58.0', '中国', '四川', '成都', 1520822748, 1, 1520822748, 1520822748, 2, 1);
INSERT INTO `vm_users_login_logs` VALUES (4, 41, '171.221.142.90', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520845823, 1, 1520845823, 1520845823, 2, 1);
INSERT INTO `vm_users_login_logs` VALUES (5, 42, '171.221.142.90', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520934765, 1, 1520934765, 1520934765, 2, 1);
INSERT INTO `vm_users_login_logs` VALUES (6, 42, '171.221.142.90', 'Windows 7', '1920*1080', 'firefox 58.0', '中国', '四川', '成都', 1520934798, 1, 1520934798, 1520934798, 2, 1);
INSERT INTO `vm_users_login_logs` VALUES (7, 42, '171.213.12.120', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520995577, 1, 1520995577, 1520995577, 2, 1);
INSERT INTO `vm_users_login_logs` VALUES (8, 42, '171.213.12.120', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520995583, 1, 1520995583, 1520995583, 2, 1);
INSERT INTO `vm_users_login_logs` VALUES (9, 42, '171.213.12.120', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520995591, 1, 1520995591, 1520995591, 2, 1);
INSERT INTO `vm_users_login_logs` VALUES (10, 42, '171.213.12.120', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520995598, 1, 1520995598, 1520995598, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
