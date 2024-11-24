/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 24/11/2024 02:25:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(0) NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话',
  `create_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `is_collect` int(0) NULL DEFAULT 1 COMMENT '收藏',
  `image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
  `contact_meiti` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '社交媒体',
  `corporation_phone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '公司电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '张三', 22, '男', '上海市435', '1386767565643', '2024-11-24', '123213324', 2, 'https://dazhiruou-test.oss-cn-chengdu.aliyuncs.com/crudLearning-master/5e7aefe2ccaf4991bb2b5b31f6db6125.jpg', '放到123', '12323422334');
INSERT INTO `user` VALUES (3, '李四', 20, '男', '合肥市', '13978786565', '2020-11-18', NULL, 2, NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, '赵柳', 20, '男', '南京市', '13978786565', '2020-11-18', NULL, 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, '钱望', 22, '男', '深圳市', '13867675656', '2020-11-18', NULL, 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (7, '李云', 20, '男', '合肥市', '13978786565', '2020-11-18', NULL, 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (8, '张傅', 22, '男', '上海市', '13867675656', '2020-11-18', NULL, 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (9, '李青', 20, '男', '合肥市', '13978786565', '2020-11-18', NULL, 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (10, '王二发', 22, '男', '昆明市', '13867675656', '2020-11-18', NULL, 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (12, '王得贵', 22, '男', '成都市', '13867674565', '2020-11-18', NULL, 1, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
