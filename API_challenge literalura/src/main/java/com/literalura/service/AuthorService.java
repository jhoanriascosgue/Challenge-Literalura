package com.literalura.service;

import com.literalura.model.Author;
import com.literalura.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository authorRepository;
    
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
    
    public List<Author> findAuthorsAliveInYear(Integer year) {
        return authorRepository.findAuthorsAliveInYear(year);
    }
}