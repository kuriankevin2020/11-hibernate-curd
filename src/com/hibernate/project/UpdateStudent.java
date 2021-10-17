package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {

		Student student = new Student("Kurian", "Kevin", "kuriankevin@gmail.com");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();

			// update1
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student myStudent = session.get(Student.class, student.getId());
			myStudent.setFirstName("Luffy");
			session.getTransaction().commit();

			// update2
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}
}
