package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

public class GetStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int theId = 1;

			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on student id
			Student myStudent = session.get(Student.class, theId);
			System.out.println("Student: " + myStudent);

			session.getTransaction().commit();

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}
