package com.tuto.ProjectWithMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println(factory);
		System.out.println(factory.isClosed());
		Student std = new Student(119, "Manish", "Dehradun");
		FileInputStream fis=new FileInputStream("src/main/java/pic.png");
		byte[] image=new byte[fis.available()];
		
		Address addr=new Address("Silicon", "Noida", true, 1.88, new Date(), image );
		System.out.println(std);
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(std);
		session.save(addr);
		session.getTransaction().commit();
		session.close();
		
		
		System.out.println("Done...!");

	}
}
