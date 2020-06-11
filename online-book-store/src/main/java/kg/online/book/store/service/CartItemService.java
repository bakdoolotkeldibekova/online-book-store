package kg.online.book.store.service;

import kg.online.book.store.dto.CartItemDTO;
import kg.online.book.store.entity.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem create(CartItemDTO cartItemDTO);
    CartItem deleteById(Long id);
    CartItem getById(Long id);
    List<CartItem> getAll();
}
