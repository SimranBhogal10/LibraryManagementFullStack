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

import com.example.Library.entity.Books;
import com.example.Library.repository.Book;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private Book book;
	
	@PostMapping
	public Books save(@RequestBody Books books) {
		return book.save(books);
	}
	
	@GetMapping
	public List<Books> display(){
		return book.display();
	}
	
	@GetMapping("/{id}")
	public Books displayOne(@PathVariable int id){
		return book.displayOne(id);
	}
	
	@PutMapping("/{id}")
	public Books update(@PathVariable int id, @RequestBody Books books) {
		return book.update(id, books);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return book.delete(id);
	}
}
