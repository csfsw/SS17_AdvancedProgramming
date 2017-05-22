create table manager(
managerId	 INT PRIMARY KEY AUTO_INCREMENT,
userName	VARCHAR(32)	NOT NULL,
password	VARCHAR(32)	NOT NULL
);
create table student(
sId		INT PRIMARY KEY	AUTO_INCREMENT,	
firstName	VARCHAR(32)	NOT NULL,
lastName	VARCHAR(32),
dob			YEAR NOT NULL,
email		varchar(32),
phone		varchar(32)
);
create table teacher(
tId		INT PRIMARY KEY	AUTO_INCREMENT,
managerId	INT		NOT NULL, 
firstName	VARCHAR(32) NOT NULL,
lastName	VARCHAR(32),
degree 		VARCHAR(16) NOT NULL,
salary		INT	NOT NULL,
email 		VARCHAR(32),
phone		VARCHAR(32),
CONSTRAINT managerId foreign key(managerId) references manager(managerId)
);

create table subject(
subId	INT PRIMARY KEY	AUTO_INCREMENT,
subName	VARCHAR(32)	NOT NULL
);

create table classes(
classId	INT PRIMARY KEY	AUTO_INCREMENT,
className	VARCHAR(32) NOT NULL
);

create table instruction(
insId	INT	PRIMARY KEY	AUTO_INCREMENT,
tId		INT 	NOT NULL,
subId	INT 	NOT NULL,
classId	INT 	NOT NULL,
sId		INT 	NOT NULL,
CONSTRAINT TeacherId foreign key(tId) references teacher(tId),
CONSTRAINT subjectId foreign key(subId) references subject(subId),
CONSTRAINT classId foreign key(classId) references classes(classId),
CONSTRAINT studentId foreign key(sId) references student(sId)
);
create table exam(
examId	INT PRIMARY KEY	AUTO_INCREMENT,
tId		INT 	NOT NULL,
sId		INT 	NOT NULL,
subId	INT 	NOT NULL,
examDate	DATE,
CONSTRAINT TeacherId foreign key(tId) references teacher(tId),
CONSTRAINT subjectId foreign key(subId) references subject(subId),
CONSTRAINT studentId foreign key(sId) references student(sId)
);

create table score(
scoreId	INT PRIMARY KEY AUTO_INCREMENT,
examId	INT 	NOT NULL,
sId		INT 	NOT NULL,
marks	TINYINT	NOT NULL
CONSTRAINT studentId foreign key(sId) references student(sId),
CONSTRAINT examId foreign key(examId) references exam(examId)
);

create table feePayment(
paymentId	INT PRIMARY KEY	AUTO_INCREMENT,	
sId		INT  NOT NULL,
subId	INT  NOT NULL,
managerId	INT  NOT NULL,
payAmount	INT NOT NULL,
payDate		DATE	NOT NULL
CONSTRAINT subjectId foreign key(subId) references subject(subId),
CONSTRAINT studentId foreign key(sId) references student(sId),
CONSTRAINT managerId foreign key(managerId) references manager(managerId)
);
