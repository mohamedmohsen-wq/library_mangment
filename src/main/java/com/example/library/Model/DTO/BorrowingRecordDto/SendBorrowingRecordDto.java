package com.example.library.Model.DTO.BorrowingRecordDto;

import java.sql.Date;

import com.example.library.Model.DTO.bookDto.GetBookDto;
import com.example.library.Model.Entity.Book;
import com.example.library.Model.Entity.PatronEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendBorrowingRecordDto {

	 
	    private Date borrowDate;
	   
	    
	    private Date returnDate;
	    

}
