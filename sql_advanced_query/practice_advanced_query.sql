CREATE DATABASE student_examination_sys
DEFAULT
	CHARSET utf8
    COLLATE utf8_general_ci;
    
USE student_examination_sys;

CREATE TABLE student (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    sex CHAR(1) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO student(name, age, sex)
VALUES
	('张三', '18', '男'),
    ('李四', '20', '女');
    
CREATE TABLE subject (
	id INT PRIMARY KEY NOT NULL,
    subject VARCHAR(100) NOT NULL,
    teacher VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO subject
VALUES
	('1001', '语文', '王老师', '本次考试比较简单'),
    ('1002', '数学', '刘老师', '本次考试比较难');
    
CREATE TABLE score (
	id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    score DOUBLE NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO score(student_id, subject_id, score)
VALUES
	('1', '1001', '80'),
    ('2', '1001', '60'),
    ('1', '1002', '70'),
    ('2', '1002', '60.5');
    
SELECT MAX(score) AS highestScore
FROM score
WHERE subject_id = (
	SELECT id
    FROM subject
    WHERE subject = '语文'
);

SELECT
	subject,
    MAX(score) AS highestScore
FROM score
INNER JOIN subject ON subject_id = subject.id
GROUP BY subject
HAVING subject = '语文';

SELECT AVG(score) AS averageScore
FROM score
WHERE subject_id = (
	SELECT id
    FROM subject
    WHERE subject = '语文'
)
UNION
SELECT AVG(score) AS averageScore
FROM score;

SELECT score 
FROM score
WHERE subject_id = (
	SELECT id
    FROM subject
    WHERE subject = '数学'
) AND student_id = (
	SELECT id
    FROM student
    WHERE name = '张三'
);

SELECT
	name,
    subject,
    score
FROM student
INNER JOIN score ON student_id = student.id
INNER JOIN subject ON subject_id = subject.id
WHERE name = '张三' AND subject = '数学';

SELECT 
	AVG(score) AS averageScore, 
    MAX(score) AS highestScore
FROM score
WHERE subject_id = (
	SELECT id
    FROM subject
    WHERE teacher = '刘老师'
);

SELECT
	teacher,
    subject,
	AVG(score) AS averageScore,
    MAX(score) AS highestScore
FROM score
INNER JOIN subject ON subject_id = subject.id
GROUP BY teacher
HAVING teacher = '刘老师';

SELECT 
	sex,
    AVG(score) AS averageScore
FROM score
INNER JOIN student ON student_id = student.id
GROUP BY sex;
