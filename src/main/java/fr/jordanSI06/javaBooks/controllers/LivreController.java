package fr.jordanSI06.javaBooks.controllers;

import fr.jordanSI06.javaBooks.models.Livre;
import fr.jordanSI06.javaBooks.services.LivreService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreController {
    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id) {
        return livreService.getLivreById(id);
    }

    @PostMapping
    public Livre ajouterLivre(@RequestBody Livre livre) {
        return livreService.ajouterLivre(livre);
    }

    @DeleteMapping("/{id}")
    public void supprimerLivre(@PathVariable Long id) {
        livreService.supprimerLivre(id);
    }
}
