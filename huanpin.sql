/*
Navicat MySQL Data Transfer

Source Server         : ccx
Source Server Version : 50728
Source Host           : 127.0.0.1:3306
Source Database       : huanpin

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2019-11-15 18:19:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t1
-- ----------------------------
DROP TABLE IF EXISTS `t1`;
CREATE TABLE `t1` (
  `账号` varchar(255) NOT NULL,
  `密码` varchar(255) DEFAULT NULL,
  `联系方式` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`账号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t1
-- ----------------------------
INSERT INTO `t1` VALUES ('', 'ccx', 'qq：12345');
INSERT INTO `t1` VALUES ('0', '000', '123');
INSERT INTO `t1` VALUES ('031702146', '123456', '18096825997');
INSERT INTO `t1` VALUES ('1', '1', '1');
INSERT INTO `t1` VALUES ('1783814508', 'qqdmmwzdd123', '15750708672');
INSERT INTO `t1` VALUES ('ccx', 'ccx', '手机号：12345');
INSERT INTO `t1` VALUES ('ddl', '123', '123456789');
INSERT INTO `t1` VALUES ('i', 'i', '邮箱：123@qq.com');
INSERT INTO `t1` VALUES ('i2', 'i', '');
INSERT INTO `t1` VALUES ('i3', 'i', '');
INSERT INTO `t1` VALUES ('lee', '123456', '18096825997');
INSERT INTO `t1` VALUES ('mrzy', '123456', '123');

-- ----------------------------
-- Table structure for t2
-- ----------------------------
DROP TABLE IF EXISTS `t2`;
CREATE TABLE `t2` (
  `店名` varchar(255) NOT NULL,
  `账号` varchar(255) DEFAULT NULL,
  `起送费` varchar(255) DEFAULT NULL,
  `配送费` varchar(255) DEFAULT NULL,
  `地址` varchar(255) DEFAULT NULL,
  `平均价格` varchar(255) DEFAULT NULL,
  `经度` varchar(255) DEFAULT NULL,
  `纬度` varchar(255) DEFAULT NULL,
  `套餐数` int(20) DEFAULT NULL,
  PRIMARY KEY (`店名`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t2
-- ----------------------------
INSERT INTO `t2` VALUES ('i', '', '10', '10', null, null, null, null, null);
INSERT INTO `t2` VALUES ('佳乐堡汉堡店（学姐的店）', '', '9.9', '0', null, null, null, null, null);
INSERT INTO `t2` VALUES ('喜仕屋·牛丼咖喱（福大店）', '', '8', '2', null, null, null, null, null);
INSERT INTO `t2` VALUES ('萍福烤冷面（福大店）', '', '0', '0', null, null, null, null, null);
INSERT INTO `t2` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '', '17', '3', null, null, null, null, null);

-- ----------------------------
-- Table structure for t3
-- ----------------------------
DROP TABLE IF EXISTS `t3`;
CREATE TABLE `t3` (
  `店名` varchar(255) NOT NULL,
  `商品` varchar(255) NOT NULL,
  `价格` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`店名`,`商品`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t3
-- ----------------------------
INSERT INTO `t3` VALUES ('i', '可乐', '2');
INSERT INTO `t3` VALUES ('i', '汉堡', '5');
INSERT INTO `t3` VALUES ('佳乐堡汉堡店（学姐的店）', '川香鸡柳', '6');
INSERT INTO `t3` VALUES ('佳乐堡汉堡店（学姐的店）', '热狗', '6');
INSERT INTO `t3` VALUES ('佳乐堡汉堡店（学姐的店）', '蛋挞', '9');
INSERT INTO `t3` VALUES ('佳乐堡汉堡店（学姐的店）', '骨肉相连', '6');
INSERT INTO `t3` VALUES ('佳乐堡汉堡店（学姐的店）', '鸡腿堡+鸡肉卷+中可', '15');
INSERT INTO `t3` VALUES ('佳乐堡汉堡店（学姐的店）', '鸡腿堡+鸡腿+中可', '15');
INSERT INTO `t3` VALUES ('喜仕屋·牛丼咖喱（福大店）', '可口可乐', '8');
INSERT INTO `t3` VALUES ('喜仕屋·牛丼咖喱（福大店）', '土豆饼', '7');
INSERT INTO `t3` VALUES ('喜仕屋·牛丼咖喱（福大店）', '抹茶大福', '8');
INSERT INTO `t3` VALUES ('喜仕屋·牛丼咖喱（福大店）', '海草', '6');
INSERT INTO `t3` VALUES ('喜仕屋·牛丼咖喱（福大店）', '温泉蛋', '5');
INSERT INTO `t3` VALUES ('喜仕屋·牛丼咖喱（福大店）', '芝士', '6');
INSERT INTO `t3` VALUES ('喜仕屋·牛丼咖喱（福大店）', '韩国泡菜', '6');
INSERT INTO `t3` VALUES ('喜仕屋·牛丼咖喱（福大店）', '鲜蔬汤', '6');
INSERT INTO `t3` VALUES ('喜仕屋·牛丼咖喱（福大店）', '鸡排', '8');
INSERT INTO `t3` VALUES ('萍福烤冷面（福大店）', '东北烤冷面', '50');
INSERT INTO `t3` VALUES ('萍福烤冷面（福大店）', '福州鱼丸', '11');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '三番鸡块', '7');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '双层鸡腿堡', '10');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '手枪腿', '10');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '滋补烤全腿', '10');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '热狗', '2.5');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '脆皮香蕉', '6');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '脆皮黑块', '5');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '薯条', '7');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '蛋挞', '4');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '香芋派', '5');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '香芋金球', '6');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '鸡肉卷', '8');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '鸡肉洋葱圈', '6');
INSERT INTO `t3` VALUES ('豪大大鸡排.汉堡.烧烤炸串', '鸡腿堡', '8');

-- ----------------------------
-- Table structure for t4
-- ----------------------------
DROP TABLE IF EXISTS `t4`;
CREATE TABLE `t4` (
  `账号` varchar(255) DEFAULT NULL,
  `店名` varchar(255) DEFAULT NULL,
  `地址` varchar(255) DEFAULT NULL,
  `最晚时间` varchar(255) DEFAULT NULL,
  `商品` varchar(255) DEFAULT NULL,
  `价格` varchar(255) DEFAULT NULL,
  `起送费` varchar(255) DEFAULT NULL,
  `联系方式` varchar(255) DEFAULT NULL,
  `拼单号` varchar(255) DEFAULT NULL,
  `状态` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t4
-- ----------------------------
INSERT INTO `t4` VALUES ('', '佳乐堡汉堡店（学姐的店）', '福州大学32#107', '2019/11/19 8:00', '川香鸡柳', '6', '9.9', 'qq：12345', '1', '2');
INSERT INTO `t4` VALUES ('ccx', '佳乐堡汉堡店（学姐的店）', '福州大学东3-100', '2019/11/19 9:00', '热狗', '6', '9.9', '手机号：12345', '1', '2');
INSERT INTO `t4` VALUES ('', '喜仕屋·牛丼咖喱（福大店）', '福州大学西3-201', '2019/11/19 12:00', '土豆饼', '7', '8', 'qq：12345', '10', '2');
INSERT INTO `t4` VALUES ('', '萍福烤冷面（福大店）', '福州大学东2-302', '2019/11/19 13:00', '福州鱼丸', '11', '0', 'qq：12345', '3', '2');
INSERT INTO `t4` VALUES ('i', '豪大大鸡排.汉堡.烧烤炸串', '福州大学东1-401', '2019/11/19 18:00', '热狗', '2.5', '17', '邮箱：123@qq.com', '4', '2');
INSERT INTO `t4` VALUES ('', '豪大大鸡排.汉堡.烧烤炸串', '福州大学西2-105', '2019/11/19 17:00', '滋补烤全腿', '10', '17', 'qq：12345', '4', '2');
INSERT INTO `t4` VALUES ('ccx', '佳乐堡汉堡店（学姐的店）', '福州大学东3-100', '2019/11/13 14:56', '川香鸡柳', '6', '9.9', '手机号：12345', '8', '0');
INSERT INTO `t4` VALUES ('', '佳乐堡汉堡店（学姐的店）', '福州大学西3-201', '2019/11/13 15:56', '蛋挞', '9', '9.9', 'qq：12345', '8', '0');
INSERT INTO `t4` VALUES ('', 'i', '福州大学东1-105', '2019/11/13 18:22', '汉堡', '5', '10', 'qq：12345', '7', '2');
INSERT INTO `t4` VALUES ('ccx', '喜仕屋·牛丼咖喱（福大店）', '福州大学东3-100', '2019/11/13 18:35', '土豆饼', '7', '8', '手机号：12345', '10', '2');
INSERT INTO `t4` VALUES ('031702146', 'i', '西三206', '2019/11/13 20:0', '可乐', '2', '10', '18096825997', '13', '2');
INSERT INTO `t4` VALUES ('ddl', '佳乐堡汉堡店（学姐的店）', '', '2019/11/13 20:7', '鸡腿堡+鸡肉卷+中可', '15', '9.9', '123456789', '12', '2');
INSERT INTO `t4` VALUES ('ddl', 'i', '', '2019/11/13 20:7', '汉堡', '5', '10', '123456789', '13', '2');

-- ----------------------------
-- Table structure for t5
-- ----------------------------
DROP TABLE IF EXISTS `t5`;
CREATE TABLE `t5` (
  `账号` varchar(255) NOT NULL,
  `地址` varchar(255) NOT NULL,
  PRIMARY KEY (`账号`,`地址`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t5
-- ----------------------------
INSERT INTO `t5` VALUES ('', '福州大学32#107');
INSERT INTO `t5` VALUES ('', '福州大学东1-105');
INSERT INTO `t5` VALUES ('', '福州大学东2-302');
INSERT INTO `t5` VALUES ('', '福州大学西1-403');
INSERT INTO `t5` VALUES ('', '福州大学西2-104');
INSERT INTO `t5` VALUES ('', '福州大学西3-201');
INSERT INTO `t5` VALUES ('031702146', '西三206');
INSERT INTO `t5` VALUES ('ccx', '福州大学东3-100');
INSERT INTO `t5` VALUES ('ccx', '福州大学西1-302');

-- ----------------------------
-- Table structure for t6
-- ----------------------------
DROP TABLE IF EXISTS `t6`;
CREATE TABLE `t6` (
  `拼单号` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t6
-- ----------------------------
INSERT INTO `t6` VALUES ('13');
