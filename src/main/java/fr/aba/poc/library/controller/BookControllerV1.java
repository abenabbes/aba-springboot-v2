package fr.aba.poc.library.controller;

import fr.aba.poc.library.model.dto.*;
import fr.aba.poc.library.service.BookServiceV1;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookControllerV1 {

	private final BookServiceV1 bookService;
	
	@GetMapping("/searsh")
    public ResponseEntity<List<BookResponseDto>> getBooksByAuthor(
    		    @RequestParam String authorPrenom,
    		    @RequestParam String authorNom
    )
	
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

	@PostMapping("/addBookV2")
	@ResponseStatus(HttpStatus.CREATED)
	public BookAuthorCompletDto addBooksWithAuthorV2(
			@RequestParam BookCompletDto dto){
		return bookService.ddBooksWithAuthorV2(dto);
	}
}
