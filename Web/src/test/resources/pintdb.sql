/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : pintdb

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2015-11-28 22:06:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blooddrive
-- ----------------------------
DROP TABLE IF EXISTS `blooddrive`;
CREATE TABLE `blooddrive` (
  `blood_drive_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(300) NOT NULL,
  `city` varchar(50) NOT NULL,
  `description` varchar(500) NOT NULL,
  `end_time` date NOT NULL,
  `number_of_donors` int(11) NOT NULL,
  `start_time` date NOT NULL,
  `state` varchar(50) NOT NULL,
  `title` varchar(200) NOT NULL,
  `zip` int(11) NOT NULL,
  `hospital_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`blood_drive_id`),
  KEY `FK_ryp5sxhswyhg5ul9d95cpapji` (`hospital_id`),
  CONSTRAINT `FK_ryp5sxhswyhg5ul9d95cpapji` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`hospital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blooddrive
-- ----------------------------
INSERT INTO `blooddrive` VALUES ('1', '1234 FIU Way', 'Miami', 'We need blood due to the high frequency of accidents in the area.', '2015-12-08', '1', '2015-11-18', 'FL', 'FIU Blood Drive', '0', '1');
INSERT INTO `blooddrive` VALUES ('2', '1234 Maidique Way', 'Miami', 'We\'re all about the pizza.', '2015-12-13', '0', '2015-11-23', 'FL', 'FIU-MMC Blood Drive', '0', '1');
INSERT INTO `blooddrive` VALUES ('3', '1234 Red Way', 'Miami', 'We need blood due to the high frequency of accidents in the area.', '2015-12-23', '0', '2015-12-05', 'FL', 'Red Cross Blood Drive', '0', '1');
INSERT INTO `blooddrive` VALUES ('4', '1234 Infinite Way', 'Miami', 'We need donations for children patients.', '2016-01-12', '0', '2015-12-23', 'FL', 'Miami Children\'s Blood Drive', '0', '1');
INSERT INTO `blooddrive` VALUES ('5', '1234 Homestead Way', 'Homestead', 'We are at the heart of homestead.', '2015-12-01', '0', '2015-11-03', 'FL', 'Homestead Blood Drive', '0', '1');

-- ----------------------------
-- Table structure for blooddrive_employee
-- ----------------------------
DROP TABLE IF EXISTS `blooddrive_employee`;
CREATE TABLE `blooddrive_employee` (
  `blood_drive_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`blood_drive_id`,`user_id`),
  KEY `FK_1b3766qayag5m5annc5wijq34` (`user_id`),
  CONSTRAINT `FK_1b3766qayag5m5annc5wijq34` FOREIGN KEY (`user_id`) REFERENCES `employee` (`user_id`),
  CONSTRAINT `FK_2b4owfqmbx2jnm2g1la564sni` FOREIGN KEY (`blood_drive_id`) REFERENCES `blooddrive` (`blood_drive_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blooddrive_employee
-- ----------------------------
INSERT INTO `blooddrive_employee` VALUES ('1', '2');
INSERT INTO `blooddrive_employee` VALUES ('2', '2');
INSERT INTO `blooddrive_employee` VALUES ('3', '2');
INSERT INTO `blooddrive_employee` VALUES ('4', '2');
INSERT INTO `blooddrive_employee` VALUES ('5', '2');
INSERT INTO `blooddrive_employee` VALUES ('1', '3');

-- ----------------------------
-- Table structure for donor
-- ----------------------------
DROP TABLE IF EXISTS `donor`;
CREATE TABLE `donor` (
  `user_id` bigint(20) NOT NULL,
  `city` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `zip` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of donor
-- ----------------------------
INSERT INTO `donor` VALUES ('6', 'Miami', 'USA', 'FL', '33165');
INSERT INTO `donor` VALUES ('7', 'Homestead', 'USA', 'FL', '33135');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `user_id` bigint(20) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `hospital_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_tc2131dn11w4e4l7qyo41m074` (`hospital_id`),
  CONSTRAINT `FK_tc2131dn11w4e4l7qyo41m074` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`hospital_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'Dionny', 'Santiago', '555-555-5551', '1');
INSERT INTO `employee` VALUES ('2', 'Gregory', 'Jean-Baptiste', '555-555-5551', '1');
INSERT INTO `employee` VALUES ('3', 'Anjli', 'Chhatwani', '555-555-5551', '1');
INSERT INTO `employee` VALUES ('4', 'Dweep', 'Patel', '555-555-5551', '1');
INSERT INTO `employee` VALUES ('5', 'Azizul', 'Hakim', '555-555-5551', '1');
INSERT INTO `employee` VALUES ('8', 'Sajib', 'Talukder', '555-555-5551', '2');
INSERT INTO `employee` VALUES ('9', 'Peter', 'Clarke', '555-555-5551', '2');

-- ----------------------------
-- Table structure for hospital
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `hospital_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hospital_name` varchar(200) NOT NULL,
  PRIMARY KEY (`hospital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospital
-- ----------------------------
INSERT INTO `hospital` VALUES ('1', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('2', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('3', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('4', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('5', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('6', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('7', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('8', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('9', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('10', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('11', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('12', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('13', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('14', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('15', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('16', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('17', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('18', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('19', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('20', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('21', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('22', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('23', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('24', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('25', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('26', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('27', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('28', 'Baptist Hospital');
INSERT INTO `hospital` VALUES ('29', 'FIU Hospital');
INSERT INTO `hospital` VALUES ('30', 'Baptist Hospital');

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `notification_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `long_description` varchar(500) NOT NULL,
  `sent_time` datetime NOT NULL,
  `short_description` varchar(200) NOT NULL,
  `title` varchar(200) NOT NULL,
  `blood_drive_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`notification_id`),
  KEY `FK_fs7wfe2rq9xn0hurqeo0edhmo` (`blood_drive_id`),
  CONSTRAINT `FK_fs7wfe2rq9xn0hurqeo0edhmo` FOREIGN KEY (`blood_drive_id`) REFERENCES `blooddrive` (`blood_drive_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notification
-- ----------------------------
INSERT INTO `notification` VALUES ('1', 'We\'ve got some pineapple pizza.', '2015-11-27 20:36:51', 'The pizza is here.', 'FIU Hospital Notification', '1');
INSERT INTO `notification` VALUES ('2', 'We\'ve got a little bit of pineapple pizza.', '2015-11-27 21:06:51', 'The pizza is half gone.', 'FIU Hospital Notification', '1');
INSERT INTO `notification` VALUES ('3', 'But we still need blood.', '2015-11-27 21:36:51', 'The pizza is completely gone.', 'FIU Hospital Notification', '1');
INSERT INTO `notification` VALUES ('4', 'We required a lot more blood than originally anticipated.', '2015-11-26 20:36:51', 'We need a lot more blood.', 'Red Cross Notification', '2');
INSERT INTO `notification` VALUES ('5', 'We are very thankful that we met our donation goals yesterday. Now let\'s keep going strong.', '2015-11-27 21:06:51', 'Thank you very much for your donations.', 'Red Cross Notification', '2');
INSERT INTO `notification` VALUES ('6', 'Let\'s get more blood donations.', '2015-11-27 20:36:51', 'We are running out of time!', 'Homestead Notification', '5');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_enabled` bit(1) NOT NULL,
  `account_expired` bit(1) NOT NULL,
  `account_locked` bit(1) NOT NULL,
  `credentials_expired` bit(1) NOT NULL,
  `fail_counter` int(11) NOT NULL,
  `first_fail_time` datetime DEFAULT NULL,
  `max_failures` int(11) NOT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$5N1L6nD99NUq0aQZd//ZluN0FldoPwYvqtCXxSY95ZDKXcxV3HaAq', 'manager');
INSERT INTO `users` VALUES ('2', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$bUvxEqhag4TDRskJji2IS.SllbRlASUGmezKCLZmaMXF5kz/hrodu', 'coordinator');
INSERT INTO `users` VALUES ('3', '\0', '\0', '\0', '\0', '0', '2015-11-25 21:27:35', '3', '$2a$10$CRjFmn60QuQq7QeYSVtEFO45ypq2pFzVgA4sQ6RmMcueqzcOeL/xS', 'nurse');
INSERT INTO `users` VALUES ('4', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$vGBgjq68acpFIb00em1sq.UExAmmRBKB4eQCsJRVAjt/IAM.kjtcW', 'nurse2');
INSERT INTO `users` VALUES ('5', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$sh5a9okvnH3JP/vtMRetaeUrSzUqnpphlPopA70KATdnjMXT5k8s2', 'nurse3');
INSERT INTO `users` VALUES ('6', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$f8z4KOGiWPpeCJFd0/m8IucnlxMGycWdCCZ6xszGq/hK/irhg1Wv2', 'donor');
INSERT INTO `users` VALUES ('7', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$Lo9GQHHI9DWXkFmzwSRH/OdH/Q2f66/qyGDJ4dsBW74r4CLqVTb2e', 'donor2');
INSERT INTO `users` VALUES ('8', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$buXgqTZzFntuoQkIhrl1kOg9i/hJelRHDKNVHxe05Ua6bjWmc6wjC', 'h2nurse1');
INSERT INTO `users` VALUES ('9', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$gPzArnJEk6AWT/ycEvV5OunYFpKWmMR7ic9b0MIw0UxNl6bvPXHwu', 'h2nurse2');

-- ----------------------------
-- Table structure for user_authority
-- ----------------------------
DROP TABLE IF EXISTS `user_authority`;
CREATE TABLE `user_authority` (
  `authority` varchar(255) NOT NULL,
  `user` bigint(20) NOT NULL,
  PRIMARY KEY (`user`,`authority`),
  CONSTRAINT `FK_pkonk86q1byx1npopbfk61jlr` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_authority
-- ----------------------------
INSERT INTO `user_authority` VALUES ('ROLE_MANAGER', '1');
INSERT INTO `user_authority` VALUES ('ROLE_COORDINATOR', '2');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '3');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '4');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '5');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '6');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '7');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '8');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '9');

-- ----------------------------
-- Table structure for user_notification
-- ----------------------------
DROP TABLE IF EXISTS `user_notification`;
CREATE TABLE `user_notification` (
  `user_notification_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `has_seen` bit(1) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `notification_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_notification_id`),
  KEY `FK_hrv2lmyjlt3ken6hk2f4sg1e` (`user_id`),
  KEY `FK_57br8073hgsj70sww9gwv88to` (`notification_id`),
  CONSTRAINT `FK_57br8073hgsj70sww9gwv88to` FOREIGN KEY (`notification_id`) REFERENCES `notification` (`notification_id`),
  CONSTRAINT `FK_hrv2lmyjlt3ken6hk2f4sg1e` FOREIGN KEY (`user_id`) REFERENCES `donor` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_notification
-- ----------------------------
INSERT INTO `user_notification` VALUES ('1', '\0', '6', '1');
INSERT INTO `user_notification` VALUES ('2', '\0', '6', '2');
INSERT INTO `user_notification` VALUES ('3', '\0', '6', '3');
INSERT INTO `user_notification` VALUES ('4', '\0', '6', '4');
INSERT INTO `user_notification` VALUES ('5', '\0', '6', '5');
INSERT INTO `user_notification` VALUES ('6', '\0', '7', '6');
