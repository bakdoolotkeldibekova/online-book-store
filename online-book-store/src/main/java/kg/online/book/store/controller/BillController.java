package kg.online.book.store.controller;

import kg.online.book.store.entity.Bill;
import kg.online.book.store.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @PutMapping("/{billId}/{payed}")
    public Bill updatePayed(@PathVariable Long billId, @PathVariable Boolean payed){
        return billService.updatePayed(billId, payed);
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

    @GetMapping("/total_cost")
    public List<Bill> getAllByTotalCostBetween(@RequestBody Double a, @RequestBody Double b){
        return billService.getAllByTotalCostBetween(a, b);
    }

    @GetMapping("/payed")
    public List<Bill> getAllByPayed(@RequestBody Boolean payed){
        return billService.getAllByPayed(payed);
    }

    @GetMapping("/user/{userLogin}")
    public Bill getByUserLogin(@PathVariable String userLogin){
        return billService.getByUserLogin(userLogin);
    }

}
