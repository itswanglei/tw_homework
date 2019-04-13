CREATE TABLE student (
	id int(11) NOT NULL,
    name varchar(50) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE teacher (
  id int(11) NOT NULL,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE subject (
  id int(11) NOT NULL,
  title varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE teaching_infor (
  id int(11) NOT NULL AUTO_INCREMENT,
  subject_id int(11) NOT NULL,
  teacher_id int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE student_score (
  id int(11) NOT NULL AUTO_INCREMENT,
  student_id int(11) NOT NULL,
  subject_id int(11) NOT NULL,
  score double DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
