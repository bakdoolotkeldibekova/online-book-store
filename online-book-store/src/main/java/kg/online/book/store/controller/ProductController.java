package kg.online.book.store.controller;

import kg.online.book.store.dto.ProductDTO;
import kg.online.book.store.entity.Image;
import kg.online.book.store.entity.Product;
import kg.online.book.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product create(@RequestBody ProductDTO productDTO){
        return productService.create(productDTO);
    }

    @GetMapping("/name")
    public List<Product> getAllByName(@RequestBody String name) {
        return productService.getAllByName(name);
    }

    @GetMapping("/author_name")
    public List<Product> getAllByAuthorName(@RequestBody String authorName) {
        return productService.getAllByAuthorName(authorName);
    }

    @GetMapping("/genre")
    public List<Product> getAllByGenreName(@RequestBody String genreName) {
        return productService.getAllByGenreList(genreName);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @DeleteMapping("/{id}")
    public Product deleteById(@PathVariable Long id){
        return productService.deleteById(id);
    }

    @PutMapping("/isAvailable/{productId}")
    public Product changeAvailable(@PathVariable Long productId, @RequestBody Boolean isAvailable){
        return productService.changeAvailable(productId, isAvailable);
    }

    @PutMapping("/discount/{productId}")
    public Product changeDiscount(@PathVariable Long productId, @RequestBody Integer discount){
        return productService.changeDiscount(productId, discount);
    }

    @PutMapping("/image/{productId}")
    public Product updateImage(@PathVariable Long productId, @RequestBody Image image){
        return productService.updateImage(productId, image);
    }

}
