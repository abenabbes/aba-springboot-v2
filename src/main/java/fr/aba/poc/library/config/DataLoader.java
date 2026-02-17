package fr.aba.poc.library.config;

import org.springframework.boot.CommandLineRunner;

//@Component
//@Profile("dev")
//@AllArgsConstructor
//@Slf4j
public class DataLoader implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

//	private final AuthorRepository authorRepository;
//    private final BookRepository bookRepository;
//    
//	@Override
//	public void run(String... args) throws Exception {
//		// Pour éviter les doublons lors du redémarrage de l'application
//		if(authorRepository.count() > 0 || bookRepository.count() > 0) {
//			return;
//		}
//		
//		// Créer un Author 
//		var authorEntity = authorRepository.save(
//				AuthorEntity.builder()
//				.prenom("Victor")
//				.nom("Hugo")
//				.sexe(Gender.M)
//				.build()
//				);
//		
//		// Créer des Books associés à l'Author
//		BookEntity book1 = BookEntity.builder()
//				.titre("Les Misérables")
//				.isbn("123456789")
//				.datePublication(LocalDate.of(1862, 4, 3))
//				.author(authorEntity)
//				.build();
//		
//		BookEntity book2 = BookEntity.builder()
//				.titre("Notre Dame de Paris")
//				.isbn("567891234")
//				.datePublication(LocalDate.of(1862, 4, 3))
//				.author(authorEntity)
//				.build();
//		
//		bookRepository.saveAll(List.of(book1, book2));
//		
//	log.debug("DataLoader a inséré un auteur et ses livres en base de données pour le profil 'dev'");	
//		
//	}

}
