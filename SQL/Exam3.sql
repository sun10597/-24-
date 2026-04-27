SELECT * FROM hr.departments;

select * from jobs;

desc emp;

show tables;

desc emp;

select *from emp where sal > 2800;
select * from emp where job="MANAGER" and sal > 2800;

select distinct * from emp

select * from emp where deptno in (10,20);

create table A(name int);
create table B(name int);

insert into A values (1),(2),(3);
insert into B values (2),(3),(4);

select name from a
union
select name from b;

select id, name, email, password from member