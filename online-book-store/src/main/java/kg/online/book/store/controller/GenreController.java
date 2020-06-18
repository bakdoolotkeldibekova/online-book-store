package kg.online.book.store.controller;

import kg.online.book.store.entity.Genre;
import kg.online.book.store.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping
    public Genre create(@RequestBody Genre genre){
        return genreService.create(genre);
    }

    @GetMapping("/{id}")
    public Genre getById(@PathVariable Long id){
        return genreService.getById(id);
    }

    @GetMapping
    public List<Genre> getAll(){
        return genreService.getAll();
    }

    @DeleteMapping("/{id}")
    public Genre deleteById(@PathVariable Long id){
        return genreService.deleteById(id);
    }
}
