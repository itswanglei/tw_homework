# 子查询、联结查询、组合查询用法总结

## 子查询

子查询就是在一个查询语句内部嵌套的查询，因而子查询语句也被称为内部查询、包含子查询语句的查询称为外部查询。这种查询语句的查询顺序是从内向外的。

常见的使用子查询的形式为：在`WHERE`语句内、在`IN`或`NOT IN`操作符后、在`FROM`语句内、在`EXISTS`或`NOT EXISTS`操作符后。

### 在WHERE语句中使用子查询

可以在`WHERE`语句中使用子查询的结果对外部查询的数据进行过滤。

以下面的付款信息payments表为例：

![](http://ww1.sinaimg.cn/large/98792392ly1g1ghjsa8nzj209s05mjre.jpg)

查询订单金额最大的客户的操作为：

```SQL
SELECT
	customerNumber,
    amount
FROM payments
WHERE amount = (
	SELECT MAX(amount)
    FROM payments
);
```

查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1ghlr4uf0j205f015a9t.jpg)

### 在IN或NOT IN操作符后使用子查询

`IN`和`NOT IN`语句用于过滤出存在/不存在于子查询结果的数据。

例如在如下的顾客表customers和订单表orders中进行查询：

![](http://ww1.sinaimg.cn/large/98792392ly1g1ghvczm23j20nb05idg3.jpg)

![](http://ww1.sinaimg.cn/large/98792392ly1g1ghw91u76j20kj05z3yo.jpg)

查询出未产生订单的客户名单的操作为：

```SQL
SELECT customerName
FROM customers
WHERE customerNumber NOT IN (
	SELECT DISTINCT customerNumber
    FROM orders
);
```

查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1gi0oz6ibj205103r744.jpg)

### 在FROM语句内使用子查询

可以将子查询结果作为一个临时表用于`FROM`语句中。

以如下订单详情表orderdetails为例：

![](http://ww1.sinaimg.cn/large/98792392ly1g1gi4pyal8j20cd061dfv.jpg)

查询该表中的订单包含的商品种类的最大值、最小值和平均值的操作为：

```SQL
SELECT	
	MAX(count),
    MIN(count),
    FLOOR(AVG(count))
FROM (
	SELECT 
		orderNumber,
        COUNT(orderNumber) AS count
	FROM orderdetails
    GROUP BY orderNumber
) AS orderCount;
```

查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1giby8884j2080015gld.jpg)

### 在EXISTS或NOT EXISTS操作符后使用子查询

使用`EXISTS`和`NOT EXISTS`操作符可以过滤出满足/不满足于子查询结果的数据。

以上述customers表、orders表和orderdetails表为例，查询三个表中订单总额大于60000的顾客名单的操作为：

```SQL
SELECT 
	customerNumber,
    customerName
FROM customers
WHERE EXISTS (
	SELECT
		orderNumber,
        SUM(quantityOrdered * priceEach) AS total
	FROM orders
    INNER JOIN orderdetails USING (orderNumber)
    WHERE customerNumber = customers.customerNumber
    GROUP BY orderNumber
    HAVING total > 60000
);
```

查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1gkpci2hfj207902mdfn.jpg)

## 联结查询

联结查询是将多个表的数据放在一起进行查询。

联结查询包含内联结、外联结、交叉联结、自联结等，其中最常用的为内联结和外联结。

### 内联结

内联结即查询两个表中数据的交集（如图），查询过程是将主表和副表的每一条数据都按照联结条件来匹配，只有满足联结条件的数据才会被保留。

![](http://ww1.sinaimg.cn/large/98792392ly1g1hcrf357mj20ac05njrh.jpg)

内联结的语法：

- `FROM`后跟随主表
- `INNER JOIN`后跟随副表
- `ON`后跟随联结条件

内联结可以联结多个表来查询。

以如下的student表和score表为例：

![](http://ww1.sinaimg.cn/large/98792392ly1g1hfp4mptfj205b0230si.jpg)

![](http://ww1.sinaimg.cn/large/98792392ly1g1hf918lrwj206r02kjr6.jpg)

从两个表中检索出登记过成绩的各学生的总成绩的语句为：

```SQL
SELECT
	name,
    SUM(score) AS sum
FROM
	student
		INNER JOIN 
    score ON student.id = student_id
GROUP BY name;
```

查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1hfajb2z8j203701m741.jpg)

可以看到内联结仅取出了均存在于两个表的学生的成绩。

### 外联结

外联结在查询过程中会保留主表中的所有数据，并对每一行数据按照指定的联结规则与附表匹配，若能匹配则取出副表中对应的数据，若不能匹配则该项以NULL填充。左外联结和右外联结的效果如下面两张图所示。

![](http://ww1.sinaimg.cn/large/98792392ly1g1hfkrslz2j20eu04r0t3.jpg)



外联结的语法：

- `FROM`后跟随主表
- `LEFT JOIN`或`RIGEHT JOIN`后跟随副表
- `ON`后跟随联结条件

依旧以上述student表和score表为例。

从两个表中检索出所有各学生的总成绩的语句为：

```SQL
SELECT 
    name, 
    SUM(score) AS sum
FROM
    student
        LEFT JOIN
    score ON student.id = student_id
GROUP BY name;
```

检索结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1hfuuglcyj2038024dfl.jpg)

可以看到由于score表中没有王五的成绩，因此王五的总成绩为NULL。

## 组合查询

组合查询是将多次查询的结果显示到一张表中，使用`UNION`关键字实现。

**其规则是**：只有当多次查询的结果具有相似的结构（即相同数量的列，且对应列的类型相同或可以相互转换）时才能进行组合查询。

以上面的student表和score表为例。

查询出张三的平均分和总分的语句为：

```SQL
SELECT 
    name, AVG(score) AS scoreInfor
FROM
    student
        INNER JOIN
    score ON student.id = student_id
WHERE
    name = '张三'
UNION
SELECT
	name, SUM(score) AS scoreInfor
FROM 
	student
		INNER JOIN
	score ON student.id = student_id
WHERE 
	name = '张三';
```

查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1hg9ntqxnj203v01na9t.jpg)

## 总结

这三种方法的相同之处都是可以从多个相互关联的表中查询数据，相比单一表的查询更加使用。

不同之处在于：

- 子查询是按照从内向外的顺序依次执行查询，主要用于使用子查询的结果作为基础进一步进行外层的查询，更适用于二次检索或过滤数据等操作。在嵌套曾经较少的情况下代码可读性较高，但检索效率较低。
- 联结查询是对不同表的数据进行了组合，并按照一定条件过滤；更适用于查询多表之间的共有数据（如内联结）或表数据的扩充（如外联结）等场景。
- 组合查询是将多次相似查询的结合进行合并展示的一种方式，主要用于对查询结果的聚合。

---

## 参考

- [MySQL Subquery](<http://www.mysqltutorial.org/mysql-subquery/>)

