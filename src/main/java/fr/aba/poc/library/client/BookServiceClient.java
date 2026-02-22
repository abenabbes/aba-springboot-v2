package fr.aba.poc.library.client;

import fr.aba.poc.library.generated.client.api.BooksApi;
import fr.aba.poc.library.generated.client.model.BookDto;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public class BookServiceClient {

    private final BooksApi booksApi;

    public BookServiceClient(BooksApi booksApi) {
        this.booksApi = booksApi;
    }

    public Mono<BookDto> searchBook(String isbn, String titre, LocalDate datePublication) {
        return booksApi.searchOneBook(isbn, titre, datePublication);
    }

    public Mono<BookDto> addBook(String title, String isbn, LocalDate datePublication,
                                 String authorPrenom, String authorNom, String sexe) {
        return booksApi.addBooks(title, isbn, datePublication, authorPrenom, authorNom, sexe);
    }
}
