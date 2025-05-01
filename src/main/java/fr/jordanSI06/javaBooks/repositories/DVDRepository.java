package fr.jordanSI06.javaBooks.repositories;

import fr.jordanSI06.javaBooks.models.DVD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DVDRepository extends JpaRepository<DVD, Long> {
    Optional<DVD> findByTitre(String titre);
    Optional<DVD> findByGenre(String genre);
}
