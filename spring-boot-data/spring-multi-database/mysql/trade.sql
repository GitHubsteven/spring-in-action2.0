create table if not exists oms.trade
(
	id int auto_increment
		primary key,
	order_id varchar(200) not null comment ''订单id'',
	platform varchar(100) null comment ''平台'',
	amount decimal(10,4) null comment ''金额'',
	constraint order_orderId_uindex
		unique (order_id)
)
comment ''订单'';

