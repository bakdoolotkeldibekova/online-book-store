package kg.online.book.store.service;

import kg.online.book.store.dto.CartItemDTO;
import kg.online.book.store.entity.Cart;
import kg.online.book.store.entity.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem create(String login, CartItemDTO cartItemDTO);
    CartItem deleteById(String login, Long id);
    CartItem getById(Long id);
    List<CartItem> getAll();

    List<CartItem> getAllMine(String login);
}
