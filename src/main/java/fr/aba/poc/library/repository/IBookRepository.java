package fr.aba.poc.library.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.aba.poc.library.model.entity.BookEntity;

public interface IBookRepository extends JpaRepository<BookEntity, Long> {

	List<BookEntity> findByAuthorId(Long authorId);
	
	// Cette requête signifie :
		// Si ISBN est fourni → match ISBN
		// Sinon si titre est fourni → match titre
		// Sinon si date fournie → match date
//	@Query("""
//		    SELECT b FROM BookEntity b
//		    WHERE 
//		        (:isbn IS NULL OR b.isbn = :isbn)
//		        OR (:titre IS NULL OR b.titre = :titre)
//		        OR (:datePublication IS NULL OR b.datePublication = :datePublication)
//		    """)
	@Query("""
		    SELECT b FROM BookEntity b
		    WHERE 
		        CASE 
		            WHEN :isbn IS NOT NULL THEN b.isbn = :isbn
		            WHEN :titre IS NOT NULL THEN b.titre = :titre
		            WHEN :datePublication IS NOT NULL THEN b.datePublication = :datePublication
		            ELSE true
		        END
		    """)
		List<BookEntity> searchOneBook(
		    @Param("isbn") String isbn,
		    @Param("titre") String titre,
		    @Param("datePublication") LocalDate datePublication
		);
	
	@Query("""
		    SELECT b FROM BookEntity b
		    WHERE 
		        (:isbn IS NULL OR b.isbn = :isbn)
		        AND (:titre IS NULL OR b.titre LIKE :titre)
		        AND (:datePublication IS NULL OR b.datePublication = :datePublication)
		    """)
		Optional<BookEntity> findOneBook(
		    @Param("isbn") String isbn,
		    @Param("titre") String titre,
		    @Param("datePublication") LocalDate datePublication
		);
	
	Optional<BookEntity> findByIsbn(String isbn);
	
}
