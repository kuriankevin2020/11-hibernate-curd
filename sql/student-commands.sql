/* display complete content of student table */
SELECT * FROM hb_student_tracker.student;

/* delete complete content of student table */
TRUNCATE hb_student_tracker.student;

/* provide the starting index for primary key */
ALTER TABLE hb_student_tracker.student AUTO_INCREMENT=10001;

/* delete linked table data */
 SET FOREIGN_KEY_CHECKS = 0;
 TRUNCATE `hb-01-one-to-one-uni`.instructor_detail;
 SET FOREIGN_KEY_CHECKS = 1;
 
 /* show table structure */
  DESC `hb-01-one-to-one-uni`.instructor_detail;