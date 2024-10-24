package com.example.library.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.Model.DTO.bookDto.GetBookDto;
import com.example.library.Model.DTO.bookDto.SendBookDto;
import com.example.library.Model.DTO.bookDto.updateBookDto;
import com.example.library.Model.Entity.Book;

@Service
public interface BookService {
	
	List<GetBookDto> GetAll();
	
	GetBookDto Get( Long Id);
	
	SendBookDto  SendBooks( SendBookDto Send);
	
	String Delelte(Long ID);
	
	updateBookDto updateBooks(updateBookDto updateBooks);

}
