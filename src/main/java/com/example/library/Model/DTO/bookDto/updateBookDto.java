package com.example.library.Model.DTO.bookDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class updateBookDto {
    private long id;
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
}
