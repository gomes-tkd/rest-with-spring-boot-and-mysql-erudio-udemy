package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.repositories;

import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
