package com.example.library.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Model.DTO.PatronDto.GetPatronDto;
import com.example.library.Model.DTO.PatronDto.SendPatronDto;
import com.example.library.Model.DTO.PatronDto.updatePatronDto;
import com.example.library.Service.ServicePatron;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class patronController {
	
	private final ServicePatron ser;
	
	@GetMapping("/patrons")
	List<GetPatronDto> GetAll() {
		return this.ser.GetAll();
		
	}
	@GetMapping("/patrons/{id}")
	public GetPatronDto Get( @PathVariable Long id) {
		return this.ser.Get(id);
		
	}

	@PostMapping("/patrons")
	public SendPatronDto SendPatron( @RequestBody SendPatronDto SendPatron) {
		return this.ser.SendPatron(SendPatron);
		
	}
	
	@DeleteMapping("/patrons/{id}")
	public String Delete(@PathVariable Long id) {
		return this.ser.Delete(id);
		
		
	}
	
	@PutMapping("/patrons")
	public updatePatronDto upDatePatron( @RequestBody  updatePatronDto upDatePatron) {
		return this.ser.upDatePatron(upDatePatron);
		
		
	}
}


