package fr.jordanSI06.javaBooks.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // Lombok : Génère les getters, setters, toString
@NoArgsConstructor
@AllArgsConstructor
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String auteur;
    private String isbn;
}
