package com.example.library.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.Model.DTO.PatronDto.GetPatronDto;
import com.example.library.Model.DTO.PatronDto.SendPatronDto;
import com.example.library.Model.DTO.PatronDto.updatePatronDto;

@Service
public interface ServicePatron {
	
	List<GetPatronDto> GetAll();
	
	GetPatronDto Get (Long id);
	
	SendPatronDto SendPatron(SendPatronDto SendPatron);
	
	String Delete(Long id);
	
	updatePatronDto upDatePatron(updatePatronDto upDatePatron);

}
