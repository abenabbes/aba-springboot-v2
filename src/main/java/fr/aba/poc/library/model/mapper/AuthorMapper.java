package fr.aba.poc.library.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import fr.aba.poc.library.model.dto.AuthorDto;
import fr.aba.poc.library.model.entity.AuthorEntity;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

	AuthorDto toDTO(AuthorEntity entite);
	
	AuthorEntity toEntity(AuthorDto dto);
	
	List<AuthorDto> toDTOList(List<AuthorEntity> entities);
	
	List<AuthorEntity> toEntityList(List<AuthorDto> dtos);
}
