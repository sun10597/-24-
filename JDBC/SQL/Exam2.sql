
create table book (
	id bigint auto_increment primary key,
    title varchar(200) not null,
    author varchar(100) not null,
    publisher varchar(100),
    isbn varchar(20) unique,
    price int not null,
    published_date date,
    create_at timestamp default now()
);

drop table member;
create table member(
 id bigint auto_increment primary key,
 name varchar(255) not null,
 email varchar(255) unique not null,
 password varchar(255) not null,
 created_at timestamp default CURRENT_TIMESTAMP,
 update_at timestamp default Current_timestamp ON UPDATE CURRENT_TIMESTAMP
 );
 
 select * from member;
insert into member(name, email, password) values("김선우", "qwer@gmail.com", "qwer1234");
insert into member(name, email, password) values ("kang", "carami@naver.com", "1111");
insert into member(name, email, password) values ("Kim", "123", "123");
 
 update member set email="qwer22@gmail.com" where name = "김선우";
 update member set name="kkk123" where email="123";
 
SELECT @@version;