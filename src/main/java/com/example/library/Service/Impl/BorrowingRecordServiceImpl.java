package com.example.library.Service.Impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.library.Model.DTO.BorrowingRecordDto.SendBorrowingRecordDto;
import com.example.library.Model.DTO.BorrowingRecordDto.updateBorrowingRecordDto;
import com.example.library.Model.Entity.Book;
import com.example.library.Model.Entity.BorrowingRecord;
import com.example.library.Model.Entity.PatronEntity;
import com.example.library.Model.Mapper.MapperBorrowingRecord;
import com.example.library.Repository.BookRepository;
import com.example.library.Repository.BorrowingRecordRepo;
import com.example.library.Repository.PatronRepository;
import com.example.library.Service.ServiceBorrowingRecord;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BorrowingRecordServiceImpl implements ServiceBorrowingRecord {
	private final BorrowingRecordRepo RepoBorrow;
	private final PatronRepository RepoPatron;
	private final BookRepository RepoBook;
	private final MapperBorrowingRecord map;
	
	
	@Override
    @Transactional

	public SendBorrowingRecordDto send(SendBorrowingRecordDto sendDto,Long book_id, Long patron_id) {
		Book sendIdBook= this.RepoBook.findById(book_id).orElseThrow(() -> new RuntimeException("Book not found"));;
		PatronEntity sendPatroId=this.RepoPatron.findById( patron_id).orElseThrow(() -> new RuntimeException("Book not found"));;
		BorrowingRecord send=this.map.SendEntity(sendDto);
		send.setBook(sendIdBook);
		send.setPatron(sendPatroId);
		BorrowingRecord send1=this.RepoBorrow.save(send);
		SendBorrowingRecordDto responsSend=this.map.send(send1);
		
		return responsSend;
	}


	@Override
	public updateBorrowingRecordDto update(updateBorrowingRecordDto updateDto, Long book_id, Long patron_id) {
		Book updateIdBook= this.RepoBook.findById(book_id).orElseThrow(() -> new RuntimeException("Book not found"));;
		PatronEntity updatePatroId=this.RepoPatron.findById( patron_id).orElseThrow(() -> new RuntimeException("Book not found"));;
		BorrowingRecord send=this.map.updateEntity(updateDto);
		send.setBook(updateIdBook);
		send.setPatron(updatePatroId);
		BorrowingRecord update1=this.RepoBorrow.save(send);
		updateBorrowingRecordDto responsUpdate=this.map.update(update1);
		
		return responsUpdate;
	}

}
