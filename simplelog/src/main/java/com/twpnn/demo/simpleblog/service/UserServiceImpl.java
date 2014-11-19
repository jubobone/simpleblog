package com.twpnn.demo.simpleblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twpnn.demo.simpleblog.dao.UserDao;
import com.twpnn.demo.simpleblog.model.User;

@Service 
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User findById(Long id) throws Exception {
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() throws Exception {
		return userDao.findAll();
	}

	@Override
	public boolean save(User user) throws Exception {
		return userDao.save(user);
	}

	@Override
	public boolean update(User user) throws Exception {
		return userDao.update(user);
	}

	@Override
	public boolean delete(User user) throws Exception {
		return userDao.delete(user);
	}

	@Override
	public List<User> findByEmail(String email) throws Exception {
		return userDao.findByEmail(email);
	}

	@Override
	public List<User> findByUsername(String username) throws Exception {
		return userDao.findByUsername(username);
	}
}
