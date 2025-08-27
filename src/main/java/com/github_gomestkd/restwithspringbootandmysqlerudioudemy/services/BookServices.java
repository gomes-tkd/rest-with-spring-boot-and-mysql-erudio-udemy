package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.services;

import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.controllers.BookController;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.controllers.PersonController;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.dto.BookDTO;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.dto.PersonDTO;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.exception.RequiredObjectIsNullException;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.exception.ResourceNotFoundException;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.model.Book;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.model.Person;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github_gomestkd.restwithspringbootandmysqlerudioudemy.mapper.ObjectMapper.parseListObjects;
import static com.github_gomestkd.restwithspringbootandmysqlerudioudemy.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {
    private final Logger logger = LoggerFactory.getLogger(BookServices.class);

    @Autowired
    private BookRepository repository;

    public List<BookDTO> findAll() {
        logger.debug("[START] findAll - Finding all books...");
        List<Book> books = repository.findAll();
        logger.info("[SUCCESS] findAll - Found {} books.", books.size());
        List<BookDTO> booksDTO =  parseListObjects(books, BookDTO.class);

        booksDTO.forEach(BookServices::addHateoasLinks);

        return booksDTO;
    }

    public BookDTO findById(Long id) {
        logger.debug("[START] findById - Attempting to find person with ID: {}", id);
        try {
            Book book = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));
            logger.info("[SUCCESS] findById - Successfully found person with ID: {}", id);

            BookDTO dto = parseObject(book, BookDTO.class);

            addHateoasLinks(dto);

            return dto;
        } catch (ResourceNotFoundException e) {
            logger.warn("[NOT_FOUND] findById - Person not found with ID: {}. Reason: {}", id, e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("[ERROR] findById - An unexpected error occurred while finding person with ID: {}", id, e);
            throw e;
        }
    }

    public BookDTO create(BookDTO person) {
        if (person == null) {
            throw new RequiredObjectIsNullException();
        }

        logger.debug("[START] create - Attempting to create a new person. Input: {}", person);
        try {
            Book createdPerson = parseObject(person, Book.class);

            logger.info("[SUCCESS] create - Successfully created person with ID: {}", createdPerson.getId());

            BookDTO dto = parseObject(repository.save(createdPerson), BookDTO.class);

            addHateoasLinks(dto);

            return dto;
        } catch (Exception e) {
            logger.error("[ERROR] create - Failed to create person. Input: {}. Reason: {}", person, e.getMessage(), e);
            throw e;
        }
    }

    public BookDTO update(BookDTO book) {
        if (book     == null) {
            throw new RequiredObjectIsNullException();
        }

        Long id = book.getId();
        logger.debug("[START] update - Attempting to update person with ID: {}. Input: {}", id, book);

        try {
            Book updatedBook = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setPrice(book.getPrice());
            updatedBook.setLaunchDate(book.getLaunchDate());

            logger.info("[SUCCESS] update - Successfully updated person with ID: {}", id);
            BookDTO dto = parseObject(repository.save(updatedBook), BookDTO.class);

            addHateoasLinks(dto);

            return dto;
        } catch (ResourceNotFoundException e) {
            logger.warn("[NOT_FOUND] update - Person to update not found with ID: {}. Reason: {}", id, e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("[ERROR] update - Failed to update person with ID: {}. Reason: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    public void delete(Long id) {
        logger.debug("[START] delete - Attempting to delete person with ID: {}", id);
        try {
            Book entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

            repository.delete(entity);
            logger.info("[SUCCESS] delete - Successfully deleted person with ID: {}", id);
        } catch (ResourceNotFoundException e) {
            logger.warn("[NOT_FOUND] delete - Person to delete not found with ID: {}. Reason: {}", id, e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("[ERROR] delete - Failed to delete person with ID: {}. Reason: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    private static void addHateoasLinks(BookDTO dto) {
        dto.add(linkTo(methodOn(BookController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).create(dto)).withRel("create").withType("PUT"));
        dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(BookController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
        // Implement HATEOAS links for BookDTO if needed
    }
}
