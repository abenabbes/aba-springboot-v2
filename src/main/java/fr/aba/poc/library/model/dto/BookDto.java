package fr.aba.poc.library.model.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {

	private Long id;
	
	@NotBlank(message = "Le titre est obligatoire")
	private String titre;
	
	@NotNull(message = "L'ISBN est obligatoire")
	private Integer isbn;
	
	@NotNull(message = "L'a date de publication est obligatoire")
	private LocalDate datePublication;
	
	//private AuthorDto author;
}
