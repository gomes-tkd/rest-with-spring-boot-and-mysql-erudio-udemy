package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.services;

import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.dto.BookDTO;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.exception.RequiredObjectIsNullException;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.model.Book;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.repositories.BookRepository;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.unitytests.mapper.mocks.MockBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BookServicesTest {

    MockBook input;

    @InjectMocks
    private BookServices service;

    @Mock
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        this.input = new MockBook();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        List<Book> bookList = input.mockEntityList();

        when(bookRepository.findAll()).thenReturn(bookList);

        List<BookDTO> people = service.findAll();

        assertNotNull(people);
        assertEquals(14, people.size());

        BookDTO bookOne = people.get(1);

        bookOne.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/book/1")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        bookOne.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        bookOne.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        bookOne.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        bookOne.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals(1L, bookOne.getId());
        assertEquals("Title Test: 1", bookOne.getTitle());
        assertEquals("Author Test: 1",  bookOne.getAuthor());
        assertEquals(25.25D, bookOne.getPrice());
        assertNotNull(bookOne.getLaunchDate());

        BookDTO bookFour = people.get(4);

        bookFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/book/4")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        bookFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        bookFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        bookFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        bookFour.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/book/4")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals(4L, bookFour.getId());
        assertEquals("Title Test: 4", bookFour.getTitle());
        assertEquals("Author Test: 4",  bookFour.getAuthor());
        assertEquals(25.25D, bookFour.getPrice());
        assertNotNull(bookFour.getLaunchDate());


        BookDTO bookSeven = people.get(7);

        bookSeven.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/book/7")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        bookSeven.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        bookSeven.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        bookSeven.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        bookSeven.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/book/7")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals(7L, bookSeven.getId());
        assertEquals("Title Test: 7", bookSeven.getTitle());
        assertEquals("Author Test: 7",  bookSeven.getAuthor());
        assertEquals(25.25D, bookSeven.getPrice());
        assertNotNull(bookSeven.getLaunchDate());


        BookDTO bookThirteen = people.get(13);

        bookThirteen.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/book/13")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        bookThirteen.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        bookThirteen.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        bookThirteen.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        bookThirteen.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/book/13")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals(13L, bookThirteen.getId());
        assertEquals("Title Test: 7", bookSeven.getTitle());
        assertEquals("Author Test: 7",  bookSeven.getAuthor());
        assertEquals(25.25D, bookSeven.getPrice());
        assertNotNull(bookThirteen.getLaunchDate());
    }

    @Test
    void findById() {
        Book book = input.mockEntity(1);
        book.setId(1L);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        BookDTO result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/book/1")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/book/1")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals(1L, result.getId());
        assertEquals("Title Test: 1", result.getTitle());
        assertEquals("Author Test: 1",  result.getAuthor());
        assertEquals(25.25D, result.getPrice());
        assertNotNull(result.getLaunchDate());
    }

    @Test
    void create() {
        Book book = input.mockEntity(1);
        Book persisted = book;
        persisted.setId(1L);

        BookDTO dto = input.mockDTO(1);

        when(bookRepository.save(any(Book.class))).thenReturn(persisted);

        var result = service.create(dto);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/book/1")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals(1L, result.getId());
        assertEquals("Title Test: 1", result.getTitle());
        assertEquals("Author Test: 1",  result.getAuthor());
        assertEquals(25.25D, result.getPrice());
        assertNotNull(result.getLaunchDate());
    }

    @Test
    void createWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.create(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void update() {
        Book person = input.mockEntity(1);
        Book persisted = person;
        persisted.setId(1L);

        BookDTO dto = input.mockDTO(1);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(person));
        when(bookRepository.save(person)).thenReturn(persisted);

        BookDTO result = service.update(dto);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("self")
                            || !link.getHref().endsWith("/api/v1/book/1")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("findAll")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("GET");
                }
        );


        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("create")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("POST");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("update")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("PUT");
                }
        );

        result.getLinks().stream().anyMatch(
                link -> {
                    if (!link.getRel().value().equals("delete")
                            || !link.getHref().endsWith("/api/v1/book/")) return false;
                    assertNotNull(link.getType());
                    return link.getType().equals("DELETE");
                }
        );

        assertEquals(1L, result.getId());
        assertEquals("Title Test: 1", result.getTitle());
        assertEquals("Author Test: 1",  result.getAuthor());
        assertEquals(25.25D, result.getPrice());
        assertNotNull(result.getLaunchDate());
    }

    @Test
    void updateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.update(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void delete() {
        Book book = input.mockEntity(1);
        book.setId(1L);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        service.delete(1L);

        verify(bookRepository, times(1)).findById(anyLong());
        verify(bookRepository, times(1)).delete(any(Book.class));
        verifyNoMoreInteractions(bookRepository);
    }
}