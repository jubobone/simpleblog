package com.twpnn.demo.simpleblog.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.twpnn.demo.simpleblog.model.User;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	protected static Logger logger = Logger.getLogger("MemberDaoImpl");

	protected Session session;

	@Autowired
	public void setDummySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		session = this.getHibernateTemplate().getSessionFactory().openSession();
	}

	@Override
	public User findById(Long id) throws Exception {
		User user = this.getHibernateTemplate().get(User.class, id);
		return user;
	}

	@Override
	public List<User> findAll() throws Exception {
		List<User> userList = session.createCriteria(User.class).list(); 
		session.flush(); // update latest session
		session.clear(); // clear current session once get data from latest
							// session
		return userList;
	}

	@Override
	public boolean save(User user) throws Exception {
		this.getHibernateTemplate().saveOrUpdate(user);
		return true;
	}

	@Override
	public boolean update(User user) throws Exception {
		this.getHibernateTemplate().update(user);
		return true;
	}

	@Override
	public boolean delete(User user) throws Exception {
		this.getHibernateTemplate().delete(user);
		return true;
	}

	@Override
	public List<User> findByEmail(String email) throws Exception {
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>)this.getHibernateTemplate().find("FROM User u WHERE u.email = ?", email);
        return userList;
    }

	@Override
	public List<User>  findByUsername(String username) throws Exception {
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>)this.getHibernateTemplate().find("FROM user u WHERE u.username = ?", username);
        return userList;
	}

}
