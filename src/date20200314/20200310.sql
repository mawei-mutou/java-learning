mysql> use huxiaoyang;
Database changed
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| huxiaoyang         |
| mysql              |
| new1               |
| performance_schema |
| test               |
+--------------------+
6 rows in set (0.00 sec)

mysql> set names gkb;
ERROR 1115 (42000): Unknown character set: 'gkb'
mysql> set names gbk;
Query OK, 0 rows affected (0.00 sec)

mysql> use huxiaoyang;
Database changed
mysql> #ȡ��cat_id=3����Ʒ�������۸��ɵ͵��߽�������
mysql> select goods_id,goods_name shop_price from goods where cate_id =3;
ERROR 1054 (42S22): Unknown column 'cate_id' in 'where clause'
mysql> select goods_id,goods_name shop_price from goods where cat_id =3;
+----------+------------+
| goods_id | shop_price |
+----------+------------+
|        1 | С����          |
|        2 | �л�����          |
|        3 | ��Ϊ�ֻ�         |
+----------+------------+
3 rows in set (0.01 sec)

mysql> select goods_id,goods_name, shop_price from goods where cat_id =3;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|        1 | С����          |      77.35 |
|        2 | �л�����          |      77.35 |
|        3 | ��Ϊ�ֻ�         |    3800.00 |
+----------+------------+------------+
3 rows in set (0.00 sec)

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
| test3                |
+----------------------+
8 rows in set (0.06 sec)

mysql> select goods_id,goods_name, shop_price from goods where cat_id =3 order by goods_price;
ERROR 1054 (42S22): Unknown column 'goods_price' in 'order clause'
mysql> select goods_id,goods_name, shop_price from goods where cat_id =3 order by shop_price;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|        1 | С����          |      77.35 |
|        2 | �л�����          |      77.35 |
|        3 | ��Ϊ�ֻ�         |    3800.00 |
+----------+------------+------------+
3 rows in set (0.00 sec)

mysql> select goods_id,goods_name, shop_price from goods where cat_id =3 order by shop_price desc;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|        3 | ��Ϊ�ֻ�         |    3800.00 |
|        1 | С����          |      77.35 |
|        2 | �л�����          |      77.35 |
+----------+------------+------------+
3 rows in set (0.00 sec)

mysql> #��һ��desc���ǽ������С�
mysql> desc goods;
+--------------+------------------------+------+-----+---------+----------------+
| Field        | Type                   | Null | Key | Default | Extra          |
+--------------+------------------------+------+-----+---------+----------------+
| goods_id     | mediumint(8) unsigned  | NO   | PRI | NULL    | auto_increment |
| cat_id       | smallint(5) unsigned   | NO   |     | 0       |                |
| goods_sn     | varchar(60)            | NO   |     |         |                |
| goods_name   | varchar(120)           | NO   |     |         |                |
| click_count  | int(10) unsigned       | NO   |     | 0       |                |
| goods_number | smallint(5) unsigned   | NO   |     | 0       |                |
| market_price | decimal(10,2) unsigned | NO   |     | 0.00    |                |
| shop_price   | decimal(10,2) unsigned | NO   |     | 0.00    |                |
| add_time     | int(10) unsigned       | NO   |     | 0       |                |
| is_best      | tinyint(1) unsigned    | NO   |     | 0       |                |
| is_new       | tinyint(1) unsigned    | NO   |     | 0       |                |
| is_hot       | tinyint(1) unsigned    | NO   |     | 0       |                |
+--------------+------------------------+------+-----+---------+----------------+
12 rows in set (0.03 sec)

mysql> select goods_id,goods_name, shop_price from goods where cat_id =3 order by shop_price desc;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|        3 | ��Ϊ�ֻ�         |    3800.00 |
|        1 | С����          |      77.35 |
|        2 | �л�����          |      77.35 |
+----------+------------+------------+
3 rows in set (0.00 sec)

mysql> select goods_id,goods_name, shop_price from goods where cat_id =3 order by cat_id,shop_price;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|        1 | С����          |      77.35 |
|        2 | �л�����          |      77.35 |
|        3 | ��Ϊ�ֻ�         |    3800.00 |
+----------+------------+------------+
3 rows in set (0.00 sec)

mysql> select goods_id,goods_name, shop_price from goods  order by cat_id,shop_price;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|        4 | ���           |      20.60 |
|        6 | ����           |      56.00 |
|        5 | ����           |     420.50 |
|        1 | С����          |      77.35 |
|        2 | �л�����          |      77.35 |
|        3 | ��Ϊ�ֻ�         |    3800.00 |
+----------+------------+------------+
6 rows in set (0.00 sec)

mysql> select cat_id,goods_name, shop_price from goods  order by cat_id,shop_price;
+--------+------------+------------+
| cat_id | goods_name | shop_price |
+--------+------------+------------+
|      0 | ���           |      20.60 |
|      2 | ����           |      56.00 |
|      2 | ����           |     420.50 |
|      3 | С����          |      77.35 |
|      3 | �л�����          |      77.35 |
|      3 | ��Ϊ�ֻ�         |    3800.00 |
+--------+------------+------------+
6 rows in set (0.00 sec)

mysql> select cat_id,goods_name, shop_price from goods  order by cat_id,shop_price desc;
+--------+------------+------------+
| cat_id | goods_name | shop_price |
+--------+------------+------------+
|      0 | ���           |      20.60 |
|      2 | ����           |     420.50 |
|      2 | ����           |      56.00 |
|      3 | ��Ϊ�ֻ�         |    3800.00 |
|      3 | С����          |      77.35 |
|      3 | �л�����          |      77.35 |
+--------+------------+------------+
6 rows in set (0.00 sec)

