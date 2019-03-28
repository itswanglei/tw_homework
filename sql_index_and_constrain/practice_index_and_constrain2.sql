CREATE DATABASE student_managment_sys DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE student_managment_sys;

CREATE TABLE student (
	id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    birthday DATE,
    sex CHAR(1) NOT NULL,
    INDEX nameIndex (name(50))
);

CREATE INDEX nameIndex ON student(name(50));

ALTER TABLE student ADD INDEX nameIndex(name(50));

SHOW INDEX FROM student;
ALTER TABLE student DROP INDEX nameIndex;

DROP TABLE student;

CREATE TABLE student (
	id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    birthday DATE,
    sex CHAR(1) NOT NULL,
    UNIQUE idIndex (id)
);

CREATE UNIQUE INDEX idIndex ON student(id);

ALTER TABLE student ADD UNIQUE INDEX idIndex(id);

SHOW INDEX FROM student;
DROP INDEX idIndex ON student;

CREATE TABLE student (
	id INT,
    name VARCHAR(100) NOT NULL,
    birthday DATE,
    sex CHAR(1) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE student ADD PRIMARY KEY (id);

SHOW INDEX FROM student;
ALTER TABLE student DROP PRIMARY KEY;
