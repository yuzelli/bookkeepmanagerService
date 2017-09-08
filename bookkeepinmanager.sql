/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : bookkeepinmanager

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2017-09-14 09:34:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bookkeep
-- ----------------------------
DROP TABLE IF EXISTS `bookkeep`;
CREATE TABLE `bookkeep` (
  `id` int(10) NOT NULL auto_increment,
  `year` varchar(255) NOT NULL,
  `month` varchar(255) NOT NULL,
  `day` varchar(255) NOT NULL,
  `min` varchar(255) NOT NULL,
  `week` varchar(255) NOT NULL,
  `type_id` varchar(11) NOT NULL,
  `isZhiCu` varchar(255) NOT NULL,
  `money` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(10) NOT NULL auto_increment,
  `u_phone` varchar(11) NOT NULL,
  `u_password` varchar(20) NOT NULL,
  `u_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
