package com.gl.Library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.Library.model.Book;
import com.gl.Library.service.LibraryService;

@RestController
@RequestMapping("/books")
public class LibraryController {
	
	@Autowired
	LibraryService libraryService;
	
	@GetMapping("/greet")
	public String greet()
	{
		return "Hello World";
	}
	
	@GetMapping("/demo")
	public Book test()
	{
		Book b1=new Book(101,"RDPD","Alice","motivational");
		return b1;
	}
	
	@PostMapping("/addBook")
	public Book addBook(@RequestParam("id") int id, 
			 	   @RequestParam("title") String title,
			 	  @RequestParam("author") String author,
			 	 @RequestParam("cat") String cat)
	{
		Book b2=new Book();
		b2.setId(id);
		b2.setTitle(title);
		b2.setAuthor(author);
		b2.setCategory(cat);	
		
		return libraryService.addBook(b2);	
	}
	
	@PostMapping("/addBookByJson")
	public Book addBook(@RequestBody Book b2)
	{	
		return libraryService.addBook(b2);	
	}
	
	/*@PostMapping("/addBookByJson")
	public ResponseEntity<Book> addBook(@RequestBody Book b2)
	{	
		return new ResponseEntity<Book>(
				libraryService.addBook(b2),
				HttpStatus.OK
				);	
	}*/
	
	@GetMapping("/getBook")
	public Book getBook(@RequestParam("id") int id)
	{
		return libraryService.getBook(id);
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBook()
	{
		return libraryService.getAllBooks();
	}
	
	@DeleteMapping("/deleteBook")
	public String deleteBook(@RequestParam("id") int id)
	{
		libraryService.deleteBook(id);
		return "Record Deleted";
	}
	
	@PutMapping("/updateBook")
	public Book updateBook(@RequestParam("bookid") int bid,
							@RequestBody Book b3)
	{
		return libraryService.updateBook(bid,b3);
	}
}


