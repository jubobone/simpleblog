package com.twpnn.demo.simpleblog.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.twpnn.demo.simpleblog.model.Greeting;

@Repository
public class GreetingDao {

	protected static Logger logger = Logger.getLogger("GreetingDao");

	@Autowired
	private SessionFactory sessionFactory;

	public List<Greeting> getAllGreetings() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("select g from Greeting g order by id desc");
		List<Greeting> greetingList = q.list();
		return greetingList;
	}

	public void addGreeting(Greeting greeting) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.save(greeting);
		trans.commit();
	}

}
