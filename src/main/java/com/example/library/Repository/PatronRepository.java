package com.example.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.Model.Entity.Book;
import com.example.library.Model.Entity.PatronEntity;

public interface PatronRepository  extends JpaRepository<PatronEntity,Long> {

}
