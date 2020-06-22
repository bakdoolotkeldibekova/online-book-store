package kg.online.book.store.service;

import kg.online.book.store.entity.Bill;
import kg.online.book.store.entity.Order;
import kg.online.book.store.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private OrderService orderService;

    @Override
    public Bill create(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill updatePayed(Long billId, Boolean payed) {
        Bill bill = getById(billId);
        if (bill == null) return  null;

        bill.setPayed(payed);
        return billRepository.save(bill);
    }

    @Override
    public Bill deleteById(Long id) {
        Bill bill = getById(id);
        billRepository.deleteById(id);
        return bill;
    }

    @Override
    public Bill getById(Long id) {
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    @Override
    public List<Bill> getAllByTotalCostBetween(Double a, Double b) {
        return billRepository.findAllByTotalCostBetween(a, b);
    }

    @Override
    public List<Bill> getAllByPayed(Boolean payed) {
        return billRepository.findAllByPayed(payed);
    }

    @Override
    public Bill getByUserLogin(String login) {
        Order order = orderService.getByLogin(login);
        return billRepository.findByOrder(order);
    }
}
