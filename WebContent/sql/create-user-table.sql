CREATE DATABASE 'demo';
USE demo;

create table Employee(
	id  int(3) NOT NULL AUTO_INCREMENT,
	emp_name varchar(120) NOT NULL,
	emp_email varchar(220) NOT NULL,
	emp_dept varchar(120),
	PRIMARY KEY (id)
);

