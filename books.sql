/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.0.41-community-nt : Database - bookmarket
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookmarket` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookmarket`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `username` char(20) default NULL,
  `userpass` varchar(30) NOT NULL,
  `realname` varchar(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`username`,`userpass`,`realname`) values ('wangweili','w1211','王韦力');

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `picture` char(50) NOT NULL,
  `bookname` char(30) NOT NULL,
  `booknumber` char(30) NOT NULL default '',
  `price` float NOT NULL,
  `author` char(40) NOT NULL,
  `copyright` char(40) NOT NULL,
  `detail` varchar(400) default NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY  (`booknumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `books` */

insert  into `books`(`picture`,`bookname`,`booknumber`,`price`,`author`,`copyright`,`detail`,`total`) values ('upload/1491831275675.jpg','C++','b001',16,'王韦力','重庆工商出版社','C++入门',30),('upload/1491832386132.jpg','C','b002',34,'王韦力','重庆工商出版社','C入门',20),('upload/1491652610893.jpg','php入门经典','b003',23,'王韦力','重庆工商出版社','php入门',5),('upload/1491832458420.jpg','ORACLE','b004',18.6,'王韦力','重庆工商出版社','oracle入门',40),('upload/1491879456096.jpg','oracle','b005',45,'王韦力','重庆工商出版社','oracle经典',39),('upload/1491879530059.jpg','mysql','b006',29.8,'王韦力','重庆工商出版社','mysql入门经典',50),('upload/1491879613303.jpg','j2ee','b007',18,'王韦力','重庆工商出版社','java企业级',60),('upload/1491882456163.jpg','java web','b008',45,'王韦力','重庆工商出版社','java web',46);

/*Table structure for table `checks` */

DROP TABLE IF EXISTS `checks`;

CREATE TABLE `checks` (
  `state` int(11) NOT NULL default '0',
  `checkid` char(20) NOT NULL,
  `manager` char(30) default NULL,
  `username` char(30) NOT NULL,
  `bname` char(30) NOT NULL,
  `address` char(200) NOT NULL,
  `tel` char(11) NOT NULL,
  `books` varchar(300) NOT NULL default '''商品''',
  `member` char(50) NOT NULL default '''数量''',
  `totalmoney` float NOT NULL default '0',
  PRIMARY KEY  (`checkid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `checks` */

insert  into `checks`(`state`,`checkid`,`manager`,`username`,`bname`,`address`,`tel`,`books`,`member`,`totalmoney`) values (1,'20170413846648','wangweili','wangweili','王韦力','重庆工商大学南岸主校区','15736038709','null,ORACLE,C','null,1,1',52.6);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `username` char(30) NOT NULL default '',
  `userpass` varchar(30) NOT NULL,
  `tel` char(11) NOT NULL,
  `email` char(30) NOT NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`username`,`userpass`,`tel`,`email`) values ('wang','w1211840085','15736038709','1211840085@qq.com'),('wangweili','w1211','15736038709','weili_wang@qq.com'),('xiaolan','xiaolan12','17782131142','1211840085@qq.com'),('王韦力','w1211','15736038709','1211840085@qq.com');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `username` char(20) NOT NULL default '',
  `userpass` char(20) NOT NULL,
  `id` char(20) NOT NULL,
  `tel` char(12) NOT NULL,
  `realname` char(10) NOT NULL,
  `salary` float default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`username`,`userpass`,`id`,`tel`,`realname`,`salary`) values ('xiaobao','xiaobao','s007','15736038709','小宝宝',3400),('xiaobo','xiaobo','s011','15736038709','小波',7000),('xiaofu','xiaofu','s009','4000','小虎',4000),('xiaojun','xiaojun','s005','15736038709','小军',5000),('xiaotao','xiaotao','s003','15736038709','小涛',4000),('xiaowang','xiaowang','s001','15736038709','小王',10000),('xiaowu','xiaowu','s004','15736038709','小吴',3500.5),('xiaoxu','xiaoxu','s008','15736038709','小徐',3000),('xiaoya','xiaoya','s009','15736038709','小雅',5000),('xiaozhang','xiaozhang','s006','15736038709','小张',4400),('xiaozhou','xiaozhou','s002','15736038709','小周',4000);

/*Table structure for table `sales` */

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `id` int(11) NOT NULL auto_increment,
  `username` char(20) NOT NULL,
  `salesmoney` float default NULL,
  `dates` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sales` */

/*Table structure for table `shopcart` */

DROP TABLE IF EXISTS `shopcart`;

CREATE TABLE `shopcart` (
  `totalMoney` float default '0',
  `id` int(11) NOT NULL auto_increment,
  `bookname` char(30) NOT NULL,
  `username` char(30) NOT NULL,
  `booknumber` char(30) NOT NULL,
  `price` float NOT NULL,
  `counts` int(11) NOT NULL default '1',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shopcart` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
