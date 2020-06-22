package kg.online.book.store.repository;

import kg.online.book.store.entity.Bill;
import kg.online.book.store.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findAllByTotalCostBetween(Double a, Double b);
    List<Bill> findAllByPayed(Boolean payed);
    Bill findByOrder(Order order);
}
