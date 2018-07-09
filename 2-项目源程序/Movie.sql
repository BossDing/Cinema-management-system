--1��������
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
--2��������(6)
--create table department(					--����
--	dep_id varchar(11) primary key,         --���
--	dep_name varchar(40) not null,			--��������
--)
Create table users(
    use_id int primary key identity(1,1),		--���
	use_name varchar(40) not null,			--�û���
	use_password varbinary(1024) not null,		--����
	use_level int not null
)
--Create table users(
--    use_id int identity(1,1) primary key,			--���
--	use_name varchar(40) not null,			--�û���
--	use_password varchar(40) not null,		--����
--	use_level int not null
--)
--create table staff(							--ְԱ
--	sta_id varchar(11) primary key,			--���
--	sta_name varchar(40) not null,			--����
--	sta_sex varchar(2) default('��'),		--�Ա�
--	sta_kind varchar(40) not null,			--ְ��
--	sta_phone varchar(11) not null,			--��ϵ��ʽ
--)
create table movie(						    --ӰƬ
	mov_id varchar(11) primary key,         --���
	mov_picture varchar(40),				--����
	mov_name varchar(40) not null,          --����
	mov_introduce nvarchar(400),            --��Ӱ���
	mov_indate varchar(40) not null,               --��ӳʱ��
	mov_outdate varchar(40) not null,			    --��ӳʱ��
	mov_time varchar(40) not null,          --ʱ��
	mov_director varchar(40) not null,      --����
	mov_star varchar(40) not null,          --����
	mov_style varchar(40) default('2D'),    --ӰƬ��ʽ
	mov_kind varchar(40) not null,          --ӰƬ����
)
go
create table ticket(						--��ӰƱ
	tic_id varchar(11) primary key,         --���
	hal_number int not null,                --��λ��
	pla_id varchar(11) not null,            --����
	tic_code varchar(40) not null,          --��֤��
	cus_id varchar(11),						--���
)
go
create table hall(						    --��Ӱ����
	hal_id varchar(11) primary key,		    --���
	hal_name varchar(40) not null,		    --����
	hal_rows int not null,					--��
	hal_seats int not null,					--��
	hal_count int not null,    			    --��λ��
	hal_kind varchar(40) default('С'),     --���
	hal_state varchar(40) default('������') --״̬
) 
go
create table play(							--��ӳ
	pla_id varchar(11) primary key,		    --���
	hal_id varchar(11) not null,		    --Ӱ����
	mov_id varchar(11) not null,		    --��Ӱ���
	pla_starttime datetime not null,		--����ʱ��
	tic_price varchar(40) not null			--Ʊ��
) 
go
create table customer(						--�˿ͱ�
	cus_id varchar(11) primary key,		    --���
	cus_name varchar(40) not null,          --����
	cus_sex varchar(2) default('��'),		--�Ա�
	cus_phone varchar(11) not null,		    --��ϵ��ʽ
	use_id int identity(4,1),               --�û����
)
go
create table vip(							--��Ա��
	cus_id varchar(11) primary key,		    --���
	vip_discount varchar(40),		--�ۿ�		
	vip_id varchar(11) not null,		    --��Ա����
	cus_viptime varchar(40) not null,		--��Ա����
) 
go
--3�����Լ��
--3.1��������Լ��
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
--3.2����Ӻ˲�Լ��
--Alter Table staff
--Add 
--	Constraint CK_sta_phone Check (sta_phone like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
--	Constraint CK_sta_sex Check (sta_sex in('��','Ů'))
--GO
Alter Table movie
Add Constraint CK_mov_style Check (mov_style in('2D','3D'))
GO
Alter Table hall
Add 
	Constraint CK_hal_count Check (hal_count > 0),
	Constraint CK_hal_kind Check (hal_kind in('IMAX','��','С')),
	Constraint CK_hal_state Check (hal_state in('����','������'))
GO

Alter Table customer
Add 
	Constraint CK_cus_phone Check (cus_phone like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	Constraint CK_cus_sex Check (cus_sex in('��','Ů'))
GO
Alter Table vip
Add 
	Constraint CK_vip_id Check (vip_id in('����','�м�','�߼�')),
	Constraint CK_vip_discount Check (vip_discount <= 1.0)
GO
Alter Table ticket
Add 
	Constraint CK_hal_number Check (hal_number > 0)
GO
--3.3�����ΨһԼ��
Alter Table ticket
Add Constraint UN_tic_code Unique (tic_code)
GO
--4����������

Insert Into users
Values('admin',pwdencrypt('123456'),'1'),
	  ('zlinjie',pwdencrypt('123456'),'1'),
	  ('cting',pwdencrypt('123456'),'1'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('�¾���',pwdencrypt('123456'),'0'),
	  ('��ΰ��',pwdencrypt('123456'),'0'),
	  ('¬����',pwdencrypt('123456'),'0'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('֣����',pwdencrypt('123456'),'0'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('ʷ����',pwdencrypt('123456'),'0'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('���Ƴ�',pwdencrypt('123456'),'0'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('�º貨',pwdencrypt('123456'),'0'),
	  ('�쳩��',pwdencrypt('123456'),'0'),
	  ('�����',pwdencrypt('123456'),'0'),
	  ('�����',pwdencrypt('123456'),'0'),
	  ('�����',pwdencrypt('123456'),'0'),
	  ('���ǳ�',pwdencrypt('123456'),'0'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('�����',pwdencrypt('123456'),'0'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('Ӧ��ѩ',pwdencrypt('123456'),'0'),
	  ('�����',pwdencrypt('123456'),'0'),
	  ('�˳���',pwdencrypt('123456'),'0'),
	  ('�²�ϼ',pwdencrypt('123456'),'0'),
	  ('�¼�¶',pwdencrypt('123456'),'0'),
	  ('��С��',pwdencrypt('123456'),'0'),
	  ('¬����',pwdencrypt('123456'),'0'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('����Ⱥ',pwdencrypt('123456'),'0'),
	  ('�µ��',pwdencrypt('123456'),'0'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('�װٻ�',pwdencrypt('123456'),'0'),
	  ('��ӨӨ',pwdencrypt('123456'),'0'),
	  ('����Ƽ',pwdencrypt('123456'),'0'),
	  ('�����',pwdencrypt('123456'),'0'),
	  ('������',pwdencrypt('123456'),'0'),
	  ('�����',pwdencrypt('123456'),'0')
GO
--Insert Into users
--Values('1','admin',pwdencrypt('123456'),'1'),
--	  ('2','zlinjie',pwdencrypt('123456'),'1'),
--	  ('3','cting',pwdencrypt('123456'),'1'),
--	  ('4','������',pwdencrypt('123456'),'0'),
--	  ('5','�¾���',pwdencrypt('123456'),'0'),
--	  ('6','��ΰ��',pwdencrypt('123456'),'0'),
--	  ('7','¬����',pwdencrypt('123456'),'0'),
--	  ('8','������',pwdencrypt('123456'),'0'),
--	  ('9','֣����',pwdencrypt('123456'),'0'),
--	  ('10','������',pwdencrypt('123456'),'0'),
--	  ('11','������',pwdencrypt('123456'),'0'),
--	  ('12','������',pwdencrypt('123456'),'0'),
--	  ('13','ʷ����',pwdencrypt('123456'),'0'),
--	  ('14','������',pwdencrypt('123456'),'0'),
--	  ('15','���Ƴ�',pwdencrypt('123456'),'0'),
--	  ('16','������',pwdencrypt('123456'),'0'),
--	  ('17','�º貨',pwdencrypt('123456'),'0'),
--	  ('18','�쳩��',pwdencrypt('123456'),'0'),
--	  ('19','�����',pwdencrypt('123456'),'0'),
--	  ('20','�����',pwdencrypt('123456'),'0'),
--	  ('21','�����',pwdencrypt('123456'),'0'),
--	  ('22','���ǳ�',pwdencrypt('123456'),'0'),
--	  ('23','������',pwdencrypt('123456'),'0'),
--	  ('24','�����',pwdencrypt('123456'),'0'),
--	  ('25','������',pwdencrypt('123456'),'0'),
--	  ('26','������',pwdencrypt('123456'),'0'),
--	  ('27','Ӧ��ѩ',pwdencrypt('123456'),'0'),
--	  ('28','�����',pwdencrypt('123456'),'0'),
--	  ('29','�˳���',pwdencrypt('123456'),'0'),
--	  ('30','�²�ϼ',pwdencrypt('123456'),'0'),
--	  ('31','�¼�¶',pwdencrypt('123456'),'0'),
--	  ('32','��С��',pwdencrypt('123456'),'0'),
--	  ('33','¬����',pwdencrypt('123456'),'0'),
--	  ('34','������',pwdencrypt('123456'),'0'),
--	  ('35','����Ⱥ',pwdencrypt('123456'),'0'),
--	  ('36','�µ��',pwdencrypt('123456'),'0'),
--	  ('37','������',pwdencrypt('123456'),'0'),
--	  ('38','�װٻ�',pwdencrypt('123456'),'0'),
--	  ('39','��ӨӨ',pwdencrypt('123456'),'0'),
--	  ('40','����Ƽ',pwdencrypt('123456'),'0'),
--	  ('41','�����',pwdencrypt('123456'),'0'),
--	  ('42','������',pwdencrypt('123456'),'0'),
--	  ('43','�����',pwdencrypt('123456'),'0')
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
--Values('STAFF001','����','��','����','15968798848'),
--	  ('STAFF002','����','Ů','��ƱԱ','18632945848'),
--	  ('STAFF003','��ܿ','Ů','��ƱԱ','15958975418')
--GO
Insert Into movie
Values('LMA20170001','../../img/chaoren.jpg','�����ܶ�Ա2',
	   '����һ��׷���������е��ڵس��ˣ�Լ������ᯱ�������������ûץ��ȴ�ƻ��˳��н��裬������ץ���ѱ���
	   ������ȡ���˳��˰�Ǩ����������������ͱ��������׸�T�����ɭ�������͵���Ů���˰ͺ��򣨻���������������
	   ���ո���ô��֮ʱ�������³��˹�����Ѷ����ܿ�ѷ��������������Ϣ�����ż��Ŵ����˹�١��Ҹ����������µǿƿ�������
	   ����Ҫ�����Ǻ�����ͨ�����ð�ܽ�ա��Ҹ�����ɪ�ա������������з��ĸ߿Ƽ���ý������������������������������ٴκϷ���',
	   '2018-06-15','2018-07-15','126','�����¡�����','���׸�T�����ɭ������������','3D','������������ð��'),
	   
	  ('LMA20170002','../../img/xingjing.jpg','��Ϻ�̾�',
	  '����Ϻ�̾�������ʵ���¸ı࣬�����������ɣ���ǧԴ�Σ����޼�Ů���㣨Ԭ���Σ������ڰ�����״̬�����壨�����Σ���
	  �Լ����˳��ң������Σ���ɵĲ����׼����̾�С�ӣ�Ϊ�˸����εؼ��Ӷ��������¸��ڵ���Ϻ�ꡣȴ���������������
	  ����ֻ��һ�߾�Ӫ��Ϻ��һ����Ѱ�������ɴ�����һϵ�о��Ķ��Ƕ��ֱ���һ��Ȥζ�Ĺ��� [2]  ��',
	  '2018-06-22','2018-07-22','93','���ܿ','��ǧԴ��Ԭ�橣�����','2D','���ˡ����顢��������ʳ��ϲ��'),
	  
	  ('LMA20170003','../../img/shijie.jpg','٪�޼�����2',
	  '��٪�޼�����2����ʱ���������٪�޼��������⹫԰�������ȼٴ屻ʧ�صĿ����Ǵݻ������,�ɲ��������Ѿ�����������,
	  �����Ҵ�Ŀ������ڴ������Ը����㡣�����ϵ����߻�ɽ��ʼ��Ծ�Ժ�,ŷ��(����˹����������)�������(����˿������˹����������)
	  ������һ���˶�,��Ҫ���������Ҵ�Ŀ������������ [4]  ��',
	  '2018-06-15','2018-07-15','128','������������¡�������','����˹�������أ�����˿������˹��������','3D','�������ƻá�ð��')
GO
Insert Into customer
Values('CUS80000001','������','��','13848910364'),
	   ('CUS80000002','�¾���','��','13845678911'),
	   ('CUS80000003','��ΰ��','��','18645678912'),
	   ('CUS80000004','¬����','��','18945646910'),
	   ('CUS80000005','������','��','15915467911'),
	   ('CUS80000006','֣����','��','13945563412'),
	   ('CUS80000007','������','��','13676588910'),
	   ('CUS80000008','������','��','18953438992'),
	   ('CUS80000009','������','��','13845888914'),
	   ('CUS80000010','ʷ����','��','13945564552'),
	   ('CUS80000011','������','��','18045678889'),
	   ('CUS80000012','���Ƴ�','��','18645678912'),
	   ('CUS80000013','������','��','15915467911'),
	   ('CUS80000014','�º貨','��','15968766783'),
	   ('CUS80000015','�쳩��','��','18645678912'),
	   ('CUS80000016','�����','��','18832338373'),
	   ('CUS80000017','�����','��','18745368919'),
	   ('CUS80000018','�����','��','18645678912'),
	   ('CUS80000019','���ǳ�','��','15915467911'),
	   ('CUS80000020','������','��','18005888690'),
	   ('CUS80000021','�����','Ů','13845678911'),
	   ('CUS80000022','������','Ů','15977896783'),
	   ('CUS80000023','������','Ů','13945564552'),
	   ('CUS80000024','Ӧ��ѩ','Ů','13775628971'),
	   ('CUS80000025','�����','Ů','15977896783'),
	   ('CUS80000026','�˳���','Ů','13845678911'),
	   ('CUS80000027','�²�ϼ','Ů','18956924567'),
	   ('CUS80000028','�¼�¶','Ů','15977896783'),
	   ('CUS80000029','��С��','Ů','18997666983'),
	   ('CUS80000030','¬����','Ů','18005888690'),
	   ('CUS80000031','������','Ů','18997666983'),
	   ('CUS80000032','����Ⱥ','Ů','18005888690'),
	   ('CUS80000033','�µ��','Ů','18669876809'),
	   ('CUS80000034','������','Ů','18997666983'),
	   ('CUS80000035','�װٻ�','Ů','18956924567'),
	   ('CUS80000036','��ӨӨ','Ů','13945564552'),
	   ('CUS80000037','����Ƽ','Ů','18669876809'),
	   ('CUS80000038','�����','Ů','18956924567'),
	   ('CUS80000039','������','Ů','13869906233'),
	   ('CUS80000040','�����','Ů','18997666983')
GO
--Insert Into customer
--Values('CUS80000001','������','��','13848910364','4'),
--	   ('CUS80000002','�¾���','��','13845678911','5'),
--	   ('CUS80000003','��ΰ��','��','18645678912','6'),
--	   ('CUS80000004','¬����','��','18945646910','7'),
--	   ('CUS80000005','������','��','15915467911','8'),
--	   ('CUS80000006','֣����','��','13945563412','9'),
--	   ('CUS80000007','������','��','13676588910','10'),
--	   ('CUS80000008','������','��','18953438992','11'),
--	   ('CUS80000009','������','��','13845888914','12'),
--	   ('CUS80000010','ʷ����','��','13945564552','13'),
--	   ('CUS80000011','������','��','18045678889','14'),
--	   ('CUS80000012','���Ƴ�','��','18645678912','15'),
--	   ('CUS80000013','������','��','15915467911','16'),
--	   ('CUS80000014','�º貨','��','15968766783','17'),
--	   ('CUS80000015','�쳩��','��','18645678912','18'),
--	   ('CUS80000016','�����','��','18832338373','19'),
--	   ('CUS80000017','�����','��','18745368919','20'),
--	   ('CUS80000018','�����','��','18645678912','21'),
--	   ('CUS80000019','���ǳ�','��','15915467911','22'),
--	   ('CUS80000020','������','��','18005888690','23'),
--	   ('CUS80000021','�����','Ů','13845678911','24'),
--	   ('CUS80000022','������','Ů','15977896783','25'),
--	   ('CUS80000023','������','Ů','13945564552','26'),
--	   ('CUS80000024','Ӧ��ѩ','Ů','13775628971','27'),
--	   ('CUS80000025','�����','Ů','15977896783','28'),
--	   ('CUS80000026','�˳���','Ů','13845678911','29'),
--	   ('CUS80000027','�²�ϼ','Ů','18956924567','30'),
--	   ('CUS80000028','�¼�¶','Ů','15977896783','31'),
--	   ('CUS80000029','��С��','Ů','18997666983','32'),
--	   ('CUS80000030','¬����','Ů','18005888690','33'),
--	   ('CUS80000031','������','Ů','18997666983','34'),
--	   ('CUS80000032','����Ⱥ','Ů','18005888690','35'),
--	   ('CUS80000033','�µ��','Ů','18669876809','36'),
--	   ('CUS80000034','������','Ů','18997666983','37'),
--	   ('CUS80000035','�װٻ�','Ů','18956924567','38'),
--	   ('CUS80000036','��ӨӨ','Ů','13945564552','39'),
--	   ('CUS80000037','����Ƽ','Ů','18669876809','40'),
--	   ('CUS80000038','�����','Ů','18956924567','41'),
--	   ('CUS80000039','������','Ů','13869906233','42'),
--	   ('CUS80000040','�����','Ů','18997666983','43')
--GO
Insert Into vip
Values ('CUS80000001','0.9','����','6��'),
	   ('CUS80000002','0.7','�м�','5��'),
	   ('CUS80000003','0.5','�߼�','16��'),
	   ('CUS80000004','0.9','����','18��'),
	   ('CUS80000005','0.7','�м�','20��'),
	   ('CUS80000006','0.9','����','25��'),
	   ('CUS80000007','0.5','�߼�','13��'),
	   ('CUS80000008','0.7','�м�','27��'),
	   ('CUS80000009','0.9','����','6��'),
	   ('CUS80000010','0.5','�߼�','29��'),
	   ('CUS80000011','0.5','�߼�','7��'),
	   ('CUS80000012','0.9','����','10��'),
	   ('CUS80000013','0.7','�м�','16��'),
	   ('CUS80000014','0.7','�м�','18��'),
	   ('CUS80000015','0.7','�м�','21��'),
	   ('CUS80000016','0.9','����','8��'),
	   ('CUS80000017','0.9','����','16��'),
	   ('CUS80000018','0.5','�߼�','23��'),
	   ('CUS80000019','0.5','�߼�','17��'),
	   ('CUS80000020','0.5','�߼�','8��'),
	   ('CUS80000021','0.9','����','30��'),
	   ('CUS80000022','0.7','�м�','9��'),
	   ('CUS80000023','0.5','�߼�','13��'),
	   ('CUS80000024','0.9','����','25��'),
	   ('CUS80000025','0.5','�߼�','25��'),
	   ('CUS80000026','0.5','�߼�','17��'),
	   ('CUS80000027','0.9','����','27��'),
	   ('CUS80000028','0.7','�м�','23��'),
	   ('CUS80000029','0.7','�м�','61��'),
	   ('CUS80000030','0.9','����','26��'),
	   ('CUS80000031','0.9','����','14��'),
	   ('CUS80000032','0.5','�߼�','24��'),
	   ('CUS80000033','0.9','����','36��'), 
	   ('CUS80000034','0.9','����','17��'),
	   ('CUS80000035','0.5','�߼�','16��'),
	   ('CUS80000036','0.9','����','13��'),
	   ('CUS80000037','0.5','�߼�','14��'),
	   ('CUS80000038','0.7','�м�','16��'),
	   ('CUS80000039','0.9','����','18��'),
	   ('CUS80000040','0.5','�߼�','26��')
GO
Insert Into hall
Values('HALL001','1����','8','16','128','С','����'),
	  ('HALL002','2����','8','16','128','С','������'),
	  ('HALL003','3����','9','15','135','С','����'),
	  ('HALL004','4����','9','15','135','С','������'),
	  ('HALL005','5����','12','20','240','��','������'),
	  ('HALL006','6����','11','21','231','��','����'),
	  ('HALL007','7����','12','20','240','��','������'),
	  ('HALL008','8����','11','21','231','��','����'),
      ('HALL009','IMAX1��','9','16','145','IMAX','������'),
      ('HALL010','IMAX2��','12','21','252','IMAX','����')
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
--4.1����鵼��
Select * From hall
Select * From movie
Select * From play
Select * From ticket
GO
Select mov_name,hal_name  From ticket,movie,hall
select * From users where pwdcompare('123456', use_password)=1
go
-------------������ܴ�����----------
--Create trigger tr_user
--ON users
--instead of insert
--AS
--Declare @use_id varchar(11),@use_name varchar(40),@use_password varbinary(1024),@use_level int
--Select @use_id=use_id,@use_name=use_name,@use_password = use_password,@use_level=use_level from inserted
--insert Into users Values(@use_id,@use_name,@use_password,@use_level)
--GO


-----------------------------��ͼ-----------------------------

---------------------------��ѯ��Ա 
Select customer.*,vip_discount,vip_id,cus_viptime From customer,vip where vip.cus_id = customer.cus_id
GO
Create View v_vip
As
	Select customer.*,vip_discount,vip_id,cus_viptime 
	From customer,vip where vip.cus_id = customer.cus_id
GO
----------------------------��ѯ��Ӱ
Create View v_movie
AS
	Select mov_name,mov_indate,mov_time,mov_kind,mov_style  From movie
GO
----------------------------��ѯ����  
Create View v_play
AS
	Select pla_id,hal_name,hal_count,hal_kind,mov_name,pla_starttime,mov_time,tic_price from hall,movie,play
	Where hall.hal_id = play.hal_id and play.mov_id=movie.mov_id
GO

-----------------------------������-----------------------------

--------------------------------ɾ������
Create trigger tr_play
ON play
For delete
As 
declare @playid varchar(11)
select @playid = pla_id from deleted
delete ticket where pla_id = @playid
GO
------------------------------------���볡�� 
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
--			print '��ʱ����е�Ӱ�ڴ�Ӱ�����ţ�'
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
--			print '��ʱ����е�Ӱ�ڴ�Ӱ�����ţ�'
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
			print '��ʱ����е�Ӱ�ڴ�Ӱ�����ţ�'
			rollback
		end
	else
		Insert Into play Values(@pla_id,@hal_id,@mov_id,@pla_starttime,@tic_price)
GO
----------------------------��Ա����   
Create trigger tr_vip
ON vip 
instead of insert
AS
Declare @cus_id varchar(11),@vip_discount varchar(40),@vip_id varchar(11),@cus_viptime varchar(40)
Select @cus_id = cus_id,@vip_discount = vip_discount,@vip_id = vip_id,@cus_viptime = cus_viptime from inserted
if(@vip_id = '�߼�')
	set @vip_discount = '0.5'
else if(@vip_id = '�м�')
	set @vip_discount = '0.7'
else set @vip_discount = '0.9'
insert Into vip Values(@cus_id,@vip_discount,@vip_id,@cus_viptime)
GO
----------------------------�û�����   
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
Values('CUS80000100','222','��','13848910364')
GO
--drop trigger tr_users
select * from customer where use_id='44'
select * from users where use_id='44'
GO
-----------------------------��Ա�޸�
Create trigger tr_vipmodifty
ON vip 
for update
AS
Declare @cus_id varchar(11),@vip_discount varchar(40),@vip_id varchar(11),@cus_viptime varchar(40)
Select @cus_id = cus_id,@vip_discount = vip_discount,@vip_id = vip_id,@cus_viptime = cus_viptime from inserted
if(@vip_id = '�߼�')
	set @vip_discount = '0.5'
else if(@vip_id = '�м�')
	set @vip_discount = '0.7'
else set @vip_discount = '0.9'
update vip set vip_discount=@vip_discount,vip_id=@vip_id,cus_viptime=@cus_viptime where cus_id=@cus_id
GO
update vip set vip_discount='0',vip_id='�м�',cus_viptime = '13��' where cus_id = 'CUS80000001'
Select * From vip
GO


------------------------------ɾ���˿�
Create trigger tr_Customer
ON Customer
For delete
As 
declare @cus_id varchar(11)
select @cus_id=cus_id from deleted
delete vip  where cus_id = @cus_id
GO

-----------------------------------�洢����------------------------------

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
---------------����Ӱ�����ƺ͵�Ӱ�����޸ĳ���
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
@movie_name = '��Ϻ�̾�',@hall_name = '1����',
@movie_id=@mid output,@hall_id=@hid output
Update play set mov_id = @mid,hal_id = @hid,tic_price = '53.00' Where pla_id = 'PLAY2017002'
GO
select * From play 
go
---------------------------------��ѯ��ӰƱ   �洢����
Create PROC pr_ticket
AS
Begin
	Select tic_id,hal_number,hal_name,mov_name,tic_price from ticket,hall,movie,play
	Where hall.hal_id = play.hal_id and play.mov_id=movie.mov_id and ticket.pla_id = play.pla_id
End
GO
EXEC pr_ticket
GO
---------------------------------��ѯӰ��   �洢���� 
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