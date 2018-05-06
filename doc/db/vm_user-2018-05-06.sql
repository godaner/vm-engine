/*
 Navicat Premium Data Transfer

 Source Server         : 39.108.231.231
 Source Server Type    : MySQL
 Source Server Version : 50633
 Source Host           : 39.108.231.231:3306
 Source Schema         : vm_user

 Target Server Type    : MySQL
 Target Server Version : 50633
 File Encoding         : 65001

 Date: 06/05/2018 20:01:17
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
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '前端用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_users
-- ----------------------------
INSERT INTO `vm_users` VALUES (1, '张大可aaa', '123456789', 2, 1521538534, '14141阿达撒旦aaaaaaaaaaaa', 1500443357, 1520563814, '/src/img?fileId=620', 2, 1);
INSERT INTO `vm_users` VALUES (2, '1231', '1231', 2, 1606898, '11111111111111111', 1515060503, 1520570591, '/src/img?fileId=619', 2, 2);
INSERT INTO `vm_users` VALUES (3, 'root1', '123', 3, 1520498, '6666', 1515060691, 1520558667, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (4, 'root1', '123', 3, 1520498, '6666', 1515060691, 1520501520, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (5, 'root1', '123', 3, 1515060691, '6666', 1515060691, 1515060691, '/src/img?fileId=-1', 2, 1);
INSERT INTO `vm_users` VALUES (6, 'root1', '123', 3, 1515060691, '6666', 1515060691, 1515060691, '/src/img?fileId=618', 2, 1);
INSERT INTO `vm_users` VALUES (7, '12313', '1231312313', 2, 1519797086, '12313', 1520488388, 1520488388, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (8, '敖德萨多阿萨', '阿斯达多', 1, 1520315995, '阿斯达多', 1520488800, 1520488800, '/src/img?fileId=-1', 2, 1);
INSERT INTO `vm_users` VALUES (9, '阿萨德阿斯达多啊', '阿斯达大所大大大大大大大阿斯', 2, 1520316030, '阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多阿斯达多', 1520488880, 1520488880, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (10, 'zk', '123', 2, 1521698521, '12313', 1520488927, 1520488927, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (11, 'adsad', 'asdad', 2, 1520316597, 'asda', 1520489401, 1520489401, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (12, 'asdad', 'asdad', 2, 1520317554, 'adsad', 1520490358, 1520490358, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (13, 'asda', 'asda', 3, 1520922505, '123', 1520490509, 1520490509, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (14, '12313123', '12313', 1, 1519713316, '1231', 1520490919, 1520490919, '/src/img?fileId=-1', 2, 1);
INSERT INTO `vm_users` VALUES (15, '123131', '12313', 2, 1519799918, '12313', 1520491124, 1520504180, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (16, '1231311111', '1231312313', 1, 1520318630, '12313', 1520491442, 1520491442, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (17, '12313123aaaaa', '12313', 2, 1520318944, '12313', 1520491755, 1520491755, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (18, '12313123aaaaacc', '12313', 2, 1583390944, '12313', 1520491845, 1520491845, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (19, 'asdad1111', 'asda', 2, 1521616041, 'asda', 1520492849, 1520492849, '/src/img?fileId=-1', 2, 1);
INSERT INTO `vm_users` VALUES (20, '12313111111', '1231312313', 2, 1521011291, '12313', 1520492897, 1520492897, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (21, 'adssa', 'asdad', 1, 1519715485, 'asdad', 1520493089, 1520493089, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (22, '12313131313', '11', 1, 1520417681, '1231', 1520504087, 1520504087, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (23, 'zhangdake', '123', 2, 1520471734, '奥士达大厦', 1520558142, 1520558142, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (24, '奥术大师', '阿萨', 1, 1520990251, '阿斯达多所', 1520558256, 1520558256, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (25, '阿萨德', '123', 2, 1519694373, '123', 1520558377, 1520558377, '/src/img?fileId=-1', 2, 1);
INSERT INTO `vm_users` VALUES (26, '1231311111111111', '1231312313', 2, 1521422456, '1231', 1520558462, 1520558462, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (27, '12313111', '12313', 2, 1520817731, '12312', 1520558535, 1520563824, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (28, 'asdsad', 'adsad', 2, 1520904235, 'asda', 1520558641, 1520558641, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (29, '1231111', '123131', 2, 1520300226, '132123', 1520559433, 1520559433, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (30, 'asdad1111111', '1231', 2, 1520218233, '12313', 1520563839, 1520563839, '/src/img?fileId=-1', 2, 1);
INSERT INTO `vm_users` VALUES (31, '阿萨德阿萨', '奥士达大厦多', 1, 1520224855, '阿打算', 1520570458, 1520570458, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (32, '啊啊啊啊', '啊啊', 2, 1520829798, '啊啊啊啊', 1520570602, 1520570602, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (33, '12321332999', '123', 2, 1520225330, '11777', 1520570934, 1520571359, '/src/img?fileId=-1', 2, 2);
INSERT INTO `vm_users` VALUES (34, '111123', 'a', 2, 1520225775, '12313', 1520571379, 1520571596, '/src/img?fileId=617', 2, 2);
INSERT INTO `vm_users` VALUES (35, '123', '123', 2, 1520830805, '123', 1520571608, 1520571608, '/src/img/1074', 1, 2);
INSERT INTO `vm_users` VALUES (36, '1231313', '12313', 2, 1520744444, '123', 1520571649, 1520571649, '/src/img/853', 1, 2);
INSERT INTO `vm_users` VALUES (37, '1231111111', '123', 2, 1520330835, '123', 1520590044, 1520590044, '/src/img/791', 2, 2);
INSERT INTO `vm_users` VALUES (38, '111', '123', 1, 1520335586, '啦啦啦', 1520594800, 1524893579, '/src/img/1022', 1, 1);
INSERT INTO `vm_users` VALUES (39, '张可', '123', 3, 1519622574, '123', 1520832179, 1520841750, '/src/img/746', 1, 1);
INSERT INTO `vm_users` VALUES (40, 'zhangke1', '123', 1, 1520932096, 'js定义两个数组。\n\nvar arrA=[1,2,3];\n\nvar arrB=[4,5,6];\n\n要实现[1,2,3,4,5,6]，如果直接arrA.push(arrB); 则arrB只会作为了arrA的一个元素。执行如图：\n\n20170803182733', 1520845708, 1521904822, '/src/img/786', 1, 1);
INSERT INTO `vm_users` VALUES (41, 'zhangke', '123', 1, 1520327324, 'www.epfrontier.com/ind...  - 百度快照\n公司简介 - 美食杰\n美食杰 - 中国最优质的美食,食谱,菜谱网。做你最喜爱的美', 1520845762, 1521209933, '/src/img/898', 1, 1);
INSERT INTO `vm_users` VALUES (42, 'root', '123', 3, 1520411263, '12313sada', 1520929668, 1520930151, '/src/img?fileId=641', 2, 1);
INSERT INTO `vm_users` VALUES (43, 'asdadaaa', 'asdad', 2, 1520319959, 'asd', 1521183966, 1521183966, '/src/img/829', 2, 1);
INSERT INTO `vm_users` VALUES (44, '12312313', '123', 2, 1519811939, '123', 1521194345, 1521194345, '/src/img/850', 2, 1);
INSERT INTO `vm_users` VALUES (45, 'ha', 'asdsad', 2, 1520234497, '9999999999999999999999999', 1521530501, 1522822320, '/src/img/902', 1, 1);
INSERT INTO `vm_users` VALUES (46, 'root', '123', 1, 422175960, '2', 1522821964, 1524896460, '/src/img/1073', 1, 1);
INSERT INTO `vm_users` VALUES (47, '123131313', '123', 1, 1525069577, 'asdad', 1525328783, 1525328783, '/src/img/1072', 1, 1);
INSERT INTO `vm_users` VALUES (48, '123111', '123', 1, 1525071190, '123', 1525330395, 1525330452, '/src/img/1064', 1, 1);
INSERT INTO `vm_users` VALUES (49, 'root1', '123', 2, 1525829918, 'asd', 1525397928, 1525397928, '/src/img/-1', 1, 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 105 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '前端用户登录记录' ROW_FORMAT = Compact;

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
INSERT INTO `vm_users_login_logs` VALUES (11, 38, '171.213.12.120', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521094532, 1, 1521094532, 1521094532, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (12, 38, '171.213.12.120', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521094569, 1, 1521094569, 1521094569, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (13, 38, '171.221.142.90', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521171034, 1, 1521171034, 1521171034, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (14, 38, '171.213.12.120', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521171920, 1, 1521171920, 1521171920, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (15, 38, '171.221.142.90', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521175835, 1, 1521175835, 1521175835, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (16, 38, '171.221.142.90', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521184001, 1, 1521184001, 1521184001, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (17, 38, '171.221.142.90', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521186935, 1, 1521186935, 1521186935, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (18, 40, '171.221.143.215', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521904798, 1, 1521904798, 1521904798, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (19, 41, '171.221.143.215', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521904839, 1, 1521904839, 1521904839, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (20, 38, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521963153, 1, 1521963153, 1521963153, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (21, 38, '171.221.143.215', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521964814, 1, 1521964814, 1521964814, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (22, 38, '171.221.143.215', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521964891, 1, 1521964891, 1521964891, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (23, 38, '171.221.143.215', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521965891, 1, 1521965891, 1521965891, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (24, 38, '171.221.143.215', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521965911, 1, 1521965911, 1521965911, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (25, 38, '171.221.143.215', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521965949, 1, 1521965949, 1521965949, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (26, 38, '171.221.143.215', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521966077, 1, 1521966077, 1521966077, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (27, 38, '171.221.143.215', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521966199, 1, 1521966199, 1521966199, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (28, 38, '171.221.143.215', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521966398, 1, 1521966398, 1521966398, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (29, 38, '171.221.143.215', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521966504, 1, 1521966504, 1521966504, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (30, 41, '171.221.143.215', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1521966522, 1, 1521966522, 1521966522, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (31, 38, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522050959, 1, 1522050959, 1522050959, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (32, 38, '171.221.136.161', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522395029, 1, 1522395029, 1522395029, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (33, 38, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522395204, 1, 1522395204, 1522395204, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (34, 38, '171.221.141.10', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522397261, 1, 1522397261, 1522397261, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (35, 38, '171.213.12.83', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1522734156, 1, 1522734156, 1522734156, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (36, 38, '183.222.130.23', 'Linux', '360*640', 'chrome 57.0.2987.132', '中国', '四川', '眉山', 1522863330, 1, 1522863330, 1522863330, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (37, 38, '183.222.130.23', 'Linux', '360*640', 'chrome 57.0.2987.132', '中国', '四川', '眉山', 1522863492, 1, 1522863492, 1522863492, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (38, 38, '183.222.128.222', 'Linux', '360*640', 'chrome 57.0.2987.132', '中国', '四川', '眉山', 1522952201, 1, 1522952201, 1522952201, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (39, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'ie 10.0', '中国', '四川', '成都', 1523001578, 1, 1523001578, 1523001578, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (40, 38, '183.222.128.222', 'Linux', '360*640', 'chrome 57.0.2987.132', '中国', '四川', '眉山', 1523011491, 1, 1523011491, 1523011491, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (41, 38, '171.221.0.121', 'Windows', '1366*768', 'gecko /5.0 (windows nt 10.0; wow64; trident/7.0; .net4.0c; .net4.0e; .net clr 2.0.50727; .net clr 3.0.30729; .net clr 3.5.30729; rv:11.0) like gecko', '中国', '四川', '成都', 1523022865, 1, 1523022865, 1523022865, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (42, 38, '171.221.0.121', 'Windows', '1366*768', 'gecko /5.0 (windows nt 10.0; wow64; trident/7.0; .net4.0c; .net4.0e; .net clr 2.0.50727; .net clr 3.0.30729; .net clr 3.5.30729; rv:11.0) like gecko', '中国', '四川', '成都', 1523022873, 1, 1523022873, 1523022873, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (43, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'firefox 23.0', '中国', '四川', '成都', 1523258951, 1, 1523258951, 1523258951, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (44, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1523267888, 1, 1523267888, 1523267888, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (45, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1523267943, 1, 1523267943, 1523267943, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (46, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520779433, 1, 1520779433, 1520779433, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (47, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520779869, 1, 1520779869, 1520779869, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (48, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520780697, 1, 1520780697, 1520780697, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (49, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520780820, 1, 1520780820, 1520780820, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (50, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520781062, 1, 1520781062, 1520781062, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (52, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520787682, 1, 1520787682, 1520787682, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (53, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520788132, 1, 1520788132, 1520788132, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (54, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520788309, 1, 1520788309, 1520788309, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (55, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1523339127, 1, 1523339127, 1523339127, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (56, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1523339398, 1, 1523339398, 1523339398, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (57, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1523339524, 1, 1523339524, 1523339524, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (58, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1523339638, 1, 1523339638, 1523339638, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (59, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1520789443, 1, 1520789443, 1520789443, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (60, 38, '171.221.143.47', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1523339834, 1, 1523339834, 1523339834, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (61, 38, '118.113.1.69', 'Windows 7', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524108719, 1, 1524108719, 1524108719, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (62, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524731814, 1, 1524731814, 1524731814, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (63, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524795438, 1, 1524795438, 1524795438, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (65, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524795779, 1, 1524795779, 1524795779, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (66, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524796024, 1, 1524796024, 1524796024, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (67, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524796046, 1, 1524796046, 1524796046, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (68, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524796122, 1, 1524796122, 1524796122, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (69, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524796157, 1, 1524796157, 1524796157, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (70, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524796221, 1, 1524796221, 1524796221, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (71, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524796286, 1, 1524796286, 1524796286, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (72, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524796824, 1, 1524796824, 1524796824, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (73, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 58.0.3029.110', '中国', '四川', '成都', 1524797058, 1, 1524797058, 1524797058, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (74, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524797255, 1, 1524797255, 1524797255, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (75, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524799665, 1, 1524799665, 1524799665, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (76, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524886210, 1, 1524886210, 1524886210, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (77, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524886239, 1, 1524886239, 1524886239, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (78, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 58.0.3029.110', '中国', '四川', '成都', 1524886288, 1, 1524886288, 1524886288, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (79, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524886333, 1, 1524886333, 1524886333, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (80, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 58.0.3029.110', '中国', '四川', '成都', 1524886348, 1, 1524886348, 1524886348, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (81, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524886451, 1, 1524886451, 1524886451, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (82, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 58.0.3029.110', '中国', '四川', '成都', 1524886462, 1, 1524886462, 1524886462, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (83, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524887487, 1, 1524887487, 1524887487, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (84, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 58.0.3029.110', '中国', '四川', '成都', 1524887491, 1, 1524887491, 1524887491, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (85, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524893487, 1, 1524893487, 1524893487, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (86, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 58.0.3029.110', '中国', '四川', '成都', 1524893504, 1, 1524893504, 1524893504, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (87, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524893515, 1, 1524893515, 1524893515, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (88, 38, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524893562, 1, 1524893562, 1524893562, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (89, 46, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524894114, 1, 1524894114, 1524894114, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (90, 46, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524896461, 1, 1524896461, 1524896461, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (91, 46, '171.221.0.219', 'Windows', '1920*1080', 'chrome 58.0.3029.110', '中国', '四川', '成都', 1524903604, 1, 1524903604, 1524903604, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (92, 46, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524903610, 1, 1524903610, 1524903610, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (93, 46, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524903625, 1, 1524903625, 1524903625, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (94, 46, '171.221.0.219', 'Windows', '1920*1080', 'chrome 58.0.3029.110', '中国', '四川', '成都', 1524903637, 1, 1524903637, 1524903637, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (95, 46, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524903746, 1, 1524903746, 1524903746, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (96, 46, '171.221.0.219', 'Windows', '1920*1080', 'chrome 58.0.3029.110', '中国', '四川', '成都', 1524903758, 1, 1524903758, 1524903758, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (97, 46, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524905462, 1, 1524905462, 1524905462, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (98, 46, '171.221.0.219', 'Windows', '1920*1080', 'chrome 58.0.3029.110', '中国', '四川', '成都', 1524905476, 1, 1524905476, 1524905476, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (99, 46, '171.221.0.219', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1524905521, 1, 1524905521, 1524905521, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (100, 46, '171.221.0.219', 'Windows', '1920*1080', 'chrome 58.0.3029.110', '中国', '四川', '成都', 1524905561, 1, 1524905561, 1524905561, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (101, 46, '183.222.132.198', 'Windows', '1920*1080', 'gecko /5.0 (windows nt 10.0; wow64; trident/7.0; .net4.0c; .net4.0e; .net clr 2.0.50727; .net clr 3.0.30729; .net clr 3.5.30729; core/1.53.3538.400 qqbrowser/9.6.12782.400; rv:11.0) like gecko', '中国', '四川', '眉山', 1525021759, 1, 1525021759, 1525021759, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (102, 46, '118.113.0.58', 'Windows', '1920*1080', 'chrome 49.0.2623.112', '中国', '四川', '成都', 1525273794, 1, 1525273794, 1525273794, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (103, 46, '171.221.143.198', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1525326946, 1, 1525326946, 1525326946, 1, 1);
INSERT INTO `vm_users_login_logs` VALUES (104, 48, '171.221.143.198', 'Windows', '1920*1080', 'chrome 62.0.3202.94', '中国', '四川', '成都', 1525330430, 1, 1525330430, 1525330430, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
