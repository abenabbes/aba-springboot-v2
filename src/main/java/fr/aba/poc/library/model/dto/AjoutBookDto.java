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
public class AjoutBookDto {

	public String title;
	public Integer isbn;
	public LocalDate datePublication;
	public String authorPrenom;
	public String authorNom;
	public String sexe;
}
