package kg.online.book.store.controller;

import kg.online.book.store.dto.CartItemDTO;
import kg.online.book.store.entity.CartItem;
import kg.online.book.store.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/cart_item")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public CartItem create(Principal principal, @RequestBody CartItemDTO cartItemDTO){
        return cartItemService.create(principal.getName(), cartItemDTO);
    }

    @GetMapping
    public List<CartItem> getAll(){
        return cartItemService.getAll();
    }

    @GetMapping("/mine")
    public List<CartItem> getAllMine(Principal principal){
        return cartItemService.getAllMine(principal.getName());
    }

    @GetMapping("/{id}")
    public CartItem getById(@PathVariable Long id){
        return cartItemService.getById(id);
    }

    @DeleteMapping("/{id}")
    public CartItem deleteById(Principal principal, @PathVariable Long id){
        return cartItemService.deleteById(principal.getName(), id);
    }
}
