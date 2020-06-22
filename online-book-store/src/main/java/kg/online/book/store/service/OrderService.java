package kg.online.book.store.service;

import kg.online.book.store.dto.OrderDTO;
import kg.online.book.store.entity.Order;
import kg.online.book.store.entity.UserAccount;

import java.util.List;

public interface OrderService {
    Order create(String login, OrderDTO orderDTO);
    Order deleteById(Long id);
    Order getById(Long id);
    List<Order> getAll();

    Order getByLogin(String login);
    List<Order> getAllByProductCostBetween(Double a, Double b);
}
