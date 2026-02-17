package fr.aba.poc.library.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.aba.poc.library.model.dto.BookResponseDto;
import fr.aba.poc.library.model.entity.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapperV1 {

	@Mapping(target = "id", source = "id")
    @Mapping(target = "titre", source = "titre")
	@Mapping(target = "isbn", source = "isbn")
	@Mapping(target = "publicationDate", source = "datePublication")
    BookResponseDto toResponseDto(BookEntity entity);

    List<BookResponseDto> toResponseDtos(List<BookEntity> entities);
}
