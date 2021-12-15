package com.tuto.fetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("com/tuto/fetch/hibernate.cfg.xml")
				.buildSessionFactory();
		Student std1 = new Student(111, "Manish", "Noida", new Certificate("Java", "Three"));
		Student std2 = new Student(100, "Sanjeeta", "Delhi", new Certificate("Patents", "Four"));

		Session s = factory.openSession();
		
		s.save(std1);
		s.save(std2);
		Transaction tx = s.beginTransaction();
		tx.commit();
		s.close();
		factory.close();

	}

}
