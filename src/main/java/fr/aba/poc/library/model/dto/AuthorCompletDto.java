package fr.aba.poc.library.model.dto;

import fr.aba.poc.library.model.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@Getter
@Setter
public class AuthorCompletDto {

	private Long id;
	private String prenom;
	private String nom;
	private Gender sexe;
	
	//private List<BookDto> books;
	
}
