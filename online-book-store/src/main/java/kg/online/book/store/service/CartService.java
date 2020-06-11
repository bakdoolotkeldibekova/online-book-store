package kg.online.book.store.service;

import kg.online.book.store.dto.CartDTO;
import kg.online.book.store.entity.Cart;

import java.util.List;

public interface CartService {
    Cart create(CartDTO cartDTO);
    Cart deleteById(Long id);
    Cart getById(Long id);
    List<Cart> getAll();
}
