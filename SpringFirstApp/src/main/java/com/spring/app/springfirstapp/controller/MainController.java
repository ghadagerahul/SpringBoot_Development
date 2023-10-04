package com.spring.app.springfirstapp.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.StringUtils;

import com.spring.app.springfirstapp.entity.UserEntity;
import com.spring.app.springfirstapp.serviceImpl.UserRepoImpl;

@Controller
public class MainController {

	@Autowired
	private UserRepoImpl repo;

	Logger logHelper = LoggerFactory.getLogger(MainController.class);

// Registration user : start..............................
	@RequestMapping("/Register")
	public String welcomeMethod(Model model) {

		model.addAttribute("userForm", new UserEntity());

		return "register.html";

	}

	@RequestMapping(path = "/authenticate", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute UserEntity user, Model model) {

		System.out.println(user.toString());
		System.out.println("========== Submitted Resp ==========");
		model.addAttribute("nameuser", user.getUsername());

		repo.saveUsersRepo(user);
		model.addAttribute("message", "mainMethod() Exicuted...........!!!");
		System.out.println("mainMethod() Exicuted...........!!!");
		return "done.html";

	}
// Registration user : end...........................

// Login User:Start..................................
	@RequestMapping("login")
	public String loginUser(Model model) {

		model.addAttribute("userForm1", new UserEntity());

		return "login.html";
	}

	@RequestMapping("/authenticateLogin")
	public String authenticateLoginUser(@ModelAttribute UserEntity user, Model model) throws NullPointerException {

		String username = user.getUsername();
		String password = user.getPassword();
		UserEntity list = new UserEntity();

		
		
		if (!StringUtils.isEmpty(username)) {
			try {
				list = repo.getbyusernameEntity(username);
				if(list == null) {
					model.addAttribute("invalidPass", "User is Not Registered...!!!");
					return "loginError.html";
				}
			} catch (Exception e) {
				logHelper.info(e.getMessage());
				model.addAttribute("invalidPass", "User is Not Registered...!!!");
				return "loginError.html";
			}
			System.out.println(list.toString());

			if (StringUtils.equalsIgnoreCase(password, list.getPassword())) {
				return "dashboard.html";
			}
			model.addAttribute("invalidPass", "Invalid Usename / Password...!!!");
			return "loginError.html";

		} else {
			logHelper.info("UserNmae in null ....!!!!!!!!");
			model.addAttribute("errorMessage", "Please Enter UserName.");
		}
		System.out.println(list.toString());

		return "loginError.html";
	}
// Login User:End.........................................

}
