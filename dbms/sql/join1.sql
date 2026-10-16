-- ========================================================
-- DATABASE: join1.db
-- TABLE: Product
-- ========================================================

DROP TABLE IF EXISTS Product;

CREATE TABLE Product (
    ProductId VARCHAR(10) PRIMARY KEY,
    PName VARCHAR(50),
    Brand VARCHAR(50),
    PCategory VARCHAR(50),
    Color VARCHAR(30),
    Review VARCHAR(30)
);

INSERT INTO Product (ProductId, PName, Brand, PCategory, Color, Review) VALUES
('P101', 'High Boots', 'Diesel', 'Shoes', 'Blue', 'Good'),
('P102', 'Mens Formal Shirt', 'Terrain', 'Clothing', 'Turquoise', 'Bad'),
('P103', 'Pearl Earring', 'Essence', 'Accessories', 'Yellow', 'Excellent'),
('P104', 'Kids Crocks', 'Sparx', NULL, 'Pink', 'Excellent'),
('P105', 'Kids Shirt', 'Cosmos', 'Clothing', 'White', 'Bad'),
('P106', 'Sporty Sneakers', 'Reebok', 'Shoes', 'White', 'Good'),
('P107', 'Womens Jacket', 'NorthFace', 'Clothing', NULL, 'Good'),
('P108', 'Leather Wallet', 'Luxurio', 'Accessories', 'Brown', 'Excellent'),
('P109', 'Leather Wallet', 'Reebok', 'Accessories', 'Brown', 'Excellent');

-- --------------------------------------------------------
-- QUERIES
-- --------------------------------------------------------

-- 1. Products sharing PCategory and Review with another product (excluding 'Bad' reviews)
SELECT DISTINCT 
    p1.ProductId, 
    p1.PName, 
    p1.PCategory, 
    p1.Review
FROM Product p1
JOIN Product p2 
    ON p1.PCategory = p2.PCategory 
    AND p1.Review = p2.Review 
    AND p1.ProductId <> p2.ProductId
WHERE p1.Review <> 'Bad';
