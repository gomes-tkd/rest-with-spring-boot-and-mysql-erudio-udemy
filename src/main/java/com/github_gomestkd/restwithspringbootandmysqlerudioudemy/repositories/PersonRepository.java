package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.repositories;

import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
