package fr.aba.poc.library.model.dto;

import java.time.LocalDate;

import fr.aba.poc.library.model.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class BookDto {
	
	private Long id;
	@NotBlank(message = "Le titre du livre est obligatoire")
	private String titre;
	@NotBlank(message = "L'ISBN du livre est obligatoire")
	private String isbn;
	@NotNull(message = "La date de publication du livre est obligatoire")
	private LocalDate datePublication;	
	//private AuthorDto author;
	// On évite la récursion infinie
    // On ne met pas AuthorDto complet ici
    private Long authorId;
    @NotBlank(message = "Le prénom de l'auteur est obligatoire")
    private String authorPrenom;
    @NotBlank(message = "Le nom de l'auteur est obligatoire")
    private String authorNom;
    @NotNull(message = "Le sexe de l'auteur est obligatoire")
    private Gender authorSexe;
}
