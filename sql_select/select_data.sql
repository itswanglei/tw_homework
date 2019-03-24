SHOW DATABASES;
USE student_examination_sys;

CREATE TABLE student_infor (
	id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    subject VARCHAR(100) NOT NULL,
    score INT NOT NULL
);
DESCRIBE student_infor;

INSERT INTO student_infor VALUES 
	('1', '张三', '语文', '80'), 
    ('2', '李四', '语文', '90');

INSERT INTO student_infor VALUES
	('3', '王五', '语文', '60'),
    ('4', '王胖子', '数学', '59');
    
ALTER TABLE student_infor MODIFY score DOUBLE NOT NULL;

INSERT INTO student_infor VALUES
	('5', '张王五', '英语', '59.9'),
    ('6', '吴彦祖', '英语', '99.9'),
    ('7', '郭德纲', '数学', '100'),
    ('8', '郭敬明', '数学', '99'),
    ('9', '郭靖', '英语', '70');
    
SELECT name, score FROM student_infor WHERE subject = '语文';

SELECT name, score FROM student_infor WHERE subject = '语文' ORDER BY score DESC;

SELECT name FROM student_infor WHERE subject = '语文' ORDER BY score DESC LIMIT 1;

SELECT name FROM student_infor WHERE name LIKE '郭%' AND subject = '数学' ORDER BY score DESC LIMIT 1;

SELECT name, score FROM student_infor WHERE name LIKE '_王%';