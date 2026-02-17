package fr.aba.poc.library.controller;

import java.time.LocalDate;

import org.apache.coyote.BadRequestException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.aba.poc.library.model.dto.BookDto;
import fr.aba.poc.library.service.IBookServiceV;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/library")
@RequiredArgsConstructor
@Tag(name = "Books", description = "Gestion des livres")
@Slf4j
public class LibraryController {

	// Attributs
	private final IBookServiceV bookService;

	// Premier endpoint de recherche de livres
	// On peut faire une recherche par titre, isbn ou date de publication
	// Exemple d'URL :
	// /api/library/search?titre=Le%20Petit%20Prince&isbn=978-3-16-148410-0&datePublication=1943-04-06
	// @GetMapping("/searchAllBooks")
	public BookDto searchBook() {
		log.info("Endpoint de recherche de livres par auteur");
		// Implémentation de la recherche de livres en fonction des critères fournis

		// return bookService.searchBookByTitreIsbnDatePublication(isbn, titre,
		// datePublication); // à implémenter
		return null; // à implémenter
	}

	/**
	 * Ajoute un livre avec les informations de l'auteur. Les paramètres sont passés
	 * en tant que paramètres de requête.
	 * 
	 * @param title           Titre du livre à ajouter
	 * @param isbn            ISBN du livre à ajouter
	 * @param datePublication Date de publication du livre à ajouter (format ISO :
	 *                        yyyy-MM-dd)
	 * @param authorPrenom    Prénom de l'auteur du livre à ajouter
	 * @param authorNom       Nom de l'auteur du livre à ajouter
	 * @param sexe            Sexe de l'auteur du livre à ajouter (M ou F)
	 * @return String indiquant le résultat de l'ajout du livre
	 */
	@PostMapping("/addBooks")
	@ResponseStatus(HttpStatus.CREATED) // Bonne pratique :
										// Code de statut HTTP 201 pour indiquer que la ressource a été créée avec
										// succès
	public BookDto addBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String isbn,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate datePublication,
			@RequestParam(required = false) String authorPrenom, @RequestParam(required = false) String authorNom,
			@RequestParam(required = false) String sexe) {
		// Implémentation de l'ajout de livres avec auteur
		log.info("Endpoint d'ajout de livres avec auteur");

		return bookService.addBooks(title, isbn, datePublication, authorPrenom, authorNom, sexe);
	}

	/**
	 * Recherche un seule livre en fonction de l'ISBN, du titre ou de la date de
	 * publication.
	 * 
	 * @param isbn            ISBN du livre à rechercher (optionnel)
	 * @param titre           Titre du livre à rechercher (optionnel)
	 * @param datePublication Date de publication du livre à rechercher (optionnel)
	 * @return ResponseEntity contenant le livre trouvé ou une réponse 404 si aucun
	 *         livre ne correspond aux critères de recherche
	 * @throws BadRequestException
	 */
	@GetMapping("/searchOneBook")
	@Operation(summary = "Rechercher un livre")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Livre trouvé"),
			@ApiResponse(responseCode = "404", description = "Livre non trouvé") })
	public ResponseEntity<BookDto> searchOneBook(@RequestParam(required = false) String isbn,
			@RequestParam(required = false) String titre,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(required = false) LocalDate datePublication) {
		// Implémentation de la recherche de tous les livres
		log.info("Endpoint de recherche de tous les livres");
		BookDto book = bookService.searchOneBook(isbn, titre, datePublication);

		return ResponseEntity.ok(book);

	}

}
