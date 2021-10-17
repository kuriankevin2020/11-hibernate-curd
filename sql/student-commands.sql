/* display complete content of student table */
SELECT * FROM hb_student_tracker.student;

/* delete complete content of student table */
TRUNCATE hb_student_tracker.student;

/* provide the starting index for primary key */
ALTER TABLE hb_student_tracker.student AUTO_INCREMENT=10001;