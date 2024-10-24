package com.example.library.Model.Mapper;

import org.mapstruct.Mapper;

import com.example.library.Model.DTO.BorrowingRecordDto.SendBorrowingRecordDto;
import com.example.library.Model.DTO.BorrowingRecordDto.updateBorrowingRecordDto;
import com.example.library.Model.Entity.BorrowingRecord;

@Mapper(componentModel = "spring")

public interface MapperBorrowingRecord {
	
SendBorrowingRecordDto send(BorrowingRecord SendEntity);
BorrowingRecord SendEntity(SendBorrowingRecordDto send);


updateBorrowingRecordDto update(BorrowingRecord updateEntity);
BorrowingRecord updateEntity(updateBorrowingRecordDto update);
}
