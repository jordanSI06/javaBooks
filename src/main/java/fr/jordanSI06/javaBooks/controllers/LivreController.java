package fr.jordanSI06.javaBooks.controllers;

import fr.jordanSI06.javaBooks.dto.LivreDTO;
import fr.jordanSI06.javaBooks.mappers.LivreMapper;
import fr.jordanSI06.javaBooks.models.Livre;
import fr.jordanSI06.javaBooks.services.LivreService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/livres")
public class LivreController {
    private final LivreService livreService;
    private final LivreMapper livreMapper;

    public LivreController(LivreService livreService, LivreMapper livreMapper) {
        this.livreService = livreService;
        this.livreMapper = livreMapper;
    }

    /*
     * Récupérer tous les livres (GET)
     */
    @GetMapping
    public ResponseEntity<List<LivreDTO>> getAllLivres() {
        List<LivreDTO> livres = livreService.getAllLivres()
                .stream()
                .map(livreMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(livres);
    }

    /*
     * Récupérer un livre par son ID (GET)
     */
    @GetMapping("/{id}")
    public ResponseEntity<LivreDTO> getLivreById(@PathVariable Long id) {
        Livre livre = livreService.getLivreById(id);
        return ResponseEntity.ok(livreMapper.toDTO(livre));
    }

    /*
     * Ajouter un livre (POST)
     */
    @PostMapping
    public ResponseEntity<LivreDTO> ajouterLivre(@Valid @RequestBody LivreDTO livreDTO) {
        Livre livre = livreMapper.toEntity(livreDTO);
        Livre savedLivre = livreService.ajouterLivre(livre);
        return ResponseEntity.status(HttpStatus.CREATED).body(livreMapper.toDTO(savedLivre));
    }

    /**
     * Supprimer un livre (DELETE)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerLivre(@PathVariable Long id) {
        livreService.supprimerLivre(id);
        return ResponseEntity.noContent().build();
    }
}
