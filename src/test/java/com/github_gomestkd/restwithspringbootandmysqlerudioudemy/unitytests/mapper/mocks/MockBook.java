package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.unitytests.mapper.mocks;

import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.dto.BookDTO;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.model.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {
    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> booksList = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            booksList.add(mockEntity(i));
        }

        return booksList;
    }

    public List<BookDTO> mockEntityDTOList() {
        List<BookDTO> bookDTOList = new ArrayList<BookDTO>();

        for (int i = 0; i < 14; i++) {
            bookDTOList.add(mockDTO(i));
        }

        return bookDTOList;
    }

    public Book mockEntity(Integer id) {
        Book book = new Book();

        book.setId(id.longValue());
        book.setTitle("Title Test: " + id);
        book.setAuthor("Author Test: " + id);
        book.setPrice(25.25D);
        book.setLaunchDate(new Date());

        return book;
    }

    public BookDTO mockDTO(Integer id) {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setId(id.longValue());
        bookDTO.setTitle("Title Test: " + id);
        bookDTO.setAuthor("Author Test: " + id);
        bookDTO.setPrice(25.25D);
        bookDTO.setLaunchDate(new Date());

        return bookDTO;
    }
}
