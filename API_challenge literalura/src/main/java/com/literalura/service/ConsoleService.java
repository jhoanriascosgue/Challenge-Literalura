package com.literalura.service;

import com.literalura.model.Book;
import com.literalura.model.Author;
import com.literalura.service.menu.MenuOption;
import com.literalura.service.menu.MenuPrinter;
import com.literalura.service.printer.BookPrinter;
import com.literalura.service.printer.AuthorPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Scanner;
import java.util.List;

@Service
public class ConsoleService {
    
    @Autowired
    private BookService bookService;
    
    @Autowired
    private AuthorService authorService;
    
    private final Scanner scanner = new Scanner(System.in);
    
    public void startConsoleApplication() {
        boolean running = true;
        while (running) {
            MenuPrinter.printMenu();
            try {
                MenuOption option = MenuOption.fromValue(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                
                running = processMenuOption(option);
            } catch (IllegalArgumentException e) {
                System.out.println("Opción inválida. Por favor intente nuevamente.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }
    
    private boolean processMenuOption(MenuOption option) {
        switch (option) {
            case SEARCH_BOOK:
                searchBookByTitle();
                break;
            case LIST_BOOKS:
                listAllBooks();
                break;
            case LIST_AUTHORS:
                listAllAuthors();
                break;
            case LIST_AUTHORS_BY_YEAR:
                listAuthorsAliveInYear();
                break;
            case LIST_BOOKS_BY_LANGUAGE:
                listBooksByLanguage();
                break;
            case EXIT:
                return false;
        }
        return true;
    }
    
    private void searchBookByTitle() {
        System.out.print("Ingrese el título del libro: ");
        String title = scanner.nextLine();
        List<Book> books = bookService.findBooksByTitle(title);
        
        if (books.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.");
        } else {
            books.forEach(BookPrinter::printBookDetails);
        }
    }
    
    private void listAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            books.forEach(BookPrinter::printBookDetails);
        }
    }
    
    private void listAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        if (authors.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            authors.forEach(AuthorPrinter::printAuthorDetails);
        }
    }
    
    private void listAuthorsAliveInYear() {
        System.out.print("Ingrese el año: ");
        int year = scanner.nextInt();
        List<Author> authors = authorService.findAuthorsAliveInYear(year);
        
        if (authors.isEmpty()) {
            System.out.println("No se encontraron autores vivos en ese año.");
        } else {
            authors.forEach(AuthorPrinter::printAuthorDetails);
        }
    }
    
    private void listBooksByLanguage() {
        System.out.print("Ingrese el idioma (ES/EN/FR/PT): ");
        String language = scanner.nextLine().toUpperCase();
        List<Book> books = bookService.findBooksByLanguage(language);
        
        if (books.isEmpty()) {
            System.out.println("No se encontraron libros en ese idioma.");
        } else {
            books.forEach(BookPrinter::printBookDetails);
        }
    }
}