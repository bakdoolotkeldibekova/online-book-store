package kg.online.book.store.service;

import kg.online.book.store.dto.OrderDTO;
import kg.online.book.store.entity.Order;

import java.util.List;

public interface OrderService {
    Order create(OrderDTO orderDTO);
    Order deleteById(Long id);
    Order getById(Long id);
    List<Order> getAll();
}
