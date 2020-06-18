package kg.online.book.store.controller;

import kg.online.book.store.dto.ProductDTO;
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

}
