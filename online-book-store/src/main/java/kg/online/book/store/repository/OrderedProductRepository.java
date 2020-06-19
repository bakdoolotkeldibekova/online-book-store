package kg.online.book.store.repository;

import kg.online.book.store.entity.Order;
import kg.online.book.store.entity.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long> {
    List<OrderedProduct> findAllByOrder(Order order);
}
