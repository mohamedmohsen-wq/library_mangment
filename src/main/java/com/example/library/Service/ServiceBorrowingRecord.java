package com.example.library.Service;

import org.springframework.stereotype.Service;

import com.example.library.Model.DTO.BorrowingRecordDto.SendBorrowingRecordDto;
import com.example.library.Model.DTO.BorrowingRecordDto.updateBorrowingRecordDto;

@Service
public interface ServiceBorrowingRecord {
	
	SendBorrowingRecordDto send(SendBorrowingRecordDto sendDto ,Long book_id, Long patron_id);
	
	
	updateBorrowingRecordDto update(updateBorrowingRecordDto updateDto ,Long book_id, Long patron_id);
	

}
