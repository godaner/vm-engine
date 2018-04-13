/*
 Navicat Premium Data Transfer

 Source Server         : 120.78.191.94_root
 Source Server Type    : MySQL
 Source Server Version : 50633
 Source Host           : 120.78.191.94:3306
 Source Schema         : vm_src

 Target Server Type    : MySQL
 Target Server Version : 50633
 File Encoding         : 65001

 Date: 14/03/2018 17:23:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for vm_files
-- ----------------------------
DROP TABLE IF EXISTS `vm_files`;
CREATE TABLE `vm_files`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `filename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '图片名,如a.png',
  `original_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '文件原名',
  `file_size` bigint(20) UNSIGNED DEFAULT NULL COMMENT '图片大小',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `content_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '文件类型，如video/mp4',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 642 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '文件信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_files
-- ----------------------------
INSERT INTO `vm_files` VALUES (412, '110', '1', 1, 1519970567, 1519970567, '1', 1, 1);
INSERT INTO `vm_files` VALUES (413, '2', '2', 2, 1519970567, 1519970567, '2', 1, 1);
INSERT INTO `vm_files` VALUES (414, '3', '3', 3, 1519970567, 1519970567, '3', 1, 1);
INSERT INTO `vm_files` VALUES (415, '4', '4', 4, 1519970567, 1519970567, '4', 1, 1);
INSERT INTO `vm_files` VALUES (416, '5', '5', 5, 1519970567, 1519970567, '5', 1, 1);
INSERT INTO `vm_files` VALUES (417, '6', '6', 6, 1519970567, 1519970567, '6', 1, 1);
INSERT INTO `vm_files` VALUES (418, '7', '7', 7, 1519970567, 1519970567, '7', 1, 1);
INSERT INTO `vm_files` VALUES (419, '8', '8', 8, 1519970567, 1519970567, '8', 1, 1);
INSERT INTO `vm_files` VALUES (420, '9', '9', 9, 1519970567, 1519970567, '9', 1, 1);
INSERT INTO `vm_files` VALUES (422, '1', '1', 1, 1519970923, 1519970923, '1', 1, 1);
INSERT INTO `vm_files` VALUES (423, '2', '2', 2, 1519970923, 1519970923, '2', 1, 1);
INSERT INTO `vm_files` VALUES (424, '3', '3', 3, 1519970923, 1519970923, '3', 1, 1);
INSERT INTO `vm_files` VALUES (425, '4', '4', 4, 1519970923, 1519970923, '4', 1, 1);
INSERT INTO `vm_files` VALUES (426, '5', '5', 5, 1519970923, 1519970923, '5', 1, 1);
INSERT INTO `vm_files` VALUES (427, '6', '6', 6, 1519970923, 1519970923, '6', 1, 1);
INSERT INTO `vm_files` VALUES (428, '7', '7', 7, 1519970923, 1519970923, '7', 1, 1);
INSERT INTO `vm_files` VALUES (429, '8', '8', 8, 1519970923, 1519970923, '8', 1, 1);
INSERT INTO `vm_files` VALUES (430, '9', '9', 9, 1519970923, 1519970923, '9', 1, 1);
INSERT INTO `vm_files` VALUES (432, '1', '1', 1, 1519971005, 1519971005, '1', 1, 1);
INSERT INTO `vm_files` VALUES (433, '2', '2', 2, 1519971005, 1519971005, '2', 1, 1);
INSERT INTO `vm_files` VALUES (434, '3', '3', 3, 1519971005, 1519971005, '3', 1, 1);
INSERT INTO `vm_files` VALUES (435, '4', '4', 4, 1519971005, 1519971005, '4', 1, 1);
INSERT INTO `vm_files` VALUES (436, '5', '5', 5, 1519971005, 1519971005, '5', 1, 1);
INSERT INTO `vm_files` VALUES (437, '6', '6', 6, 1519971005, 1519971005, '6', 1, 1);
INSERT INTO `vm_files` VALUES (438, '7', '7', 7, 1519971005, 1519971005, '7', 1, 1);
INSERT INTO `vm_files` VALUES (439, '8', '8', 8, 1519971005, 1519971005, '8', 1, 1);
INSERT INTO `vm_files` VALUES (440, '9', '9', 9, 1519971005, 1519971005, '9', 1, 1);
INSERT INTO `vm_files` VALUES (442, '1', '1', 1, 1519971136, 1519971136, '1', 1, 1);
INSERT INTO `vm_files` VALUES (443, '2', '2', 2, 1519971136, 1519971136, '2', 1, 1);
INSERT INTO `vm_files` VALUES (444, '3', '3', 3, 1519971136, 1519971136, '3', 1, 1);
INSERT INTO `vm_files` VALUES (445, '4', '4', 4, 1519971136, 1519971136, '4', 1, 1);
INSERT INTO `vm_files` VALUES (446, '5', '5', 5, 1519971136, 1519971136, '5', 1, 1);
INSERT INTO `vm_files` VALUES (447, '6', '6', 6, 1519971136, 1519971136, '6', 1, 1);
INSERT INTO `vm_files` VALUES (448, '7', '7', 7, 1519971136, 1519971136, '7', 1, 1);
INSERT INTO `vm_files` VALUES (449, '8', '8', 8, 1519971136, 1519971136, '8', 1, 1);
INSERT INTO `vm_files` VALUES (450, '9', '9', 9, 1519971136, 1519971136, '9', 1, 1);
INSERT INTO `vm_files` VALUES (452, '1', '1', 1, 1519971765, 1519971765, '1', 1, 1);
INSERT INTO `vm_files` VALUES (453, '2', '2', 2, 1519971765, 1519971765, '2', 1, 1);
INSERT INTO `vm_files` VALUES (454, '3', '3', 3, 1519971765, 1519971765, '3', 1, 1);
INSERT INTO `vm_files` VALUES (455, '4', '4', 4, 1519971765, 1519971765, '4', 1, 1);
INSERT INTO `vm_files` VALUES (456, '5', '5', 5, 1519971765, 1519971765, '5', 1, 1);
INSERT INTO `vm_files` VALUES (457, '6', '6', 6, 1519971765, 1519971765, '6', 1, 1);
INSERT INTO `vm_files` VALUES (458, '7', '7', 7, 1519971765, 1519971765, '7', 1, 1);
INSERT INTO `vm_files` VALUES (459, '8', '8', 8, 1519971765, 1519971765, '8', 1, 1);
INSERT INTO `vm_files` VALUES (460, '9', '9', 9, 1519971765, 1519971765, '9', 1, 1);
INSERT INTO `vm_files` VALUES (461, '110', '0', 0, 1519971866, 1519971866, '0', 1, 1);
INSERT INTO `vm_files` VALUES (462, '1', '1', 1, 1519971866, 1519971866, '1', 1, 1);
INSERT INTO `vm_files` VALUES (463, '2', '2', 2, 1519971866, 1519971866, '2', 1, 1);
INSERT INTO `vm_files` VALUES (464, '3', '3', 3, 1519971866, 1519971866, '3', 1, 1);
INSERT INTO `vm_files` VALUES (465, '4', '4', 4, 1519971866, 1519971866, '4', 1, 1);
INSERT INTO `vm_files` VALUES (466, '5', '5', 5, 1519971866, 1519971866, '5', 1, 1);
INSERT INTO `vm_files` VALUES (467, '6', '6', 6, 1519971866, 1519971866, '6', 1, 1);
INSERT INTO `vm_files` VALUES (468, '7', '7', 7, 1519971866, 1519971866, '7', 1, 1);
INSERT INTO `vm_files` VALUES (469, '8', '8', 8, 1519971866, 1519971866, '8', 1, 1);
INSERT INTO `vm_files` VALUES (470, '9', '9', 9, 1519971866, 1519971866, '9', 1, 1);
INSERT INTO `vm_files` VALUES (471, '110', '0', 0, 1519972307, 1519972307, '0', 1, 1);
INSERT INTO `vm_files` VALUES (472, '1', '1', 1, 1519972307, 1519972307, '1', 1, 1);
INSERT INTO `vm_files` VALUES (473, '2', '2', 2, 1519972307, 1519972307, '2', 1, 1);
INSERT INTO `vm_files` VALUES (474, '3', '3', 3, 1519972307, 1519972307, '3', 1, 1);
INSERT INTO `vm_files` VALUES (475, '4', '4', 4, 1519972307, 1519972307, '4', 1, 1);
INSERT INTO `vm_files` VALUES (476, '5', '5', 5, 1519972307, 1519972307, '5', 1, 1);
INSERT INTO `vm_files` VALUES (477, '6', '6', 6, 1519972307, 1519972307, '6', 1, 1);
INSERT INTO `vm_files` VALUES (478, '7', '7', 7, 1519972307, 1519972307, '7', 1, 1);
INSERT INTO `vm_files` VALUES (479, '8', '8', 8, 1519972307, 1519972307, '8', 1, 1);
INSERT INTO `vm_files` VALUES (480, '9', '9', 9, 1519972307, 1519972307, '9', 1, 1);
INSERT INTO `vm_files` VALUES (481, '110', '0', 0, 1519972308, 1519972308, '0', 1, 1);
INSERT INTO `vm_files` VALUES (482, '1', '1', 1, 1519972308, 1519972308, '1', 1, 1);
INSERT INTO `vm_files` VALUES (483, '2', '2', 2, 1519972308, 1519972308, '2', 1, 1);
INSERT INTO `vm_files` VALUES (484, '3', '3', 3, 1519972308, 1519972308, '3', 1, 1);
INSERT INTO `vm_files` VALUES (485, '4', '4', 4, 1519972308, 1519972308, '4', 1, 1);
INSERT INTO `vm_files` VALUES (486, '5', '5', 5, 1519972308, 1519972308, '5', 1, 1);
INSERT INTO `vm_files` VALUES (487, '6', '6', 6, 1519972308, 1519972308, '6', 1, 1);
INSERT INTO `vm_files` VALUES (488, '7', '7', 7, 1519972308, 1519972308, '7', 1, 1);
INSERT INTO `vm_files` VALUES (489, '8', '8', 8, 1519972308, 1519972308, '8', 1, 1);
INSERT INTO `vm_files` VALUES (490, '9', '9', 9, 1519972308, 1519972308, '9', 1, 1);
INSERT INTO `vm_files` VALUES (491, '110', '0', 0, 1519972308, 1519972308, '0', 1, 1);
INSERT INTO `vm_files` VALUES (492, '1', '1', 1, 1519972308, 1519972308, '1', 1, 1);
INSERT INTO `vm_files` VALUES (493, '2', '2', 2, 1519972308, 1519972308, '2', 1, 1);
INSERT INTO `vm_files` VALUES (494, '3', '3', 3, 1519972308, 1519972308, '3', 1, 1);
INSERT INTO `vm_files` VALUES (495, '4', '4', 4, 1519972308, 1519972308, '4', 1, 1);
INSERT INTO `vm_files` VALUES (496, '5', '5', 5, 1519972308, 1519972308, '5', 1, 1);
INSERT INTO `vm_files` VALUES (497, '6', '6', 6, 1519972308, 1519972308, '6', 1, 1);
INSERT INTO `vm_files` VALUES (498, '7', '7', 7, 1519972308, 1519972308, '7', 1, 1);
INSERT INTO `vm_files` VALUES (499, '8', '8', 8, 1519972308, 1519972308, '8', 1, 1);
INSERT INTO `vm_files` VALUES (500, '9', '9', 9, 1519972308, 1519972308, '9', 1, 1);
INSERT INTO `vm_files` VALUES (501, '110', '0', 0, 1519972308, 1519972308, '0', 1, 1);
INSERT INTO `vm_files` VALUES (502, '1', '1', 1, 1519972308, 1519972308, '1', 1, 1);
INSERT INTO `vm_files` VALUES (503, '2', '2', 2, 1519972308, 1519972308, '2', 1, 1);
INSERT INTO `vm_files` VALUES (504, '3', '3', 3, 1519972308, 1519972308, '3', 1, 1);
INSERT INTO `vm_files` VALUES (505, '4', '4', 4, 1519972308, 1519972308, '4', 1, 1);
INSERT INTO `vm_files` VALUES (506, '5', '5', 5, 1519972308, 1519972308, '5', 1, 1);
INSERT INTO `vm_files` VALUES (507, '6', '6', 6, 1519972308, 1519972308, '6', 1, 1);
INSERT INTO `vm_files` VALUES (508, '7', '7', 7, 1519972308, 1519972308, '7', 1, 1);
INSERT INTO `vm_files` VALUES (509, '8', '8', 8, 1519972308, 1519972308, '8', 1, 1);
INSERT INTO `vm_files` VALUES (510, '9', '9', 9, 1519972308, 1519972308, '9', 1, 1);
INSERT INTO `vm_files` VALUES (511, '110', '0', 0, 1519972308, 1519972308, '0', 1, 1);
INSERT INTO `vm_files` VALUES (512, '1', '1', 1, 1519972308, 1519972308, '1', 1, 1);
INSERT INTO `vm_files` VALUES (513, '2', '2', 2, 1519972308, 1519972308, '2', 1, 1);
INSERT INTO `vm_files` VALUES (514, '3', '3', 3, 1519972308, 1519972308, '3', 1, 1);
INSERT INTO `vm_files` VALUES (515, '4', '4', 4, 1519972308, 1519972308, '4', 1, 1);
INSERT INTO `vm_files` VALUES (516, '5', '5', 5, 1519972308, 1519972308, '5', 1, 1);
INSERT INTO `vm_files` VALUES (517, '6', '6', 6, 1519972308, 1519972308, '6', 1, 1);
INSERT INTO `vm_files` VALUES (518, '7', '7', 7, 1519972308, 1519972308, '7', 1, 1);
INSERT INTO `vm_files` VALUES (519, '8', '8', 8, 1519972308, 1519972308, '8', 1, 1);
INSERT INTO `vm_files` VALUES (520, '9', '9', 9, 1519972308, 1519972308, '9', 1, 1);
INSERT INTO `vm_files` VALUES (521, '110', '0', 0, 1519972309, 1519972309, '0', 1, 1);
INSERT INTO `vm_files` VALUES (522, '1', '1', 1, 1519972309, 1519972309, '1', 1, 1);
INSERT INTO `vm_files` VALUES (523, '2', '2', 2, 1519972309, 1519972309, '2', 1, 1);
INSERT INTO `vm_files` VALUES (524, '3', '3', 3, 1519972309, 1519972309, '3', 1, 1);
INSERT INTO `vm_files` VALUES (525, '4', '4', 4, 1519972309, 1519972309, '4', 1, 1);
INSERT INTO `vm_files` VALUES (526, '5', '5', 5, 1519972309, 1519972309, '5', 1, 1);
INSERT INTO `vm_files` VALUES (527, '6', '6', 6, 1519972309, 1519972309, '6', 1, 1);
INSERT INTO `vm_files` VALUES (528, '7', '7', 7, 1519972309, 1519972309, '7', 1, 1);
INSERT INTO `vm_files` VALUES (529, '8', '8', 8, 1519972309, 1519972309, '8', 1, 1);
INSERT INTO `vm_files` VALUES (530, '9', '9', 9, 1519972309, 1519972309, '9', 1, 1);
INSERT INTO `vm_files` VALUES (531, '110', '0', 0, 1519972309, 1519972309, '0', 1, 1);
INSERT INTO `vm_files` VALUES (532, '1', '1', 1, 1519972309, 1519972309, '1', 1, 1);
INSERT INTO `vm_files` VALUES (533, '2', '2', 2, 1519972309, 1519972309, '2', 1, 1);
INSERT INTO `vm_files` VALUES (534, '3', '3', 3, 1519972309, 1519972309, '3', 1, 1);
INSERT INTO `vm_files` VALUES (535, '4', '4', 4, 1519972309, 1519972309, '4', 1, 1);
INSERT INTO `vm_files` VALUES (536, '5', '5', 5, 1519972309, 1519972309, '5', 1, 1);
INSERT INTO `vm_files` VALUES (537, '6', '6', 6, 1519972309, 1519972309, '6', 1, 1);
INSERT INTO `vm_files` VALUES (538, '7', '7', 7, 1519972309, 1519972309, '7', 1, 1);
INSERT INTO `vm_files` VALUES (539, '8', '8', 8, 1519972309, 1519972309, '8', 1, 1);
INSERT INTO `vm_files` VALUES (540, '9', '9', 9, 1519972309, 1519972309, '9', 1, 1);
INSERT INTO `vm_files` VALUES (541, '110', '0', 0, 1519972603, 1519972603, '0', 1, 1);
INSERT INTO `vm_files` VALUES (542, '1', '1', 1, 1519972603, 1519972603, '1', 1, 1);
INSERT INTO `vm_files` VALUES (543, '2', '2', 2, 1519972603, 1519972603, '2', 1, 1);
INSERT INTO `vm_files` VALUES (544, '3', '3', 3, 1519972603, 1519972603, '3', 1, 1);
INSERT INTO `vm_files` VALUES (545, '4', '4', 4, 1519972603, 1519972603, '4', 1, 1);
INSERT INTO `vm_files` VALUES (546, '5', '5', 5, 1519972603, 1519972603, '5', 1, 1);
INSERT INTO `vm_files` VALUES (547, '6', '6', 6, 1519972603, 1519972603, '6', 1, 1);
INSERT INTO `vm_files` VALUES (548, '7', '7', 7, 1519972603, 1519972603, '7', 1, 1);
INSERT INTO `vm_files` VALUES (549, '8', '8', 8, 1519972603, 1519972603, '8', 1, 1);
INSERT INTO `vm_files` VALUES (550, '9', '9', 9, 1519972603, 1519972603, '9', 1, 1);
INSERT INTO `vm_files` VALUES (551, '110', '0', 0, 1519972736, 1519972736, '0', 1, 1);
INSERT INTO `vm_files` VALUES (552, '1', '1', 1, 1519972736, 1519972736, '1', 1, 1);
INSERT INTO `vm_files` VALUES (553, '2', '2', 2, 1519972736, 1519972736, '2', 1, 1);
INSERT INTO `vm_files` VALUES (554, '3', '3', 3, 1519972736, 1519972736, '3', 1, 1);
INSERT INTO `vm_files` VALUES (555, '4', '4', 4, 1519972736, 1519972736, '4', 1, 1);
INSERT INTO `vm_files` VALUES (556, '5', '5', 5, 1519972736, 1519972736, '5', 1, 1);
INSERT INTO `vm_files` VALUES (557, '6', '6', 6, 1519972736, 1519972736, '6', 1, 1);
INSERT INTO `vm_files` VALUES (558, '7', '7', 7, 1519972736, 1519972736, '7', 1, 1);
INSERT INTO `vm_files` VALUES (559, '8', '8', 8, 1519972736, 1519972736, '8', 1, 1);
INSERT INTO `vm_files` VALUES (560, '9', '9', 9, 1519972736, 1519972736, '9', 1, 1);
INSERT INTO `vm_files` VALUES (561, '110', '0', 0, 1519972875, 1519972875, '0', 1, 1);
INSERT INTO `vm_files` VALUES (562, '1', '1', 1, 1519972875, 1519972875, '1', 1, 1);
INSERT INTO `vm_files` VALUES (563, '2', '2', 2, 1519972875, 1519972875, '2', 1, 1);
INSERT INTO `vm_files` VALUES (564, '3', '3', 3, 1519972875, 1519972875, '3', 1, 1);
INSERT INTO `vm_files` VALUES (565, '4', '4', 4, 1519972875, 1519972875, '4', 1, 1);
INSERT INTO `vm_files` VALUES (566, '5', '5', 5, 1519972875, 1519972875, '5', 1, 1);
INSERT INTO `vm_files` VALUES (567, '6', '6', 6, 1519972875, 1519972875, '6', 1, 1);
INSERT INTO `vm_files` VALUES (568, '7', '7', 7, 1519972875, 1519972875, '7', 1, 1);
INSERT INTO `vm_files` VALUES (569, '8', '8', 8, 1519972875, 1519972875, '8', 1, 1);
INSERT INTO `vm_files` VALUES (570, '9', '9', 9, 1519972875, 1519972875, '9', 1, 1);
INSERT INTO `vm_files` VALUES (571, '110', '0', 0, 1519976577, 1519976577, '0', 2, 1);
INSERT INTO `vm_files` VALUES (572, '1', '1', 1, 1519976577, 1519976577, '1', 2, 1);
INSERT INTO `vm_files` VALUES (573, '2', '2', 2, 1519976577, 1519976577, '2', 2, 1);
INSERT INTO `vm_files` VALUES (574, '3', '3', 3, 1519976577, 1519976577, '3', 2, 1);
INSERT INTO `vm_files` VALUES (575, '4', '4', 4, 1519976577, 1519976577, '4', 2, 1);
INSERT INTO `vm_files` VALUES (576, '5', '5', 5, 1519976577, 1519976577, '5', 2, 1);
INSERT INTO `vm_files` VALUES (577, '6', '6', 6, 1519976577, 1519976577, '6', 2, 1);
INSERT INTO `vm_files` VALUES (578, '7', '7', 7, 1519976577, 1519976577, '7', 2, 1);
INSERT INTO `vm_files` VALUES (579, '8', '8', 8, 1519976577, 1519976577, '8', 2, 1);
INSERT INTO `vm_files` VALUES (580, '9', '9', 9, 1519976577, 1519976577, '9', 2, 1);
INSERT INTO `vm_files` VALUES (581, '8559b997-ce0a-464a-8287-78674649760f.png', 'TIM??20180205185501.png', 13660, 1519976619, 1519976619, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (582, '0bf4bdd5-6208-4a9b-80ce-6fe444f9868d.png', 'TIM??20180205185501.png', 13660, 1519976757, 1519976757, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (583, '0796d952-ffb1-4a79-a7b5-17a3177470de.png', 'TIM??20180130172320.png', 84130, 1519976834, 1519976834, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (584, '3ec7d8e1-74b6-4d0c-8e06-e696377085c0.png', 'TIM??20180205185501.png', 13660, 1519976836, 1519976836, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (585, '7ae097c7-4d47-448c-8177-fbc1893adb63.jpg', 'TIM??20180224093835.jpg', 57768, 1520411530, 1520411530, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (586, '805e04e8-459d-492b-82b9-2aa31eb26baa.png', 'TIM??20180205185501.png', 13660, 1520411587, 1520411587, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (587, '703eba7b-6e14-4fd3-86a0-56f697800bfa.png', 'TIM??20180205185501.png', 13660, 1520411744, 1520411744, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (588, 'a91891a2-a612-426f-90b5-e58fbdda3259.png', 'TIM??20180205185501.png', 13660, 1520415369, 1520415369, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (589, '93f0e7d8-fd08-4125-9414-3cecad9180cb.png', 'TIM??20180205185501.png', 13660, 1520416050, 1520416050, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (590, 'ba1838c9-5702-4eb6-b6e5-a434f30350f4.png', 'TIM??20180131145040.png', 130955, 1520416100, 1520416100, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (591, '022b8b4a-0f0d-4b20-8135-109daefebb9b.jpg', 'TIM??20180224093835.jpg', 57768, 1520416106, 1520416106, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (592, 'ed70208d-18a5-437a-853c-7f18510e09b0.jpg', 'TIM??20180224093835.jpg', 57768, 1520416499, 1520416499, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (593, 'ca342cac-4d73-43af-8f60-79cfec1530b8.png', 'TIM??20180205185501.png', 13660, 1520416579, 1520416579, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (594, '58abb677-355a-4dc0-b2bd-feb513fd9370.png', 'TIM??20180205185501.png', 13660, 1520417402, 1520417402, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (595, '839eb8c2-5495-464e-8c62-b566fcfe46a6.png', 'TIM??20180205185501.png', 13660, 1520417619, 1520417619, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (596, '7b4a695f-62ef-41e7-b800-a38b2e50121f.png', 'TIM??20180205185501.png', 13660, 1520417768, 1520417768, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (597, '7d12e734-7ae6-48ba-a534-6040fa7cf0f0.jpg', 'TIM??20180224093835.jpg', 57768, 1520417927, 1520417927, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (598, '8d19c4ba-8eb9-4ea2-a270-d6eef2b855f0.jpg', 'TIM??20180224093835.jpg', 57768, 1520418018, 1520418018, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (599, '26d0cfe8-be0b-4771-8986-37f9cb8f40f7.png', 'TIM??20180205185501.png', 13660, 1520418141, 1520418141, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (600, '64f8346e-8c39-46f5-b17c-a6029b19faf8.png', 'TIM??20180205185501.png', 13660, 1520418233, 1520418233, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (601, '64a98f7b-5eff-44b0-aebb-652b76c122b7.png', 'TIM??20180131182833.png', 76192, 1520418399, 1520418399, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (602, '45b724af-9311-46c0-b528-621074d17142.jpg', 'TIM??20180224093835.jpg', 57768, 1520418474, 1520418474, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (603, '123edb9f-6559-4070-889e-89ddeada415f.png', 'TIM??20180205185501.png', 13660, 1520419315, 1520419315, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (604, 'd22f6480-8b1d-48df-85b7-a3b4afbe8a79.png', 'TIM??20180130172343.png', 119227, 1520419619, 1520419619, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (605, 'd98ca6c3-cdd3-45b8-878d-cc28adc9cacf.png', 'TIM??20180205134459.png', 11413, 1520419707, 1520419707, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (606, 'e62df85f-6927-450a-a702-766bc27f7e28.png', 'TIM??20180205185501.png', 13660, 1520420603, 1520420603, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (607, '79e31955-ea9e-4f2b-93d7-fadb9e86f80c.png', 'TIM??20180205185501.png', 13660, 1520420941, 1520420941, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (608, '22678477-3419-4c83-a352-7a4aa41059b5.png', 'TIM??20180205104328.png', 25090, 1520420961, 1520420961, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (609, 'fd4336bc-bc96-4e7e-949b-97ade40bd565.png', 'TIM??20180205185501.png', 13660, 1520421977, 1520421977, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (610, '1436dd59-cf22-4d5f-a83d-dc46fd472bde.png', 'TIM??20180205185501.png', 13660, 1520422107, 1520422107, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (611, '70979e97-910a-4529-82e6-e0dbe4e70ac1.png', 'TIM??20180205134459.png', 11413, 1520422270, 1520422270, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (612, '55957aca-08fe-42e7-89f1-4de95d48a010.png', 'TIM??20180205185501.png', 13660, 1520422482, 1520422482, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (613, '39cdbe25-ab54-46ae-a12b-b11c754f4fcb.jpg', 'TIM??20180224093835.jpg', 57768, 1520422540, 1520422540, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (614, 'c39c9e1c-6d29-4d5e-8747-df4faf73493e.png', 'TIM??20180205185501.png', 13660, 1520422545, 1520422545, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (615, '27bc078d-8287-49b6-ac0a-e064946dc253.png', 'TIM??20180207091011.png', 23549, 1520422549, 1520422549, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (616, '08441ed0-d573-4724-b68e-bb92e6523753.jpg', 'TIM??20180224093835.jpg', 57768, 1520422559, 1520422559, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (617, '640861db-d6d6-4e97-a5b2-bd2232f5e6c7.png', 'TIM??20180131182833.png', 76192, 1520422568, 1520422568, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (618, 'c973f5af-46df-4da4-a055-2d75ca2bca43.png', 'TIM??20180205185501.png', 13660, 1520422724, 1520422724, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (619, '8276f914-5e15-4236-b8c6-4ee9da0617aa.png', 'TIM??20180205104328.png', 25090, 1520422732, 1520422732, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (620, '0be35311-9f5c-478e-a0d2-638c7fbc789d.jpg', 'TIM??20180224093835.jpg', 57768, 1520422747, 1520422747, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (621, '558b3eac-9477-495f-9024-07f114fef87c.png', 'TIM??20180205185501.png', 13660, 1520575845, 1520575845, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (622, '6199d9af-cf51-4ea4-8201-d5e79515c244.png', 'TIM??20180205185501.png', 13660, 1520576409, 1520576409, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (623, '92258000-dddf-42f9-8c42-5a046bf6c6b7.png', 'TIM??20180131145040.png', 130955, 1520576428, 1520576428, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (624, 'bcbdf400-8f7c-47c9-81a8-82c09cb0be29.png', 'TIM??20180205185501.png', 13660, 1520576438, 1520576438, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (625, 'fdc49c84-6cba-421a-9357-3224184abcf8.png', 'TIM??20180205185501.png', 13660, 1520577658, 1520577658, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (626, 'c38d83e1-1585-4e33-97a9-76c0eab1a39b.jpg', 'TIM??20180224093835.jpg', 57768, 1520577664, 1520577664, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (627, '4b82df12-d786-448c-ac6d-398e907f0bbd.png', 'TIM??20180205185501.png', 13660, 1520577673, 1520577673, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (628, '17581ec2-f412-44df-975e-6431f87b3f05.png', 'TIM??20180208132125.png', 9166, 1520577682, 1520577682, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (629, '724c82be-aae4-49ce-9f84-d72673837fdf.png', 'TIM??20180130172343.png', 119227, 1520590008, 1520590008, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (630, '3c2318c4-e191-44fe-9ffc-05ec0b99355e.png', 'TIM??20180205185501.png', 13660, 1520591562, 1520591562, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (631, 'ca617f3c-bec9-47dd-bbdf-aec62fac021e.png', 'TIM??20180130172343.png', 119227, 1520591579, 1520591579, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (632, 'e5777eb4-60a5-4295-bd89-17ca2a522d3c.png', 'TIM??20180205185501.png', 13660, 1520592248, 1520592248, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (633, '464ac935-2e8b-48e0-8727-51580f62f781.jpg', 'Cg-4WlWQ9OmIZLzsABPwctWQ5uMAAGJsgIwtHEAE_CK734 (1).jpg', 763584, 1520592259, 1520592259, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (634, '29bd5bda-d9fb-4b48-83e8-d57099ec3704.jpg', 'Cg-4WlWQ9OmIZLzsABPwctWQ5uMAAGJsgIwtHEAE_CK734 (1).jpg', 763584, 1520592770, 1520592770, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (635, '1dc6bcfc-e665-45d0-a1f7-1e16da790726.png', 'TIM??20180131145040.png', 130955, 1520602730, 1520602730, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (636, 'bbf077d5-d32f-4409-9117-503a1c16b280.jpg', '40kvusja5qx.jpg', 166657, 1520602777, 1520602777, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (637, 'de795f08-5b91-4237-bfd2-fcfe6573f2f9.png', 'TIM??20180205185501.png', 13660, 1520606977, 1520606977, 'image/png', 2, 1);
INSERT INTO `vm_files` VALUES (638, 'eeb6491e-3410-4607-a79a-e3a9880818d9.jpg', '40kvusja5qx.jpg', 166657, 1520607627, 1520607627, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (639, 'b2d86811-016e-44c2-9996-139cbdebd87d.jpg', 'Cg-4WlWQ9OmIZLzsABPwctWQ5uMAAGJsgIwtHEAE_CK734 (1).jpg', 763584, 1520608080, 1520608080, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (640, '739ca1f7-1bf1-4cfb-babe-dd35b8a187a0.jpg', '40kvusja5qx.jpg', 166657, 1520608931, 1520608931, 'image/jpeg', 2, 1);
INSERT INTO `vm_files` VALUES (641, '825afc33-1aea-4da0-b9bc-f0cf87e2ce86.jpg', 'Cg-4WlWQ9OmIZLzsABPwctWQ5uMAAGJsgIwtHEAE_CK734 (1).jpg', 763584, 1520609486, 1520609486, 'image/jpeg', 2, 1);

SET FOREIGN_KEY_CHECKS = 1;