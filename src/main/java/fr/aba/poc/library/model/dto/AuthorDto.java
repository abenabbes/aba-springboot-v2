package fr.aba.poc.library.model.dto;

import java.util.List;

import fr.aba.poc.library.model.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class AuthorDto {

	private Long id;
	@NotBlank(message = "Le prénom de l'auteur est obligatoire")
	private String prenom;
	@NotBlank(message = "Le nom de l'auteur est obligatoire")
	private String nom;
	@NotNull(message = "Le sexe de l'auteur est obligatoire")
	private Gender sexe;	
	private List<BookDto> books;
	
}
