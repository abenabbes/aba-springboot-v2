package fr.aba.poc.library.model.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponseDto {

	private Long id;
    private String titre;
    private Integer isbn;
    private LocalDate publicationDate;
    
}
