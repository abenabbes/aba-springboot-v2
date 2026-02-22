package fr.aba.poc.library.client;

import fr.aba.poc.library.generated.client.model.BookDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/library")
@RequiredArgsConstructor
@Tag(name = "Books", description = "Gestion des livres")
@Slf4j
public class LibraryControllerClient {

    private  BookServiceClient bookServiceClient;

    @GetMapping("/searchOneBookClient")
    public Mono<ResponseEntity<BookDto>> searchBook(
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) String titre,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate datePublication) {

        return bookServiceClient.searchBook(isbn, titre, datePublication)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
