package kg.online.book.store.controller;

import kg.online.book.store.dto.OrderDTO;
import kg.online.book.store.entity.Order;
import kg.online.book.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order create(Principal principal, @RequestBody OrderDTO orderDTO){
        return orderService.create(principal.getName(), orderDTO);
    }

    @GetMapping
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id){
        return orderService.getById(id);
    }

    @GetMapping("/mine")
    public Order getMine(Principal principal){
        return orderService.getByLogin(principal.getName());
    }

    @GetMapping("/user_acc")
    public Order getByUserAccount(@RequestBody String login){
        return orderService.getByLogin(login);
    }

    @GetMapping("/products_cost")
    public List<Order> getAllByProductsCost(@RequestBody Double a, @RequestBody Double b){
        return orderService.getAllByProductCostBetween(a, b);
    }

    @DeleteMapping("/{id}")
    public Order deleteById(@PathVariable Long id){
        return orderService.deleteById(id);
    }



}
