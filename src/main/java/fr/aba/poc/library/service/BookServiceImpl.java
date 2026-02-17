package fr.aba.poc.library.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.aba.poc.library.exception.BadRequestException;
import fr.aba.poc.library.exception.CreationException;
import fr.aba.poc.library.exception.NotFoundException;
import fr.aba.poc.library.model.Gender;
import fr.aba.poc.library.model.dto.BookDto;
import fr.aba.poc.library.model.entity.AuthorEntity;
import fr.aba.poc.library.model.entity.BookEntity;
import fr.aba.poc.library.model.mapper.BookMapper;
import fr.aba.poc.library.repository.IAuthorRepository;
import fr.aba.poc.library.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements IBookServiceV {

	private final IAuthorRepository authorRepository;
	private final IBookRepository bookRepository;
	private final BookMapper bookMapper;

	@Override
	public BookDto addBooks(String title, String isbn, LocalDate datePublication, String authorPrenom, String authorNom,
			String sexe) throws CreationException {

		log.info("Service d'ajout de livres avec auteur - V1");

		// Traitement sur les valeurs en entrées
		if (title == null || title.isEmpty()) {
			throw new CreationException("Le titre du livre est obligatoire");
		}

		if (isbn == null || isbn.isEmpty()) {
			throw new CreationException("L'ISBN du livre est obligatoire");
		}

		if (datePublication == null) {
			throw new CreationException("La date de publication du livre est obligatoire");
		}

		if (authorPrenom == null || authorPrenom.isEmpty()) {
			throw new CreationException("Le prénom de l'auteur est obligatoire");
		}

		if (authorNom == null || authorNom.isEmpty()) {
			throw new CreationException("Le nom de l'auteur est obligatoire");
		}

		if (sexe == null || sexe.isEmpty()) {
			throw new CreationException("Le sexe de l'auteur est obligatoire");
		}

		// Vérifier si l'auteur existe déjà dans la base de données
		AuthorEntity existingAuthor = authorRepository.findByPrenomAndNom(authorPrenom, authorNom).orElseGet(() -> { // Si
																														// l'auteur
																														// n'existe
																														// pas
																														// alors
																														// création
																														// d'un
																														// nouveau
			AuthorEntity a = new AuthorEntity();
			a.setPrenom(authorPrenom);
			a.setNom(authorNom);
			a.setSexe(Gender.valueOf(sexe));
			return authorRepository.save(a);
		});

		// Vérifier si le livre existe déjà dans la base de données avec les mêmes
		// critères de recherche
		// List<BookEntity> existingBooks = bookRepository.searchOneBook(title, isbn,
		// datePublication);
		// Optional<BookEntity> existingBooks = bookRepository.findByIsbn(isbn);
		Optional<BookEntity> existingBooks = bookRepository.findOneBook(isbn, title, datePublication);

		// Si un livre avec le même ISBN existe déjà, on considère que c'est un doublon
		if (!existingBooks.isEmpty()) {
			throw new CreationException(
					"Le livre existe déjà dans la base de données avec les mêmes critères de recherche");
		}

		// Création d'un BookEntity à partir des informations du livre fournies dans la
		// requête
		BookEntity book = BookEntity.builder().titre(title).isbn(isbn).datePublication(datePublication)
				.author(existingAuthor) // Association du livre avec l'auteur existant ou nouvellement créé
				.build();
		bookRepository.save(book);
		// Sans passer par un mapper
//	 		return BookDto.builder()
//	 				.id(book.getId())
//	 				.titre(book.getTitre())
//	 				.isbn(book.getIsbn())
//	 				.datePublication(book.getDatePublication())
//	 				.authorId(existingAuthor.getId())
//	 				.authorPrenom(existingAuthor.getPrenom())
//	 				.authorNom(existingAuthor.getNom())
//	 				.authorSexe(existingAuthor.getSexe())
//	 				.build();

		// Passer par un mapper
		return bookMapper.toBookDto(book);

	}

	@Override
	public BookDto searchOneBook(String isbn, String titre, LocalDate datePublication) {

		// Aucun critère fourni → erreur
		if ((isbn == null || isbn.isBlank()) && (titre == null || titre.isBlank()) && datePublication == null) {

			throw new BadRequestException(
					"Au moins un critère de recherche doit être fourni : isbn, titre ou datePublication");
		}

		Optional<BookEntity> optionalBook;

		if (isbn != null && !isbn.isBlank()) {
			optionalBook = bookRepository.findOneBook(isbn.trim(), null, null);
		} else if (titre != null && !titre.isBlank()) {
			optionalBook = bookRepository.findOneBook(null, "%" + titre.trim() + "%", null);
		} else {
			optionalBook = bookRepository.findOneBook(null, null, datePublication);
		}

		return optionalBook.map(bookMapper::toBookDto).orElseThrow(() -> new NotFoundException("Livre non trouvé"));
	}

}
