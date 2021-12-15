package com.tuto.fetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("com/tuto/fetch/hibernate.cfg.xml").buildSessionFactory();
		System.out.println(factory);
		System.out.println(factory.isClosed());
		
		Session session=factory.openSession();
		//get method : 119
		Student std1 = (Student) session.get(Student.class, 119);
		System.out.println(std1);
		
		//load method : 119
		
//		Student std2=(Student)session.load(Student.class, 119);
//		System.out.println(std2);
				
		session.close();
		factory.close();
	}

}
