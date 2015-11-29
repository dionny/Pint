/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : pintdb

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2015-11-29 01:58:00
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
INSERT INTO `blooddrive` VALUES ('1', '1234 FIU Way', 'Miami', 'We need blood due to the high frequency of accidents in the area.', '2015-12-23', '0', '2015-09-23', 'FL', 'FIU-MMC Blood Drive', '0', '1');
INSERT INTO `blooddrive` VALUES ('2', '1234 FIU Way', 'Miami', 'We need blood and we need it now.', '2015-12-23', '0', '2015-09-23', 'FL', 'FIU-BBC Blood Drive', '0', '2');
INSERT INTO `blooddrive` VALUES ('3', 'Red Cross Way', 'San Francisco', 'Due to a recent earthquake we are in dire need of blood donations.', '2015-12-23', '0', '2015-09-23', 'CA', 'Red Cross Blood Drive', '0', '3');
INSERT INTO `blooddrive` VALUES ('4', 'Index Way', 'Index', 'Due to a recent hurricane we are in need of blood.', '2015-12-23', '0', '2015-09-23', 'WA', 'Index Blood Drive', '0', '5');
INSERT INTO `blooddrive` VALUES ('5', '1234 Infinite Way', 'Miami', 'We need donations for children patients.', '2016-01-13', '0', '2015-12-24', 'FL', 'Miami Children\'s Blood Drive', '0', '4');

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
INSERT INTO `blooddrive_employee` VALUES ('1', '19');
INSERT INTO `blooddrive_employee` VALUES ('2', '24');
INSERT INTO `blooddrive_employee` VALUES ('3', '25');
INSERT INTO `blooddrive_employee` VALUES ('5', '26');
INSERT INTO `blooddrive_employee` VALUES ('4', '27');
INSERT INTO `blooddrive_employee` VALUES ('1', '28');
INSERT INTO `blooddrive_employee` VALUES ('1', '30');
INSERT INTO `blooddrive_employee` VALUES ('1', '32');

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
INSERT INTO `donor` VALUES ('1', 'Miami', 'USA', 'FL', '33165');
INSERT INTO `donor` VALUES ('2', 'Miami', 'USA', 'FL', '33165');
INSERT INTO `donor` VALUES ('3', 'Miami', 'USA', 'FL', '33165');
INSERT INTO `donor` VALUES ('4', 'San Francisco', 'USA', 'CA', '82211');
INSERT INTO `donor` VALUES ('5', 'San Francisco', 'USA', 'CA', '82211');
INSERT INTO `donor` VALUES ('6', 'San Francisco', 'USA', 'CA', '82211');
INSERT INTO `donor` VALUES ('7', 'Atlanta', 'USA', 'GA', '55487');
INSERT INTO `donor` VALUES ('8', 'Atlanta', 'USA', 'GA', '33328');
INSERT INTO `donor` VALUES ('9', 'Index', 'USA', 'WA', '12348');
INSERT INTO `donor` VALUES ('10', 'Index', 'USA', 'WA', '12348');
INSERT INTO `donor` VALUES ('11', 'Index', 'USA', 'WA', '12348');
INSERT INTO `donor` VALUES ('12', 'New York', 'USA', 'NY', '48779');
INSERT INTO `donor` VALUES ('13', 'Dallas', 'USA', 'TX', '77654');

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
INSERT INTO `employee` VALUES ('14', 'Muhammad', 'Hakim', '1231231234', '1');
INSERT INTO `employee` VALUES ('15', 'Dweep', 'Patel', '4231231234', '2');
INSERT INTO `employee` VALUES ('16', 'Michael', 'Harrison', '4231481234', '3');
INSERT INTO `employee` VALUES ('17', 'Eduardo', 'Lopez', '4231671234', '4');
INSERT INTO `employee` VALUES ('18', 'Sandra', 'Jennings', '4212671234', '5');
INSERT INTO `employee` VALUES ('19', 'Gregory', 'Jean-Baptiste', '7861738554', '1');
INSERT INTO `employee` VALUES ('20', 'Diane', 'Patel', '9541778554', '1');
INSERT INTO `employee` VALUES ('21', 'Jan', 'Peas', '3058469514', '1');
INSERT INTO `employee` VALUES ('22', 'Ali', 'Saksh', '7864313245', '1');
INSERT INTO `employee` VALUES ('23', 'Mike', 'Sham', '7812313245', '2');
INSERT INTO `employee` VALUES ('24', 'Ravi', 'David', '783113245', '2');
INSERT INTO `employee` VALUES ('25', 'Katy', 'Perry', '7831663245', '3');
INSERT INTO `employee` VALUES ('26', 'David', 'Jones', '7831633245', '4');
INSERT INTO `employee` VALUES ('27', 'Jennifer', 'Lawrence', '3331633245', '5');
INSERT INTO `employee` VALUES ('28', 'Jenny', 'Smith', '7951738554', '1');
INSERT INTO `employee` VALUES ('29', 'Jennifer', 'James', '1151438615', '1');
INSERT INTO `employee` VALUES ('30', 'Maritza', 'Michaels', '7756638615', '1');
INSERT INTO `employee` VALUES ('31', 'Diana', 'King', '7751488615', '1');
INSERT INTO `employee` VALUES ('32', 'Peter', 'Clarke', '8123911223', '1');
INSERT INTO `employee` VALUES ('33', 'Leonardo', 'Bobadilla', '9451438615', '1');
INSERT INTO `employee` VALUES ('34', 'Amanda', 'Delina', '7951438615', '2');
INSERT INTO `employee` VALUES ('35', 'Linda', 'Spears', '7751788115', '2');
INSERT INTO `employee` VALUES ('36', 'Dionny', 'Santiago', '4584484711', '3');

-- ----------------------------
-- Table structure for hospital
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `hospital_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hospital_name` varchar(200) NOT NULL,
  PRIMARY KEY (`hospital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospital
-- ----------------------------
INSERT INTO `hospital` VALUES ('1', 'FIU-MMC Hospital');
INSERT INTO `hospital` VALUES ('2', 'FIU-BBC Hospital');
INSERT INTO `hospital` VALUES ('3', 'Red Cross Hospital');
INSERT INTO `hospital` VALUES ('4', 'Miami Children\'s Hospital');
INSERT INTO `hospital` VALUES ('5', 'Index Hospital');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notification
-- ----------------------------
INSERT INTO `notification` VALUES ('1', 'We\'ve got some pineapple pizza.', '2015-11-28 01:56:58', 'The pizza is here.', 'FIU-MMC Hospital Notification', '1');
INSERT INTO `notification` VALUES ('2', 'O+ is a rare blood type and we are lacking. Please come and donate.s', '2015-11-28 02:26:58', 'We need O+ blood type.', 'FIU-MMC Hospital Notification', '1');
INSERT INTO `notification` VALUES ('3', 'We are here until 6PM today. Please come by and donate.', '2015-11-28 02:56:58', 'The son of one of our employees needs blood urgently.', 'FIU-MMC Hospital Notification', '1');
INSERT INTO `notification` VALUES ('4', 'We required a lot more blood than originally anticipated.', '2015-11-27 01:56:58', 'We need a lot more blood.', 'Red Cross Notification', '3');
INSERT INTO `notification` VALUES ('5', 'We are very thankful that we met our donation goals yesterday. Now let\'s keep going strong.', '2015-11-28 02:26:58', 'Thank you very much for your donations.', 'Red Cross Notification', '3');
INSERT INTO `notification` VALUES ('6', 'A patient of thrombocytopenia is in a very critical condition and needs A negative blood. Please come and donate.', '2015-11-28 01:56:58', 'We need A- blood.', 'FIU-BBC Notification', '2');
INSERT INTO `notification` VALUES ('7', 'Let\'s get more blood donations.', '2015-11-28 01:56:58', 'We are running out of time!', 'FIU-BBC Notification', '2');
INSERT INTO `notification` VALUES ('8', 'Due to a recent hurricane we are in major need of blood donations. Please come and assist us as soon as possible.', '2015-11-28 01:56:58', 'Hurricane Devistation', 'Index Notification', '4');
INSERT INTO `notification` VALUES ('9', 'Please come and donate to help these patients.', '2015-11-28 01:56:58', 'We are collecting blood for thalassemia patients.', 'Index Notification', '4');

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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$ZbctISQEXWcy3YAPRz8Klunsr8cI.v3SI1DGuglRcaCvT3XeACeTO', 'bpate005@fiu.edu');
INSERT INTO `users` VALUES ('2', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$on4LaueLep3ixtFFc46rQuR391Qmcpa4fSqdkftK0LD2TKxrrVA5y', 'accha004@fiu.edu');
INSERT INTO `users` VALUES ('3', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$LVfsaiC7aG1v6vZzC4nbhO5yR0K0Cm44EjtxQ/bNeev8l7/1o4bkC', 'jliu005@fiu.edu');
INSERT INTO `users` VALUES ('4', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$42/.wHLkx4DV56QZ6V3bxOea61RWML3vc00Vz4sZWbqggmFWPUKZa', 'calvin121@fiu.edu');
INSERT INTO `users` VALUES ('5', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$gTfy7pPktqA9VTukwCMYC.vAQKkZ7yskjC4N42TolX5Vo1ryzhtAy', 'frank004@fiu.edu');
INSERT INTO `users` VALUES ('6', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$aUvdZiDFkug3o3rjs6mqZ.SHkBIn51HiiM7P.Osj6Oe8X2qybLVMC', 'ruby009@fiu.edu');
INSERT INTO `users` VALUES ('7', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$L8lM1fc2kI/TGDz37BIe7esJhjjLt8jpWaT2cCc99njxc2TqxlS/.', 'cora337@fiu.edu');
INSERT INTO `users` VALUES ('8', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$4CqGA1AwW0LV.74v7.PVA.FxVkInilNaL/kLiuuQvWBE.LyGQEo72', 'jan008@fiu.edu');
INSERT INTO `users` VALUES ('9', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$nlnSRzsFwjFNYSQG7XMhturSE0wXfDdTirKBK.xQO6sIqUHqFsDsm', 'Xuejiao@gmail.com');
INSERT INTO `users` VALUES ('10', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$.dWG8uUckrL7vUTlvh34d.IJBKdq1WMBT3fryVOIrwgIQvKSOX8fu', 'Azizul@gmail.com');
INSERT INTO `users` VALUES ('11', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$dWAK5FcNLtrfkvrPhHQCrerexWuFkmbOkXy.EXq7XIfoOiJzGUj5W', 'xliu002@fiu.edu');
INSERT INTO `users` VALUES ('12', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$pmPvEKXyfkzr7oybcmc9nueG6D4TAwxFhGw0.RwxRxhEpcLXlffWy', 'dolly999@fiu.edu');
INSERT INTO `users` VALUES ('13', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$6mLhCTYNHyfwQ2SiItfyFOBxKvf3GuorY27uWg0hjeBaODp05Su7W', 'david888@gmail.com');
INSERT INTO `users` VALUES ('14', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$e01cHDnKBESrOWVfIy7OieX76nQ9OA3UmGo19OzB75.gxHFV7Wmym', 'mhaki005@pint.edu');
INSERT INTO `users` VALUES ('15', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$00l.sEeu8qY.DfrDkCZLsejsyO.zeZHkbXraw.RzbiPhsMwZuDTGm', 'dpatel001@pint.edu');
INSERT INTO `users` VALUES ('16', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$VSD2yMrvD1kVJIuD6Z4aa.LXvJBVwHroYsTLPaJkumowWtcJm4VFG', 'mharr001@pint.edu');
INSERT INTO `users` VALUES ('17', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$XrOCKRRp7K/Pucw3mFOTNue3dviu1S5l834tiN7PLINBbJ6vVE6ra', 'edulop@pint.edu');
INSERT INTO `users` VALUES ('18', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$K9iia11SOV8OkRf6lOAdE.aVYsKWKVGDlpodaVFCDWFhAOLSU.TwC', 'sandra@pint.edu');
INSERT INTO `users` VALUES ('19', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$/aY5HQoL5IuwuoyCkCCC8OJPPGierPlYGjhhL5zCJiZxWb0qjKLp.', 'Greg001@pint.edu');
INSERT INTO `users` VALUES ('20', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$CNkYoaw5V.PVCpYp.EsMD.OV1hftppbT2yqdr/UmjTVcJRYL388B.', 'dpatel@pint.edu');
INSERT INTO `users` VALUES ('21', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$OrxNe.4J0XKE5Swi1DOGS.fPgZfsUk3lQGa80e.W2W9drbtOKLcNi', 'jpea006@gmail.edu');
INSERT INTO `users` VALUES ('22', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$BRL52k3QfhMU741NLc5Nc.V63VN5w6i.GU4sFr7vOsotCRdDiUgUG', 'asaks004@fiu.edu');
INSERT INTO `users` VALUES ('23', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$uFmPJVtHXJCjc3HvE2fMheQJeFV65zCL.mLIuWCEyadrqJj2RVg9m', 'msham001@pint.edu');
INSERT INTO `users` VALUES ('24', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$mIZljIJ3TmfHR9NVSBnR2./Ucmz0g2THN7eM0fjES1YkE1emOLwyi', 'rdavi006@pint.edu');
INSERT INTO `users` VALUES ('25', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$tdy4n/auqhKGv4.ZJAhRA.3RlLOIV9ie3bzYpmX0Cky4MdfcMrdUO', 'kperr@pint.edu');
INSERT INTO `users` VALUES ('26', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$d9cXAMfs6Xs08ox97quJOugGOFXmYsVP3lO6yel/xObou5uW1lyRK', 'djone@pint.edu');
INSERT INTO `users` VALUES ('27', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$8IhlY/f.HO7dUxcUZqIjwuS3UktGPrAVoamWfwhhRv.6EMPw4Xx9.', 'jlaw@pint.edu');
INSERT INTO `users` VALUES ('28', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$Jqujpwm7//xePqJlmIbRdegb5O5kl1Q1glDA7zLdZ67sG.9Cnxx4e', 'jenny@pint.edu');
INSERT INTO `users` VALUES ('29', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$Bsb66ZIl8AW1LJxlNjC48.ASWTTGZWZ2QrI.KchBHY8Bkry9YTQOS', 'jennifer@pint.edu');
INSERT INTO `users` VALUES ('30', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$/QkjxwwIAzWxXtuS4jCiXeSDz8B19uJtgYh1JXQuQ7.YmyD24T9eK', 'maritza@pint.edu');
INSERT INTO `users` VALUES ('31', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$XXRemrWZcqsQq0JOy1bg9ejK6pOR9x8dFa0Od6D26GmDYUWmEH0/i', 'diana@pint.edu');
INSERT INTO `users` VALUES ('32', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$6b/9cYmE6grVivnZ7bGwC.dLtzF8FnigOxh7tl7RTyPGhOC6G1E5y', 'clarke@pint.edu');
INSERT INTO `users` VALUES ('33', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$Ls5N8q5/X65F3D1Eq/dz4eZZ6oOx0hpatvyq9k4Q7z2jRPrgS/gRe', 'leonardo@pint.edu');
INSERT INTO `users` VALUES ('34', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$dehCMKDc1xGzpdEG.OkeneCWMK1JfkDC6U0JpFFqzr7c45g6ly/GS', 'adelina@pint.edu');
INSERT INTO `users` VALUES ('35', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$demAUpWyj9FEDRZkakR.Muazzcb0XX5rPcVj94xz4vJzKgmiSbfMS', 'linda@pint.edu');
INSERT INTO `users` VALUES ('36', '\0', '\0', '\0', '\0', '0', null, '3', '$2a$10$NsTxOd06eqWkLTxutMoDiOwFFxND7pioDAzixAPIVlljvsKK2efNG', 'dionny@pint.edu');

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
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '1');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '2');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '3');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '4');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '5');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '6');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '7');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '8');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '9');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '10');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '11');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '12');
INSERT INTO `user_authority` VALUES ('ROLE_DONOR', '13');
INSERT INTO `user_authority` VALUES ('ROLE_MANAGER', '14');
INSERT INTO `user_authority` VALUES ('ROLE_MANAGER', '15');
INSERT INTO `user_authority` VALUES ('ROLE_MANAGER', '16');
INSERT INTO `user_authority` VALUES ('ROLE_MANAGER', '17');
INSERT INTO `user_authority` VALUES ('ROLE_MANAGER', '18');
INSERT INTO `user_authority` VALUES ('ROLE_COORDINATOR', '19');
INSERT INTO `user_authority` VALUES ('ROLE_COORDINATOR', '20');
INSERT INTO `user_authority` VALUES ('ROLE_COORDINATOR', '21');
INSERT INTO `user_authority` VALUES ('ROLE_COORDINATOR', '22');
INSERT INTO `user_authority` VALUES ('ROLE_COORDINATOR', '23');
INSERT INTO `user_authority` VALUES ('ROLE_COORDINATOR', '24');
INSERT INTO `user_authority` VALUES ('ROLE_COORDINATOR', '25');
INSERT INTO `user_authority` VALUES ('ROLE_COORDINATOR', '26');
INSERT INTO `user_authority` VALUES ('ROLE_COORDINATOR', '27');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '28');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '29');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '30');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '31');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '32');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '33');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '34');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '35');
INSERT INTO `user_authority` VALUES ('ROLE_NURSE', '36');

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_notification
-- ----------------------------
INSERT INTO `user_notification` VALUES ('1', '\0', '1', '1');
INSERT INTO `user_notification` VALUES ('2', '\0', '2', '1');
INSERT INTO `user_notification` VALUES ('3', '\0', '3', '1');
INSERT INTO `user_notification` VALUES ('4', '\0', '1', '2');
INSERT INTO `user_notification` VALUES ('5', '\0', '2', '2');
INSERT INTO `user_notification` VALUES ('6', '\0', '3', '2');
INSERT INTO `user_notification` VALUES ('7', '\0', '1', '3');
INSERT INTO `user_notification` VALUES ('8', '\0', '2', '3');
INSERT INTO `user_notification` VALUES ('9', '\0', '3', '3');
INSERT INTO `user_notification` VALUES ('10', '\0', '1', '6');
INSERT INTO `user_notification` VALUES ('11', '\0', '2', '6');
INSERT INTO `user_notification` VALUES ('12', '\0', '3', '6');
INSERT INTO `user_notification` VALUES ('13', '\0', '1', '7');
INSERT INTO `user_notification` VALUES ('14', '\0', '2', '7');
INSERT INTO `user_notification` VALUES ('15', '\0', '3', '7');
INSERT INTO `user_notification` VALUES ('16', '\0', '4', '4');
INSERT INTO `user_notification` VALUES ('17', '\0', '5', '4');
INSERT INTO `user_notification` VALUES ('18', '\0', '6', '4');
INSERT INTO `user_notification` VALUES ('19', '\0', '4', '5');
INSERT INTO `user_notification` VALUES ('20', '\0', '5', '5');
INSERT INTO `user_notification` VALUES ('21', '\0', '6', '5');
INSERT INTO `user_notification` VALUES ('22', '\0', '9', '8');
INSERT INTO `user_notification` VALUES ('23', '\0', '10', '8');
INSERT INTO `user_notification` VALUES ('24', '\0', '11', '8');
INSERT INTO `user_notification` VALUES ('25', '\0', '9', '9');
INSERT INTO `user_notification` VALUES ('26', '\0', '10', '9');
INSERT INTO `user_notification` VALUES ('27', '\0', '11', '9');
