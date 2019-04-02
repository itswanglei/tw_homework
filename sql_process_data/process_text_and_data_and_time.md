# SQL中常用的文本处理函数和日期时间处理函数

## 常用文本处理函数

- `CONCAT(str1, str2, ...)`：拼接字符串

  ```SQL
  mysql> SELECT CONCAT('There', ' is', ' an', ' apple.');
  +------------------------------------------+
  | CONCAT('There', ' is', ' an', ' apple.') |
  +------------------------------------------+
  | There is an apple.                       |
  +------------------------------------------+
  ```

- `CONCAT_WS(separator, str1, str2, ...)`：使用指定分隔符连接字符串

  ```SQL
  mysql> SELECT CONCAT_WS('-', 'There', 'is', 'an', 'apple');
  +----------------------------------------------+
  | CONCAT_WS('-', 'There', 'is', 'an', 'apple') |
  +----------------------------------------------+
  | There-is-an-apple                            |
  +----------------------------------------------+
  ```

- `LEFT(str, length)`：从左截取指定长度的子字符串

  ```sql
  mysql> SELECT LEFT('ZHANG SAN', 5);
  +----------------------+
  | LEFT('ZHANG SAN', 5) |
  +----------------------+
  | ZHANG                |
  +----------------------+
  ```

- `RIGHT(str, length)`：从右截取指定长度的子字符串

  ```SQL
  mysql> SELECT RIGHT('ZHANG SAN', 3);
  +-----------------------+
  | RIGHT('ZHANG SAN', 3) |
  +-----------------------+
  | SAN                   |
  +-----------------------+
  ```

- `SUBSTRING(str, index, length)`：从指定位置处开始截取指定长度的子字符串

  ```
   mysql> SELECT SUBSTRING('ABCDEFG', 3, 4);
   +----------------------------+
   | SUBSTRING('ABCDEFG', 3, 4) |
   +----------------------------+
   | CDEF                       |
   +----------------------------+
  ```

- `LENGTH(str)`：返回字符串的长度

  ```SQL
  mysql> SELECT LENGTH('ZHANG SAN');
  +---------------------+
  | LENGTH('ZHANG SAN') |
  +---------------------+
  |                   9 |
  +---------------------+
  ```

- `LOWER(str)`：将字符串转换为小写格式

  ```SQL
  mysql> SELECT LOWER('ZHANG SAN');
  +--------------------+
  | LOWER('ZHANG SAN') |
  +--------------------+
  | zhang san          |
  +--------------------+
  ```

- `UPPER(str)`：将字符串转换为大写格式

  ```SQL
  mysql> SELECT UPPER('zhang san');
  +--------------------+
  | UPPER('zhang san') |
  +--------------------+
  | ZHANG SAN          |
  +--------------------+
  ```

- `LTRIM(str)`：去除字符串左侧的空格

  ```SQL
  mysql> SELECT CONCAT('(', LTRIM('   LEFT'), ')');
  +------------------------------------+
  | CONCAT('(', LTRIM('   LEFT'), ')') |
  +------------------------------------+
  | (LEFT)                             |
  +------------------------------------+
  ```

- `RTRIM(str)`：去除字符串右侧的空格

  ```SQL
  mysql> SELECT CONCAT('(', RTRIM('RIGHT   '), ')');
  +-------------------------------------+
  | CONCAT('(', RTRIM('RIGHT   '), ')') |
  +-------------------------------------+
  | (RIGHT)                             |
  +-------------------------------------+
  ```

- `TRIM(str)`：去除字符串两侧的空格

  ```SQL
  mysql> SELECT CONCAT('(', TRIM('   MIDDLE   '), ')');
  +----------------------------------------+
  | CONCAT('(', TRIM('   MIDDLE   '), ')') |
  +----------------------------------------+
  | (MIDDLE)                               |
  +----------------------------------------+
  ```

- `ELT(index, str1, str2, ...)`：返回字符串序列中指定位置的字符串

  ```SQL
  mysql> SELECT ELT(3, 'A', 'B', 'C', 'D');
  +----------------------------+
  | ELT(3, 'A', 'B', 'C', 'D') |
  +----------------------------+
  | C                          |
  +----------------------------+
  ```

- `FIELD(str, str1, str2, ...)`：返回指定字符串str在字符串序列中的位置，找不到返回0

  ```SQL
  mysql> SELECT FIELD('C', 'A', 'B', 'C', 'D');
  +--------------------------------+
  | FIELD('C', 'A', 'B', 'C', 'D') |
  +--------------------------------+
  |                              3 |
  +--------------------------------+
  ```

- `FIND_IN_SET(str, stringList)`：返回指定字符串str在由“`,`”分割的字符串序列中的位置

  ```SQL
  mysql> SELECT FIND_IN_SET('C', 'A,B,C,D');
  +-----------------------------+
  | FIND_IN_SET('C', 'A,B,C,D') |
  +-----------------------------+
  |                           3 |
  +-----------------------------+
  ```

- `FORMAT(X, D)`：按照指定的小数位数D将数值X转化为字符串

  ```SQL
  mysql> SELECT FORMAT(123.45678, 2);
  +----------------------+
  | FORMAT(123.45678, 2) |
  +----------------------+
  | 123.46               |
  +----------------------+
  ```

- `INSERT(str, index, length, newString)`：从指定位置开始用新字符串替换原字符串中指定长度的字符，index超出原字符串范围时返回原字符串

  ```SQL
  mysql> SELECT INSERT('ABCDEF', 3, 3, '123');
  +-------------------------------+
  | INSERT('ABCDEF', 3, 3, '123') |
  +-------------------------------+
  | AB123F                        |
  +-------------------------------+
  ```

- `LOCATE(substr, str)`：返回子字符串在指定字符串中第一次出现的位置

  `LOCATE(substr, str, index)`：从指定字符串的指定位置处开始查找子字符串出现的位置

  找不到返回0

  ```SQL
  mysql> SELECT LOCATE('a', 'banana');
  +-----------------------+
  | LOCATE('a', 'banana') |
  +-----------------------+
  |                     2 |
  +-----------------------+
  
  mysql> SELECT LOCATE('a', 'banana', 3);
  +--------------------------+
  | LOCATE('a', 'banana', 3) |
  +--------------------------+
  |                        4 |
  +--------------------------+
  ```

- `LPAD(str, length, padStr)`：在字符串左侧用padStr将原字符串填充至指定长度，当指定长度小于原字符串长度时，截断原字符串

  ```SQL
  mysql> SELECT LPAD('HELLO', 8, '!');
  +-----------------------+
  | LPAD('HELLO', 8, '!') |
  +-----------------------+
  | !!!HELLO              |
  +-----------------------+
  ```

- `RPAD(str, length, padStr)`：在字符串右侧用padStr将原字符串填充至指定长度，当指定长度小于原字符串长度时，截断原字符串

  ```SQL
  mysql> SELECT RPAD('HELLO', 8, '!');
  +-----------------------+
  | RPAD('HELLO', 8, '!') |
  +-----------------------+
  | HELLO!!!              |
  +-----------------------+
  ```

- `REPEAT(str, times)`：按照指定次数重复字符串

  ```SQL
  mysql> SELECT REPEAT('LA', 3);
  +-----------------+
  | REPEAT('LA', 3) |
  +-----------------+
  | LALALA          |
  +-----------------+
  ```

- `REPLACE(str, from_str, to_str)`：将字符串中的所有匹配的字符串替换为新字符串

  ```SQL
  mysql> SELECT REPLACE('LALALA', 'L', 'B');
  +-----------------------------+
  | REPLACE('LALALA', 'L', 'B') |
  +-----------------------------+
  | BABABA                      |
  +-----------------------------+
  ```

- `REVERSE(str)`：将字符串逆序输出

  ```SQL
  mysql> SELECT REVERSE('ABC');
  +----------------+
  | REVERSE('ABC') |
  +----------------+
  | CBA            |
  +----------------+
  ```

## 常用日期和时间处理函数

- `NOW()`：返回当前的时间和日期

  ```SQL
  mysql> SELECT NOW();
  +---------------------+
  | NOW()               |
  +---------------------+
  | 2019-03-25 18:01:47 |
  +---------------------+
  ```

- `CURDATE()`：返回当前的日期

  ```SQL
  mysql> SELECT CURDATE();
  +------------+
  | CURDATE()  |
  +------------+
  | 2019-03-25 |
  +------------+
  ```

- `CURTIME()`：返回当前时间

  ```SQL
  mysql> SELECT CURTIME();
  +-----------+
  | CURTIME() |
  +-----------+
  | 18:05:02  |
  +-----------+
  ```

- `DATE(dateAndTime)`：提取日期时间表达式中的日期部分

  ```SQL
  mysql> SELECT DATE(NOW());
  +-------------+
  | DATE(NOW()) |
  +-------------+
  | 2019-03-25  |
  +-------------+
  ```

- `DAY()`：返回日期时间表达式中的天数部分

  ```SQL
  mysql> SELECT DAY(NOW());
  +------------+
  | DAY(NOW()) |
  +------------+
  |         25 |
  +------------+
  ```

- `YEAR()`：返回日期时间表达式中的年部分

  ```SQL
  mysql> SELECT YEAR(NOW());
  +-------------+
  | YEAR(NOW()) |
  +-------------+
  |        2019 |
  +-------------+
  ```

- `EXTRACT(unit FROM date)`：按照指定的时间单位从日期时间表达式中提取年、月、日、时间等部分

  ```SQL
  mysql> SELECT EXTRACT(YEAR FROM NOW());
  +--------------------------+
  | EXTRACT(YEAR FROM NOW()) |
  +--------------------------+
  |                     2019 |
  +--------------------------+
  
  mysql> SELECT EXTRACT(WEEK FROM NOW());
  +--------------------------+
  | EXTRACT(WEEK FROM NOW()) |
  +--------------------------+
  |                       12 |
  +--------------------------+
  
  mysql> SELECT EXTRACT(HOUR_MICROSECOND FROM NOW());
  +--------------------------------------+
  | EXTRACT(HOUR_MICROSECOND FROM NOW()) |
  +--------------------------------------+
  |                         191218000000 |
  +--------------------------------------+
  ```

  时间单位的值可参考[Temporal Intervals](<https://dev.mysql.com/doc/refman/8.0/en/expressions.html#temporal-intervals>)文档

- `DATE_FORMAT(date, format)`：按照指定格式显示时间日期

  可选的格式可参考[Date and time functions](<https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_date-format>)

  ```SQL
  mysql> SELECT DATE_FORMAT(NOW(), '%W %M %Y');
  +--------------------------------+
  | DATE_FORMAT(NOW(), '%W %M %Y') |
  +--------------------------------+
  | Monday March 2019              |
  +--------------------------------+
  ```

- `DATE_ADD(date, INTERVAL exp unit)`、`DATE_SUB(date, INTERVAL exp unit)`：日期和时间的加减操作。返回值是否包含时间取决于给定的时间日期的表达式和时间单位。

  ```SQL
  mysql> SELECT DATE_ADD('2018-03-25', INTERVAL 1 DAY);
  +----------------------------------------+
  | DATE_ADD('2018-03-25', INTERVAL 1 DAY) |
  +----------------------------------------+
  | 2018-03-26                             |
  +----------------------------------------+
  
  mysql> SELECT DATE_SUB('2018-03-25 19:26:47', INTERVAL 1 HOUR);
  +--------------------------------------------------+
  | DATE_SUB('2018-03-25 19:26:47', INTERVAL 1 HOUR) |
  +--------------------------------------------------+
  | 2018-03-25 18:26:47                              |
  +--------------------------------------------------+
  ```

- `DATEDIFF(date1, date2)`：返回两个日期的差值，会忽略表达式中的时间，仅对日期进行运算

  ```SQL
  mysql> SELECT DATEDIFF('2018-4-30', NOW());
  +------------------------------+
  | DATEDIFF('2018-4-30', NOW()) |
  +------------------------------+
  |                         -329 |
  +------------------------------+
  1 row in set (0.00 sec)
  ```

- `ADDDATE(date, INTERVAL exp unit)`：等同于`DATE_ADD()`

  `ADDDATE(date, days)`：在给定的日期上加上给定的天数

  ```SQL
  mysql> SELECT ADDDATE(NOW(), 31);
  +---------------------+
  | ADDDATE(NOW(), 31)  |
  +---------------------+
  | 2019-04-25 19:39:53 |
  +---------------------+
  ```

- `ADDTIME(time1, time2)`：将两个时间表达式相加

  ```SQL
  mysql> SELECT ADDTIME('10:33:24', '22:23:22');
  +---------------------------------+
  | ADDTIME('10:33:24', '22:23:22') |
  +---------------------------------+
  | 32:56:46                        |
  +---------------------------------+
  ```
