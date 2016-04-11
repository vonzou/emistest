package net.emis.demo.service;

import java.util.List;

import net.emis.demo.model.User;

public interface UserServiceI {
	
	public int addUser(User u);
	
	public int delUserByPK(String uuid);
	
	public User findUserByPK(String uuid);
	
	public List<User> findUserByName(String username);
	
	public List<User> getAllUsers();
}
