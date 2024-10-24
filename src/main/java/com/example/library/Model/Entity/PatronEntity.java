package com.example.library.Model.Entity;

import java.util.List;

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
@Table(name = "Patron")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PatronEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String contactInfo;
    
    @OneToMany(mappedBy = "patron" , cascade = CascadeType.ALL)
    private List<BorrowingRecord> borrowingRecords;

}
