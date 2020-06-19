package kg.online.book.store.controller;

import kg.online.book.store.dto.OrderDTO;
import kg.online.book.store.entity.Order;
import kg.online.book.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order create(@RequestBody OrderDTO orderDTO){
        return orderService.create(orderDTO);
    }

    @GetMapping
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id){
        return orderService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Order deleteById(@PathVariable Long id){
        return orderService.deleteById(id);
    }

}