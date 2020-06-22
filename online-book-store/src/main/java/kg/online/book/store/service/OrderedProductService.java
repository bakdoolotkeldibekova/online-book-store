package kg.online.book.store.service;

import kg.online.book.store.dto.OrderedProductDTO;
import kg.online.book.store.entity.OrderedProduct;

import java.util.List;

public interface OrderedProductService {
    OrderedProduct create(OrderedProductDTO orderedProductDTO);
    OrderedProduct deleteById(Long id);
    OrderedProduct getById(Long id);
    List<OrderedProduct> getAll();
}
