package kg.online.book.store.service;

import kg.online.book.store.dto.BillDTO;
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
    public Bill create(BillDTO billDTO) {
        Order order = orderService.getById(billDTO.getOrderId());
        if(order == null) return null;

        Bill bill = new Bill();
        bill.setOrder(order);
        bill.setPayed(billDTO.isPayed());
        bill.setTotalCost(billDTO.getTotalCost());
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
}
