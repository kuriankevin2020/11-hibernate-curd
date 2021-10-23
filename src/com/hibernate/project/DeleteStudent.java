package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// delete1
			Student student1 = session.get(Student.class, 1);
			Student student2 = session.get(Student.class, 2);
			session.delete(student1);
			session.delete(student2);

			// delete2
			session.createQuery("delete Student where id=3").executeUpdate();
			session.createQuery("delete Student where id=4").executeUpdate();

			session.getTransaction().commit();

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}
