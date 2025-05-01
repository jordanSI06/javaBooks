package fr.jordanSI06.javaBooks.dto;

import jakarta.validation.constraints.NotBlank;

public record DVDDTO(
        Long id,
        @NotBlank String auteur,
        @NotBlank String realisateur
) {}
