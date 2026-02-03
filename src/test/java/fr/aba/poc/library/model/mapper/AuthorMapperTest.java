package fr.aba.poc.library.model.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import fr.aba.poc.library.model.Gender;
import fr.aba.poc.library.model.dto.AuthorDto;
import fr.aba.poc.library.model.entity.AuthorEntity;

public class AuthorMapperTest {

	private final AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);
	
	@Test
	public void testMapEntityToDTO() {
		AuthorEntity entity = AuthorEntity.builder()
				.id(1L)
				.prenom("John")
				.nom("Doe")
				.sexe(Gender.M)
				.build();
		
		AuthorDto dto = authorMapper.toDTO(entity);
		
		assert dto.getId().equals(entity.getId());
		assertThat(dto).isNotNull();
	}
	
	@Test
	public void testMapEntityToListDto() {
		AuthorEntity entity1 = AuthorEntity.builder()
				.id(1L)
				.prenom("John")
				.nom("Hugo")
				.sexe(Gender.M)
				.build();
		
		AuthorEntity entity2 = AuthorEntity.builder()
				.id(1L)
				.prenom("John")
				.nom("Sand")
				.sexe(Gender.M)
				.build();
		
		List<AuthorDto> dtos = authorMapper.toDTOList(List.of(entity1,entity2));
		
		assertThat(dtos).isNotNull();
		assertThat(dtos.size()).isEqualTo(2);
		assertThat(dtos.get(0).getNom()).isEqualTo("Hugo");
        assertThat(dtos.get(1).getNom()).isEqualTo("Sand");
	}
}
