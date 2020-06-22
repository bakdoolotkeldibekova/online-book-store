package kg.online.book.store.service;

import kg.online.book.store.dto.ProductDTO;
import kg.online.book.store.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(ProductDTO productDTO);
    Product getById(Long id);
    List<Product> getAll();
    Product deleteById(Long id);

    Product changeAvailable(Long productId, Boolean isAvailable);
    Product changeDiscount(Long productId, Integer discount);
}
