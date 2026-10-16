-- SQL query to find employees who earn more than their department's average salary.
-- correlated subquery to calculate the average for each department dynamically.

SELECT 
    employee_id, 
    employee_name, 
    department_id, 
    salary
FROM 
    employees e
WHERE 
    salary > (
        SELECT 
            AVG(salary) 
        FROM 
            employees 
        WHERE 
            department_id = e.department_id
    );

-- Alternative Approach (Using Window Functions)
-- If your database supports window functions (like PostgreSQL, MySQL 8.0+, or SQL Server), you can use AVG() OVER inside a Common Table Expression (CTE) for better performance on large datasets:

WITH DepartmentAverage AS (
    SELECT 
        employee_id,
        employee_name,
        department_id,
        salary,
        AVG(salary) OVER(PARTITION BY department_id) as avg_dept_salary
    FROM 
        employees
)
SELECT 
    employee_id,
    employee_name,
    department_id,
    salary
FROM 
    DepartmentAverage
WHERE 
    salary > avg_dept_salary;

-- using inner join
-- This subquery calculates the average salary for each department once

SELECT 
    e.employee_id, 
    e.employee_name, 
    e.department_id, 
    e.salary
FROM 
    employees e
INNER JOIN (
    SELECT 
        department_id, 
        AVG(salary) AS avg_salary
    FROM 
        employees
    GROUP BY 
        department_id
) dept_avg 
ON e.department_id = dept_avg.department_id
WHERE 
    e.salary > dept_avg.avg_salary;
