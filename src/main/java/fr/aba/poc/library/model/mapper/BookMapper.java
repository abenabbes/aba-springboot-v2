package fr.aba.poc.library.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.aba.poc.library.model.dto.BookDto;
import fr.aba.poc.library.model.entity.BookEntity;

@Mapper(componentModel = "spring",
		unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE // pour ignorer les propriétés non mappées et éviter les warnings
		)
public interface BookMapper {

	@Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "author.prenom", target = "authorPrenom")
    @Mapping(source = "author.nom", target = "authorNom")
	@Mapping(source = "author.sexe", target = "authorSexe")
	BookDto toBookDto(BookEntity entite);
	
	@Mapping(target = "author", ignore = true) // géré dans le service
	BookEntity toBookEntity(BookDto dto);
	
	List<BookDto> toBookDtoList(List<BookEntity> entities);
	
	List<BookEntity> toBookEntityList(List<BookDto> dtos);
}
