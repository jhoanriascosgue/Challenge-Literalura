package com.literalura.controller;

import com.literalura.model.Author;
import com.literalura.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;
    
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }
    
    @GetMapping("/alive")
    public ResponseEntity<List<Author>> getAuthorsAliveInYear(@RequestParam Integer year) {
        return ResponseEntity.ok(authorService.findAuthorsAliveInYear(year));
    }
}