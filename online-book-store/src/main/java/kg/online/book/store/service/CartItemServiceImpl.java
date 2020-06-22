package kg.online.book.store.service;

import kg.online.book.store.dto.CartItemDTO;
import kg.online.book.store.entity.Cart;
import kg.online.book.store.entity.CartItem;
import kg.online.book.store.entity.Product;
import kg.online.book.store.entity.UserAccount;
import kg.online.book.store.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public CartItem create(String login, CartItemDTO cartItemDTO) {
        UserAccount userAccount = userAccountService.getByLogin(login);
        if(userAccount != null){
            Cart cart = cartService.getByUserAccount(userAccount);
            Product product = productService.getById(cartItemDTO.getProductId());
            if (cart == null || product == null) return null;

            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(cartItemDTO.getQuantity());
            return cartItemRepository.save(cartItem);
        }
        return null;
    }

    @Override
    public CartItem deleteById(String login, Long id) {
        CartItem cartItem = getById(id);
        Cart cart = cartService.getByUserAccount(userAccountService.getByLogin(login));
        if (!cart.equals(cartItem.getCart()))
            return null;

        cartItemRepository.deleteById(id);
        return cartItem;
    }

    @Override
    public CartItem getById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    @Override
    public List<CartItem> getAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public List<CartItem> getAllMine(String login) {
        UserAccount userAccount = userAccountService.getByLogin(login);
        if (userAccount == null) return null;

        Cart cart = cartService.getByUserAccount(userAccount);
        if (cart == null) return null;

        return cartItemRepository.findAllByCart(cart);
    }
}
