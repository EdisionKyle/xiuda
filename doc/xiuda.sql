/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : xiuda

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-01-08 23:47:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `parent_ids` varchar(50) DEFAULT NULL COMMENT '父编号列表',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否可用',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '0/', '系统管理', '0', '', '', '#xe62e;', '0', '1');
INSERT INTO `sys_menu` VALUES ('2', '1', '0/1/', '菜单管理', '1', '/sys/menu/list', '', '', '0', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '0/1/', '角色管理', '1', '/sys/role/list', '', '', '0', '1');
INSERT INTO `sys_menu` VALUES ('4', '0', '0/', '工单管理', '0', '', '', '#xe61a;', '0', '1');
INSERT INTO `sys_menu` VALUES ('7', '2', '0/1/2/', '菜单新建', '2', '', 'menu:create', '', '0', '1');
INSERT INTO `sys_menu` VALUES ('8', '2', '0/1/2/', '菜单修改', '2', '/sys/menu/list', 'menu:update', '', '0', '1');
INSERT INTO `sys_menu` VALUES ('9', '2', '0/1/2/', '菜单删除', '2', '/sys/role/list', 'menu:delete', '', '0', '1');
INSERT INTO `sys_menu` VALUES ('12', '3', '0/1/3/', '角色新增', '2', '', 'role:create', '', '0', '1');
INSERT INTO `sys_menu` VALUES ('13', '3', '0/1/3/', '角色修改', '2', '', 'role:update', '', '0', '1');
INSERT INTO `sys_menu` VALUES ('14', '3', '0/1/3/', '角色删除', '2', '', 'role:delete', '', '0', '1');
INSERT INTO `sys_menu` VALUES ('93', '4', '0/4/', '工单删除', '1', '', '', '', '2', '1');
INSERT INTO `sys_menu` VALUES ('94', '4', '0/4/', '工单更新', '1', '', '', '', null, '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `available` tinyint(1) DEFAULT '0',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '拥有全部权限', '1', '2017-01-04 01:12:39');
INSERT INTO `sys_role` VALUES ('2', '业务员', '业务员拥有普通操作权限', '1', '2017-01-03 04:14:31');
INSERT INTO `sys_role` VALUES ('6', '普通管理员', '一般权限', '0', '2017-01-07 23:52:59');
INSERT INTO `sys_role` VALUES ('7', '产品人员', '产品权限', '0', '2017-01-07 23:55:40');
INSERT INTO `sys_role` VALUES ('8', '技术人员', '技术权限', '0', '2017-01-07 23:57:15');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('24', '6', '1', '2017-01-07 23:52:59');
INSERT INTO `sys_role_menu` VALUES ('25', '6', '2', '2017-01-07 23:52:59');
INSERT INTO `sys_role_menu` VALUES ('26', '6', '7', '2017-01-07 23:52:59');
INSERT INTO `sys_role_menu` VALUES ('27', '6', '8', '2017-01-07 23:52:59');
INSERT INTO `sys_role_menu` VALUES ('28', '6', '9', '2017-01-07 23:52:59');
INSERT INTO `sys_role_menu` VALUES ('29', '6', '3', '2017-01-07 23:52:59');
INSERT INTO `sys_role_menu` VALUES ('30', '6', '12', '2017-01-07 23:52:59');
INSERT INTO `sys_role_menu` VALUES ('31', '6', '13', '2017-01-07 23:52:59');
INSERT INTO `sys_role_menu` VALUES ('32', '6', '14', '2017-01-07 23:52:59');
INSERT INTO `sys_role_menu` VALUES ('33', '7', '1', '2017-01-07 23:55:40');
INSERT INTO `sys_role_menu` VALUES ('34', '7', '3', '2017-01-07 23:55:40');
INSERT INTO `sys_role_menu` VALUES ('35', '7', '12', '2017-01-07 23:55:40');
INSERT INTO `sys_role_menu` VALUES ('36', '7', '13', '2017-01-07 23:55:40');
INSERT INTO `sys_role_menu` VALUES ('37', '7', '14', '2017-01-07 23:55:40');
INSERT INTO `sys_role_menu` VALUES ('38', '7', '4', '2017-01-07 23:55:40');
INSERT INTO `sys_role_menu` VALUES ('39', '7', '93', '2017-01-07 23:55:40');
INSERT INTO `sys_role_menu` VALUES ('40', '7', '94', '2017-01-07 23:55:40');
INSERT INTO `sys_role_menu` VALUES ('41', '8', '1', '2017-01-07 23:57:15');
INSERT INTO `sys_role_menu` VALUES ('42', '8', '2', '2017-01-07 23:57:15');
INSERT INTO `sys_role_menu` VALUES ('43', '8', '7', '2017-01-07 23:57:15');
INSERT INTO `sys_role_menu` VALUES ('44', '8', '8', '2017-01-07 23:57:15');
INSERT INTO `sys_role_menu` VALUES ('45', '8', '9', '2017-01-07 23:57:15');
INSERT INTO `sys_role_menu` VALUES ('46', '8', '3', '2017-01-07 23:57:15');
INSERT INTO `sys_role_menu` VALUES ('47', '8', '12', '2017-01-07 23:57:15');
INSERT INTO `sys_role_menu` VALUES ('48', '8', '13', '2017-01-07 23:57:15');
INSERT INTO `sys_role_menu` VALUES ('49', '8', '14', '2017-01-07 23:57:15');
INSERT INTO `sys_role_menu` VALUES ('50', '8', '4', '2017-01-07 23:57:15');
INSERT INTO `sys_role_menu` VALUES ('51', '8', '93', '2017-01-07 23:57:15');
INSERT INTO `sys_role_menu` VALUES ('52', '8', '94', '2017-01-07 23:57:15');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(15) NOT NULL COMMENT '员工登录名',
  `user_no` varchar(10) NOT NULL COMMENT '员工编号',
  `username` varchar(50) NOT NULL COMMENT '员工姓名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `telphone` varchar(15) DEFAULT NULL COMMENT '员工固话',
  `role_id` bigint(20) DEFAULT NULL COMMENT '系统角色',
  `user_job` varchar(20) DEFAULT NULL COMMENT '员工职位',
  `organization_id` bigint(20) NOT NULL COMMENT '所属服务商',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `idx_sys_user_username` (`login_name`),
  KEY `idx_sys_user_organization_id` (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统员工';

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for `xiuda_city`
-- ----------------------------
DROP TABLE IF EXISTS `xiuda_city`;
CREATE TABLE `xiuda_city` (
  `cs_bianhao` varchar(10) NOT NULL COMMENT '城市编号',
  `Cs_chengshi` varchar(15) DEFAULT NULL COMMENT '城市名',
  `Cs_shengfen` varchar(10) DEFAULT NULL COMMENT '省份',
  `Cs_quxian` varchar(15) DEFAULT NULL COMMENT '区/县',
  PRIMARY KEY (`cs_bianhao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xiuda_city
-- ----------------------------
INSERT INTO `xiuda_city` VALUES ('110101', '广州市', '广东省', '天河区');
INSERT INTO `xiuda_city` VALUES ('110102', '广州市', '广东省', '越秀区');
INSERT INTO `xiuda_city` VALUES ('110201', '深圳市', '广东省', '福田区');
INSERT INTO `xiuda_city` VALUES ('110202', '深圳市', '广东省', '南山区');
INSERT INTO `xiuda_city` VALUES ('110301', '佛山市', '广东省', '禅城区');
INSERT INTO `xiuda_city` VALUES ('110302', '佛山市', '广东省', '顺德区');
INSERT INTO `xiuda_city` VALUES ('120101', '东城区', '北京', '');
INSERT INTO `xiuda_city` VALUES ('130101', '黄浦区', '上海', null);
INSERT INTO `xiuda_city` VALUES ('130201', '宝山区', '上海', null);

-- ----------------------------
-- Table structure for `xiuda_fuwushang`
-- ----------------------------
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

-- ----------------------------
-- Records of xiuda_fuwushang
-- ----------------------------
INSERT INTO `xiuda_fuwushang` VALUES ('1920840918', '小猪猪精修服务商', '小猪猪', '123', '110101', '天河公园黄埔大道员村23号', '113.372814', '23.134261', 'images/logo.png', '1');

-- ----------------------------
-- Table structure for `xiuda_staff`
-- ----------------------------
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

-- ----------------------------
-- Records of xiuda_staff
-- ----------------------------
INSERT INTO `xiuda_staff` VALUES ('1100000111', '田鹏程', '15820353733', '0755-2349806', 'tianpc0318@163.com', '1239079837', 'Java高级开发工程师', '1920840918');
