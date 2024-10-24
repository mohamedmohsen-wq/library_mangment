package com.example.library.Model.DTO.BorrowingRecordDto;

import java.sql.Date;

import com.example.library.Model.DTO.bookDto.GetBookDto;
import com.example.library.Model.Entity.Book;
import com.example.library.Model.Entity.PatronEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class updateBorrowingRecordDto {
	private Long id;

	 
    private Date borrowDate;
   
    
    private Date returnDate;
    

    
}
