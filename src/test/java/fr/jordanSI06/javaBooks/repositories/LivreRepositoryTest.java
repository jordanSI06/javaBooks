package fr.jordanSI06.javaBooks.repositories;

import fr.jordanSI06.javaBooks.models.Livre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class LivreRepositoryTest {

    @Autowired
    private LivreRepository livreRepository;

    @Test
    void testSaveAndFind() {
        Livre livre = new Livre();
        livre.setTitre("Dune");
        livre.setAuteur("Frank Herbert");
        livre.setIsbn("9780441013593");

        Livre savedLivre = livreRepository.save(livre);
        Livre foundLivre = livreRepository.findById(savedLivre.getId()).orElse(null);

        assertThat(foundLivre).isNotNull();
        assertThat(foundLivre.getTitre()).isEqualTo("Dune");
    }
}