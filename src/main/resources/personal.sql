/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.6.17-log : Database - personal
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`personal` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `personal`;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `create_name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_name` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `pass_word` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`create_name`,`create_time`,`update_name`,`update_time`,`user_name`,`pass_word`,`address`,`phone`) values 
('04a12e144819407ca26e2e406920933f','system','2016-12-13 10:38:00','system','2016-12-13 10:38:00','1212','3123','232','2423'),
('054980e12edb4193b2fcefe290f3b69b','system','2016-12-13 12:42:56','system','2016-12-13 12:42:56','qwqw','3213','ewew','3232'),
('146223a17d114050a26b3f0dcb37a48f','system','2016-09-28 14:15:22','system','2016-09-28 14:15:22','蔡林峰','123','shangh上海shi','123456789'),
('1ccec6c2f9b44746b94c771c2f96d198','system','2016-12-13 12:38:51','system','2016-12-13 12:38:51',NULL,NULL,NULL,NULL),
('25d656ebcb8a48f3ad4d181dcf9a2a57','system','2016-12-13 12:39:50','system','2016-12-13 12:39:50',NULL,NULL,NULL,NULL),
('304ab337537e4042889f1297490d50a5','system','2016-12-13 10:31:10','system','2016-12-13 10:31:10',NULL,NULL,NULL,NULL),
('32e3d42e3c5a4243b4abca17ab30f66e','system','2016-12-13 11:18:30','system','2016-12-13 11:18:30',NULL,NULL,NULL,NULL),
('3a7f88d3837c4a2a857fb394495fea2b','system','2016-09-27 21:59:11','system','2016-09-27 21:59:11',NULL,NULL,NULL,NULL),
('4be23d57a436463b8c76bab56b0de507','system','2016-12-13 10:22:56','system','2016-12-13 10:22:56',NULL,NULL,NULL,NULL),
('5dc9061ed0ac403e9abb04e96433f083','system','2016-09-28 14:25:30','system','2016-09-28 14:25:30','蔡林峰','123','shangh上海shi','123456789'),
('6015691f672344e2a2255f2861dc2579','system','2016-09-28 14:01:50','system','2016-09-28 14:01:50','蔡林峰','123','shangh上海shi','123456789'),
('7194728e3c3341d7a0dd9cebb50380e2','system','2016-12-13 12:29:36','system','2016-12-13 12:29:36',NULL,NULL,NULL,NULL),
('849ce9cc30264b20808063b9174e7058','system','2016-12-13 10:21:16','system','2016-12-13 10:21:16',NULL,NULL,NULL,NULL),
('910f2e55054f468a83feed3ac185be92','system','2016-12-13 10:27:14','system','2016-12-13 10:27:14',NULL,NULL,NULL,NULL),
('9501dd9988d342d4ac1d8c79891c8406','system','2016-12-13 11:17:54','system','2016-12-13 11:17:54','1212','3123','232','2423'),
('97f65f775ca64a71b1c5c3f1fb6c785f','system','2016-09-27 21:45:44','system','2016-09-27 21:45:44',NULL,NULL,NULL,NULL),
('9c5d3fd6adc644ddb434129aae1aaec6','system','2016-09-18 18:15:44','system','2016-09-27 21:58:47','小花妹','134','上海市','1234567890'),
('9d57826443b348f08ee6dbb161db2bdb','system','2016-09-28 09:52:13','system','2016-09-28 09:52:13','蔡林峰','123','shangh上海shi','123456789'),
('a2960a61ea9b420db38aa82381d9e793','system','2016-09-18 18:15:28','system','2016-09-27 21:54:08','蔡林峰','134','上海市','1234567890'),
('a6144748f94b4a9baf2a3f36fc848252','system','2016-09-28 14:27:23','system','2016-09-28 14:27:23','蔡林峰','123','shangh上海shi','123456789'),
('a728e293e3e5423c8d83c9925e8e0f0a','system','2016-09-18 18:15:08','system','2016-09-18 18:15:08','张海峰','123','上海市','1234567890'),
('a86af9e0b7114cb0893832e1032d0bdb','system','2016-12-13 12:40:19','system','2016-12-13 12:40:19',NULL,NULL,NULL,NULL),
('ab000fed17ba425694e24b0db7be7a4c','system','2016-09-28 14:09:03','system','2016-09-28 14:09:03','蔡林峰','123','shangh上海shi','123456789'),
('accf57ad8352454fa9e19b7415e09669','system','2016-09-18 18:15:33','system','2016-09-18 18:15:33','高国祥','134','上海市','1234567890'),
('b7500add20624e29a15e5627cdcb76d5','system','2016-12-13 10:19:50','system','2016-12-13 10:19:50','qewq','34324','wqewq','3123'),
('ba8934c009dc43ccb52e4be1d9491194','system','2016-12-13 11:17:54','system','2016-12-13 11:17:54','1212','3123','232','2423'),
('bec711832271411e8a33c589d398ce51','system','2016-09-27 22:01:31','system','2016-09-27 22:01:31',NULL,NULL,NULL,NULL),
('d6bced2c80b14e759d3c773dab3aa6da','system','2016-12-13 10:31:07','system','2016-12-13 10:31:07','1212','3123','232','2423'),
('d71c7b1800aa4e7ebfc5b0ffc2d81422','system','2016-12-13 10:31:07','system','2016-12-13 10:31:07','1212','3123','232','2423'),
('db0cf6d2cd7548d6b7d1ec52b1794a4e','system','2016-09-18 18:15:38','system','2016-09-18 18:15:38','李健','134','上海市','1234567890'),
('e821fb46c9ab42659c0c613646198192','system','2016-09-18 18:15:50','system','2016-09-18 18:15:50','朱永恒','134','上海市','1234567890'),
('e873e2ab540f4da48e9d2054e47bd996','system','2016-09-28 14:26:38','system','2016-09-28 14:26:38','蔡林峰','123','shangh上海shi','123456789'),
('e8cbcdab85ce445faf9bf38ddd19e313','system','2016-09-18 18:15:22','system','2016-09-18 18:15:22','尹亚飞','134','上海市','1234567890'),
('ea193aa9979d494c9960f94592f57efb','system','2016-12-13 10:38:00','system','2016-12-13 10:38:00','1212','3123','232','2423'),
('fe9a21be7f91411cab3c07ba4fab725c','system','2016-12-13 10:38:23','system','2016-12-13 10:38:23',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
