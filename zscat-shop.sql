/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost
 Source Database       : zscat-shop

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : utf-8

 Date: 12/14/2018 13:25:33 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `detail` varchar(10) DEFAULT NULL COMMENT '地址',
  `mobile` varchar(13) DEFAULT NULL COMMENT '电话',
  `isdefault` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_address`
-- ----------------------------
BEGIN;
INSERT INTO `t_address` VALUES ('1', '58', 'zscat分布式框架', '11', '11', '1'), ('2', '58', 'zscat商城', '33', '33', '1'), ('3', '56', 'zsShop商城', '22', '22', '1'), ('4', '58', '张三', '新港中路397号', '020-81167888', '1'), ('5', '58', '张三', '新港中路397号', '020-81167888', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_adv`
-- ----------------------------
DROP TABLE IF EXISTS `t_adv`;
CREATE TABLE `t_adv` (
  `id` int(11) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `member` varchar(255) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `totalprice` decimal(10,0) DEFAULT NULL,
  `stat` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `t_article`
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `summary` text COMMENT '摘要',
  `releaseDate` datetime DEFAULT NULL COMMENT '发布时间',
  `clickHit` int(11) DEFAULT NULL COMMENT '点击量',
  `replyHit` int(11) DEFAULT '0' COMMENT '回复量',
  `content` longtext COMMENT '内容',
  `keyWord` varchar(200) DEFAULT NULL COMMENT '关键字',
  `state` int(11) DEFAULT '1' COMMENT '状态',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  `villageid` bigint(20) DEFAULT NULL COMMENT '所属者',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `topicid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_article`
-- ----------------------------
BEGIN;
INSERT INTO `t_article` VALUES ('1', '商城第一次更新', null, null, null, '0', null, null, '1', null, null, null, null), ('2', '商城第二版', null, null, null, '0', null, null, '1', null, null, null, null), ('3', '商城第三版', null, null, null, '0', null, null, '1', null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `t_banner`
-- ----------------------------
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `stat` int(11) DEFAULT '0' COMMENT '状态',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  `storeid` bigint(20) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_banner`
-- ----------------------------
BEGIN;
INSERT INTO `t_banner` VALUES ('11', 'zscat商城', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/banner5.png', '1', null), ('12', 'zscat后台', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/banner4.png', '1', null), ('13', '妹子', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/banner1.jpg', '2', null), ('14', '母婴', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/bg2.png', '1', null), ('15', '积分', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/3/integral-banner.jpg', '2', null), ('16', 'cms1', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/3/hw_bg2.png', '3', null), ('18', 'cms2', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/3/hw_bg3.png', '3', null), ('19', 'j3shop', '1', 'http://p0bt2oaom.bkt.clouddn.com/AD-01.jpg', '4', null), ('20', 'j3shop', '1', 'http://p0bt2oaom.bkt.clouddn.com/AD-01.jpg', '4', null), ('21', 'j3shop', '1', 'http://p0bt2oaom.bkt.clouddn.com/AD-02.jpg', '4', null), ('22', 'j3shop', '1', 'http://p0bt2oaom.bkt.clouddn.com/AD-03.jpg', '4', null), ('23', 'j3shop', '1', 'http://p0bt2oaom.bkt.clouddn.com/AD-04.jpg', '4', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_brand`
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `stat` int(11) DEFAULT '0' COMMENT '状态',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_brand`
-- ----------------------------
BEGIN;
INSERT INTO `t_brand` VALUES ('1', 'zscat牌', '0', 'http://p0bt2oaom.bkt.clouddn.com/1252.jpg'), ('2', '车车', '0', 'http://p0bt2oaom.bkt.clouddn.com/199.jpg'), ('3', '女人', '0', 'http://p0bt2oaom.bkt.clouddn.com/1663.jpg'), ('4', '包包', '0', 'http://p0bt2oaom.bkt.clouddn.com/6116.jpg'), ('5', '一叶子', '0', 'http://p0bt2oaom.bkt.clouddn.com/1208.jpg'), ('6', '水密码', '0', 'http://p0bt2oaom.bkt.clouddn.com/741.png'), ('7', '斯塔美', '0', 'http://p0bt2oaom.bkt.clouddn.com/152.jpg'), ('8', 'OLAY', '0', 'http://p0bt2oaom.bkt.clouddn.com/156.jpg'), ('9', '御泥坊', '0', 'http://p0bt2oaom.bkt.clouddn.com/245.jpg'), ('10', '森田药庄', '0', 'http://p0bt2oaom.bkt.clouddn.com/339.jpg'), ('11', '温碧泉', '0', 'http://p0bt2oaom.bkt.clouddn.com/1270.jpg'), ('12', '丸美', '0', 'http://p0bt2oaom.bkt.clouddn.com/1309.jpg'), ('13', '自然堂', '0', 'http://p0bt2oaom.bkt.clouddn.com/1145.jpg'), ('14', '美肤宝', '0', 'http://p0bt2oaom.bkt.clouddn.com/1396.jpg');
COMMIT;

-- ----------------------------
--  Table structure for `t_cart`
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodsid` bigint(20) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `goodsname` varchar(255) DEFAULT NULL COMMENT '商品',
  `price` varchar(10) DEFAULT NULL COMMENT '价格',
  `count` int(11) DEFAULT NULL COMMENT '个数',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  `storeid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `userIp` varchar(50) DEFAULT NULL COMMENT 'IP',
  `blogId` int(11) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `commentDate` datetime DEFAULT NULL COMMENT '时间',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `blogger_id` bigint(20) DEFAULT NULL COMMENT '博客',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `blogger` varchar(255) DEFAULT NULL COMMENT '回答者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_comment`
-- ----------------------------
BEGIN;
INSERT INTO `t_comment` VALUES ('1', '111', '85', '鬼才知道这些鬼东西', '2016-11-01 12:49:39', '1', '3', 'Storm 的可靠性保证测试', null), ('2', null, '86', 'http://localhost:8081/pig/front/blog/shequDetail/85  测试', '2016-11-03 13:15:22', null, '4', '分布式会话跟踪系统架构设计与实践', null), ('3', '0:0:0:0:0:0:0:1', '122', '我来回得zacat3', '2016-11-03 13:56:10', null, '3', 'zscat3', '转');
COMMIT;

-- ----------------------------
--  Table structure for `t_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `t_coupon`;
CREATE TABLE `t_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '0未使用 1已使用 2已过期',
  `amount` decimal(12,2) DEFAULT NULL,
  `begin_time` date DEFAULT NULL,
  `coupon_count` int(11) DEFAULT NULL,
  `coupon_end_time` date DEFAULT NULL,
  `coupon_name` varchar(255) DEFAULT NULL,
  `coupon_order_amount` decimal(12,2) DEFAULT NULL,
  `pic` varchar(20) DEFAULT NULL,
  `is_receive` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1.满减 2.折扣',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_coupon`
-- ----------------------------
BEGIN;
INSERT INTO `t_coupon` VALUES ('1', '2014-09-23 16:42:45', '3', '5.00', '2014-09-01', '10', '2014-12-31', '5元优惠券', '100.00', '425993', '0', '1'), ('2', '2014-09-23 19:52:36', '1', '10.00', '2014-09-01', '100', '2014-12-31', '10元优惠券', '100.00', '425994', '1', '1'), ('3', '2014-09-24 10:39:07', '2', '20.00', '2014-09-01', '10', '2014-12-31', '7折优惠券', '200.00', '425995', '0', '2'), ('4', '2014-09-23 16:42:45', '2', '5.00', '2014-09-01', '10', '2014-12-31', '15元优惠券', '100.00', '425993', '0', '1'), ('5', '2014-09-23 19:52:36', '1', '10.00', '2014-09-01', '100', '2014-12-31', '20元优惠券', '100.00', '425994', '1', '1'), ('6', '2014-09-24 10:39:07', '3', '20.00', '2014-09-01', '10', '2014-12-31', '9折优惠券', '200.00', '425995', '0', '2');
COMMIT;

-- ----------------------------
--  Table structure for `t_favorite`
-- ----------------------------
DROP TABLE IF EXISTS `t_favorite`;
CREATE TABLE `t_favorite` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deletestatus` int(1) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `goodsid` bigint(20) DEFAULT NULL,
  `storeid` bigint(20) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FKAFC41E93339519D2` (`goodsid`,`userid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_favorite`
-- ----------------------------
BEGIN;
INSERT INTO `t_favorite` VALUES ('48', '2017-10-22 10:06:50', '2', '1', '35', '1', '58'), ('49', '2017-10-22 10:32:42', '2', '1', '50', '7', '58'), ('50', '2017-11-30 20:23:42', '2', '1', '63', null, '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_floor`
-- ----------------------------
DROP TABLE IF EXISTS `t_floor`;
CREATE TABLE `t_floor` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `name` varchar(100) DEFAULT NULL COMMENT '类型名称',
  `typesort` int(3) DEFAULT '0' COMMENT '商品类型排序',
  `parent_id` bigint(10) DEFAULT NULL COMMENT 'classid',
  `parent_ids` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `del_flag` varchar(255) DEFAULT NULL,
  `advimg` varchar(255) DEFAULT NULL COMMENT '活动图片',
  `advurl` varchar(255) DEFAULT NULL COMMENT '活动链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品类型表';

-- ----------------------------
--  Records of `t_floor`
-- ----------------------------
BEGIN;
INSERT INTO `t_floor` VALUES ('1', 'zscat名包', '0', '1', null, '每一个zscat名包都有一个故事!', null, 'http://p0bt2oaom.bkt.clouddn.com/AD-p-6.jpg', 'http://j2shop.tunnel.qydev.com/blog/index'), ('3', 'zscat名车', '3', '212', null, '每一个zscat名车都有一个故事!', null, 'http://p0bt2oaom.bkt.clouddn.com/che.jpg', 'http://j2shop.tunnel.qydev.com/blog/index'), ('4', 'zscat美女', '0', '217', null, '每一个zscat美女都有一个故事!', null, 'http://p0bt2oaom.bkt.clouddn.com/AD-p-5.jpg', 'http://j2shop.tunnel.qydev.com/blog/index');
COMMIT;

-- ----------------------------
--  Table structure for `t_floor_brand`
-- ----------------------------
DROP TABLE IF EXISTS `t_floor_brand`;
CREATE TABLE `t_floor_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brandid` bigint(20) DEFAULT NULL,
  `floorid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_floor_brand`
-- ----------------------------
BEGIN;
INSERT INTO `t_floor_brand` VALUES ('15', '5', '1'), ('16', '2', '1'), ('17', '3', '1'), ('18', '4', '1'), ('19', '4', '4'), ('27', '3', '4'), ('28', '1', '4'), ('29', '2', '4'), ('30', '3', '3'), ('31', '1', '3'), ('32', '2', '3'), ('33', '4', '3'), ('34', '13', '1'), ('35', '14', '1'), ('36', '12', '1'), ('37', '5', '1'), ('38', '6', '1'), ('39', '7', '1'), ('40', '8', '1'), ('41', '5', '3'), ('42', '6', '3'), ('43', '7', '3'), ('44', '8', '3'), ('45', '6', '4'), ('46', '7', '4'), ('47', '10', '4'), ('48', '11', '4'), ('49', '9', '4');
COMMIT;

-- ----------------------------
--  Table structure for `t_floor_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_floor_goods`;
CREATE TABLE `t_floor_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productid` bigint(20) DEFAULT NULL,
  `floorid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_floor_goods`
-- ----------------------------
BEGIN;
INSERT INTO `t_floor_goods` VALUES ('15', '71', '1'), ('16', '72', '1'), ('17', '73', '1'), ('18', '74', '1'), ('19', '75', '1'), ('27', '76', '1'), ('28', '77', '1'), ('29', '78', '2'), ('30', '79', '2'), ('31', '80', '2'), ('32', '81', '2'), ('33', '82', '2'), ('34', '83', '2'), ('35', '84', '3'), ('36', '85', '3'), ('37', '86', '3'), ('38', '87', '3'), ('39', '88', '3'), ('40', '89', '3'), ('41', '90', '3'), ('42', '91', '3'), ('43', '92', '3');
COMMIT;

-- ----------------------------
--  Table structure for `t_good_sorder`
-- ----------------------------
DROP TABLE IF EXISTS `t_good_sorder`;
CREATE TABLE `t_good_sorder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodsid` bigint(20) DEFAULT NULL,
  `orderid` bigint(20) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `goodsname` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_good_sorder`
-- ----------------------------
BEGIN;
INSERT INTO `t_good_sorder` VALUES ('85', '70', '83', 'homenav3.png', 'htc one', '5', '23'), ('86', '66', '83', 'classify-ph05.png', '索尼（SONY） Xperia SP M3 ', '2', '522'), ('87', '70', '84', 'homenav3.png', 'htc one', '5', '23'), ('88', '66', '84', 'classify-ph05.png', '索尼（SONY） Xperia SP M3 ', '2', '522');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '名称',
  `tag` varchar(255) DEFAULT NULL COMMENT '标签',
  `remark` longtext,
  `summary` longtext,
  `clickHit` int(255) DEFAULT '0' COMMENT '点击量',
  `typeid` bigint(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  `typename` varchar(255) DEFAULT NULL COMMENT '类型',
  `classid` bigint(255) DEFAULT NULL COMMENT '分类',
  `orderby` varchar(255) DEFAULT NULL,
  `prices` varchar(255) DEFAULT NULL COMMENT '价格',
  `imgmore` varchar(1000) DEFAULT NULL,
  `create_by` bigint(64) DEFAULT '0' COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记(0活null 正常 1,删除)',
  `replyhit` int(11) DEFAULT '0' COMMENT '评价量',
  `sellhit` int(11) DEFAULT '0' COMMENT '销售量',
  `iscom` int(255) DEFAULT '1' COMMENT '1推荐，2不推荐',
  `storeid` bigint(20) DEFAULT NULL,
  `storename` varchar(255) DEFAULT NULL,
  `brandid` bigint(20) DEFAULT NULL,
  `collecthit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_goods`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods` VALUES ('71', '罗马假日 永生花', '包', '<p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/8e3fef83-fd6d-469f-b888-01b7758c9a58.jpg\" style=\"width: 100px;\"><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/669a56d8-ba5e-4041-abbd-13878e9d42e5.jpg\" style=\"width: 65px;\"><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/669a56d8-ba5e-4041-abbd-13878e9d42e5.jpg\" style=\"width: 65px;\"><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/050ac06f91828d346a4711c0773e7d51.jpg\" style=\"width: 630px;\"></p><p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/acda526adc6f8c69fe78629508a9ff83.jpg\" style=\"width: 636px;\"><br></p>', null, '0', '13', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/2347f937-4f9d-4ee5-a19d-be8e8a1b63e2.png', '后台框架', '264', null, '299', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/2347f937-4f9d-4ee5-a19d-be8e8a1b63e2.png,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/7d8c621f-6daf-4250-9cb0-b1551b068bfa(1).jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/4b9b124f-1310-4fe1-af7d-b79a7a4ad2bc.png', '1', '2017-12-02 21:31:59', null, '0', '0', '1', '7', null, '4', null), ('72', '科技感防盗双肩包', '', '<p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/52c871af-5cc7-40cd-87ab-8dd7ea02d140.jpg\" style=\"width: 65px;\"><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/6055d103-2d89-41b3-b31e-9234ab8bbdc8.jpg\" style=\"width: 65px;\"><br></p>', null, '0', '13', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/d248235c-0535-42e4-a5cc-c9794068d7e9(2).png', '后台框架', '264', null, '399', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/d248235c-0535-42e4-a5cc-c9794068d7e9(2).png,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/39bb719b-214c-4a3f-b472-d16aa1498b59.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/76f68934-0efc-482d-a35d-dcc781a8638a.jpg', '1', '2017-12-02 21:36:29', null, '0', '0', '1', '7', null, '4', null), ('73', '马卡龙拼色托特包', '', '<p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/0f76048c-2763-4e9b-9f4b-3cca40e8dc8b.png\" style=\"width: 428px;\"><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/98fb631c-795b-4df2-b429-da8faecfee32.jpg\" style=\"width: 100px;\"><br></p>', null, '0', '13', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/0f76048c-2763-4e9b-9f4b-3cca40e8dc8b(2).png', '后台框架', '264', null, '59', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/0f76048c-2763-4e9b-9f4b-3cca40e8dc8b(2).png,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/4fe6028b-42f5-491e-b091-06accee6ffc9.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/4fc6ec4f-5075-40c3-a8d0-2a2f21e643c1.jpeg', '1', '2017-12-02 21:38:03', null, '0', '0', null, '7', null, '4', null), ('74', '英伦温莎轻雅双肩包', '', '<p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/3ea65e2edb90ea338c80d55fc3f82c77.jpg\" style=\"width: 630px;\"><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/5e94297366f274053f47456389949fe0.jpg\" style=\"width: 630px;\"><br></p>', null, '0', '13', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/1df8e433-32e2-45b7-b081-5b8b0a902f16.png', '后台框架', '264', null, '362', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/1df8e433-32e2-45b7-b081-5b8b0a902f16.png,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/5afa9d1d63f742254dd483a6d978f564.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/8ef22ade-d969-4b48-bd0f-7c607260b2ee.jpg', '1', '2017-12-02 21:39:42', null, '0', '0', '1', '7', null, '4', null), ('75', '男士七匹狼', '', '<p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/86cdf5b5-b5c6-4972-b1f9-0f1dc4c388ad.jpg\" style=\"width: 100px;\"><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/6e66868c-837c-46b3-b18e-b756479670f9.jpg\" style=\"width: 100px;\"><br></p>', null, '0', '13', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/8a009458-f5df-407c-95ca-c2ee81bffbc2.jpg', '后台框架', '264', null, '69', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/8a009458-f5df-407c-95ca-c2ee81bffbc2.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/3053c908-bcae-4643-bd26-5ea078dee48e.jpg', '1', '2017-12-02 21:44:34', null, '0', '0', '1', '7', null, '4', null), ('76', '艾吉贝2015新款多层收纳真皮单肩斜挎包女包头层牛皮斜跨小包包女', '', '<p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/1787bd1d-9381-402b-b98e-97ceeddf7692(2).jpg\" style=\"width: 100px;\"><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/ed971163-f1bf-45e8-b63a-50cf514df3e1.jpg\" style=\"width: 65px;\"><br></p>', null, '0', '13', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/1787bd1d-9381-402b-b98e-97ceeddf7692(2).jpg', '后台框架', '264', null, '89', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/1787bd1d-9381-402b-b98e-97ceeddf7692(2).jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/fdc59871-ff17-49bb-8fc2-3ec79331a6ab.png,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/419da357-1a5e-4191-8652-fa9f73579824.jpg', '1', '2017-12-02 21:47:39', null, '0', '0', '1', '7', null, '4', null), ('77', '黑色手提包', '', '<p><br></p>', null, '0', '13', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/0b1be21d-0566-4764-817f-7e7e96b3057b(1).jpg', '后台框架', '264', null, '66', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/0b1be21d-0566-4764-817f-7e7e96b3057b(1).jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/7844ee76-bd8e-4093-8379-b7eaa260e37f.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/86cdf5b5-b5c6-4972-b1f9-0f1dc4c388ad.jpg', '1', '2017-12-02 21:48:55', null, '0', '0', '1', '7', null, '4', null), ('78', '1号媳妇', '', '<p><br></p>', null, '0', '10', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/微信图片_20171202215605.jpg', 'ssm框架', '256', null, '99999', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/微信图片_20171202215605.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/微信图片_20171202215647.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/微信图片_20171202215658.jpg', '1', '2017-12-02 22:00:42', null, '0', '0', '1', '2', null, '3', null), ('79', '范冰冰', '', '<p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/e7d4cac126941b5a-396dcc73e3007ef8-bfa5c11dd3ea93a8d77ffe8a6f6347c1.jpg\" style=\"width: 400px;\"><br></p>', null, '0', '10', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/53e981f88a8af750-043293bd725ac52f-b1719c09a4eb97917674bdea97ce39a8.jpg', '', '256', null, '8888', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/53e981f88a8af750-043293bd725ac52f-b1719c09a4eb97917674bdea97ce39a8.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/4abb143c81046d05-2ce49f14414deb25-695c5ab2e11efd1d845862353c308f0a.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/c583df4cdb382aff-50aefb79b44e9cc2-4f1371eb44b2d9a18c33e94a2653ac7d.jpg', '1', '2017-12-02 22:02:00', null, '0', '0', '1', '2', null, '3', null), ('80', '刘亦菲', '', '<p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/f10069f89ae5da80-7f099a25c1fcaef1-0d76b2364594c87a50502eda4cf4a876.jpg\" style=\"width: 250px;\"><br></p>', null, '5', '10', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/30c40e020f63f81f-7bd77d19c1df47f9-4bf44928eddd2d2f94080f68a4181ff5.jpg', 'ssm框架', '256', null, '8888', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/30c40e020f63f81f-7bd77d19c1df47f9-4bf44928eddd2d2f94080f68a4181ff5.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/4ed4545fff7981a7-1d62999ce76c5a61-c0db27dd0273278463b44c4265f717e6.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/3f3f7f612f8a8d5c-536ae837e5e1ba7e-5ed0f4deaba429232db8177426c81c2f.jpg', '1', '2017-12-02 22:04:17', null, '0', '0', '1', '2', null, '3', null), ('81', '高圆圆', '', '<p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/d7036c9a17f5fda2-692b72bb72244631-d82a33655d8f898b47b2c5fef6343e80.jpg\" style=\"width: 220px;\"><br></p>', null, '2', '10', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/4abb143c81046d05-2ce49f14414deb25-0f0f231899e416952a4d2d2a03a6af91.jpg', 'ssm框架', '256', null, '8888', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/4abb143c81046d05-2ce49f14414deb25-0f0f231899e416952a4d2d2a03a6af91.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/18b802f0eb835f7e-f90693c95e6a93be-7e280d0925fe6d6a0b9cb8b62cbdd967.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/18b802f0eb835f7e-f90693c95e6a93be-78a13f9b2923a5357c63195501bad103.jpg', '1', '2017-12-02 22:05:31', null, '0', '0', '1', '2', null, '3', null), ('82', '刘诗诗', '', '<p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/fe0f38266b1cd093-14c78354174ba987-18d7b66642098d7a7e5e6c8221f2bb8a.jpg\" style=\"width: 220px;\"><br></p>', null, '0', '10', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/00f7ce062ff37075-52173f9ca1848127-e779933ce08152a34c769f0f2a222727.jpg', 'ssm框架', '256', null, '7777', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/00f7ce062ff37075-52173f9ca1848127-e779933ce08152a34c769f0f2a222727.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/3c8506cc8f74c9b7-858e24cdf713e0a3-df1d6144f97c798fea7c7485c44ae8f2.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/30c40e020f63f81f-c00171587126b6cf-1e66f24118b7df972fa99edf02657f47.jpg', '1', '2017-12-02 22:06:42', null, '0', '0', '1', '2', null, '3', null), ('83', '佟丽娅', '', '<p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/e9fc19c65cd2272a-172cf4ab731c814c-d07c142e072fb4e02818fea692d5ed7e.jpg\" style=\"width: 220px;\"><br></p>', null, '0', '10', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/30c40e020f63f81f-c00171587126b6cf-bc6f591c99d887ae27444473a0ce9e1a.jpg', 'ssm框架', '256', null, '777', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/30c40e020f63f81f-c00171587126b6cf-bc6f591c99d887ae27444473a0ce9e1a.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/49441198c9025f19-f32856163f8cb7da-19f369b65136f4dbf2f36e021166fa57.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/95c435a20586d145-334347e9007b1a29-4b83d3cdf6ecf9b9fbcf498b8770f2f3.jpg', '1', '2017-12-02 22:09:09', null, '0', '0', '1', '2', null, '3', null), ('84', '唐嫣', '', '<p><img src=\"http://p0bt2oaom.bkt.clouddn.com/2017/12/2/b17c8f01e57d5969-d3492e1ab3bea685-a9f57689a9e179d106ab88118a005730.jpg\" style=\"width: 220px;\"><br></p>', null, '0', '10', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/b17c8f01e57d5969-d3492e1ab3bea685-a9f57689a9e179d106ab88118a005730.jpg', 'ssm框架', '256', null, '777', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/b17c8f01e57d5969-d3492e1ab3bea685-a9f57689a9e179d106ab88118a005730.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/d9ee2417259c6e75-219fb870bdabc13a-f7bf8770e2f36d544d93f0836addbc44.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/073dd602d5871102-4328563730fefcb4-09e6cec6fcee36589f49f0cbaa45c183.jpg', '1', '2017-12-02 22:11:08', null, '0', '0', '1', '2', null, '3', null), ('85', '宝马', '', '<p><br></p>', null, '0', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/o_1c0blvgkq43056444644409755925376.jpg', '', '257', null, '35000', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/o_1c0blvgkq43056444644409755925376.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/o_1c0asil6r929150637424738217991.jpg', '1', '2017-12-02 22:22:21', null, '0', '0', '1', '1', null, '2', null), ('86', '奔驰', '', '<p><br></p>', null, '0', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/o_1c0blvgkq43056444644409755925376.jpg', '', '257', null, '36000', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/o_1c0blvgkq43056444644409755925376.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/o_1c02h9aam1103462857300814566544078.jpg', '1', '2017-12-02 22:22:45', null, '0', '0', '1', '1', null, '2', null), ('87', '奥迪', '', '<p><br></p>', null, '0', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/o_1c08dk0id468041014050122581632508.jpg', '', '257', null, '450000', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/o_1c08dk0id468041014050122581632508.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/o_1c088jevv196862982410426238942795.jpg', '1', '2017-12-02 22:23:07', null, '0', '0', '1', '1', null, '2', null), ('88', 'daz4', '', '<p><br></p>', null, '0', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/o_1c08qq02r51082461021572317828915.jpg', '', '257', null, '390000', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/o_1c08qq02r51082461021572317828915.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/o_1c088jevv196862982410426238942795.jpg', '1', '2017-12-02 22:23:29', null, '0', '0', '1', '1', null, '2', null), ('89', '兰博基尼', '', '<p><br></p>', null, '2', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/3f6c24264a9d1159-8c8b24f690e6208a-b2554f7e23816b3b5ba5a0d39f362ed8.jpg', '', '257', null, '382222', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/3f6c24264a9d1159-8c8b24f690e6208a-b2554f7e23816b3b5ba5a0d39f362ed8.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/13a17e67be6bb241-07f3c39fab82837f-bfb19f52e1cfd788aaaf6193a5414782.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/179863da17707baa-9c303adc57998ffe-929b9c416b968c9e0d811e12246c3845.jpg', '1', '2017-12-02 22:26:05', null, '0', '0', '1', '1', null, '2', null), ('90', '保时捷', '', '<p><br></p>', null, '6', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/ac75323d6b6de243-a5e00022a0971b80-b5cfd3eae3861ce92caec3a25a4a6c0e.jpg', '', '257', null, '376666', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/ac75323d6b6de243-a5e00022a0971b80-b5cfd3eae3861ce92caec3a25a4a6c0e.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/a0563ae4c8dc69d0-c61e859243992b03-f0955047abfd96e155e0ab52f8948e1c.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/ac75323d6b6de243-174fbc37ffe7ed35-4daffb531c52a8ac679cba15aff9ee63.jpg', '1', '2017-12-02 22:26:33', null, '0', '0', '1', '1', null, '2', null), ('91', '凯迪拉克', '', '<p><br></p>', null, '3', '1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/ac75323d6b6de243-eac8ca492ea27a6f-3d6fc2d1b842ee0495399e9e7f75c138.jpg', '', '257', null, '346666', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/ac75323d6b6de243-eac8ca492ea27a6f-3d6fc2d1b842ee0495399e9e7f75c138.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/ac75323d6b6de243-eac8ca492ea27a6f-5d8635c21b10e20481d8b49bc13264ad.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/ac75323d6b6de243-e8600a70e32f2820-536a252e29ad706f550b6ae1a2dba9d1.jpg', '1', '2017-12-02 22:27:01', null, '0', '0', '1', '1', null, '2', null), ('92', '法拉利', '', '<p><br></p>', null, '10', null, 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/ac75323d6b6de243-eac8ca492ea27a6f-a9c37ad79d32b49171dd42b6c0e8020f.jpg', '', '257', null, '356666', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/2/ac75323d6b6de243-eac8ca492ea27a6f-a9c37ad79d32b49171dd42b6c0e8020f.jpg,http://p0bt2oaom.bkt.clouddn.com/2017/12/2/ac75323d6b6de243-eac8ca492ea27a6f-75768cf1d2be43148c113f7d018dbbbb.jpg', '1', '2017-12-02 22:27:40', null, '0', '0', '1', null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_class`;
CREATE TABLE `t_goods_class` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '索引ID',
  `name` varchar(100) NOT NULL COMMENT '分类名称',
  `pic` varchar(255) DEFAULT NULL COMMENT '分类图片',
  `del_flag` char(1) DEFAULT '1' COMMENT '前台显示，0为否，1为是，默认为1',
  `title` varchar(200) DEFAULT NULL COMMENT '名称',
  `pid` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=268 DEFAULT CHARSET=utf8 COMMENT='商品分类表';

-- ----------------------------
--  Records of `t_goods_class`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_class` VALUES ('1', '全部类别', null, '1', 'spring是很好的项目', '0', '0,'), ('212', 'zscat系列', null, '1', 'mybatis是很不错的项目2', '1', '212,0,,'), ('213', '手机品牌', null, '1', 'zscat项目1', '1', '0,1,'), ('214', '前端/后台', null, '1', '11', '1', '0,1,'), ('215', 'cms项目', null, '1', '2222', '1', '1,'), ('216', 'oa项目', null, '1', '33', '1', '0,1,'), ('217', '官网项目', null, '1', '44', '1', '0,1,'), ('218', 'ssh框架', null, '1', null, '212', null), ('228', '美容项目', null, '1', null, '213', null), ('229', '宠物项目', null, '1', null, '214', null), ('230', '交友项目', null, '1', null, '215', null), ('231', '体育项目', null, '1', null, '216', null), ('256', '女明星', null, '1', '11', '217', null), ('257', '名车', null, '1', '1', '217', null), ('258', '三星', null, '1', '', '212', null), ('259', '华为', null, '1', '', '214', null), ('260', '金立', null, '1', '', '215', null), ('261', '联想', null, '1', '', '216', null), ('262', '中兴', null, '1', '', '256', null), ('263', '小米', null, '1', '', '213', null), ('264', '生活包', null, '1', '', '217', null), ('265', '商城框架', null, '1', '', '212', null), ('266', 'springboot', null, '1', '', '212', null), ('267', 'test1', 'http://p0bt2oaom.bkt.clouddn.com/2017/12/3/app5-5.png', null, 'qu  test', null, '官网项目');
COMMIT;

-- ----------------------------
--  Table structure for `t_goods_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_type`;
CREATE TABLE `t_goods_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `create_by` bigint(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记(0活null 正常 1,删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_goods_type`
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_type` VALUES ('1', '名车', null, null, '0'), ('10', '名包包', '2', '2016-12-22 09:59:15', '0'), ('13', '美女', null, null, '0'), ('14', 'test', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `t_jifendata`
-- ----------------------------
DROP TABLE IF EXISTS `t_jifendata`;
CREATE TABLE `t_jifendata` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `addcount` int(255) DEFAULT NULL COMMENT '积分',
  `createdate` date DEFAULT NULL COMMENT '时间',
  `userid` bigint(20) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_jifendata`
-- ----------------------------
BEGIN;
INSERT INTO `t_jifendata` VALUES ('23', '1', '2017-11-30', '1', '登录'), ('24', '1', '2017-11-30', '1', '登录'), ('25', '1', '2017-11-30', '1', '登录'), ('26', '1', '2017-11-30', '1', '登录'), ('27', '1', '2017-11-30', '1', '登录'), ('28', '1', '2017-11-30', '1', '登录'), ('29', '1', '2017-11-30', '1', '登录'), ('30', '1', '2017-11-30', '1', '登录'), ('31', '1', '2017-11-30', '1', '登录'), ('32', '1', '2017-11-30', '1', '登录'), ('33', '1', '2017-12-01', '1', '登录'), ('34', '1', '2017-12-01', '1', '登录'), ('35', '2', '2017-12-01', '1', '提交订单'), ('36', '2', '2017-12-01', '1', '提交订单'), ('37', '1', '2017-12-01', '1', '登录');
COMMIT;

-- ----------------------------
--  Table structure for `t_jifengoods`
-- ----------------------------
DROP TABLE IF EXISTS `t_jifengoods`;
CREATE TABLE `t_jifengoods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '名称',
  `tag` varchar(255) DEFAULT NULL COMMENT '标签',
  `remark` longtext,
  `summary` longtext,
  `clickHit` int(255) DEFAULT '0' COMMENT '点击量',
  `typeid` bigint(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  `classid` bigint(255) DEFAULT NULL COMMENT '分类',
  `prices` varchar(255) DEFAULT NULL COMMENT '价格',
  `imgmore` varchar(1000) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `replyhit` int(11) DEFAULT '0' COMMENT '评价量',
  `iscom` int(255) DEFAULT '1' COMMENT '1推荐，2不推荐',
  `storeid` bigint(20) DEFAULT NULL,
  `days` int(11) DEFAULT NULL COMMENT '有效期  天',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_jifengoods`
-- ----------------------------
BEGIN;
INSERT INTO `t_jifengoods` VALUES ('33', 'zscat分布式框架', 'spring,springmvc ,通用mapper, dubbo,zookeep', '<p style=\"margin-top: 1.12em; margin-bottom: 1.12em; margin-left: 42pt; padding: 0px; text-indent: 21pt;\">开源分布式框架zsCat 559182393</p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; margin-left: 42pt; padding: 0px; text-indent: 21pt;\"><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2nOAEpXXXXXXOXFXXXXXXXXXX_!!2541510480.png\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2MmkOpXXXXXcBXpXXXXXXXXXX_!!2541510480.png\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2Qwi2oVXXXXcCXpXXXXXXXXXX_!!2541510480.png\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2FLC5oVXXXXb.XpXXXXXXXXXX_!!2541510480.png\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2541510480/TB2WwzyoVXXXXblXXXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"554\" height=\"314\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2541510480/TB2R9LyoVXXXXbcXXXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"553\" height=\"415\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2541510480/TB2crHzoVXXXXa0XXXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"553\" height=\"290\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2nsu2oVXXXXcFXpXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"553\" height=\"232\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2541510480/TB283y3oVXXXXcAXpXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"554\" height=\"281\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2541510480/TB2hEndoVXXXXaeXpXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"554\" height=\"317\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2541510480/TB2hffmoVXXXXc3XXXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"554\" height=\"396\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2541510480/TB2VF11oVXXXXcvXpXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"554\" height=\"93\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2541510480/TB2oSHboVXXXXaEXpXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"554\" height=\"102\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2541510480/TB2eEPXoVXXXXaYXpXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"554\" height=\"289\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2541510480/TB2k7bxoVXXXXa.XXXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1362\" height=\"582\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2SorfoVXXXXX0XpXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1364\" height=\"610\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2tYK6oVXXXXb2XpXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1364\" height=\"580\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2541510480/TB23U5ZoVXXXXcAXpXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1364\" height=\"580\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2541510480/TB2mDrnoVXXXXcFXXXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1361\" height=\"696\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2541510480/TB2RfraoVXXXXarXpXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1364\" height=\"699\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2541510480/TB2qwjgoVXXXXX5XpXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1360\" height=\"586\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2541510480/TB2uvYloVXXXXXXXpXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1362\" height=\"582\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2541510480/TB2wCvsoVXXXXbWXXXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1364\" height=\"610\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2xd2noVXXXXcOXXXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1363\" height=\"592\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2541510480/TB27AWSoVXXXXX5XFXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1364\" height=\"580\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2541510480/TB2dKiWoVXXXXXcXFXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1356\" height=\"585\" style=\"border: 0px; vertical-align: top;\"/></p><h5 style=\"margin: 0px 0px 0px 10px; padding: 0px; font-size: 15px; height: 22px;\">邻家好货</h5><p><br/></p>,', '开源分布式框架zsCat 559182393邻家好货', '193', '11', 'zscat.png', '246', '50', 'https://img.alicdn.com/imgextra/i1/2541510480/TB2nOAEpXXXXXXOXFXXXXXXXXXX_!!2541510480.png,https://img.alicdn.com/imgextra/i1/2541510480/TB2MmkOpXXXXXcBXpXXXXXXXXXX_!!2541510480.png,https://img.alicdn.com/imgextra/i1/2541510480/TB2Qwi2oVXXXXcCXpXXXXXXXXXX_!!2541510480.png,', '2016-12-23 12:07:18', '5', null, '1', null), ('34', 'zscat商城', 'mybatisplus ,ssm,dubbo', '<p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\">qq &nbsp;951449465</p><p>dubbo 权限设计，spring，springmvc ，mybatis，beetl &nbsp;sso &nbsp;solr搜索引擎 &nbsp; &nbsp; &nbsp; &nbsp;演示地址 &nbsp;http://zscat.carp.mopaasapp.com/login http://shop.zscat&nbsp;</p><p>开源分布式框架zsCat 559182393</p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; margin-left: 42pt; padding: 0px; text-indent: 21pt;\"><br/></p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; margin-left: 42pt; padding: 0px; text-indent: 21pt;\">开源分布式框架zsCat 559182393</p><p>&nbsp;1.技术关键字&nbsp;如&nbsp;redis、dubbo&nbsp;等<br/>2.服务关键字&nbsp;如&nbsp;商品，商城，电商等<br/>3.关联关键字&nbsp;&nbsp;如分布式，购物网，外包，商城私活<br/>等&nbsp;</p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><span style=\"font-family: 宋体; font-size: 10.5pt;\">zsCat&nbsp;<span style=\"font-family:宋体\">多用户 多商家模式商城</span></span><span style=\"font-family: 宋体; font-size: 10.5pt;\"></span></p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><span style=\"font-family: 宋体; font-size: 10.5pt;\">java shiro Spring springmvc &nbsp;mybatis mybatis-plus &nbsp;redis rabbitmq</span><span style=\"font-size: 10.5pt; line-height: 1.5; font-family: 宋体;\"><span style=\"font-family:宋体\">将服务提出来，预留</span></span><span style=\"font-size: 10.5pt; line-height: 1.5; font-family: 宋体;\">dubbo&nbsp;<span style=\"font-family:宋体\">分布式服务结构</span></span></p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><span style=\"font-size: 10.5pt; line-height: 1.5; font-family: 宋体;\"><span style=\"font-family:宋体\"></span></span></p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><span style=\"font-size: 10.5pt; line-height: 1.5; font-family: 宋体;\"><span style=\"font-family:宋体\"></span></span></p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><span style=\"font-size: 10.5pt; line-height: 1.5; font-family: 宋体;\"><span style=\"font-family:宋体\"><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2CnxvXZwb61Bjy0FfXXXvlpXa_!!2541510480.png\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2541510480/TB27jdzX_ga61BjSspiXXXUSXXa_!!2541510480.png\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2GDtvXZwb61Bjy0FfXXXvlpXa_!!2541510480.png\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB28X4yXZIa61Bjy0FiXXc1XpXa_!!2541510480.png\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2541510480/TB2x3JAXZga61Bjy1XaXXafzVXa_!!2541510480.png\" class=\"\" width=\"683\" height=\"384\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2541510480/TB2zHxxXZsX61Bjy1XdXXa0aFXa_!!2541510480.png\" class=\"\" width=\"222\" height=\"623\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2541510480/TB2uzlyX_ga61BjSspfXXadSpXa_!!2541510480.png\" class=\"\" width=\"683\" height=\"384\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2541510480/TB2f3FAXZga61Bjy1XaXXafzVXa_!!2541510480.png\" class=\"\" width=\"683\" height=\"384\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2541510480/TB2QENyX4IX61BjSsplXXazrpXa_!!2541510480.png\" class=\"\" width=\"683\" height=\"384\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2541510480/TB2btdzX_gX61BjSspmXXaFcFXa_!!2541510480.png\" class=\"\" width=\"683\" height=\"384\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2541510480/TB2YwuqX4Ab61BjSZFBXXc9pFXa_!!2541510480.png\" class=\"\" width=\"1366\" height=\"768\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2541510480/TB2TF8xX4oa61Bjy0FaXXcHwpXa_!!2541510480.png\" class=\"\" width=\"1366\" height=\"768\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2541510480/TB2VUesX3Uc61BjSZFmXXbJHFXa_!!2541510480.png\" class=\"\" width=\"683\" height=\"384\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2541510480/TB2CAOrX4wb61BjSZFlXXbuoVXa_!!2541510480.png\" class=\"\" width=\"683\" height=\"384\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2541510480/TB2zUasX3Uc61BjSZFmXXbJHFXa_!!2541510480.png\" class=\"\" width=\"683\" height=\"384\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2q01qXZkd61BjSZPhXXcb9VXa_!!2541510480.png\" class=\"\" width=\"683\" height=\"384\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2mfurX9Zb61BjSZPfXXaU.pXa_!!2541510480.png\" class=\"\" width=\"683\" height=\"384\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB27JapX37c61BjSZFKXXb6hFXa_!!2541510480.png\" class=\"\" width=\"683\" height=\"384\" style=\"border: 0px; vertical-align: top;\"/></span></span></p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><span style=\"font-family: 宋体; font-size: 10.5pt;\"></span></p><h5 style=\"margin: 0px 0px 0px 10px; padding: 0px; font-size: 15px; white-space: normal; widows: auto; background-color: rgb(255, 255, 255);\">看了该宝贝的人还看了</h5><ul style=\"margin: 0px; padding: 0px; list-style: none;\"><li></li></ul><p><br/></p>,', 'qq  951449465dubbo 权限设计，spring，springmvc ，mybatis，beetl  sso  solr搜索引擎        演示地址  http://zscat.carp.mopaasapp.com/login http://shop.zscat 开源分布式框架zsCat 55', '161', '11', 'shop.png', '238', '200', 'https://img.alicdn.com/imgextra/i1/2541510480/TB2CnxvXZwb61Bjy0FfXXXvlpXa_!!2541510480.png,https://img.alicdn.com/imgextra/i4/2541510480/TB27jdzX_ga61BjSspiXXXUSXXa_!!2541510480.png,https://img.alicdn.com/imgextra/i1/2541510480/TB2GDtvXZwb61Bjy0FfXXXvlpXa_!!2541510480.png,', '2016-12-23 12:54:02', '0', '1', '1', null), ('35', 'zsShop商城', 'spring,springmvc ,通用mapper, dubbo,zookeep', '<p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><span style=\"color: rgb(108, 108, 108); font-size: 12px; line-height: 18px;\">spring，springmvc ，mybatis，通用mapping ，redis beetl &nbsp;</span><span style=\"line-height: 1.5;\">AmazeUI-2.4.2 &nbsp;jquery</span></p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><span style=\"line-height: 1.5;\"></span>后台权限管理 精确到按钮级别 &nbsp;菜单配置 字典管理 机构管理 用户 &nbsp;角色管理 &nbsp;商品管理 &nbsp;类别管理</p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\">订单管理 &nbsp; 购物车 &nbsp;广告 &nbsp;文章管理等</p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\">前台 首页菜单 购物详情 &nbsp;个人中心</p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\">树形组件 &nbsp;下拉组件 &nbsp;选择树组件 等等</p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><span style=\"color: rgb(108, 108, 108); font-size: 12px; line-height: 18px;\"></span></p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><br/></p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\">登录后 顶部显示后台管理 ，可以查看</p><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><span style=\"font-size: 12px;\"><a target=\"_blank\" style=\"color: rgb(51, 102, 204); outline: 0px;\"><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2541510480/TB2tvhtbNmJ.eBjy0FhXXbBdFXa_!!2541510480.png\" style=\"border: 0px; vertical-align: top; height: 600px; width: 600px; float: none; margin: 0px;\"/></a></span><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2541510480/TB2wkprbSuJ.eBjy0FgXXXBBXXa_!!2541510480.jpg\" style=\"border: 0px; vertical-align: top; height: 500px; width: 500px; float: none; margin: 0px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2541510480/TB2QGpnbHeI.eBjSspkXXaXqVXa_!!2541510480.png\" style=\"border: 0px; vertical-align: top; height: 500px; width: 500px; float: none; margin: 0px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2541510480/TB2eRlebHaI.eBjy1XdXXcoqXXa_!!2541510480.png\" style=\"border: 0px; vertical-align: top; height: 500px; width: 500px; float: none; margin: 0px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2541510480/TB2T6FkbM1J.eBjy0FaXXaXeVXa_!!2541510480.png\" class=\"\" style=\"border: 0px; vertical-align: top; height: 500px; width: 500px; float: none; margin: 0px;\"/><img src=\"https://img.alicdn.com/imgextra/i3/2541510480/TB2iTtMbR9J.eBjy0FoXXXyvpXa_!!2541510480.png\" class=\"\" align=\"absmiddle\" width=\"1366\" height=\"768\" style=\"border: 0px; vertical-align: top;\"/><img src=\"https://img.alicdn.com/imgextra/i2/2541510480/TB2GfVubIeJ.eBjy0FiXXXqapXa_!!2541510480.jpg\" class=\"\" align=\"absmiddle\" width=\"1242\" height=\"2208\" style=\"border: 0px; vertical-align: top;\"/></p><h5 style=\"margin: 0px 0px 0px 10px; padding: 0px; font-size: 15px;\">买了该宝贝的人还买了</h5><p><br/></p>,', 'spring，springmvc ，mybatis，通用mapping ，redis beetl  AmazeUI-2.4.2  jquery后台权限管理 精确到按钮级别  菜单配置 字典管理 机构管理 用户  角色管理  商品管理  类别管理订单管理   购物车  广告  文章管理等前台 首页菜单 购物详情', '100', '10', 'zsshop.jpg', '238', '150', 'https://img.alicdn.com/imgextra/i3/2541510480/TB2tvhtbNmJ.eBjy0FhXXbBdFXa_!!2541510480.png,https://img.alicdn.com/imgextra/i4/2541510480/TB2wkprbSuJ.eBjy0FgXXXBBXXa_!!2541510480.jpg,https://img.alicdn.com/imgextra/i3/2541510480/TB2QGpnbHeI.eBjSspkXXaXqVXa_!!2541510480.png,', '2017-05-20 12:58:40', '0', null, '1', null), ('36', 'zscatPlus', 'spring,springmvc ,通用mapper, dubbo,zookeep', '<p><img src=\"/zsTrade/static/ueditor/jsp/upload1/20161223/1482469194786.png\" style=\"float:none;\" title=\"H.png\"/></p><p><img src=\"/zsTrade/static/ueditor/jsp/upload1/20161223/1482469198359.png\" style=\"float:none;\" title=\"QQ图片20161012163538.png\"/></p><p><img src=\"/zsTrade/static/ueditor/jsp/upload1/20161223/1482469195105.png\" style=\"float:none;\" title=\"QQ图片20161012163729.png\"/></p><p><br/></p>,', '', '102', '11', 'H.png', '247', '50', '/zsTrade/static/ueditor/jsp/upload1/20161223/1482469194786.png,/zsTrade/static/ueditor/jsp/upload1/20161223/1482469198359.png,/zsTrade/static/ueditor/jsp/upload1/20161223/1482469195105.png,', '2016-12-23 12:59:55', '0', '1', '1', null), ('37', 'zscat社区', 'layui,ssm', '<p><img src=\"/zsTrade/static/ueditor/jsp/upload1/20161223/1482469481972.png\" style=\"float:none;\" title=\"blog.png\"/></p><p><img src=\"/zsTrade/static/ueditor/jsp/upload1/20161223/1482469481086.png\" style=\"float:none;\" title=\"QQ截图20161104134602.png\"/></p><p><img src=\"/zsTrade/static/ueditor/jsp/upload1/20161223/1482469482244.png\" style=\"float:none;\" title=\"QQ截图20161104135156.png\"/></p><p><img src=\"/zsTrade/static/ueditor/jsp/upload1/20161223/1482469487209.jpg\" style=\"float:none;\" title=\"04.jpg\"/></p><p><img src=\"/zsTrade/static/ueditor/jsp/upload1/20161223/1482469481047.png\" style=\"float:none;\" title=\"QQ图片20161028110015.png\"/></p><p><img src=\"/zsTrade/static/ueditor/jsp/upload1/20161223/1482469481495.png\" style=\"float:none;\" title=\"QQ图片20161028110044.png\"/></p><p><img src=\"/zsTrade/static/ueditor/jsp/upload1/20161223/1482469480820.png\" style=\"float:none;\" title=\"QQ图片20161028111335.png\"/></p><p><br/></p>,', '', '21', '10', 'blog.png', '245', '20', '/zsTrade/static/ueditor/jsp/upload1/20161223/1482469481972.png,/zsTrade/static/ueditor/jsp/upload1/20161223/1482469481086.png,/zsTrade/static/ueditor/jsp/upload1/20161223/1482469482244.png,', '2017-01-24 13:04:44', '0', null, '1', null), ('38', 'zsCms', 'ssm', '<p><img src=\"/zsTrade/static/ueditor/jsp/upload1/20161223/1482469612881.png\" style=\"float:none;\" title=\"cms.png\"/></p><p><img src=\"/zsTrade/static/ueditor/jsp/upload1/20161223/1482469616227.png\" style=\"float:none;\" title=\"QQ图片20161028130524.png\"/></p><p><br/></p>,', '', '20', '10', 'cms.png', '246', '30', '/zsTrade/static/ueditor/jsp/upload1/20161223/1482469612881.png,/zsTrade/static/ueditor/jsp/upload1/20161223/1482469616227.png,', '2017-05-20 13:06:55', '7', '2', '1', null), ('39', 'zscatLte分布式框架', 'spring', '<p style=\"margin-bottom: 15px; orphans: 2; white-space: normal; widows: 2; box-sizing: inherit; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; background-color: rgb(250, 250, 250); margin-top: 0px !important;\">zscatLte是一个轻量级权限管理系统，其核心设计目标是开发迅速、学习简单、轻量级、易扩展。<br style=\"box-sizing: inherit;\"/>使用zscatLte搭建项目，只需编写30%左右代码，其余的代码交给系统自动生成。<br style=\"box-sizing: inherit;\"/>一个月的工作量，一周就能完成，剩余的时间可以陪家人、朋友、撩妹、钓凯子等，从此踏入高富帅、白富美行业。</p><p style=\"margin-top: 0px; margin-bottom: 15px; orphans: 2; white-space: normal; widows: 2; box-sizing: inherit; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; background-color: rgb(250, 250, 250);\"><strong style=\"box-sizing: inherit;\">具有如下特点</strong></p><ul class=\"task-list\" style=\"orphans: 2; white-space: normal; widows: 2; box-sizing: inherit; font-size: 14px; line-height: 24px; margin: 0px 0px 15px; padding-left: 30px; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; background-color: rgb(250, 250, 250);\"><li>轻量级的权限系统，只涉及Spring、Shiro、Mybatis后端框架，降低学习使用成本</li><li>友好的代码结构及注释，便于阅读及二次开发</li><li>支持HTML、JSP、Velocity、Freemarker等视图，零技术门槛</li><li>灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求(如需控制到按钮级别，需使用Shiro标签，控制按钮的显示或隐藏)</li><li>页面交互使用Vue2.x，极大的提高了开发效率</li><li>完善的代码生成机制，可在线生成entity、xml、dao、service、page、js代码，减少70%以上的开发任务</li><li>引入quartz定时任务，可动态完成任务的添加、修改、删除、暂停、恢复及日志查看等功能</li><li>引入路由机制，刷新页面会停留在当前页</li></ul><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833332927.png\" style=\"float:none;\" title=\"blog.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833337146.png\" style=\"float:none;\" title=\"gen.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833336912.png\" style=\"float:none;\" title=\"menu.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833335881.png\" style=\"float:none;\" title=\"zscatlte.png\"/></p><p><br/></p>,', 'zscatLte是一个轻量级权限管理系统，其核心设计目标是开发迅速、学习简单、轻量级、易扩展。使用zscatLte搭建项目，只需编写30%左右代码，其余的代码交给系统自动生成。一个月的工作量，一周就能完成，剩余的时间可以陪家人、朋友、撩妹、钓凯子等，从此踏入高富帅、白富美行业。具有如下特点轻量级的权限系统，只', '61', '11', 'zscatlte.png', '247', '50', '/static/ueditor/jsp/upload1/20161227/1482833332927.png,/static/ueditor/jsp/upload1/20161227/1482833337146.png,/static/ueditor/jsp/upload1/20161227/1482833336912.png,', '2016-12-27 18:08:57', '0', '1', '1', null), ('40', 'java后台框架', 'hibernate', '<p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833394317.png\" style=\"float:none;\" title=\"blog.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833403014.png\" style=\"float:none;\" title=\"menu.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833395840.png\" style=\"float:none;\" title=\"role.png\"/></p><p><br/></p>,', '', '43', '10', 'blog.png', '247', '1', '/static/ueditor/jsp/upload1/20161227/1482833394317.png,/static/ueditor/jsp/upload1/20161227/1482833403014.png,/static/ueditor/jsp/upload1/20161227/1482833395840.png,', '2017-01-24 18:09:58', '0', null, '1', null), ('41', 'ssh后台框架_activiy5', 'ssh', '<h3 style=\"box-sizing: inherit; font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; line-height: 1.33em; margin: 20px 0px 10px; padding: 0px; font-size: 18px; -webkit-font-smoothing: antialiased; cursor: text; position: relative; color: rgba(0, 0, 0, 0.8); white-space: normal; background-color: rgb(250, 250, 250);\">ommon</h3><ul class=\"task-list\" style=\"box-sizing: inherit; font-size: 14px; line-height: 24px; margin: 0px 0px 15px; padding-left: 30px; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; white-space: normal; background-color: rgb(250, 250, 250);\"><li>泛型封装dao、service、controller基类，包含分页，查询条件封装，从而达到快速crud操作(参考<a href=\"https://github.com/springside\" target=\"_blank\" style=\"box-sizing: inherit; color: rgb(65, 131, 196); text-decoration: none; background-color: transparent; cursor: pointer !important; word-wrap: break-word; margin-top: 0px; margin-bottom: 0px; background-position: initial initial; background-repeat: initial initial;\">springside4</a>&quot;)</li><li>简易代码生成器,增加字段配置功能、生成页面功能，实现增删查改不需要写一句代码(参考<a href=\"https://github.com/thinkgem/jeesite\" target=\"_blank\" style=\"box-sizing: inherit; color: rgb(65, 131, 196); text-decoration: none; background-color: transparent; cursor: pointer !important; word-wrap: break-word; margin-top: 0px; margin-bottom: 0px; background-position: initial initial; background-repeat: initial initial;\">jeesite</a>)</li><li>ehcache缓存</li><li>springmvc 整合hibernate validater 进行后端数据验证</li></ul><h3 style=\"box-sizing: inherit; font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; line-height: 1.33em; margin: 20px 0px 10px; padding: 0px; font-size: 18px; -webkit-font-smoothing: antialiased; cursor: text; position: relative; color: rgba(0, 0, 0, 0.8); white-space: normal; background-color: rgb(250, 250, 250);\"><a class=\"anchor\" id=\"系统权限管理_6\" href=\"http://git.oschina.net/rguess/thinker#系统权限管理_6\" style=\"box-sizing: inherit; color: rgb(65, 131, 196); text-decoration: none; background-color: transparent; cursor: pointer; word-wrap: break-word; display: block; padding-left: 30px; margin-left: -20px; position: absolute; top: 0px; left: 0px; bottom: 0px; outline: none; background-position: initial initial; background-repeat: initial initial;\"></a>系统权限管理</h3><ul class=\"task-list\" style=\"box-sizing: inherit; font-size: 14px; line-height: 24px; margin: 0px 0px 15px; padding-left: 30px; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; white-space: normal; background-color: rgb(250, 250, 250);\"><li>系统管理——包含用户、角色、权限、资源、菜单管理</li><li>权限管理——使用框架apache shiro进行系统认证、授权操作</li><ul class=\"task-list\" style=\"box-sizing: inherit; margin: 0px; padding-left: 30px;\"><li>系统认证、授权操作</li><li>按钮粒度的权限控制</li><li>并发登录人数控制</li><li>后端使用注解进行方法级别的权限控制</li></ul><li>系统登录,操作日志记录,查询,分析</li></ul><h3 style=\"box-sizing: inherit; font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; line-height: 1.33em; margin: 20px 0px 10px; padding: 0px; font-size: 18px; -webkit-font-smoothing: antialiased; cursor: text; position: relative; color: rgba(0, 0, 0, 0.8); white-space: normal; background-color: rgb(250, 250, 250);\"><a class=\"anchor\" id=\"oa工作流程_7\" href=\"http://git.oschina.net/rguess/thinker#oa工作流程_7\" style=\"box-sizing: inherit; color: rgb(65, 131, 196); text-decoration: none; background-color: transparent; cursor: pointer; word-wrap: break-word; display: block; padding-left: 30px; margin-left: -20px; position: absolute; top: 0px; left: 0px; bottom: 0px; outline: none; background-position: initial initial; background-repeat: initial initial;\"></a>OA工作流程</h3><ul class=\"task-list\" style=\"box-sizing: inherit; font-size: 14px; line-height: 24px; margin: 0px 0px 15px; padding-left: 30px; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; white-space: normal; background-color: rgb(250, 250, 250);\"><li>集成activiti(工作流引擎)</li><ul class=\"task-list\" style=\"box-sizing: inherit; margin: 0px; padding-left: 30px;\"><li>整合spring</li><li>工作流引擎并完成工作流通用基类、常用工具类</li><li>通用待办,已办,我的流程等常用查询</li><li>定义业务开发需实现的接口</li><li>流程部署</li><li>请假流程例子</li><li>自由工作流设计例子</li></ul></ul><h3 style=\"box-sizing: inherit; font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; line-height: 1.33em; margin: 20px 0px 10px; padding: 0px; font-size: 18px; -webkit-font-smoothing: antialiased; cursor: text; position: relative; color: rgba(0, 0, 0, 0.8); white-space: normal; background-color: rgb(250, 250, 250);\"><a class=\"anchor\" id=\"内容管理_8\" href=\"http://git.oschina.net/rguess/thinker#内容管理_8\" style=\"box-sizing: inherit; color: rgb(65, 131, 196); text-decoration: none; background-color: transparent; cursor: pointer; word-wrap: break-word; display: block; padding-left: 30px; margin-left: -20px; position: absolute; top: 0px; left: 0px; bottom: 0px; outline: none; background-position: initial initial; background-repeat: initial initial;\"></a>内容管理</h3><ul class=\"task-list\" style=\"box-sizing: inherit; font-size: 14px; line-height: 24px; margin: 0px 0px 15px; padding-left: 30px; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; white-space: normal; background-color: rgb(250, 250, 250);\"><li>实现栏目，文章，系统静态资源的管理</li><li>实现上传word发表文章</li><li>实现ueditor富文本方式发表文章</li><li>aop+freemarker+线程实现首页静态化</li><li>实现多个站点的管理</li><li>基于该cms的个人博客网站</li></ul><h3 style=\"box-sizing: inherit; font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; line-height: 1.33em; margin: 20px 0px 10px; padding: 0px; font-size: 18px; -webkit-font-smoothing: antialiased; cursor: text; position: relative; color: rgba(0, 0, 0, 0.8); white-space: normal; background-color: rgb(250, 250, 250);\"><a class=\"anchor\" id=\"utils_9\" href=\"http://git.oschina.net/rguess/thinker#utils_9\" style=\"box-sizing: inherit; color: rgb(65, 131, 196); text-decoration: none; background-color: transparent; cursor: pointer; word-wrap: break-word; display: block; padding-left: 30px; margin-left: -20px; position: absolute; top: 0px; left: 0px; bottom: 0px; outline: none; background-position: initial initial; background-repeat: initial initial;\"></a>utils</h3><ul class=\"task-list\" style=\"box-sizing: inherit; font-size: 14px; line-height: 24px; margin: 0px 0px 15px; padding-left: 30px; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; white-space: normal; background-color: rgb(250, 250, 250);\"><li>开发中常用工具类整理</li><ul class=\"task-list\" style=\"box-sizing: inherit; margin: 0px; padding-left: 30px;\"><li>基于apache poi的通用导出excel工具类</li><li>各种类型相互转化工具类</li><li>Http与Servlet工具类</li><li>常用日期处理工具类</li><li>各种编码,解码,加密等工作类</li><li>反射操作封装</li><li>文件操作</li><li>WordToHtml</li><li>spring注解方式实现定时任务调度，实现mysql数据备份</li><li>...</li></ul><li>整理了丰富多样的js、jquery插件</li><ul class=\"task-list\" style=\"box-sizing: inherit; margin: 0px; padding-left: 30px;\"><li>bootstrap</li><li>jquery validation、修改验证后显示以适应bootstrap，显得更加美观、添加常用验证</li><li>自定义的js分页插件(配合bootstrap-paginator)</li><li>ztree(jquery 树插件)</li><li>datetimepicker(日历控件)</li><li>gritter(提示框)</li><li>jquery-slimscroll(定义局部元素滚动)</li><li>jquery-treegrid(树插件能更好的与bootstrap table融合以展示数据)</li><li>bootstrap-tree(简易的树插件)</li><li>chosen-bootstrap(下拉框选择控件)</li><li>font-awesome(字体)</li><li>uniform(表单美化)</li><li>jquery blockUI(遮罩层)</li><li>ueditor(富文本编辑器)</li><li>bootstrap-fileupload</li><li>jquery fileupload多文件上传带进度条</li><li>....</li></ul></ul><h3 style=\"box-sizing: inherit; font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; line-height: 1.33em; margin: 20px 0px 10px; padding: 0px; font-size: 18px; -webkit-font-smoothing: antialiased; cursor: text; position: relative; color: rgba(0, 0, 0, 0.8); white-space: normal; background-color: rgb(250, 250, 250);\"><a class=\"anchor\" id=\"others_10\" href=\"http://git.oschina.net/rguess/thinker#others_10\" style=\"box-sizing: inherit; color: rgb(65, 131, 196); text-decoration: none; background-color: transparent; cursor: pointer; word-wrap: break-word; display: block; padding-left: 30px; margin-left: -20px; position: absolute; top: 0px; left: 0px; bottom: 0px; outline: none; background-position: initial initial; background-repeat: initial initial;\"></a>others</h3><ul class=\"task-list\" style=\"box-sizing: inherit; font-size: 14px; line-height: 24px; margin: 0px 0px 15px; padding-left: 30px; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; white-space: normal; background-color: rgb(250, 250, 250);\"><li>集成jsper report动态报表工具(未完成)</li><li>jpush消息推送</li></ul><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833523239.png\" style=\"float:none;\" title=\"cms.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833525442.png\" style=\"float:none;\" title=\"liuc2.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833517232.png\" style=\"float:none;\" title=\"menu.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833524270.png\" style=\"float:none;\" title=\"role1.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833524459.png\" style=\"float:none;\" title=\"流程.png\"/></p><p><br/></p>,', 'ommon泛型封装dao、service、controller基类，包含分页，查询条件封装，从而达到快速crud操作(参考springside4\")简易代码生成器,增加字段配置功能、生成页面功能，实现增删查改不需要写一句代码(参考jeesite)ehcache缓存springmvc 整合hibernate v', '25', '10', 'home1.png', '247', '50', '/static/ueditor/jsp/upload1/20161227/1482833523239.png,/static/ueditor/jsp/upload1/20161227/1482833525442.png,/static/ueditor/jsp/upload1/20161227/1482833517232.png,', '2016-12-27 18:12:03', '6', null, '1', null), ('42', '因库网校系统', 'ssm', '<p style=\"box-sizing: inherit; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250); margin-top: 0px !important;\"><strong style=\"box-sizing: inherit;\">免费开源网校系统源代码轻松搭建在线教育平台</strong></p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">因酷交流群①：468278040 (满)</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\"><br/></p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">因酷交流群②：164295773</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">官网:<a href=\"http://http//www.inxedu.com\" class=\"md_relative_url\" target=\"_blank\" style=\"box-sizing: inherit; color: rgb(65, 131, 196); text-decoration: none; background-color: transparent; cursor: pointer !important; word-wrap: break-word; background-position: initial initial; background-repeat: initial initial;\">http://www.inxedu.com</a></p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">演示站:<a href=\"http://http//demo1.inxedu.com\" class=\"md_relative_url\" target=\"_blank\" style=\"box-sizing: inherit; color: rgb(65, 131, 196); text-decoration: none; background-color: transparent; cursor: pointer !important; word-wrap: break-word; background-position: initial initial; background-repeat: initial initial;\">http://demo1.inxedu.com</a></p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">账号:<a href=\"mailto:demo@inxedu.com\" style=\"box-sizing: inherit; color: rgb(65, 131, 196); text-decoration: none; background-color: transparent; cursor: pointer !important; word-wrap: break-word; background-position: initial initial; background-repeat: initial initial;\">demo@inxedu.com</a></p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">密码:111111<br style=\"box-sizing: inherit;\"/><br style=\"box-sizing: inherit;\"/>网站功能模块:</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">课程功能</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">咨询功能</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">问答功能</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">首页banner推荐</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">播放模块</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">个人中心模块</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">个人资料模块</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">修改头像模块</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">收藏课程模块</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">问题总结:<br style=\"box-sizing: inherit;\"/>项目导入如果get set报错请添加lombok插件就可以正常使用了</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\"><strong style=\"box-sizing: inherit;\">技术框架</strong></p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">核心框架：Spring Framework</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">视图框架：Spring MVC</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">持久层框架：MyBatis 3</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">JS框架：jQuery</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">富文本：kindeditor</p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\"><strong style=\"box-sizing: inherit;\">开发环境</strong></p><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">建议开发者使用以下环境，这样避免版本带来的问题</p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833798198.png\" style=\"float:none;\" title=\"1index.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833794932.png\" style=\"float:none;\" title=\"2index.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482833799763.png\" style=\"float:none;\" title=\"3index.png\"/></p><p><br/></p>,', '免费开源网校系统源代码轻松搭建在线教育平台因酷交流群①：468278040 (满)因酷交流群②：164295773官网:http://www.inxedu.com演示站:http://demo1.inxedu.com账号:demo@inxedu.com密码:111111网站功能模块:课程功能咨询功能问答功能首', '8', '10', '1index.png', '238', '1', '/static/ueditor/jsp/upload1/20161227/1482833798198.png,/static/ueditor/jsp/upload1/20161227/1482833794932.png,/static/ueditor/jsp/upload1/20161227/1482833799763.png,', '2016-12-27 18:16:38', '0', '1', '1', null), ('43', 'jeesite后台框架', '', '<p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">1、后端</p><ul class=\"task-list\" style=\"box-sizing: inherit; font-size: 14px; line-height: 24px; margin: 0px 0px 15px; padding-left: 30px; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; white-space: normal; background-color: rgb(250, 250, 250);\"><li>核心框架：Spring Framework 4.1</li><li>安全框架：Apache Shiro 1.2</li><li>视图框架：Spring MVC 4.1</li><li>服务端验证：Hibernate Validator 5.2</li><li>布局框架：SiteMesh 2.4</li><li>工作流引擎：Activiti 5.21</li><li>任务调度：Spring Task 4.1</li><li>持久层框架：MyBatis 3.2</li><li>数据库连接池：Alibaba Druid 1.0</li><li>缓存框架：Ehcache 2.6、Redis</li><li>日志管理：SLF4J 1.7、Log4j</li><li>工具类：Apache Commons、Jackson 2.2、Xstream 1.4、Dozer 5.3、POI 3.9</li></ul><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">2、前端</p><ul class=\"task-list\" style=\"box-sizing: inherit; font-size: 14px; line-height: 24px; margin: 0px 0px 15px; padding-left: 30px; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; white-space: normal; background-color: rgb(250, 250, 250);\"><li>JS框架：jQuery 1.9。</li><li>CSS框架：Twitter Bootstrap 2.3.1（稳定是后台，UI方面根据需求自己升级改造吧）。</li><li>客户端验证：JQuery Validation Plugin 1.11。</li><li>富文本在线编辑：CKEditor</li><li>在线文件管理：CKFinder</li><li>动态页签：Jerichotab</li><li>手机端框架：Jingle</li><li>数据表格：jqGrid</li><li>对话框：jQuery jBox</li><li>下拉选择框：jQuery Select2</li><li>树结构控件：jQuery zTree</li><li>日期控件： My97DatePicker</li></ul><p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 15px; line-height: 25px; text-align: justify; word-break: break-word; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; font-size: 15px; white-space: normal; background-color: rgb(250, 250, 250);\">4、平台</p><ul class=\"task-list\" style=\"box-sizing: inherit; font-size: 14px; line-height: 24px; margin: 0px 0px 15px; padding-left: 30px; color: rgba(0, 0, 0, 0.8); font-family: Lato, &#39;Helvetica Neue&#39;, Arial, Helvetica, &#39;Microsoft YaHei&#39;, sans-serif; white-space: normal; background-color: rgb(250, 250, 250);\"><li>服务器中间件：在Java EE 5规范（Servlet 2.5、JSP 2.1）下开发，支持应用服务器中间件 有Tomcat 6+、Jboss 7+、WebLogic 10+、WebSphere 8+。</li><li>数据库支持：目前仅提供MySql和Oracle数据库的支持，但不限于数据库，平台留有其它数据库支持接口， 你可以很方便的更改为其它数据库，如：SqlServer 2008、MySql 5.5、H2等</li><li>开发环境：Java、Eclipse Java EE 4.3、Maven 3.1、Git</li></ul><p><br/></p>,', '1、后端核心框架：Spring Framework 4.1安全框架：Apache Shiro 1.2视图框架：Spring MVC 4.1服务端验证：Hibernate Validator 5.2布局框架：SiteMesh 2.4工作流引擎：Activiti 5.21任务调度：Spring Task 4.1持', '20', '10', 'zscat.png', '247', '50', '', '2016-12-27 18:21:25', '0', null, '1', null), ('44', 'zscat_妹子后台框架', 'ssm', '<p><img src=\"/static/ueditor/jsp/upload1/20161227/1482834426033.png\" style=\"float:none;\" title=\"1meizi.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482834430190.png\" style=\"float:none;\" title=\"2meizi.png\"/></p><p><img src=\"/static/ueditor/jsp/upload1/20161227/1482834431132.png\" style=\"float:none;\" title=\"3妹子1.png\"/></p><p><br/></p>,', '', '42', '10', '1meizi.png', '247', '55', '/static/ueditor/jsp/upload1/20161227/1482834426033.png,/static/ueditor/jsp/upload1/20161227/1482834430190.png,/static/ueditor/jsp/upload1/20161227/1482834431132.png,', '2016-12-27 18:27:07', '4', null, '1', null), ('49', '华迪空气净化器KJ420P-HD280', '', '<ul class=\"attributes-list\" style=\"margin: 0px; padding: 0px 15px; list-style: none; clear: both;\"><li>品牌:&nbsp;华迪</li><li>型号:&nbsp;KJ420P-HD280</li><li>噪音:&nbsp;0-35dB</li><li>控制方式:&nbsp;其他</li><li>智能类型:&nbsp;其他</li><li>颗粒物CADR值:&nbsp;420.1立方米/小时</li><li>颗粒物CCM值:&nbsp;P4(12000≤M)</li><li>风量:&nbsp;600立方米/小时</li><li>适用面积:&nbsp;30m^2-50m^2</li><li>功能:&nbsp;定时 除VOC 除花粉 除颗粒物 除甲醛 除烟除尘 杀菌 加湿 加氧</li><li>空气净化产品类别:&nbsp;空气净化器</li><li>风量:&nbsp;400 立方米/小时以上</li><li>电源方式:&nbsp;交流电</li><li>售后服务:&nbsp;店铺三包</li><li>适用对象:&nbsp;家用 卧室 办公室</li><li>空气净化器风量:&nbsp;400 立方米/小时</li></ul><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2591435385/TB2Qmv4XrRkpuFjSspmXXc.9XXa_!!2591435385.jpg\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2591435385/TB2XOn3XxXlpuFjSsphXXbJOXXa_!!2591435385.jpg\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2591435385/TB2JCv4Xr8kpuFjy0FcXXaUhpXa_!!2591435385.jpg\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2591435385/TB2Nrj2XBNkpuFjy0FaXXbRCVXa_!!2591435385.jpg\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2591435385/TB22Wv4XwJlpuFjSspjXXcT.pXa_!!2591435385.jpg\" class=\"\" width=\"750\" height=\"567\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2591435385/TB2plL4XC0jpuFjy0FlXXc0bpXa_!!2591435385.jpg\" class=\"\" width=\"750\" height=\"567\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2591435385/TB2T6T3XrVkpuFjSspcXXbSMVXa_!!2591435385.jpg\" class=\"\" width=\"750\" height=\"531\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2591435385/TB2TRL4XC0jpuFjy0FlXXc0bpXa_!!2591435385.jpg\" class=\"\" width=\"750\" height=\"720\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2591435385/TB2nzn2Xw0kpuFjSspdXXX4YXXa_!!2591435385.jpg\" class=\"\" width=\"750\" height=\"759\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2591435385/TB2Wmz4Xr8kpuFjy0FcXXaUhpXa_!!2591435385.jpg\" class=\"\" width=\"750\" height=\"828\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2591435385/TB2GAn3XxXkpuFjy0FiXXbUfFXa_!!2591435385.jpg\" class=\"\" width=\"750\" height=\"684\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2591435385/TB2PAn3XxXkpuFjy0FiXXbUfFXa_!!2591435385.jpg\" class=\"\" width=\"750\" height=\"477\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2591435385/TB2_Y_3XCtkpuFjy0FhXXXQzFXa_!!2591435385.jpg\" class=\"\" width=\"750\" height=\"720\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2591435385/TB2VJP4XrtlpuFjSspoXXbcDpXa_!!2591435385.jpg\" class=\"\" width=\"750\" height=\"651\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/></p><p><br/></p>,', '品牌: 华迪型号: KJ420P-HD280噪音: 0-35dB控制方式: 其他智能类型: 其他颗粒物CADR值: 420.1立方米/小时颗粒物CCM值: P4(12000≤M)风量: 600立方米/小时适用面积: 30m^2-50m^2功能: 定时 除VOC 除花粉 除颗粒物 除甲醛 除烟除尘 杀菌 加湿 ', '13', '13', '1智能.jpg', '250', '3980', 'https://img.alicdn.com/imgextra/i2/2591435385/TB2Qmv4XrRkpuFjSspmXXc.9XXa_!!2591435385.jpg,https://img.alicdn.com/imgextra/i2/2591435385/TB2XOn3XxXlpuFjSsphXXbJOXXa_!!2591435385.jpg,https://img.alicdn.com/imgextra/i1/2591435385/TB2JCv4Xr8kpuFjy0FcXXaUhpXa_!!2591435385.jpg,', '2017-01-06 13:22:42', '0', '2', '7', null), ('50', '华迪智能空气净化器', '', '<ul class=\"attributes-list\" style=\"margin: 0px; padding: 0px 15px; list-style: none; clear: both;\"><li>品牌:&nbsp;华迪</li><li>型号:&nbsp;HD-AP100</li><li>智能类型:&nbsp;其他</li></ul><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><img src=\"https://img.alicdn.com/imgextra/i2/2591435385/TB2Jw99spXXXXcNXpXXXXXXXXXX_!!2591435385.png\" align=\"absmiddle\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img src=\"https://img.alicdn.com/imgextra/i3/2591435385/TB2MW2xspXXXXXVXpXXXXXXXXXX_!!2591435385.png\" align=\"absmiddle\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img src=\"https://img.alicdn.com/imgextra/i4/2591435385/TB2xO6yspXXXXXVXpXXXXXXXXXX_!!2591435385.png\" align=\"absmiddle\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img src=\"https://img.alicdn.com/imgextra/i4/2591435385/TB2Tcm_spXXXXXiXFXXXXXXXXXX_!!2591435385.png\" align=\"absmiddle\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img src=\"https://img.alicdn.com/imgextra/i1/2591435385/TB2oxv8spXXXXXCXXXXXXXXXXXX_!!2591435385.png\" class=\"\" align=\"absmiddle\" width=\"800\" height=\"626\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img src=\"https://img.alicdn.com/imgextra/i4/2591435385/TB2xOHgspXXXXceXpXXXXXXXXXX_!!2591435385.png\" class=\"\" align=\"absmiddle\" width=\"800\" height=\"610\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img src=\"https://img.alicdn.com/imgextra/i3/2591435385/TB2JTHLspXXXXcqXXXXXXXXXXXX_!!2591435385.png\" class=\"\" align=\"absmiddle\" width=\"800\" height=\"539\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/></p><p><br/></p>,', '品牌: 华迪型号: HD-AP100智能类型: 其他', '32', '13', '1智能.jpg', '250', '2280', 'https://img.alicdn.com/imgextra/i2/2591435385/TB2Jw99spXXXXcNXpXXXXXXXXXX_!!2591435385.png,https://img.alicdn.com/imgextra/i3/2591435385/TB2MW2xspXXXXXVXpXXXXXXXXXX_!!2591435385.png,https://img.alicdn.com/imgextra/i4/2591435385/TB2xO6yspXXXXXVXpXXXXXXXXXX_!!2591435385.png,', '2017-05-20 13:24:02', '0', null, '7', null), ('51', '华迪智能网关HDG6200', '', '<ul class=\"attributes-list\" style=\"margin: 0px; padding: 0px 15px; list-style: none; clear: both;\"><li>兼容平台:&nbsp;ANDROID</li><li>品牌:&nbsp;华迪</li><li>连接方式:&nbsp;Wi-Fi连接</li><li>颜色:&nbsp;白色</li><li>颜色分类:&nbsp;白色</li></ul><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><span style=\"color: rgb(108, 108, 108); line-height: 14.4px; font-size: 12px;\">支持智能家居功能、云电脑功能、网络机顶盒功能、无线路由器热点功能、支持与指定型号智能路由器家庭联网功能、支持物业管理系统、支持宽频系统、整合支持数百个互联网应用<img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2591435385/TB2R5nXspXXXXa_XpXXXXXXXXXX_!!2591435385.jpg\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2591435385/TB2EfYaspXXXXbPXpXXXXXXXXXX_!!2591435385.jpg\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/></span></p><p><br/></p>,', '兼容平台: ANDROID品牌: 华迪连接方式: Wi-Fi连接颜色: 白色颜色分类: 白色支持智能家居功能、云电脑功能、网络机顶盒功能、无线路由器热点功能、支持与指定型号智能路由器家庭联网功能、支持物业管理系统、支持宽频系统、整合支持数百个互联网应用', '2', '13', '3智能.png', '251', '339', 'https://img.alicdn.com/imgextra/i4/2591435385/TB2R5nXspXXXXa_XpXXXXXXXXXX_!!2591435385.jpg,https://img.alicdn.com/imgextra/i1/2591435385/TB2EfYaspXXXXbPXpXXXXXXXXXX_!!2591435385.jpg,', '2017-01-06 13:25:33', '0', '2', '7', null), ('52', '华迪智能插排', '', '<p><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2591435385/TB2fBlRaH1K.eBjSszbXXcTHpXa_!!2591435385.png\" style=\"border: 0px; vertical-align: top; font-family: tahoma, arial, 宋体, sans-serif; font-size: 14px; line-height: 21px; white-space: normal; background-color: rgb(255, 255, 255); max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2591435385/TB2jAxMaHaI.eBjSspaXXXIKpXa_!!2591435385.png\" style=\"border: 0px; vertical-align: top; font-family: tahoma, arial, 宋体, sans-serif; font-size: 14px; line-height: 21px; white-space: normal; background-color: rgb(255, 255, 255); max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/2591435385/TB2WeRSaNmJ.eBjy0FhXXbBdFXa_!!2591435385.png\" style=\"border: 0px; vertical-align: top; font-family: tahoma, arial, 宋体, sans-serif; font-size: 14px; line-height: 21px; white-space: normal; background-color: rgb(255, 255, 255); max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2591435385/TB2o1RQaIeJ.eBjy0FiXXXqapXa_!!2591435385.png\" style=\"border: 0px; vertical-align: top; font-family: tahoma, arial, 宋体, sans-serif; font-size: 14px; line-height: 21px; white-space: normal; background-color: rgb(255, 255, 255); max-width: 750px;\"/></p>,', '', '3', '13', '4智能.jpg', '251', '139', 'https://img.alicdn.com/imgextra/i3/2591435385/TB2fBlRaH1K.eBjSszbXXcTHpXa_!!2591435385.png,https://img.alicdn.com/imgextra/i2/2591435385/TB2jAxMaHaI.eBjSspaXXXIKpXa_!!2591435385.png,https://img.alicdn.com/imgextra/i4/2591435385/TB2WeRSaNmJ.eBjy0FhXXbBdFXa_!!2591435385.png,', '2017-01-06 13:26:38', '0', null, '7', null), ('53', '华迪智能控制面板', '', '<ul class=\"attributes-list\" style=\"margin: 0px; padding: 0px 15px; list-style: none; clear: both;\"><li>品牌:&nbsp;华迪</li><li>型号:&nbsp;HD-CP100</li><li>智能类型:&nbsp;其他</li><li>颜色分类:&nbsp;白色 黑色</li></ul><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2591435385/TB2FvL6aigSXeFjy0FcXXahAXXa_!!2591435385.png\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2591435385/TB29AVQaHaI.eBjSszdXXaB6XXa_!!2591435385.png\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2591435385/TB2BztNaHeI.eBjSspkXXaXqVXa_!!2591435385.png\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2591435385/TB2EvP6aigSXeFjy0FcXXahAXXa_!!2591435385.png\" style=\"border: 0px; vertical-align: top; max-width: 750px;\"/></p><p><br/></p>,', '品牌: 华迪型号: HD-CP100智能类型: 其他颜色分类: 白色 黑色', '14', '13', '5智能.png', '251', '129', 'https://img.alicdn.com/imgextra/i3/2591435385/TB2FvL6aigSXeFjy0FcXXahAXXa_!!2591435385.png,https://img.alicdn.com/imgextra/i2/2591435385/TB29AVQaHaI.eBjSszdXXaB6XXa_!!2591435385.png,https://img.alicdn.com/imgextra/i1/2591435385/TB2BztNaHeI.eBjSspkXXaXqVXa_!!2591435385.png,', '2017-05-20 13:27:41', '0', '1', '7', null), ('54', '华迪智能灯泡', '', '<ul class=\"attributes-list\" style=\"margin: 0px; padding: 0px 15px; list-style: none; clear: both;\"><li>品牌:&nbsp;华迪</li><li>型号:&nbsp;HD-LL100</li><li>智能类型:&nbsp;其他</li><li>颜色分类:&nbsp;白色</li></ul><p style=\"margin-top: 1.12em; margin-bottom: 1.12em; padding: 0px;\"><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2591435385/TB2lxjGoFXXXXa0XXXXXXXXXXXX_!!2591435385.png\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/2591435385/TB2Tb_woFXXXXcxXXXXXXXXXXXX_!!2591435385.png\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/2591435385/TB28PHAoFXXXXaGXXXXXXXXXXXX_!!2591435385.png\" style=\"border: 0px; vertical-align: top;\"/><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/2591435385/TB2ZVHuoFXXXXXAXpXXXXXXXXXX_!!2591435385.png\" style=\"border: 0px; vertical-align: top;\"/></p><p><br/></p>,', '品牌: 华迪型号: HD-LL100智能类型: 其他颜色分类: 白色', '26', '13', '6智能.png', '251', '99', 'https://img.alicdn.com/imgextra/i3/2591435385/TB2lxjGoFXXXXa0XXXXXXXXXXXX_!!2591435385.png,https://img.alicdn.com/imgextra/i2/2591435385/TB2Tb_woFXXXXcxXXXXXXXXXXXX_!!2591435385.png,https://img.alicdn.com/imgextra/i3/2591435385/TB28PHAoFXXXXaGXXXXXXXXXXXX_!!2591435385.png,', '2017-01-06 13:28:46', '0', '2', '7', null), ('63', '三星Galaxy S||| I9300下单立100', 'san', '11111111111111', null, '1', '14', 'classify-ph02.png', '213', '46', '', '2017-05-20 14:04:17', '0', '1', '2', null), ('64', '移动版 Iphone 5s 支持4G 特价！全新移动Iphone', '', '', null, '1', '14', 'classify-ph03.png', '257', '52', '', '2017-05-02 14:05:41', '0', null, '2', null), ('65', '苹果 手机iPhone5S（16G）& #40;金& #41;4968抢购中！货源有限', '22', '22', null, '1', '14', 'classify-ph04.png', '259', '65', '', '2017-05-10 14:06:26', '8', '1', '2', null), ('66', '索尼（SONY） Xperia SP M3 5C电信3G手机（白色）', '', '', null, '2', '14', 'classify-ph05.png', '260', '522', '', '2017-05-16 14:07:22', '0', '1', '2', null), ('67', '夏新 大V二代 A920W 3G手机（睿智蓝）WCDMA/GSM', '2', '2', null, '1', '14', 'detail-ban02.png', '261', '56', '', '2017-05-20 14:07:49', '0', null, '2', null), ('68', 'Lenovo/联想 联想 K900金', '', '', null, '1', '14', 'detail-ban03.png', '261', '222', '', '2017-05-08 14:08:39', '1', null, '2', null), ('69', '小米五洲', '', '', null, '2', '14', 'homenav4.png', '263', '233', '', '2017-05-20 14:09:13', '0', null, '2', null), ('70', 'htc one', '', '', null, '5', '14', 'homenav3.png', '259', '23', '', '2017-05-01 14:09:43', '0', '1', '2', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_link`
-- ----------------------------
DROP TABLE IF EXISTS `t_link`;
CREATE TABLE `t_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linkName` varchar(100) DEFAULT NULL COMMENT '名称',
  `linkUrl` varchar(200) DEFAULT NULL COMMENT 'url',
  `orderNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_link`
-- ----------------------------
BEGIN;
INSERT INTO `t_link` VALUES ('1', 'zscat官网', 'http://www.zscat.top/gw/index', '1'), ('2', 'zscat商城', 'http://shop.zscat.top/index.htm', '2'), ('3', 'zscat内容管理系统', 'http://www.zscat.top/cms/index', '3'), ('4', 'zscat后台', 'http://www.zscat.top/index', '4'), ('5', '免费logo在线制作', 'http://www.uugai.com/', '5'), ('6', 'test', 'test6', '6'), ('7', '22', '22', '22'), ('8', '123', '123', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_member`
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `addtime` datetime DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `qq` varchar(255) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(255) DEFAULT NULL COMMENT 'EMAIL',
  `trueName` varchar(255) DEFAULT NULL COMMENT '昵称',
  `gold` int(11) DEFAULT NULL COMMENT '金币',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `address` varchar(255) DEFAULT NULL,
  `storeid` bigint(20) DEFAULT NULL COMMENT '商铺',
  `img` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_member`
-- ----------------------------
BEGIN;
INSERT INTO `t_member` VALUES ('54', '123', 'babc156ac796828d0d08625f86f6dc55', '2017-05-20 13:46:25', null, null, null, '123', '2', '1', '192.168.1.6', '7', 'default.jpg', null), ('55', '456', 'c8194c09ac51a2c23e44cd67165341a9', '2017-05-20 13:57:38', null, null, null, '456', '9', '1', '192.168.1.6', '2', '3.jpg', null), ('56', 'admin', '86f3059b228c8acf99e69734b6bb32cc', '2017-05-21 03:59:44', '', '', '', 'admin', '5', '1', '192.168.1.6', '1', '2.jpg', null), ('57', '789456', '6d8c4a09e0a855920cb8ef25a019c62f', '2017-09-03 16:07:49', null, null, null, '789456', '0', '1', '192.168.1.102', null, '1.jpg', null), ('58', '专', 'oDIzz0M1TJ77dw46jXsawJqId84g', '2017-10-19 18:03:21', null, null, null, '专', '0', '1', 'China-Beijing-Chaoyang', '1', 'https://wx.qlogo.cn/mmopen/vi_32/iaGr8vffqgqiaE3ibNzh9NN8ASiasYCxl4yA2dU7iaMdVjXJREBKCDR5Pr2IdN4lB9PvFzaJWpgicb1lN5zRRdichmjvg/0', '男'), ('59', '456789', 'd3c46518cce2d78bc967ffc84ebc9d0c', null, null, null, null, '456789', null, '1', null, null, '0.jpg', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `totalprice` decimal(10,0) DEFAULT NULL COMMENT '总价格',
  `totalcount` int(255) DEFAULT NULL COMMENT '总个数',
  `ordersn` varchar(255) DEFAULT NULL COMMENT '订单号',
  `status` int(255) DEFAULT '1' COMMENT '状态',
  `userid` bigint(11) DEFAULT NULL COMMENT '用户',
  `createdate` datetime DEFAULT NULL,
  `paymentid` bigint(11) DEFAULT NULL,
  `addressid` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `usercontent` varchar(255) DEFAULT NULL,
  `couponid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_order`
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES ('83', '1154', '7', 'RXJLD3B3', '9', '1', '2017-12-01 20:43:38', '0', '1', '0', null, '1'), ('84', '1154', '7', 'L3OLSWME', '9', '1', '2017-12-01 20:43:43', '0', '1', '0', null, '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_order_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_log`;
CREATE TABLE `t_order_log` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '订单处理历史索引id',
  `order_id` bigint(11) NOT NULL COMMENT '订单id',
  `order_state` varchar(20) NOT NULL COMMENT '订单状态信息',
  `change_state` varchar(20) DEFAULT NULL COMMENT '下一步订单状态信息',
  `state_info` varchar(20) NOT NULL COMMENT '订单状态描述',
  `create_time` bigint(13) DEFAULT NULL COMMENT '处理时间',
  `operator` varchar(30) NOT NULL COMMENT '操作人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=863 DEFAULT CHARSET=utf8 COMMENT='订单处理历史表';

-- ----------------------------
--  Records of `t_order_log`
-- ----------------------------
BEGIN;
INSERT INTO `t_order_log` VALUES ('861', '83', '1', null, '提交订单', '1512132218944', '1'), ('862', '84', '1', null, '提交订单', '1512132225687', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_push_task`
-- ----------------------------
DROP TABLE IF EXISTS `t_push_task`;
CREATE TABLE `t_push_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `template_id` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小程序模版ID',
  `task_name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模版名称',
  `task_topic` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动主题',
  `task_caption` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动说明',
  `task_tips` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '温馨提示',
  `task_type` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '任务类型',
  `status` int(1) DEFAULT NULL COMMENT '任务是否已经发送 1 未发送[默认] 2 已发送',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `goods_name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品标题',
  `goods_online_status` int(2) DEFAULT NULL COMMENT '商品前台状态 1 上架 0 下架',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品金额（需要的海贝数）',
  `is_upload` int(1) DEFAULT NULL,
  `file_name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `t_push_task`
-- ----------------------------
BEGIN;
INSERT INTO `t_push_task` VALUES ('99', '895CZeh4-ISI3cpl1yyS-o_i6EtMfrC8bzgaipHauF0', '活动加入成功提醒', '【免费领】减脂面包', '原价39.9元抹茶代餐面包\n「限量50个免费名额」', '点此消息立即参与吧！', '指定用户发送', '2', '2348', '橙子快跑全麦面包抹茶蔓越莓口味600g', '1', '88.00', '1', '订单信息 (7).xlsx', '2018-09-18 10:46:21', '2018-09-18 15:17:22'), ('100', '895CZeh4-ISI3cpl1yyS-o_i6EtMfrC8bzgaipHauF0', '活动加入成功提醒', '【免费领】减脂面包', '原价39.9元抹茶代餐面包\n「限量50个免费名额」', '点此消息立即参与吧！', '指定用户发送', '2', '2348', '橙子快跑全麦面包抹茶蔓越莓口味600g', '1', '88.00', '1', '订单信息 (7).xlsx', '2018-09-18 15:18:58', '2018-09-18 15:25:55'), ('101', '895CZeh4-ISI3cpl1yyS-o_i6EtMfrC8bzgaipHauF0', '活动加入成功提醒', '【免费领】减脂面包', '原价39.9元抹茶代餐面包\n「限量50个免费名额」', '点此消息立即参与吧！', '指定用户发送', '2', '2348', '橙子快跑全麦面包抹茶蔓越莓口味600g', '1', '88.00', '1', '订单信息 (7).xlsx', '2018-09-18 15:30:23', '2018-09-18 15:40:50'), ('102', '895CZeh4-ISI3cpl1yyS-o_i6EtMfrC8bzgaipHauF0', '活动加入成功提醒', '【免费领】减脂面包', '原价39.9元抹茶代餐面包\n「限量50个免费名额」', '点此消息立即参与吧！', '指定用户发送', '2', '2348', '橙子快跑全麦面包抹茶蔓越莓口味600g', '1', '88.00', '1', '订单信息 (7).xlsx', '2018-09-18 15:48:48', '2018-09-18 15:49:27'), ('103', '895CZeh4-ISI3cpl1yyS-o_i6EtMfrC8bzgaipHauF0', '活动加入成功提醒', '【限量特价】去污神器', '原价38海贝去污神器\n「限量50个特价名额」', '点此消息立即参与！', '指定用户发送', '2', '2371', '小白神器二代鞋子清洁喷雾瓶100ml', '1', '38.00', '1', '订单信息 (7).xlsx', '2018-09-18 15:55:41', '2018-09-18 16:11:28');
COMMIT;

-- ----------------------------
--  Table structure for `t_push_task_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_push_task_user`;
CREATE TABLE `t_push_task_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) DEFAULT NULL COMMENT '推送ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `form_id` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小程序推送formId',
  `status` int(2) DEFAULT NULL COMMENT '推送状态 1 已推送 2 未推送',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_push_user_from_id_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_push_user_from_id_record`;
CREATE TABLE `t_push_user_from_id_record` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  `form_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小程序推送formId',
  `source` smallint(2) DEFAULT NULL COMMENT '来源 source 1，步数兑换海贝按钮；2，首页邀请按钮；3，步数拦截弹窗邀请按钮；4，兑换商品按钮；\n\n5，海贝不够邀请按钮；6，引导关注蒙层按钮；7，健康体验领取按钮',
  `status` smallint(2) DEFAULT NULL COMMENT '使用状态 1 未使用[默认] 2 已使用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `_idx_form_id_` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_reply`
-- ----------------------------
DROP TABLE IF EXISTS `t_reply`;
CREATE TABLE `t_reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodsid` bigint(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `userid` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_reply`
-- ----------------------------
BEGIN;
INSERT INTO `t_reply` VALUES ('1', '70', '回复', '2017-10-18 18:35:05', '1', '1', '123yser'), ('2', '70', '3333', '2017-10-03 18:35:24', '1', '2', '3333');
COMMIT;

-- ----------------------------
--  Table structure for `t_store`
-- ----------------------------
DROP TABLE IF EXISTS `t_store`;
CREATE TABLE `t_store` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` bit(1) NOT NULL DEFAULT b'0',
  `storeAddress` varchar(255) DEFAULT NULL,
  `storeCredit` int(11) DEFAULT NULL,
  `storeInfo` longtext,
  `storeMsn` varchar(255) DEFAULT NULL,
  `storeName` varchar(255) DEFAULT NULL COMMENT '名称',
  `storeOwer` varchar(255) DEFAULT NULL,
  `storeQq` varchar(255) DEFAULT NULL,
  `storeRecommend` bit(1) DEFAULT NULL,
  `storeSeoDescription` longtext,
  `storeSeoKeywords` longtext,
  `storeStatus` int(11) DEFAULT '3',
  `storeTelephone` varchar(255) DEFAULT NULL,
  `storeZip` varchar(255) DEFAULT NULL,
  `template` varchar(255) DEFAULT NULL,
  `areaId` bigint(20) DEFAULT NULL,
  `storeBannerId` bigint(20) DEFAULT NULL,
  `storeLicenseId` bigint(20) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  `favoriteCount` int(11) DEFAULT '0',
  `storeLat` decimal(6,2) DEFAULT NULL,
  `storeLng` decimal(6,2) DEFAULT NULL,
  `storeWw` varchar(255) DEFAULT NULL,
  `mapType` varchar(255) DEFAULT 'baidu',
  `storeDistribution` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_store`
-- ----------------------------
BEGIN;
INSERT INTO `t_store` VALUES ('1', '2017-05-20 13:50:28', b'0', '北京海淀', null, '销售和研发所有的分布式框架相关的产品', '13146587711', 'zscat名车销售店', 'zscat小架', '951449465', null, null, null, '3', '13146587711', null, null, null, null, null, 'logo.png', '0', null, null, null, 'baidu', null), ('2', '2017-05-20 13:50:28', b'0', '北京海淀', null, '销售和研发所有的手机相关的产品', '13146587711', 'zscat美女店', 'zscat小欣', '951449465', null, null, null, '3', '13146587711', null, null, null, null, null, 'shouji.jpg', '0', null, null, null, 'baidu', null), ('7', '2017-05-20 13:50:28', b'0', '北京朝阳', null, '销售和研发所有的智能家居相关的产品', '13146587711', 'zscat名牌包包店', 'zscat小新', '951449465', null, null, null, '3', '13146587722', null, null, null, null, null, 'elk.png', '0', null, null, null, 'baidu', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_topic`
-- ----------------------------
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `stat` char(1) DEFAULT '0' COMMENT '删除标记(0活null 正常 1,删除)',
  `clickhit` int(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_topic`
-- ----------------------------
BEGIN;
INSERT INTO `t_topic` VALUES ('1', 'zscat框架话题', '2016-12-22 09:59:15', '1', '11', 'zscat.png', 'XXXXcXFXXXXXXXXXX_!!2541510480.png\" class=\"\" width=\"1356\" height=\"585\" style=\"border: 0px; vertical-align: top;\"/></p><h5 style=\"margin: 0px 0px 0px 10px; padding: 0px; font-size: 15px; height: 22px;\">邻家好货</h5><p><br/></p>,'), ('2', '商城话题', '2016-12-22 10:09:37', '2', '2', 'shop.png', 'ommon泛型封装dao、service、controller基类，包含分页，查询条件封装，从而达到快速crud操作(参考springside4\")简易代码生成器,增加字段配置功能、生成页面功能，实现增删查改不需要写一句代码(参考jeesite)ehcache缓存springmvc 整合hibernate v');
COMMIT;

-- ----------------------------
--  Table structure for `t_user_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_coupon`;
CREATE TABLE `t_user_coupon` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `coupon_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_user_coupon`
-- ----------------------------
BEGIN;
INSERT INTO `t_user_coupon` VALUES ('1', '58', '3'), ('2', '58', '2'), ('3', '58', '1'), ('4', '58', '4'), ('5', '58', '5'), ('6', '58', '6');
COMMIT;

-- ----------------------------
--  Table structure for `t_user_jfgoods`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_jfgoods`;
CREATE TABLE `t_user_jfgoods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodsid` bigint(20) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `goodsname` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_user_jfgoods`
-- ----------------------------
BEGIN;
INSERT INTO `t_user_jfgoods` VALUES ('87', '66', '1', 'classify-ph05.png', '索尼（SONY） Xperia SP M3 5C电信3G手机（白色）', null, '522'), ('88', '70', '1', 'homenav3.png', 'htc one', null, '23'), ('89', '70', '1', 'homenav3.png', 'htc one', null, '23'), ('90', '68', '1', 'detail-ban03.png', 'Lenovo/联想 联想 K900金', null, '222'), ('91', '68', '1', 'detail-ban03.png', 'Lenovo/联想 联想 K900金', null, '222');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
