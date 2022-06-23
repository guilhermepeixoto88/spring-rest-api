package com.github.rest.webservices.springrestapi.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping(path="/users")
	public List<User> listAll(){
		return userDao.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User findById(@PathVariable Integer id) {
		return userDao.findOne(id);
	}
	
}
