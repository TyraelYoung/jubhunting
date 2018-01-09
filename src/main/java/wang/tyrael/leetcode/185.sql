create table Employee(
    Id int,
    Name varchar(20),
    Salary int,
    DepartmentId int
);
create table Department(
    Id int,
    Name varchar(20)
);
insert into Employee values (1, 'Joe', 70000 ,1);
insert into Employee values (2, 'Henry', 80000   ,2);
insert into Employee values (3, 'Sam   ', 60000   ,2);
insert into Employee values (4, 'Max   ', 90000   ,1);
insert into Employee values (5, 'Janet ', 69000   ,1);
insert into Employee values (6, 'Randy ', 85000   ,1);

insert into Department values (1, 'IT');
insert into Department values (2, 'Sales');

# 直接的思路是子查询、in、limit
# mysql不支持，则转化为count，模拟实现limit
SELECT
	d. NAME AS Department,
	e1. NAME AS Employee,
	Salary
FROM
	Employee as e1
INNER JOIN Department AS d ON e1.DepartmentId = d.Id
where 3 >=
(
	SELECT count(DISTINCT
		e2.Salary
	)
	FROM
		Employee e2
	WHERE e2.Salary >= e1.Salary and e2.DepartmentId = e1.DepartmentId
)
ORDER BY Department, Salary desc

