/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost
 Source Database       : zscat-label

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : utf-8

 Date: 12/02/2018 18:19:55 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tb_label`
-- ----------------------------
DROP TABLE IF EXISTS `tb_label`;
CREATE TABLE `tb_label` (
  `label_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `label_group_id` int(11) DEFAULT NULL COMMENT '标签分组ID',
  `label_type` int(11) DEFAULT NULL COMMENT '标签类型 手动标签（1） 自动标签（2）',
  `label_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标签名称',
  `label_status` int(11) DEFAULT NULL COMMENT '标签状态 激活（1）已停用（2）',
  `is_user_show` int(11) DEFAULT NULL COMMENT '用户端是否展示 用户端展示（2）用户端不展示（1）',
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生效条件。上市月份，包含当前月',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建人 userId',
  `is_delete` int(1) DEFAULT '0' COMMENT '删除状态 未删除(0)  已删除(1)',
  `last_update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `last_update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人 userId',
  `label_partition` int(11) DEFAULT NULL COMMENT '标签大类 用户标签(1)  内容标签(2)  兼容标签(3) ',
  `parent_id` int(11) DEFAULT NULL COMMENT '标签父ID',
  PRIMARY KEY (`label_id`),
  KEY `_idx_label_partition_` (`label_partition`),
  KEY `_idx_label_group_id_` (`label_group_id`),
  KEY `_idx_label_type_` (`label_type`),
  KEY `_idx_is_user_show_` (`is_user_show`),
  KEY `_idx_label_status_` (`label_status`),
  KEY `_idx_create_time_` (`create_time`),
  KEY `_idx_is_delete_` (`is_delete`)
) ENGINE=InnoDB AUTO_INCREMENT=561 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='标签表';

-- ----------------------------
--  Table structure for `tb_label_group`
-- ----------------------------
DROP TABLE IF EXISTS `tb_label_group`;
CREATE TABLE `tb_label_group` (
  `label_group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签分组ID',
  `label_group_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标签分组名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建人 userId',
  `is_delete` int(1) DEFAULT '0' COMMENT '删除状态 未删除(0)  已删除(1)',
  `last_update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `last_update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人 userId',
  PRIMARY KEY (`label_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='标签分组';

-- ----------------------------
--  Table structure for `tb_label_relation`
-- ----------------------------
DROP TABLE IF EXISTS `tb_label_relation`;
CREATE TABLE `tb_label_relation` (
  `label_relation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签关系ID',
  `label_id` int(11) DEFAULT NULL COMMENT '标签ID',
  `label_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标签名称',
  `label_partition` int(11) DEFAULT NULL COMMENT '标签大类',
  `label_group_id` int(11) DEFAULT NULL COMMENT '标签分组ID',
  `relation_id` int(11) DEFAULT NULL COMMENT '关联ID',
  `relation_type` int(11) DEFAULT NULL COMMENT '关联类型 全部/不限(0) 用户(1) 食材(2) 标签(4) 任务(5) 媒体资源/营销软文(6) 问卷(7)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建人 userId',
  `is_delete` int(1) DEFAULT '0' COMMENT '删除状态 未删除(0)  已删除(1)',
  `last_update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `last_update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人 userId',
  PRIMARY KEY (`label_relation_id`),
  KEY `_idx_label_id_` (`label_id`),
  KEY `_idx_is_delete_` (`is_delete`)
) ENGINE=InnoDB AUTO_INCREMENT=642732 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='标签关联关系表';

SET FOREIGN_KEY_CHECKS = 1;
