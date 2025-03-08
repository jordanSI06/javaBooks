package fr.jordanSI06.javaBooks.mappers;

import fr.jordanSI06.javaBooks.dto.LivreDTO;
import fr.jordanSI06.javaBooks.models.Livre;
import org.mapstruct.Mapper;

/*
 * Envoie toutes les propriétés existantes et à venir de l'entité Livre dans le DTO LivreDTO
 */
@Mapper(componentModel = "spring")
public interface LivreMapper {

    LivreDTO toDTO(Livre livre);

    Livre toEntity(LivreDTO dto);
}