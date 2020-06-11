package kg.online.book.store.service;

import kg.online.book.store.dto.BillDTO;
import kg.online.book.store.entity.Bill;

import java.util.List;

public interface BillService {
    Bill create(BillDTO billDTO);
    Bill deleteById(Long id);
    Bill getById(Long id);
    List<Bill> getAll();
}
