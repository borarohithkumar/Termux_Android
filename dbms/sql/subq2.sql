-- ========================================================
-- DATABASE: subq2.db
-- TABLES: customer, invoice
-- ========================================================

DROP TABLE IF EXISTS invoice;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    custid VARCHAR(10) PRIMARY KEY,
    custname VARCHAR(50),
    custlocation VARCHAR(50)
);

CREATE TABLE invoice (
    invoiceno VARCHAR(10) PRIMARY KEY,
    custid VARCHAR(10),
    discount INT,
    FOREIGN KEY (custid) REFERENCES customer(custid)
);

INSERT INTO customer (custid, custname, custlocation) VALUES 
('C101', 'Alice', 'Yonkers'),
('C102', 'Bob', 'Yonkers'),
('C103', 'Charlie', 'New York');

INSERT INTO invoice (invoiceno, custid, discount) VALUES 
('IN110', 'C101', 10),
('IN111', 'C101', 5),
('IN112', 'C102', 15),
('IN113', 'C103', 25);

-- --------------------------------------------------------
-- QUERIES
-- --------------------------------------------------------

-- 1. Maximum discount for Yonkers customers using LEFT JOIN
SELECT c.custid, c.custname, MAX(i.discount) AS highdiscount
FROM customer c
LEFT JOIN invoice i ON c.custid = i.custid
WHERE c.custlocation = 'Yonkers'
GROUP BY c.custid, c.custname;

-- 2. Maximum discount for Yonkers customers using Subqueries
SELECT 
    c.custid, 
    c.custname, 
    (SELECT MAX(i.discount) FROM invoice i WHERE i.custid = c.custid) AS highdisc
FROM customer c
WHERE c.custid IN (
    SELECT custid 
    FROM customer 
    WHERE custlocation = 'Yonkers'
)
GROUP BY c.custid, c.custname;
