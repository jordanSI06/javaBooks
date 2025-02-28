package fr.jordanSI06.javaBooks.exceptions;

public class LivreNonTrouveException extends RuntimeException {
    public LivreNonTrouveException(String message) {
        super(message);
    }
}