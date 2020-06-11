package kg.online.book.store.service;

import kg.online.book.store.dto.CartItemDTO;
import kg.online.book.store.entity.Cart;
import kg.online.book.store.entity.CartItem;
import kg.online.book.store.entity.Product;
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

    @Override
    public CartItem create(CartItemDTO cartItemDTO) {
        Cart cart = cartService.getById(cartItemDTO.getCartId());
        Product product = productService.getById(cartItemDTO.getProductId());
        if (cart == null || product == null) return null;

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(cartItemDTO.getQuantity());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem deleteById(Long id) {
        CartItem cartItem = getById(id);
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
}
