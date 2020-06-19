package kg.online.book.store.controller;

import kg.online.book.store.entity.DeliveryMethod;
import kg.online.book.store.service.DeliveryMethodService;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery_method")
public class DeliveryMethodController {
    @Autowired
    private DeliveryMethodService deliveryMethodService;

    @PostMapping
    public DeliveryMethod create(@RequestBody DeliveryMethod deliveryMethod){
        return deliveryMethodService.create(deliveryMethod);
    }

    @GetMapping
    public List<DeliveryMethod> getAll(){
        return deliveryMethodService.getAll();
    }

    @GetMapping("/{id}")
    public DeliveryMethod getById(@PathVariable Long id){
        return deliveryMethodService.getById(id);
    }

    @DeleteMapping("/{id}")
    public DeliveryMethod deleteById(@PathVariable Long id){
        return deliveryMethodService.getById(id);
    }

}
