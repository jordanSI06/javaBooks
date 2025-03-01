package fr.jordanSI06.javaBooks.repositories;

import fr.jordanSI06.javaBooks.models.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {
    Optional<Livre> findByIsbn(String isbn);
    Optional<Livre> findByTitle(String title);
}
