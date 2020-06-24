-------------------------------------------
Task 1
-------------------------------------------
1
SELECT city,MAX(grade)
FROM customer
GROUP BY city;
-------------------------------------------
Task 2
-------------------------------------------
1
SELECT customer_id,ord_date,MAX(purch_amt)
FROM orders
GROUP BY customer_id,ord_date;
-------
2
SELECT customer_id, ord_date, MAX(purch_amt)
FROM orders
GROUP BY customer_id, ord_date
HAVING MAX(purch_amt) BETWEEN 2000 and 6000;
-------------------------------------------
Task 3
------------------------------------------
1
SELECT c.cust_name, c.city, s.name, s.commission
FROM customer c
INNER JOIN salesman s
ON c.salesman_id = s.salesman_id
WHERE s.commission >.12;
--------
2
SELECT c.cust_name, c.city, c.grade, s.name, s.city
FROM customer c
LEFT JOIN salesman s
ON c.salesman_id = s.salesman_id
ORDER BY c.customer_id;
-----------
3
SELECT c.cust_name, c.city, c.grade, s.name, s.city
FROM customer c
LEFT JOIN salesman s
ON c.salesman_id = s.salesman_id
WHERE c.grade < 300
ORDER BY c.cust_name;
-------------------------------------------
Task 4
-------------------------------------------
SELECT emp_department.dpt_name
FROM emp_details
JOIN emp_department
ON emp_dept =dpt_code
GROUP BY emp_department.dpt_name
 HAVING COUNT(*) > 2;
