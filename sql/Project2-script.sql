select * from customer;
select * from species;
select * from breed;
select * from pet;
select * from application;
select * from employee;

alter table pet add column name varchar;

create table customer(
id serial primary key,
fname varchar,
lname varchar,
username varchar,
password varchar,
information varchar);

create table species(
id serial primary key,
sName varchar);

create table breed(
id serial primary key,
bName varchar);

create table pet(
id serial primary key,
sId int references species(id),
bId int references breed(id),
size varchar,
age int,
gender varchar,
price float,
available boolean,
image bytea);

create table application(
id serial primary key,
pId int references pet(id),
cId int references customer(id),
subDate date,
bSupApproval boolean,
secondApproval boolean,
status varchar);

create table employee(
id serial primary key,
fname varchar,
lname varchar,
username varchar,
password varchar,
sId int references species(id));

