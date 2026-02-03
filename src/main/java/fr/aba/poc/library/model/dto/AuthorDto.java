package fr.aba.poc.library.model.dto;

import java.util.List;

import fr.aba.poc.library.model.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorDto {

	private Long id;
	
	@NotBlank(message = "Le prénom est obligatoire")
	private String prenom;
	
	@NotBlank(message = "Le nom est obligatoire")
	private String nom;
	
	@NotBlank(message = "La sexe est obligatoire")
	private Gender sexe;
	
	//private List<BookDto> books;
	
}
