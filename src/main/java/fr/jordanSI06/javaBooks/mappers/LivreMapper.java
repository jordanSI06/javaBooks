package fr.jordanSI06.javaBooks.mappers;

import org.springframework.stereotype.Component;

import fr.jordanSI06.javaBooks.dto.LivreDTO;
import fr.jordanSI06.javaBooks.models.Livre;

@Component
public class LivreMapper {
    public LivreDTO toDTO(Livre livre) {
        return new LivreDTO(livre.getTitre(), livre.getAuteur(), livre.getIsbn());
    }

    public Livre toEntity(LivreDTO dto) {
        Livre livre = new Livre();
        livre.setTitre(dto.titre());
        livre.setAuteur(dto.auteur());
        livre.setIsbn(dto.isbn());
        return livre;
    }
}