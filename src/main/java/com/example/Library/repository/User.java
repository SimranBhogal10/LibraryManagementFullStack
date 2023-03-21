package com.example.Library.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.Library.entity.Users;

@Repository
public class User {

	@Autowired
	public RedisTemplate template;
	
	public Users save(Users users) {
		template.opsForHash().put("Users", users.getId(), users);
		return users;
	}
	
	public List<Users> display(){
		return template.opsForHash().values("Users");
	}
	
	public Users displayOne(int id) {
		return (Users)template.opsForHash().get("Users", id);
	}
	
	public Users update(int id, Users users) {
		template.opsForHash().put("Users",id , users);
		return users;
	}
	
	public String delete(int id) {
		template.opsForHash().delete("Users", id);
		return "User removed!!";
	}
}
