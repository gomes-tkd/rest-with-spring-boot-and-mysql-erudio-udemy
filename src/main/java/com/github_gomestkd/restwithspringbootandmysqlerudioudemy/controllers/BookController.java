package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.controllers;

import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.controllers.docs.BookControllerDocs;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.controllers.docs.PersonControllerDocs;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.dto.BookDTO;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.dto.PersonDTO;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.model.Book;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.services.BookServices;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.services.PersonServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@Tag(name = "Book", description = "Endpoints for Managing Books")
public class BookController implements BookControllerDocs {

    @Autowired
    private BookServices service;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<BookDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
    @Override
    public BookDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(produces =  MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
    @Override
    public BookDTO create(@RequestBody BookDTO book) {
        return service.create(book);
    }

    @PutMapping(produces =  MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
    @Override
    public BookDTO update(@RequestBody BookDTO book) {
        return service.update(book);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
