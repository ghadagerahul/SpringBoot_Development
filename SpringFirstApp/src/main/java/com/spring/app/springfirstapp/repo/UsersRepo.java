package com.spring.app.springfirstapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.spring.app.springfirstapp.entity.UserEntity;
import com.spring.app.springfirstapp.model.UserLogin;

@Repository
@EnableJpaRepositories
public interface UsersRepo extends JpaRepository<UserEntity, String> {

	

}
