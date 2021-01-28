/*
Navicat MySQL Data Transfer

Source Server         : 192.168.150.98
Source Server Version : 80017
Source Host           : 192.168.150.98:3306
Source Database       : z_qds

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2021-01-12 10:21:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for example
-- ----------------------------
DROP TABLE IF EXISTS `example`;
CREATE TABLE `example` (
  `int` int(11) DEFAULT NULL,
  `varchar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `datetime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of example
-- ----------------------------
INSERT INTO `example` VALUES ('1', '12', '2020-12-23 16:00:32');