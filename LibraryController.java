package com.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController
{
	private Library libraryService = new Library();
	
	@GetMapping("/books")
	public List<Book> retrieveBooks() 
	{
		return libraryService.displayAll();
	}			
	
	@GetMapping("/books/author")
	public List<Book> retrieveAuthor()
	{
		return libraryService.displayByAuthor();
	}	
	
	@GetMapping("/books/title/{searchTitle}")
	public List<Book> retrieveByTitle(@PathVariable String searchTitle)
	{
		return libraryService.searchByTitle(searchTitle);
	}	
	
	@GetMapping("/books/{ID}")
	public Book retrieveByID(@PathVariable int ID) 
	{
		return libraryService.getByID(ID);
	}	
	
	@PostMapping("/books/add/{title}/{author}")
	public ResponseEntity<Void> addBook(@PathVariable String title, @PathVariable String author) 
	{		
		libraryService.addBook(new Book(title, author));	
		return ResponseEntity.ok(null);		
	}	

}
