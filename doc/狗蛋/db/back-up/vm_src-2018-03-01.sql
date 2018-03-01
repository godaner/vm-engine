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

 Date: 01/03/2018 16:53:40
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
  `size` bigint(20) UNSIGNED DEFAULT NULL COMMENT '图片大小',
  `status` tinyint(5) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态,1为正常，2为冻结，3为删除',
  `create_time` int(10) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` int(10) UNSIGNED NOT NULL COMMENT '更新时间',
  `content_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '文件类型，如video/mp4',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 320 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '文件信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vm_files
-- ----------------------------
INSERT INTO `vm_files` VALUES (1, 'a.png', NULL, NULL, 1, 21, 12, 'image/jped');
INSERT INTO `vm_files` VALUES (2, 'b.png', NULL, NULL, 1, 21, 121, 'image/jped');
INSERT INTO `vm_files` VALUES (3, 'c.png', NULL, NULL, 1, 213, 123, 'image/jped');
INSERT INTO `vm_files` VALUES (4, 'd.png', NULL, NULL, 1, 123, 123, 'image/jped');
INSERT INTO `vm_files` VALUES (5, 'e.png', NULL, NULL, 1, 123, 123, 'image/jped');
INSERT INTO `vm_files` VALUES (6, 'f.png', NULL, NULL, 1, 123, 123, 'image/jped');
INSERT INTO `vm_files` VALUES (7, 'g.png', NULL, NULL, 1, 123, 123, 'image/jped');
INSERT INTO `vm_files` VALUES (8, 'h.png', NULL, NULL, 1, 123, 123, 'image/jped');
INSERT INTO `vm_files` VALUES (9, 'i.png', NULL, NULL, 1, 123, 123, 'image/jped');
INSERT INTO `vm_files` VALUES (10, 'k.png', NULL, NULL, 1, 123, 123, 'image/jped');
INSERT INTO `vm_files` VALUES (33, 'a.mp4', NULL, NULL, 1, 123, 123, 'video/mp4');
INSERT INTO `vm_files` VALUES (34, 'b.mp4', NULL, NULL, 1, 123, 123, 'video/mp4');
INSERT INTO `vm_files` VALUES (35, 'a.mp4', NULL, NULL, 1, 465, 132, 'video/mp4');
INSERT INTO `vm_files` VALUES (36, 'b.mp4', NULL, NULL, 1, 156, 1231, 'video/mp4');
INSERT INTO `vm_files` VALUES (101, 'a.png', NULL, NULL, 1, 156, 465, 'image/jped');
INSERT INTO `vm_files` VALUES (201, 'a.png', NULL, NULL, 1, 1, 1, 'image/jped');
INSERT INTO `vm_files` VALUES (202, 'b.png', NULL, NULL, 1, 1, 1, 'image/jped');
INSERT INTO `vm_files` VALUES (203, 'a1b56415-a232-447e-be57-2b0d3f9fea1a.jpg', '1.jpg', 0, 1, 1515670268, 1515670268, NULL);
INSERT INTO `vm_files` VALUES (204, '99c72576-c135-4946-a209-720883a16583.jpg', '1.jpg', 0, 1, 1515670965, 1515670965, NULL);
INSERT INTO `vm_files` VALUES (205, '4ecc499f-08b4-4aad-b0a7-6c6fdb7beff8.jpg', '1.jpg', 0, 1, 1515670969, 1515670969, NULL);
INSERT INTO `vm_files` VALUES (206, '7aecee06-3f1d-4b9b-b142-fccc43b16681.jpg', '1.jpg', 0, 1, 1515671016, 1515671016, NULL);
INSERT INTO `vm_files` VALUES (207, '1de3a8a3-74de-40ba-a291-f57e4ec837c4.jpg', '1.jpg', 0, 1, 1515671139, 1515671139, NULL);
INSERT INTO `vm_files` VALUES (208, '6c1ac750-8a72-4a44-a2b0-2f34574ee68a.jpg', '1.jpg', 0, 1, 1515676068, 1515676068, NULL);
INSERT INTO `vm_files` VALUES (209, '2189ad4a-470d-4f3a-baa9-e712ee4f6e6d.jpg', '1.jpg', 0, 1, 1515679009, 1515679009, NULL);
INSERT INTO `vm_files` VALUES (210, '03a2ec52-40f4-426f-a070-d830555577b6.jpg', '1.jpg', 0, 1, 1515680614, 1515680614, NULL);
INSERT INTO `vm_files` VALUES (211, '8872e6e7-0810-4d72-8ef7-1de42ca0be6a.png', '1.png', 0, 1, 1515681652, 1515681652, NULL);
INSERT INTO `vm_files` VALUES (212, 'c5ad1ff1-827f-41c3-9311-d71893b85ff0.jpg', '1.jpg', 0, 1, 1515681833, 1515681833, NULL);
INSERT INTO `vm_files` VALUES (213, 'f084deae-b8d9-4ec5-b951-46e7c37a3fd9.png', '1.png', 0, 1, 1515681895, 1515681895, NULL);
INSERT INTO `vm_files` VALUES (214, '4d2b27e9-563a-4a76-afad-7b3b92c678bc.jpg', '1.jpg', 0, 1, 1515682153, 1515682153, NULL);
INSERT INTO `vm_files` VALUES (215, 'f9d2145a-6f7d-44ef-9c90-752a4978d026.png', '1.png', 0, 1, 1515682314, 1515682314, NULL);
INSERT INTO `vm_files` VALUES (216, 'd848b61d-9666-466b-88a2-f73f9dd0e23a.jpg', '1.jpg', 0, 1, 1515682323, 1515682323, NULL);
INSERT INTO `vm_files` VALUES (217, 'fa90cd31-7869-4ba8-bea2-269452b51035.png', '1.png', 0, 1, 1515682342, 1515682342, NULL);
INSERT INTO `vm_files` VALUES (218, 'dffd298e-8f7a-4898-a287-462dbb65b4ac.jpg', '1.jpg', 0, 1, 1515682360, 1515682360, NULL);
INSERT INTO `vm_files` VALUES (219, 'd5fa9a2b-05a7-49bc-a383-e73447da6db2.png', '1.png', 0, 1, 1515682752, 1515682752, NULL);
INSERT INTO `vm_files` VALUES (220, 'd9d12e2b-cb2d-4312-a3d2-13338bfdf7f7.jpg', '1.jpg', 0, 1, 1515682996, 1515682996, NULL);
INSERT INTO `vm_files` VALUES (221, 'ae208591-0990-4202-bed5-19e91d24f47c.', NULL, 0, 1, 1515738525, 1515738525, NULL);
INSERT INTO `vm_files` VALUES (224, '8716d5b5-563d-4103-8c27-2a21700c1ddb.jpg', '1.jpg', 0, 1, 1515739966, 1515739966, NULL);
INSERT INTO `vm_files` VALUES (225, '72c1e062-2581-41e9-830c-f2f08c355046.jpg', '1.jpg', 0, 1, 1515740043, 1515740043, NULL);
INSERT INTO `vm_files` VALUES (226, '1de8e814-e990-403f-bb20-8c8431527b9b.jpg', '1.jpg', 0, 1, 1515740052, 1515740052, NULL);
INSERT INTO `vm_files` VALUES (227, '48a31e48-2951-4038-98e5-d43672c1c6b2.jpg', '1.jpg', 0, 1, 1515740159, 1515740159, NULL);
INSERT INTO `vm_files` VALUES (228, '54dc7cca-ac6f-4b3f-bced-356ebe490085.jpg', '1.jpg', 0, 1, 1515740354, 1515740354, NULL);
INSERT INTO `vm_files` VALUES (229, '86346ecc-3470-4c54-8ed9-5f8cfefbd648.jpg', '1.jpg', 0, 1, 1515740424, 1515740424, NULL);
INSERT INTO `vm_files` VALUES (230, 'c3c6a111-4c9c-4147-b9a6-6e1b08d9ba37.jpg', '1.jpg', 0, 1, 1515740553, 1515740553, NULL);
INSERT INTO `vm_files` VALUES (231, '89730fd3-d2ce-42c4-b49d-cf5586313096.jpg', '1.jpg', 0, 1, 1515740559, 1515740559, NULL);
INSERT INTO `vm_files` VALUES (232, '5928b59e-1923-4dfd-8599-e4b54a3fdc96.jpg', '1.jpg', 0, 1, 1515740562, 1515740562, NULL);
INSERT INTO `vm_files` VALUES (233, 'eaa55f0e-05c1-46dd-b341-9256623bf7d3.jpg', '1.jpg', 0, 1, 1515740578, 1515740578, NULL);
INSERT INTO `vm_files` VALUES (234, 'f33414cf-447c-4f55-bd78-089482167afc.jpg', '1.jpg', 0, 1, 1515740586, 1515740586, NULL);
INSERT INTO `vm_files` VALUES (235, '1fb3521d-afc6-470a-aea4-11fde762df96.png', '1.png', 0, 1, 1515740743, 1515740743, NULL);
INSERT INTO `vm_files` VALUES (236, '53a30161-dc66-4746-9a9c-0ca3a74b0962.jpg', '1.jpg', 0, 1, 1515740773, 1515740773, NULL);
INSERT INTO `vm_files` VALUES (237, 'a55fc417-ec2e-4fbe-96c1-a6934229f55d.jpg', '1.jpg', 0, 1, 1515741633, 1515741633, NULL);
INSERT INTO `vm_files` VALUES (238, 'b025c912-fe7c-41d5-a461-a1bad73a7c69.jpg', '1.jpg', 0, 1, 1515741712, 1515741712, NULL);
INSERT INTO `vm_files` VALUES (239, '078a72ed-07dd-4fc5-8191-98a472561f1d.jpg', '1.jpg', 0, 1, 1515742581, 1515742581, NULL);
INSERT INTO `vm_files` VALUES (240, '1200b097-6e6a-4913-b9cd-8340782acce3.jpg', '1.jpg', 0, 1, 1515742837, 1515742837, NULL);
INSERT INTO `vm_files` VALUES (241, 'd7d0baa1-371f-40d7-8c78-6703f3cf05e2.jpg', '1.jpg', 0, 1, 1515743291, 1515743291, NULL);
INSERT INTO `vm_files` VALUES (242, '80953ed5-16dc-4f18-a89e-644b8b0aaf06.jpg', '1.jpg', 0, 1, 1515743432, 1515743432, NULL);
INSERT INTO `vm_files` VALUES (243, '3cbf52df-02b3-43c2-aa4e-ada2b05f2a62.jpg', '1.jpg', 0, 1, 1515743439, 1515743439, NULL);
INSERT INTO `vm_files` VALUES (244, '762eddc4-b0e0-492b-a207-764bd167c2cc.jpg', '1.jpg', 0, 1, 1515743947, 1515743947, NULL);
INSERT INTO `vm_files` VALUES (245, 'cf06b6e3-4a7b-4075-83cb-13bb3306c544.jpg', '1.jpg', 0, 1, 1515744512, 1515744512, NULL);
INSERT INTO `vm_files` VALUES (246, '61c99bae-e299-4b4f-82ff-2790f2bae139.jpg', '1.jpg', 0, 1, 1515744521, 1515744521, NULL);
INSERT INTO `vm_files` VALUES (247, '8cf922c5-2f67-4553-ba0c-458aa3566205.jpg', '1.jpg', 0, 1, 1515744524, 1515744524, NULL);
INSERT INTO `vm_files` VALUES (248, 'b11c09c0-ce26-4755-a10c-34886c9b0120.jpg', '1.jpg', 0, 1, 1515744526, 1515744526, NULL);
INSERT INTO `vm_files` VALUES (249, 'd021e7fb-4eb2-4c2e-823f-f506c2df76d3.jpg', '1.jpg', 0, 1, 1515744551, 1515744551, NULL);
INSERT INTO `vm_files` VALUES (250, '8422851c-2938-4b53-9d2f-cc81bbba0ae9.jpg', '1.jpg', 0, 1, 1515744812, 1515744812, NULL);
INSERT INTO `vm_files` VALUES (251, '21794b60-8fa1-43d8-bfc8-776e91723965.jpg', '1.jpg', 0, 1, 1515744834, 1515744834, NULL);
INSERT INTO `vm_files` VALUES (252, 'c9d07ccd-95c7-4656-95cd-a18dd6c9bace.jpg', '1.jpg', 0, 1, 1515744950, 1515744950, NULL);
INSERT INTO `vm_files` VALUES (253, 'f604e7da-4960-4025-af3e-d02db0466e3e.jpg', '1.jpg', 0, 1, 1515744971, 1515744971, NULL);
INSERT INTO `vm_files` VALUES (254, '34c054f3-f7de-41b2-aa01-a8d816739dbd.jpg', '1.jpg', 0, 1, 1515747478, 1515747478, NULL);
INSERT INTO `vm_files` VALUES (255, '0aff4258-4abc-497f-8aa2-4f5d72409d36.jpg', '1.jpg', 0, 1, 1515747506, 1515747506, NULL);
INSERT INTO `vm_files` VALUES (256, '5f89493d-d29c-4bcc-9e5e-68f13b2eee4c.jpg', '1.jpg', 0, 1, 1515976877, 1515976877, NULL);
INSERT INTO `vm_files` VALUES (257, '4cf66dcd-9053-4d5c-8c4d-2697aa979edb.jpg', '1.jpg', 0, 1, 1515976900, 1515976900, NULL);
INSERT INTO `vm_files` VALUES (258, 'e54e8341-d39e-409b-9294-5f0e4742eb42.jpg', '1.jpg', 0, 1, 1515982962, 1515982962, NULL);
INSERT INTO `vm_files` VALUES (259, '4ecabf02-fd9a-4138-8432-42f0ccf2fcc5.jpg', '1.jpg', 0, 1, 1515982982, 1515982982, NULL);
INSERT INTO `vm_files` VALUES (260, 'e8e2da8c-5d66-45f1-a6ab-723234730374.jpg', '1.jpg', 0, 1, 1515982994, 1515982994, NULL);
INSERT INTO `vm_files` VALUES (261, 'ff76ea9b-c217-4cbb-a2fa-64b4c0fcd6ed.jpg', '1.jpg', 0, 1, 1515983266, 1515983266, NULL);
INSERT INTO `vm_files` VALUES (262, '0e087190-495a-4929-b0a2-210cd991bc04.jpg', '1.jpg', 0, 1, 1515983898, 1515983898, NULL);
INSERT INTO `vm_files` VALUES (263, '1.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515986773, 1515986773, 'image/jpeg');
INSERT INTO `vm_files` VALUES (264, '1.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989588, 1515989588, 'image/jpeg');
INSERT INTO `vm_files` VALUES (265, '1.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989655, 1515989655, 'image/jpeg');
INSERT INTO `vm_files` VALUES (266, '1.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989741, 1515989741, 'image/jpeg');
INSERT INTO `vm_files` VALUES (267, '1.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989768, 1515989768, 'image/jpeg');
INSERT INTO `vm_files` VALUES (268, '4bda95d7-ddff-43d7-b09c-9f95c742bcec.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989769, 1515989769, 'image/jpeg');
INSERT INTO `vm_files` VALUES (269, '1.jpg', 'u=1579369671,4166587722&fm=200&gp=0.jpg', 14592, 1, 1515989798, 1515989798, 'image/jpeg');
INSERT INTO `vm_files` VALUES (270, '1.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989801, 1515989801, 'image/jpeg');
INSERT INTO `vm_files` VALUES (271, '22207666-7f54-425e-9bd9-f87de5c74f7a.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989803, 1515989803, 'image/jpeg');
INSERT INTO `vm_files` VALUES (272, '1.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989946, 1515989946, 'image/jpeg');
INSERT INTO `vm_files` VALUES (273, '07ac2fbe-dc3e-4996-9b0a-a4e98fb6baa6.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989950, 1515989950, 'image/jpeg');
INSERT INTO `vm_files` VALUES (274, '1.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989957, 1515989957, 'image/jpeg');
INSERT INTO `vm_files` VALUES (275, '2382aaa2-f6f4-4d6d-9eab-4b1fc0440192.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989960, 1515989960, 'image/jpeg');
INSERT INTO `vm_files` VALUES (276, '1.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989963, 1515989963, 'image/jpeg');
INSERT INTO `vm_files` VALUES (277, '785db37b-cae2-4cbf-b54d-4c437ca5b3ec.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1515989966, 1515989966, 'image/jpeg');
INSERT INTO `vm_files` VALUES (278, '1.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1516008496, 1516008496, 'image/jpeg');
INSERT INTO `vm_files` VALUES (279, '11adad2c-f92c-45bc-a6db-7af1e2a3199e.jpg', '4a36acaf2edda3ccd53548ea0be93901203f9223.jpg', 187801, 1, 1516008498, 1516008498, 'image/jpeg');
INSERT INTO `vm_files` VALUES (280, '1.jpg', 'u=2450994032,3525797548&fm=214&gp=0.jpg', 10508, 1, 1516322391, 1516322391, 'image/jpeg');
INSERT INTO `vm_files` VALUES (281, '1.jpg', 'u=2450994032,3525797548&fm=214&gp=0.jpg', 10508, 1, 1516322756, 1516322756, 'image/jpeg');
INSERT INTO `vm_files` VALUES (282, '1.jpg', 'u=2450994032,3525797548&fm=214&gp=0.jpg', 10508, 1, 1516323326, 1516323326, 'image/jpeg');
INSERT INTO `vm_files` VALUES (283, '1.jpg', 'u=1579369671,4166587722&fm=200&gp=0.jpg', 14592, 1, 1516323473, 1516323473, 'image/jpeg');
INSERT INTO `vm_files` VALUES (284, '1.jpg', 'u=2450994032,3525797548&fm=214&gp=0.jpg', 10508, 1, 1516323536, 1516323536, 'image/jpeg');
INSERT INTO `vm_files` VALUES (285, '1.jpg', 'timg.jpg', 71233, 1, 1516323677, 1516323677, 'image/jpeg');
INSERT INTO `vm_files` VALUES (286, '8f0838c5-8a13-494c-a7c2-2165d7226d4f.jpg', 'timg.jpg', 71233, 1, 1516323680, 1516323680, 'image/jpeg');
INSERT INTO `vm_files` VALUES (287, '1.jpg', 'u=2450994032,3525797548&fm=214&gp=0.jpg', 10508, 1, 1516325347, 1516325347, 'image/jpeg');
INSERT INTO `vm_files` VALUES (288, 'df2813b1-4d0e-404e-8652-8b6541a660de.jpg', 'u=2450994032,3525797548&fm=214&gp=0.jpg', 10508, 1, 1516325349, 1516325349, 'image/jpeg');
INSERT INTO `vm_files` VALUES (289, '7f01b270-6af6-4719-b4d1-fa192990586b.png', 'TIM??20180205185501.png', 13660, 1, 1519879567, 1519879567, 'image/png');
INSERT INTO `vm_files` VALUES (290, '1870af2e-4ba6-4d90-9d41-6db66a3b7344.png', 'TIM??20180205185501.png', 13660, 1, 1519879695, 1519879695, 'image/png');
INSERT INTO `vm_files` VALUES (291, '069bbfc6-854a-4524-bb38-afabb27f66ab.png', 'TIM??20180130172320.png', 84130, 1, 1519879844, 1519879844, 'image/png');
INSERT INTO `vm_files` VALUES (292, '3d9d39e1-fe52-459d-bf67-c7608b84e574.png', 'TIM??20180205185501.png', 13660, 1, 1519879947, 1519879947, 'image/png');
INSERT INTO `vm_files` VALUES (293, '31707991-d288-413c-9d37-f12887087a1e.png', 'TIM??20180205185501.png', 13660, 1, 1519880072, 1519880072, 'image/png');
INSERT INTO `vm_files` VALUES (294, 'a16abc3c-9c17-43b5-a7d6-923c57275a0b.png', 'TIM??20180205185501.png', 13660, 1, 1519880091, 1519880091, 'image/png');
INSERT INTO `vm_files` VALUES (295, '74e6186e-87d7-4114-95a5-58434c915676.png', 'TIM??20180205185501.png', 13660, 1, 1519880106, 1519880106, 'image/png');
INSERT INTO `vm_files` VALUES (296, 'b30a5896-3e84-48f4-ad0c-16c2814bed9a.png', 'TIM??20180205185501.png', 13660, 1, 1519881057, 1519881057, 'image/png');
INSERT INTO `vm_files` VALUES (297, 'cc7f77f9-c22d-41f0-a786-653e0d8443b9.png', 'TIM??20180205185501.png', 13660, 1, 1519881302, 1519881302, 'image/png');
INSERT INTO `vm_files` VALUES (298, '26165b41-35db-4e80-9155-d71fcb0f20a4.png', 'TIM??20180224093835.png', 57768, 1, 1519881307, 1519881307, 'image/png');
INSERT INTO `vm_files` VALUES (299, 'b5cb2e35-d948-4ba0-8894-0fb7c812bed8.png', 'TIM??20180207091011.png', 23549, 1, 1519881311, 1519881311, 'image/png');
INSERT INTO `vm_files` VALUES (300, '0b76ead8-0210-4c49-a5e3-ac56ca53406d.png', 'TIM??20180205185501.png', 13660, 1, 1519881809, 1519881809, 'image/png');
INSERT INTO `vm_files` VALUES (301, '9b8c72ae-fa1d-4503-9593-1e213720f44d.png', 'TIM??20180205185501.png', 13660, 1, 1519881996, 1519881996, 'image/png');
INSERT INTO `vm_files` VALUES (302, '740d7079-3240-49fc-b2ab-d4794729460d.png', 'TIM??20180205185501.png', 13660, 1, 1519882320, 1519882320, 'image/png');
INSERT INTO `vm_files` VALUES (303, '84c55d78-3ad4-4b06-bb41-327276d49256.png', 'TIM??20180205185501.png', 13660, 1, 1519882416, 1519882416, 'image/png');
INSERT INTO `vm_files` VALUES (304, '13be5062-5a4b-4695-9aab-ebc39312e38b.png', 'TIM??20180205185501.png', 13660, 1, 1519882924, 1519882924, 'image/png');
INSERT INTO `vm_files` VALUES (305, '17114cab-5f76-40ed-a7e8-3624d6294c08.png', 'TIM??20180205185501.png', 13660, 1, 1519882988, 1519882988, 'image/png');
INSERT INTO `vm_files` VALUES (306, 'a64652da-233b-4272-9dfa-ed506da29129.png', 'TIM??20180205185501.png', 13660, 1, 1519883089, 1519883089, 'image/png');
INSERT INTO `vm_files` VALUES (307, '44801b7d-f221-46f4-9965-5a4eed7e0096.png', 'TIM??20180205185501.png', 13660, 1, 1519883269, 1519883269, 'image/png');
INSERT INTO `vm_files` VALUES (308, '643b5f68-a2d5-421d-9093-90587a07d2cd.png', 'TIM??20180205185501.png', 13660, 1, 1519883269, 1519883269, 'image/png');
INSERT INTO `vm_files` VALUES (309, 'a602261e-6f19-4d6f-9541-568a1e757944.png', 'TIM??20180205185501.png', 13660, 1, 1519883322, 1519883322, 'image/png');
INSERT INTO `vm_files` VALUES (310, '2b23071b-43f1-405a-a3aa-c515e4819bd8.png', 'TIM??20180205185501.png', 13660, 1, 1519883458, 1519883458, 'image/png');
INSERT INTO `vm_files` VALUES (311, '1da90209-985d-4bc9-a03e-84056ebd515e.png', 'TIM??20180205185501.png', 13660, 1, 1519884709, 1519884709, 'image/png');
INSERT INTO `vm_files` VALUES (312, 'f8100d3e-974c-41b3-8269-9c7223c71602.png', 'TIM??20180205185501.png', 13660, 1, 1519885000, 1519885000, 'image/png');
INSERT INTO `vm_files` VALUES (313, '96b07017-e2fa-4fd6-9ad8-d7951e432e10.png', 'TIM??20180205185501.png', 13660, 1, 1519885373, 1519885373, 'image/png');
INSERT INTO `vm_files` VALUES (314, 'c546f16c-ee25-4002-bde6-629206a88dca.png', 'TIM??20180205185501.png', 13660, 1, 1519886512, 1519886512, 'image/png');
INSERT INTO `vm_files` VALUES (315, '48949f17-30e8-440c-bcd3-1993f28fe199.png', 'TIM??20180205185501.png', 13660, 1, 1519887442, 1519887442, 'image/png');
INSERT INTO `vm_files` VALUES (316, 'ad27b3da-6d55-45dd-b86c-05799f42e25d.png', 'TIM??20180205185501.png', 13660, 1, 1519887592, 1519887592, 'image/png');
INSERT INTO `vm_files` VALUES (317, 'fbd5789d-82af-41e3-9435-b6963cdb5859.png', 'TIM??20180205185501.png', 13660, 1, 1519887939, 1519887939, 'image/png');
INSERT INTO `vm_files` VALUES (318, 'd1f6baf8-026e-4f2a-9042-b91c25a8be4c.png', 'TIM??20180205185501.png', 13660, 1, 1519889062, 1519889062, 'image/png');
INSERT INTO `vm_files` VALUES (319, '11f3d282-18a5-468c-b0cc-6c64808aba25.png', 'TIM??20180224093835.png', 57768, 1, 1519889098, 1519889098, 'image/png');

SET FOREIGN_KEY_CHECKS = 1;
