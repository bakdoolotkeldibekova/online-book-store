package kg.online.book.store.repository;

import kg.online.book.store.entity.Order;
import kg.online.book.store.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByUserAccount(UserAccount userAccount);
    List<Order> findAllByProductsCostBetween(Double a, Double b);
}
