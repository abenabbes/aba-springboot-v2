package fr.aba.poc.library.model.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class BookResponseDto {

	private Long id;
    private String titre;
    private Integer isbn;
    private LocalDate publicationDate;
    private String authorPrenom;
    private String authorNom;
    
}
