package fr.jordanSI06.javaBooks.mappers;

import fr.jordanSI06.javaBooks.dto.DVDDTO;
import fr.jordanSI06.javaBooks.models.DVD;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DVDMapper {

    DVDDTO toDTO(DVD dvd);
    DVD toEntity(DVDDTO dto);
}
