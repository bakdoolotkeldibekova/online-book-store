package kg.online.book.store.service;

import kg.online.book.store.entity.Cart;
import kg.online.book.store.entity.UserAccount;

import java.util.List;

public interface CartService {
    Cart create(Cart cart);
    Cart deleteById(Long id);
    Cart getById(Long id);
    List<Cart> getAll();

    Cart getByUserAccount(UserAccount userAccount);
}
