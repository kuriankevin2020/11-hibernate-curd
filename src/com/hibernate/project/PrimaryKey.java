package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

// NOTE:
// Q: How to change the starting index of AUTO_INCREMENT value?
// CMD: ALTER TABLE hb_student_tracker.student AUTO_INCREMENT=3000;
// Q:  How to reset the AUTO_INCREMENT value / delete all raws in table
// CMD: TRUNCATE hb_student_tracker.student;

public class PrimaryKey {

	public static void main(String[] args) {

		Student student1 = new Student("Kurian", "Kevin", "kuriankevin@gmail.com");
		Student student2 = new Student("David", "Augustine", "davidaugustine@gmail.com");
		Student student3 = new Student("Deva", "Gopu", "devagopu@luv2code.com");
		Student student4 = new Student("Vineeth", "Neelan", "vineethneelan@luv2code.com");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {

			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.save(student4);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}
}
