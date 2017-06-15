/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.17-log : Database - searchblogengine
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`searchblogengine` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `searchblogengine`;

/*Table structure for table `googel_cx` */

DROP TABLE IF EXISTS `googel_cx`;

CREATE TABLE `googel_cx` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(100) DEFAULT NULL COMMENT 'google 自定义搜索key',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `googel_cx` */

insert  into `googel_cx`(`id`,`key`) values (1,'000114588724884436284:w9aeldsvrao'),(2,'000114588724884436284:iyh2if_rnqi'),(3,'000114588724884436284:lgiye8nqccq'),(4,'000114588724884436284:pnglbmv0nis');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
