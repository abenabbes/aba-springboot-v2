
package fr.aba.poc.library.service;

import java.time.LocalDate;

import fr.aba.poc.library.model.dto.BookDto;

public interface IBookServiceV {

	BookDto addBooks(String title, String isbn, LocalDate datePublication, String authorPrenom, String authorNom,
			String sexe);

	BookDto searchOneBook(String isbn, String titre, LocalDate datePublication);
}
