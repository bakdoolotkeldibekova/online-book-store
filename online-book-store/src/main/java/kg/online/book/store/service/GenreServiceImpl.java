package kg.online.book.store.service;

import kg.online.book.store.entity.Genre;
import kg.online.book.store.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre getById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre deleteById(Long id) {
        Genre genre = getById(id);
        genreRepository.deleteById(id);
        return genre;
    }

    @Override
    public Genre getByName(String name) {
        return genreRepository.findByNameContainingIgnoringCase(name);
    }
}
