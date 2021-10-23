package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {

		// create a student object
		Student student1 = new Student("Kurian", "Kevin", "kuriankevin@gmail.com");
		Student student2 = new Student("David", "Augustine", "davidaugustine@gmail.com");
		Student student3 = new Student("Deva", "Gopu", "devagopu@luv2code.com");
		Student student4 = new Student("Vineeth", "Neelan", "vineethneelan@luv2code.com");

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.save(student4);

			// commit transaction
			session.getTransaction().commit();

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}
