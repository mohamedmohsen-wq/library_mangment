package com.example.library.Model.Mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;

import com.example.library.Model.DTO.bookDto.GetBookDto;
import com.example.library.Model.DTO.bookDto.SendBookDto;
import com.example.library.Model.DTO.bookDto.updateBookDto;
import com.example.library.Model.Entity.Book;

@Mapper(componentModel = "spring")
public interface MapperBooks {
	Book entity (GetBookDto Dto);
	GetBookDto Dto(Book entity);
	
	
	List<Book> ListEntity (List<GetBookDto> ListDto);
	List<GetBookDto> ListDto(List<Book> ListEntity);
	
	
	
	Book entitySend(SendBookDto DtoSend);
	SendBookDto DtoSend(Book entitySend);
	
	Book entityUpdate( updateBookDto DtoUpdate);
	
	updateBookDto DtoUpdate(Book entityUpdate);
	
	 
	

	
	
	
	

}
