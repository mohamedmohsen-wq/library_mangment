package com.example.library.Model.DTO.bookDto;

import java.util.List;

import com.example.library.Model.Entity.Book;
import com.example.library.Model.Entity.BorrowingRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SendBookDto {
	private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    
}
