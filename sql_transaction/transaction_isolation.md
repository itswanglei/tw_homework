# 理解事务的隔离特性

## 脏读、不可重复读、幻读

- **脏读**：读到别的事务还未提交的修改
- **不可重复读**：读到别的事务已提交的修改，即在同一事务中多次查询结果不同
- **幻读**：由于未读到其他事务新插入或删除的数据导致后续插入或删除操作出错，即之前的查询结果是不真实的

脏读和不可重复读都针对的是现有数据被修改的情况，幻读针对的是插入或删除新数据的情况。

## 事务的隔离级别

在 SQL 标准中定义了四种数据库的事务的隔离级别：`READ UNCOMMITED`、`READ COMMITED`、`REPEATABLE READ` 和 `SERIALIZABLE`。不同级别的特性如下：

| 级别            | 脏读   | 不可重复读 | 幻读   |
| --------------- | ------ | ---------- | ------ |
| READ UNCOMMITED | 可能   | 可能       | 可能   |
| READ COMMITED   | 不可能 | 可能       | 可能   |
| REPEATABLE READ | 不可能 | 不可能     | 可能   |
| SERIALIZABLE    | 不可能 | 不可能     | 不可能 |

默认的隔离级别为`REPEATABLE READ`。

事务的隔离级别针对的是客户端，是对当前客户端的约束，限制当前客户端的读操作，即

- SERIALIZABLE级别强制当前客户端发起的写事务等待其他客户端的写事务提交后再执行
- REPEATABLE READ级别限制当前客户端不能读到其他客户端的事务的修改
- READ COMMITED级别限制当前客户端不能读到其他客户端的事务未提交的修改
- READ UNCOMMITED级别不对当前客户端的读事务进行限制

## 一个栗子

以如下的 score 表为例：

| id   | student_id | subject_id | score |
| ---- | ---------- | ---------- | ----- |
| 1    | 1          | 1001       | 90    |
| 2    | 1          | 1002       | 80    |
| 3    | 2          | 1001       | 60    |
| 4    | 2          | 1002       | 60.5  |

运行两个并行的事务：事务A和事务B。

其中，事务A执行对score表中的score列的修改操作：

```SQL
-- 事务A
BEGIN;
SELECT * FROM score;
UPDATE 
	score
SET
	score = score + 5;
SELECT * FROM score;
```

事务B执行对score表的查询操作：

```SQL
-- 事务B
BEGIN;
SELECT * FROM score;
```

### 隔离级别为 REPEATABLE READ 时

在事务A还未提交修改时，事务B查询score表时，查询不到事务A执行的修改：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pjkf32bej206r02uwea.jpg)

即**没有发生脏读现象**。

当事务A提交（`COMMIT`）上述修改后，事务B查询score表的结果如下：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pjkf32bej206r02uwea.jpg)

同样查询不到事务A执行的修改，即**没有发生不可重复读现象**。

因此在`REPEATABLE READ`隔离等级下，查询到的是表的历史版本。

如果在事务A提交之前想在事务B中修改表中的数据，如：

```SQL
UPDATE
	score
SET	
	score = score - 5;
```

MySQL在运行一段时间后会如下错误：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pjwpk3xpj20vg00ma9v.jpg)

这是因为事务B在等待事务A先提交所做的修改，并且因为等待超时报错。

这说明事务在执行过程中禁止当其他事务存在未提交修改时同时修改数据。

如果事务A在原表中插入一条数据，例如：

```SQL
INSERT INTO score
VALUES
	(5, 3, 1001, 85);
```

无论事务A是否提交该数据，事务B的查询结果均为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pkvh86vkj206t02w0sj.jpg)

即事务B查询不到新插入的数据，但此时如果事务B想在表中插入同样的数据时，运行会报错：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pl8332laj20vn00pt8j.jpg)

即**发生了幻读现象**。

### 隔离级别为 READ COMMITED 时

在事务A还未提交修改时，事务B查询score表的结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pk49dgfuj206r02uwea.jpg)

此时，事务B查询不到事务A未提交的修改，即**没有发生脏读现象**。

当事务A提交上述修改后，事务B的查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pk8tj93kj206t02w0sj.jpg)

此时，事务B可以查询到事务A提交后的修改，即**发生了不可重复读现象**。

如果事务A在原表中插入一条数据，事务B查询不到新插入的数据，但此时如果事务B想在表中插入同样的数据时，运行会报错：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pl8332laj20vn00pt8j.jpg)

即**发生了幻读现象**。

### 隔离级别为 READ UNCOMMITED 时

在事务A还未提交修改时，事务B查询score表的结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pkihcyc0j206t02w0sj.jpg)

此时，事务B可以查询到事务A未提交的修改，即**发生了脏读现象**。

当事务A提交上述修改后，事务B的查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pk8tj93kj206t02w0sj.jpg)

此时，事务B可以查询到事务A提交后的修改，即**发生了不可重复读现象**。

如果事务A在原表中插入一条数据，事务B查询不到新插入的数据，但此时如果事务B想在表中插入同样的数据时，运行会报错：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pl8332laj20vn00pt8j.jpg)

即**发生了幻读现象**。

### 隔离级别为 SERIALIZABLE 时

在事务A还未提交修改时，事务B查询score表的结果时，MySQL在运行一段时间后会报如下错误：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pknjn5d9j20vg00ma9v.jpg)

这表明事务B一直在等待事务A提交其修改直到超时。

说明了当前的隔离级别实际上是将并行的事务强制串行执行了。

当事务A提交上述修改后，事务B查询score表的结果如下：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pjkf32bej206r02uwea.jpg)

同样查询不到事务A执行的修改，即**没有发生不可重复读现象**。

如果事务A在原表中插入一条数据，在事务A还未交该数据时，事务B想插入同样的数据，MySQL在运行一段时间后会报如下错误：

![](http://ww1.sinaimg.cn/large/98792392ly1g1pknjn5d9j20vg00ma9v.jpg)

这表明事务B一直在等待事务A提交其修改直到超时。

即**没有发生幻读现象**。