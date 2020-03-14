mysql> show databases
    -> ;
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

mysql> use huxiaoyang
Database changed
mysql> show tables;
+----------------------+
| Tables_in_huxiaoyang |
+----------------------+
| newst                |
+----------------------+
1 row in set (0.01 sec)

mysql> select * from newst;
+------+-------+
| ID   | sname |
+------+-------+
|    1 | hhhhh |
+------+-------+
1 row in set (0.00 sec)

mysql> truncate newst;
Query OK, 0 rows affected (0.01 sec)

mysql> selecst * from newst;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'selecst * from newst' at line 1
mysql> select * from newst;
Empty set (0.00 sec)

mysql> drop table newst;
Query OK, 0 rows affected (0.00 sec)

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

mysql> use huxiaoyang;
Database changed
mysql> show tables;
Empty set (0.00 sec)

mysql> create table number_one(
    -> name varchar(10);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 2
mysql> create tabke number_one(
    -> name varchar(10)
    -> ,sexy varchar(10),
    -> company varchar(10),
    -> salary double(10),
    -> age int(10)
    -> )engine myisam charset utf8;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'tabke number_one(
name varchar(10)
,sexy varchar(10),
company varchar(10),
salar' at line 1
