package kg.online.book.store.service;

import kg.online.book.store.entity.Cart;
import kg.online.book.store.entity.UserAccount;
import kg.online.book.store.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart deleteById(Long id) {
        Cart cart = getById(id);
        cartRepository.deleteById(id);
        return cart;
    }

    @Override
    public Cart getById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getByUserAccount(UserAccount userAccount) {
        return cartRepository.findByUserAccount(userAccount);
    }
}
