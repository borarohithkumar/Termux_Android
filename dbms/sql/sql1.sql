-- ========================================================
-- DATABASE: sql1.db
-- TABLES: Customer, Product, Vendor, VendorOffering, Invoice
-- ========================================================

DROP TABLE IF EXISTS Invoice;
DROP TABLE IF EXISTS VendorOffering;
DROP TABLE IF EXISTS Vendor;
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS Customer;

CREATE TABLE Customer (
    CustId VARCHAR(5) PRIMARY KEY CHECK (CustId LIKE 'C%'),
    CustName VARCHAR(10) NOT NULL,
    Age NUMERIC(2) CHECK (Age BETWEEN 0 AND 99),
    CustLocation VARCHAR(20),
    Email VARCHAR(30) UNIQUE,
    Gender CHAR(1) CHECK (Gender IN ('M', 'F'))
);

CREATE TABLE Product (
    ProductId VARCHAR(5) PRIMARY KEY,
    PName VARCHAR(50),
    Brand VARCHAR(50),
    PCategory VARCHAR(50),
    Color VARCHAR(20),
    Review VARCHAR(20)
);

CREATE TABLE Vendor (
    VendorId VARCHAR(5) PRIMARY KEY,
    VendorName VARCHAR(50),
    VendorContactNo VARCHAR(15),
    Rating NUMERIC(2)
);

CREATE TABLE VendorOffering (
    VendorId VARCHAR(5),
    ProductId VARCHAR(5),
    Price NUMERIC(7,2) NOT NULL CHECK (Price > 0),
    PRIMARY KEY (VendorId, ProductId),
    FOREIGN KEY (VendorId) REFERENCES Vendor(VendorId),
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
);

CREATE TABLE Invoice (
    InvoiceId VARCHAR(5) PRIMARY KEY CHECK (InvoiceId LIKE 'IN%'),
    CustId VARCHAR(5),
    VendorId VARCHAR(5),
    ProductId VARCHAR(5),
    QuantityPurchased NUMERIC(2) NOT NULL,
    Discount NUMERIC(3,1) NOT NULL DEFAULT 0.0,
    PurchaseDate DATE NOT NULL DEFAULT CURRENT_DATE,
    FOREIGN KEY (CustId) REFERENCES Customer(CustId),
    FOREIGN KEY (VendorId) REFERENCES Vendor(VendorId),
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
);

INSERT INTO Customer VALUES
('C101', 'Nancy', 28, 'Plattsburg', 'nancy@gmail.com', 'F'),
('C102', 'Bob', 21, 'Ithaca', 'bob@gmail.com', 'M'),
('C103', 'Clara', 35, 'Yonkers', 'clara@gmail.com', 'F'),
('C104', 'Vincent', 22, 'Ithaca', 'vincent@gmail.com', 'M'),
('C105', 'Alex', 40, 'Cortland', NULL, 'M'),
('C106', 'Peter', 31, 'Yonkers', 'peter@gmail.com', 'M'),
('C107', 'Rose', 26, 'Ithaca', 'rose@gmail.com', 'F'),
('C108', 'Elina', 29, 'Auburn', 'elina@gmail.com', 'F');

INSERT INTO Product VALUES
('P101', 'High Boots', 'Diesel', 'Shoes', 'Blue', 'Good'),
('P102', 'Mens Formal Shirt', 'Terrain', 'Clothing', 'Turquoise', 'Bad'),
('P103', 'Pearl Earring', 'Essence', 'Accessories', 'Yellow', 'Excellent'),
('P104', 'Kids Crocks', 'Sparx', NULL, 'Pink', 'Excellent'),
('P105', 'Kids Shirt', 'Cosmos', 'Clothing', 'White', 'Bad'),
('P106', 'Sporty Sneakers', 'Reebok', 'Shoes', 'White', 'Good'),
('P107', 'Womens Jacket', 'NorthFace', 'Clothing', NULL, 'Good'),
('P108', 'Leather Wallet', 'Luxurio', 'Accessories', 'Brown', 'Excellent');

INSERT INTO Vendor VALUES
('V101', 'Wendy Creations', '8976567890', 4),
('V102', 'CrazyNuts', NULL, 3),
('V103', 'FlyingHigh Retailers', '8126567890', 5),
('V104', 'Global Traders', '8005432556', 2),
('V105', 'Caretech Enterprises', '8116567890', 4),
('V106', 'Infinity Solutions', '8056781234', 3),
('V107', 'BrightWorks Technology', '8045678902', 5),
('V108', 'Walgreens Retailers', '8034567891', 4);

INSERT INTO VendorOffering VALUES
('V101', 'P101', 6001.00),
('V102', 'P102', 1200.33),
('V102', 'P104', 1000.86),
('V103', 'P101', 9333.67),
('V103', 'P103', 200.00),
('V104', 'P104', 900.00),
('V104', 'P105', 334.00),
('V105', 'P105', 222.50),
('V107', 'P107', 334.00),
('V108', 'P106', 5600.00);

INSERT INTO Invoice VALUES
('IN101', 'C101', 'V101', 'P101', 1, 12.5, '2023-08-11'),
('IN102', 'C102', 'V102', 'P102', 3, 13.0, '2023-09-23'),
('IN103', 'C103', 'V103', 'P103', 2, 15.2, '2023-06-10'),
('IN104', 'C104', 'V104', 'P104', 1, 10.0, '2023-09-01'),
('IN105', 'C103', 'V105', 'P105', 4, 5.0,  '2023-09-08'),
('IN106', 'C106', 'V102', 'P104', 7, 10.8, '2023-10-02'),
('IN107', 'C108', 'V103', 'P101', 4, 2.0,  '2023-10-12'),
('IN108', 'C107', 'V104', 'P105', 3, 3.3,  '2023-06-12'),
('IN109', 'C108', 'V108', 'P106', 8, 7.0,  '2023-07-18'),
('IN110', 'C101', 'V103', 'P101', 10, 20.4, '2023-08-18');

-- --------------------------------------------------------
-- QUERIES
-- --------------------------------------------------------

-- 1. All invoices calculated with MRP & Final Price
SELECT 
    i.CustId AS CUSTID, 
    i.InvoiceId AS INVOICEID, 
    CAST(ROUND(v.Price * i.QuantityPurchased) AS INT) AS MRP, 
    CAST(ROUND((v.Price * (1 - i.Discount / 100.0)) * i.QuantityPurchased) AS INT) AS FINAL_PRICE
FROM Invoice i 
JOIN VendorOffering v 
    ON i.VendorId = v.VendorId 
    AND i.ProductId = v.ProductId;

-- 2. Invoices filtered for bulk quantity purchased (> 2)
SELECT 
    i.CustId AS CUSTID, 
    i.InvoiceId AS INVOICEID, 
    CAST(ROUND(v.Price * i.QuantityPurchased) AS INT) AS MRP, 
    CAST(ROUND((v.Price * (1 - i.Discount / 100.0)) * i.QuantityPurchased) AS INT) AS FINAL_PRICE
FROM Invoice i 
JOIN VendorOffering v 
    ON i.VendorId = v.VendorId 
    AND i.ProductId = v.ProductId 
    AND i.QuantityPurchased > 2;

-- 3. Individual customer item purchases ordered by location and brand
SELECT c.CustLocation, c.CustId, p.Brand, i.QuantityPurchased
FROM Customer c
JOIN Invoice i ON c.CustId = i.CustId
JOIN Product p ON i.ProductId = p.ProductId
ORDER BY c.CustLocation ASC, p.Brand ASC;

-- 4. Aggregated total products sold grouped by location and brand
SELECT c.CustLocation, p.Brand, SUM(i.QuantityPurchased) AS productssold
FROM Customer c                                       
JOIN Invoice i ON c.CustId = i.CustId                                
JOIN Product p ON i.ProductId = p.ProductId                          
GROUP BY c.CustLocation, p.Brand                    
ORDER BY c.CustLocation ASC, p.Brand ASC;

-- 5. Fallback 'NA' for invoice ID on non-clothing items
SELECT DISTINCT 
    p.ProductId, 
    p.PCategory,
    CASE 
        WHEN p.PCategory = 'Clothing' AND i.InvoiceId IS NOT NULL THEN i.InvoiceId
        ELSE 'NA'
    END AS invoice_id
FROM Product p
LEFT JOIN Invoice i ON p.ProductId = i.ProductId
WHERE p.PCategory IS NOT NULL;

-- 6. All customers who made at least 1 bulk purchase of quantity >= 8 using Correlated Filtering with EXISTS
SELECT c.CustId, c.CustName, c.CustLocation
FROM Customer c
WHERE EXISTS (
    SELECT 1 
    FROM Invoice i 
    WHERE i.CustId = c.CustId 
      AND i.QuantityPurchased >= 8
);
