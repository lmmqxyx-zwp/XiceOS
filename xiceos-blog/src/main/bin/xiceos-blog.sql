/*
  navicat mysql data transfer

  source server         : 192.168.0.244
  source server version : 50162
  source host           : 192.168.0.244:3306
  source database       : xiceos-blog

  target server type    : mysql
  target server version : 50162
  file encoding         : 65001

  date: 2018-12-12 11:12:19
*/

-- drop database if exists `xiceos-blog`;
-- create database `xiceos-blog` character set utf8;
-- use `xiceos-bolg`;

set foreign_key_checks=0;

-- ----------------------------
-- table structure for blog_comments 评论表
-- ----------------------------
drop table if exists `blog_comments`;
create table `blog_comments` (
  `coid` int(10) unsigned not null auto_increment comment '主键、非负数、自增',
  `cid` int(10) unsigned default '0' comment 'blog_contents表主键',
  `created` int(10) unsigned default '0' comment '评论生成时的时间戳',
  `author` varchar(200) default null comment '评论作者',
  `authorid` int(10) unsigned default '0' comment '评论所属用户ID',
  `ownerid` int(10) unsigned default '0' comment '评论所属内容作者ID',
  `mail` varchar(200) default null comment '评论者邮件',
  `url` varchar(200) default null comment '评论者网址',
  `ip` varchar(64) default null comment '评论者IP地址',
  `agent` varchar(200) default null comment '评论者客户端',
  `text` text comment '评论文字',
  `type` varchar(16) default 'comment' comment '评论类型',
  `status` varchar(16) default 'approved' comment '评论状态',
  `parent` int(10) unsigned default '0' comment '父级评论',
  primary key (`coid`),
  key `cid` (`cid`),
  key `created` (`created`)
) engine=innodb auto_increment=1 default charset=utf8;

-- ----------------------------
-- table structure for blog_contents 内容表
-- ----------------------------
drop table if exists `blog_contents`;
create table `blog_contents` (
  `cid` int(10) unsigned not null auto_increment comment '主键',
  `title` varchar(200) default null comment '内容标题',
  `slug` varchar(200) default null comment '内容缩略名',
  `created` int(10) unsigned default '0' comment '内容生成时的时间戳',
  `modified` int(10) unsigned default '0' comment '内容更新时的时间戳',
  `text` longtext comment '内容文字',
  `order` int(10) unsigned default '0' comment '排序',
  `authorid` int(10) unsigned default '0' comment '内容所属用户ID',
  `template` varchar(32) default null comment '内容使用的模板',
  `type` varchar(16) default 'post' comment '内容类别',
  `status` varchar(16) default 'publish' comment '内容状态',
  `password` varchar(32) default null comment '受保护内容、对应内容保护密码',
  `commentsnum` int(10) unsigned default '0' comment '内容所属评论数、冗余字段',
  `allowcomment` char(1) default '0' comment '是否允许评论',
  `allowping` char(1) default '0' comment '是否允许ping',
  `allowfeed` char(1) default '0' comment '允许出现再聚合中',
  `parent` int(10) unsigned default '0' comment '父级内容ID',
  primary key (`cid`),
  unique key `slug` (`slug`),
  key `created` (`created`)
) engine=innodb auto_increment=1 default charset=utf8;

-- ----------------------------
-- table structure for blog_fields 扩展字段表
-- ----------------------------
drop table if exists `blog_fields`;
create table `blog_fields` (
  `cid` int(10) unsigned not null comment '联合主键',
  `name` varchar(200) not null comment '字段名称、联合主键',
  `type` varchar(8) default 'str' comment '字段类型',
  `str_value` text comment '字段对应字符串值',
  `int_value` int(10) default '0' comment '整型',
  `float_value` float default '0' comment '浮点型',
  primary key (`cid`,`name`),
  key `int_value` (`int_value`),
  key `float_value` (`float_value`)
) engine=innodb default charset=utf8;

-- ----------------------------
-- table structure for blog_metas 项目表
-- ----------------------------
drop table if exists `blog_metas`;
create table `blog_metas` (
  `mid` int(10) unsigned not null auto_increment comment '项目主键',
  `name` varchar(200) default null comment '名称',
  `slug` varchar(200) default null comment '项目缩略名',
  `type` varchar(32) not null comment '项目类型',
  `description` varchar(200) default null comment '项目描述',
  `count` int(10) unsigned default '0' comment '项目所属内容个数',
  `order` int(10) unsigned default '0' comment '项目排序',
  `parent` int(10) unsigned default '0',
  primary key (`mid`),
  key `slug` (`slug`)
) engine=innodb auto_increment=1 default charset=utf8;

-- ----------------------------
-- table structure for blog_options 配置表
-- ----------------------------
drop table if exists `blog_options`;
create table `blog_options` (
  `name` varchar(32) not null comment '配置名称',
  `user` int(10) unsigned not null default '0' comment '配置所属用户、默认位0(全局配置)',
  `value` text comment '配置值',
  primary key (`name`,`user`)
) engine=innodb default charset=utf8;

-- ----------------------------
-- table structure for blog_relationships 关系表
-- ----------------------------
drop table if exists `blog_relationships`;
create table `blog_relationships` (
  `cid` int(10) unsigned not null comment 'blog_contents表主键',
  `mid` int(10) unsigned not null comment 'blog_metas表主键',
  primary key (`cid`,`mid`)
) engine=innodb default charset=utf8;

-- ----------------------------
-- table structure for blog_users 用户表
-- ----------------------------
drop table if exists `blog_users`;
create table `blog_users` (
  `uid` int(10) unsigned not null auto_increment comment '主键',
  `username` varchar(32) default null comment '用户名称',
  `password` varchar(64) default null comment '用户密码',
  `mail` varchar(200) default null comment '用户邮箱',
  `url` varchar(200) default null comment '用户主页',
  `screenname` varchar(32) default null comment '用户显示的名称',
  `created` int(10) unsigned default '0' comment '用户注册时时间戳',
  `activated` int(10) unsigned default '0' comment '最后活动时间',
  `logged` int(10) unsigned default '0' comment '上次登录最后活跃时间',
  `group` varchar(16) default 'visitor' comment '用户组',
  `authcode` varchar(64) default null comment '用户登录验证码',
  `remember` int(1) default null comment '记住登录状态',
  primary key (`uid`),
  unique key `username` (`username`),
  unique key `mail` (`mail`)
) engine=innodb auto_increment=1 default charset=utf8;

-- ----------------------------
-- Table structure for blog_operation_log
-- ----------------------------
drop table if exists `blog_operation_log`;
create table `blog_operation_log` (
  `lid` int(10) not null auto_increment comment '主键id',
  `uid` int(10) default null comment '用户主键',
  `username` varchar(32) default null comment '用户名称',
  `ip` varchar(64) default null comment '用户ip',
  `param` varchar(255) default null comment '操作参数',
  `desc` varchar(255) default null comment '操作描述',
  `type` varchar(32) default null comment '日志类型',
  `createtime` datetime default null comment '创建时间',
  `result` text comment '日志结果',
  primary key (`lid`)
) engine=innodb auto_increment=1 default charset=utf8;