# MySQL中的索引用法总结

索引作为一种数据结构，其用途是用于提升检索数据的效率。

## 索引的分类

MySQL中的索引共分为：

- 普通索引（INDEX）：索引列值可重复
- 唯一索引（UNIQUE）：索引列值必须唯一，可以为NULL
- 主键索引（PRIMARY KEY）：索引列值必须唯一，不能为NULL，一个表只能有一个主键索引
- 全文索引（FULL TEXT）：给每个字段创建索引

## 不同类型索引用途的区别

- 普通索引常用于过滤数据。例如，以商品种类作为索引，检索种类为“手机”的商品。
- 唯一索引主要用于标识一列数据不允许重复的特性，相比主键索引不常用于检索的场景。
- 主键索引是行的唯一标识，因而其主要用途是检索特定数据。
- 全文索引效率低，常用于文本中内容的检索。

## 使用索引

### 创建索引

- 普通索引（INDEX）：

  ```SQL
  -- 在创建表时指定
  CREATE TABLE student (
  	id INT NOT NULL,
      name VARCHAR(100) NOT NULL,
      birthday DATE,
      sex CHAR(1) NOT NULL,
      INDEX nameIndex (name(50))
  );
  
  -- 基于表结构创建
  CREATE INDEX nameIndex ON student(name(50));
  
  -- 修改表结构创建
  ALTER TABLE student ADD INDEX nameIndex(name(50));
  ```

- 唯一索引（UNIQUE）：

  ```SQL
  -- 在创建表时指定
  CREATE TABLE student (
  	id INT NOT NULL,
      name VARCHAR(100) NOT NULL,
      birthday DATE,
      sex CHAR(1) NOT NULL,
      UNIQUE idIndex (id)
  );
  
  -- 基于表结构创建
  CREATE UNIQUE INDEX idIndex ON student(id);
  
  -- 修改表结构创建
  ALTER TABLE student ADD UNIQUE INDEX idIndex(id);
  ```

- 主键索引（PRIMARY KEY）：

  ```SQL
  -- 创建表时时指定
  CREATE TABLE student (
  	id INT,
      name VARCHAR(100) NOT NULL,
      birthday DATE,
      sex CHAR(1) NOT NULL,
      PRIMARY KEY (id)
  );
  
  -- 修改表结构创建
  ALTER TABLE student ADD PRIMARY KEY (id);
  ```

  主键索引不能使用基于表结构创建的方式创建。

### 删除索引

- 普通索引（INDEX）：

  ```SQL
  -- 直接删除
  DROP INDEX nameIndex ON student;
  
  -- 修改表结构删除
  ALTER TABLE student DROP INDEX nameIndex;
  ```

- 唯一索引（UNIQUE）：

  ```SQL
  -- 直接删除
  DROP INDEX idIndex ON student;
  
  -- 修改表结构删除
  ALTER TABLE student DROP INDEX idIndex;
  ```

- 主键索引（PRIMARY KEY）：

  ```SQL
  ALTER TABLE student DROP PRIMARY KEY;
  ```

  主键不能采用直接删除的方式删除。

### 查看索引

```SQL
SHOW INDEX FROM student;
```

## 选择索引的原则

- 常用于查询条件的字段较适合作为索引，例如`WHERE`语句和`JOIN`语句中出现的列
- 唯一性太差的字段不适合作为索引，例如性别
- 更新过于频繁（更新频率远高于检索频率）的字段不适合作为索引

## 使用索引的利弊

- 使用索引的好处是索引通过一定的算法建立了索引值于列值直接的联系，可以通过索引直接获取对应的行数据，而无需进行全表搜索，因而加快了检索速度
- 但由于索引也是一种数据结构，它需要占据额外的内存空间，并且读取索引也加会大IO资源的消耗，因而索引并非越多越好，且对过小的表也没有添加索引的必要

