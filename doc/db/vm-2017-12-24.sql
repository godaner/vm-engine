/*
Navicat MySQL Data Transfer

Source Server         : 120.78.191.94-root
Source Server Version : 50633
Source Host           : 120.78.191.94:3306
Source Database       : vm

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-12-24 16:14:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for vm_admins
-- ----------------------------
DROP TABLE IF EXISTS `vm_admins`;
CREATE TABLE `vm_admins` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '唯一用户名',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码，md5加密',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='后端管理员表';

-- ----------------------------
-- Records of vm_admins
-- ----------------------------
INSERT INTO `vm_admins` VALUES ('1', 'aaa', 'aaaa', '1', '1', '1');
INSERT INTO `vm_admins` VALUES ('6', 'AAA', 'a', '1', '1', '1');

-- ----------------------------
-- Table structure for vm_admins_login_logs
-- ----------------------------
DROP TABLE IF EXISTS `vm_admins_login_logs`;
CREATE TABLE `vm_admins_login_logs` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `admin_id` bigint(20) unsigned NOT NULL COMMENT '登录的管理员id',
  `login_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登录ip',
  `system` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '电脑系统',
  `dpi` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '电脑分辨率',
  `brower` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '使用的浏览器',
  `country` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登录国家',
  `province` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登录省份',
  `city` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '登录城市',
  `login_time` int(6) unsigned NOT NULL COMMENT '登陆时间',
  `result` tinyint(5) unsigned NOT NULL COMMENT '登录结果，1位成功，2位失败',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='后端管理员登录表';

-- ----------------------------
-- Records of vm_admins_login_logs
-- ----------------------------

-- ----------------------------
-- Table structure for vm_countrys
-- ----------------------------
DROP TABLE IF EXISTS `vm_countrys`;
CREATE TABLE `vm_countrys` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `name_chinese` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `name_english` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='国家表';

-- ----------------------------
-- Records of vm_countrys
-- ----------------------------
INSERT INTO `vm_countrys` VALUES ('1', '00', '未知的國家', 'Unknown Country', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('2', 'TT', '千里達與托貝哥共和國 (Trinidad and Tobago)', 'Trinidad and Tobago', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('3', 'TV', '土瓦魯 (Tuvalu)', 'Tuvalu', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('4', 'TR', '土耳其 (Türkiye)', 'Turkey (Türkiye)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('5', 'TM', '土庫曼 (Türkmenistan)', 'Turkmenistan (Türkmenistan)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('6', 'BT', '不丹 (འབྲུག་ཡུལ)', 'Bhutan (འབྲུག་ཡུལ)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('7', 'CF', '中非共和國 (République Centrafricaine)', 'Central African Republic (République Centrafricaine)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('8', 'CN', '中國 (中国)', 'China (中国)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('9', 'DK', '丹麥 (Danmark)', 'Denmark (Danmark)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('10', 'EC', '厄瓜多 (Ecuador)', 'Ecuador', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('11', 'ER', '厄利垂亞 (Ertra)', 'Eritrea (Ertra)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('12', 'PG', '巴布亞紐幾內亞 (Papua New Guinea)', 'Papua New Guinea', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('13', 'BR', '巴西 (Brasil)', 'Brazil (Brasil)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('14', 'BB', '巴貝多 (Barbados)', 'Barbados', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('15', 'PY', '巴拉圭 (Paraguay)', 'Paraguay', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('16', 'BH', '巴林 (البحرين)', 'Bahrain (البحرين)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('17', 'BS', '巴哈馬 (Bahamas)', 'Bahamas', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('18', 'PA', '巴拿馬 (Panamá)', 'Panama (Panamá)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('19', 'PS', '巴勒斯坦領土 (Palestinian Territory)', 'Palestinian Territory', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('20', 'PK', '巴基斯坦 (پاکستان)', 'Pakistan (پاکستان)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('21', 'JP', '日本', 'Japan (日本)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('22', 'BE', '比利時 (België)', 'Belgium (België)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('23', 'JM', '牙買加 (Jamaica)', 'Jamaica', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('24', 'IL', '以色列 (ישראל)', 'Israel (ישראל)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('25', 'CA', '加拿大 (Canada)', 'Canada', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('26', 'GA', '加彭 (Gabon)', 'Gabon', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('27', 'MP', '北馬里亞納群島 (Northern Mariana Islands)', 'Northern Mariana Islands', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('28', 'KP', '北韓 (조선)', 'North Korea (조선)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('29', 'QA', '卡達 (قطر)', 'Qatar (قطر)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('30', 'CU', '古巴 (Cuba)', 'Cuba', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('31', 'SZ', '史瓦濟蘭 (Swaziland)', 'Swaziland', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('32', 'TW', '台灣', 'Taiwan (台灣)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('33', 'NE', '尼日 (Niger)', 'Niger', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('34', 'NI', '尼加拉瓜 (Nicaragua)', 'Nicaragua', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('35', 'NP', '尼泊爾 (नेपाल)', 'Nepal (नेपाल)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('36', 'BV', '布干維島 (Bouvet Island)', 'Bouvet Island', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('37', 'BF', '布吉納法索 (Burkina Faso)', 'Burkina Faso', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('38', 'GT', '瓜地馬拉 (Guatemala)', 'Guatemala', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('39', 'GP', '瓜達羅普 (Guadeloupe)', 'Guadeloupe', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('40', 'WF', '瓦利斯群島和富圖納群島 (Wallis and Futuna)', 'Wallis and Futuna', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('41', 'GM', '甘比亞 (Gambia)', 'Gambia', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('42', 'BY', '白俄羅斯 (Белару́сь)', 'Belarus (Белару́сь)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('43', 'PN', '皮特康 (Pitcairn)', 'Pitcairn', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('44', 'LT', '立陶宛 (Lietuva)', 'Lithuania (Lietuva)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('45', 'IQ', '伊拉克 (العراق)', 'Iraq (العراق)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('46', 'IR', '伊朗 (ایران)', 'Iran (ایران)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('47', 'IS', '冰島 (Ísland)', 'Iceland (Ísland)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('48', 'LI', '列支敦士登 (Liechtenstein)', 'Liechtenstein', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('49', 'HU', '匈牙利 (Magyarország)', 'Hungary (Magyarország)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('50', 'ID', '印尼 (Indonesia)', 'Indonesia', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('51', 'IN', '印度 (India)', 'India', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('52', 'DJ', '吉布地 (Djibouti)', 'Djibouti', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('53', 'KI', '吉里巴斯 (Kiribati)', 'Kiribati', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('54', 'KG', '吉爾吉斯 (Кыргызстан)', 'Kyrgyzstan (Кыргызстан)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('55', 'DO', '多明尼加共和國 (Dominican Republic)', 'Dominican Republic', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('56', 'DM', '多明尼克 (Dominica)', 'Dominica', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('57', 'TG', '多哥 (Togo)', 'Togo', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('58', 'AG', '安地卡及巴布達 (Antigua and Barbuda)', 'Antigua and Barbuda', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('59', 'AO', '安哥拉 (Angola)', 'Angola', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('60', 'AD', '安道爾共和國 (Andorra)', 'Andorra', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('61', 'AI', '安歸拉島 (Anguilla)', 'Anguilla', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('62', 'TK', '托克勞群島 (Tokelau)', 'Tokelau', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('63', 'BM', '百慕達 (Bermuda)', 'Bermuda', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('64', 'ET', '衣索比亞 (Ityop&#39;iya)', 'Ethiopia (Ityop&#39;iya)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('65', 'ES', '西班牙 (España)', 'Spain (España)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('66', 'EH', '西撒哈拉 (الصحراء الغربية)', 'Western Sahara (الصحراء الغربية)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('67', 'HR', '克羅埃西亞 (Hrvatska)', 'Croatia (Hrvatska)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('68', 'SJ', '冷岸及央棉群島 (Svalbard and Jan Mayen)', 'Svalbard and Jan Mayen', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('69', 'LY', '利比亞 (ليبيا)', 'Libya (ليبيا)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('70', 'HN', '宏都拉斯 (Honduras)', 'Honduras', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('71', 'GR', '希臘 (&#39;Eλλας)', 'Greece (&#39;Eλλας)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('72', 'SA', '沙烏地阿拉伯 (المملكة العربية السعودية)', 'Saudi Arabia (المملكة العربية السعودية)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('73', 'BN', '汶萊 (Brunei Darussalam)', 'Brunei (Brunei Darussalam)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('74', 'BZ', '貝里斯 (Belize)', 'Belize', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('75', 'BJ', '貝南 (Bénin)', 'Benin (Bénin)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('76', 'GQ', '赤道幾內亞 (Guinea Ecuatorial)', 'Equatorial Guinea (Guinea Ecuatorial)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('77', 'ZW', '辛巴威 (Zimbabwe)', 'Zimbabwe', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('78', 'AM', '亞美尼亞 (Հայաստան)', 'Armenia (Հայաստան)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('79', 'AZ', '亞賽拜然 (Azərbaycan)', 'Azerbaijan (Azərbaycan)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('80', 'TZ', '坦尚尼亞 (Tanzania)', 'Tanzania', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('81', 'NG', '奈及利亞 (Nigeria)', 'Nigeria', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('82', 'VE', '委內瑞拉 (Venezuela)', 'Venezuela', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('83', 'BD', '孟加拉 (বাংলাদেশ)', 'Bangladesh (বাংলাদেশ)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('84', 'ZM', '尚比亞 (Zambia)', 'Zambia', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('85', 'PW', '帛琉 (Belau)', 'Palau (Belau)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('86', 'SB', '所羅門群島 (Solomon Islands)', 'Solomon Islands', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('87', 'LV', '拉脫維亞 (Latvija)', 'Latvia (Latvija)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('88', 'TO', '東加 (Tonga)', 'Tonga', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('89', 'TL', '東帝汶 (Timor-Leste)', 'East Timor (Timor-Leste)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('90', 'BA', '波士尼亞-赫塞哥維納 (Bosna i Hercegovina)', 'Bosnia and Herzegovina (Bosna i Hercegovina)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('91', 'BW', '波札那 (Botswana)', 'Botswana', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('92', 'PR', '波多黎克 (Puerto Rico)', 'Puerto Rico', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('93', 'PL', '波蘭 (Polska)', 'Poland (Polska)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('94', 'FR', '法國 (France)', 'France', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('95', 'FO', '法羅群島 (Faroe Islands)', 'Faroe Islands', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('96', 'GF', '法屬圭亞那 (French Guiana)', 'French Guiana', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('97', 'PF', '法屬波里尼西亞 (French Polynesia)', 'French Polynesia', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('98', 'TF', '法屬南部屬地 (French Southern Territories)', 'French Southern Territories', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('99', 'GI', '直布羅陀 (Gibraltar)', 'Gibraltar', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('100', 'KE', '肯亞 (Kenya)', 'Kenya', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('101', 'FI', '芬蘭 (Suomi)', 'Finland (Suomi)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('102', 'AE', '阿拉伯聯合大公國 (الإمارات العربيّة المتّحدة)', 'United Arab Emirates (الإمارات العربيّة المتّحدة)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('103', 'AR', '阿根廷 (Argentina)', 'Argentina', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('104', 'OM', '阿曼 (عمان)', 'Oman (عمان)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('105', 'AF', '阿富汗 (افغانستان)', 'Afghanistan (افغانستان)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('106', 'DZ', '阿爾及利亞 (الجزائر)', 'Algeria (الجزائر)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('107', 'AL', '阿爾巴尼亞 (Shqipëria)', 'Albania (Shqipëria)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('108', 'AW', '阿魯巴島 (Aruba)', 'Aruba', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('109', 'BG', '保加利亞 (България)', 'Bulgaria (България)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('110', 'RU', '俄羅斯 (Россия)', 'Russia (Россия)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('111', 'ZA', '南非 (South Africa)', 'South Africa', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('112', 'GS', '南喬治亞與南桑威奇群島 (South Georgia and the South Sandwich Islands)', 'South Georgia and the South Sandwich Islands', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('113', 'AQ', '南極洲 (Antarctica)', 'Antarctica', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('114', 'KR', '南韓 (한국)', 'South Korea (한국)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('115', 'KZ', '哈薩克 (Қазақстан)', 'Kazakhstan (Қазақстан)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('116', 'KH', '柬埔寨 (Kampuchea)', 'Cambodia (Kampuchea)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('117', 'TD', '查德 (Tchad)', 'Chad (Tchad)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('118', 'BO', '玻利維亞 (Bolivia)', 'Bolivia', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('119', 'CC', '科克群島 (Cocos Islands)', 'Cocos Islands', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('120', 'CK', '科克群島 (Cook Islands)', 'Cook Islands', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('121', 'KW', '科威特 (الكويت)', 'Kuwait (الكويت)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('122', 'KM', '科摩洛 (Comores)', 'Comoros (Comores)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('123', 'TN', '突尼西亞 (تونس)', 'Tunisia (تونس)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('124', 'JO', '約旦 (الاردن)', 'Jordan (الاردن)', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('125', 'US', '美國 (United States)', 'United States', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('126', 'UM', '美屬外部小群島 (United States minor outlying islands)', 'United States minor outlying islands', '1', '0', '0');
INSERT INTO `vm_countrys` VALUES ('127', 'VI', '美屬維京群島 (Virgin Islands, U.S.)', 'Virgin Islands, U.S.', '1', '0', '0');

-- ----------------------------
-- Table structure for vm_files
-- ----------------------------
DROP TABLE IF EXISTS `vm_files`;
CREATE TABLE `vm_files` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `fileName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '图片名,如a.png',
  `originalName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '文件原名',
  `size` bigint(20) unsigned DEFAULT NULL COMMENT '图片大小',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文件信息表';

-- ----------------------------
-- Records of vm_files
-- ----------------------------
INSERT INTO `vm_files` VALUES ('1', 'a.png', null, null, '1', '21', '12');
INSERT INTO `vm_files` VALUES ('2', 'b.png', null, null, '1', '21', '121');
INSERT INTO `vm_files` VALUES ('3', 'c.png', null, null, '1', '213', '123');
INSERT INTO `vm_files` VALUES ('4', 'd.png', null, null, '1', '123', '123');
INSERT INTO `vm_files` VALUES ('5', 'e.png', null, null, '1', '123', '123');
INSERT INTO `vm_files` VALUES ('6', 'f.png', null, null, '1', '123', '123');
INSERT INTO `vm_files` VALUES ('7', 'g.png', null, null, '1', '123', '123');
INSERT INTO `vm_files` VALUES ('8', 'h.png', null, null, '1', '123', '123');
INSERT INTO `vm_files` VALUES ('9', 'i.png', null, null, '1', '123', '123');
INSERT INTO `vm_files` VALUES ('10', 'k.png', null, null, '1', '123', '123');
INSERT INTO `vm_files` VALUES ('33', 'a.mp4', null, null, '1', '123', '123');
INSERT INTO `vm_files` VALUES ('34', 'b.mp4', null, null, '1', '123', '123');
INSERT INTO `vm_files` VALUES ('35', 'c.mp4', null, null, '1', '465', '132');

-- ----------------------------
-- Table structure for vm_filmmakers
-- ----------------------------
DROP TABLE IF EXISTS `vm_filmmakers`;
CREATE TABLE `vm_filmmakers` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '演员名',
  `alias` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '别名',
  `profession` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '职业',
  `blood_type` tinyint(5) unsigned NOT NULL COMMENT '血型，1，为未知',
  `constellation` tinyint(5) unsigned NOT NULL COMMENT '星座，1，为未知',
  `sex` tinyint(6) unsigned NOT NULL DEFAULT '3' COMMENT '性别，1为男，1为女，3未设置',
  `birthday` int(10) unsigned NOT NULL COMMENT '演员生日',
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '演员国家',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '演员描述',
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '图片地址',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='电影人基本信息表(包括演员，导演等)';

-- ----------------------------
-- Records of vm_filmmakers
-- ----------------------------
INSERT INTO `vm_filmmakers` VALUES ('1', 'zhangke', '', '', '0', '0', '3', '13546', '成都', '厉害了', '', '1', '123', '1233');
INSERT INTO `vm_filmmakers` VALUES ('2', '张大可', '', '', '0', '0', '3', '213', '眉山', '大眉山', '', '1', '123', '123');
INSERT INTO `vm_filmmakers` VALUES ('3', '布拉-德皮特', '', '', '0', '0', '3', '12321', 'ASDSA', 'ASDSA', '', '1', '123', '123');
INSERT INTO `vm_filmmakers` VALUES ('4', 'ABD', '', '', '0', '0', '3', '123123', '1231', '12321', '', '1', '12312', '123');

-- ----------------------------
-- Table structure for vm_movies
-- ----------------------------
DROP TABLE IF EXISTS `vm_movies`;
CREATE TABLE `vm_movies` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
  `alias` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '别名',
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '描述',
  `director_id` bigint(20) unsigned NOT NULL COMMENT '导演id（指向电影人表：vm_filmmakers）',
  `release_time` int(10) unsigned NOT NULL COMMENT '上映时间',
  `score` float(3,1) unsigned NOT NULL COMMENT '评分',
  `watch_num` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '观看数量',
  `movie_time` int(10) unsigned NOT NULL COMMENT '电影时长',
  `src_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '资源url',
  `img_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '图片url',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='电影表';

-- ----------------------------
-- Records of vm_movies
-- ----------------------------
INSERT INTO `vm_movies` VALUES ('1', '北京爱上西雅图', '电影aaa', '已在香港立足开馆的叶问（甄子丹 饰）与太太张永成（熊黛林 饰）平静地生活，不料小儿子叶正就读的小学发生了流氓滋扰事件，参与闹事的正是田傲山（梁家仁 饰）昔日的徒弟马鲸笙（谭耀文 饰）。于是叶问带领徒弟徐力（张继聪 饰）等人保护了黄老师（吴千语 饰）、校长（刘以达 饰）以及众小学生，并结识了同样是咏春传人的车夫张天志（张晋 饰），二人惺惺相惜。可是事件却没有止步于此，马鲸笙的老板费兰奇（迈克·泰森 饰）才是幕后黑手，探长肥波（郑则仕 饰）也卷入了其中，与此同时，张天志向叶问发起了谁是“正宗咏春”的挑战，叶问该如何应战？', '1', '1', '1.0', '100', '12312', '/movie/src/35', '/movie/img/1', '1', '1231', '123');
INSERT INTO `vm_movies` VALUES ('2', '甲方乙方', 'bbb', '哈哈', '2', '123', '2.0', '1000', '123', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('3', '长龙卧虎', 'asdad', 'asdad', '3', '123', '3.0', '78', '123', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('4', '惊变28周', 'asdad', 'asdad', '2', '123', '3.0', '787', '123', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('5', '天下第一', 'asdad', 'asdad', '2', '123', '3.0', '45', '123', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('6', '庇护', 'asdad', 'asdad', '3', '123', '3.0', '789797', '123', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('7', '山村老尸', 'asdad', 'asdad', '3', '123', '3.0', '877', '123', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('8', '一个勺子', 'asdad', 'asdad', '3', '123', '3.0', '4566', '123', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('9', '甲方乙方', 'asdad', 'asdad', '3', '123', '3.0', '10', '123', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('10', '我的世界', 'asdad', 'asdad', '2', '123', '3.0', '10456', '123', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('11', '惊变28天', 'asdad', 'asdad', '9', '123', '3.0', '4567', '123', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('12', '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', '112', '123', '9.6', '555', '99', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('13', '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', '112', '123', '9.6', '555', '99', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('14', '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', '112', '123', '9.6', '555', '99', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('15', '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', '112', '123', '9.6', '555', '99', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('16', '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', '112', '123', '9.6', '555', '99', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('17', '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', '112', '123', '9.6', '555', '99', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('18', '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', '112', '123', '9.6', '555', '99', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('19', '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', '112', '123', '9.6', '555', '99', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('20', '地球停转之日', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', '112', '123', '9.6', '555', '99', '/movie/src/33', '/movie/img/1', '1', '123', '123');
INSERT INTO `vm_movies` VALUES ('21', '齐天大圣', '地球停转之日/地球停转之日', '地球停转之日地球停转之日', '112', '123', '9.6', '555', '99', '/movie/src/33', '/movie/img/1', '1', '123', '123');

-- ----------------------------
-- Table structure for vm_movies_filmmakers_realation
-- ----------------------------
DROP TABLE IF EXISTS `vm_movies_filmmakers_realation`;
CREATE TABLE `vm_movies_filmmakers_realation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `movie_id` bigint(20) unsigned NOT NULL COMMENT '电影id',
  `filmmaker_id` bigint(20) unsigned NOT NULL COMMENT '电影人id',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='关系表-电影及其电影人表';

-- ----------------------------
-- Records of vm_movies_filmmakers_realation
-- ----------------------------
INSERT INTO `vm_movies_filmmakers_realation` VALUES ('1', '1', '1', '1', '1', '1');
INSERT INTO `vm_movies_filmmakers_realation` VALUES ('2', '1', '2', '1', '1', '1');
INSERT INTO `vm_movies_filmmakers_realation` VALUES ('3', '1', '3', '1', '1', '1');
INSERT INTO `vm_movies_filmmakers_realation` VALUES ('4', '3', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for vm_movies_tags_realation
-- ----------------------------
DROP TABLE IF EXISTS `vm_movies_tags_realation`;
CREATE TABLE `vm_movies_tags_realation` (
  `id` bigint(20) unsigned NOT NULL COMMENT '自增主键',
  `movie_id` bigint(20) unsigned NOT NULL COMMENT '电影id',
  `tag_id` bigint(20) unsigned NOT NULL COMMENT '类型id',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='关系表-电影标签表';

-- ----------------------------
-- Records of vm_movies_tags_realation
-- ----------------------------
INSERT INTO `vm_movies_tags_realation` VALUES ('1', '1', '1', '1', '12', '123');
INSERT INTO `vm_movies_tags_realation` VALUES ('2', '2', '2', '1', '123', '123');
INSERT INTO `vm_movies_tags_realation` VALUES ('3', '3', '3', '1', '123', '123');
INSERT INTO `vm_movies_tags_realation` VALUES ('4', '4', '4', '1', '123', '123');
INSERT INTO `vm_movies_tags_realation` VALUES ('5', '5', '5', '1', '45', '45');
INSERT INTO `vm_movies_tags_realation` VALUES ('6', '6', '6', '1', '6', '6');
INSERT INTO `vm_movies_tags_realation` VALUES ('7', '7', '7', '1', '7', '7');
INSERT INTO `vm_movies_tags_realation` VALUES ('8', '8', '8', '1', '8', '8');
INSERT INTO `vm_movies_tags_realation` VALUES ('9', '9', '9', '1', '9', '9');
INSERT INTO `vm_movies_tags_realation` VALUES ('10', '10', '10', '1', '10', '10');
INSERT INTO `vm_movies_tags_realation` VALUES ('11', '11', '11', '1', '11', '11');
INSERT INTO `vm_movies_tags_realation` VALUES ('12', '1', '2', '1', '2', '2');
INSERT INTO `vm_movies_tags_realation` VALUES ('13', '1', '3', '1', '1', '1');
INSERT INTO `vm_movies_tags_realation` VALUES ('14', '1', '4', '1', '1', '1');
INSERT INTO `vm_movies_tags_realation` VALUES ('15', '1', '5', '1', '5', '5');
INSERT INTO `vm_movies_tags_realation` VALUES ('16', '1', '6', '1', '6', '6');
INSERT INTO `vm_movies_tags_realation` VALUES ('17', '1', '7', '1', '7', '7');
INSERT INTO `vm_movies_tags_realation` VALUES ('18', '1', '8', '1', '8', '8');

-- ----------------------------
-- Table structure for vm_tags
-- ----------------------------
DROP TABLE IF EXISTS `vm_tags`;
CREATE TABLE `vm_tags` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '类型名',
  `tag_group_id` bigint(20) unsigned NOT NULL COMMENT '所属标签组',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='电影标签';

-- ----------------------------
-- Records of vm_tags
-- ----------------------------
INSERT INTO `vm_tags` VALUES ('1', '港台', '1', '1', '0', '0');
INSERT INTO `vm_tags` VALUES ('2', '大陆', '1', '1', '0', '0');
INSERT INTO `vm_tags` VALUES ('3', '恐怖', '2', '1', '2', '1');
INSERT INTO `vm_tags` VALUES ('4', '惊悚', '2', '1', '12', '123');
INSERT INTO `vm_tags` VALUES ('5', '欧美', '1', '1', '54', '45');
INSERT INTO `vm_tags` VALUES ('6', '日本', '1', '1', '45', '45');
INSERT INTO `vm_tags` VALUES ('7', '韩国', '1', '1', '1', '1');
INSERT INTO `vm_tags` VALUES ('8', '印度', '1', '1', '1', '1');
INSERT INTO `vm_tags` VALUES ('9', '俄罗斯', '1', '1', '1', '1');
INSERT INTO `vm_tags` VALUES ('10', '蒙古', '1', '1', '1', '1');
INSERT INTO `vm_tags` VALUES ('11', '非洲', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for vm_tags_groups
-- ----------------------------
DROP TABLE IF EXISTS `vm_tags_groups`;
CREATE TABLE `vm_tags_groups` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标签组名',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='标签组';

-- ----------------------------
-- Records of vm_tags_groups
-- ----------------------------
INSERT INTO `vm_tags_groups` VALUES ('1', '地区', '1', '123', '123');
INSERT INTO `vm_tags_groups` VALUES ('2', '类型', '1', '213', '123');

-- ----------------------------
-- Table structure for vm_users
-- ----------------------------
DROP TABLE IF EXISTS `vm_users`;
CREATE TABLE `vm_users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '唯一用户名',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码，md5加密',
  `sex` tinyint(1) unsigned NOT NULL DEFAULT '3' COMMENT '性别，1为男，1为女，3未设置',
  `birthday` int(10) unsigned NOT NULL COMMENT '用户生日',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '' COMMENT '用户描述',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='前端用户表';

-- ----------------------------
-- Records of vm_users
-- ----------------------------
INSERT INTO `vm_users` VALUES ('1', 'config', 'asdad', '1', '20171128', '', '1', '0', '0');
INSERT INTO `vm_users` VALUES ('2', 'asda', 'config', '1', '1512013538', '厉害了', '1', '1512013538', '1512013538');
INSERT INTO `vm_users` VALUES ('3', 'asda', 'config', '1', '1512016833', '厉害了', '1', '1512016833', '1512016833');
INSERT INTO `vm_users` VALUES ('4', 'asda', 'config', '1', '1512017199', '厉害了', '1', '1512017199', '1512017199');
INSERT INTO `vm_users` VALUES ('5', 'asda', 'config', '1', '1512017436', '厉害了', '1', '1512017436', '1512017436');
INSERT INTO `vm_users` VALUES ('6', 'asda', 'config', '1', '1512105885', '厉害了', '1', '1512105885', '1512105885');
INSERT INTO `vm_users` VALUES ('7', 'asda', 'config', '1', '1512105907', '厉害了', '1', '1512105907', '1512105907');
INSERT INTO `vm_users` VALUES ('8', 'asda', 'config', '1', '1512105916', '厉害了', '1', '1512105916', '1512105916');
INSERT INTO `vm_users` VALUES ('9', 'asda', 'config', '1', '1512105944', '厉害了', '1', '1512105944', '1512105944');
INSERT INTO `vm_users` VALUES ('10', 'asda', 'config', '1', '1512105987', '厉害了', '1', '1512105987', '1512105987');
INSERT INTO `vm_users` VALUES ('11', 'asda', 'config', '1', '1512106011', '厉害了', '1', '1512106011', '1512106011');
INSERT INTO `vm_users` VALUES ('12', 'asda', 'config', '1', '1512106044', '厉害了', '1', '1512106044', '1512106044');
INSERT INTO `vm_users` VALUES ('13', 'asda', 'config', '1', '1512106146', '厉害了', '1', '1512106146', '1512106146');
INSERT INTO `vm_users` VALUES ('14', 'asda', 'config', '1', '1512106191', '厉害了', '1', '1512106191', '1512106191');

-- ----------------------------
-- Table structure for vm_users_login_logs
-- ----------------------------
DROP TABLE IF EXISTS `vm_users_login_logs`;
CREATE TABLE `vm_users_login_logs` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `login_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登录ip',
  `system` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '电脑系统',
  `dpi` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '电脑分辨率',
  `brower` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '使用的浏览器',
  `country` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登录国家',
  `province` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登录省份',
  `city` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '登录城市',
  `login_time` int(6) unsigned NOT NULL COMMENT '登陆时间',
  `result` tinyint(5) unsigned NOT NULL COMMENT '登录结果，1位成功，2位失败',
  `status` tinyint(5) unsigned NOT NULL DEFAULT '1' COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `update_time` int(10) unsigned NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='前端用户登录记录';

-- ----------------------------
-- Records of vm_users_login_logs
-- ----------------------------
