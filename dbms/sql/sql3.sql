-- ========================================================
-- DATABASE: sql3.db
-- TABLES: Sport, Event
-- ========================================================

DROP TABLE IF EXISTS Event;
DROP TABLE IF EXISTS Sport;

CREATE TABLE Sport (
    sportid VARCHAR(10) PRIMARY KEY,
    sportname VARCHAR(50) NOT NULL,
    sporttype VARCHAR(20) NOT NULL,
    venue VARCHAR(100) NOT NULL
);

CREATE TABLE Event (
    eventid VARCHAR(10) PRIMARY KEY,
    sportid VARCHAR(10),
    playerid VARCHAR(10),
    eventdate DATE,
    noofattempts INT,
    FOREIGN KEY (sportid) REFERENCES Sport(sportid)
);

INSERT INTO Sport VALUES
('S001', '100m Backstroke', 'Swimming', 'University Sports Complex'),
('S002', 'Freestyle Wrestling', 'Wrestling', 'Indoor Arena'),
('S003', 'Shot Put Throw', 'Athletics', 'Outdoor Stadium'),
('S004', 'Trail Running', 'Athletics', 'Lake Side Trail'),
('S005', 'Greco Roman', 'Wrestling', 'Indoor Arena'),
('S006', '200m Hurdles', 'Athletics', 'Athletic Track'),
('S007', 'Javelin Throw', 'Athletics', 'Outdoor Stadium');

INSERT INTO Event VALUES
('E901', 'S002', 'P214', '2022-07-20', 1),
('E902', 'S003', 'P213', '2022-07-22', 5),
('E903', 'S001', 'P216', '2022-07-17', 2),
('E904', 'S005', 'P215', '2022-07-15', 1),
('E905', 'S007', 'P211', '2022-07-15', 6),
('E906', 'S002', 'P214', '2022-07-21', 1),
('E907', 'S007', 'P218', '2022-07-22', 6),
('E908', 'S001', 'P214', '2022-07-17', 2),
('E909', 'S001', 'P218', '2022-07-19', 1);

-- --------------------------------------------------------
-- QUERIES
-- --------------------------------------------------------

-- 1. Earliest event date where number of attempts was under 3
SELECT eventid, eventdate 
FROM Event
WHERE eventdate = (
    SELECT MIN(eventdate) 
    FROM Event 
    WHERE noofattempts < 3
);

-- 2. List all sports with individual attempt records
SELECT s.sportid, e.noofattempts AS max
FROM Sport s
LEFT JOIN Event e ON s.sportid = e.sportid;

-- 3. Maximum attempts for Athletics sport and placeholder (0) for unplayed Athletics sport
SELECT s.sportid, MAX(e.noofattempts) AS max
FROM Sport s
LEFT JOIN Event e ON s.sportid = e.sportid
WHERE s.sporttype = 'Athletics'
GROUP BY s.sportid
HAVING max IS NOT NULL
UNION
SELECT MIN(s.sportid) AS sportid, COALESCE(e.noofattempts, 0) AS max
FROM Sport s
LEFT JOIN Event e ON s.sportid = e.sportid
WHERE e.noofattempts IS NULL AND s.sporttype = 'Athletics';
