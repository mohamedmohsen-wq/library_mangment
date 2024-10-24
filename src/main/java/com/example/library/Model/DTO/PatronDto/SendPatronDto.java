package com.example.library.Model.DTO.PatronDto;

import com.example.library.Model.DTO.bookDto.GetBookDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendPatronDto {
	 
	    
	    private String name;
	    private String contactInfo;

}
