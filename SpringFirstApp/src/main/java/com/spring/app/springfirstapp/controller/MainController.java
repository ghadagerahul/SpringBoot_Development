package com.spring.app.springfirstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.spring.app.springfirstapp.entity.UserEntity;
import com.spring.app.springfirstapp.model.UserLogin;
import com.spring.app.springfirstapp.repo.UsersRepo;
import com.spring.app.springfirstapp.serviceImpl.UserRepoImpl;

@Controller
public class MainController {

	@Autowired
	private UserRepoImpl repo;
	
    @RequestMapping("/wel")
    public String welcomeMethod(Model model){

     model.addAttribute("userForm", new UserLogin());
    
        
        return "login.html";

    }
    
    @RequestMapping(path = "/authenticate", method = RequestMethod.POST)
	public String authenticateMethod(@ModelAttribute UserEntity user, Model model) {

		System.out.println(user.toString());
		System.out.println("========== Submitted Resp==========");
		model.addAttribute("nameuser", user.getUsername());
		
		repo.saveUsersRepo(user);
		model.addAttribute("message", "mainMethod() Exicuted...........!!!");
		System.out.println("mainMethod() Exicuted...........!!!");
		return "done.html";

	}
  
    
    public  void mainMethod() {
    	
    	UserEntity entity = new UserEntity();
    	entity.setUsername("Rahul");
    	entity.setEmail("rahul@gmail.com");
    	entity.setMobileNo("2334434334");
    	entity.setPassword("myapp.123");
    	
    	
    	
    	
    }
    
    
}
