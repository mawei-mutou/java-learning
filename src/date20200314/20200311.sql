mysql> use huxiaoyang;
Database changed
mysql> select goods_id,goods_name max(goods_id) as max from goods where goods_id =max;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'max(goods_id) as max from goods where goods_id =max' at line 1
mysql> select goods_id,goods_name ,max(goods_id) as max from goods where goods_id =max;
ERROR 1054 (42S22): Unknown column 'max' in 'where clause'
mysql> select goods_id,goods_name from goods where goods_id in  (selecet max(goods_id) from goods);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'max(goods_id) from goods)' at line 1
mysql> select max(goods_id) from goods;
+---------------+
| max(goods_id) |
+---------------+
|             6 |
+---------------+
1 row in set (0.00 sec)

mysql> select goods_id,goods_name from where goods_id in(select max(goods_id) from goods);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'where goods_id in(select max(goods_id) from goods)' at line 1
mysql> select goods_id,goods_name from where goods_id =(select max(goods_id) from goods);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'where goods_id =(select max(goods_id) from goods)' at line 1
mysql> select * from goods;
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
| goods_id | cat_id | goods_sn | goods_name | click_count | goods_number | market_price | shop_price | add_time | is_best | is_new | is_hot |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
|        1 |      3 |          | 小蓝海          |           0 |            2 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        2 |      3 |          | 中华香烟          |           0 |           26 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        3 |      3 |          | 华为手机         |           0 |            6 |      6200.00 |    3800.00 |        0 |       0 |      0 |      0 |
|        4 |      0 |          | 面粉           |           0 |          855 |        26.30 |      20.60 |        0 |       0 |      0 |      0 |
|        5 |      2 |          | 耳机           |           0 |           85 |       500.65 |     420.50 |        0 |       0 |      0 |      0 |
|        6 |      2 |          | 耳机           |           0 |           75 |         0.00 |      56.00 |        0 |       0 |      0 |      0 |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
6 rows in set (0.00 sec)

mysql> select goods_id,goods_name from goods where goods_id =(select max(goods_id) from goods);
+----------+------------+
| goods_id | goods_name |
+----------+------------+
|        6 | 耳机           |
+----------+------------+
1 row in set (0.00 sec)

mysql> insert into goods
    -> values
    -> (85,23,'汽车',)\c
mysql> insert into goods
    -> (goods_id,cat_id,goods_name,market_price,shop_price)
    -> values
    -> (85,23,'汽车',360000,330000);
Query OK, 1 row affected (0.00 sec)

mysql> insert into goods
    -> (goods_id,cat_id,goods_name,market_price,shop_price)
    -> values
    -> (23,5,'水杯',30,26);
Query OK, 1 row affected (0.00 sec)

mysql> select * from goods;
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
| goods_id | cat_id | goods_sn | goods_name | click_count | goods_number | market_price | shop_price | add_time | is_best | is_new | is_hot |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
|        1 |      3 |          | 小蓝海          |           0 |            2 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        2 |      3 |          | 中华香烟          |           0 |           26 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        3 |      3 |          | 华为手机         |           0 |            6 |      6200.00 |    3800.00 |        0 |       0 |      0 |      0 |
|        4 |      0 |          | 面粉           |           0 |          855 |        26.30 |      20.60 |        0 |       0 |      0 |      0 |
|        5 |      2 |          | 耳机           |           0 |           85 |       500.65 |     420.50 |        0 |       0 |      0 |      0 |
|        6 |      2 |          | 耳机           |           0 |           75 |         0.00 |      56.00 |        0 |       0 |      0 |      0 |
|       85 |     23 |          | 汽车           |           0 |            0 |    360000.00 |  330000.00 |        0 |       0 |      0 |      0 |
|       23 |      5 |          | 水杯          |           0 |            0 |        30.00 |      26.00 |        0 |       0 |      0 |      0 |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
8 rows in set (0.00 sec)

mysql> select goods_id,goods_name from goods where goods_id =(select max(goods_id) from goods);
+----------+------------+
| goods_id | goods_name |
+----------+------------+
|       85 | 汽车           |
+----------+------------+
1 row in set (0.02 sec)

mysql> #查询每个栏目下good_id最大的商品
mysql> select max(goods_id) from goods group by cat_id;
+---------------+
| max(goods_id) |
+---------------+
|             4 |
|             6 |
|             3 |
|            23 |
|            85 |
+---------------+
5 rows in set (0.00 sec)

mysql> select cat_id, max(goods_id) from goods group by cat_id;
+--------+---------------+
| cat_id | max(goods_id) |
+--------+---------------+
|      0 |             4 |
|      2 |             6 |
|      3 |             3 |
|      5 |            23 |
|     23 |            85 |
+--------+---------------+
5 rows in set (0.00 sec)

mysql> select goods_id,goods_name from goods where  goods_id =(select max(goods_id) from goods) group by cat_id;
+----------+------------+
| goods_id | goods_name |
+----------+------------+
|       85 | 汽车           |
+----------+------------+
1 row in set (0.00 sec)

mysql> select goods_id,goods_name from goods where  goods_id in (select max(goods_id) from goods);
+----------+------------+
| goods_id | goods_name |
+----------+------------+
|       85 | 汽车           |
+----------+------------+
1 row in set (0.00 sec)

mysql> select goods_id,goods_name from goods where  goods_id  in (select max(goods_id) from goods group by cat_id);
+----------+------------+
| goods_id | goods_name |
+----------+------------+
|        3 | 华为手机         |
|        4 | 面粉           |
|        6 | 耳机           |
|       85 | 汽车           |
|       23 | 水杯          |
+----------+------------+
5 rows in set (0.00 sec)

mysql> #也可以使用下面的方式取
mysql> select goods_id,goods_name from goods order by cat_id,goods_id desc ;
+----------+------------+
| goods_id | goods_name |
+----------+------------+
|        4 | 面粉           |
|        6 | 耳机           |
|        5 | 耳机           |
|        3 | 华为手机         |
|        2 | 中华香烟          |
|        1 | 小蓝海          |
|       23 | 水杯          |
|       85 | 汽车           |
+----------+------------+
8 rows in set (0.00 sec)

mysql> select cat_id, goods_id,goods_name from goods order by cat_id,goods_id desc ;
+--------+----------+------------+
| cat_id | goods_id | goods_name |
+--------+----------+------------+
|      0 |        4 | 面粉           |
|      2 |        6 | 耳机           |
|      2 |        5 | 耳机           |
|      3 |        3 | 华为手机         |
|      3 |        2 | 中华香烟          |
|      3 |        1 | 小蓝海          |
|      5 |       23 | 水杯          |
|     23 |       85 | 汽车           |
+--------+----------+------------+
8 rows in set (0.00 sec)

mysql> select * from (select cat_id,goods_id,goods_name from goods order by cat_id,goods_id desc) as temp;
+--------+----------+------------+
| cat_id | goods_id | goods_name |
+--------+----------+------------+
|      0 |        4 | 面粉           |
|      2 |        6 | 耳机           |
|      2 |        5 | 耳机           |
|      3 |        3 | 华为手机         |
|      3 |        2 | 中华香烟          |
|      3 |        1 | 小蓝海          |
|      5 |       23 | 水杯          |
|     23 |       85 | 汽车           |
+--------+----------+------------+
8 rows in set (0.00 sec)

mysql> select * from (select cat_id,goods_id,goods_name from goods order by cat_id,goods_id desc) as temp group by cat_id;
+--------+----------+------------+
| cat_id | goods_id | goods_name |
+--------+----------+------------+
|      0 |        4 | 面粉           |
|      2 |        6 | 耳机           |
|      3 |        3 | 华为手机         |
|      5 |       23 | 水杯          |
|     23 |       85 | 汽车           |
+--------+----------+------------+
5 rows in set (0.00 sec)

mysql> creat table test11
    -> (name varchar(20) )
    -> engine myisam charset utf8;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'creat table test11
(name varchar(20) )
engine myisam charset utf8' at line 1
mysql> creat table test11
    -> (name varchar(20) )
    -> engine myisam charset utf8;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'creat table test11
(name varchar(20) )
engine myisam charset utf8' at line 1
mysql> create table test11
    -> (name varchar(20) )
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.03 sec)

mysql> insert into test11 
    -> values
    -> 'lisi';
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ''lisi'' at line 3
mysql> insert into test11 
    -> values
    -> ('lisi'),('wangwu'),();
ERROR 1136 (21S01): Column count doesn't match value count at row 3
mysql> insert into test11 
    -> ('lisi'),('wangwu');
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ''lisi'),('wangwu')' at line 2
mysql> insert into test11 
    -> ('lisi');
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ''lisi')' at line 2
mysql> insert into test11 
    -> values
    -> ('lisi');
Query OK, 1 row affected (0.02 sec)

mysql> insert into test11 
    -> values
    -> ('si','wangwu',null);
ERROR 1136 (21S01): Column count doesn't match value count at row 1
mysql> insert into test11 
    -> values
    -> ('si','wangwu');
ERROR 1136 (21S01): Column count doesn't match value count at row 1
mysql> insert into test11 
    -> values
    -> ('si');
Query OK, 1 row affected (0.00 sec)

mysql> insert into test11 
    -> values
    -> 'si';
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ''si'' at line 3
mysql> insert into test11 
    -> values
    -> ('si','suf');
ERROR 1136 (21S01): Column count doesn't match value count at row 1
mysql> insert into test11 
    -> values
    -> ('si'），（'suf');
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '），（'suf')' at line 3
mysql> insert into test11 
    -> values
    -> ('si')，('suf');
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '，('suf')' at line 3
mysql> insert into test11 
    -> values
    -> ('ddd'),('lll');
Query OK, 2 rows affected (0.00 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> insert into test11 
    -> values
    -> (null);
Query OK, 1 row affected (0.00 sec)

mysql> select * from test11;
+------+
| name |
+------+
| lisi |
| si   |
| ddd  |
| lll  |
| NULL |
+------+
5 rows in set (0.00 sec)

mysql> select * from where name =null;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'where name =null' at line 1
mysql> select * from test11 where name =null;
Empty set (0.00 sec)

mysql> select * from test11 where name !=null;
Empty set (0.00 sec)

mysql> select * from test11 where name is not null;
+------+
| name |
+------+
| lisi |
| si   |
| ddd  |
| lll  |
+------+
4 rows in set (0.00 sec)

mysql> select * from test11 where name is null;
+------+
| name |
+------+
| NULL |
+------+
1 row in set (0.00 sec)

mysql> show table;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 1
mysql> show tables;
+----------------------+
| Tables_in_huxiaoyang |
+----------------------+
| class                |
| goods                |
| m1                   |
| menber               |
| nums                 |
| score                |
| test                 |
| test11               |
| test3                |
+----------------------+
9 rows in set (0.06 sec)

mysql> select class;
ERROR 1054 (42S22): Unknown column 'class' in 'field list'
mysql> select * from class;
+----+-------+--------+----------+--------+-------+-------+-------+---------+
| id | sname | gender | company  | salary | fanbu | score | sum   | bonus   |
+----+-------+--------+----------+--------+-------+-------+-------+---------+
|  3 | 刘备      |        | 皇室成员       |  15.28 |     0 |     0 | 00000 |    0.00 |
|  4 | 孙策      |        | 江东集团         |  56.34 |     0 |     0 | 00000 |    0.00 |
|  5 | 曹操     | 男       | 宦官后代       |  88.56 |   212 |     0 | 00000 |    0.00 |
|  6 | 姚东     | 男       |          |   0.00 |     0 |   240 | 00000 | 8880.89 |
|  7 | 姚东     |        |          |   0.00 |     0 |     0 | 00000 | 8880.89 |
+----+-------+--------+----------+--------+-------+-------+-------+---------+
5 rows in set (0.02 sec)

mysql> create table test4(
    -> cat_id tinyint(2) unsigned not null primary key auto_increment,
    -> cname varchar(10) not null default '')
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.02 sec)

mysql> insert into test4
    -> values
    -> (1,'猴子'；)
    -> \c
mysql> insert into test4
    -> values
    -> (1,'猴子');
Query OK, 1 row affected (0.01 sec)

mysql> insert into test4
    -> values
    -> (2,'老虎'),
    -> (3,''大象);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '大象)' at line 4
mysql> insert into test4
    -> values
    -> (2,'老虎'),
    -> (3,'大象');
Query OK, 2 rows affected (0.00 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> select * from test4;
+--------+-------+
| cat_id | cname |
+--------+-------+
|      1 | 猴子      |
|      2 | 老虎     |
|      3 | 大象      |
+--------+-------+
3 rows in set (0.00 sec)

mysql> create table test5
    -> (id tinyint(2) unsigned not null primary key auto_increment,
    -> name varchar(10) not null default '')
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.01 sec)

mysql> desc test5;
+-------+---------------------+------+-----+---------+----------------+
| Field | Type                | Null | Key | Default | Extra          |
+-------+---------------------+------+-----+---------+----------------+
| id    | tinyint(2) unsigned | NO   | PRI | NULL    | auto_increment |
| name  | varchar(10)         | NO   |     |         |                |
+-------+---------------------+------+-----+---------+----------------+
2 rows in set (0.01 sec)

mysql> insert into test5
    -> values
    -> (49,'云彩'),
    -> (85,'月亮');
Query OK, 2 rows affected (0.00 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> select * from test4,test5;
+--------+-------+----+------+
| cat_id | cname | id | name |
+--------+-------+----+------+
|      1 | 猴子      | 49 | 云彩    |
|      1 | 猴子      | 85 | 月亮     |
|      2 | 老虎     | 49 | 云彩    |
|      2 | 老虎     | 85 | 月亮     |
|      3 | 大象      | 49 | 云彩    |
|      3 | 大象      | 85 | 月亮     |
+--------+-------+----+------+
6 rows in set (0.00 sec)

mysql> create table test5
    -> (cat_id tinyint(2) unsigned not null primary key auto_increment,)
    ->  cname varchar(10) not null default '')\c
mysql> create table test5
    -> (cat_id tinyint(2) unsigned not null primary key auto_increment,
    -> cname varchar(10) not null default '',
    -> name varchar(10) not null default '')
    -> engine myisam charset utf8;
ERROR 1050 (42S01): Table 'test5' already exists
mysql> create table test6
    -> (cat_id tinyint(2) unsigned not null primary key auto_increment,
    -> cname varchar(10) not null default '',
    -> name varchar(10) not null default '')
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.02 sec)

mysql> insert into test6
    -> select cat_id, cname, name from (select * from test4,test5) as temp;
ERROR 1062 (23000): Duplicate entry '1' for key 'PRIMARY'
mysql> select cat_id, cname, name from (select * from test4,test5) as temp;
+--------+-------+------+
| cat_id | cname | name |
+--------+-------+------+
|      1 | 猴子      | 云彩    |
|      1 | 猴子      | 月亮     |
|      2 | 老虎     | 云彩    |
|      2 | 老虎     | 月亮     |
|      3 | 大象      | 云彩    |
|      3 | 大象      | 月亮     |
+--------+-------+------+
6 rows in set (0.00 sec)

mysql> 
mysql> select goods_name ,goods_id,cat_id ,cat_id,cname from goods,test4;
ERROR 1052 (23000): Column 'cat_id' in field list is ambiguous
mysql> select goods_name ,goods_id,goods.cat_id ,test4.cat_id,cname from goods,test4;
+------------+----------+--------+--------+-------+
| goods_name | goods_id | cat_id | cat_id | cname |
+------------+----------+--------+--------+-------+
| 小蓝海          |        1 |      3 |      1 | 猴子      |
| 小蓝海          |        1 |      3 |      2 | 老虎     |
| 小蓝海          |        1 |      3 |      3 | 大象      |
| 中华香烟          |        2 |      3 |      1 | 猴子      |
| 中华香烟          |        2 |      3 |      2 | 老虎     |
| 中华香烟          |        2 |      3 |      3 | 大象      |
| 华为手机         |        3 |      3 |      1 | 猴子      |
| 华为手机         |        3 |      3 |      2 | 老虎     |
| 华为手机         |        3 |      3 |      3 | 大象      |
| 面粉           |        4 |      0 |      1 | 猴子      |
| 面粉           |        4 |      0 |      2 | 老虎     |
| 面粉           |        4 |      0 |      3 | 大象      |
| 耳机           |        5 |      2 |      1 | 猴子      |
| 耳机           |        5 |      2 |      2 | 老虎     |
| 耳机           |        5 |      2 |      3 | 大象      |
| 耳机           |        6 |      2 |      1 | 猴子      |
| 耳机           |        6 |      2 |      2 | 老虎     |
| 耳机           |        6 |      2 |      3 | 大象      |
| 汽车           |       85 |     23 |      1 | 猴子      |
| 汽车           |       85 |     23 |      2 | 老虎     |
| 汽车           |       85 |     23 |      3 | 大象      |
| 水杯          |       23 |      5 |      1 | 猴子      |
| 水杯          |       23 |      5 |      2 | 老虎     |
| 水杯          |       23 |      5 |      3 | 大象      |
+------------+----------+--------+--------+-------+
24 rows in set (0.00 sec)

mysql> select goods_name ,goods_id,goods.cat_id ,test4.cat_id,cname from test4,goods;
+------------+----------+--------+--------+-------+
| goods_name | goods_id | cat_id | cat_id | cname |
+------------+----------+--------+--------+-------+
| 小蓝海          |        1 |      3 |      1 | 猴子      |
| 小蓝海          |        1 |      3 |      2 | 老虎     |
| 小蓝海          |        1 |      3 |      3 | 大象      |
| 中华香烟          |        2 |      3 |      1 | 猴子      |
| 中华香烟          |        2 |      3 |      2 | 老虎     |
| 中华香烟          |        2 |      3 |      3 | 大象      |
| 华为手机         |        3 |      3 |      1 | 猴子      |
| 华为手机         |        3 |      3 |      2 | 老虎     |
| 华为手机         |        3 |      3 |      3 | 大象      |
| 面粉           |        4 |      0 |      1 | 猴子      |
| 面粉           |        4 |      0 |      2 | 老虎     |
| 面粉           |        4 |      0 |      3 | 大象      |
| 耳机           |        5 |      2 |      1 | 猴子      |
| 耳机           |        5 |      2 |      2 | 老虎     |
| 耳机           |        5 |      2 |      3 | 大象      |
| 耳机           |        6 |      2 |      1 | 猴子      |
| 耳机           |        6 |      2 |      2 | 老虎     |
| 耳机           |        6 |      2 |      3 | 大象      |
| 汽车           |       85 |     23 |      1 | 猴子      |
| 汽车           |       85 |     23 |      2 | 老虎     |
| 汽车           |       85 |     23 |      3 | 大象      |
| 水杯          |       23 |      5 |      1 | 猴子      |
| 水杯          |       23 |      5 |      2 | 老虎     |
| 水杯          |       23 |      5 |      3 | 大象      |
+------------+----------+--------+--------+-------+
24 rows in set (0.00 sec)

mysql> select * from goods;
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
| goods_id | cat_id | goods_sn | goods_name | click_count | goods_number | market_price | shop_price | add_time | is_best | is_new | is_hot |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
|        1 |      3 |          | 小蓝海          |           0 |            2 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        2 |      3 |          | 中华香烟          |           0 |           26 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        3 |      3 |          | 华为手机         |           0 |            6 |      6200.00 |    3800.00 |        0 |       0 |      0 |      0 |
|        4 |      0 |          | 面粉           |           0 |          855 |        26.30 |      20.60 |        0 |       0 |      0 |      0 |
|        5 |      2 |          | 耳机           |           0 |           85 |       500.65 |     420.50 |        0 |       0 |      0 |      0 |
|        6 |      2 |          | 耳机           |           0 |           75 |         0.00 |      56.00 |        0 |       0 |      0 |      0 |
|       85 |     23 |          | 汽车           |           0 |            0 |    360000.00 |  330000.00 |        0 |       0 |      0 |      0 |
|       23 |      5 |          | 水杯          |           0 |            0 |        30.00 |      26.00 |        0 |       0 |      0 |      0 |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
8 rows in set (0.00 sec)

mysql> create table goods_name
    -> (cat_id tinyint(2) unsigned not null default 0,)
    -> \c
mysql> create table goods_name
    -> (cat_id tinyint(2) unsigned not null default 0,
    -> cat_name varchar(10) not null default '')
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.01 sec)

mysql> insert into goods_name
    -> values
    -> select cat_id,goods_name from goods;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'select cat_id,goods_name from goods' at line 3
mysql> insert into goods_name
    -> select cat_id,goods_name from goods;
Query OK, 8 rows affected (0.00 sec)
Records: 8  Duplicates: 0  Warnings: 0

mysql> select * from goods_name;
+--------+----------+
| cat_id | cat_name |
+--------+----------+
|      3 | 小蓝海        |
|      3 | 中华香烟        |
|      3 | 华为手机       |
|      0 | 面粉         |
|      2 | 耳机         |
|      2 | 耳机         |
|     23 | 汽车         |
|      5 | 水杯        |
+--------+----------+
8 rows in set (0.01 sec)

mysql> select count(1) from goods;
+----------+
| count(1) |
+----------+
|        8 |
+----------+
1 row in set (0.00 sec)

mysql> insert into goods_name
    -> values
    -> (3,'h皮衣')，
    -> （5,）\c
mysql> insert into goods_name
    -> values
    -> (3,'皮衣'),
    -> (8,'袜子');
Query OK, 2 rows affected (0.00 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> select * from goods_name;
+--------+----------+
| cat_id | cat_name |
+--------+----------+
|      3 | 小蓝海        |
|      3 | 中华香烟        |
|      3 | 华为手机       |
|      0 | 面粉         |
|      2 | 耳机         |
|      2 | 耳机         |
|     23 | 汽车         |
|      5 | 水杯        |
|      3 | 皮衣        |
|      8 | 袜子         |
+--------+----------+
10 rows in set (0.00 sec)

mysql> select goods_id,goods_name ,goods.cat_id,goods_name.cat_id,cat_name from goods.goods_name;
ERROR 1146 (42S02): Table 'goods.goods_name' doesn't exist
mysql> select goods_id,goods_name ,goods.cat_id,goods_name.cat_id,cat_name from goods,goods_name;
+----------+------------+--------+--------+----------+
| goods_id | goods_name | cat_id | cat_id | cat_name |
+----------+------------+--------+--------+----------+
|        1 | 小蓝海          |      3 |      3 | 小蓝海        |
|        2 | 中华香烟          |      3 |      3 | 小蓝海        |
|        3 | 华为手机         |      3 |      3 | 小蓝海        |
|        4 | 面粉           |      0 |      3 | 小蓝海        |
|        5 | 耳机           |      2 |      3 | 小蓝海        |
|        6 | 耳机           |      2 |      3 | 小蓝海        |
|       85 | 汽车           |     23 |      3 | 小蓝海        |
|       23 | 水杯          |      5 |      3 | 小蓝海        |
|        1 | 小蓝海          |      3 |      3 | 中华香烟        |
|        2 | 中华香烟          |      3 |      3 | 中华香烟        |
|        3 | 华为手机         |      3 |      3 | 中华香烟        |
|        4 | 面粉           |      0 |      3 | 中华香烟        |
|        5 | 耳机           |      2 |      3 | 中华香烟        |
|        6 | 耳机           |      2 |      3 | 中华香烟        |
|       85 | 汽车           |     23 |      3 | 中华香烟        |
|       23 | 水杯          |      5 |      3 | 中华香烟        |
|        1 | 小蓝海          |      3 |      3 | 华为手机       |
|        2 | 中华香烟          |      3 |      3 | 华为手机       |
|        3 | 华为手机         |      3 |      3 | 华为手机       |
|        4 | 面粉           |      0 |      3 | 华为手机       |
|        5 | 耳机           |      2 |      3 | 华为手机       |
|        6 | 耳机           |      2 |      3 | 华为手机       |
|       85 | 汽车           |     23 |      3 | 华为手机       |
|       23 | 水杯          |      5 |      3 | 华为手机       |
|        1 | 小蓝海          |      3 |      0 | 面粉         |
|        2 | 中华香烟          |      3 |      0 | 面粉         |
|        3 | 华为手机         |      3 |      0 | 面粉         |
|        4 | 面粉           |      0 |      0 | 面粉         |
|        5 | 耳机           |      2 |      0 | 面粉         |
|        6 | 耳机           |      2 |      0 | 面粉         |
|       85 | 汽车           |     23 |      0 | 面粉         |
|       23 | 水杯          |      5 |      0 | 面粉         |
|        1 | 小蓝海          |      3 |      2 | 耳机         |
|        2 | 中华香烟          |      3 |      2 | 耳机         |
|        3 | 华为手机         |      3 |      2 | 耳机         |
|        4 | 面粉           |      0 |      2 | 耳机         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|       85 | 汽车           |     23 |      2 | 耳机         |
|       23 | 水杯          |      5 |      2 | 耳机         |
|        1 | 小蓝海          |      3 |      2 | 耳机         |
|        2 | 中华香烟          |      3 |      2 | 耳机         |
|        3 | 华为手机         |      3 |      2 | 耳机         |
|        4 | 面粉           |      0 |      2 | 耳机         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|       85 | 汽车           |     23 |      2 | 耳机         |
|       23 | 水杯          |      5 |      2 | 耳机         |
|        1 | 小蓝海          |      3 |     23 | 汽车         |
|        2 | 中华香烟          |      3 |     23 | 汽车         |
|        3 | 华为手机         |      3 |     23 | 汽车         |
|        4 | 面粉           |      0 |     23 | 汽车         |
|        5 | 耳机           |      2 |     23 | 汽车         |
|        6 | 耳机           |      2 |     23 | 汽车         |
|       85 | 汽车           |     23 |     23 | 汽车         |
|       23 | 水杯          |      5 |     23 | 汽车         |
|        1 | 小蓝海          |      3 |      5 | 水杯        |
|        2 | 中华香烟          |      3 |      5 | 水杯        |
|        3 | 华为手机         |      3 |      5 | 水杯        |
|        4 | 面粉           |      0 |      5 | 水杯        |
|        5 | 耳机           |      2 |      5 | 水杯        |
|        6 | 耳机           |      2 |      5 | 水杯        |
|       85 | 汽车           |     23 |      5 | 水杯        |
|       23 | 水杯          |      5 |      5 | 水杯        |
|        1 | 小蓝海          |      3 |      3 | 皮衣        |
|        2 | 中华香烟          |      3 |      3 | 皮衣        |
|        3 | 华为手机         |      3 |      3 | 皮衣        |
|        4 | 面粉           |      0 |      3 | 皮衣        |
|        5 | 耳机           |      2 |      3 | 皮衣        |
|        6 | 耳机           |      2 |      3 | 皮衣        |
|       85 | 汽车           |     23 |      3 | 皮衣        |
|       23 | 水杯          |      5 |      3 | 皮衣        |
|        1 | 小蓝海          |      3 |      8 | 袜子         |
|        2 | 中华香烟          |      3 |      8 | 袜子         |
|        3 | 华为手机         |      3 |      8 | 袜子         |
|        4 | 面粉           |      0 |      8 | 袜子         |
|        5 | 耳机           |      2 |      8 | 袜子         |
|        6 | 耳机           |      2 |      8 | 袜子         |
|       85 | 汽车           |     23 |      8 | 袜子         |
|       23 | 水杯          |      5 |      8 | 袜子         |
+----------+------------+--------+--------+----------+
80 rows in set (0.00 sec)

mysql> select count(1) from goods;
+----------+
| count(1) |
+----------+
|        8 |
+----------+
1 row in set (0.00 sec)

mysql> select count(1) from goods_name;
+----------+
| count(1) |
+----------+
|       10 |
+----------+
1 row in set (0.00 sec)

mysql> select goods_id,goods_name ,goods.cat_id,goods_name.cat_id,cat_name from goods,goods_name where goods.cat_id=goods_name.cat_id;
+----------+------------+--------+--------+----------+
| goods_id | goods_name | cat_id | cat_id | cat_name |
+----------+------------+--------+--------+----------+
|        1 | 小蓝海          |      3 |      3 | 小蓝海        |
|        2 | 中华香烟          |      3 |      3 | 小蓝海        |
|        3 | 华为手机         |      3 |      3 | 小蓝海        |
|        1 | 小蓝海          |      3 |      3 | 中华香烟        |
|        2 | 中华香烟          |      3 |      3 | 中华香烟        |
|        3 | 华为手机         |      3 |      3 | 中华香烟        |
|        1 | 小蓝海          |      3 |      3 | 华为手机       |
|        2 | 中华香烟          |      3 |      3 | 华为手机       |
|        3 | 华为手机         |      3 |      3 | 华为手机       |
|        4 | 面粉           |      0 |      0 | 面粉         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|       85 | 汽车           |     23 |     23 | 汽车         |
|       23 | 水杯          |      5 |      5 | 水杯        |
|        1 | 小蓝海          |      3 |      3 | 皮衣        |
|        2 | 中华香烟          |      3 |      3 | 皮衣        |
|        3 | 华为手机         |      3 |      3 | 皮衣        |
+----------+------------+--------+--------+----------+
19 rows in set (0.00 sec)

mysql> select goods_id,goods_name,cat_id from goods;
+----------+------------+--------+
| goods_id | goods_name | cat_id |
+----------+------------+--------+
|        1 | 小蓝海          |      3 |
|        2 | 中华香烟          |      3 |
|        3 | 华为手机         |      3 |
|        4 | 面粉           |      0 |
|        5 | 耳机           |      2 |
|        6 | 耳机           |      2 |
|       85 | 汽车           |     23 |
|       23 | 水杯          |      5 |
+----------+------------+--------+
8 rows in set (0.00 sec)

mysql> select cat_id,cat_name from goods_name;
+--------+----------+
| cat_id | cat_name |
+--------+----------+
|      3 | 小蓝海        |
|      3 | 中华香烟        |
|      3 | 华为手机       |
|      0 | 面粉         |
|      2 | 耳机         |
|      2 | 耳机         |
|     23 | 汽车         |
|      5 | 水杯        |
|      3 | 皮衣        |
|      8 | 袜子         |
+--------+----------+
10 rows in set (0.00 sec)

mysql> select goods_id,goods_name ,goods.cat_id,goods_name.cat_id,cat_name from goods left join goods_name on goods.cat_id=goods_name.cat_id;
+----------+------------+--------+--------+----------+
| goods_id | goods_name | cat_id | cat_id | cat_name |
+----------+------------+--------+--------+----------+
|        1 | 小蓝海          |      3 |      3 | 小蓝海        |
|        1 | 小蓝海          |      3 |      3 | 中华香烟        |
|        1 | 小蓝海          |      3 |      3 | 华为手机       |
|        1 | 小蓝海          |      3 |      3 | 皮衣        |
|        2 | 中华香烟          |      3 |      3 | 小蓝海        |
|        2 | 中华香烟          |      3 |      3 | 中华香烟        |
|        2 | 中华香烟          |      3 |      3 | 华为手机       |
|        2 | 中华香烟          |      3 |      3 | 皮衣        |
|        3 | 华为手机         |      3 |      3 | 小蓝海        |
|        3 | 华为手机         |      3 |      3 | 中华香烟        |
|        3 | 华为手机         |      3 |      3 | 华为手机       |
|        3 | 华为手机         |      3 |      3 | 皮衣        |
|        4 | 面粉           |      0 |      0 | 面粉         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|       85 | 汽车           |     23 |     23 | 汽车         |
|       23 | 水杯          |      5 |      5 | 水杯        |
+----------+------------+--------+--------+----------+
19 rows in set (0.01 sec)

mysql> #效率比两个表全乘高。
mysql> select goods_id,goods_name ,goods.cat_id,goods_name.cat_id,cat_name from goods right join goods_name on goods.cat_id=goods_name.cat_id;
+----------+------------+--------+--------+----------+
| goods_id | goods_name | cat_id | cat_id | cat_name |
+----------+------------+--------+--------+----------+
|        1 | 小蓝海          |      3 |      3 | 小蓝海        |
|        2 | 中华香烟          |      3 |      3 | 小蓝海        |
|        3 | 华为手机         |      3 |      3 | 小蓝海        |
|        1 | 小蓝海          |      3 |      3 | 中华香烟        |
|        2 | 中华香烟          |      3 |      3 | 中华香烟        |
|        3 | 华为手机         |      3 |      3 | 中华香烟        |
|        1 | 小蓝海          |      3 |      3 | 华为手机       |
|        2 | 中华香烟          |      3 |      3 | 华为手机       |
|        3 | 华为手机         |      3 |      3 | 华为手机       |
|        4 | 面粉           |      0 |      0 | 面粉         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|       85 | 汽车           |     23 |     23 | 汽车         |
|       23 | 水杯          |      5 |      5 | 水杯        |
|        1 | 小蓝海          |      3 |      3 | 皮衣        |
|        2 | 中华香烟          |      3 |      3 | 皮衣        |
|        3 | 华为手机         |      3 |      3 | 皮衣        |
|     NULL | NULL       |   NULL |      8 | 袜子         |
+----------+------------+--------+--------+----------+
20 rows in set (0.00 sec)

mysql> select goods_id,goods_name ,goods.cat_id,goods_name.cat_id,cat_name from goods_name left join goods on goods.cat_id=goods_name.cat_id;
+----------+------------+--------+--------+----------+
| goods_id | goods_name | cat_id | cat_id | cat_name |
+----------+------------+--------+--------+----------+
|        1 | 小蓝海          |      3 |      3 | 小蓝海        |
|        2 | 中华香烟          |      3 |      3 | 小蓝海        |
|        3 | 华为手机         |      3 |      3 | 小蓝海        |
|        1 | 小蓝海          |      3 |      3 | 中华香烟        |
|        2 | 中华香烟          |      3 |      3 | 中华香烟        |
|        3 | 华为手机         |      3 |      3 | 中华香烟        |
|        1 | 小蓝海          |      3 |      3 | 华为手机       |
|        2 | 中华香烟          |      3 |      3 | 华为手机       |
|        3 | 华为手机         |      3 |      3 | 华为手机       |
|        4 | 面粉           |      0 |      0 | 面粉         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|       85 | 汽车           |     23 |     23 | 汽车         |
|       23 | 水杯          |      5 |      5 | 水杯        |
|        1 | 小蓝海          |      3 |      3 | 皮衣        |
|        2 | 中华香烟          |      3 |      3 | 皮衣        |
|        3 | 华为手机         |      3 |      3 | 皮衣        |
|     NULL | NULL       |   NULL |      8 | 袜子         |
+----------+------------+--------+--------+----------+
20 rows in set (0.00 sec)

mysql> select goods_id,goods_name ,goods.cat_id,goods_name.cat_id,cat_name from goods right join goods_name on goods.cat_id=goods_name.cat_id;
+----------+------------+--------+--------+----------+
| goods_id | goods_name | cat_id | cat_id | cat_name |
+----------+------------+--------+--------+----------+
|        1 | 小蓝海          |      3 |      3 | 小蓝海        |
|        2 | 中华香烟          |      3 |      3 | 小蓝海        |
|        3 | 华为手机         |      3 |      3 | 小蓝海        |
|        1 | 小蓝海          |      3 |      3 | 中华香烟        |
|        2 | 中华香烟          |      3 |      3 | 中华香烟        |
|        3 | 华为手机         |      3 |      3 | 中华香烟        |
|        1 | 小蓝海          |      3 |      3 | 华为手机       |
|        2 | 中华香烟          |      3 |      3 | 华为手机       |
|        3 | 华为手机         |      3 |      3 | 华为手机       |
|        4 | 面粉           |      0 |      0 | 面粉         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|       85 | 汽车           |     23 |     23 | 汽车         |
|       23 | 水杯          |      5 |      5 | 水杯        |
|        1 | 小蓝海          |      3 |      3 | 皮衣        |
|        2 | 中华香烟          |      3 |      3 | 皮衣        |
|        3 | 华为手机         |      3 |      3 | 皮衣        |
|     NULL | NULL       |   NULL |      8 | 袜子         |
+----------+------------+--------+--------+----------+
20 rows in set (0.00 sec)

mysql> select goods_id,goods_name ,goods.cat_id,goods_name.cat_id,cat_name from goods_name right join goods on goods.cat_id=goods_name.cat_id;
+----------+------------+--------+--------+----------+
| goods_id | goods_name | cat_id | cat_id | cat_name |
+----------+------------+--------+--------+----------+
|        1 | 小蓝海          |      3 |      3 | 小蓝海        |
|        1 | 小蓝海          |      3 |      3 | 中华香烟        |
|        1 | 小蓝海          |      3 |      3 | 华为手机       |
|        1 | 小蓝海          |      3 |      3 | 皮衣        |
|        2 | 中华香烟          |      3 |      3 | 小蓝海        |
|        2 | 中华香烟          |      3 |      3 | 中华香烟        |
|        2 | 中华香烟          |      3 |      3 | 华为手机       |
|        2 | 中华香烟          |      3 |      3 | 皮衣        |
|        3 | 华为手机         |      3 |      3 | 小蓝海        |
|        3 | 华为手机         |      3 |      3 | 中华香烟        |
|        3 | 华为手机         |      3 |      3 | 华为手机       |
|        3 | 华为手机         |      3 |      3 | 皮衣        |
|        4 | 面粉           |      0 |      0 | 面粉         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|       85 | 汽车           |     23 |     23 | 汽车         |
|       23 | 水杯          |      5 |      5 | 水杯        |
+----------+------------+--------+--------+----------+
19 rows in set (0.00 sec)

mysql> select goods_id,goods_name ,goods.cat_id,goods_name.cat_id,cat_name from goods_name inner join goods on goods.cat_id=goods_name.cat_id;
+----------+------------+--------+--------+----------+
| goods_id | goods_name | cat_id | cat_id | cat_name |
+----------+------------+--------+--------+----------+
|        1 | 小蓝海          |      3 |      3 | 小蓝海        |
|        2 | 中华香烟          |      3 |      3 | 小蓝海        |
|        3 | 华为手机         |      3 |      3 | 小蓝海        |
|        1 | 小蓝海          |      3 |      3 | 中华香烟        |
|        2 | 中华香烟          |      3 |      3 | 中华香烟        |
|        3 | 华为手机         |      3 |      3 | 中华香烟        |
|        1 | 小蓝海          |      3 |      3 | 华为手机       |
|        2 | 中华香烟          |      3 |      3 | 华为手机       |
|        3 | 华为手机         |      3 |      3 | 华为手机       |
|        4 | 面粉           |      0 |      0 | 面粉         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|       85 | 汽车           |     23 |     23 | 汽车         |
|       23 | 水杯          |      5 |      5 | 水杯        |
|        1 | 小蓝海          |      3 |      3 | 皮衣        |
|        2 | 中华香烟          |      3 |      3 | 皮衣        |
|        3 | 华为手机         |      3 |      3 | 皮衣        |
+----------+------------+--------+--------+----------+
19 rows in set (0.00 sec)

mysql> select goods_id,goods_name ,goods.cat_id,goods_name.cat_id,cat_name from goods inner join goods_name on goods.cat_id=goods_name.cat_id;
+----------+------------+--------+--------+----------+
| goods_id | goods_name | cat_id | cat_id | cat_name |
+----------+------------+--------+--------+----------+
|        1 | 小蓝海          |      3 |      3 | 小蓝海        |
|        2 | 中华香烟          |      3 |      3 | 小蓝海        |
|        3 | 华为手机         |      3 |      3 | 小蓝海        |
|        1 | 小蓝海          |      3 |      3 | 中华香烟        |
|        2 | 中华香烟          |      3 |      3 | 中华香烟        |
|        3 | 华为手机         |      3 |      3 | 中华香烟        |
|        1 | 小蓝海          |      3 |      3 | 华为手机       |
|        2 | 中华香烟          |      3 |      3 | 华为手机       |
|        3 | 华为手机         |      3 |      3 | 华为手机       |
|        4 | 面粉           |      0 |      0 | 面粉         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|        5 | 耳机           |      2 |      2 | 耳机         |
|        6 | 耳机           |      2 |      2 | 耳机         |
|       85 | 汽车           |     23 |     23 | 汽车         |
|       23 | 水杯          |      5 |      5 | 水杯        |
|        1 | 小蓝海          |      3 |      3 | 皮衣        |
|        2 | 中华香烟          |      3 |      3 | 皮衣        |
|        3 | 华为手机         |      3 |      3 | 皮衣        |
+----------+------------+--------+--------+----------+
19 rows in set (0.00 sec)

mysql> create table m(
    -> mid int;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 2
mysql> 
mysql> create table m(
    -> mid int,
    -> hid int,
    -> gid int,
    -> result varchar(10),
    -> matime date)
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.02 sec)

mysql> insert into m
    -> values
    -> (1,1,2,'2:0','2006-05--21'),
    -> (2,2,3,'1:2','2006-06--21'),
    -> (3,3,1,'2:5','2006-06--25'),
    -> (4,2,1,'3:2','2006-07--21'),
    -> ;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 6
mysql> insert into m
    -> values
    -> (1,1,2,'2:0','2006-05--21'),
    -> (2,2,3,'1:2','2006-06--21'),
    -> (3,3,1,'2:5','2006-06--25'),
    -> (4,2,1,'3:2','2006-07--21');
Query OK, 4 rows affected (0.00 sec)
Records: 4  Duplicates: 0  Warnings: 0

mysql> create table t(
    -> tid int,
    -> tname varchar(20))
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.01 sec)

mysql> insert into t
    -> values
    -> (1,'国安'),
    -> (2,'申花'),
    -> (3,'公益联队);
    '> ->
    '> ;
    '> '
    -> 
    -> \c
mysql> insert into t
    -> values
    -> (1,'国安'),
    -> (2,'申花'),
    -> (3,'公益联队);
    '> '
    -> ;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 5
mysql> insert into t
    -> (1,'国安'),
    -> (2,'申花'),
    -> (3,'公益联队');
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '1,'国安'),
(2,'申花'),
(3,'公益联队')' at line 2
mysql> insert into t
    -> values
    -> (1,'国安'),
    -> (2,'申花'),
    -> (3,'公益联队');
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> select * from m;
+------+------+------+--------+------------+
| mid  | hid  | gid  | result | matime     |
+------+------+------+--------+------------+
|    1 |    1 |    2 | 2:0    | 2006-05-21 |
|    2 |    2 |    3 | 1:2    | 2006-06-21 |
|    3 |    3 |    1 | 2:5    | 2006-06-25 |
|    4 |    2 |    1 | 3:2    | 2006-07-21 |
+------+------+------+--------+------------+
4 rows in set (0.01 sec)

mysql> select * from t;
+------+----------+
| tid  | tname    |
+------+----------+
|    1 | 国安         |
|    2 | 申花       |
|    3 | 公益联队         |
+------+----------+
3 rows in set (0.00 sec)

mysql> select hid result gid matime from m;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'gid matime from m' at line 1
mysql> select hid, result ,gid ,matime from m;
+------+--------+------+------------+
| hid  | result | gid  | matime     |
+------+--------+------+------------+
|    1 | 2:0    |    2 | 2006-05-21 |
|    2 | 1:2    |    3 | 2006-06-21 |
|    3 | 2:5    |    1 | 2006-06-25 |
|    2 | 3:2    |    1 | 2006-07-21 |
+------+--------+------+------------+
4 rows in set (0.00 sec)

mysql> select hid,tname, result ,gid ,matime from m left join t on hid=tid;
+------+----------+--------+------+------------+
| hid  | tname    | result | gid  | matime     |
+------+----------+--------+------+------------+
|    1 | 国安         | 2:0    |    2 | 2006-05-21 |
|    2 | 申花       | 1:2    |    3 | 2006-06-21 |
|    3 | 公益联队         | 2:5    |    1 | 2006-06-25 |
|    2 | 申花       | 3:2    |    1 | 2006-07-21 |
+------+----------+--------+------+------------+
4 rows in set (0.00 sec)

mysql> select tname, result ,gid ,matime from m left join t on hid=tid;
+----------+--------+------+------------+
| tname    | result | gid  | matime     |
+----------+--------+------+------------+
| 国安         | 2:0    |    2 | 2006-05-21 |
| 申花       | 1:2    |    3 | 2006-06-21 |
| 公益联队         | 2:5    |    1 | 2006-06-25 |
| 申花       | 3:2    |    1 | 2006-07-21 |
+----------+--------+------+------------+
4 rows in set (0.00 sec)

mysql> select tname ,result, tname,matime from (select tname, result ,gid ,matime from m left join t on hid=tid) left join t on gid =tid;
ERROR 1248 (42000): Every derived table must have its own alias
mysql> select tname ,result, tname,matime from (select tname, result ,gid ,matime from m left join t on hid=tid) as tem left join t on gid =tid;
ERROR 1052 (23000): Column 'tname' in field list is ambiguous
mysql> select tem.tname ,result,t.tname,matime from (select tname, result ,gid ,matime from m left join t on hid=tid) as tem left join t on gid =tid;
+----------+--------+----------+------------+
| tname    | result | tname    | matime     |
+----------+--------+----------+------------+
| 国安         | 2:0    | 申花       | 2006-05-21 |
| 申花       | 1:2    | 公益联队         | 2006-06-21 |
| 公益联队         | 2:5    | 国安         | 2006-06-25 |
| 申花       | 3:2    | 国安         | 2006-07-21 |
+----------+--------+----------+------------+
4 rows in set (0.00 sec)

