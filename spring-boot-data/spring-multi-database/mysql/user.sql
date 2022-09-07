create table if not exists user
(
	id int auto_increment
		primary key,
	username varchar(200) not null comment '用户名称',
	age int null comment '年龄',
	generation int default 0 not null comment '性别：1：man,0:woman',
	country varchar(200) null comment '国家',
	constraint user_username_uindex
		unique (username)
)
comment '用户信息';

