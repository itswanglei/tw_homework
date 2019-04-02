# SQL规范总结

遵循一定的规范有助于提高代码的可读性和可移植性，对SQL来说规范中最主要的是命名规范和代码规范，这里给出了一些通用的规范，具体应该遵循的规范需要依据项目要求来确定。

## 命名规范

### 可用字符

- 对SQL来说，命名可用的字符包括 A-Z、a-z、0-9 及下划线。

- 命名时尽量不用数字。

- 下划线用于分割单词，不要以下划线作为开头或结尾

### 命名方式

- 使用英文而非拼音

- 做到见名知义

- 使用带有集合意义的词语，使用单数形式

  例如：用 stuff 而不是 employees

- 表明和列明尽量不要重名
- 避免通过组合两个表明来命名关系表

### 大小写规范

- 数据库名，小写，单词间用下划线分隔
- 表名，小写，单词间用下划线分隔
- 列名，小写，单词间用下划线分隔
- 别名，小驼峰命名法

### 长度限制

- 命名尽可能详细准确，但切忌太过冗长
- 表名、列名尽量限制在30字符以内

### 单词缩写

- 谨慎使用缩写
- 表名超过15字符、列名超过20字符时可以考虑用缩写
- 获得单词对应的缩写的方法：
  - 查字典
  - 推荐网站：<http://shortof.com/>
  - 删除除首字母外的元音字符和重复字符

- 对于主从表，从表从第二个单词开始缩写

### 其他

- 外键的命名建议采用“主表名_字段名”的形式

  例如：student_id

- 表示日期和时间字段建议通过后缀指明该字段精确到什么范围

  例如：birth_date 说明精确到日期

- 含义为“是否...”的布尔型字段前缀加 is

  例如：is_success、is_active

## 语句规范

### 关键字

- 关键字使用大写形式，以和其他代码区分
- 尽量使用关键字的全称而非缩写，以增强可读性

```SQL
SELECT 
	name
FROM
	student;
```

### 格式

通过适当的空格、换行和缩进来提高代码的可读性

- 可以添加空格的地方：

  - 运算符两侧
  - 逗号后

  ```SQL
  SELECT
  	name, age
  FROM
  	student
  WHERE
  	age > 18
  ```

- 可以添加换行的地方：

  - `AND`和`OR`关键字另起一行
  - 分号后另起一行
  - 每个关键字的定义之后另起一行

  ```SQL
  SELECT
  	name, age
  FROM
  	student
  WHERE
  	name LIKE '王%'
  	AND age > 18;
  ```

- 可以添加缩进的地方：

  - 联结查询应缩进
  - 子查询应缩进
  - 对字段的约束应缩进

  ```SQL
  SELECT 
      name, SUM(score) AS sum
  FROM
      student
          INNER JOIN
      score ON student.id = student_id
  GROUP BY student_id;
  ```

### 简洁性

保持代码的简洁性，去掉不必要的SQL语句

- 能用`BETWEEN`指定查询条件的地方不要用`AND`加多个子句的形式
- 能用`IN`指定查询条件的地方不要用`OR`加多个子句的形式
- 尽量少使用`UNION`和临时表

```SQL
-- 正例
SELECT
	name
FROM
	student
WHERE
	age BETWEEN 18 AND 22;
	
-- 反例
SELECT
	name
FROM
	student
WHERE
	age > 18 
	AND age < 22;
```

### 其他

- 使用标准的SQL函数来保证代码的可移植性
- 在必要的地方添加注释，不要滥用注释

## 创建表的规范

### 数据类型

- 使用SQL标准数据类型以保证可移植性

- 仅在必要的时候使用`REAL`和`FLOAT`类型，尽量使用`NUMERIC`和`DECIMAL`类型

  因为`FLOAT`型存在圆整错误

### 默认值

- 默认值应和字段类型相同

  例如：对于`DOUBLE`类型的字段，其默认值应指定为0.0而非0

- 默认值应定义在数据类型之后、`NOT NULL`约束之前

  例如：`sex CHAR(1) DEFAULT '男' NOT NULL`

### 键

- 指定为键的字段的值应具有唯一性
- 键字段在各表中的类型应该保持一致，且发生改变的可能性较低
- 尽量使键为简单值，必要情况下也可以使用复合值

### 约束

- 表应该至少拥有一个键

- 除`UNIQUE`、`PRIMARY KEY`、`FOREIGN KEY`外应给约束定义名称

- 约束的定义顺序：

  - 主键约束应定义在`CREATE TABLE`语句之后

  - 各列约束应定义在列的下方，使用缩进对齐

  - 涉及多个列的约束应尽量放置在涉及到的列的附近，如果不行的话放在表的创建的最后

  - 对整个表的约束应该放在表的创建的最后

  - 按照字母表的顺序排列约束

    例如，`ON DELETE`约束应该在`ON UPDATE`约束之前

- 定义必要的检查约束：
  - 当字符串类型的字段值格式已知时，使用`LIKE`和`SIMILAR TO`约束来检查
  - 当数字类型的字段值范围已知时，利用`CHECK`约束语句来检查

```SQL
CREATE TABLE student (
    PRIMARY KEY (id),
	id INT,
    name VARCHAR(100) NOT NULL,
    birth_date DATE,
    sex CHAR(1) NOT NULL
    	CONSTRAINT sex_value
    	CHECK (sex IN ('男', '女'))
);
```

---

## 参考

- [数据库设计中的命名规范](https://www.jianshu.com/p/7e60dbd59138)
- [SQL Style Guide](https://www.sqlstyle.guide/)

