mysql> use huxiaoyang;
Database changed
mysql> select * from goods;
+----------+--------+----------+--------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
| goods_id | cat_id | goods_sn | goods_name   | click_count | goods_number | market_price | shop_price | add_time | is_best | is_new | is_hot |
+----------+--------+----------+--------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
|        1 |      0 |          | 灏忚摑娴�       |           0 |            0 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        2 |      0 |          | 涓崕棣欑儫     |           0 |            0 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        3 |      0 |          | 鍗庝负鎵嬫満     |           0 |            0 |      6200.00 |    3800.00 |        0 |       0 |      0 |      0 |
|        4 |      0 |          | 闈㈢矇         |           0 |            0 |        26.30 |      20.60 |        0 |       0 |      0 |      0 |
|        5 |      0 |          | 鑰虫満         |           0 |            0 |       500.65 |     420.50 |        0 |       0 |      0 |      0 |
+----------+--------+----------+--------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
5 rows in set (0.00 sec)

mysql> set names gbk;
Query OK, 0 rows affected (0.00 sec)

mysql> select * from goods;
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
| goods_id | cat_id | goods_sn | goods_name | click_count | goods_number | market_price | shop_price | add_time | is_best | is_new | is_hot |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
|        1 |      0 |          | 小蓝海          |           0 |            0 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        2 |      0 |          | 中华香烟          |           0 |            0 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        3 |      0 |          | 华为手机         |           0 |            0 |      6200.00 |    3800.00 |        0 |       0 |      0 |      0 |
|        4 |      0 |          | 面粉           |           0 |            0 |        26.30 |      20.60 |        0 |       0 |      0 |      0 |
|        5 |      0 |          | 耳机           |           0 |            0 |       500.65 |     420.50 |        0 |       0 |      0 |      0 |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
5 rows in set (0.00 sec)

mysql> #查询除最贵的商品价格，即查询shop_price最大的值查询出来。
mysql> select max(shop_price) from goos;
ERROR 1146 (42S02): Table 'huxiaoyang.goos' doesn't exist
mysql> select max(shop_price) from goods;
+-----------------+
| max(shop_price) |
+-----------------+
|         3800.00 |
+-----------------+
1 row in set (0.00 sec)

mysql> #查询最便宜的。
mysql> select min(shop_price) from goods;
+-----------------+
| min(shop_price) |
+-----------------+
|           20.60 |
+-----------------+
1 row in set (0.00 sec)

mysql> #求总和用sum函数
mysql> select sum(goods_id) from goods;
+---------------+
| sum(goods_id) |
+---------------+
|            15 |
+---------------+
1 row in set (0.00 sec)

mysql> #求平均价格avg（）
mysql> select avg(shop_price) from goods;
+-----------------+
| avg(shop_price) |
+-----------------+
|      879.160000 |
+-----------------+
1 row in set (0.02 sec)

mysql> #求总共的行数
mysql> select count(*) from goods;
+----------+
| count(*) |
+----------+
|        5 |
+----------+
1 row in set (0.00 sec)

mysql> insert into goods 
    -> (goods_name,shop_price)
    -> values
    -> ('����',56);
Query OK, 1 row affected (0.00 sec)

mysql> select count(goods_name) from goods;
+-------------------+
| count(goods_name) |
+-------------------+
|                 6 |
+-------------------+
1 row in set (0.00 sec)

mysql> insert into goods
    -> (goods_name,shop_price)
    -> values
    -> (null,null);
ERROR 1048 (23000): Column 'goods_name' cannot be null
mysql> select * from goods;
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
| goods_id | cat_id | goods_sn | goods_name | click_count | goods_number | market_price | shop_price | add_time | is_best | is_new | is_hot |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
|        1 |      0 |          | С����          |           0 |            0 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        2 |      0 |          | �л�����          |           0 |            0 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        3 |      0 |          | ��Ϊ�ֻ�         |           0 |            0 |      6200.00 |    3800.00 |        0 |       0 |      0 |      0 |
|        4 |      0 |          | ���           |           0 |            0 |        26.30 |      20.60 |        0 |       0 |      0 |      0 |
|        5 |      0 |          | ����           |           0 |            0 |       500.65 |     420.50 |        0 |       0 |      0 |      0 |
|        6 |      0 |          | ����           |           0 |            0 |         0.00 |      56.00 |        0 |       0 |      0 |      0 |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
6 rows in set (0.00 sec)

mysql> update goods set cat_id =3 where goods_id between 1 and 3;
Query OK, 3 rows affected (0.00 sec)
Rows matched: 3  Changed: 3  Warnings: 0

mysql> update goods set cat_id =2 where goods_id between 5 and 6;
Query OK, 2 rows affected (0.00 sec)
Rows matched: 2  Changed: 2  Warnings: 0

mysql> #���ݲ�ͬ��cat_id���м�����
mysql> select count(*) from goods group by cat_id;
+----------+
| count(*) |
+----------+
|        1 |
|        2 |
|        3 |
+----------+
3 rows in set (0.00 sec)

mysql> update goods set goods_number =2 where goods_id=1;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update goods set goods_number =26 where goods_id=0;
Query OK, 0 rows affected (0.00 sec)
Rows matched: 0  Changed: 0  Warnings: 0

mysql> update goods set goods_number =26 where goods_id=2;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update goods set goods_number =6 where goods_id=3;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update goods set goods_number =855 where goods_id=4;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update goods set goods_number =85 where goods_id=5;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update goods set goods_number =75 where goods_id=6;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from goods;
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
| goods_id | cat_id | goods_sn | goods_name | click_count | goods_number | market_price | shop_price | add_time | is_best | is_new | is_hot |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
|        1 |      3 |          | С����          |           0 |            2 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        2 |      3 |          | �л�����          |           0 |           26 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        3 |      3 |          | ��Ϊ�ֻ�         |           0 |            6 |      6200.00 |    3800.00 |        0 |       0 |      0 |      0 |
|        4 |      0 |          | ���           |           0 |          855 |        26.30 |      20.60 |        0 |       0 |      0 |      0 |
|        5 |      2 |          | ����           |           0 |           85 |       500.65 |     420.50 |        0 |       0 |      0 |      0 |
|        6 |      2 |          | ����           |           0 |           75 |         0.00 |      56.00 |        0 |       0 |      0 |      0 |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
6 rows in set (0.00 sec)

mysql> select goods_name,sum(goods_number) from goods group by cat_id;
+------------+-------------------+
| goods_name | sum(goods_number) |
+------------+-------------------+
| ���           |               855 |
| ����           |               160 |
| С����          |                34 |
+------------+-------------------+
3 rows in set (0.00 sec)

mysql> select cat_id,sum(goods_number) from goods group by cat_id;
+--------+-------------------+
| cat_id | sum(goods_number) |
+--------+-------------------+
|      0 |               855 |
|      2 |               160 |
|      3 |                34 |
+--------+-------------------+
3 rows in set (0.00 sec)

mysql> select goods_name,market_price,shop_price ,(market_price-shop_price) as discount 
    -> from goods where 1
    -> having discount > 200;
+------------+--------------+------------+----------+
| goods_name | market_price | shop_price | discount |
+------------+--------------+------------+----------+
| ��Ϊ�ֻ�         |      6200.00 |    3800.00 |  2400.00 |
+------------+--------------+------------+----------+
1 row in set (0.00 sec)

mysql> #a��ѯÿ����Ʒ��ѹ�Ļ����Ʒ����*��Ʒ�۸�
mysql> select goods_id,goods_number,shop_price,(goods_number*shop_price) as hk from goods;
+----------+--------------+------------+----------+
| goods_id | goods_number | shop_price | hk       |
+----------+--------------+------------+----------+
|        1 |            2 |      77.35 |   154.70 |
|        2 |           26 |      77.35 |  2011.10 |
|        3 |            6 |    3800.00 | 22800.00 |
|        4 |          855 |      20.60 | 17613.00 |
|        5 |           85 |     420.50 | 35742.50 |
|        6 |           75 |      56.00 |  4200.00 |
+----------+--------------+------------+----------+
6 rows in set (0.00 sec)

mysql> #��ѯ��ѹ�Ļ���֮�͡�
mysql> select sum(shop_price*goods_number) as sum from goods;
+----------+
| sum      |
+----------+
| 82521.30 |
+----------+
1 row in set (0.00 sec)

mysql> select (goods_number*shop_price) as hk from goods;
+----------+
| hk       |
+----------+
|   154.70 |
|  2011.10 |
| 22800.00 |
| 17613.00 |
| 35742.50 |
|  4200.00 |
+----------+
6 rows in set (0.00 sec)

mysql> select (goods_number*shop_price) as hk from goods
    -> having sum(hk);
+--------+
| hk     |
+--------+
| 154.70 |
+--------+
1 row in set (0.00 sec)

mysql> ��ѯÿ��cat_id�»�ѹ�Ļ���
    -> select cat_id,sum(shop_price*goods_number) as sum from goods group by cat_id;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '��ѯÿ��cat_id�»�ѹ�Ļ���
select cat_id,sum(shop_price*goods_number) ' at line 1
mysql> select cat_id,sum(shop_price*goods_number) as sum from goods group by cat_id;
+--------+----------+
| cat_id | sum      |
+--------+----------+
|      0 | 17613.00 |
|      2 | 39942.50 |
|      3 | 24965.80 |
+--------+----------+
3 rows in set (0.00 sec)

mysql> select cat_id,sum(shop_price*goods_number) as sumhk from goods group by cat_id 
    -> having sumhk >20000;
+--------+----------+
| cat_id | sumhk    |
+--------+----------+
|      2 | 39942.50 |
|      3 | 24965.80 |
+--------+----------+
2 rows in set (0.00 sec)

mysql> #��ѯ����ѹ�������20000����Ŀ��
mysql> select cat_id,sum(shop_price*goods_number) as sumhk from goods group by cat_id 
    -> having sumhk >20000;
+--------+----------+
| cat_id | sumhk    |
+--------+----------+
|      2 | 39942.50 |
|      3 | 24965.80 |
+--------+----------+
2 rows in set (0.00 sec)

mysql> create table score(
    -> name varchar(10) not null default '',
    -> subject varchar(10) not null default '',
    -> score tinyint(3) unsigned not null default 0)
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.02 sec)

mysql> desc score;
+---------+---------------------+------+-----+---------+-------+
| Field   | Type                | Null | Key | Default | Extra |
+---------+---------------------+------+-----+---------+-------+
| name    | varchar(10)         | NO   |     |         |       |
| subject | varchar(10)         | NO   |     |         |       |
| score   | tinyint(3) unsigned | NO   |     | 0       |       |
+---------+---------------------+------+-----+---------+-------+
3 rows in set (0.02 sec)

mysql> insert into score
    -> values
    -> ('����','��ѧ',90),
    -> ('����','����',50)��
    -> ('����','����',40),
    -> ('����','����',55),
    -> ('����','����',45),
    -> ('����','����',30);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '��
('����','����',40),
('����','����',55),
('����','����',45),
('' at line 4
mysql> insert into score
    -> values
    -> ('����','��ѧ',90);
Query OK, 1 row affected (0.00 sec)

mysql> insert into score
    -> values
    -> ('����','����',50),
    -> ('����','����',40),
    -> ('����','����',55),
    -> ('����','����',45),
    -> ('����','����',30);
Query OK, 5 rows affected (0.00 sec)
Records: 5  Duplicates: 0  Warnings: 0

mysql> select * from score;
+------+---------+-------+
| name | subject | score |
+------+---------+-------+
| ����     | ��ѧ       |    90 |
| ����     | ����        |    50 |
| ����     | ����        |    40 |
| ����     | ����        |    55 |
| ����     | ����        |    45 |
| ����     | ����        |    30 |
+------+---------+-------+
6 rows in set (0.00 sec)

mysql> #Ŀ�꣺��ѯ��2�ż�2�����ϲ������ߵ�ƽ���ɼ�
mysql> select name,count(subject) as count,avg(score) as avg_score from score
    -> having count>=2 and avg_score\c
mysql> select name,count(score<60) as count,avg(score) as avg_score from score
    -> group by name
    -> having count>=2;
+------+-------+-----------+
| name | count | avg_score |
+------+-------+-----------+
| ����     |     3 |   60.0000 |
| ����     |     2 |   50.0000 |
+------+-------+-----------+
2 rows in set (0.00 sec)

mysql> show create table result;
ERROR 1146 (42S02): Table 'huxiaoyang.result' doesn't exist
mysql> show create table score;
+-------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Table | Create Table                                                                                                                                                                                          |
+-------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| score | CREATE TABLE `score` (
  `name` varchar(10) NOT NULL DEFAULT '',
  `subject` varchar(10) NOT NULL DEFAULT '',
  `score` tinyint(3) unsigned NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 |
+-------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)

mysql> select name,count(score<60) as count,avg(score) as avg_score from score
    -> group by name\c
mysql> select name ,avg(score),sum(score<60) from score group by name
    -> having sum > =2;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '=2' at line 2
mysql> select name ,avg(score),sum(score<60) from score group by name
    -> having sum >=2;
ERROR 1054 (42S22): Unknown column 'sum' in 'having clause'
mysql> select name ,avg(score),sum(score<60) as gks from score group by name
    -> having gks >=2;
+------+------------+------+
| name | avg(score) | gks  |
+------+------------+------+
| ����     |    60.0000 |    2 |
| ����     |    50.0000 |    2 |
+------+------------+------+
2 rows in set (0.00 sec)

mysql> #����������ȥ����
mysql> select name,count(-1) from score where score<60 group by name having count(-1)>=2;
+------+-----------+
| name | count(-1) |
+------+-----------+
| ����     |         2 |
| ����     |         2 |
+------+-----------+
2 rows in set (0.00 sec)

mysql> #������Ľ������Ϊ�±���ʹ�ã������Ѿ�ѡ���˹ҿ�2�ż�2�����ϵ��ˡ�
mysql> select name,avg(score) from(select name,count(-1) from score where score<60 group by name having count(-1)>=2);
ERROR 1248 (42000): Every derived table must have its own alias
mysql> select name,avg(score) from(select name,count(-1) from score where score<60 group by name having count(-1)>=2) as temp;
ERROR 1054 (42S22): Unknown column 'score' in 'field list'
mysql> select name from(select name,count(-1) from score where score<60 group by name having count(-1)>=2) as temp;
+------+
| name |
+------+
| ����     |
| ����     |
+------+
2 rows in set (0.00 sec)

mysql> #��������ȡ���˹ҿ�2�ż�2�����ϵ���
mysql> select name,avg(score) from score where name in (select name from(select name,count(-1) from score where score<60 group by name having count(-1)>=2) as temp);
+------+------------+
| name | avg(score) |
+------+------------+
| ����     |    56.0000 |
+------+------------+
1 row in set (0.00 sec)

mysql> select name,avg(score) from score where name in (select name from(select name,count(-1) from score where score<60 group by name having count(-1)>=2) as temp) group by name;
+------+------------+
| name | avg(score) |
+------+------------+
| ����     |    60.0000 |
| ����     |    50.0000 |
+------+------------+
2 rows in set (0.00 sec)

