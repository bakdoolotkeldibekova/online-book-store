package kg.online.book.store.service;

import kg.online.book.store.entity.Author;

import java.util.List;

public interface AuthorService {
    Author create(Author author);
    Author deleteById(Long id);
    Author getById(Long id);
    List<Author> getAll();

    List<Author> getAllByName(String name);
    List<Author> getAllByBiography(String biography);
}
