CREATE DATABASE student_examination_sys DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
SHOW DATABASES;
USE student_examination_sys;
CREATE TABLE student (
	`id` INT NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `age` INT NOT NULL,
    `sex` VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SHOW TABLES;
DESCRIBE student;
INSERT INTO student VALUES ('001', '张三', '18', '男');
DESCRIBE student;
CREATE TABLE subject (
	`id` INT NOT NULL,
    `subject` VARCHAR(100) NOT NULL,
    `teacher` VARCHAR(100) NOT NULL,
    `description` VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SHOW TABLES;
DESCRIBE subject;
CREATE TABLE score (
	`id` INT NOT NULL,
    `student_id` INT NOT NULL,
    `subject_id` INT NOT NULL,
    `score` INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DESCRIBE score;
SHOW TABLES;