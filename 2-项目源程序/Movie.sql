--1、创建库
use master
go
IF  EXISTS(SELECT * FROM  sysdatabases WHERE  name ='movie')
   drop database movie
go
create database movie
on primary
(
	name=movie_data,
	filename='D:\movies.mdf',
	size=5,
	maxsize=15,
	filegrowth=1
)
log on
(
	name=movie_log,
	filename='D:\movie_log',
	size=5,
	maxsize=10,
	filegrowth=10%
)
go
use movie
go
--2、创建表(6)
--create table department(					--部门
--	dep_id varchar(11) primary key,         --编号
--	dep_name varchar(40) not null,			--部门名称
--)
Create table users(
    use_id int primary key identity(1,1),		--编号
	use_name varchar(40) not null,			--用户名
	use_password varbinary(1024) not null,		--密码
	use_level int not null
)
--Create table users(
--    use_id int identity(1,1) primary key,			--编号
--	use_name varchar(40) not null,			--用户名
--	use_password varchar(40) not null,		--密码
--	use_level int not null
--)
--create table staff(							--职员
--	sta_id varchar(11) primary key,			--编号
--	sta_name varchar(40) not null,			--姓名
--	sta_sex varchar(2) default('男'),		--性别
--	sta_kind varchar(40) not null,			--职称
--	sta_phone varchar(11) not null,			--联系方式
--)
create table movie(						    --影片
	mov_id varchar(11) primary key,         --编号
	mov_picture varchar(40),				--海报
	mov_name varchar(40) not null,          --名称
	mov_introduce nvarchar(400),            --电影简介
	mov_indate varchar(40) not null,               --上映时间
	mov_outdate varchar(40) not null,			    --下映时间
	mov_time varchar(40) not null,          --时长
	mov_director varchar(40) not null,      --导演
	mov_star varchar(40) not null,          --主演
	mov_style varchar(40) default('2D'),    --影片格式
	mov_kind varchar(40) not null,          --影片类型
)
go
create table ticket(						--电影票
	tic_id varchar(11) primary key,         --编号
	hal_number int not null,                --座位号
	pla_id varchar(11) not null,            --场次
	tic_code varchar(40) not null,          --验证码
	cus_id varchar(11),						--编号
)
go
create table hall(						    --电影厅表
	hal_id varchar(11) primary key,		    --编号
	hal_name varchar(40) not null,		    --名称
	hal_rows int not null,					--排
	hal_seats int not null,					--座
	hal_count int not null,    			    --座位数
	hal_kind varchar(40) default('小'),     --规格
	hal_state varchar(40) default('不可用') --状态
) 
go
create table play(							--放映
	pla_id varchar(11) primary key,		    --编号
	hal_id varchar(11) not null,		    --影厅号
	mov_id varchar(11) not null,		    --电影编号
	pla_starttime datetime not null,		--播放时间
	tic_price varchar(40) not null			--票价
) 
go
create table customer(						--顾客表
	cus_id varchar(11) primary key,		    --编号
	cus_name varchar(40) not null,          --姓名
	cus_sex varchar(2) default('男'),		--性别
	cus_phone varchar(11) not null,		    --联系方式
	use_id int identity(4,1),               --用户编号
)
go
create table vip(							--会员卡
	cus_id varchar(11) primary key,		    --编号
	vip_discount varchar(40),		--折扣		
	vip_id varchar(11) not null,		    --会员类型
	cus_viptime varchar(40) not null,		--会员期限
) 
go
--3、添加约束
--3.1、添加外键约束
--Alter Table ticket
--Add 
--	Constraint FK_tic_pla Foreign key (pla_id) References play(pla_id)
--GO
--Alter Table vip
--Add Constraint FK_vip_cus Foreign key (cus_id) References customer(cus_id)
--GO
--Alter Table play
--Add 
--	Constraint FK_pla_hal Foreign key (hal_id) References hall(hal_id),
--	Constraint FK_pla_mov Foreign key (mov_id) References movie(mov_id)
--GO
--3.2、添加核查约束
--Alter Table staff
--Add 
--	Constraint CK_sta_phone Check (sta_phone like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
--	Constraint CK_sta_sex Check (sta_sex in('男','女'))
--GO
Alter Table movie
Add Constraint CK_mov_style Check (mov_style in('2D','3D'))
GO
Alter Table hall
Add 
	Constraint CK_hal_count Check (hal_count > 0),
	Constraint CK_hal_kind Check (hal_kind in('IMAX','大','小')),
	Constraint CK_hal_state Check (hal_state in('可用','不可用'))
GO

Alter Table customer
Add 
	Constraint CK_cus_phone Check (cus_phone like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	Constraint CK_cus_sex Check (cus_sex in('男','女'))
GO
Alter Table vip
Add 
	Constraint CK_vip_id Check (vip_id in('初级','中级','高级')),
	Constraint CK_vip_discount Check (vip_discount <= 1.0)
GO
Alter Table ticket
Add 
	Constraint CK_hal_number Check (hal_number > 0)
GO
--3.3、添加唯一约束
Alter Table ticket
Add Constraint UN_tic_code Unique (tic_code)
GO
--4、导入数据

Insert Into users
Values('admin',pwdencrypt('123456'),'1'),
	  ('zlinjie',pwdencrypt('123456'),'1'),
	  ('cting',pwdencrypt('123456'),'1'),
	  ('王豪杰',pwdencrypt('123456'),'0'),
	  ('陈觉柽',pwdencrypt('123456'),'0'),
	  ('方伟杰',pwdencrypt('123456'),'0'),
	  ('卢传文',pwdencrypt('123456'),'0'),
	  ('张翔宇',pwdencrypt('123456'),'0'),
	  ('郑心奕',pwdencrypt('123456'),'0'),
	  ('吴枭宇',pwdencrypt('123456'),'0'),
	  ('尹琪宝',pwdencrypt('123456'),'0'),
	  ('林杨坤',pwdencrypt('123456'),'0'),
	  ('史晨柯',pwdencrypt('123456'),'0'),
	  ('江信朋',pwdencrypt('123456'),'0'),
	  ('郭浩晨',pwdencrypt('123456'),'0'),
	  ('翁天翔',pwdencrypt('123456'),'0'),
	  ('陈鸿波',pwdencrypt('123456'),'0'),
	  ('徐畅阳',pwdencrypt('123456'),'0'),
	  ('胡田昊',pwdencrypt('123456'),'0'),
	  ('董堃昊',pwdencrypt('123456'),'0'),
	  ('马振豪',pwdencrypt('123456'),'0'),
	  ('孙锴成',pwdencrypt('123456'),'0'),
	  ('马宇腾',pwdencrypt('123456'),'0'),
	  ('李溧君',pwdencrypt('123456'),'0'),
	  ('孔宁静',pwdencrypt('123456'),'0'),
	  ('胡晴雯',pwdencrypt('123456'),'0'),
	  ('应静雪',pwdencrypt('123456'),'0'),
	  ('胡夏璐',pwdencrypt('123456'),'0'),
	  ('潘晨婷',pwdencrypt('123456'),'0'),
	  ('陈彩霞',pwdencrypt('123456'),'0'),
	  ('陈嘉露',pwdencrypt('123456'),'0'),
	  ('何小义',pwdencrypt('123456'),'0'),
	  ('卢秀秀',pwdencrypt('123456'),'0'),
	  ('胡淑婷',pwdencrypt('123456'),'0'),
	  ('将依群',pwdencrypt('123456'),'0'),
	  ('陈丹娅',pwdencrypt('123456'),'0'),
	  ('胡淑媛',pwdencrypt('123456'),'0'),
	  ('孔百慧',pwdencrypt('123456'),'0'),
	  ('王莹莹',pwdencrypt('123456'),'0'),
	  ('杨秀萍',pwdencrypt('123456'),'0'),
	  ('张湘楠',pwdencrypt('123456'),'0'),
	  ('赵艳琳',pwdencrypt('123456'),'0'),
	  ('周丽斓',pwdencrypt('123456'),'0')
GO
--Insert Into users
--Values('1','admin',pwdencrypt('123456'),'1'),
--	  ('2','zlinjie',pwdencrypt('123456'),'1'),
--	  ('3','cting',pwdencrypt('123456'),'1'),
--	  ('4','王豪杰',pwdencrypt('123456'),'0'),
--	  ('5','陈觉柽',pwdencrypt('123456'),'0'),
--	  ('6','方伟杰',pwdencrypt('123456'),'0'),
--	  ('7','卢传文',pwdencrypt('123456'),'0'),
--	  ('8','张翔宇',pwdencrypt('123456'),'0'),
--	  ('9','郑心奕',pwdencrypt('123456'),'0'),
--	  ('10','吴枭宇',pwdencrypt('123456'),'0'),
--	  ('11','尹琪宝',pwdencrypt('123456'),'0'),
--	  ('12','林杨坤',pwdencrypt('123456'),'0'),
--	  ('13','史晨柯',pwdencrypt('123456'),'0'),
--	  ('14','江信朋',pwdencrypt('123456'),'0'),
--	  ('15','郭浩晨',pwdencrypt('123456'),'0'),
--	  ('16','翁天翔',pwdencrypt('123456'),'0'),
--	  ('17','陈鸿波',pwdencrypt('123456'),'0'),
--	  ('18','徐畅阳',pwdencrypt('123456'),'0'),
--	  ('19','胡田昊',pwdencrypt('123456'),'0'),
--	  ('20','董堃昊',pwdencrypt('123456'),'0'),
--	  ('21','马振豪',pwdencrypt('123456'),'0'),
--	  ('22','孙锴成',pwdencrypt('123456'),'0'),
--	  ('23','马宇腾',pwdencrypt('123456'),'0'),
--	  ('24','李溧君',pwdencrypt('123456'),'0'),
--	  ('25','孔宁静',pwdencrypt('123456'),'0'),
--	  ('26','胡晴雯',pwdencrypt('123456'),'0'),
--	  ('27','应静雪',pwdencrypt('123456'),'0'),
--	  ('28','胡夏璐',pwdencrypt('123456'),'0'),
--	  ('29','潘晨婷',pwdencrypt('123456'),'0'),
--	  ('30','陈彩霞',pwdencrypt('123456'),'0'),
--	  ('31','陈嘉露',pwdencrypt('123456'),'0'),
--	  ('32','何小义',pwdencrypt('123456'),'0'),
--	  ('33','卢秀秀',pwdencrypt('123456'),'0'),
--	  ('34','胡淑婷',pwdencrypt('123456'),'0'),
--	  ('35','将依群',pwdencrypt('123456'),'0'),
--	  ('36','陈丹娅',pwdencrypt('123456'),'0'),
--	  ('37','胡淑媛',pwdencrypt('123456'),'0'),
--	  ('38','孔百慧',pwdencrypt('123456'),'0'),
--	  ('39','王莹莹',pwdencrypt('123456'),'0'),
--	  ('40','杨秀萍',pwdencrypt('123456'),'0'),
--	  ('41','张湘楠',pwdencrypt('123456'),'0'),
--	  ('42','赵艳琳',pwdencrypt('123456'),'0'),
--	  ('43','周丽斓',pwdencrypt('123456'),'0')
--GO
Select * From users where use_name = 'admin' and pwdcompare('123456', use_password)=1
GO
--Insert Into users
--Values('admin','123456','1'),
--	  ('zlinjie','123456','0'),
--	  ('cting','123456','1')
--GO
--select * from users where use_name = 'admin' and pwdcompare('123456', use_password)=1
--Insert Into staff
--Values('STAFF001','张三','男','经理','15968798848'),
--	  ('STAFF002','王丽','女','售票员','18632945848'),
--	  ('STAFF003','赵芸','女','售票员','15958975418')
--GO
Insert Into movie
Values('LMA20170001','../../img/chaoren.jpg','超人总动员2',
	   '超能一家追逐抢劫银行的挖地超人（约翰·拉岑贝格配音），人没抓到却破坏了城市建设，被政府抓到把柄，
	   被彻底取消了超人搬迁资助。正当大力神巴鲍伯（格雷格·T·尼尔森配音）和弹力女超人巴荷莉（霍利·亨特配音）
	   烦恼该怎么办之时，酷冰侠鲁休斯（塞缪尔·杰克逊配音）带来好消息：电信集团大亨温斯顿·狄弗（鲍勃·奥登科克配音）
	   ，想要与他们合作，通过妹妹艾芙琳·狄弗（凯瑟琳·基纳配音）研发的高科技传媒技术，帮助超人们重整公众形象后再次合法。',
	   '2018-06-15','2018-07-15','126','布拉德·伯德','格雷格·T·尼尔森，霍利·亨特','3D','动画、动作、冒险'),
	   
	  ('LMA20170002','../../img/xingjing.jpg','龙虾刑警',
	  '《龙虾刑警》由真实故事改编，讲述话唠杜宇飞（王千源饰）、恨嫁女花姐（袁姗姗饰）、处于半退休状态的能叔（刘桦饰）、
	  以及新人陈笠（周游饰）组成的不靠谱缉毒刑警小队，为了更隐蔽地监视毒贩而盘下隔壁的龙虾店。却不料生意火爆起来，
	  他们只得一边经营龙虾店一边搜寻线索，由此引发一系列惊心动魄而又别有一番趣味的故事 [2]  。',
	  '2018-06-22','2018-07-22','93','李昕芸','王千源，袁姗姗，刘桦','2D','警匪、剧情、动作、美食、喜剧'),
	  
	  ('LMA20170003','../../img/shijie.jpg','侏罗纪世界2',
	  '《侏罗纪世界2》的时间点设置在侏罗纪世界主题公园及豪华度假村被失控的恐龙们摧毁四年后,纳布拉尔岛已经被人类遗弃,
	  岛上幸存的恐龙们在丛林中自给自足。当岛上的休眠火山开始活跃以后,欧文(克里斯·帕拉特饰)与克莱尔(布莱丝·达拉斯·霍华德饰)
	  发起了一场运动,想要保护岛上幸存的恐龙们免于灭绝 [4]  。',
	  '2018-06-15','2018-07-15','128','胡安·安东尼奥·巴亚纳','克里斯·帕拉特，布莱丝·达拉斯·霍华德','3D','动作、科幻、冒险')
GO
Insert Into customer
Values('CUS80000001','王豪杰','男','13848910364'),
	   ('CUS80000002','陈觉柽','男','13845678911'),
	   ('CUS80000003','方伟杰','男','18645678912'),
	   ('CUS80000004','卢传文','男','18945646910'),
	   ('CUS80000005','张翔宇','男','15915467911'),
	   ('CUS80000006','郑心奕','男','13945563412'),
	   ('CUS80000007','吴枭宇','男','13676588910'),
	   ('CUS80000008','尹琪宝','男','18953438992'),
	   ('CUS80000009','林杨坤','男','13845888914'),
	   ('CUS80000010','史晨柯','男','13945564552'),
	   ('CUS80000011','江信朋','男','18045678889'),
	   ('CUS80000012','郭浩晨','男','18645678912'),
	   ('CUS80000013','翁天翔','男','15915467911'),
	   ('CUS80000014','陈鸿波','男','15968766783'),
	   ('CUS80000015','徐畅阳','男','18645678912'),
	   ('CUS80000016','胡田昊','男','18832338373'),
	   ('CUS80000017','董堃昊','男','18745368919'),
	   ('CUS80000018','马振豪','男','18645678912'),
	   ('CUS80000019','孙锴成','男','15915467911'),
	   ('CUS80000020','马宇腾','男','18005888690'),
	   ('CUS80000021','李溧君','女','13845678911'),
	   ('CUS80000022','孔宁静','女','15977896783'),
	   ('CUS80000023','胡晴雯','女','13945564552'),
	   ('CUS80000024','应静雪','女','13775628971'),
	   ('CUS80000025','胡夏璐','女','15977896783'),
	   ('CUS80000026','潘晨婷','女','13845678911'),
	   ('CUS80000027','陈彩霞','女','18956924567'),
	   ('CUS80000028','陈嘉露','女','15977896783'),
	   ('CUS80000029','何小义','女','18997666983'),
	   ('CUS80000030','卢秀秀','女','18005888690'),
	   ('CUS80000031','胡淑婷','女','18997666983'),
	   ('CUS80000032','将依群','女','18005888690'),
	   ('CUS80000033','陈丹娅','女','18669876809'),
	   ('CUS80000034','胡淑媛','女','18997666983'),
	   ('CUS80000035','孔百慧','女','18956924567'),
	   ('CUS80000036','王莹莹','女','13945564552'),
	   ('CUS80000037','杨秀萍','女','18669876809'),
	   ('CUS80000038','张湘楠','女','18956924567'),
	   ('CUS80000039','赵艳琳','女','13869906233'),
	   ('CUS80000040','周丽斓','女','18997666983')
GO
--Insert Into customer
--Values('CUS80000001','王豪杰','男','13848910364','4'),
--	   ('CUS80000002','陈觉柽','男','13845678911','5'),
--	   ('CUS80000003','方伟杰','男','18645678912','6'),
--	   ('CUS80000004','卢传文','男','18945646910','7'),
--	   ('CUS80000005','张翔宇','男','15915467911','8'),
--	   ('CUS80000006','郑心奕','男','13945563412','9'),
--	   ('CUS80000007','吴枭宇','男','13676588910','10'),
--	   ('CUS80000008','尹琪宝','男','18953438992','11'),
--	   ('CUS80000009','林杨坤','男','13845888914','12'),
--	   ('CUS80000010','史晨柯','男','13945564552','13'),
--	   ('CUS80000011','江信朋','男','18045678889','14'),
--	   ('CUS80000012','郭浩晨','男','18645678912','15'),
--	   ('CUS80000013','翁天翔','男','15915467911','16'),
--	   ('CUS80000014','陈鸿波','男','15968766783','17'),
--	   ('CUS80000015','徐畅阳','男','18645678912','18'),
--	   ('CUS80000016','胡田昊','男','18832338373','19'),
--	   ('CUS80000017','董堃昊','男','18745368919','20'),
--	   ('CUS80000018','马振豪','男','18645678912','21'),
--	   ('CUS80000019','孙锴成','男','15915467911','22'),
--	   ('CUS80000020','马宇腾','男','18005888690','23'),
--	   ('CUS80000021','李溧君','女','13845678911','24'),
--	   ('CUS80000022','孔宁静','女','15977896783','25'),
--	   ('CUS80000023','胡晴雯','女','13945564552','26'),
--	   ('CUS80000024','应静雪','女','13775628971','27'),
--	   ('CUS80000025','胡夏璐','女','15977896783','28'),
--	   ('CUS80000026','潘晨婷','女','13845678911','29'),
--	   ('CUS80000027','陈彩霞','女','18956924567','30'),
--	   ('CUS80000028','陈嘉露','女','15977896783','31'),
--	   ('CUS80000029','何小义','女','18997666983','32'),
--	   ('CUS80000030','卢秀秀','女','18005888690','33'),
--	   ('CUS80000031','胡淑婷','女','18997666983','34'),
--	   ('CUS80000032','将依群','女','18005888690','35'),
--	   ('CUS80000033','陈丹娅','女','18669876809','36'),
--	   ('CUS80000034','胡淑媛','女','18997666983','37'),
--	   ('CUS80000035','孔百慧','女','18956924567','38'),
--	   ('CUS80000036','王莹莹','女','13945564552','39'),
--	   ('CUS80000037','杨秀萍','女','18669876809','40'),
--	   ('CUS80000038','张湘楠','女','18956924567','41'),
--	   ('CUS80000039','赵艳琳','女','13869906233','42'),
--	   ('CUS80000040','周丽斓','女','18997666983','43')
--GO
Insert Into vip
Values ('CUS80000001','0.9','初级','6天'),
	   ('CUS80000002','0.7','中级','5天'),
	   ('CUS80000003','0.5','高级','16天'),
	   ('CUS80000004','0.9','初级','18天'),
	   ('CUS80000005','0.7','中级','20天'),
	   ('CUS80000006','0.9','初级','25天'),
	   ('CUS80000007','0.5','高级','13天'),
	   ('CUS80000008','0.7','中级','27天'),
	   ('CUS80000009','0.9','初级','6天'),
	   ('CUS80000010','0.5','高级','29天'),
	   ('CUS80000011','0.5','高级','7天'),
	   ('CUS80000012','0.9','初级','10天'),
	   ('CUS80000013','0.7','中级','16天'),
	   ('CUS80000014','0.7','中级','18天'),
	   ('CUS80000015','0.7','中级','21天'),
	   ('CUS80000016','0.9','初级','8天'),
	   ('CUS80000017','0.9','初级','16天'),
	   ('CUS80000018','0.5','高级','23天'),
	   ('CUS80000019','0.5','高级','17天'),
	   ('CUS80000020','0.5','高级','8天'),
	   ('CUS80000021','0.9','初级','30天'),
	   ('CUS80000022','0.7','中级','9天'),
	   ('CUS80000023','0.5','高级','13天'),
	   ('CUS80000024','0.9','初级','25天'),
	   ('CUS80000025','0.5','高级','25天'),
	   ('CUS80000026','0.5','高级','17天'),
	   ('CUS80000027','0.9','初级','27天'),
	   ('CUS80000028','0.7','中级','23天'),
	   ('CUS80000029','0.7','中级','61天'),
	   ('CUS80000030','0.9','初级','26天'),
	   ('CUS80000031','0.9','初级','14天'),
	   ('CUS80000032','0.5','高级','24天'),
	   ('CUS80000033','0.9','初级','36天'), 
	   ('CUS80000034','0.9','初级','17天'),
	   ('CUS80000035','0.5','高级','16天'),
	   ('CUS80000036','0.9','初级','13天'),
	   ('CUS80000037','0.5','高级','14天'),
	   ('CUS80000038','0.7','中级','16天'),
	   ('CUS80000039','0.9','初级','18天'),
	   ('CUS80000040','0.5','高级','26天')
GO
Insert Into hall
Values('HALL001','1号厅','8','16','128','小','可用'),
	  ('HALL002','2号厅','8','16','128','小','不可用'),
	  ('HALL003','3号厅','9','15','135','小','可用'),
	  ('HALL004','4号厅','9','15','135','小','不可用'),
	  ('HALL005','5号厅','12','20','240','大','不可用'),
	  ('HALL006','6号厅','11','21','231','大','可用'),
	  ('HALL007','7号厅','12','20','240','大','不可用'),
	  ('HALL008','8号厅','11','21','231','大','可用'),
      ('HALL009','IMAX1厅','9','16','145','IMAX','不可用'),
      ('HALL010','IMAX2厅','12','21','252','IMAX','可用')
GO
Insert Into play
Values('PLAY2017001','HALL009','LMA20170001','2018-01-10 10:30:00','43.50'),
	  ('PLAY2017002','HALL005','LMA20170001','2018-01-10 12:00:00','43.50'),
	  ('PLAY2017003','HALL002','LMA20170001','2018-01-10 13:30:00','43.50'),
	  ('PLAY2017004','HALL009','LMA20170001','2018-01-10 14:40:00','43.50'),
	  ('PLAY2017005','HALL006','LMA20170001','2018-01-10 17:30:00','43.50'),
	  ('PLAY2017006','HALL002','LMA20170001','2018-01-10 18:20:00','43.50'),
	  ('PLAY2017007','HALL005','LMA20170001','2018-01-10 20:00:00','43.50'),
	  ('PLAY2017008','HALL010','LMA20170001','2018-01-10 21:10:00','43.50'),
	  ('PLAY2017009','HALL001','LMA20170002','2018-01-10 12:10:00','40.00'),
	  ('PLAY2017010','HALL004','LMA20170002','2018-01-10 14:40:00','40.00'),
	  ('PLAY2017011','HALL008','LMA20170002','2018-01-10 17:15:00','40.00'),
	  ('PLAY2017012','HALL001','LMA20170002','2018-01-10 20:10:00','40.00'),
	  ('PLAY2017013','HALL010','LMA20170003','2018-01-10 09:40:00','46.75'),
	  ('PLAY2017014','HALL003','LMA20170003','2018-01-10 11:20:00','46.75'),
	  ('PLAY2017015','HALL010','LMA20170003','2018-01-10 12:20:00','46.75'),
	  ('PLAY2017016','HALL006','LMA20170003','2018-01-10 13:20:00','46.75'),
	  ('PLAY2017017','HALL007','LMA20170003','2018-01-10 15:40:00','46.75'),
	  ('PLAY2017018','HALL003','LMA20170003','2018-01-10 16:00:00','46.75'),
	  ('PLAY2017019','HALL005','LMA20170003','2018-01-10 18:40:00','46.75'),
	  ('PLAY2017020','HALL009','LMA20170003','2018-01-10 19:30:00','46.75')
GO
Insert Into ticket
Values('TIC10001','2','PLAY2017001','WFGG1859T','CUS80000001'),
	  ('TIC10002','3','PLAY2017002','DFE1521EY','CUS80000002'),
	  ('TIC10003','4','PLAY2017003','WEHF1859U','CUS80000003'),
	  ('TIC10004','6','PLAY2017004','AS1521E9I','CUS80000004'),
	  ('TIC10005','7','PLAY2017005','5EHF1859O','CUS80000005'),
	  ('TIC10006','9','PLAY2017006','WE1521E9P','CUS80000006'),
	  ('TIC10007','10','PLAY2017007','WEFF18597','CUS80000007'),
	  ('TIC10008','12','PLAY2017008','W41521E98','CUS80000008'),
	  ('TIC10009','14','PLAY2017009','REHF18DFY','CUS80000009'),
	  ('TIC10010','15','PLAY2017010','WE1521E9Q','CUS80000010'),
	  ('TIC10011','16','PLAY2017011','YEHD1859W','CUS80000011'),
	  ('TIC10012','17','PLAY2017012','WE15D1E9E','CUS80000012'),
	  ('TIC10013','45','PLAY2017013','WFGGFS85R','CUS80000013'),
	  ('TIC10014','65','PLAY2017014','WE15F1EYU','CUS80000014'),
	  ('TIC10015','23','PLAY2017015','WEHD1AF9A','CUS80000015'),
	  ('TIC10016','43','PLAY2017016','WE1521E9S','CUS80000016'),
	  ('TIC10017','24','PLAY2017017','WEHFF459D','CUS80000017'),
	  ('TIC10018','54','PLAY2017018','W32521E9F','CUS80000018'),
	  ('TIC10019','13','PLAY2017019','W4FRF189G','CUS80000019'),
	  ('TIC10020','15','PLAY2017020','4E152TE9H','CUS80000020'),
	  ('TIC10021','17','PLAY2017001','WEHF2359J','CUS80000021'),
	  ('TIC10022','36','PLAY2017002','WE1TG1E9K','CUS80000022'),
	  ('TIC10023','15','PLAY2017003','5THF185JL','CUS80000023'),
	  ('TIC10024','19','PLAY2017004','FR1521E9Z','CUS80000024'),
	  ('TIC10025','43','PLAY2017005','WEH4G859X','CUS80000025'),
	  ('TIC10026','44','PLAY2017006','WF1541E9C','CUS80000026'),
	  ('TIC10027','53','PLAY2017007','WEHFD856V','CUS80000027'),
	  ('TIC10028','86','PLAY2017008','WE1521E9B','CUS80000028'),
	  ('TIC10029','25','PLAY2017009','4EHF1859N','CUS80000029'),
	  ('TIC10030','96','PLAY2017010','3E1DR1E9M','CUS80000030'),
	  ('TIC10031','28','PLAY2017011','ER4F18594','CUS80000031'),
	  ('TIC10032','87','PLAY2017012','4R1521E9H','CUS80000032'),
	  ('TIC10033','79','PLAY2017013','6YHF1859E','CUS80000033'),
	  ('TIC10034','68','PLAY2017014','GT1521E96','CUS80000034'),
	  ('TIC10035','59','PLAY2017015','H6HF1859E','CUS80000035'),
	  ('TIC10036','75','PLAY2017016','4FHF1859G','CUS80000036'),
	  ('TIC10037','95','PLAY2017017','H61521E9T','CUS80000037'),
	  ('TIC10038','86','PLAY2017018','F3RV18592','CUS80000038'),
	  ('TIC10039','57','PLAY2017019','EFC521E9W','CUS80000039'),
	  ('TIC10040','86','PLAY2017020','2WE521E9X','CUS80000040')	  
GO
--4.1、检查导入
Select * From hall
Select * From movie
Select * From play
Select * From ticket
GO
Select mov_name,hal_name  From ticket,movie,hall
select * From users where pwdcompare('123456', use_password)=1
go
-------------密码加密触发器----------
--Create trigger tr_user
--ON users
--instead of insert
--AS
--Declare @use_id varchar(11),@use_name varchar(40),@use_password varbinary(1024),@use_level int
--Select @use_id=use_id,@use_name=use_name,@use_password = use_password,@use_level=use_level from inserted
--insert Into users Values(@use_id,@use_name,@use_password,@use_level)
--GO


-----------------------------视图-----------------------------

---------------------------查询会员 
Select customer.*,vip_discount,vip_id,cus_viptime From customer,vip where vip.cus_id = customer.cus_id
GO
Create View v_vip
As
	Select customer.*,vip_discount,vip_id,cus_viptime 
	From customer,vip where vip.cus_id = customer.cus_id
GO
----------------------------查询电影
Create View v_movie
AS
	Select mov_name,mov_indate,mov_time,mov_kind,mov_style  From movie
GO
----------------------------查询场次  
Create View v_play
AS
	Select pla_id,hal_name,hal_count,hal_kind,mov_name,pla_starttime,mov_time,tic_price from hall,movie,play
	Where hall.hal_id = play.hal_id and play.mov_id=movie.mov_id
GO

-----------------------------触发器-----------------------------

--------------------------------删除场次
Create trigger tr_play
ON play
For delete
As 
declare @playid varchar(11)
select @playid = pla_id from deleted
delete ticket where pla_id = @playid
GO
------------------------------------插入场次 
--Alter trigger T_plays
--ON play
--instead of insert
--As 
--	Declare @pla_id varchar(11),@hal_id varchar(11),@mov_id varchar(11),@mov_ids varchar(11),@pla_starttime datetime,@tic_price varchar(40),@pla_starttime1 datetime,@time int
--	Select @hal_id = hal_id,@mov_id = mov_id,@pla_id = pla_id,@pla_starttime = pla_starttime,@tic_price=tic_price from inserted
--	Select @pla_starttime1 = pla_starttime from play,hall where hall.hal_id = play.hal_id and play.hal_id = @hal_id
--	Select @time=mov_time from movie,play where movie.mov_id=play.mov_id and pla_id = @pla_id
--	while(cast(CONVERT(varchar, @pla_starttime)as datetime) between(cast(CONVERT(varchar,dateadd(mi,-160,@pla_starttime1))as datetime))and(cast(CONVERT(varchar,dateadd(mi,@time,@pla_starttime1))as datetime)))
--		begin
--			print '该时间段有电影在此影厅播放！'
--			rollback
--		end
--		Insert Into play Values(@pla_id,@hal_id,@mov_id,@pla_starttime,@tic_price)
--GO
--Select * from play Where cast(CONVERT(varchar, '2018-02-10 11:30:00')as datetime) between(cast(CONVERT(varchar,dateadd(mi,-1,'2018-02-10 11:30:00'))as datetime))and(cast(CONVERT(varchar,dateadd(mi,1,'2018-02-10 11:30:00'))as datetime))
--GO
--Alter trigger T_plays
--ON play
--instead of insert
--As 
--	Declare @pla_id varchar(11),@hal_id varchar(11),@mov_id varchar(11),@mov_ids varchar(11),@pla_starttime datetime,@tic_price varchar(40),@pla_starttime1 datetime,@time int
--	Select @hal_id = hal_id,@mov_id = mov_id,@pla_id = pla_id,@pla_starttime = pla_starttime,@tic_price=tic_price from inserted
--	Select @pla_starttime1 = pla_starttime from play,hall where hall.hal_id = play.hal_id and play.hal_id = @hal_id
--	Select @time=mov_time from movie,play where movie.mov_id=play.mov_id and pla_id = @pla_id
--	if (Select COUNT(*) from play Where cast(CONVERT(varchar, @pla_starttime)as datetime) between(cast(CONVERT(varchar,dateadd(mi,-160,@pla_starttime1))as datetime))and(cast(CONVERT(varchar,dateadd(mi,@time,@pla_starttime1))as datetime)))>1
--		begin
--			print '该时间段有电影在此影厅播放！'
--			rollback
--		end
--	else
--		Insert Into play Values(@pla_id,@hal_id,@mov_id,@pla_starttime,@tic_price)
--GO
--Select * from play Where cast(CONVERT(varchar, pla_starttime)as datetime) between(cast(CONVERT(varchar,dateadd(mi,-1,'2018-02-10 11:30:00'))as datetime))and(cast(CONVERT(varchar,dateadd(mi,1,'2018-02-10 11:30:00'))as datetime))
--GO  
Create trigger T_plays
ON play
instead of insert
As 
	Declare @pla_id varchar(11),@hal_id varchar(11),@mov_id varchar(11),@mov_ids varchar(11),@pla_starttime datetime,@tic_price varchar(40),@pla_starttime1 datetime,@time int
	Select @hal_id = hal_id,@mov_id = mov_id,@pla_id = pla_id,@pla_starttime = pla_starttime,@tic_price=tic_price from inserted
	Select @pla_starttime1 = pla_starttime from play,hall where hall.hal_id = play.hal_id and play.hal_id = @hal_id
	--Select @time=mov_time from movie,play where movie.mov_id=play.mov_id and pla_id = @pla_id
	if (Select COUNT(*) from play Where hal_id = @hal_id and pla_starttime = @pla_starttime)>0
		begin
			print '该时间段有电影在此影厅播放！'
			rollback
		end
	else
		Insert Into play Values(@pla_id,@hal_id,@mov_id,@pla_starttime,@tic_price)
GO
----------------------------会员插入   
Create trigger tr_vip
ON vip 
instead of insert
AS
Declare @cus_id varchar(11),@vip_discount varchar(40),@vip_id varchar(11),@cus_viptime varchar(40)
Select @cus_id = cus_id,@vip_discount = vip_discount,@vip_id = vip_id,@cus_viptime = cus_viptime from inserted
if(@vip_id = '高级')
	set @vip_discount = '0.5'
else if(@vip_id = '中级')
	set @vip_discount = '0.7'
else set @vip_discount = '0.9'
insert Into vip Values(@cus_id,@vip_discount,@vip_id,@cus_viptime)
GO
----------------------------用户插入   
Create trigger tr_users
ON customer
instead of insert
AS
Declare @cus_id varchar(11),@use_id int,@cus_name varchar(40),@cus_sex varchar(2),@cus_phone varchar(11)
Select @cus_id = cus_id,@use_id = use_id,@cus_name = cus_name,@cus_sex = cus_sex,@cus_phone = cus_phone from inserted
insert Into customer Values(@cus_id,@cus_name,@cus_sex,@cus_phone)
insert Into users Values(@cus_name,pwdencrypt('123456'),'0')
GO
Insert Into customer
Values('CUS80000100','222','男','13848910364')
GO
--drop trigger tr_users
select * from customer where use_id='44'
select * from users where use_id='44'
GO
-----------------------------会员修改
Create trigger tr_vipmodifty
ON vip 
for update
AS
Declare @cus_id varchar(11),@vip_discount varchar(40),@vip_id varchar(11),@cus_viptime varchar(40)
Select @cus_id = cus_id,@vip_discount = vip_discount,@vip_id = vip_id,@cus_viptime = cus_viptime from inserted
if(@vip_id = '高级')
	set @vip_discount = '0.5'
else if(@vip_id = '中级')
	set @vip_discount = '0.7'
else set @vip_discount = '0.9'
update vip set vip_discount=@vip_discount,vip_id=@vip_id,cus_viptime=@cus_viptime where cus_id=@cus_id
GO
update vip set vip_discount='0',vip_id='中级',cus_viptime = '13天' where cus_id = 'CUS80000001'
Select * From vip
GO


------------------------------删除顾客
Create trigger tr_Customer
ON Customer
For delete
As 
declare @cus_id varchar(11)
select @cus_id=cus_id from deleted
delete vip  where cus_id = @cus_id
GO

-----------------------------------存储过程------------------------------

Create PROC pr_play
AS
Begin
	Select pla_id,hal_name,hal_kind,mov_name,pla_starttime,mov_time,tic_price from hall,movie,play
	Where hall.hal_id = play.hal_id and play.mov_id=movie.mov_id 
End
GO
Create PROC pr_a @cus_id varchar(11),@a int output
As
Begin
	Select @a = COUNT(*) from customer
	Where cus_id = @cus_id 
End
GO
Create PROC pr_tickets @cus_id varchar(11)
AS
Begin
	Select customer.cus_id,hal_name,hal_kind,mov_name,pla_starttime,mov_time,tic_price,hal_number from hall,movie,play,customer,ticket
    Where customer.cus_id = ticket.cus_id and ticket.pla_id = play.pla_id and hall.hal_id = play.hal_id and play.mov_id = movie.mov_id and customer.cus_id = @cus_id
End
GO
--drop proc pr_ticket
EXEC pr_tickets 'CUS80000036'
GO
select cus_id From customer where use_id = 8
--declare @b int
--exec pr_a
--@cus_id = 'CUS80000002',
--@a=@b output
--select @b
--GO
Select customer.cus_id,hal_name,hal_kind,mov_name,pla_starttime,mov_time,tic_price,hal_number from hall,movie,play,customer,ticket
Where customer.cus_id = ticket.cus_id and ticket.pla_id = play.pla_id and hall.hal_id = play.hal_id and play.mov_id = movie.mov_id and customer.cus_id = 'CUS80000036'
GO
---------------根据影厅名称和电影名称修改场次
Create Proc p_name @movie_name varchar(40),@hall_name varchar(40), @movie_id varchar(11) output,@hall_id varchar(11) output
As
Begin
	Select @movie_id = mov_id from movie
	Where mov_name = @movie_name
	Select @hall_id = hal_id from hall
	Where hal_name = @hall_name
End
GO
declare @mid varchar(11),@hid varchar(11)
exec p_name
@movie_name = '龙虾刑警',@hall_name = '1号厅',
@movie_id=@mid output,@hall_id=@hid output
Update play set mov_id = @mid,hal_id = @hid,tic_price = '53.00' Where pla_id = 'PLAY2017002'
GO
select * From play 
go
---------------------------------查询电影票   存储过程
Create PROC pr_ticket
AS
Begin
	Select tic_id,hal_number,hal_name,mov_name,tic_price from ticket,hall,movie,play
	Where hall.hal_id = play.hal_id and play.mov_id=movie.mov_id and ticket.pla_id = play.pla_id
End
GO
EXEC pr_ticket
GO
---------------------------------查询影厅   存储过程 
Select hal_name,mov_name,mov_time,pla_starttime from hall,movie,play
Where hall.hal_id = play.hal_id and play.mov_id=movie.mov_id 
GO
Create PROC pr_hall
AS
Begin
	Select hal_name,mov_name,mov_time,pla_starttime from hall,movie,play
	Where hall.hal_id = play.hal_id and play.mov_id=movie.mov_id 
End
GO


select * from vip where cus_id = 'CUS80000036'