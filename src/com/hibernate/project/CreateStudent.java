package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {

		// create a student object
		Student student = new Student("Kurian", "Kevin", "kuriankevin@gmail.com");

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {

			// create session
			Session session = factory.getCurrentSession();

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(student);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}
}
