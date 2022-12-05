/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50736
Source Host           : 192.168.122.132:3307
Source Database       : Object

Target Server Type    : MYSQL
Target Server Version : 50736
File Encoding         : 65001

Date: 2022-12-02 18:56:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_pk` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123');
INSERT INTO `user` VALUES ('2', 'user1', '123');
INSERT INTO `user` VALUES ('3', 'user2', '123');
INSERT INTO `user` VALUES ('4', 'user3', '123');
INSERT INTO `user` VALUES ('6', '张三', '123');
