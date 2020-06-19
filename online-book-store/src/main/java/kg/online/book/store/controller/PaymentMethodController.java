package kg.online.book.store.controller;

import kg.online.book.store.entity.PaymentMethod;
import kg.online.book.store.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment_method")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping
    public PaymentMethod create(@RequestBody PaymentMethod paymentMethod){
        return paymentMethodService.create(paymentMethod);
    }

    @GetMapping
    public List<PaymentMethod> getAll(){
        return paymentMethodService.getAll();
    }

    @GetMapping("/{id}")
    public PaymentMethod getById(@PathVariable Long id){
        return paymentMethodService.getById(id);
    }

    @DeleteMapping("/{id}")
    public PaymentMethod deleteById(@PathVariable Long id){
        return paymentMethodService.getById(id);
    }

}
