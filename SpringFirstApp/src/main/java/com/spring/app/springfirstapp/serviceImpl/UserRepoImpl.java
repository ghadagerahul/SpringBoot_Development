package com.spring.app.springfirstapp.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.springfirstapp.entity.UserEntity;
import com.spring.app.springfirstapp.model.UserLogin;
import com.spring.app.springfirstapp.repo.UsersRepo;

import antlr.collections.List;

@Service
public class UserRepoImpl {

	@Autowired
	private UsersRepo userRepo;
	
	public UserEntity saveUsersRepo(UserEntity user) {
		return userRepo.save(user);
	}
	
	public UserEntity getbyusernameEntity(String userName) throws Exception {
		Optional<UserEntity> data =userRepo.findById(userName);
		return data.isPresent()?data.get():null;
	}
}
