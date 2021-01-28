/*
Navicat MySQL Data Transfer

Source Server         : 192.168.150.98
Source Server Version : 80017
Source Host           : 192.168.150.98:3306
Source Database       : z_qds

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2021-01-12 10:21:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', null, '1');
INSERT INTO `dept` VALUES ('2', null, '2');
INSERT INTO `dept` VALUES ('3', '2', '3');
INSERT INTO `dept` VALUES ('4', '2', '4');
INSERT INTO `dept` VALUES ('5', '1', '5');
INSERT INTO `dept` VALUES ('6', '1', '6');
