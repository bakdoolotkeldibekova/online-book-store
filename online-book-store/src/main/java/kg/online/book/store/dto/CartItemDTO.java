package kg.online.book.store.dto;

import kg.online.book.store.entity.Cart;
import kg.online.book.store.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartItemDTO {
    private Long cartId;
    private Long productId;
    private int quantity;
}
