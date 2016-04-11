package net.emis.demo.test;

import java.util.List;

import net.emis.demo.model.User;
import net.emis.demo.service.UserServiceI;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class UserServiceTest {
	private static Logger log = Logger.getLogger(UserServiceTest.class);
	
	@Autowired
	private UserServiceI userService;

	@Test
	public void testAddUser(){
		User u = new User();
		u.setAge(18);
		u.setPassword("1");
		u.setRealname("张三");
		u.setUsername("zhangsan");
		List<User> userList = userService.findUserByName(u.getUsername());
		log.debug("查找到的信息： " + JSON.toJSONString(userList));
		if(userList == null){
			int i = userService.addUser(u);
			log.debug("执行添加结果：i = " + i);
			if(i > 0){
				log.debug(" 添加新用户成功 " + JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
			} else {
				log.debug(" 添加新用户失败 " + JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
			}
		} else {
			log.debug("else 查找到的用户信息：" + JSON.toJSONString(userList));
			log.debug("else 该用户已存在，不可重复添加！");
		}	
		log.debug("查找到的用户信息：" + JSON.toJSONString(userList));
		log.debug("该用户已存在，不可重复添加！");
	}
	
	@Test
	public void getUserByPK(){
		User u = userService.findUserByPK("00373199-4897-428e-ba39-51bafcbe60fd");
		if(u != null){
			log.debug(" 查找用户成功 " + JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
		}
	}
}
