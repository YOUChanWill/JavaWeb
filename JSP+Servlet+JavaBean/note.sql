/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50736
Source Host           : 192.168.122.132:3307
Source Database       : Object

Target Server Type    : MYSQL
Target Server Version : 50736
File Encoding         : 65001

Date: 2022-12-02 18:54:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `username` varchar(255) CHARACTER SET utf8 NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `purview` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=ucs2;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('user3', 'user3', 'user3 public note', '1');
INSERT INTO `note` VALUES ('user1', '星期四', '疯狂星期四v我50.', '1');
INSERT INTO `note` VALUES ('张三', '网页设计', '10个页面+js+css', '0');
INSERT INTO `note` VALUES ('张三', '求助', '今天星期四，谁请我吃', '1');
