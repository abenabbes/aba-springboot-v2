package fr.aba.poc.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.aba.poc.library.exception.NotFoundException;
import fr.aba.poc.library.model.Gender;
import fr.aba.poc.library.model.dto.AjoutBookDto;
import fr.aba.poc.library.model.dto.BookRequestDto;
import fr.aba.poc.library.model.dto.BookResponseDto;
import fr.aba.poc.library.model.entity.AuthorEntity;
import fr.aba.poc.library.model.entity.BookEntity;
import fr.aba.poc.library.model.mapper.BookMapperV1;
import fr.aba.poc.library.repository.AuthorRepository;
import fr.aba.poc.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceV1Impl implements BookServiceV1 {

	private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookMapperV1 bookMapperV1;
	
	@Override
	public List<BookResponseDto> getBooksByAuthor(BookRequestDto request) {
		
		AuthorEntity author = authorRepository
                .findByPrenomAndNom(request.getAuthorPrenom(), request.getAuthorNom())
                .orElseThrow(() -> new NotFoundException(
                        "Attention! Aucun auteur existe avec le prénom = : " 
                        		+ request.getAuthorPrenom() + " et le Nom = " 
                        		+ request.getAuthorNom() 
                ));

        List<BookEntity> books = bookRepository.findByAuthorId(author.getId());

        return bookMapperV1.toResponseDtos(books);
	}

	@Override
	public void addBooksWithAuthor(AjoutBookDto request) {
		// Création d'un AuthorEntity à partir des informations de l'auteur fournies dans la requête
		AuthorEntity author = AuthorEntity.builder()
				.prenom(request.getAuthorPrenom())
				.nom(request.getAuthorNom())
				.sexe(Gender.valueOf(request.getSexe()))
				.build();

		// recherche d'un auteur existant dans la base de données avec le même prénom et nom
		AuthorEntity existingAuthor = authorRepository
				.findByPrenomAndNom(request.getAuthorPrenom(), 
						request.getAuthorNom())
				.orElse(null);
		
		// Sauvegarde de l'auteur dans la base de données
		AuthorEntity savedAuthor = null;
		if(existingAuthor == null) {
			 savedAuthor = authorRepository.save(author);
		}
		

		// Création d'un BookEntity à partir des informations du livre fournies dans la requête
		BookEntity book = BookEntity.builder()
				.titre(request.getTitle())
				.isbn(request.getIsbn())
				.datePublication(request.getDatePublication())
				.author(savedAuthor) // Association du livre avec l'auteur sauvegardé
				.build();

		// Sauvegarde du livre dans la base de données
		bookRepository.save(book);
		
	}

}
