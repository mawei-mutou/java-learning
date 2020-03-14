mysql> set names gbk;
Query OK, 0 rows affected (0.00 sec)

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
8 rows in set (0.09 sec)

mysql> #要求：取出价格<30和>4000的商品，但是不能使用or.
mysql> #先取出价格<30的商品，再取出>4000的商品
mysql> select goods_id,goods_name,shop_price from goods where shop_price <30;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|        4 | 面粉           |      20.60 |
|       23 | 水杯          |      26.00 |
+----------+------------+------------+
2 rows in set (0.00 sec)

mysql> select goods_id,goods_name,shop_price from goods where shop_price >4000;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|       85 | 汽车           |  330000.00 |
+----------+------------+------------+
1 row in set (0.00 sec)

mysql> #2个语句的结果拼接起来就可以了，用union合并连接。
mysql> select goods_id,goods_name,shop_price from goods where shop_price >4000
    -> union 
    -> select goods_id,goods_name,shop_price from goods where shop_price <30;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|       85 | 汽车           |  330000.00 |
|        4 | 面粉           |      20.60 |
|       23 | 水杯          |      26.00 |
+----------+------------+------------+
3 rows in set (0.02 sec)

mysql> #问题：如果两个表的列数不一样或者名字不一样，是否能合并，怎么样合并
mysql> select goods_id,shop_price from goods where shop_price <30
    -> union
    -> select goods_id,goods_name,shop_price from goods where shop_price >4000;
ERROR 1222 (21000): The used SELECT statements have a different number of columns
mysql> #答案 是不能合并
mysql> select goods_id,goods_name,shop_price from goods where shop_price <30
    -> union
    -> select goods_id,goods,shop_price from goods where shop_price >4000;
ERROR 1054 (42S22): Unknown column 'goods' in 'field list'
mysql> select goods_id,goods_name,shop_price from goods where shop_price <30
    -> union
    -> select goods_id,goods_name as ppp,shop_price from goods where shop_price >4000;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|        4 | 面粉           |      20.60 |
|       23 | 水杯          |      26.00 |
|       85 | 汽车           |  330000.00 |
+----------+------------+------------+
3 rows in set (0.00 sec)

mysql> select goods_id,goods_name,shop_price from goods where shop_price <30
    -> union
    -> select goods_id,goods_id,shop_price from goods where shop_price >4000;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|        4 | 面粉           |      20.60 |
|       23 | 水杯          |      26.00 |
|       85 | 85         |  330000.00 |
+----------+------------+------------+
3 rows in set (0.00 sec)

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

mysql> select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 2
    -> union
    -> select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 5
    -> order by shop_price;
+------------+----------+------------+--------+
| goods_name | goods_id | shop_price | cat_id |
+------------+----------+------------+--------+
| 水杯          |       23 |      26.00 |      5 |
| 耳机           |        6 |      56.00 |      2 |
| 耳机           |        5 |     420.50 |      2 |
+------------+----------+------------+--------+
3 rows in set (0.01 sec)

mysql> select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 2
    -> union
    -> select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 5
    -> where goods_id =6;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'where goods_id =6' at line 4
mysql> (select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 5
    -> \c
mysql> select goods_name,goods_id,shop_price,cat_id from ()
    -> select goods_name,goods_id,shop_price,cat_id from ()\c
mysql> select goods_name,goods_id,shop_price,cat_id from (
    -> select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 2
    -> union
    -> select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 5)
    -> as temp where id =6;
ERROR 1054 (42S22): Unknown column 'id' in 'where clause'
mysql> select goods_name,goods_id,shop_price,cat_id from (
    -> select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 2
    -> union
    -> select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 5
    -> order by shop_price) as temp 
    -> where cat_id =6;
Empty set (0.00 sec)

mysql> select goods_name,goods_id,shop_price,cat_id from (
    -> select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 2
    -> union
    -> select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 5
    -> order by shop_price) as temp 
    -> where cat_id =2;
+------------+----------+------------+--------+
| goods_name | goods_id | shop_price | cat_id |
+------------+----------+------------+--------+
| 耳机           |        6 |      56.00 |      2 |
| 耳机           |        5 |     420.50 |      2 |
+------------+----------+------------+--------+
2 rows in set (0.00 sec)

mysql> (select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 2 order by shop_price)
    ->      union
    ->      (select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 5 order by shop_price)
    ->    order by shop_price;
+------------+----------+------------+--------+
| goods_name | goods_id | shop_price | cat_id |
+------------+----------+------------+--------+
| 水杯          |       23 |      26.00 |      5 |
| 耳机           |        6 |      56.00 |      2 |
| 耳机           |        5 |     420.50 |      2 |
+------------+----------+------------+--------+
3 rows in set (0.00 sec)

mysql>   (select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 2 order by shop_price)
    ->      union
    ->      (select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 5 order by shop_price);
+------------+----------+------------+--------+
| goods_name | goods_id | shop_price | cat_id |
+------------+----------+------------+--------+
| 耳机           |        5 |     420.50 |      2 |
| 耳机           |        6 |      56.00 |      2 |
| 水杯          |       23 |      26.00 |      5 |
+------------+----------+------------+--------+
3 rows in set (0.00 sec)

mysql>   (select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 2 order by shop_price)
    ->      union
    ->      union\c
mysql>   (select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 2 order by shop_price)
    ->      union
    ->      (select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 3 order by shop_price)
    -> ;
+------------+----------+------------+--------+
| goods_name | goods_id | shop_price | cat_id |
+------------+----------+------------+--------+
| 耳机           |        5 |     420.50 |      2 |
| 耳机           |        6 |      56.00 |      2 |
| 小蓝海          |        1 |      77.35 |      3 |
| 中华香烟          |        2 |      77.35 |      3 |
| 华为手机         |        3 |    3800.00 |      3 |
+------------+----------+------------+--------+
5 rows in set (0.00 sec)

mysql> #a查出第s3个栏目下价格前三的商品和第4个栏目价格前2的商品，用union完成
mysql>      (select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 3 order by shop_price\c
mysql>      (select goods_name,goods_id,shop_price,cat_id from goods where cat_id = 3 order by shop_price\c
mysql> select goods_name,goods_id,shop_price,cat_id from  (
    -> select goods_name,goods_id,shop_price,cat_id from goods where cat_id =3 order by shop_price limit 3
    -> union
    -> select goods_name,goods_id,shop_price,cat_id from goods where cat_id =2 order by shop_price limit 2) as temp;
ERROR 1221 (HY000): Incorrect usage of UNION and ORDER BY
mysql> select goods_id,cst_id,goods_name,sho_price
    -> from goods
    -> where cat_id=3 order by shop_price desc limit 3;
ERROR 1054 (42S22): Unknown column 'cst_id' in 'field list'
mysql> select goods_id,cat_id,goods_name,sho_price
    -> from goods
    -> where cat_id=3 order by shop_price desc limit 3;
ERROR 1054 (42S22): Unknown column 'sho_price' in 'field list'
mysql> select goods_id,cat_id,goods_name,shop_price
    -> from goods
    -> where cat_id=3 order by shop_price desc limit 3;
+----------+--------+------------+------------+
| goods_id | cat_id | goods_name | shop_price |
+----------+--------+------------+------------+
|        3 |      3 | 华为手机         |    3800.00 |
|        1 |      3 | 小蓝海          |      77.35 |
|        2 |      3 | 中华香烟          |      77.35 |
+----------+--------+------------+------------+
3 rows in set (0.00 sec)

mysql> select goods_id,cat_id,goods_name,shop_price
    -> from goods
    -> where cat_id=2 order by shop_price desc limit 2;
+----------+--------+------------+------------+
| goods_id | cat_id | goods_name | shop_price |
+----------+--------+------------+------------+
|        5 |      2 | 耳机           |     420.50 |
|        6 |      2 | 耳机           |      56.00 |
+----------+--------+------------+------------+
2 rows in set (0.00 sec)

mysql> 
mysql> （select goods_id,cat_id,goods_name,shop_price
    ->     from goods
    ->    where cat_id=3 order by shop_price desc limit 3）
    -> union
    -> (select goods_id,cat_id,goods_name,shop_price
    ->    from goods
    ->    where cat_id=2 order by shop_price desc limit 2);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '（select goods_id,cat_id,goods_name,shop_price
    from goods
   where cat_id=3' at line 1
mysql> 
mysql> （select goods_id,cat_id,goods_name,shop_price
    ->     from goods
    ->    where cat_id=3 order by shop_price desc limit 3）
    -> union
    -> (select goods_id,cat_id,goods_name,shop_price
    ->    from goods
    ->    where cat_id=2 order by shop_price desc limit 2);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '（select goods_id,cat_id,goods_name,shop_price
    from goods
   where cat_id=3' at line 1
mysql> (select goods_id,cat_id,goods_name,shop_price
    ->     from goods
    ->    where cat_id=3 order by shop_price desc limit 3)
    -> union
    -> (select goods_id,cat_id,goods_name,shop_price
    ->    from goods
    ->    where cat_id=2 order by shop_price desc limit 2);
+----------+--------+------------+------------+
| goods_id | cat_id | goods_name | shop_price |
+----------+--------+------------+------------+
|        3 |      3 | 华为手机         |    3800.00 |
|        1 |      3 | 小蓝海          |      77.35 |
|        2 |      3 | 中华香烟          |      77.35 |
|        5 |      2 | 耳机           |     420.50 |
|        6 |      2 | 耳机           |      56.00 |
+----------+--------+------------+------------+
5 rows in set (0.00 sec)

mysql> create table a (
    -> sname char(10)
    -> )engine myisam charset utf8;
Query OK, 0 rows affected (0.04 sec)

mysql> insert into a 
    -> values
    -> ('a','b','c');
ERROR 1136 (21S01): Column count doesn't match value count at row 1
mysql> desc a;
+-------+----------+------+-----+---------+-------+
| Field | Type     | Null | Key | Default | Extra |
+-------+----------+------+-----+---------+-------+
| sname | char(10) | YES  |     | NULL    |       |
+-------+----------+------+-----+---------+-------+
1 row in set (0.04 sec)

mysql> drop table a;
Query OK, 0 rows affected (0.00 sec)

mysql> show tables;
+----------------------+
| Tables_in_huxiaoyang |
+----------------------+
| class                |
| goods                |
| goods_name           |
| m                    |
| m1                   |
| menber               |
| nums                 |
| score                |
| t                    |
| test                 |
| test11               |
| test3                |
| test4                |
| test5                |
| test6                |
+----------------------+
15 rows in set (0.13 sec)

mysql> create table test7(
    -> sname char(1)
    -> )engine myisam charset utf8;
Query OK, 0 rows affected (0.02 sec)

mysql> insert into test7
    -> values
    -> ('a'),('b'),('c');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> create table test8
    -> (sname char(1))
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.03 sec)

mysql> insert into test8
    -> values
    -> ('b'),('c'),('d');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> select * from test7 
    -> union 
    -> select * from test8;
+-------+
| sname |
+-------+
| a     |
| b     |
| c     |
| d     |
+-------+
4 rows in set (0.00 sec)

mysql> select * from test7 
    -> union 
    -> select * from test8;\c
+-------+
| sname |
+-------+
| a     |
| b     |
| c     |
| d     |
+-------+
4 rows in set (0.00 sec)

mysql> select * from test7 
    -> union all
    -> select * from test8;
+-------+
| sname |
+-------+
| a     |
| b     |
| c     |
| b     |
| c     |
| d     |
+-------+
6 rows in set (0.00 sec)

mysql> create table 1
    -> (num tinyint(1))
    -> engine myisam charset utf8;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '1
(num tinyint(1))
engine myisam charset utf8' at line 1
mysql> create table 1
    -> (num tinyint(1))\c
mysql> create table one
    -> (num tinyint)
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.02 sec)

mysql> insert into one
    -> values
    -> (8,7,6);
ERROR 1136 (21S01): Column count doesn't match value count at row 1
mysql> insert into one
    -> values
    -> (8),(1),(9);
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> create table two
    -> (num tinyint(2))
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.03 sec)

mysql> insert into two
    -> values
    -> (7),(8),(9);
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> select * from one
    -> union
    -> select * from two;
+------+
| num  |
+------+
|    8 |
|    1 |
|    9 |
|    7 |
+------+
4 rows in set (0.00 sec)

mysql> select * from one
    -> union all
    -> select * from two;
+------+
| num  |
+------+
|    8 |
|    1 |
|    9 |
|    7 |
|    8 |
|    9 |
+------+
6 rows in set (0.00 sec)

mysql> select * from ont left join tow;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 1
mysql> select * from ont left join two;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 1
mysql> select * from oet left join two;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 1
mysql> select * from one left join two;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 1
mysql> select num from one left join two;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 1
mysql> drop table one,two;
Query OK, 0 rows affected (0.00 sec)

mysql> create table one(
    -> id int ,
    -> num tinyint(1))
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.03 sec)

mysql> insert into one(
    -> \c
mysql> 
mysql> insert into one
    -> values
    -> (1,2),\c
mysql> drop table one;
Query OK, 0 rows affected (0.00 sec)

mysql> create table one (
    -> name char(1) ,
    -> num tiny(1))
    -> engine myisam charset utf8;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'tiny(1))
engine myisam charset utf8' at line 3
mysql> create table one (
    -> name char(1),
    -> num tiny(1))
    -> engine myisam charset utf8;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'tiny(1))
engine myisam charset utf8' at line 3
mysql> create table one (
    -> num tinyint(1))
    -> name char(1),
    -> \c
mysql> create table one (
    -> name char(1),
    -> num tinyint(1))
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.03 sec)

mysql> insert into one 
    -> values
    -> ('a',1),('b',3),('c',8);
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> create table two(
    -> name char(1),
    -> num tinyint(1))
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.03 sec)

mysql> insert into two
    -> values
    -> ('b',5),('c',25),('d',23);
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> select name,(one.num+two.num) as nums from one,two where one.num=two.num;
ERROR 1052 (23000): Column 'name' in field list is ambiguous
mysql> select one.name,(one.num+two.num) as nums from one,two where one.name=two.name;
+------+------+
| name | nums |
+------+------+
| b    |    8 |
| c    |   33 |
+------+------+
2 rows in set (0.00 sec)

mysql> select * from one
    -> union
    -> select * from two;
+------+------+
| name | num  |
+------+------+
| a    |    1 |
| b    |    3 |
| c    |    8 |
| b    |    5 |
| c    |   25 |
| d    |   23 |
+------+------+
6 rows in set (0.00 sec)

mysql> select one.name,one.num,two.name as tname,two.num as tnum from one left join two on one.name=two.name;
+------+------+-------+------+
| name | num  | tname | tnum |
+------+------+-------+------+
| a    |    1 | NULL  | NULL |
| b    |    3 | b     |    5 |
| c    |    8 | c     |   25 |
+------+------+-------+------+
3 rows in set (0.00 sec)

mysql> select one.name,one.num,two.name as tname,two.num as tnum fromtwo left join one on one.name=two.name;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'fromtwo left join one on one.name=two.name' at line 1
mysql> select one.name,one.num,two.name as tname,two.num as tnum from two left join one on one.name=two.name;
+------+------+-------+------+
| name | num  | tname | tnum |
+------+------+-------+------+
| b    |    3 | b     |    5 |
| c    |    8 | c     |   25 |
| NULL | NULL | d     |   23 |
+------+------+-------+------+
3 rows in set (0.00 sec)

mysql> select one.name,(one.num+two.num)as nums from one left join two on one.name=two.name;
+------+------+
| name | nums |
+------+------+
| a    | NULL |
| b    |    8 |
| c    |   33 |
+------+------+
3 rows in set (0.00 sec)

mysql> select one.name,(one.num+two.num) as nums from two left join one on one.name=two.name;
+------+------+
| name | nums |
+------+------+
| b    |    8 |
| c    |   33 |
| NULL | NULL |
+------+------+
3 rows in set (0.00 sec)

mysql> select two.name,(one.num+two.num) as nums from two left join one on one.name=two.name;
+------+------+
| name | nums |
+------+------+
| b    |    8 |
| c    |   33 |
| d    | NULL |
+------+------+
3 rows in set (0.00 sec)

mysql> select one.name,(one.num+two.num)as nums from one left join two on one.name=two.name
    -> union
    -> select two.name,(one.num+two.num) as nums from two left join one on one.name=two.name;
+------+------+
| name | nums |
+------+------+
| a    | NULL |
| b    |    8 |
| c    |   33 |
| d    | NULL |
+------+------+
4 rows in set (0.02 sec)

mysql> select * from one 
    -> union
    -> select * from two;
+------+------+
| name | num  |
+------+------+
| a    |    1 |
| b    |    3 |
| c    |    8 |
| b    |    5 |
| c    |   25 |
| d    |   23 |
+------+------+
6 rows in set (0.00 sec)

mysql> select name,sum(num) group by name;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'group by name' at line 1
mysql> select name,sum(num)from(select * from one union select * from two) as tem group by name;
+------+----------+
| name | sum(num) |
+------+----------+
| a    |        1 |
| b    |        8 |
| c    |       33 |
| d    |       23 |
+------+----------+
4 rows in set (0.01 sec)

mysql> select * from one;
+------+------+
| name | num  |
+------+------+
| a    |    1 |
| b    |    3 |
| c    |    8 |
+------+------+
3 rows in set (0.00 sec)

mysql> select * from two;
+------+------+
| name | num  |
+------+------+
| b    |    5 |
| c    |   25 |
| d    |   23 |
+------+------+
3 rows in set (0.00 sec)

mysql> log(2,8);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'log(2,8)' at line 1
mysql> log(8,2);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'log(8,2)' at line 1
mysql> select log(8,2);
+---------------------+
| log(8,2)            |
+---------------------+
| 0.33333333333333337 |
+---------------------+
1 row in set (0.00 sec)

mysql> select log(2,8);
+----------+
| log(2,8) |
+----------+
|        3 |
+----------+
1 row in set (0.00 sec)

mysql> select mod(99,10);
+------------+
| mod(99,10) |
+------------+
|          9 |
+------------+
1 row in set (0.00 sec)

mysql> select 99%10;
+-------+
| 99%10 |
+-------+
|     9 |
+-------+
1 row in set (0.00 sec)

mysql> select round(5/3,3);
+--------------+
| round(5/3,3) |
+--------------+
|        1.667 |
+--------------+
1 row in set (0.00 sec)

mysql> select pow(2,3);
+----------+
| pow(2,3) |
+----------+
|        8 |
+----------+
1 row in set (0.00 sec)

mysql> s
    -> \c
mysql> select group_concat(goods_name) from goods;
+---------------------------------------------------+
| group_concat(goods_name)                          |
+---------------------------------------------------+
| 小蓝海,中华香烟,华为手机,面粉,耳机,耳机,汽车,水杯                                      |
+---------------------------------------------------+
1 row in set (0.02 sec)

mysql> select reverse('huxiaoyang');
+-----------------------+
| reverse('huxiaoyang') |
+-----------------------+
| gnayoaixuh            |
+-----------------------+
1 row in set (0.00 sec)

mysql> select curtime();
+-----------+
| curtime() |
+-----------+
| 14:58:58  |
+-----------+
1 row in set (0.00 sec)

mysql> select curtime().curdate().now();
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '.curdate().now()' at line 1
mysql> select curtime(),curdate(),now();
+-----------+------------+---------------------+
| curtime() | curdate()  | now()               |
+-----------+------------+---------------------+
| 14:59:24  | 2020-03-12 | 2020-03-12 14:59:24 |
+-----------+------------+---------------------+
1 row in set (0.00 sec)

mysql> select dat_format(now(),'YYYY:MM:DD');
ERROR 1305 (42000): FUNCTION huxiaoyang.dat_format does not exist
mysql> select date_format(now(),'YYYY:MM:DD');
+---------------------------------+
| date_format(now(),'YYYY:MM:DD') |
+---------------------------------+
| YYYY:MM:DD                      |
+---------------------------------+
1 row in set (0.00 sec)

mysql> exit;
