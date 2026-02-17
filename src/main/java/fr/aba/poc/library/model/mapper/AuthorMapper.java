package fr.aba.poc.library.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import fr.aba.poc.library.model.dto.AuthorDto;
import fr.aba.poc.library.model.entity.AuthorEntity;

@Mapper(componentModel = "spring", 
		uses = {BookMapper.class},
		unmappedTargetPolicy = ReportingPolicy.IGNORE // pour ignorer les propriétés non mappées et éviter les warnings
		) 
public interface AuthorMapper {

	AuthorDto toAuthorDto(AuthorEntity entite);
	
	@Mapping(target = "books", ignore = true) // géré dans le service pour éviter la récursion infinie
	AuthorEntity toAuthorEntity(AuthorDto dto);
	
	List<AuthorDto> toAuthorDtoList(List<AuthorEntity> entities);
	
	List<AuthorEntity> toAuthorEntityList(List<AuthorDto> dtos);
}
