package fr.aba.poc.library.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponseDto {

	private Long id;
    private String titre;
}
