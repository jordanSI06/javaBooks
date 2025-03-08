package fr.jordanSI06.javaBooks.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record LivreDTO(
    @NotBlank String titre,
    @NotBlank String auteur,
    @Pattern(regexp = "\\d{13}", message = "L'ISBN doit contenir 13 chiffres")
    String isbn
) {}