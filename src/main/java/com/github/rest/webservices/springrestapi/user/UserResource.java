package com.github.rest.webservices.springrestapi.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User user = userDao.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id:".concat(id.toString()));
		}
		return user;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> create(@RequestBody User user) {
		User createdUser = userDao.save(user);
		
		URI uri = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(createdUser.getId())
			.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void delete(@PathVariable Integer id) {
		User user = userDao.delete(id);
		if(user == null) {
			throw new UserNotFoundException("id:".concat(id.toString()));
		}
	}
}
