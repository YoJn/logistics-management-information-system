/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.20-log : Database - bos32
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bos32` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `bos32`;

/*Table structure for table `auth_function` */

DROP TABLE IF EXISTS `auth_function`;

CREATE TABLE `auth_function` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `page` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `generatemenu` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zindex` int(11) DEFAULT NULL,
  `pid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_Key_2` (`name`),
  KEY `FK33r6np87v1p6gge7t6rpcao5h` (`pid`),
  CONSTRAINT `FK33r6np87v1p6gge7t6rpcao5h` FOREIGN KEY (`pid`) REFERENCES `auth_function` (`id`),
  CONSTRAINT `auth_function_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `auth_function` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `auth_function` */

LOCK TABLES `auth_function` WRITE;

insert  into `auth_function`(`id`,`name`,`code`,`description`,`page`,`generatemenu`,`zindex`,`pid`) values ('11','基础档案','jichudangan',NULL,NULL,'1',0,NULL),('112','收派标准','standard',NULL,'page_base_standard.action','1',1,'11'),('113','取派员设置','staff',NULL,'page_base_staff.action','1',2,'11'),('114','区域设置','region',NULL,'page_base_region.action','1',3,'11'),('115','管理分区','subarea',NULL,'page_base_subarea.action','1',4,'11'),('116','管理定区/调度排班','decidedzone',NULL,'page_base_decidedzone.action','1',5,'11'),('12','受理','shouli',NULL,NULL,'1',1,NULL),('121','业务受理','noticebill',NULL,'page_qupai_noticebill_add.action','1',0,'12'),('122','工作单快速录入','quickworkordermanage',NULL,'page_qupai_quickworkorder.action','1',1,'12'),('124','工作单导入','workordermanageimport',NULL,'page_qupai_workorderimport.action','1',3,'12'),('13','调度','diaodu',NULL,NULL,'1',2,NULL),('131','查台转单','changestaff',NULL,NULL,'1',0,'13'),('132','人工调度','personalassign',NULL,'page_qupai_diaodu.action','1',1,'13'),('14','物流配送流程管理','zhongzhuan',NULL,NULL,'1',3,NULL),('141','启动配送流程','start',NULL,'workOrderManageAction_list.action','1',0,'14'),('142','查看个人任务','personaltask',NULL,'taskAction_findPersonalTask.action','1',1,'14'),('143','查看我的组任务','grouptask',NULL,'taskAction_findGroupTask.action','1',2,'14'),('402881e464c686800164c68f2eca0000','取派员列表查询权限','staff-list','xx','/staffAction_pageQuery.action','0',2,'113'),('8a7e843355a4392d0155a43aa7150000','删除取派员','staff.delete','xxx','staffAction_delete.action','0',1,'113');

UNLOCK TABLES;

/*Table structure for table `auth_role` */

DROP TABLE IF EXISTS `auth_role`;

CREATE TABLE `auth_role` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_Key_2` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `auth_role` */

LOCK TABLES `auth_role` WRITE;

insert  into `auth_role`(`id`,`name`,`code`,`description`) values ('402881e464c606a00164c6087de20000','test','test','test'),('402881e464c60e340164c61816aa0000','超级管理员角色','admin','超级管理员角色'),('402881e464c60e340164c618e4d50001','普通人员角色','common_user','普通人员角色');

UNLOCK TABLES;

/*Table structure for table `bc_decidedzone` */

DROP TABLE IF EXISTS `bc_decidedzone`;

CREATE TABLE `bc_decidedzone` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `staff_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh0xplk12o52a6eryw4hcqnfwt` (`staff_id`),
  CONSTRAINT `FK_decidedzone_staff` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`),
  CONSTRAINT `FKh0xplk12o52a6eryw4hcqnfwt` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `bc_decidedzone` */

LOCK TABLES `bc_decidedzone` WRITE;

insert  into `bc_decidedzone`(`id`,`name`,`staff_id`) values ('001','平西王','402881e9649370330164937398440000');

UNLOCK TABLES;

/*Table structure for table `bc_region` */

DROP TABLE IF EXISTS `bc_region`;

CREATE TABLE `bc_region` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `province` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `district` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `postcode` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `shortcode` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `citycode` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `bc_region` */

LOCK TABLES `bc_region` WRITE;

insert  into `bc_region`(`id`,`province`,`city`,`district`,`postcode`,`shortcode`,`citycode`) values ('QY001','北京市','北京市','东城区','110101','BJSBJSDCQ','beijingshi'),('QY002','北京市','北京市','西城区','110102','BJSBJSXCQ','beijingshi'),('QY003','北京市','北京市','朝阳区','110105','BJSBJSCYQ','beijingshi'),('QY004','北京市','北京市','丰台区','110106','BJSBJSFTQ','beijingshi'),('QY005','北京市','北京市','石景山区','110107','BJSBJSSJSQ','beijingshi'),('QY006','北京市','北京市','海淀区','110108','BJSBJSHDQ','beijingshi'),('QY007','北京市','北京市','门头沟区','110109','BJSBJSMTGQ','beijingshi'),('QY008','北京市','北京市','房山区','110111','BJSBJSFSQ','beijingshi'),('QY009','北京市','北京市','通州区','110112','BJSBJSTZQ','beijingshi'),('QY010','北京市','北京市','顺义区','110113','BJSBJSSYQ','beijingshi'),('QY011','北京市','北京市','昌平区','110114','BJSBJSCPQ','beijingshi'),('QY012','北京市','北京市','大兴区','110115','BJSBJSDXQ','beijingshi'),('QY013','北京市','北京市','怀柔区','110116','BJSBJSHRQ','beijingshi'),('QY014','北京市','北京市','平谷区','110117','BJSBJSPGQ','beijingshi'),('QY015','北京市','北京市','密云县','110228','BJSBJSMYX','beijingshi'),('QY016','北京市','北京市','延庆县','110229','BJSBJSYQX','beijingshi'),('QY017','河北省','石家庄市','长安区','130102','HBSSJZSZAQ','shijiazhuangshi'),('QY018','河北省','石家庄市','桥东区','130103','HBSSJZSQDQ','shijiazhuangshi'),('QY019','河北省','石家庄市','桥西区','130104','HBSSJZSQXQ','shijiazhuangshi'),('QY020','河北省','石家庄市','新华区','130105','HBSSJZSXHQ','shijiazhuangshi'),('QY021','河北省','石家庄市','井陉矿区','130107','HBSSJZSJXKQ','shijiazhuangshi'),('QY022','河北省','石家庄市','裕华区','130108','HBSSJZSYHQ','shijiazhuangshi'),('QY023','河北省','石家庄市','井陉县','130121','HBSSJZSJXX','shijiazhuangshi'),('QY024','河北省','石家庄市','正定县','130123','HBSSJZSZDX','shijiazhuangshi'),('QY025','河北省','石家庄市','栾城县','130124','HBSSJZSLCX','shijiazhuangshi'),('QY026','河北省','石家庄市','行唐县','130125','HBSSJZSXTX','shijiazhuangshi'),('QY027','河北省','石家庄市','灵寿县','130126','HBSSJZSLSX','shijiazhuangshi'),('QY028','河北省','石家庄市','高邑县','130127','HBSSJZSGYX','shijiazhuangshi'),('QY029','河北省','石家庄市','深泽县','130128','HBSSJZSSZX','shijiazhuangshi'),('QY030','河北省','石家庄市','赞皇县','130129','HBSSJZSZHX','shijiazhuangshi'),('QY031','河北省','石家庄市','无极县','130130','HBSSJZSWJX','shijiazhuangshi'),('QY032','河北省','石家庄市','平山县','130131','HBSSJZSPSX','shijiazhuangshi'),('QY033','河北省','石家庄市','元氏县','130132','HBSSJZSYSX','shijiazhuangshi'),('QY034','河北省','石家庄市','赵县','130133','HBSSJZSZX','shijiazhuangshi'),('QY035','河北省','石家庄市','辛集市','130181','HBSSJZSXJS','shijiazhuangshi'),('QY036','河北省','石家庄市','藁城市','130182','HBSSJZSGCS','shijiazhuangshi'),('QY037','河北省','石家庄市','晋州市','130183','HBSSJZSJZS','shijiazhuangshi'),('QY038','河北省','石家庄市','新乐市','130184','HBSSJZSXLS','shijiazhuangshi'),('QY039','河北省','石家庄市','鹿泉市','130185','HBSSJZSLQS','shijiazhuangshi'),('QY040','天津市','天津市','和平区','120101','TJSTJSHPQ','tianjinshi'),('QY041','天津市','天津市','河东区','120102','TJSTJSHDQ','tianjinshi'),('QY042','天津市','天津市','河西区','120103','TJSTJSHXQ','tianjinshi'),('QY043','天津市','天津市','南开区','120104','TJSTJSNKQ','tianjinshi'),('QY044','天津市','天津市','河北区','120105','TJSTJSHBQ','tianjinshi'),('QY045','天津市','天津市','红桥区','120106','TJSTJSHQQ','tianjinshi'),('QY046','天津市','天津市','滨海新区','120116','TJSTJSBHXQ','tianjinshi'),('QY047','天津市','天津市','东丽区','120110','TJSTJSDLQ','tianjinshi'),('QY048','天津市','天津市','西青区','120111','TJSTJSXQQ','tianjinshi'),('QY049','天津市','天津市','津南区','120112','TJSTJSJNQ','tianjinshi'),('QY050','天津市','天津市','北辰区','120113','TJSTJSBCQ','tianjinshi'),('QY051','天津市','天津市','武清区','120114','TJSTJSWQQ','tianjinshi'),('QY052','天津市','天津市','宝坻区','120115','TJSTJSBCQ','tianjinshi'),('QY053','天津市','天津市','宁河县','120221','TJSTJSNHX','tianjinshi'),('QY054','天津市','天津市','静海县','120223','TJSTJSJHX','tianjinshi'),('QY055','天津市','天津市','蓟县','120225','TJSTJSJX','tianjinshi'),('QY056','山西省','太原市','小店区','140105','SXSTYSXDQ','taiyuanshi'),('QY057','山西省','太原市','迎泽区','140106','SXSTYSYZQ','taiyuanshi'),('QY058','山西省','太原市','杏花岭区','140107','SXSTYSXHLQ','taiyuanshi'),('QY059','山西省','太原市','尖草坪区','140108','SXSTYSJCPQ','taiyuanshi'),('QY060','山西省','太原市','万柏林区','140109','SXSTYSWBLQ','taiyuanshi'),('QY061','山西省','太原市','晋源区','140110','SXSTYSJYQ','taiyuanshi'),('QY062','山西省','太原市','清徐县','140121','SXSTYSQXX','taiyuanshi'),('QY063','山西省','太原市','阳曲县','140122','SXSTYSYQX','taiyuanshi'),('QY064','山西省','太原市','娄烦县','140123','SXSTYSLFX','taiyuanshi'),('QY065','山西省','太原市','古交市','140181','SXSTYSGJS','taiyuanshi');

UNLOCK TABLES;

/*Table structure for table `bc_staff` */

DROP TABLE IF EXISTS `bc_staff`;

CREATE TABLE `bc_staff` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `telephone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `haspda` char(1) COLLATE utf8_bin DEFAULT NULL,
  `deltag` char(1) COLLATE utf8_bin DEFAULT NULL,
  `station` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `standard` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `bc_staff` */

LOCK TABLES `bc_staff` WRITE;

insert  into `bc_staff`(`id`,`name`,`telephone`,`haspda`,`deltag`,`station`,`standard`) values ('402881e464a18a170164a18bb11f0000','张三','13999999999','1','0','华为','标准一'),('402881e9649370330164937398440000','张三四','13888888888','1','0','小米','标准一');

UNLOCK TABLES;

/*Table structure for table `bc_subarea` */

DROP TABLE IF EXISTS `bc_subarea`;

CREATE TABLE `bc_subarea` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `decidedzone_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `region_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `addresskey` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `startnum` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `endnum` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `single` char(1) COLLATE utf8_bin DEFAULT NULL,
  `position` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlndbc8oldgbg3k1x63n3n6t7n` (`decidedzone_id`),
  KEY `FKcjwxm19mx5njn3xyqgqp431mb` (`region_id`),
  CONSTRAINT `FK_area_decidedzone` FOREIGN KEY (`decidedzone_id`) REFERENCES `bc_decidedzone` (`id`),
  CONSTRAINT `FK_area_region` FOREIGN KEY (`region_id`) REFERENCES `bc_region` (`id`),
  CONSTRAINT `FKcjwxm19mx5njn3xyqgqp431mb` FOREIGN KEY (`region_id`) REFERENCES `bc_region` (`id`),
  CONSTRAINT `FKlndbc8oldgbg3k1x63n3n6t7n` FOREIGN KEY (`decidedzone_id`) REFERENCES `bc_decidedzone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `bc_subarea` */

LOCK TABLES `bc_subarea` WRITE;

insert  into `bc_subarea`(`id`,`decidedzone_id`,`region_id`,`addresskey`,`startnum`,`endnum`,`single`,`position`) values ('402881e4649caf2b01649cb865060000','001','QY011','平西府','1','100','2','北清路100号'),('402881e464a1d8680164a1d9ba6b0000','001','QY001','天安门','1','100','1','国安路100号'),('402881e464a204ec0164a20622ff0000',NULL,'QY001','长城','1','100','1','长城路100号');

UNLOCK TABLES;

/*Table structure for table `qp_noticebill` */

DROP TABLE IF EXISTS `qp_noticebill`;

CREATE TABLE `qp_noticebill` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `staff_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `customer_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `customer_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `delegater` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `telephone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `pickaddress` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `arrivecity` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `product` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `pickdate` date DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `volume` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ordertype` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `user_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl5j3pm969oy1qdc1318jrmbgt` (`user_id`),
  KEY `FKhmbqr6qlg0uets978w5xshler` (`staff_id`),
  CONSTRAINT `FKhmbqr6qlg0uets978w5xshler` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`),
  CONSTRAINT `FKl5j3pm969oy1qdc1318jrmbgt` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `qp_noticebill_ibfk_2` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`),
  CONSTRAINT `qp_noticebill_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `qp_noticebill` */

LOCK TABLES `qp_noticebill` WRITE;

UNLOCK TABLES;

/*Table structure for table `qp_workbill` */

DROP TABLE IF EXISTS `qp_workbill`;

CREATE TABLE `qp_workbill` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `noticebill_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `pickstate` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `buildtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `attachbilltimes` int(11) DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `staff_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKggojlcovnpimuukxcueb18apt` (`noticebill_id`),
  KEY `FK55ckcnjyvwinnnniu5jpelg7y` (`staff_id`),
  CONSTRAINT `FK55ckcnjyvwinnnniu5jpelg7y` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`id`),
  CONSTRAINT `FKggojlcovnpimuukxcueb18apt` FOREIGN KEY (`noticebill_id`) REFERENCES `qp_noticebill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `qp_workbill` */

LOCK TABLES `qp_workbill` WRITE;

UNLOCK TABLES;

/*Table structure for table `qp_workordermanage` */

DROP TABLE IF EXISTS `qp_workordermanage`;

CREATE TABLE `qp_workordermanage` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `arrivecity` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `product` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `floadreqr` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `prodtimelimit` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `prodtype` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `sendername` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `senderphone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `senderaddr` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `receivername` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `receiverphone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `receiveraddr` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `feeitemnum` int(11) DEFAULT NULL,
  `actlweit` double DEFAULT NULL,
  `vol` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `managerCheck` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `qp_workordermanage` */

LOCK TABLES `qp_workordermanage` WRITE;

insert  into `qp_workordermanage`(`id`,`arrivecity`,`product`,`num`,`weight`,`floadreqr`,`prodtimelimit`,`prodtype`,`sendername`,`senderphone`,`senderaddr`,`receivername`,`receiverphone`,`receiveraddr`,`feeitemnum`,`actlweit`,`vol`,`managerCheck`,`updatetime`) values ('1','1','1',1,1,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `role_function` */

DROP TABLE IF EXISTS `role_function`;

CREATE TABLE `role_function` (
  `role_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `function_id` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`role_id`,`function_id`),
  KEY `FK5f8riddotqjpm9vly0b8c5nmf` (`function_id`),
  CONSTRAINT `FK10qo908yd9evkyb40vf88og85` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`),
  CONSTRAINT `FK5f8riddotqjpm9vly0b8c5nmf` FOREIGN KEY (`function_id`) REFERENCES `auth_function` (`id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`function_id`) REFERENCES `auth_function` (`id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `role_function` */

LOCK TABLES `role_function` WRITE;

insert  into `role_function`(`role_id`,`function_id`) values ('402881e464c60e340164c61816aa0000','11'),('402881e464c60e340164c618e4d50001','11'),('402881e464c60e340164c61816aa0000','112'),('402881e464c60e340164c618e4d50001','112'),('402881e464c60e340164c61816aa0000','113'),('402881e464c60e340164c618e4d50001','113'),('402881e464c60e340164c61816aa0000','114'),('402881e464c60e340164c618e4d50001','114'),('402881e464c60e340164c61816aa0000','115'),('402881e464c60e340164c618e4d50001','115'),('402881e464c60e340164c61816aa0000','116'),('402881e464c60e340164c618e4d50001','116'),('402881e464c60e340164c61816aa0000','12'),('402881e464c60e340164c618e4d50001','12'),('402881e464c60e340164c61816aa0000','121'),('402881e464c60e340164c618e4d50001','121'),('402881e464c60e340164c61816aa0000','122'),('402881e464c60e340164c618e4d50001','122'),('402881e464c60e340164c61816aa0000','124'),('402881e464c60e340164c618e4d50001','124'),('402881e464c60e340164c61816aa0000','13'),('402881e464c60e340164c61816aa0000','131'),('402881e464c60e340164c61816aa0000','132'),('402881e464c606a00164c6087de20000','14'),('402881e464c60e340164c61816aa0000','14'),('402881e464c606a00164c6087de20000','141'),('402881e464c60e340164c61816aa0000','141'),('402881e464c606a00164c6087de20000','142'),('402881e464c60e340164c61816aa0000','142'),('402881e464c606a00164c6087de20000','143'),('402881e464c60e340164c61816aa0000','143'),('402881e464c60e340164c61816aa0000','8a7e843355a4392d0155a43aa7150000'),('402881e464c60e340164c618e4d50001','8a7e843355a4392d0155a43aa7150000');

UNLOCK TABLES;

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `station` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `decidedzone_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

LOCK TABLES `t_customer` WRITE;

insert  into `t_customer`(`id`,`name`,`station`,`telephone`,`address`,`decidedzone_id`) values (1,'张三','百度','13811111111','北京市西城区长安街100号','001'),(2,'李四','哇哈哈','13822222222','上海市虹桥区南京路250号','001'),(3,'王五','搜狗','13533333333','天津市河北区中山路30号','001'),(4,'赵六','联想','18633333333','石家庄市桥西区和平路10号',NULL),(5,'小白','测试空间','18511111111','内蒙古自治区呼和浩特市和平路100号',NULL),(6,'小黑','联想','13722222222','天津市南开区红旗路20号',NULL),(7,'小花','百度','13733333333','北京市东城区王府井大街20号',NULL),(8,'小李','长城','13788888888','北京市昌平区建材城西路100号',NULL);

UNLOCK TABLES;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `username` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `station` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `telephone` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_user` */

LOCK TABLES `t_user` WRITE;

insert  into `t_user`(`id`,`username`,`password`,`salary`,`birthday`,`gender`,`station`,`telephone`,`remark`) values ('1','admin','81dc9bdb52d04dc20036dbd8313ed055',NULL,NULL,NULL,NULL,NULL,NULL),('402881e464c648bc0164c64a3c440000','xiaohong','81dc9bdb52d04dc20036dbd8313ed055',111,'2018-07-24','男','分公司','111',NULL);

UNLOCK TABLES;

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `role_id` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKqqlqhas35obkljn18mrh6mmms` (`role_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`),
  CONSTRAINT `FKeqon9sx5vssprq67dxm3s7ump` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKqqlqhas35obkljn18mrh6mmms` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user_role` */

LOCK TABLES `user_role` WRITE;

insert  into `user_role`(`user_id`,`role_id`) values ('402881e464c648bc0164c64a3c440000','402881e464c606a00164c6087de20000'),('402881e464c648bc0164c64a3c440000','402881e464c60e340164c61816aa0000');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
