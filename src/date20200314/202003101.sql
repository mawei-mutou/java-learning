mysql> use huxiaoyang
Database changed
mysql> select goods_id,goods_name ,shop_price order by shop_price,goods_id
    -> select goods_id,goods_name ,shop_price order by shop_price,goods_id\c
mysql> select goods_id,goods_name ,shop_price from goods order by shop_price,goods_id
    -> limit 2,3;
+----------+--------------+------------+
| goods_id | goods_name   | shop_price |
+----------+--------------+------------+
|        1 | 小蓝海       |      77.35 |
|        2 | 中华香烟     |      77.35 |
|        5 | 耳机         |     420.50 |
+----------+--------------+------------+
3 rows in set (0.01 sec)

mysql> set names gbk;
Query OK, 0 rows affected (0.00 sec)

mysql> select goods_id,goods_name ,shop_price from goods order by shop_price,goods_id
    -> limit 2,3;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|        1 | С����          |      77.35 |
|        2 | �л�����          |      77.35 |
|        5 | ����           |     420.50 |
+----------+------------+------------+
3 rows in set (0.00 sec)

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

mysql> #��ϰ��ȡ��ÿ��cat_id��id������Ʒ��
mysql> select goods_id,goods_name,shop_price from goods group by cat_id  order by cat_id limit 1;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|        4 | ���           |      20.60 |
+----------+------------+------------+
1 row in set (0.00 sec)

mysql> select goods_id,goods_name,shop_price from goods group by cat_id  order by cat_id;
+----------+------------+------------+
| goods_id | goods_name | shop_price |
+----------+------------+------------+
|        4 | ���           |      20.60 |
|        5 | ����           |     420.50 |
|        1 | С����          |      77.35 |
+----------+------------+------------+
3 rows in set (0.00 sec)

mysql> select goods_id,goods_name,shop_price,cat_id from goods group by cat_id  order by cat_id;
+----------+------------+------------+--------+
| goods_id | goods_name | shop_price | cat_id |
+----------+------------+------------+--------+
|        4 | ���           |      20.60 |      0 |
|        5 | ����           |     420.50 |      2 |
|        1 | С����          |      77.35 |      3 |
+----------+------------+------------+--------+
3 rows in set (0.00 sec)

mysql> select goods_id,goods_name,shop_price,cat_id from goods order by cat_id;
+----------+------------+------------+--------+
| goods_id | goods_name | shop_price | cat_id |
+----------+------------+------------+--------+
|        4 | ���           |      20.60 |      0 |
|        5 | ����           |     420.50 |      2 |
|        6 | ����           |      56.00 |      2 |
|        1 | С����          |      77.35 |      3 |
|        2 | �л�����          |      77.35 |      3 |
|        3 | ��Ϊ�ֻ�         |    3800.00 |      3 |
+----------+------------+------------+--------+
6 rows in set (0.00 sec)

mysql> select goods_id,goods_name,shop_price,cat_id from goods order by cat_id,shop_price desc;
+----------+------------+------------+--------+
| goods_id | goods_name | shop_price | cat_id |
+----------+------------+------------+--------+
|        4 | ���           |      20.60 |      0 |
|        5 | ����           |     420.50 |      2 |
|        6 | ����           |      56.00 |      2 |
|        3 | ��Ϊ�ֻ�         |    3800.00 |      3 |
|        1 | С����          |      77.35 |      3 |
|        2 | �л�����          |      77.35 |      3 |
+----------+------------+------------+--------+
6 rows in set (0.00 sec)

mysql> select goods_id,goods_name,shop_price,cat_id from (select goods_id,goods_name,shop_price,cat_id from goods order by cat_id,shop_price desc) as temp group by cat_id limit 1;
+----------+------------+------------+--------+
| goods_id | goods_name | shop_price | cat_id |
+----------+------------+------------+--------+
|        4 | ���           |      20.60 |      0 |
+----------+------------+------------+--------+
1 row in set (0.01 sec)

mysql> select goods_id,goods_name,shop_price,cat_id from goods group by cat_id order by shop_price desc;
+----------+------------+------------+--------+
| goods_id | goods_name | shop_price | cat_id |
+----------+------------+------------+--------+
|        5 | ����           |     420.50 |      2 |
|        1 | С����          |      77.35 |      3 |
|        4 | ���           |      20.60 |      0 |
+----------+------------+------------+--------+
3 rows in set (0.00 sec)

mysql> select goods_id,goods_name,max(shop_price), cat_id from goods group by cat_id;
+----------+------------+-----------------+--------+
| goods_id | goods_name | max(shop_price) | cat_id |
+----------+------------+-----------------+--------+
|        4 | ���           |           20.60 |      0 |
|        5 | ����           |          420.50 |      2 |
|        1 | С����          |         3800.00 |      3 |
+----------+------------+-----------------+--------+
3 rows in set (0.00 sec)

mysql> select cat_id from goods group by cat_id order by shop_price desc;
+--------+
| cat_id |
+--------+
|      2 |
|      3 |
|      0 |
+--------+
3 rows in set (0.00 sec)

mysql> select goods_name ,shop_price, cat_id from goods order by cat_id,shop_pirce;
ERROR 1054 (42S22): Unknown column 'shop_pirce' in 'order clause'
mysql> select goods_name ,shop_price, cat_id from goods order by cat_id,shop_price;
+------------+------------+--------+
| goods_name | shop_price | cat_id |
+------------+------------+--------+
| ���           |      20.60 |      0 |
| ����           |      56.00 |      2 |
| ����           |     420.50 |      2 |
| С����          |      77.35 |      3 |
| �л�����          |      77.35 |      3 |
| ��Ϊ�ֻ�         |    3800.00 |      3 |
+------------+------------+--------+
6 rows in set (0.00 sec)

mysql> select goods_name,shop_price,cat_id from (select goods_name ,shop_price, cat_id from goods order by cat_id,shop_price desc) as temp group by cat_id;
+------------+------------+--------+
| goods_name | shop_price | cat_id |
+------------+------------+--------+
| ���           |      20.60 |      0 |
| ����           |     420.50 |      2 |
| ��Ϊ�ֻ�         |    3800.00 |      3 |
+------------+------------+--------+
3 rows in set (0.00 sec)

