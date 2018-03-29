/*
 Navicat Premium Data Transfer

 Source Server         : 120.78.191.94_root
 Source Server Type    : MySQL
 Source Server Version : 50633
 Source Host           : 120.78.191.94:3306
 Source Schema         : vm_movie

 Target Server Type    : MySQL
 Target Server Version : 50633
 File Encoding         : 65001

 Date: 26/03/2018 12:50:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for vm_countrys
-- ----------------------------
DROP TABLE IF EXISTS `vm_countrys`;
CREATE TABLE `vm_countrys`  (
  `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `name_chinese` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `name_english` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '国家表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_countrys
-- ----------------------------
INSERT INTO `vm_countrys` VALUES (1, '00', '未知的國家', 'Unknown Country', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (2, 'TT', '千里達與托貝哥共和國 (Trinidad and Tobago)', 'Trinidad and Tobago', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (3, 'TV', '土瓦魯 (Tuvalu)', 'Tuvalu', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (4, 'TR', '土耳其 (Türkiye)', 'Turkey (Türkiye)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (5, 'TM', '土庫曼 (Türkmenistan)', 'Turkmenistan (Türkmenistan)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (6, 'BT', '不丹 (འབྲུག་ཡུལ)', 'Bhutan (འབྲུག་ཡུལ)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (7, 'CF', '中非共和國 (République Centrafricaine)', 'Central African Republic (République Centrafricaine)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (8, 'CN', '中國 (中国)', 'China (中国)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (9, 'DK', '丹麥 (Danmark)', 'Denmark (Danmark)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (10, 'EC', '厄瓜多 (Ecuador)', 'Ecuador', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (11, 'ER', '厄利垂亞 (Ertra)', 'Eritrea (Ertra)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (12, 'PG', '巴布亞紐幾內亞 (Papua New Guinea)', 'Papua New Guinea', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (13, 'BR', '巴西 (Brasil)', 'Brazil (Brasil)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (14, 'BB', '巴貝多 (Barbados)', 'Barbados', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (15, 'PY', '巴拉圭 (Paraguay)', 'Paraguay', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (16, 'BH', '巴林 (البحرين)', 'Bahrain (البحرين)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (17, 'BS', '巴哈馬 (Bahamas)', 'Bahamas', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (18, 'PA', '巴拿馬 (Panamá)', 'Panama (Panamá)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (19, 'PS', '巴勒斯坦領土 (Palestinian Territory)', 'Palestinian Territory', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (20, 'PK', '巴基斯坦 (پاکستان)', 'Pakistan (پاکستان)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (21, 'JP', '日本', 'Japan (日本)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (22, 'BE', '比利時 (België)', 'Belgium (België)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (23, 'JM', '牙買加 (Jamaica)', 'Jamaica', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (24, 'IL', '以色列 (ישראל)', 'Israel (ישראל)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (25, 'CA', '加拿大 (Canada)', 'Canada', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (26, 'GA', '加彭 (Gabon)', 'Gabon', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (27, 'MP', '北馬里亞納群島 (Northern Mariana Islands)', 'Northern Mariana Islands', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (28, 'KP', '北韓 (조선)', 'North Korea (조선)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (29, 'QA', '卡達 (قطر)', 'Qatar (قطر)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (30, 'CU', '古巴 (Cuba)', 'Cuba', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (31, 'SZ', '史瓦濟蘭 (Swaziland)', 'Swaziland', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (32, 'TW', '台灣', 'Taiwan (台灣)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (33, 'NE', '尼日 (Niger)', 'Niger', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (34, 'NI', '尼加拉瓜 (Nicaragua)', 'Nicaragua', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (35, 'NP', '尼泊爾 (नेपाल)', 'Nepal (नेपाल)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (36, 'BV', '布干維島 (Bouvet Island)', 'Bouvet Island', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (37, 'BF', '布吉納法索 (Burkina Faso)', 'Burkina Faso', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (38, 'GT', '瓜地馬拉 (Guatemala)', 'Guatemala', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (39, 'GP', '瓜達羅普 (Guadeloupe)', 'Guadeloupe', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (40, 'WF', '瓦利斯群島和富圖納群島 (Wallis and Futuna)', 'Wallis and Futuna', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (41, 'GM', '甘比亞 (Gambia)', 'Gambia', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (42, 'BY', '白俄羅斯 (Белару́сь)', 'Belarus (Белару́сь)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (43, 'PN', '皮特康 (Pitcairn)', 'Pitcairn', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (44, 'LT', '立陶宛 (Lietuva)', 'Lithuania (Lietuva)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (45, 'IQ', '伊拉克 (العراق)', 'Iraq (العراق)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (46, 'IR', '伊朗 (ایران)', 'Iran (ایران)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (47, 'IS', '冰島 (Ísland)', 'Iceland (Ísland)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (48, 'LI', '列支敦士登 (Liechtenstein)', 'Liechtenstein', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (49, 'HU', '匈牙利 (Magyarország)', 'Hungary (Magyarország)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (50, 'ID', '印尼 (Indonesia)', 'Indonesia', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (51, 'IN', '印度 (India)', 'India', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (52, 'DJ', '吉布地 (Djibouti)', 'Djibouti', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (53, 'KI', '吉里巴斯 (Kiribati)', 'Kiribati', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (54, 'KG', '吉爾吉斯 (Кыргызстан)', 'Kyrgyzstan (Кыргызстан)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (55, 'DO', '多明尼加共和國 (Dominican Republic)', 'Dominican Republic', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (56, 'DM', '多明尼克 (Dominica)', 'Dominica', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (57, 'TG', '多哥 (Togo)', 'Togo', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (58, 'AG', '安地卡及巴布達 (Antigua and Barbuda)', 'Antigua and Barbuda', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (59, 'AO', '安哥拉 (Angola)', 'Angola', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (60, 'AD', '安道爾共和國 (Andorra)', 'Andorra', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (61, 'AI', '安歸拉島 (Anguilla)', 'Anguilla', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (62, 'TK', '托克勞群島 (Tokelau)', 'Tokelau', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (63, 'BM', '百慕達 (Bermuda)', 'Bermuda', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (64, 'ET', '衣索比亞 (Ityop&#39;iya)', 'Ethiopia (Ityop&#39;iya)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (65, 'ES', '西班牙 (España)', 'Spain (España)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (66, 'EH', '西撒哈拉 (الصحراء الغربية)', 'Western Sahara (الصحراء الغربية)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (67, 'HR', '克羅埃西亞 (Hrvatska)', 'Croatia (Hrvatska)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (68, 'SJ', '冷岸及央棉群島 (Svalbard and Jan Mayen)', 'Svalbard and Jan Mayen', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (69, 'LY', '利比亞 (ليبيا)', 'Libya (ليبيا)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (70, 'HN', '宏都拉斯 (Honduras)', 'Honduras', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (71, 'GR', '希臘 (&#39;Eλλας)', 'Greece (&#39;Eλλας)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (72, 'SA', '沙烏地阿拉伯 (المملكة العربية السعودية)', 'Saudi Arabia (المملكة العربية السعودية)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (73, 'BN', '汶萊 (Brunei Darussalam)', 'Brunei (Brunei Darussalam)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (74, 'BZ', '貝里斯 (Belize)', 'Belize', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (75, 'BJ', '貝南 (Bénin)', 'Benin (Bénin)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (76, 'GQ', '赤道幾內亞 (Guinea Ecuatorial)', 'Equatorial Guinea (Guinea Ecuatorial)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (77, 'ZW', '辛巴威 (Zimbabwe)', 'Zimbabwe', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (78, 'AM', '亞美尼亞 (Հայաստան)', 'Armenia (Հայաստան)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (79, 'AZ', '亞賽拜然 (Azərbaycan)', 'Azerbaijan (Azərbaycan)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (80, 'TZ', '坦尚尼亞 (Tanzania)', 'Tanzania', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (81, 'NG', '奈及利亞 (Nigeria)', 'Nigeria', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (82, 'VE', '委內瑞拉 (Venezuela)', 'Venezuela', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (83, 'BD', '孟加拉 (বাংলাদেশ)', 'Bangladesh (বাংলাদেশ)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (84, 'ZM', '尚比亞 (Zambia)', 'Zambia', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (85, 'PW', '帛琉 (Belau)', 'Palau (Belau)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (86, 'SB', '所羅門群島 (Solomon Islands)', 'Solomon Islands', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (87, 'LV', '拉脫維亞 (Latvija)', 'Latvia (Latvija)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (88, 'TO', '東加 (Tonga)', 'Tonga', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (89, 'TL', '東帝汶 (Timor-Leste)', 'East Timor (Timor-Leste)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (90, 'BA', '波士尼亞-赫塞哥維納 (Bosna i Hercegovina)', 'Bosnia and Herzegovina (Bosna i Hercegovina)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (91, 'BW', '波札那 (Botswana)', 'Botswana', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (92, 'PR', '波多黎克 (Puerto Rico)', 'Puerto Rico', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (93, 'PL', '波蘭 (Polska)', 'Poland (Polska)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (94, 'FR', '法國 (France)', 'France', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (95, 'FO', '法羅群島 (Faroe Islands)', 'Faroe Islands', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (96, 'GF', '法屬圭亞那 (French Guiana)', 'French Guiana', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (97, 'PF', '法屬波里尼西亞 (French Polynesia)', 'French Polynesia', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (98, 'TF', '法屬南部屬地 (French Southern Territories)', 'French Southern Territories', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (99, 'GI', '直布羅陀 (Gibraltar)', 'Gibraltar', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (100, 'KE', '肯亞 (Kenya)', 'Kenya', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (101, 'FI', '芬蘭 (Suomi)', 'Finland (Suomi)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (102, 'AE', '阿拉伯聯合大公國 (الإمارات العربيّة المتّحدة)', 'United Arab Emirates (الإمارات العربيّة المتّحدة)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (103, 'AR', '阿根廷 (Argentina)', 'Argentina', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (104, 'OM', '阿曼 (عمان)', 'Oman (عمان)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (105, 'AF', '阿富汗 (افغانستان)', 'Afghanistan (افغانستان)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (106, 'DZ', '阿爾及利亞 (الجزائر)', 'Algeria (الجزائر)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (107, 'AL', '阿爾巴尼亞 (Shqipëria)', 'Albania (Shqipëria)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (108, 'AW', '阿魯巴島 (Aruba)', 'Aruba', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (109, 'BG', '保加利亞 (България)', 'Bulgaria (България)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (110, 'RU', '俄羅斯 (Россия)', 'Russia (Россия)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (111, 'ZA', '南非 (South Africa)', 'South Africa', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (112, 'GS', '南喬治亞與南桑威奇群島 (South Georgia and the South Sandwich Islands)', 'South Georgia and the South Sandwich Islands', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (113, 'AQ', '南極洲 (Antarctica)', 'Antarctica', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (114, 'KR', '南韓 (한국)', 'South Korea (한국)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (115, 'KZ', '哈薩克 (Қазақстан)', 'Kazakhstan (Қазақстан)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (116, 'KH', '柬埔寨 (Kampuchea)', 'Cambodia (Kampuchea)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (117, 'TD', '查德 (Tchad)', 'Chad (Tchad)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (118, 'BO', '玻利維亞 (Bolivia)', 'Bolivia', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (119, 'CC', '科克群島 (Cocos Islands)', 'Cocos Islands', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (120, 'CK', '科克群島 (Cook Islands)', 'Cook Islands', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (121, 'KW', '科威特 (الكويت)', 'Kuwait (الكويت)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (122, 'KM', '科摩洛 (Comores)', 'Comoros (Comores)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (123, 'TN', '突尼西亞 (تونس)', 'Tunisia (تونس)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (124, 'JO', '約旦 (الاردن)', 'Jordan (الاردن)', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (125, 'US', '美國 (United States)', 'United States', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (126, 'UM', '美屬外部小群島 (United States minor outlying islands)', 'United States minor outlying islands', 0, 0, 1, 1);
INSERT INTO `vm_countrys` VALUES (127, 'VI', '美屬維京群島 (Virgin Islands, U.S.)', 'Virgin Islands, U.S.', 0, 0, 1, 1);

-- ----------------------------
-- Table structure for vm_filmmakers
-- ----------------------------
DROP TABLE IF EXISTS `vm_filmmakers`;
CREATE TABLE `vm_filmmakers`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '演员名',
  `alias` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '别名',
  `profession` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '职业',
  `blood_type` tinyint(5) UNSIGNED NOT NULL COMMENT '血型，A,B,AB,O,E,未知',
  `sex` tinyint(6) UNSIGNED NOT NULL DEFAULT 3 COMMENT '性别，1为男，1为女，3未设置',
  `birthday` int(10) UNSIGNED NOT NULL COMMENT '演员生日',
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '演员国家',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '演员描述',
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片地址',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '电影人基本信息表(包括演员，导演等)' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_filmmakers
-- ----------------------------
INSERT INTO `vm_filmmakers` VALUES (1, 'zhangke', '', '演员/daoyan ', 0, 3, 13546, '成都', '厉害了', '/src/img/861', 1521194204, 1521194204, 2, 1);
INSERT INTO `vm_filmmakers` VALUES (2, '张大可张大可张大可张大可张大可张大可张大可张大可张大可张大可', '', '演员/daoyan ', 0, 3, 213, '眉山', '大眉山', '/src/img?fileId=-1', 1521194204, 1521194204, 2, 1);
INSERT INTO `vm_filmmakers` VALUES (3, '布拉-德皮特', '', '演员', 0, 3, 12321, 'ASDSA', 'ASDSA', '/src/img?fileId=-1', 1521194204, 1521194204, 2, 1);
INSERT INTO `vm_filmmakers` VALUES (4, '周杰伦', 'jack/杰伦周', '中国台湾流行乐男歌手、音乐人、演员、导演、编剧、监制、商人', 0, 3, 12312553, '中国大陆', '周杰伦出生于台湾省新北市，祖籍福建省永春县[24]  。周杰伦4岁的\r\n周杰伦小时候\r\n周杰伦小时候(17张)\r\n 时候，母亲叶惠美把他送到淡江山叶幼儿音乐班学习钢琴[25]  。周杰伦读初中二年级时，他的父母因性格不合离婚，而周杰伦则归母亲叶惠美抚养[26]  。中考时，周杰伦没有考上普通高中；同年，他因为擅长钢琴而被淡江中学第一届音乐班录取。高中毕业以后，他两次报考台北大学音乐系均没有被录取，于是他开始在一家餐馆打工[25]  。', '/src/img?fileId=-1', 1521194204, 1521466645, 2, 1);
INSERT INTO `vm_filmmakers` VALUES (5, '123', '123', '123', 2, 2, 1521002594, '123', '123', NULL, 1521434598, 1521434598, 2, 1);
INSERT INTO `vm_filmmakers` VALUES (6, '123', '123', '123', 2, 2, 1521607407, '123', '132', NULL, 1521434616, 1521434616, 2, 1);
INSERT INTO `vm_filmmakers` VALUES (7, '123', '123', '123', 2, 2, 1521607407, '123', '132', '/src/img/860', 1521434627, 1521434627, 2, 1);
INSERT INTO `vm_filmmakers` VALUES (8, '布拉德·皮特', 'Brad Pitt', '演员', 1, 1, 1519620328, '美国', '1987年，皮特以临时演员的身份参加了他的第一部电影《无主地》的拍摄。1993年，皮特出演《加州杀手》，并凭此片获得威尼斯电影节最佳男演员奖[1]  。1995年，皮特出演《十二只猴子》，并凭借片中的表演获得了奥斯卡最佳男配角奖的提名。', '/src/img/859', 1521434736, 1521814532, 1, 2);
INSERT INTO `vm_filmmakers` VALUES (9, 'zhangke', '123', '123', 2, 2, 1521781494, '123', '123', '/src/img/858', 1521435899, 1521529506, 1, 1);
INSERT INTO `vm_filmmakers` VALUES (10, '张可', '12313', '1231', 6, 2, 1522215221, '3333', '1111', '/src/img/857', 1521437627, 1521438720, 2, 1);
INSERT INTO `vm_filmmakers` VALUES (11, '张大可', '张大可二号', '阿萨', 3, 2, 1520315656, '阿萨', '阿萨达', '/src/img/856', 1521438866, 1521529510, 1, 1);
INSERT INTO `vm_filmmakers` VALUES (12, '安七炫', 'kangta', '我只是个演员', 3, 1, 1521165308, '大韩民国', '大韩民国大韩民国大韩民国', '/src/img/862', 1521510934, 1521783791, 1, 1);
INSERT INTO `vm_filmmakers` VALUES (13, '刘二狗a', '刘二狗二世', '演员', 3, 1, 1520924571, '美国', '星驰 编辑 \n1962年6月22日 香港 中国\n周星驰，1962年6月22日生于香港，祖籍浙江宁波，中国香港演员、导演、编剧、制作人、商人，毕业于无线电视艺员训练班。\n1980年成为丽的电视台的特约演员，从而进入演艺圈。1981年出演个人首部电视剧《IQ成熟时》。1988年将演艺', '/src/img/882', 1521529385, 1521790773, 1, 1);

-- ----------------------------
-- Table structure for vm_movies
-- ----------------------------
DROP TABLE IF EXISTS `vm_movies`;
CREATE TABLE `vm_movies`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
  `alias` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '别名',
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '描述',
  `director_id` bigint(20) UNSIGNED DEFAULT NULL COMMENT '导演id（指向电影人表：vm_filmmakers）',
  `release_time` int(10) UNSIGNED NOT NULL COMMENT '上映时间',
  `score` float(3, 1) UNSIGNED NOT NULL COMMENT '评分',
  `watch_num` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '观看数量',
  `movie_time` int(10) UNSIGNED NOT NULL COMMENT '电影时长',
  `poster_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '播放器显示的图片url',
  `img_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '列表图片url',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '电影表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_movies
-- ----------------------------
INSERT INTO `vm_movies` VALUES (23, '123', '123', '123', 13, 1520243773, 10.0, 0, 123, '/src/img/849', '/src/img/847', 1521194204, 1521788911, 1, 1);
INSERT INTO `vm_movies` VALUES (24, '12313', '123', '123', 8, 1520935198, 10.0, 0, 123, '/src/img/864', '/src/img/852', 1521194400, 1521795019, 1, 1);
INSERT INTO `vm_movies` VALUES (25, 'asdas', '12313', 'asdada阿斯达多', 13, 1520233248, 10.0, 0, 123, '/src/img/868', '/src/img/866', 1521529255, 1521795007, 1, 1);
INSERT INTO `vm_movies` VALUES (26, '绝代无双', '绝代无双2', '绝代无双绝代无双', 8, 1520925071, 10.0, 0, 12, '/src/img/896', '/src/img/885', 1521529881, 1521873835, 2, 1);
INSERT INTO `vm_movies` VALUES (27, '测试1', '12313', '《鬼吹灯之寻龙诀》根据天下霸唱所著盗墓小说《鬼吹灯》的后四部改编而成。是由乌尔善执导的悬疑动作片，陈坤、黄渤、舒淇、杨颖、夏雨领衔主演的一部动作、悬疑电影。该片主要讲述胡八一、王凯旋与Shirley杨再入草原千年古墓发生的故事。该片于2014年8月开机，2015年12月18日上映，以3D、IMAX 3D、ScreenX等多种版本同步上映。 >>>', 11, 1520321636, 10.0, 0, 120, '/src/img/881', '/src/img/877', 1521790466, 1521904469, 2, 1);

-- ----------------------------
-- Table structure for vm_movies_filmmakers_realation
-- ----------------------------
DROP TABLE IF EXISTS `vm_movies_filmmakers_realation`;
CREATE TABLE `vm_movies_filmmakers_realation`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `movie_id` bigint(20) UNSIGNED NOT NULL COMMENT '电影id',
  `filmmaker_id` bigint(20) UNSIGNED NOT NULL COMMENT '电影人id',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 191 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '关系表-电影及其电影人表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_movies_filmmakers_realation
-- ----------------------------
INSERT INTO `vm_movies_filmmakers_realation` VALUES (22, 23, 9, 1521519732, 1521519732, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (23, 23, 11, 1521519732, 1521519732, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (24, 23, 8, 1521519732, 1521519732, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (25, 24, 9, 1521520049, 1521520049, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (26, 24, 11, 1521520049, 1521520049, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (27, 24, 12, 1521520049, 1521520049, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (28, 23, 11, 1521520056, 1521520056, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (29, 24, 11, 1521520061, 1521520061, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (30, 24, 12, 1521520061, 1521520061, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (31, 23, 9, 1521520067, 1521520067, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (32, 24, 11, 1521522052, 1521522052, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (33, 24, 12, 1521522052, 1521522052, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (34, 24, 9, 1521522052, 1521522052, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (35, 23, 9, 1521522065, 1521522065, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (36, 23, 8, 1521522065, 1521522065, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (37, 24, 11, 1521522115, 1521522115, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (38, 24, 9, 1521522115, 1521522115, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (39, 24, 8, 1521522115, 1521522115, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (40, 24, 10, 1521522115, 1521522115, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (41, 24, 11, 1521523826, 1521523826, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (42, 24, 9, 1521523826, 1521523826, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (43, 24, 8, 1521523826, 1521523826, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (44, 24, 10, 1521523826, 1521523826, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (45, 23, 9, 1521523851, 1521523851, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (46, 23, 8, 1521523851, 1521523851, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (47, 23, 9, 1521524581, 1521524581, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (48, 23, 8, 1521524581, 1521524581, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (49, 23, 10, 1521524581, 1521524581, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (50, 24, 9, 1521527974, 1521527974, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (51, 24, 11, 1521527974, 1521527974, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (52, 24, 12, 1521527974, 1521527974, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (53, 24, 8, 1521527974, 1521527974, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (54, 24, 9, 1521528283, 1521528283, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (55, 24, 11, 1521528283, 1521528283, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (56, 24, 8, 1521528283, 1521528283, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (57, 23, 9, 1521528481, 1521528481, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (58, 23, 11, 1521528481, 1521528481, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (59, 23, 8, 1521528481, 1521528481, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (60, 23, 9, 1521528495, 1521528495, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (61, 23, 11, 1521528495, 1521528495, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (62, 23, 8, 1521528495, 1521528495, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (63, 24, 9, 1521528502, 1521528502, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (64, 24, 11, 1521528502, 1521528502, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (65, 24, 8, 1521528502, 1521528502, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (66, 25, 11, 1521529256, 1521529256, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (67, 25, 8, 1521529256, 1521529256, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (68, 25, 9, 1521529256, 1521529256, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (69, 25, 12, 1521529256, 1521529256, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (70, 25, 11, 1521529422, 1521529422, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (71, 25, 8, 1521529422, 1521529422, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (72, 25, 9, 1521529422, 1521529422, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (73, 25, 12, 1521529422, 1521529422, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (74, 25, 13, 1521529422, 1521529422, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (75, 23, 9, 1521529468, 1521529468, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (76, 23, 11, 1521529468, 1521529468, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (77, 23, 8, 1521529468, 1521529468, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (78, 23, 13, 1521529468, 1521529468, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (79, 23, 12, 1521529468, 1521529468, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (80, 26, 9, 1521529881, 1521529881, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (81, 26, 9, 1521550502, 1521550502, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (82, 26, 11, 1521597370, 1521597370, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (83, 26, 13, 1521597370, 1521597370, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (84, 26, 9, 1521597370, 1521597370, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (85, 26, 8, 1521597370, 1521597370, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (86, 26, 12, 1521597370, 1521597370, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (87, 26, 11, 1521775025, 1521775025, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (88, 26, 13, 1521775025, 1521775025, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (89, 26, 9, 1521775025, 1521775025, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (90, 26, 8, 1521775025, 1521775025, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (91, 26, 12, 1521775025, 1521775025, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (97, 25, 11, 1521783592, 1521783592, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (98, 25, 13, 1521783592, 1521783592, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (99, 25, 9, 1521783592, 1521783592, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (100, 25, 8, 1521783592, 1521783592, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (101, 25, 12, 1521783592, 1521783592, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (102, 25, 11, 1521783730, 1521783730, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (103, 25, 13, 1521783730, 1521783730, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (104, 25, 9, 1521783730, 1521783730, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (105, 25, 8, 1521783730, 1521783730, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (106, 25, 12, 1521783730, 1521783730, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (107, 25, 11, 1521785907, 1521785907, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (108, 25, 13, 1521785907, 1521785907, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (109, 25, 9, 1521785907, 1521785907, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (110, 25, 8, 1521785907, 1521785907, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (111, 25, 12, 1521785907, 1521785907, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (112, 25, 11, 1521786269, 1521786269, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (113, 25, 13, 1521786269, 1521786269, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (114, 25, 9, 1521786269, 1521786269, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (115, 25, 8, 1521786269, 1521786269, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (116, 25, 12, 1521786269, 1521786269, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (117, 25, 11, 1521786281, 1521786281, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (118, 25, 13, 1521786281, 1521786281, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (119, 25, 9, 1521786281, 1521786281, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (120, 25, 8, 1521786281, 1521786281, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (121, 25, 12, 1521786281, 1521786281, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (122, 24, 9, 1521786293, 1521786293, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (123, 24, 11, 1521786293, 1521786293, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (124, 24, 8, 1521786293, 1521786293, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (125, 25, 11, 1521786358, 1521786358, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (126, 25, 13, 1521786358, 1521786358, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (127, 25, 9, 1521786358, 1521786358, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (128, 25, 8, 1521786358, 1521786358, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (129, 25, 12, 1521786358, 1521786358, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (130, 26, 11, 1521788539, 1521788539, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (131, 26, 13, 1521788539, 1521788539, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (132, 26, 9, 1521788539, 1521788539, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (133, 26, 8, 1521788539, 1521788539, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (134, 26, 12, 1521788539, 1521788539, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (135, 26, 11, 1521788562, 1521788562, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (136, 26, 13, 1521788562, 1521788562, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (137, 26, 9, 1521788562, 1521788562, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (138, 26, 8, 1521788562, 1521788562, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (139, 26, 12, 1521788562, 1521788562, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (140, 24, 9, 1521788569, 1521788569, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (141, 24, 11, 1521788569, 1521788569, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (142, 24, 8, 1521788569, 1521788569, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (143, 23, 9, 1521788838, 1521788838, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (144, 23, 11, 1521788838, 1521788838, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (145, 23, 8, 1521788838, 1521788838, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (146, 23, 13, 1521788838, 1521788838, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (147, 23, 12, 1521788838, 1521788838, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (148, 26, 11, 1521788886, 1521788886, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (149, 26, 13, 1521788886, 1521788886, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (150, 26, 9, 1521788886, 1521788886, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (151, 26, 8, 1521788886, 1521788886, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (152, 26, 12, 1521788886, 1521788886, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (153, 23, 9, 1521788912, 1521788912, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (154, 23, 11, 1521788912, 1521788912, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (155, 23, 8, 1521788912, 1521788912, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (156, 23, 13, 1521788912, 1521788912, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (157, 23, 12, 1521788912, 1521788912, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (158, 27, 12, 1521790466, 1521790466, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (159, 27, 12, 1521790707, 1521790707, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (160, 27, 12, 1521790724, 1521790724, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (161, 27, 12, 1521790731, 1521790731, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (162, 27, 12, 1521792665, 1521792665, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (163, 26, 11, 1521793854, 1521793854, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (164, 26, 13, 1521793854, 1521793854, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (165, 26, 9, 1521793854, 1521793854, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (166, 26, 8, 1521793854, 1521793854, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (167, 26, 12, 1521793854, 1521793854, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (168, 27, 12, 1521793877, 1521793877, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (169, 25, 11, 1521793888, 1521793888, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (170, 25, 13, 1521793888, 1521793888, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (171, 25, 9, 1521793888, 1521793888, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (172, 25, 8, 1521793888, 1521793888, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (173, 25, 12, 1521793888, 1521793888, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (174, 27, 12, 1521794709, 1521794709, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (175, 27, 12, 1521794997, 1521794997, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (176, 25, 11, 1521795007, 1521795007, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (177, 25, 13, 1521795007, 1521795007, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (178, 25, 9, 1521795007, 1521795007, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (179, 25, 8, 1521795007, 1521795007, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (180, 25, 12, 1521795007, 1521795007, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (181, 24, 9, 1521795019, 1521795019, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (182, 24, 11, 1521795019, 1521795019, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (183, 24, 8, 1521795019, 1521795019, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (184, 27, 12, 1521797952, 1521797952, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (185, 26, 11, 1521873836, 1521873836, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (186, 26, 13, 1521873836, 1521873836, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (187, 26, 9, 1521873836, 1521873836, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (188, 26, 8, 1521873836, 1521873836, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (189, 26, 12, 1521873836, 1521873836, 2, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (190, 27, 12, 1521904469, 1521904469, 2, 1);

-- ----------------------------
-- Table structure for vm_movies_src_version
-- ----------------------------
DROP TABLE IF EXISTS `vm_movies_src_version`;
CREATE TABLE `vm_movies_src_version`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `sharpness` tinyint(2) UNSIGNED NOT NULL COMMENT '清晰度，1代表标清，2代表高清，3代表超清',
  `movie_id` bigint(20) UNSIGNED NOT NULL COMMENT '电影id',
  `weight` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '权重',
  `src_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '资源url',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_movies_src_version
-- ----------------------------
INSERT INTO `vm_movies_src_version` VALUES (1, 1, 1, 1, 1, 1, '/src/video/1', 1, 1);
INSERT INTO `vm_movies_src_version` VALUES (2, 2, 2, 2, 1, 10, '/src/video/1', 1, 1);
INSERT INTO `vm_movies_src_version` VALUES (3, 1521813202, 1521813202, 1, 27, 1, '/src/video/880', 2, 1);
INSERT INTO `vm_movies_src_version` VALUES (4, 1521814263, 1521814263, 1, 26, 1, '/src/video/884', 2, 1);
INSERT INTO `vm_movies_src_version` VALUES (5, 1521902500, 1521902500, 2, 27, 1, '/src/video/888', 2, 1);
INSERT INTO `vm_movies_src_version` VALUES (6, 1521902771, 1521979626, 1, 27, 1, '/src/video/889', 2, 1);
INSERT INTO `vm_movies_src_version` VALUES (7, 1521903536, 1521979490, 2, 27, 1, '/src/video/890', 2, 2);
INSERT INTO `vm_movies_src_version` VALUES (8, 1521903636, 1521979607, 1, 27, 1, '/src/video/891', 2, 1);
INSERT INTO `vm_movies_src_version` VALUES (9, 1521903930, 1521903930, 2, 27, 1, '/src/video/892', 2, 1);
INSERT INTO `vm_movies_src_version` VALUES (10, 1521904095, 1521904095, 2, 27, 1, '/src/video/893', 2, 1);
INSERT INTO `vm_movies_src_version` VALUES (11, 1521904133, 1521904133, 2, 23, 1, '/src/video/894', 1, 1);
INSERT INTO `vm_movies_src_version` VALUES (12, 1521904246, 1521904246, 2, 24, 1, '/src/video/895', 1, 1);
INSERT INTO `vm_movies_src_version` VALUES (13, 1521974204, 1521974204, 2, 27, 1, '/src/video/899', 2, 1);
INSERT INTO `vm_movies_src_version` VALUES (14, 1521979674, 1521979741, 3, 27, 1, '/src/video/900', 2, 1);
INSERT INTO `vm_movies_src_version` VALUES (15, 1521980168, 1521980193, 2, 27, 1, '/src/video/901', 2, 2);

-- ----------------------------
-- Table structure for vm_movies_tags_realation
-- ----------------------------
DROP TABLE IF EXISTS `vm_movies_tags_realation`;
CREATE TABLE `vm_movies_tags_realation`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `movie_id` bigint(20) UNSIGNED NOT NULL COMMENT '电影id',
  `tag_id` bigint(20) UNSIGNED NOT NULL COMMENT '类型id',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 120 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '关系表-电影标签表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_movies_tags_realation
-- ----------------------------
INSERT INTO `vm_movies_tags_realation` VALUES (100, 26, 36, 1521793854, 1521793854, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (101, 27, 35, 1521793877, 1521793877, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (102, 27, 36, 1521793877, 1521793877, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (103, 27, 37, 1521793877, 1521793877, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (104, 27, 38, 1521793877, 1521793877, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (105, 25, 35, 1521793888, 1521793888, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (106, 25, 36, 1521793888, 1521793888, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (107, 27, 35, 1521794709, 1521794709, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (108, 27, 39, 1521794709, 1521794709, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (109, 27, 35, 1521794998, 1521794998, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (110, 27, 39, 1521794998, 1521794998, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (111, 25, 35, 1521795007, 1521795007, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (112, 24, 35, 1521795020, 1521795020, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (113, 24, 39, 1521795020, 1521795020, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (114, 27, 35, 1521797952, 1521797952, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (115, 27, 39, 1521797952, 1521797952, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (116, 26, 35, 1521873836, 1521873836, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (117, 26, 39, 1521873836, 1521873836, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (118, 27, 35, 1521904469, 1521904469, 2, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (119, 27, 39, 1521904469, 1521904469, 2, 1);

-- ----------------------------
-- Table structure for vm_tags
-- ----------------------------
DROP TABLE IF EXISTS `vm_tags`;
CREATE TABLE `vm_tags`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '类型名',
  `tag_group_id` bigint(20) UNSIGNED NOT NULL COMMENT '所属标签组',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '电影标签' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_tags
-- ----------------------------
INSERT INTO `vm_tags` VALUES (1, '港台111', 1, 0, 1521702655, 2, 2);
INSERT INTO `vm_tags` VALUES (2, '大陆a', 1, 0, 1521702664, 2, 1);
INSERT INTO `vm_tags` VALUES (3, '恐怖', 2, 2, 1, 2, 1);
INSERT INTO `vm_tags` VALUES (4, '惊悚', 2, 12, 123, 2, 1);
INSERT INTO `vm_tags` VALUES (5, '欧美a', 1, 54, 1521686797, 2, 1);
INSERT INTO `vm_tags` VALUES (6, '日本', 1, 45, 1521687045, 2, 2);
INSERT INTO `vm_tags` VALUES (7, '韩国', 1, 1, 1, 2, 1);
INSERT INTO `vm_tags` VALUES (8, '印度', 1, 1, 1, 2, 1);
INSERT INTO `vm_tags` VALUES (9, '俄罗斯', 1, 1, 1, 2, 1);
INSERT INTO `vm_tags` VALUES (10, '蒙古', 1, 1, 1, 2, 1);
INSERT INTO `vm_tags` VALUES (11, '非洲1', 1, 1, 1521687039, 2, 1);
INSERT INTO `vm_tags` VALUES (12, '12', 4, 1521612679, 1521612679, 2, 1);
INSERT INTO `vm_tags` VALUES (13, '2018', 4, 1521612730, 1521612730, 2, 1);
INSERT INTO `vm_tags` VALUES (14, 'asdssssssssssssss', 4, 1521615551, 1521615551, 2, 2);
INSERT INTO `vm_tags` VALUES (15, '阿萨', 4, 1521616561, 1521616561, 2, 1);
INSERT INTO `vm_tags` VALUES (16, 'zzz', 4, 1521616571, 1521616571, 2, 1);
INSERT INTO `vm_tags` VALUES (17, 'cccc', 4, 1521616581, 1521616581, 2, 1);
INSERT INTO `vm_tags` VALUES (18, '2018你那', 11, 1521625196, 1521625196, 2, 1);
INSERT INTO `vm_tags` VALUES (19, '123', 11, 1521625569, 1521625569, 2, 1);
INSERT INTO `vm_tags` VALUES (20, '123', 11, 1521682984, 1521682984, 2, 1);
INSERT INTO `vm_tags` VALUES (21, '1231', 11, 1521683020, 1521700078, 2, 2);
INSERT INTO `vm_tags` VALUES (22, '1231', 11, 1521683137, 1521700080, 2, 2);
INSERT INTO `vm_tags` VALUES (23, '12313', 11, 1521683221, 1521700085, 2, 1);
INSERT INTO `vm_tags` VALUES (24, '12313', 10, 1521683235, 1521683235, 2, 1);
INSERT INTO `vm_tags` VALUES (25, '12313', 9, 1521683277, 1521683277, 2, 1);
INSERT INTO `vm_tags` VALUES (26, 'asdad', 10, 1521683665, 1521683665, 2, 1);
INSERT INTO `vm_tags` VALUES (27, 'aa', 11, 1521683785, 1521683785, 2, 1);
INSERT INTO `vm_tags` VALUES (28, '12313', 11, 1521683824, 1521683824, 2, 1);
INSERT INTO `vm_tags` VALUES (29, '1231', 6, 1521683984, 1521683984, 2, 1);
INSERT INTO `vm_tags` VALUES (30, '111', 6, 1521683990, 1521683990, 2, 2);
INSERT INTO `vm_tags` VALUES (31, '23123', 6, 1521683996, 1521683996, 2, 2);
INSERT INTO `vm_tags` VALUES (32, '123', 1, 1521792441, 1521792441, 2, 1);
INSERT INTO `vm_tags` VALUES (33, '美国', 16, 1521792626, 1521792635, 2, 1);
INSERT INTO `vm_tags` VALUES (34, '中国', 16, 1521792650, 1521792650, 2, 1);
INSERT INTO `vm_tags` VALUES (35, '2017', 16, 1521792852, 1521794696, 1, 1);
INSERT INTO `vm_tags` VALUES (36, '中国', 16, 1521792860, 1521792860, 2, 1);
INSERT INTO `vm_tags` VALUES (37, '2018年', 15, 1521792873, 1521792873, 2, 1);
INSERT INTO `vm_tags` VALUES (38, '2019年', 15, 1521792901, 1521792910, 2, 1);
INSERT INTO `vm_tags` VALUES (39, '中国', 17, 1521794691, 1521794691, 1, 1);

-- ----------------------------
-- Table structure for vm_tags_groups
-- ----------------------------
DROP TABLE IF EXISTS `vm_tags_groups`;
CREATE TABLE `vm_tags_groups`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标签组名',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '标签组' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_tags_groups
-- ----------------------------
INSERT INTO `vm_tags_groups` VALUES (1, '地区', 123, 123, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (2, '类xing', 213, 1521609486, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (3, 'A', 1521609757, 1521609757, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (4, '上映时间', 1521609782, 1521609782, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (5, '123', 1521617720, 1521617720, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (6, '12313', 1521617724, 1521617724, 2, 2);
INSERT INTO `vm_tags_groups` VALUES (7, '12313', 1521617728, 1521617728, 2, 2);
INSERT INTO `vm_tags_groups` VALUES (8, '12313', 1521617731, 1521617731, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (9, '111111', 1521617751, 1521617751, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (10, '11111111111', 1521617755, 1521617755, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (11, '我的分组，时尚时尚', 1521617761, 1521699562, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (12, '11', 1521701356, 1521701356, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (13, '11', 1521701437, 1521701437, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (14, '1', 1521714818, 1521714818, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (15, '地区', 1521792537, 1521792889, 2, 1);
INSERT INTO `vm_tags_groups` VALUES (16, '时间', 1521792552, 1521794666, 1, 1);
INSERT INTO `vm_tags_groups` VALUES (17, '地区', 1521794683, 1521794683, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
