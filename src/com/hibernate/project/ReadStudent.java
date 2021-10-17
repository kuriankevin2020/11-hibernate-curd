package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {

		Student student = new Student("Kurian", "Kevin", "kuriankevin@gmail.com");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {

			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();

			// find out the students id: primary key
			System.out.println("Saved student. Generated Id: " + student.getId());

			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on student id
			Student myStudent = session.get(Student.class, student.getId());
			System.out.println("Student: " + myStudent);

			// commit the transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}
}
