package kg.online.book.store.service;

import kg.online.book.store.entity.Bill;
import kg.online.book.store.entity.UserAccount;

import java.util.List;

public interface BillService {
    Bill create(Bill bill);
    Bill updatePayed(Long billId, Boolean payed);
    Bill deleteById(Long id);
    Bill getById(Long id);
    List<Bill> getAll();

    List<Bill> getAllByTotalCostBetween(Double a, Double b);
    List<Bill> getAllByPayed(Boolean payed);
    Bill getByUserLogin(String login);
}
