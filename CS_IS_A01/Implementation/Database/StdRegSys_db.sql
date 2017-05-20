 
 drop database  if exists StdRegSys_db ;
 create database StdRegSys_db character set utf8 collate utf8_persian_ci;
 use StdRegSys_db;
 
 CREATE TABLE NewStudent_tbl (
 NewStdId		BigInt Auto_Increment PRIMARY key,
 Name 			varchar(30)	    NOT NULL,
 FName			varchar(30)	    NOT NULL,
 GFName 		varchar(30) 	NOT NULL,
 DOB			int			    Not NULL,
 Nationality	varchar(15),
 NLang			varchar(15),
 Clas			int				Not NULL,
 Phone			varchar(15) 	UNIQUE,
 Status			varchar(10),
 Cas			VARCHAR(10),
 Gender			varchar(8),
 DOA			DATE			NOT NULL,
 Position		varchar(20)		DEFAULT 'برحاله'
 );
 
 CREATE TABLE SSN_tbl (
 NewStdId	BigInt	PRIMARY key,
 SSNNO		BigInt	NOT NULL,
 VolumNO	int,
 SNO		int,
 FOREIGN key(NewStdId) references NEWStudent_tbl(NewStdId) on UPDATE CASCADE on DELETE CASCADE
 );

 CREATE TABLE Relative_tbl (
 NewStdId	BigInt		PRIMARY KEY,
 Brother	varchar(30),
 Unlce		varchar(30),
 MUncle		varchar(30),
 UncleSon	varchar(30),
 MUncleSon	varchar(30),
 FOREIGN key(NewStdId) references NEWStudent_tbl(NewStdId) on UPDATE CASCADE on DELETE CASCADE
 );
 
 CREATE TABLE StdTempAddress_tbl (
 NewStdId	BigInt		primary key,
 TProvince 	varchar(20),
 TDistrict	varchar(25),
 TVillage	varchar(25),
 FOREIGN key(NewStdId) references NEWStudent_tbl(NewStdId) on UPDATE CASCADE on DELETE CASCADE
 );
 
 CREATE TABLE StdPerAddress_tbl (
 NewStdId	BigInt		primary key,
 Province 	varchar(20),
 District	varchar(25),
 Village	varchar(25),
 FOREIGN key(NewStdId) references NEWStudent_tbl(NewStdId) on UPDATE CASCADE on DELETE CASCADE
 );
 
 CREATE TABLE IncomeStudent_tbl (
 InStdId		BigInt			primary key,
 SchoolName		varchar(50)		NOT NULL,
 FOREIGN key(InStdId) references NEWStudent_tbl(NewStdId) on UPDATE CASCADE on DELETE CASCADE
 );
 
 CREATE TABLE IncomeLetter_tbl (
 InStdId		BigInt	PRIMARY KEY,
 LetterNo		int		NOT NULL UNIQUE,
 LetterDate		varchar(10)	NOT NULL,
 FOREIGN key(InStdId) references IncomeStudent_tbl(InStdId) on UPDATE CASCADE on DELETE CASCADE
 );
 
 CREATE TABLE IncomeStdSchoolAddress_tbl (
 InStdId		BigInt		PRIMARY key,
 Province		varchar(20),
 District		varchar(25),
 FOREIGN key(InStdId) references IncomeStudent_tbl(InStdId) on UPDATE CASCADE on DELETE CASCADE
 );
 
 CREATE TABLE OutcomeStudent_tbl (
 OutStdId		BigInt			primary key,
 NewSchoolName	Varchar(50)		NOT NULL,
 NewClass		int				Not NULL,
 Reason			varchar(255)	Not NULL,
 OutDate		DATE,
 FOREIGN key(OutStdId) references NEWStudent_tbl(NewStdId) on UPDATE CASCADE on DELETE CASCADE
 );
 
 CREATE TABLE OutcomeLetter_tbl (
 OutStdId		BigInt	PRIMARY KEY,
 LetterNo		int		Not NULL UNIQUE,
 LetterDate	 	Varchar(10)	Not Null,
 FOREIGN key(OutStdId) references OutcomeStudent_tbl(OutStdId) on UPDATE CASCADE on DELETE CASCADE
 );
 
 CREATE TABLE OutcomeNewSchoolAddress_tbl (
 OutStdId		BigInt		PRIMARY key,
 Province		varchar(20),
 District		varchar(25),
 FOREIGN key(OutStdId) references OutcomeStudent_tbl(OutStdId) on UPDATE CASCADE on DELETE CASCADE
 );
 
 CREATE TABLE User_tbl (
 UserId		int			primary key Auto_Increment,
 UserName	varchar(30)	Not NULL UNIQUE,
 UserLevel	varchar(20),
 Password	varchar(15) Not Null UNIQUE
 );

 