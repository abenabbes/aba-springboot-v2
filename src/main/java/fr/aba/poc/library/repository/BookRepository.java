package fr.aba.poc.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aba.poc.library.model.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

	List<BookEntity> findByAuthorId(Long authorId);
}
