package com.example.library.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.library.Model.DTO.PatronDto.GetPatronDto;
import com.example.library.Model.DTO.PatronDto.SendPatronDto;
import com.example.library.Model.DTO.PatronDto.updatePatronDto;
import com.example.library.Model.Entity.PatronEntity;
import com.example.library.Model.Mapper.MapperPatron;
import com.example.library.Repository.PatronRepository;
import com.example.library.Service.ServicePatron;
import com.example.library.component.componentBooks;
import com.example.library.component.componnentPatron;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicePatronImp  implements ServicePatron{
	
private final  MapperPatron mappat;
private final  PatronRepository repoPat;
private final componnentPatron ComponnentPatron;


	@Override
	public List<GetPatronDto> GetAll() {
		List<PatronEntity> GetALL=this.repoPat.findAll();
		
		
		return this.mappat.listDto(GetALL) ;
	}


	@Override
	 @Cacheable(value = "patrons", key = "#id")

	public GetPatronDto Get(Long id) {
		ComponnentPatron.logPatronAction("GET", id);
		PatronEntity Get=this.repoPat.getById(id);
		
		return this.mappat.DTo(Get);
	}


	@Override
	@Transactional
	public SendPatronDto SendPatron(SendPatronDto SendPatron) {
		ComponnentPatron.validateBooksData(SendPatron.getName(), SendPatron.getContactInfo());
		PatronEntity send=this.mappat.SendEntity(SendPatron);
		PatronEntity send1=this.repoPat.save(send);
		return this.mappat.SendDto(send1);
	}


	@Override
	 @Cacheable(value = "patrons", key = "#id")
	public String Delete(Long id) {
		ComponnentPatron.logPatronAction("DELETE", id);
		Optional<PatronEntity> DeletePatron=this.repoPat.findById(id);
		if(DeletePatron.isPresent()) {
			PatronEntity DeletePatron2= DeletePatron.get();
			this.repoPat.deleteById(id);
			return  "Patron deleted successfully";
			
			
		}else {
			return "Patron  not found";
		}
		
	}


	@Override
	public updatePatronDto upDatePatron(updatePatronDto upDatePatron) {
		ComponnentPatron.validateBooksData(upDatePatron.getName(), upDatePatron.getContactInfo());
		PatronEntity update=this.mappat.updateEntity(upDatePatron);
		PatronEntity update1=this.repoPat.save(update);
		return this.mappat.updateDto(update1);
		
	}

	

}
