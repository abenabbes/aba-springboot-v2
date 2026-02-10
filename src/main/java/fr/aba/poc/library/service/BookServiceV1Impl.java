package fr.aba.poc.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.aba.poc.library.exception.NotFoundException;
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
                        "Attention! Aucun auteur avec le prénom = : " 
                        		+ request.getAuthorPrenom() + " et le Nom = " 
                        		+ request.getAuthorNom() + " n'existe pas."
                ));

        List<BookEntity> books = bookRepository.findByAuthorId(author.getId());

        return bookMapperV1.toResponseDtos(books);
	}

}
