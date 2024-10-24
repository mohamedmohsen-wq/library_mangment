package com.example.library.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.ROPULVA.Component.EventsComponent;
import com.example.library.Model.DTO.bookDto.GetBookDto;
import com.example.library.Model.DTO.bookDto.SendBookDto;
import com.example.library.Model.DTO.bookDto.updateBookDto;
import com.example.library.Model.Entity.Book;
import com.example.library.Model.Mapper.MapperBooks;
import com.example.library.Repository.BookRepository;
import com.example.library.Service.BookService;
import com.example.library.component.componentBooks;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceBookImpl  implements BookService{
	private final BookRepository repoBook;
	private final MapperBooks mapBooks;
	private final componentBooks ComponentBooks;
	@Override
	public List<GetBookDto> GetAll() {
		
		List<Book>  GetAllBooks=this.repoBook.findAll();
		List<GetBookDto> GetAllBooks2=this.mapBooks.ListDto(GetAllBooks);
		return GetAllBooks2;
	}

	@Override
	 @Cacheable(value = "Books", key = "#id")
	public GetBookDto Get(Long Id) {
		ComponentBooks.logBooksAction("GET", Id);
		
		Book GetBooks = this.repoBook.getById(Id);
		GetBookDto GetBooks2=this.mapBooks.Dto(GetBooks);
		
		return GetBooks2;
	}

	@Override
	@Transactional
	public SendBookDto SendBooks( SendBookDto Send) {
		ComponentBooks.validateBooksData(Send.getTitle(), Send.getAuthor());
		Book SendBooks=this.mapBooks.entitySend(Send);
		Book SendBooks1=this.repoBook.save(SendBooks);
		return this.mapBooks.DtoSend(SendBooks1);
	}

	@Override
	 @Cacheable(value = "Books", key = "#id")

	public String Delelte(Long ID) {
		ComponentBooks.logBooksAction("DELETE", ID);
		Optional<Book> Books=this.repoBook.findById(ID);
		if(Books.isPresent()) {
			Book DeleteBook=Books.get();
			this.repoBook.deleteById(ID);
			return "Book deleted successfully";
		}else {
			return "Book  not found";
		}
		
		
	}

	@Override
	public updateBookDto updateBooks(updateBookDto updateBooks) {
		ComponentBooks.validateBooksData(updateBooks.getTitle(), updateBooks.getAuthor());
		Book updateBooks1=this.mapBooks.entityUpdate(updateBooks);
		Book updateBooks2=this.repoBook.save(updateBooks1);
		updateBookDto updateBooks3=this.mapBooks.DtoUpdate(updateBooks2);
		return updateBooks3;
	}

	

}
