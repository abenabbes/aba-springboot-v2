package fr.aba.poc.library.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.aba.poc.library.model.dto.BookRequestDto;
import fr.aba.poc.library.model.dto.BookResponseDto;
import fr.aba.poc.library.service.BookServiceV1;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookControllerV1 {

	private final BookServiceV1 bookService;
	
	@GetMapping
    public ResponseEntity<List<BookResponseDto>> getBooksByAuthor(
    		    @RequestParam String authorPrenom,
    		    @RequestParam String authorNom
    ) {
				BookRequestDto request = BookRequestDto.builder()
				.authorPrenom(authorPrenom)
				.authorNom(authorNom)
				.build();

        return ResponseEntity.ok(bookService.getBooksByAuthor(request));
	}
}
