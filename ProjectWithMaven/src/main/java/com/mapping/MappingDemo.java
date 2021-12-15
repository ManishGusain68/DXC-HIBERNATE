package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("com/mapping/hibernate.cfg.xml").buildSessionFactory();

		// creating question

		Question q1 = new Question();
		q1.setQuestionid(1);
		q1.setQuestion("What is Java");
		Answer a1 = new Answer();
		a1.setAnswerId(4);
		a1.setAnswer("Object oriented Programming");
		a1.setQuestion(q1);
		q1.setAnswer(a1);

		Question q2 = new Question();
		q2.setQuestionid(2);
		q2.setQuestion("What is Collection Framework");
		Answer a2 = new Answer();
		a2.setAnswerId(8);
		a2.setAnswer("Its an API to work with object in Java");
		a2.setQuestion(q2);
		q2.setAnswer(a2);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(q1);
		session.save(q2);
		session.save(new Answer(4, "Object oriented Programming", q1));
		session.save(new Answer(8, "Its an API to work with object in Java", q2));
		tx.commit();
		
		Question ques1=(Question)session.get(Question.class, 1);
		System.out.println(ques1);
		session.close();
		factory.close();
	}

}
