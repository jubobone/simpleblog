package com.twpnn.demo.simpleblog.dao;

import java.util.List;

import com.twpnn.demo.simpleblog.model.User;

public interface UserDao {
	public User findById(Long id) throws Exception;
	public List<User> findAll() throws Exception;
	public boolean save(User user) throws Exception;
	public boolean update(User user) throws Exception;
	public boolean delete(User user) throws Exception;
	
	public List<User> findByEmail(String email) throws Exception;
	public List<User> findByUsername(String username) throws Exception;
}
