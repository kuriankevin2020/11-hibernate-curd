package com.hibernate.project;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

public class QueryStudent {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query1
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			System.out.println("\nList of all students");
			displayStudents(theStudents);

			// query2
			theStudents = session.createQuery("from Student s where s.lastName='Kevin'").getResultList();
			System.out.println("\nStudents who have last name of Kevin");
			displayStudents(theStudents);

			// query3
			theStudents = session.createQuery("from Student s where s.lastName='Kevin'" + " OR s.firstName='Deva'")
					.getResultList();
			System.out.println("\nStudents who have last name as Kevin or first name as Deva");
			displayStudents(theStudents);

			// query4
			theStudents = session.createQuery("from Student s where s.email" + " LIKE '%@gmail.com'").getResultList();
			System.out.println("\nStudents where email ends with @gmail.com");
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit();

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student theStudent : theStudents) {
			System.out.println(theStudent);
		}
	}
}
