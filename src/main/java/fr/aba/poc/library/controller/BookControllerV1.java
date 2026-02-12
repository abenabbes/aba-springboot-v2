package fr.aba.poc.library.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.aba.poc.library.model.dto.AjoutBookDto;
import fr.aba.poc.library.model.dto.BookRequestDto;
import fr.aba.poc.library.model.dto.BookResponseDto;
import fr.aba.poc.library.service.BookServiceV1;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookControllerV1 {

	private final BookServiceV1 bookService;
	
	@GetMapping("/searsh")
    public ResponseEntity<List<BookResponseDto>> getBooksByAuthor(
    		    @RequestParam String authorPrenom,
    		    @RequestParam String authorNom
    ) throws BadRequestException
	
	{
				BookRequestDto request = BookRequestDto.builder()
				.authorPrenom(authorPrenom)
				.authorNom(authorNom)
				.build();

        return ResponseEntity.ok(bookService.getBooksByAuthor(request));
	}
	
	@PostMapping("/addBook")
	public void addBooksWithAuthor(
			@RequestParam(required = true) String title,
			@RequestParam(required = true) Integer isbn,
			@RequestParam(required = true) LocalDate datePublication,
			@RequestParam(required = true) String authorPrenom,
			@RequestParam(required = true) String authorNom,
			@RequestParam(required = true) String sexe
	) {
		// Implémentation de la recherche de livres en fonction des critères fournis
		AjoutBookDto request = AjoutBookDto.builder()
			.title(title)
			.isbn(isbn)
			.datePublication(datePublication)
			.authorPrenom(authorPrenom)
			.authorNom(authorNom)
			.sexe(sexe)
			.build();
		
		bookService.addBooksWithAuthor(request);
		
	}
}
