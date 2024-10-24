package com.example.library.Model.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "Book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "book" ,cascade = CascadeType.ALL)
    private List<BorrowingRecord> borrowingRecords;

}
