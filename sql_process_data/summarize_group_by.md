# SQL的GROUP BY用法小结

## 利用聚合函数进行分组

使用`COUNT()`、`AVE()`、`MIN()`、`MAX()`等聚合函数可实现对分组的过滤，聚合函数会分别对各组数据进行聚合。

以下面的orders表为例：

![](http://ww1.sinaimg.cn/large/98792392ly1g1g265uu9dj20km048jrf.jpg)

按照status列将订单分组并计算各组包含的订单条目数：

```SQL
SELECT status, COUNT(status)
FROM orders
GROUP BY status;
```

查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1g2bgtjaej205703j3yb.jpg)

再以一个orderdetails表为例：

![](http://ww1.sinaimg.cn/large/98792392ly1g1g4qbkhi9j20cd04qdfs.jpg)

若希望计算每个订单中包含商品的总价，则有

```SQL
SELECT 
	orderNumber, 
	SUM(quantityOrdered * priceEach) AS amount
FROM orderdetails
GROUP BY orderNumber;
```

查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1g4sn4cksj204p054744.jpg)

## 利用表达式进行分组

`GROUP BY`语句中还可以使用函数或表达式来处理数据。

例如，从上述orders表和orderdetails表中查询每年订单总额：

```SQL
SELECT
	YEAR(orderDate) AS year,
    SUM(quantityOrdered * priceEach) AS total
FROM orders 
INNER JOIN orderdetails USING (orderNumber)
GROUP BY YEAR(orderDate);
```

查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1g5ixabpyj203z0240si.jpg)

## 使用HAVING语句对分组结果进行过滤

`HAVING`语句可以过滤出分组后满足特定条件的数据。

例如，查找出总额大于60000的订单

```SQL
SELECT 
	orderNumber,
    SUM(quantityOrdered * priceEach) AS total
FROM orderdetails
GROUP BY orderNumber
HAVING total > 60000;
```

查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1g648qs0oj204t0243ya.jpg)

**注意**：

`WHERE`语句只能过滤行，不能过滤分组；因此`WHERE`语句应在`GROUP BY`之前使用。例如：

```SQL
SELECT
	orderNumber,
    SUM(quantityOrdered * priceEach) AS total
FROM orderdetails
WHERE quantityOrdered > 50 AND priceEach > 100
GROUP BY orderNumber;
```

查询结果为：

![](http://ww1.sinaimg.cn/large/98792392ly1g1g6i98ifjj204q04qa9w.jpg)

且`WHERE`语句中不能使用别名或者表达式，例如下列写法是不合法的：

```SQL
SELECT
	orderNumber AS orderId
FROM orderdetails
WHERE orderId > 100100
GROUP BY orderNumber;

--> Error Code: 1054. Unknown column 'orderId' in 'where clause'

SELECT
	orderNumber,
    SUM(quantityOrdered * priceEach) AS total
FROM orderdetails
WHERE SUM(quantityOrdered * priceEach) > 60000
GROUP BY orderNumber;

--> Error Code: 1111. Invalid use of group function	0.000 sec
```

---

## 参考

- [MySQL GROUP BY](<http://www.mysqltutorial.org/mysql-group-by.aspx>)

