package com.example.library.Model.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.library.Model.DTO.PatronDto.GetPatronDto;
import com.example.library.Model.DTO.PatronDto.SendPatronDto;
import com.example.library.Model.DTO.PatronDto.updatePatronDto;
import com.example.library.Model.Entity.PatronEntity;

@Mapper(componentModel = "spring")

public interface MapperPatron {
	PatronEntity entity (GetPatronDto DTo);
	GetPatronDto DTo(PatronEntity entity);
	
	List<PatronEntity> Listentity(List<GetPatronDto> listDto);
	List<GetPatronDto> listDto(List<PatronEntity> Listentity);
	
	PatronEntity SendEntity (SendPatronDto SendDto);
	SendPatronDto SendDto(PatronEntity SendEntity);
	
	
	PatronEntity updateEntity(updatePatronDto updateDto);
	
	updatePatronDto updateDto(PatronEntity updateEntity);
	

}
