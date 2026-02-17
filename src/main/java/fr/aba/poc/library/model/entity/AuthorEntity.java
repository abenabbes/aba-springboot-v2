package fr.aba.poc.library.model.entity;

import java.util.List;

import fr.aba.poc.library.model.Gender;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "authors",
	   uniqueConstraints = {
        // Un Author ne peut pas avoir le même prénom + nom qu'un autre Author
		// (contraintes d'unicité sur les colonnes prenom et nom)
			   @UniqueConstraint(columnNames = {"prenom", "nom"})
			}
		)
// Annotation Lombok
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String prenom;
	
	@Column(nullable = false)	
	private String nom;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender sexe;
	
	// Un Author pour plusieurs Books
	@OneToMany(
			mappedBy = "author",
			fetch = FetchType.LAZY, // LAZY partout par défaut (évite 80% des bugs de perf)
								 // chargement différé des Books d'un Author
			                     // (utile si on n'a pas toujours besoin des Books)
			cascade = CascadeType.ALL,
			orphanRemoval = true // orphanRemoval évite les incohérences : si un Book n'est plus rattaché à un Author, il est supprimé de la BDD
			)
	private List<BookEntity> books;
	
	public void addBook(BookEntity book) {
		books.add(book);
		book.setAuthor(this);
	}
	
	public void removeBook(BookEntity book) {
		books.remove(book);
		book.setAuthor(null);
	}
}
