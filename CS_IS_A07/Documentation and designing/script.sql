Drop if exist EmpRegistration_db;
Create Database ER_db;
use ER_db;
create table EmpRegistration (
EmpId			int			  primary key	auto_Increment,
FirstName		varchar(32)	  not null,
LastName		varchar(32)	  ,
FatherName	    varchar(32)	  not null,
DOB			    Date		  not null,
Gender		    varchar(10)   not null,
DepFkId         int			  not null,
Email		    varchar(64)	  unique,
Phone		    varchar(32)	  not null unique,
MainProvince    varchar(32)   not null,
MainDestrict	varchar(32)   not null,
MainVillage		varchar(32)   not null,
TempProvince	varchar(32)   not null,
TemDestrict		varchar(32)   not null,
TempVillage     varchar(32)   not null,
Salary		    int			  not null,
Contract	    varchar(64)   not null,
HireDate		Date		  not null
);
create table Department (
depId           int primary key,
DeptName        varchar(50)	  not null unique,
Deptmanager     varchar(30)  
);

alter table EmpRegistration ADD foreign key (DepFkId) REFERENCES Department(depId) 
