package fr.aba.poc.library.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import fr.aba.poc.library.model.dto.BookDto;
import fr.aba.poc.library.model.entity.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapper {

	BookDto toDTO(BookEntity entite);
	
	BookEntity toEntity(BookDto dto);
	
	List<BookDto> toDTOList(List<BookEntity> entities);
	
	List<BookEntity> toEntityList(List<BookDto> dtos);
}
