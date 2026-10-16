-- ========================================================
-- DATABASE: subq1.db
-- TABLE: INFOSCIONS
-- ========================================================

DROP TABLE IF EXISTS INFOSCIONS;

CREATE TABLE INFOSCIONS (
    ID INTEGER PRIMARY KEY,
    NAME TEXT,
    MARKS INTEGER,
    CLNO TEXT
);

INSERT INTO INFOSCIONS (ID, NAME, MARKS, CLNO) VALUES 
(1, 'Amit', 85, '10A'),
(2, 'Rahul', 60, '10A'),
(3, 'Sita', 75, '10A'),
(4, 'John', 90, '10B'),
(5, 'Jane', 55, '10B');

-- --------------------------------------------------------
-- QUERIES
-- --------------------------------------------------------

-- 1. Students scoring above or equal to average marks
SELECT id, name, marks, clno
FROM INFOSCIONS
WHERE marks >= (SELECT AVG(marks) FROM INFOSCIONS);

-- 2. Find the highest mark
SELECT MAX(marks) AS highmks FROM INFOSCIONS;

-- 3. Second highest scoring student record
SELECT id, name, marks, clno 
FROM INFOSCIONS
WHERE marks < (SELECT MAX(marks) FROM INFOSCIONS)
ORDER BY marks DESC
LIMIT 1;

-- 4. Minimum score strictly above the lowest score
SELECT MIN(marks) 
FROM INFOSCIONS 
WHERE marks > (SELECT MIN(marks) FROM INFOSCIONS);
