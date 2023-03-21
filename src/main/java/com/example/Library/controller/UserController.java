package com.example.Library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Library.entity.Users;
import com.example.Library.repository.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private User user;
	
	@PostMapping
	public Users save(@RequestBody Users users) {
		return user.save(users);
	}
	
	@GetMapping
	public List<Users> display(){
		return user.display();
	}
	
	@GetMapping("/{id}")
	public Users displayOne(@PathVariable int id){
		return user.displayOne(id);
	}
	
	@PutMapping("/{id}")
	public Users update(@PathVariable int id, @RequestBody Users users) {
		return user.update(id, users);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return user.delete(id);
	}
}
