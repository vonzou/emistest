package net.emis.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.emis.demo.model.User;
import net.emis.demo.service.UserServiceI;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/userController")
public class UserController {
	
	private static Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserServiceI userService;
	
	@RequestMapping("/showUser/{id}")
	public String showUser(@PathVariable String id, Model model,HttpServletResponse response){
		User user = userService.findUserByPK(id);
		String jsonStr = JSON.toJSONString(user);
		PrintWriter out = null;
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		try {
			out = response.getWriter();
			out.println(jsonStr);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("get Writer IO异常");
			e.printStackTrace();
		} finally {
			if(out != null){
				out.close();
			}
		}
		return "demo/showUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user, Model model){
		log.debug("前端提交的user数据："+ JSON.toJSONString(user));
		/*
		boolean isSucc = userService.addUser(user) > 0;
		if(isSucc){
			model.addAttribute("addResult", "添加用户成功");
		} else {
			model.addAttribute("addResult", "添加用户失败");
		}*/
		List<User> userList = userService.findUserByName(user.getUsername());
		log.debug("查找到的信息： " + JSON.toJSONString(userList));
		if(userList == null || userList.size() <= 0){
			int i = userService.addUser(user);
			log.debug("执行添加结果：i = " + i);
			if(i > 0){
				log.debug(" 添加新用户成功 " + JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss"));
			} else {
				log.debug(" 添加新用户失败 " + JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss"));
			}
		} else {
			log.debug("else 查找到的用户信息：" + JSON.toJSONString(userList));
			log.debug("else 该用户已存在，不可重复添加！");
		}	
		return "demo/showUser";
	}
	
	@RequestMapping("/listAllUsers")
	public String getUserList(HttpServletResponse response){
		List<User> uList = userService.getAllUsers();
		log.debug("取到的所有用户信息: " + JSON.toJSONString(uList));
		String u2Json = JSON.toJSONString(uList);
		PrintWriter out = null;
		response.setCharacterEncoding("utf-8");
		response.setContentType("appliction/json");
		try {
			out = response.getWriter();
			out.println(u2Json);
			out.flush();
		} catch (IOException e) {
			log.error("getWriter异常！");
		} finally {
			if(out != null){
				out.close();
			}
		}
		return "demo/showUser";
	}
	
	@RequestMapping("/deleteUserById/{id}")
	public String deleteUserByPK(@PathVariable String id, HttpServletResponse response){
		boolean isSucc = userService.delUserByPK(id) > 0;
		
		return "demo/showUser";
	}
}
