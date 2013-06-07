package com.camilolopes.readerweb.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.camilolopes.readerweb.exception.EmailException;
import com.camilolopes.readerweb.services.interfaces.LoginService;
@Controller
public class LoginController {
	@Autowired
	@Qualifier("loginServiceImpl")
	private LoginService loginService;
	private String email; 
	private String password;
	
	public String login(){
		String toPage = "/pages/caduser";
			try {
				loginService.authenticate(email, password);
			} catch (EmailException e) {
				addMessageFaceContext(e.getMessage());
				toPage = null;
			} catch (IllegalArgumentException e) {
				addMessageFaceContext(e.getMessage());
				toPage=null;
			}
		
		return toPage;
	}

	private void addMessageFaceContext(String msg) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg ,""));
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
