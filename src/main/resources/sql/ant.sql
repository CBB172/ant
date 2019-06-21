/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : ant

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-06-21 17:27:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ant_dict`
-- ----------------------------
DROP TABLE IF EXISTS `ant_dict`;
CREATE TABLE `ant_dict` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_name` varchar(255) NOT NULL,
  `dict_property` int(11) NOT NULL,
  `dict_show` varchar(255) NOT NULL,
  `isvalid` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of ant_dict
-- ----------------------------
INSERT INTO `ant_dict` VALUES ('1', 'ant_record_author', '0', '公开', '1');
INSERT INTO `ant_dict` VALUES ('2', 'ant_record_author', '1', '好友可见', '1');
INSERT INTO `ant_dict` VALUES ('3', 'ant_record_author', '2', '私密', '1');

-- ----------------------------
-- Table structure for `ant_record`
-- ----------------------------
DROP TABLE IF EXISTS `ant_record`;
CREATE TABLE `ant_record` (
  `record_id` int(11) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `record_title` varchar(255) NOT NULL,
  `content_detail` text NOT NULL,
  `content_brief` text NOT NULL,
  `publish_time` int(11) NOT NULL,
  `author` int(11) NOT NULL,
  `classify` int(11) NOT NULL,
  `view_count` int(11) NOT NULL,
  `approve_count` int(11) NOT NULL,
  `disapprove_count` int(11) NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isvalid` tinyint(1) NOT NULL DEFAULT '1',
  `istop` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of ant_record
-- ----------------------------
INSERT INTO `ant_record` VALUES ('1', '1723693876', '日志1', '这个人很懒...asdad', '这个人.jkl', '141', '0', '1', '12', '158', '5', '2019-06-18 14:13:46', '1', '0');
INSERT INTO `ant_record` VALUES ('2', '1723693876', '日志1撒打算大奥', '这个人很懒...zc', '这个人.gh', '142', '0', '1', '13', '159', '5', '2019-06-18 14:13:47', '1', '0');
INSERT INTO `ant_record` VALUES ('3', '1723693876', '日志1asddsa', '这个人很懒...zcx', '这个人.jm', '143', '0', '2', '15', '151', '5', '2019-06-18 14:13:48', '1', '0');
INSERT INTO `ant_record` VALUES ('4', '1723693876', '日志1asdsda', '这个人很懒...dfg', '这个人.kjl,', '144', '0', '3', '17', '152', '5', '2019-06-18 14:13:49', '1', '0');
INSERT INTO `ant_record` VALUES ('5', '1723693876', '日志1asd', '这个人很懒...asd', '这个人.hj', '145', '0', '1', '129', '153', '5', '2019-06-18 14:13:50', '1', '0');
INSERT INTO `ant_record` VALUES ('6', '1723693876', '日志1sdf', '这个人很懒...asd', '这个人.ghj', '146', '0', '2', '123', '154', '5', '2019-06-18 14:13:50', '1', '0');
INSERT INTO `ant_record` VALUES ('7', '1723693876', '日志1dfg', '这个人很懒...asd', '这个人.jmbnm', '147', '0', '3', '122', '155', '5', '2019-06-18 14:13:51', '1', '0');
INSERT INTO `ant_record` VALUES ('8', '1723693876', '日志1dfg', '这个人很懒...ad', '这个人.bm', '148', '0', '1', '123', '156', '5', '2019-06-18 14:13:52', '1', '0');
INSERT INTO `ant_record` VALUES ('9', '1723693876', '日志1fgh', '这个人很懒...a', '这个人.bm', '149', '0', '2', '124', '157', '5', '2019-06-18 14:13:53', '1', '0');
INSERT INTO `ant_record` VALUES ('10', '1723693876', '日志1cv', '这个人很懒...bgg', '这个人.bm', '150', '0', '3', '125', '158', '5', '2019-06-18 14:13:54', '1', '0');
INSERT INTO `ant_record` VALUES ('11', '1723693876', '日志1zxczc', '这个人很懒...x', '这个人.bm', '151', '0', '1', '126', '159', '5', '2019-06-18 14:13:54', '1', '0');
INSERT INTO `ant_record` VALUES ('12', '1723693876', '日志1124we', '这个人很懒...a', '这个人.gh', '152', '0', '1', '127', '150', '5', '2019-06-18 14:13:57', '1', '0');

-- ----------------------------
-- Table structure for `ant_record_classify`
-- ----------------------------
DROP TABLE IF EXISTS `ant_record_classify`;
CREATE TABLE `ant_record_classify` (
  `classify_id` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(11) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `classify_name` varchar(255) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `author` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isvalid` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`classify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='日志分类表';

-- ----------------------------
-- Records of ant_record_classify
-- ----------------------------
INSERT INTO `ant_record_classify` VALUES ('1', '0', '1723693876', '旅游日志', '这是一级分类', '0', '0', '2019-06-14 13:20:08', '1');
INSERT INTO `ant_record_classify` VALUES ('2', '0', '1723693876', 'JAVA日志', '这是一级分类', '0', '0', '2019-06-14 13:20:12', '1');
INSERT INTO `ant_record_classify` VALUES ('3', '0', '1723693876', '小狗日志', '这是一级分类', '0', '0', '2019-06-14 13:20:30', '1');
INSERT INTO `ant_record_classify` VALUES ('4', '0', '1723693876', '小猫日志', '这是一级分类', '0', '0', '2019-06-14 13:20:23', '1');

-- ----------------------------
-- Table structure for `ant_record_pic`
-- ----------------------------
DROP TABLE IF EXISTS `ant_record_pic`;
CREATE TABLE `ant_record_pic` (
  `pic_id` int(11) NOT NULL AUTO_INCREMENT,
  `record_id` int(11) NOT NULL,
  `pic_url` varchar(255) NOT NULL,
  PRIMARY KEY (`pic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志图片地址';

-- ----------------------------
-- Records of ant_record_pic
-- ----------------------------

-- ----------------------------
-- Table structure for `ant_talk`
-- ----------------------------
DROP TABLE IF EXISTS `ant_talk`;
CREATE TABLE `ant_talk` (
  `talk_id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `publish_time` int(255) NOT NULL,
  `author` smallint(6) NOT NULL DEFAULT '0' COMMENT '说说权限',
  `view_count` int(11) NOT NULL,
  `approve_count` int(11) NOT NULL,
  `disapprove_count` int(11) NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `isvalid` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`talk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of ant_talk
-- ----------------------------
INSERT INTO `ant_talk` VALUES ('1', '1234', 'BDJKWALNDJASKLNDWAJKLd的陈年旧事可能大家思考', '0', '0', '1', '2', '3', '2019-06-11 21:10:11', '1');
INSERT INTO `ant_talk` VALUES ('2', '1234', '田秀英，听啊天，每天如此的无聊，如此的不堪。。。', '0', '0', '1', '2', '3', '2019-06-12 15:57:41', '1');
INSERT INTO `ant_talk` VALUES ('3', '1234', '的话剧傻空了每次打开拉萨啊就彻底啥肌肤底扫几次都是哦啊叫啥程度健康佛id spa就彻底骚胖警察打死几次都怕啥就彻底少普及程度上稽查阶段杀几次吊牌就吃点啥就彻底收盘从v的空间哦杀几次都是啊骗局多晒哦评价；局的是哦啊骗局多晒哦怕v吃惊的是哦啊怕剧场滴哦啥配件v嗲啪v的杀局id扫平v记得晒哦怕v的啥剧多晒哦怕v啊是v啥的局i都啥破就打算iowa', '0', '0', '1', '2', '3', '2019-06-13 14:29:24', '1');
INSERT INTO `ant_talk` VALUES ('4', '1234', '都没时间咯；你彻底封杀几次没v地扫就猜到市场接受度', '0', '0', '1', '2', '3', '2019-06-16 14:45:10', '1');

-- ----------------------------
-- Table structure for `ant_talk_pic`
-- ----------------------------
DROP TABLE IF EXISTS `ant_talk_pic`;
CREATE TABLE `ant_talk_pic` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `talk_id` int(11) NOT NULL,
  `pic_url` varchar(255) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ant_talk_pic
-- ----------------------------
INSERT INTO `ant_talk_pic` VALUES ('1', '1', '/Path/aa.jpg');
INSERT INTO `ant_talk_pic` VALUES ('2', '1', '/Path/2.png');

-- ----------------------------
-- Table structure for `ant_user`
-- ----------------------------
DROP TABLE IF EXISTS `ant_user`;
CREATE TABLE `ant_user` (
  `ant_id` varchar(255) NOT NULL,
  `ant_password` varchar(255) NOT NULL,
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `state` bigint(20) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ant_user
-- ----------------------------
INSERT INTO `ant_user` VALUES ('1234', '1234', '2019-06-11 19:49:48', '1');
INSERT INTO `ant_user` VALUES ('1723693876', '1723693876', '2019-06-08 18:32:29', '1');
