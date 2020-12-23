package de.kheuwes.coleman.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.kheuwes.coleman.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
