package kg.online.book.store.controller;

import kg.online.book.store.dto.StarsDTO;
import kg.online.book.store.entity.Stars;
import kg.online.book.store.service.StarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/stars")
public class StarsController {
    @Autowired
    private StarsService starsService;

    @PostMapping
    public Stars create(Principal principal, @RequestBody StarsDTO starsDTO){
        return starsService.create(principal.getName(), starsDTO);
    }

    @DeleteMapping("/{id}")
    public Stars deleteById(@PathVariable Long id){
        return starsService.deleteById(id);
    }

    @GetMapping("/{productId}") // from 1 to 5
    public Integer getAverage(@PathVariable Long productId){
        return starsService.getAverage(productId);
    }
}
