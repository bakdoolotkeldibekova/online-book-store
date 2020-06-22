package kg.online.book.store.controller;

import kg.online.book.store.dto.OrderedProductDTO;
import kg.online.book.store.entity.OrderedProduct;
import kg.online.book.store.service.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/ordered_product")
public class OrderedProductController {
    @Autowired
    private OrderedProductService orderedProductService;

    @PostMapping
    public OrderedProduct create(@RequestBody OrderedProductDTO orderedProductDTO){
        return orderedProductService.create(orderedProductDTO);
    }

    @GetMapping
    public List<OrderedProduct> getAll(){
        return orderedProductService.getAll();
    }

    @GetMapping("/{id}")
    public OrderedProduct getById(@PathVariable Long id){
        return orderedProductService.getById(id);
    }

    @DeleteMapping("/{id}")
    public OrderedProduct deleteById(@PathVariable Long id){
        return orderedProductService.deleteById(id);
    }

}
