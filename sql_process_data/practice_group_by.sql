USE classicmodels;

SELECT * FROM orders;

SELECT status, COUNT(status)
FROM orders
GROUP BY status;

SELECT * FROM orderdetails;

SELECT 
	orderNumber, 
	SUM(quantityOrdered * priceEach) AS amount
FROM orderdetails
GROUP BY orderNumber;

SELECT
	YEAR(orderDate) AS year,
    SUM(quantityOrdered * priceEach) AS total
FROM orders 
INNER JOIN orderdetails USING (orderNumber)
GROUP BY YEAR(orderDate);

SELECT 
	orderNumber,
    SUM(quantityOrdered * priceEach) AS total
FROM orderdetails
GROUP BY orderNumber
HAVING total > 60000;

SELECT
	orderNumber,
    SUM(quantityOrdered * priceEach) AS total
FROM orderdetails
WHERE quantityOrdered > 50 AND priceEach > 100
GROUP BY orderNumber;
