package fr.aba.poc.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aba.poc.library.model.entity.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

	Optional<AuthorEntity> findByPrenomAndNom(String prenom, String nom);
}
