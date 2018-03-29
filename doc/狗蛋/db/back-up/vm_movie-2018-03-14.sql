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

 Date: 14/03/2018 17:23:09
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
  `blood_type` tinyint(5) UNSIGNED NOT NULL COMMENT '血型，1，为未知',
  `constellation` tinyint(5) UNSIGNED NOT NULL COMMENT '星座，1，为未知',
  `sex` tinyint(6) UNSIGNED NOT NULL DEFAULT 3 COMMENT '性别，1为男，1为女，3未设置',
  `birthday` int(10) UNSIGNED NOT NULL COMMENT '演员生日',
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '演员国家',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '演员描述',
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '图片地址',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '电影人基本信息表(包括演员，导演等)' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_filmmakers
-- ----------------------------
INSERT INTO `vm_filmmakers` VALUES (1, 'zhangke', '', '演员/daoyan ', 0, 0, 3, 13546, '成都', '厉害了', '/src/img?fileId=-1', 123, 1233, 1, 1);
INSERT INTO `vm_filmmakers` VALUES (2, '张大可张大可张大可张大可张大可张大可张大可张大可张大可张大可', '', '演员/daoyan ', 0, 0, 3, 213, '眉山', '大眉山', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_filmmakers` VALUES (3, '布拉-德皮特', '', '演员', 0, 0, 3, 12321, 'ASDSA', 'ASDSA', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_filmmakers` VALUES (4, '周杰伦', 'jack/杰伦周', '中国台湾流行乐男歌手、音乐人、演员、导演、编剧、监制、商人', 0, 0, 3, 12312553, '中国大陆', '周杰伦出生于台湾省新北市，祖籍福建省永春县[24]  。周杰伦4岁的\r\n周杰伦小时候\r\n周杰伦小时候(17张)\r\n 时候，母亲叶惠美把他送到淡江山叶幼儿音乐班学习钢琴[25]  。周杰伦读初中二年级时，他的父母因性格不合离婚，而周杰伦则归母亲叶惠美抚养[26]  。中考时，周杰伦没有考上普通高中；同年，他因为擅长钢琴而被淡江中学第一届音乐班录取。高中毕业以后，他两次报考台北大学音乐系均没有被录取，于是他开始在一家餐馆打工[25]  。', '/src/img?fileId=-1', 12312, 123, 1, 1);

-- ----------------------------
-- Table structure for vm_movies
-- ----------------------------
DROP TABLE IF EXISTS `vm_movies`;
CREATE TABLE `vm_movies`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
  `alias` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '别名',
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '描述',
  `director_id` bigint(20) UNSIGNED NOT NULL COMMENT '导演id（指向电影人表：vm_filmmakers）',
  `release_time` int(10) UNSIGNED NOT NULL COMMENT '上映时间',
  `score` float(3, 1) UNSIGNED NOT NULL COMMENT '评分',
  `watch_num` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '观看数量',
  `movie_time` int(10) UNSIGNED NOT NULL COMMENT '电影时长',
  `poster_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '播放器显示的图片url',
  `img_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '列表图片url',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '电影表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_movies
-- ----------------------------
INSERT INTO `vm_movies` VALUES (1, '北京爱上西雅图', '电影aaa', '已在香港立足开馆的叶问（甄子丹 饰）与太太张永成（熊黛林 饰）平静地生活，不料小儿子叶正就读的小学发生了流氓滋扰事件，参与闹事的正是田傲山（梁家仁 饰）昔日的徒弟马鲸笙（谭耀文 饰）。于是叶问带领徒弟徐力（张继聪 饰）等人保护了黄老师（吴千语 饰）、校长（刘以达 饰）以及众小学生，并结识了同样是咏春传人的车夫张天志（张晋 饰），二人惺惺相惜。可是事件却没有止步于此，马鲸笙的老板费兰奇（迈克·泰森 饰）才是幕后黑手，探长肥波（郑则仕 饰）也卷入了其中，与此同时，张天志向叶问发起了谁是“正宗咏春”的挑战，叶问该如何应战？', 2, 1, 9.9, 100, 12312, 'http://mpic.tiankong.com/8e1/58f/8e158fc2b4bb795e202a4f0196bf9cb9/640.jpg', '/src/img?fileId=-1', 1231, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (2, '甲方乙方', 'bbb', '哈哈', 2, 123, 2.0, 1000, 123, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (3, '长龙卧虎', 'asdad', 'asdad', 3, 123, 3.0, 78, 123, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (4, '惊变28周', 'asdad', 'asdad', 2, 123, 3.0, 787, 123, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (5, '天下第一', 'asdad', 'asdad', 2, 123, 3.0, 45, 123, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (6, '庇护', 'asdad', 'asdad', 3, 123, 3.0, 789797, 123, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (7, '山村老尸', 'asdad', 'asdad', 3, 123, 3.0, 877, 123, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (8, '一个勺子', 'asdad', 'asdad', 3, 123, 3.0, 4566, 123, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (9, '甲方乙方', 'asdad', 'asdad', 3, 123, 3.0, 10, 123, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (10, '我的世界', 'asdad', 'asdad', 2, 123, 3.0, 10456, 123, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (11, '惊变28天', 'asdad', 'asdad', 9, 123, 3.0, 4567, 123, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (12, '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', 112, 123, 9.6, 555, 99, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (13, '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', 112, 123, 9.6, 555, 99, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (14, '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', 112, 123, 9.6, 555, 99, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (15, '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', 112, 123, 9.6, 555, 99, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (16, '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', 112, 123, 9.6, 555, 99, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (17, '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', 112, 123, 9.6, 555, 99, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (18, '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', 112, 123, 9.6, 555, 99, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (19, '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', 112, 123, 9.6, 555, 99, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (20, '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', 112, 123, 9.6, 555, 99, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);
INSERT INTO `vm_movies` VALUES (21, '齐天大圣', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', 112, 123, 9.6, 555, 99, '/movie/src/33', '/src/img?fileId=-1', 123, 123, 1, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '关系表-电影及其电影人表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_movies_filmmakers_realation
-- ----------------------------
INSERT INTO `vm_movies_filmmakers_realation` VALUES (1, 1, 1, 1, 1, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (2, 1, 2, 1, 1, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (3, 1, 3, 1, 1, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (4, 3, 1, 1, 1, 1, 1);
INSERT INTO `vm_movies_filmmakers_realation` VALUES (5, 1, 4, 1, 1, 1, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_movies_src_version
-- ----------------------------
INSERT INTO `vm_movies_src_version` VALUES (1, 1, 1, 1, 1, 1, '/src/video/1', 1, 1);
INSERT INTO `vm_movies_src_version` VALUES (2, 2, 2, 2, 1, 10, '/src/video/1', 1, 1);

-- ----------------------------
-- Table structure for vm_movies_tags_realation
-- ----------------------------
DROP TABLE IF EXISTS `vm_movies_tags_realation`;
CREATE TABLE `vm_movies_tags_realation`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '自增主键',
  `movie_id` bigint(20) UNSIGNED NOT NULL COMMENT '电影id',
  `tag_id` bigint(20) UNSIGNED NOT NULL COMMENT '类型id',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为no，2为yes',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '关系表-电影标签表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_movies_tags_realation
-- ----------------------------
INSERT INTO `vm_movies_tags_realation` VALUES (1, 1, 1, 12, 123, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (2, 2, 2, 123, 123, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (3, 3, 3, 123, 123, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (5, 5, 5, 45, 45, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (6, 6, 6, 6, 6, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (7, 7, 7, 7, 7, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (8, 8, 8, 8, 8, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (9, 9, 9, 9, 9, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (10, 10, 10, 10, 10, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (11, 11, 11, 11, 11, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (12, 1, 2, 2, 2, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (15, 1, 5, 5, 5, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (16, 1, 6, 6, 6, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (17, 1, 7, 7, 7, 1, 1);
INSERT INTO `vm_movies_tags_realation` VALUES (18, 1, 8, 8, 8, 1, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '电影标签' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_tags
-- ----------------------------
INSERT INTO `vm_tags` VALUES (1, '港台', 1, 0, 0, 1, 1);
INSERT INTO `vm_tags` VALUES (2, '大陆', 1, 0, 0, 1, 1);
INSERT INTO `vm_tags` VALUES (3, '恐怖', 2, 2, 1, 1, 1);
INSERT INTO `vm_tags` VALUES (4, '惊悚', 2, 12, 123, 1, 1);
INSERT INTO `vm_tags` VALUES (5, '欧美', 1, 54, 45, 1, 1);
INSERT INTO `vm_tags` VALUES (6, '日本', 1, 45, 45, 1, 1);
INSERT INTO `vm_tags` VALUES (7, '韩国', 1, 1, 1, 1, 1);
INSERT INTO `vm_tags` VALUES (8, '印度', 1, 1, 1, 1, 1);
INSERT INTO `vm_tags` VALUES (9, '俄罗斯', 1, 1, 1, 1, 1);
INSERT INTO `vm_tags` VALUES (10, '蒙古', 1, 1, 1, 1, 1);
INSERT INTO `vm_tags` VALUES (11, '非洲', 1, 1, 1, 1, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '标签组' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_tags_groups
-- ----------------------------
INSERT INTO `vm_tags_groups` VALUES (1, '地区', 123, 123, 1, 1);
INSERT INTO `vm_tags_groups` VALUES (2, '类型', 213, 123, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
