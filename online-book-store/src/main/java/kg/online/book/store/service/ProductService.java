package kg.online.book.store.service;

import kg.online.book.store.dto.ProductDTO;
import kg.online.book.store.entity.Image;
import kg.online.book.store.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(ProductDTO productDTO);
    Product getById(Long id);
    List<Product> getAll();
    Product deleteById(Long id);

    Product changeAvailable(Long productId, Boolean isAvailable);
    Product changeDiscount(Long productId, Integer discount);
    Product updateImage(Long productId, Image image);

    List<Product> getAllByNameOrAuthorName(String name);
    List<Product> getAllByPriceBetween(Double a, Double b);
}
