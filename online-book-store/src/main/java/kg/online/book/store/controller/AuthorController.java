package kg.online.book.store.controller;

import kg.online.book.store.entity.Author;
import kg.online.book.store.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public Author create(@RequestBody Author author){
        return authorService.create(author);
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable Long id){
        return authorService.deleteById(id);
    }

    @GetMapping
    public List<Author> getAll(){
        return authorService.getAll();
    }

    @GetMapping("/biography/{biography}")
    public List<Author> getAllByBiography(@PathVariable String biography){
        return authorService.getAllByBiography(biography);
    }

    @GetMapping("/name/{name}")
    public List<Author> getAllByName(@PathVariable String name){
        return authorService.getAllByName(name);
    }

    @DeleteMapping("/{id}")
    public Author deleteById(@PathVariable Long id){
        return authorService.deleteById(id);
    }

}
