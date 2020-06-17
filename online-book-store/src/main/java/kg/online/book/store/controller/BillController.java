package kg.online.book.store.controller;

import kg.online.book.store.dto.BillDTO;
import kg.online.book.store.entity.Bill;
import kg.online.book.store.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping
    public Bill create(@RequestBody BillDTO billDTO){
        return billService.create(billDTO);
    }

    @GetMapping("/{id}")
    public Bill getById(@PathVariable Long id){
        return billService.getById(id);
    }

    @GetMapping
    public List<Bill> getAll(){
        return billService.getAll();
    }

    @DeleteMapping("/{id}")
    public Bill deleteById(@PathVariable Long id){
        return billService.deleteById(id);
    }
}
