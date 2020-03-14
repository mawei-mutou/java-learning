mysql> set names gbk;
Query OK, 0 rows affected (0.00 sec)

mysql> select * from gbk;
ERROR 1146 (42S02): Table 'huxiaoyang.gbk' doesn't exist
mysql> select * from goods;
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
| goods_id | cat_id | goods_sn | goods_name | click_count | goods_number | market_price | shop_price | add_time | is_best | is_new | is_hot |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
|        1 |      3 |          | 小蓝海          |           0 |            2 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        2 |      3 |          | 中华香烟          |           0 |           26 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        3 |      3 |          | 华为手机         |           0 |            6 |      6200.00 |    3800.00 |        0 |       0 |      0 |      0 |
|        4 |      0 |          | 面粉           |           0 |          855 |        26.30 |      20.60 |        0 |       0 |      0 |      0 |
|        5 |      2 |          | 耳机           |           0 |           85 |       500.65 |     100.00 |        0 |       0 |      0 |      0 |
|        6 |      2 |          | 耳机           |           0 |           75 |         0.00 |      56.00 |        0 |       0 |      0 |      0 |
|       85 |     23 |          | 汽车           |           0 |            0 |    360000.00 |  330000.00 |        0 |       0 |      0 |      0 |
|       23 |      5 |          | 水杯          |           0 |            0 |        30.00 |      26.00 |        0 |       0 |      0 |      0 |
|       86 |      0 |          | ????       |           0 |            0 |         0.00 |    5800.00 |        0 |       0 |      0 |      0 |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
9 rows in set (0.00 sec)

mysql> update goods set goods_name='笔记本' where goods_id=86;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select *  from goods;
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
| goods_id | cat_id | goods_sn | goods_name | click_count | goods_number | market_price | shop_price | add_time | is_best | is_new | is_hot |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
|        1 |      3 |          | 小蓝海          |           0 |            2 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        2 |      3 |          | 中华香烟          |           0 |           26 |        36.41 |      77.35 |        0 |       0 |      0 |      0 |
|        3 |      3 |          | 华为手机         |           0 |            6 |      6200.00 |    3800.00 |        0 |       0 |      0 |      0 |
|        4 |      0 |          | 面粉           |           0 |          855 |        26.30 |      20.60 |        0 |       0 |      0 |      0 |
|        5 |      2 |          | 耳机           |           0 |           85 |       500.65 |     100.00 |        0 |       0 |      0 |      0 |
|        6 |      2 |          | 耳机           |           0 |           75 |         0.00 |      56.00 |        0 |       0 |      0 |      0 |
|       85 |     23 |          | 汽车           |           0 |            0 |    360000.00 |  330000.00 |        0 |       0 |      0 |      0 |
|       23 |      5 |          | 水杯          |           0 |            0 |        30.00 |      26.00 |        0 |       0 |      0 |      0 |
|       86 |      0 |          | 笔记本         |           0 |            0 |         0.00 |    5800.00 |        0 |       0 |      0 |      0 |
+----------+--------+----------+------------+-------------+--------------+--------------+------------+----------+---------+--------+--------+
9 rows in set (0.00 sec)

mysql> create table test10
    -> (name varchar(10) ,)
    -> \c
mysql> create table test10
    -> (name varchar(10) ,
    -> money smallint(10))
    -> engine myisam charset utf8;
Query OK, 0 rows affected (0.04 sec)

mysql> create table test11
    -> (name varchar(10) ,
    -> money smallint(10))
    -> engine innodb charset utf8;
ERROR 1050 (42S01): Table 'test11' already exists
mysql> create table test11
    -> (name varchar(10) ,
    -> money smallint(10))
    -> engine innodb charset utf8;
ERROR 1050 (42S01): Table 'test11' already exists
mysql> create table test11
    -> \c
mysql> create table test12
    -> (name varchar(10) ,
    -> money smallint(10))
    -> engine innodb charset utf8;
Query OK, 0 rows affected (0.03 sec)

mysql> insert into test 10
    -> values
    -> ('张三',3000),
    -> ('李四',4000);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '10
values
('张三',3000),
('李四',4000)' at line 1
mysql> insert into test10
    -> ('张三',3000),
    -> ('李四',4000);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ''张三',3000),
('李四',4000)' at line 2
mysql> desc test10;
+-------+--------------+------+-----+---------+-------+
| Field | Type         | Null | Key | Default | Extra |
+-------+--------------+------+-----+---------+-------+
| name  | varchar(10)  | YES  |     | NULL    |       |
| money | smallint(10) | YES  |     | NULL    |       |
+-------+--------------+------+-----+---------+-------+
2 rows in set (0.03 sec)

mysql> insert into test10
    -> values
    -> ('张三',3000),
    -> ('李四',4000);
Query OK, 2 rows affected (0.00 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> insert into test12
    -> ('张三',3000),
    -> \c
mysql> insert into test12
    -> values
    -> ('张三',3000),
    -> ('李四',4000);
Query OK, 2 rows affected (0.01 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> select * form test10;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'form test10' at line 1
mysql> select * from test10;
+------+-------+
| name | money |
+------+-------+
| 张三     |  3000 |
| 李四     |  4000 |
+------+-------+
2 rows in set (0.00 sec)

mysql> select * from test12;
+------+-------+
| name | money |
+------+-------+
| 张三     |  3000 |
| 李四     |  4000 |
+------+-------+
2 rows in set (0.00 sec)

mysql> start transaction;
Query OK, 0 rows affected (0.00 sec)

mysql> update test12 set money = money +1000 where name='张三';
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update test12 set money = money -1000 where name='李四';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> commit;
Query OK, 0 rows affected (0.01 sec)

mysql> select * from test12;
+------+-------+
| name | money |
+------+-------+
| 张三     |  4000 |
| 李四     |  3000 |
+------+-------+
2 rows in set (0.00 sec)

mysql> 