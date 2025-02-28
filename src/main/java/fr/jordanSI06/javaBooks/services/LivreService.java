package fr.jordanSI06.javaBooks.services;

import fr.jordanSI06.javaBooks.models.Livre;
import fr.jordanSI06.javaBooks.repositories.LivreRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LivreService {
    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Optional<Livre> getLivreById(Long id) {
        return livreRepository.findById(id);
    }

    public Livre ajouterLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public void supprimerLivre(Long id) {
        livreRepository.deleteById(id);
    }
}
