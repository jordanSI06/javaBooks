package fr.jordanSI06.javaBooks.services;

import fr.jordanSI06.javaBooks.models.Livre;
import fr.jordanSI06.javaBooks.repositories.LivreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LivreServiceTest {

    @Mock
    private LivreRepository livreRepository;

    @InjectMocks
    private LivreService livreService;

    private Livre livre;

    @BeforeEach
    void setUp() {
        livre = new Livre(50L, "Dune", "Frank Herbert", "978-0441013593");
    }

    @Test
    void getLivreById_found() {
        when(livreRepository.findById(50L)).thenReturn(Optional.of(livre));

        Livre result = livreService.getLivreById(50L);

        assertNotNull(result);
        assertEquals("Dune", result.getTitre());
    }

    @Test
    void getLivreById_notFound() {
        when(livreRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            livreService.getLivreById(1L);
        });

        assertTrue(exception.getMessage().contains("Livre avec l'ID"));
    }

    @Test
    void getLivreByIsbn_Found() {
        when(livreRepository.findByIsbn("978-0441013593")).thenReturn(Optional.of(livre));

        Livre result = livreService.getLivreByIsbn("978-0441013593");

        assertNotNull(result);
        assertEquals("Dune", result.getTitre());
    }
}