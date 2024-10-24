package com.example.library.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Model.DTO.bookDto.GetBookDto;
import com.example.library.Model.DTO.bookDto.SendBookDto;
import com.example.library.Model.DTO.bookDto.updateBookDto;
import com.example.library.Model.Entity.Book;
import com.example.library.Model.Mapper.MapperBooks;
import com.example.library.Service.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BooksController {
	
	private final BookService serBooks;
	private final MapperBooks mapBookscon;
	
	@GetMapping("/Books")
	List<GetBookDto> getAll( ){
		return this.serBooks.GetAll();
		
	}
	
	@GetMapping("/Books/{id}")
	GetBookDto get(@PathVariable Long id){
		return this.serBooks.Get(id);
		
	}
	
	
	@PostMapping("/Books")
	public SendBookDto SendBooks(@RequestBody SendBookDto Send) {
		return this.serBooks.SendBooks(Send);	
		
	}
	
	@DeleteMapping("/Books/{id}")
	public String Delelte( @PathVariable Long id) {
		return this.serBooks.Delelte(id);
		
	}
	
	@PutMapping("/Books")
	updateBookDto updateBooks(@RequestBody  updateBookDto updateBooks) {
		return this.serBooks.updateBooks(updateBooks);
		
		
		
	}
	

}
