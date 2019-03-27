USE classicmodels;

SELECT * FROM payments;

SELECT
	customerNumber,
    amount
FROM payments
WHERE amount = (
	SELECT MAX(amount)
    FROM payments
);

SELECT * FROM customers;

SELECT * FROM orders;

SELECT customerName
FROM customers
WHERE customerNumber NOT IN (
	SELECT DISTINCT customerNumber
    FROM orders
);

SELECT * FROM orderdetails;

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

SELECT * FROM productlines;

SELECT * FROM products;

USE student_examination_sys;

SELECT * FROM student;

SELECT * FROM score;

SELECT
	name,
    SUM(score) AS sum
FROM
	student
INNER JOIN score ON student.id = student_id
GROUP BY name;

INSERT INTO student
VALUES
	('3', '王五', '19', '男');
    
SELECT 
    name, SUM(score) AS sum
FROM
    student
        LEFT JOIN
    score ON student.id = student_id
GROUP BY name;

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
