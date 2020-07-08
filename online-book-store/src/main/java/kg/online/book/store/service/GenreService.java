package kg.online.book.store.service;

import kg.online.book.store.entity.Genre;

import java.util.List;

public interface GenreService {
    Genre create(Genre genre);
    Genre getById(Long id);
    List<Genre> getAll();
    Genre deleteById(Long id);

    Genre getByName(String name);
}
