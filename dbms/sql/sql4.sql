-- ========================================================
-- DATABASE: sql4.db
-- TABLES: Customer, Flight, Booking
-- ========================================================

DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS Flight;
DROP TABLE IF EXISTS Customer;

CREATE TABLE Customer (
    CustId VARCHAR(10) PRIMARY KEY,
    CustName VARCHAR(50) NOT NULL
);

CREATE TABLE Flight (
    FlightId VARCHAR(10) PRIMARY KEY,
    FlightName VARCHAR(50) NOT NULL,
    FlightType VARCHAR(20),
    Source VARCHAR(50),
    Destination VARCHAR(50)
);

CREATE TABLE Booking (
    BookingId INT PRIMARY KEY,
    FlightId VARCHAR(10),
    CustId VARCHAR(10),
    TravelClass VARCHAR(20),
    FlightCharge INT,
    BookingDate DATE,
    FOREIGN KEY (CustId) REFERENCES Customer(CustId),
    FOREIGN KEY (FlightId) REFERENCES Flight(FlightId)
);

INSERT INTO Customer VALUES
('C301', 'John'),
('C302', 'Sam'),
('C303', 'Robert'),
('C304', 'Albert'),
('C305', 'Jack');

INSERT INTO Flight VALUES
('F101', 'Spice Jet Airlines', 'Domestic', 'Mumbai', 'Kolkata'),
('F102', 'Indian Airlines', 'International', 'Delhi', 'Germany'),
('F103', 'Deccan Airlines', 'Domestic', 'Chennai', 'Bengaluru'),
('F104', 'British Airways', 'International', 'London', 'Italy'),
('F105', 'Swiss Airlines', 'International', 'Zurich', 'Spain');

INSERT INTO Booking VALUES
(201, 'F101', 'C301', 'Business', 12000, '2018-03-22'),
(202, 'F105', 'C303', 'Business', 30000, '2018-05-17'),
(203, 'F103', 'C302', 'Economy',  3000,  '2018-06-23'),
(204, 'F101', 'C302', 'Economy',  10000, '2018-10-12'),
(205, 'F104', 'C303', 'Business', 25000, '2019-01-16'),
(206, 'F105', 'C301', 'Business', 30000, '2019-01-22'),
(207, 'F104', 'C304', 'Economy',  22000, '2019-02-16'),
(208, 'F101', 'C304', 'Business', 12000, '2019-09-18'),
(209, 'F101', 'C305', 'Business', 8000,  '2019-09-18');

-- --------------------------------------------------------
-- QUERIES
-- --------------------------------------------------------

-- 1. Bookings exceeding the maximum Economy class charge
SELECT bookingid, flightid, flightcharge
FROM Booking
WHERE flightcharge > (
    SELECT MAX(flightcharge) 
    FROM Booking 
    WHERE travelclass = 'Economy'
);

-- 2. Customer business booking date with 'no bookin' fallback
SELECT 
    c.custid, 
    c.custname, 
    COALESCE(b.bookingdate, 'no bookin') AS bdate
FROM Customer c
LEFT JOIN Booking b 
    ON c.custid = b.custid 
    AND b.travelclass = 'Business';

-- 3. Customer with the highest total number of bookings
SELECT b.CustId, c.CustName
FROM Customer c 
JOIN Booking b ON c.CustId = b.CustId 
GROUP BY b.CustId
HAVING COUNT(*) = (
    SELECT MAX(count)
    FROM (
        SELECT COUNT(*) AS count 
        FROM Booking 
        GROUP BY CustId
    )
);

-- 4. Minimum flight charge recorded per flight
SELECT flightid, MIN(flightcharge) AS FlightCharge, bookingdate
FROM Booking
GROUP BY flightid;
