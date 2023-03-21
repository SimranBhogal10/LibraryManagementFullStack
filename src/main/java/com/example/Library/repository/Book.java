package com.example.Library.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.Library.entity.Books;


@Repository
public class Book {
	
	@Autowired
	public RedisTemplate template;
	
	public Books save(Books books) {
		template.opsForHash().put("Books", books.getId(), books);
		return books;
	}
	
	public List<Books> display(){
		return template.opsForHash().values("Books");
	}
	
	public Books displayOne(int id) {
		return (Books)template.opsForHash().get("Books", id);
	}
	
	public Books update(int id, Books books) {
		template.opsForHash().put("Books",id , books);
		return books;
	}
	
	public String delete(int id) {
		template.opsForHash().delete("Books", id);
		return "Book removed!!";
	}
}
