package fr.aba.poc.library.model.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthorCompletDto {

    private Long id;
    private String titre;
    private Integer isbn;
    private LocalDate publicationDate;
    private String authorNom;
    private String authorPrenom;
}
