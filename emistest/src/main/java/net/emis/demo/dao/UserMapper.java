package net.emis.demo.dao;

import java.util.List;

import net.emis.demo.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uuid);
    
    List<User> selectByName(String username);
    
    List<User> selectAllUsers();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}