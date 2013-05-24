package com.camilolopes.readerweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.camilolopes.readerweb.model.bean.User;
import com.camilolopes.readerweb.services.interfaces.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userServiceImpl;
	
	private User user;

	private String description;

	private Long id;
	
	public UserController() {
		user = new User();
	}
	
	public void addEditUser(){
		userServiceImpl.saveOrUpdate(user);
	}
	
	public List<User> listAllUsers(){
		
		return userServiceImpl.readAll();
	}
	
	public List<User> searchUser(){
		
		return userServiceImpl.searchUser(description);
	}
	
	public void deleteUser(){
		userServiceImpl.delete(user);
	}
	
	public User searchUserById(){
		
		return userServiceImpl.searchById(id);
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
