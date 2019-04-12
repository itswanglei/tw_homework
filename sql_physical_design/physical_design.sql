CREATE DATABASE student_examination_sys 
DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE student_examination_sys;

CREATE TABLE student (
	PRIMARY KEY (id),
    id INT AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE subject (
	PRIMARY KEY (id),
    id INT AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    teacher VARCHAR(50) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE score (
	PRIMARY KEY (id),
    id INT AUTO_INCREMENT,
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    score_value FLOAT
) ENGINE = InnoDB DEFAULT CHARSET = utf8;