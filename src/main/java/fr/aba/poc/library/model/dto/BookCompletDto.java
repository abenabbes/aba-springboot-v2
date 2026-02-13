package fr.aba.poc.library.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
public class BookCompletDto {

	private Long id;
	private String titre;
	private Integer isbn;
	private LocalDate datePublication;
	private AuthorCompletDto author;
}
