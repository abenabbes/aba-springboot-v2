package fr.aba.poc.library.service;

import java.util.List;

import fr.aba.poc.library.model.dto.*;

public interface BookServiceV1 {

	List<BookResponseDto> getBooksByAuthor(BookRequestDto request);
	void addBooksWithAuthor(AjoutBookDto request);
	BookAuthorCompletDto ddBooksWithAuthorV2(BookCompletDto dto);
}
