USE music_project;

CREATE TABLE student_login(
	rel_idstudent		INT,
    login				varchar(50),
    user_password		varchar(64),
    
    CONSTRAINT fk_rel_ids FOREIGN KEY(rel_idstudent) REFERENCES student(idstudent),
    CONSTRAINT pk_rel_stu_log PRIMARY KEY(rel_idstudent, login)
);

ALTER TABLE student_login
	DROP COLUMN user_password;