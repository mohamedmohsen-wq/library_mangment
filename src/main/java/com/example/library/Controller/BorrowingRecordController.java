package com.example.library.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Model.DTO.BorrowingRecordDto.SendBorrowingRecordDto;
import com.example.library.Model.DTO.BorrowingRecordDto.updateBorrowingRecordDto;
import com.example.library.Model.Mapper.MapperBooks;
import com.example.library.Service.BookService;
import com.example.library.Service.ServiceBorrowingRecord;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BorrowingRecordController {
	private final ServiceBorrowingRecord serv;
	@PostMapping("/borrow/{book_id}/patron/{patron_id}")
	public SendBorrowingRecordDto send(@RequestBody SendBorrowingRecordDto sendDto , @PathVariable Long book_id, @PathVariable long patron_id) {
		return this.serv.send(sendDto, book_id, patron_id);
		
		
	}
	@PutMapping("/borrow/{book_id}/patron/{patron_id}")
	public updateBorrowingRecordDto update( @RequestBody updateBorrowingRecordDto updateDto,@PathVariable Long book_id,@PathVariable Long patron_id) {
		return this.serv.update(updateDto, book_id, patron_id);
		
		
		
	}
	

}
