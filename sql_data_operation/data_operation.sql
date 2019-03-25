CREATE TABLE student (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    sex CHAR(1) NOT NULL
);

INSERT INTO student(name, age, sex)
VALUES
	('张三', 18, '女'),
    ('李四', 20, '男'),
    ('王五', 20, '女');
    
UPDATE student 
SET 
	name = '小花', 
	sex = '女' 
WHERE id = '1';

DELETE FROM student WHERE age = '20' AND sex = '女';



SELECT * FROM student;

DROP TABLE student;