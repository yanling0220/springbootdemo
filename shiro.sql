/*

create table sys_permission
(
	id bigint auto_increment
		primary key,
	available bit null,
	name varchar(255) null,
	parent_id bigint null,
	parent_ids varchar(255) null,
	permission varchar(255) null,
	resource_type enum('menu', 'button') null,
	url varchar(255) null
)
;

create table sys_role
(
	id bigint auto_increment
		primary key,
	available bit null,
	description varchar(255) null,
	role varchar(255) null
)
;

create table sys_role_permission
(
	permission_id bigint not null,
	role_id bigint not null,
	constraint FKomxrs8a388bknvhjokh440waq
		foreign key (permission_id) references sys_permission (id),
	constraint FK9q28ewrhntqeipl1t04kh1be7
		foreign key (role_id) references sys_role (id)
)
;

create index FK9q28ewrhntqeipl1t04kh1be7
	on sys_role_permission (role_id)
;

create index FKomxrs8a388bknvhjokh440waq
	on sys_role_permission (permission_id)
;


create table sys_user_role
(
	uid bigint not null,
	role_id bigint not null,
	constraint FKgkmyslkrfeyn9ukmolvek8b8f
		foreign key (uid) references user_info (uid),
	constraint FKhh52n8vd4ny9ff4x9fb8v65qx
		foreign key (role_id) references sys_role (id)
)
;

create index FKgkmyslkrfeyn9ukmolvek8b8f
	on sys_user_role (uid)
;

create index FKhh52n8vd4ny9ff4x9fb8v65qx
	on sys_user_role (role_id)
;

create table user
(
	id int auto_increment
		primary key,
	name varchar(50) null,
	age int null,
	address varchar(200) null
)
;

create table user_info
(
	uid bigint auto_increment
		primary key,
	name varchar(255) null,
	password varchar(255) null,
	salt varchar(255) null,
	state tinyint not null,
	username varchar(255) null
)
;

create table log_icecoldmonitor
(
	id int auto_increment
		primary key,
	level varchar(255) default '' not null comment '优先级',
	category varchar(255) default '' not null comment '类目',
	thread varchar(255) default '' not null comment '进程',
	time varchar(30) default '' not null comment '时间',
	location varchar(255) default '' not null comment '位置',
	note text null comment '日志信息'
)
;

create table user
(
	id int auto_increment
		primary key,
	name varchar(50) null,
	age int null,
	address varchar(200) null
)
;








创建日志数据库表
CREATE TABLE log_icecoldmonitor (
  id int(11)  AUTO_INCREMENT PRIMARY KEY ,
  level varchar(255) NOT NULL DEFAULT '' COMMENT '优先级',
  category varchar(255)NOT NULL DEFAULT '' COMMENT '类目',
  thread varchar(255)NOT NULL DEFAULT '' COMMENT '进程',
  time varchar(30) NOT NULL DEFAULT '' COMMENT '时间',
  location varchar(255)NOT NULL DEFAULT '' COMMENT '位置',
  note text COMMENT '日志信息'
)*/

/*INSERT INTO `Sys_Permission` VALUES ('1', 1, '用户管理', '0', '0/', 'userInfo:view', 'menu', 'userInfo/userList');
INSERT INTO `Sys_Permission` VALUES ('2', 1, '用户添加', '1', '0/1', 'userInfo:add', 'button', 'userInfo/userAdd');
INSERT INTO `Sys_Permission` VALUES ('3', 1, '用户删除', '1', '0/1', 'userInfo:del', 'button', 'userInfo/userDel');

INSERT INTO `Sys_Role` VALUES ('1', 1, '管理员', 'admin');
INSERT INTO `Sys_Role` VALUES ('2', 1, 'VIP会员', 'vip');


INSERT INTO `Sys_Role_Permission` VALUES ('1', '1');
INSERT INTO `Sys_Role_Permission` VALUES ('1', '2');


INSERT INTO `Sys_User_Role` VALUES (1, 1);
INSERT INTO `Sys_User_Role` VALUES (1, 2);

INSERT INTO `User_Info` VALUES
  ('1', '管理员', 'admin', 'd3c59d25033dbf980d29554025c23a75','0','admin');*/




SELECT * FROM Sys_Permission;
SELECT * FROM Sys_Role;
SELECT * FROM Sys_Role_Permission;
SELECT * FROM Sys_User_Role;
SELECT * FROM User_Info;


