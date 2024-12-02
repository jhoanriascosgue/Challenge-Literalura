package com.literalura.controller;

import com.literalura.model.Book;
import com.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooksByTitle(@RequestParam String title) {
        return ResponseEntity.ok(bookService.findBooksByTitle(title));
    }
    
    @GetMapping("/language/{language}")
    public ResponseEntity<List<Book>> getBooksByLanguage(@PathVariable String language) {
        return ResponseEntity.ok(bookService.findBooksByLanguage(language));
    }
    
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }
}