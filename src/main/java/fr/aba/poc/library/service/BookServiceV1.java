package fr.aba.poc.library.service;

import java.util.List;

import fr.aba.poc.library.model.dto.BookRequestDto;
import fr.aba.poc.library.model.dto.BookResponseDto;

public interface BookServiceV1 {

	List<BookResponseDto> getBooksByAuthor(BookRequestDto request);
}
