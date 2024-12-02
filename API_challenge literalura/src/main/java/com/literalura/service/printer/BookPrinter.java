package com.literalura.service.printer;

import com.literalura.model.Book;

public class BookPrinter {
    public static void printBookDetails(Book book) {
        System.out.println("\nTítulo: " + book.getTitle());
        System.out.println("Autor: " + book.getAuthor().getLastName() + ", " + 
                          book.getAuthor().getFirstName());
        System.out.println("Idioma: " + book.getLanguage());
        System.out.println("Descargas: " + book.getDownloads());
    }
}