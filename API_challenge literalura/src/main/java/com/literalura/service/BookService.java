package com.literalura.service;

import com.literalura.model.Book;
import com.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
    
    public List<Book> findBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language.toUpperCase());
    }
    
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}