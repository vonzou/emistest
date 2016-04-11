package net.emis.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.emis.demo.dao.UserMapper;
import net.emis.demo.model.User;
import net.emis.demo.service.UserServiceI;
import net.emis.util.StringUtil;

@Service("userService")
public class UserServiceImpl implements UserServiceI{

	private static Logger log = Logger.getLogger(UserServiceImpl.class);
	
	private UserMapper userMapper;
	
	@Autowired
	public void setUserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public int addUser(User u) {
		String uuid = StringUtil.uuid();
		u.setUuid(uuid);
		return userMapper.insert(u);
	}

	@Override
	public User findUserByPK(String uuid) {
		return userMapper.selectByPrimaryKey(uuid);
	}

	@Override
	public int delUserByPK(String uuid) {
		return userMapper.deleteByPrimaryKey(uuid);
	}

	@Override
	public List<User> findUserByName(String username) {
		// TODO Auto-generated method stub
		log.debug("username : " + username);
		return userMapper.selectByName(username);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userMapper.selectAllUsers();
	}

}
