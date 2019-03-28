CREATE VIEW student_subject_score AS
    SELECT 
        name, subject, score
    FROM
        student
			INNER JOIN
		score ON student.id = score.student_id
			INNER JOIN
		subject ON subject.id = score.subject_id;
        
SHOW CREATE VIEW student_subject_score;

SELECT * FROM student_subject_score;

DROP VIEW student_subject_score;

CREATE VIEW student_subject_score AS
	SELECT
		name, subject, teacher, score
	FROM
		student
			INNER JOIN
		score ON student.id = student_id
			INNER JOIN
		subject ON subject.id = subject_id;
        
SELECT * FROM student_subject_score;