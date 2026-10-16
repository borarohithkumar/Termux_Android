-- ========================================================
-- DATABASE: sql2.db
-- TABLES: Publisher, Journal, Customer, Subscription
-- ========================================================

DROP TABLE IF EXISTS Subscription;
DROP TABLE IF EXISTS Journal;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Publisher;

CREATE TABLE Publisher (
    PUBLISHERID VARCHAR(10) PRIMARY KEY,
    PUBLISHERNAME VARCHAR(100) NOT NULL,
    RATING INT,
    CONTACTNO VARCHAR(15)
);

CREATE TABLE Journal (
    JOURNALID VARCHAR(10) PRIMARY KEY,
    JOURNALNAME VARCHAR(100) NOT NULL,
    GENRE VARCHAR(50),
    MONTHLYCHARGES INT,
    PUBLISHERID VARCHAR(10),
    FOREIGN KEY (PUBLISHERID) REFERENCES Publisher(PUBLISHERID)
);

CREATE TABLE Customer (
    CUSTOMERID VARCHAR(10) PRIMARY KEY,
    CUSTOMERNAME VARCHAR(50) NOT NULL,
    CUSTOMERTYPE VARCHAR(50),
    STATE VARCHAR(50),
    CITY VARCHAR(50)
);

CREATE TABLE Subscription (
    SUBSCRIPTIONID VARCHAR(10) PRIMARY KEY,
    JOURNALID VARCHAR(10),
    CUSTOMERID VARCHAR(10),
    STARTDATE DATE,
    DURATIONINMONTHS INT,
    DISCOUNTPERCENT DECIMAL(5, 2) DEFAULT 0.0,
    FOREIGN KEY (JOURNALID) REFERENCES Journal(JOURNALID),
    FOREIGN KEY (CUSTOMERID) REFERENCES Customer(CUSTOMERID)
);

INSERT INTO Publisher VALUES
('P101', 'Taylor & Francis', 4, '8765678932'),
('P102', 'Wiley', 2, NULL),
('P103', 'Sage Publications', 2, '7885678932'),
('P104', 'World Scientific', 3, '9765678932'),
('P105', 'Routledge', 5, NULL),
('P106', 'Springer Nature', 4, '7685655932');

INSERT INTO Journal VALUES
('J201', 'The Hollywood Reporter', 'Trade', 130, 'P105'),
('J202', 'Kirkus Reviews', 'Trade', 90, 'P102'),
('J203', 'The Lancet', 'Scientific', 75, 'P106'),
('J204', 'eLife', 'Academics', 85, 'P102'),
('J205', 'Pulp and Paper', 'Trade', 125, 'P102'),
('J206', 'Acta Politica', 'Politics', 110, 'P105'),
('J207', 'Global Policy', 'Politics', 105, 'P103'),
('J208', 'LOS Biology', 'Academics', 95, 'P101');

INSERT INTO Customer VALUES
('C101', 'Sam', 'Regular', 'New York', 'Manhattan'),
('C102', 'Jimmy', 'Privileged', 'Illinois', 'Chicago'),
('C103', 'Michael', 'Prime', 'Texas', 'Dallas'),
('C104', 'Oliver', 'Regular', 'Illinois', 'Chicago'),
('C105', 'Clara', 'Regular', 'Arizona', 'Phoenix'),
('C106', 'Amelia', 'Privileged', 'Arizona', 'Cottonwood'),
('C107', 'Robert', 'Regular', 'Illinois', 'Galesburg');

INSERT INTO Subscription VALUES
('S301', 'J202', 'C107', '2023-11-22', 8, 5.0),
('S302', 'J205', 'C105', '2023-09-10', 6, 0.0),
('S303', 'J201', 'C102', '2023-10-15', 4, 10.0),
('S304', 'J207', 'C103', '2023-02-25', 12, 15.0),
('S305', 'J203', 'C101', '2023-11-22', 12, 0.0),
('S306', 'J206', 'C105', '2023-11-22', 10, 8.0),
('S307', 'J202', 'C106', '2023-01-12', 6, 0.0),
('S308', 'J204', 'C107', '2023-06-29', 8, 12.0),
('S309', 'J205', 'C103', '2023-01-12', 5, 0.0),
('S310', 'J207', 'C102', '2023-08-17', 2, 5.0);

-- --------------------------------------------------------
-- QUERIES
-- --------------------------------------------------------

-- 1. Total revenue per publisher accounting for discount percentage
SELECT 
    p.PUBLISHERNAME, 
    SUM(((j.MONTHLYCHARGES * s.DURATIONINMONTHS) * (1 - (s.DISCOUNTPERCENT / 100.0)))) AS totalrevenue
FROM Publisher p
JOIN Journal j ON p.PUBLISHERID = j.PUBLISHERID
JOIN Subscription s ON j.JOURNALID = s.JOURNALID
GROUP BY p.PUBLISHERNAME
ORDER BY totalrevenue DESC;

-- 2. Count of unique subscribers per publisher
SELECT 
    p.PUBLISHERID, 
    j.JOURNALID, 
    s.CUSTOMERID, 
    COUNT(DISTINCT s.CUSTOMERID) AS count
FROM Publisher p
JOIN Journal j ON p.PUBLISHERID = j.PUBLISHERID
JOIN Subscription s ON j.JOURNALID = s.JOURNALID
GROUP BY p.PUBLISHERID;

-- 3. Publishers having strictly more than 2 unique subscribers
SELECT 
    p.PUBLISHERNAME, 
    COUNT(DISTINCT s.CUSTOMERID) AS NoOfUniqueSubscribers
FROM Publisher p
JOIN Journal j ON p.PUBLISHERID = j.PUBLISHERID
JOIN Subscription s ON j.JOURNALID = s.JOURNALID
GROUP BY p.PUBLISHERID
HAVING NoOfUniqueSubscribers > 2;
