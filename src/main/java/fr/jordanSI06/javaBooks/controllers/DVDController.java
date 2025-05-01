package fr.jordanSI06.javaBooks.controllers;

import fr.jordanSI06.javaBooks.dto.DVDDTO;
import fr.jordanSI06.javaBooks.dto.LivreDTO;
import fr.jordanSI06.javaBooks.mappers.DVDMapper;
import fr.jordanSI06.javaBooks.models.DVD;
import fr.jordanSI06.javaBooks.models.Livre;
import fr.jordanSI06.javaBooks.services.DVDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dvd")
public class DVDController {
    private final DVDService dvdService;
    private final DVDMapper dvdMapper;

    public DVDController(DVDService dvdService, DVDMapper dvdMapper) {
        this.dvdService = dvdService;
        this.dvdMapper = dvdMapper;
    }

    /*
     * Récupérer tous les dvd (GET)
     */
    @GetMapping
    public ResponseEntity<List<DVDDTO>> getAllDVD() {
        List<DVDDTO> dvds = dvdService.getAllDVD()
                .stream()
                .map(dvdMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dvds);
    }

    /*
     * Récupérer un dvd par son ID (GET)
     */
    @GetMapping("/{id}")
    public ResponseEntity<DVDDTO> getDVDById(@PathVariable Long id) {
        DVD dvd = dvdService.getDVDById(id);
        return ResponseEntity.ok(dvdMapper.toDTO(dvd));
    }

    /*
     * Ajouter un dvd (POST)
     */
    @PostMapping
    public ResponseEntity<DVDDTO> ajouterDVD(@Valid @RequestBody DVDDTO dvdDTO) {
        DVD dvd = dvdMapper.toEntity(dvdDTO);
        DVD savedDVD = dvdService.ajouterDVD(dvd);
        return ResponseEntity.status(HttpStatus.CREATED).body(dvdMapper.toDTO(savedDVD));
    }

    /**
     * Supprimer un dvd (DELETE)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerDVD(@PathVariable Long id) {
        dvdService.supprimerDVD(id);
        return ResponseEntity.noContent().build();
    }
}