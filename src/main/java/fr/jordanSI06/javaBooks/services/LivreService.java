package fr.jordanSI06.javaBooks.services;

import fr.jordanSI06.javaBooks.models.Livre;
import fr.jordanSI06.javaBooks.repositories.LivreRepository;
import fr.jordanSI06.javaBooks.exceptions.LivreNonTrouveException;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class LivreService {
    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Livre getLivreById(Long id) {
        return livreRepository.findById(id).orElseThrow(() -> new LivreNonTrouveException("Livre avec l'ID " + id + " introuvable."));

    }

    public Livre getLivreByIsbn(String isbn) {
        return livreRepository.findByIsbn(isbn).orElseThrow(() -> new LivreNonTrouveException("Livre avec l'ISBN " + isbn + " introuvable."));
    }

    public Livre ajouterLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public void supprimerLivre(Long id) {
        livreRepository.deleteById(id);
    }

    
}
