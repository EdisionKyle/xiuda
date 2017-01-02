/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.12 : Database - xiuda
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xiuda` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xiuda`;

/*Table structure for table `xiuda_city` */

DROP TABLE IF EXISTS `xiuda_city`;

CREATE TABLE `xiuda_city` (
  `cs_bianhao` varchar(10) NOT NULL COMMENT '城市编号',
  `Cs_chengshi` varchar(15) DEFAULT NULL COMMENT '城市名',
  `Cs_shengfen` varchar(10) DEFAULT NULL COMMENT '省份',
  `Cs_quxian` varchar(15) DEFAULT NULL COMMENT '区/县',
  PRIMARY KEY (`cs_bianhao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `xiuda_city` */

insert  into `xiuda_city`(`cs_bianhao`,`Cs_chengshi`,`Cs_shengfen`,`Cs_quxian`) values ('110101','广州市','广东省','天河区'),('110102','广州市','广东省','越秀区'),('110201','深圳市','广东省','福田区'),('110202','深圳市','广东省','南山区'),('110301','佛山市','广东省','禅城区'),('110302','佛山市','广东省','顺德区'),('120101','东城区','北京',''),('130101','黄浦区','上海',NULL),('130201','宝山区','上海',NULL);

/*Table structure for table `xiuda_fuwushang` */

DROP TABLE IF EXISTS `xiuda_fuwushang`;

CREATE TABLE `xiuda_fuwushang` (
  `fws_bianhao` varchar(10) NOT NULL COMMENT '服务商编号',
  `fws_mingcheng` varchar(20) DEFAULT NULL COMMENT '服务商名称',
  `fws_jiancheng` varchar(10) DEFAULT NULL COMMENT '服务商简称',
  `fws_leibie` varchar(10) DEFAULT NULL COMMENT '服务商类别',
  `fws_cs_bianhao` varchar(6) DEFAULT NULL COMMENT '城市编号',
  `fws_dizhi` varchar(30) DEFAULT NULL COMMENT '详细地址',
  `fws_jingdu` decimal(9,6) DEFAULT NULL COMMENT '经度',
  `fws_weidu` decimal(9,6) DEFAULT NULL COMMENT '纬度',
  `Fws_logo` varchar(20) DEFAULT NULL COMMENT 'LOGO',
  `Fws_zhuangtai` tinyint(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`fws_bianhao`),
  KEY `cs_bianhao_fkey` (`fws_cs_bianhao`),
  CONSTRAINT `cs_bianhao_fkey` FOREIGN KEY (`fws_cs_bianhao`) REFERENCES `xiuda_city` (`cs_bianhao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `xiuda_fuwushang` */

insert  into `xiuda_fuwushang`(`fws_bianhao`,`fws_mingcheng`,`fws_jiancheng`,`fws_leibie`,`fws_cs_bianhao`,`fws_dizhi`,`fws_jingdu`,`fws_weidu`,`Fws_logo`,`Fws_zhuangtai`) values ('1920840918','小猪猪精修服务商','小猪猪','123','110101','天河公园黄埔大道员村23号','113.372814','23.134261','images/logo.png',1);

/*Table structure for table `xiuda_staff` */

DROP TABLE IF EXISTS `xiuda_staff`;

CREATE TABLE `xiuda_staff` (
  `Yg_bianhao` varchar(10) NOT NULL COMMENT '员工编号',
  `Yg_xingming` varchar(10) DEFAULT NULL COMMENT '员工姓名',
  `Yg_shouji` varchar(11) DEFAULT NULL COMMENT '员工手机',
  `Yg_dianhua` varchar(15) DEFAULT NULL COMMENT '员工固话',
  `Yg_youxiang` varchar(20) DEFAULT NULL COMMENT '员工邮箱',
  `Yg_jiaose` varchar(10) DEFAULT NULL COMMENT '系统角色',
  `Yg_zhiwei` varchar(20) DEFAULT NULL COMMENT '员工职位',
  `Yg_fws_bianhao` varchar(10) DEFAULT NULL COMMENT '服务商编号',
  PRIMARY KEY (`Yg_bianhao`),
  KEY `sfegweg` (`Yg_fws_bianhao`),
  CONSTRAINT `sfegweg` FOREIGN KEY (`Yg_fws_bianhao`) REFERENCES `xiuda_fuwushang` (`fws_bianhao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `xiuda_staff` */

insert  into `xiuda_staff`(`Yg_bianhao`,`Yg_xingming`,`Yg_shouji`,`Yg_dianhua`,`Yg_youxiang`,`Yg_jiaose`,`Yg_zhiwei`,`Yg_fws_bianhao`) values ('1100000111','田鹏程','15820353733','0755-2349806','tianpc0318@163.com','1239079837','Java高级开发工程师','1920840918');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
