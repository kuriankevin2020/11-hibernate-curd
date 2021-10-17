package com.hibernate.project;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

public class QueryStudent {

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

			// start a transaction
			session = factory.getCurrentSession();
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
			theStudents = session.createQuery("from Student s where s.email" + " LIKE '%luv2code.com'").getResultList();
			System.out.println("\nStudents where email ends with luv2code.com ");
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student theStudent : theStudents) {
			System.out.println(theStudent);
		}
	}
}
