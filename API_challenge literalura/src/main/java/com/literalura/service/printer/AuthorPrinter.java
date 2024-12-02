package com.literalura.service.printer;

import com.literalura.model.Author;

public class AuthorPrinter {
    public static void printAuthorDetails(Author author) {
        System.out.println("\nAutor: " + author.getLastName() + ", " + 
                          author.getFirstName());
        System.out.println("Año de nacimiento: " + author.getBirthYear());
        System.out.println("Año de fallecimiento: " + 
                          (author.getDeathYear() != null ? author.getDeathYear() : "Presente"));
        System.out.println("Cantidad de libros: " + author.getBooks().size());
    }
}