package fr.aba.poc.library.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "books")
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
// **** Pour éviter les problèmes Hibernate.
// Pour éviter les boucle infini lors de la sérialisation JSON, 
// on peut utiliser l'annotation @JsonIgnore sur le champ "author" de BookEntity, 
// ou utiliser @ToString(exclude = "author") pour éviter que Lombok 
// n'inclue le champ "author" dans la méthode toString() générée, 
@ToString(exclude = "author")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String titre;
	
	@Column(nullable = false, unique = true)
	private String isbn;
	
	@Column(nullable = false)
	private LocalDate datePublication;
	
	// Plusieurs Books pour un Author
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false) // clé étrangère vers Author
	private AuthorEntity author;
}
