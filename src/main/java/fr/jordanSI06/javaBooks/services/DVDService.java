package fr.jordanSI06.javaBooks.services;

import fr.jordanSI06.javaBooks.exceptions.DVDNonTrouveException;
import fr.jordanSI06.javaBooks.exceptions.LivreNonTrouveException;
import fr.jordanSI06.javaBooks.models.DVD;
import fr.jordanSI06.javaBooks.models.Livre;
import fr.jordanSI06.javaBooks.repositories.DVDRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DVDService {
    private final DVDRepository dvdRepository;

    public DVDService(DVDRepository dvdRepository) {
        this.dvdRepository = dvdRepository;
    }

    public List<DVD> getAllDVD() {
        return dvdRepository.findAll();
    }

    public DVD getDVDById(Long id) {
        return dvdRepository.findById(id).orElseThrow(() -> new DVDNonTrouveException("Dvd avec l'ID " + id + " introuvable."));

    }

    public DVD getDVDByGenre(String genre) {
        return dvdRepository.findByGenre(genre).orElseThrow(() -> new DVDNonTrouveException("Dvd avec le genre " + genre + " introuvable."));
    }

    public DVD getDVDByTitre(String titre) {
        return dvdRepository.findByTitre(titre).orElseThrow(() -> new DVDNonTrouveException("Dvd avec le titre " + titre + " introuvable."));
    }

    public DVD ajouterDVD(DVD dvd) {
        return dvdRepository.save(dvd);
    }

    public void supprimerDVD(Long id) {
        dvdRepository.deleteById(id);
    }

}
