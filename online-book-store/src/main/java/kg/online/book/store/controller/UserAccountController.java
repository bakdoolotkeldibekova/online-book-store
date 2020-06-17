package kg.online.book.store.controller;

import kg.online.book.store.entity.UserAccount;
import kg.online.book.store.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/{id}")
    public UserAccount getById(@PathVariable Long id){
        return userAccountService.getById(id);
    }

    @GetMapping
    public List<UserAccount> getAll(){
        return userAccountService.getAll();
    }

}
