package com.spring.app.springfirstapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.springfirstapp.entity.UserEntity;
import com.spring.app.springfirstapp.model.UserLogin;
import com.spring.app.springfirstapp.repo.UsersRepo;

@Service
public class UserRepoImpl {

	@Autowired
	private UsersRepo userRepo;
	
	public UserEntity saveUsersRepo(UserEntity user) {
		return userRepo.save(user);
	}
}
