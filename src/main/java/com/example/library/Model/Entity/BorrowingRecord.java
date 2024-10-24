package com.example.library.Model.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "BorrowingRecord")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class BorrowingRecord {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

   @Temporal(TemporalType.DATE)
    private Date borrowDate;
   
     @Temporal(TemporalType.DATE)
    private Date returnDate;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patron_id" , nullable = false)
    private PatronEntity patron;



}
