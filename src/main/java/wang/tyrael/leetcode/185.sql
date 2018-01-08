create table Employee{
    Id int,
    Name varchar(20),
    Salary int,
    DepartmentId int
};
create table Name{
    Id int,
    Name varchar(20)
};
insert into Employee values (1, 'Joe', 70000 ,1);
insert into Employee values (2, 'Henry', 80000   ,2);
insert into Employee values (3, 'Sam   ', 60000   ,2);
insert into Employee values (4, 'Max   ', 90000   ,1);
insert into Employee values (5, 'Janet ', 69000   ,1);
insert into Employee values (6, 'Randy ', 85000   ,1);

insert into Department values (1, 'IT');
insert into Department values (2, 'Sales');

select Department.Name as Department, Employee.Name as Employee, Salary
from Employee, Department
where Employee.id in(
    select Employee.Id
    from Employee
    where DepartmentId in(select Id from Department)
    orderBy Salary
    limit 3,1
)
