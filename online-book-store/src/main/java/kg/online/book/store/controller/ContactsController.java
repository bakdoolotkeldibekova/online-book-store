package kg.online.book.store.controller;

import kg.online.book.store.dto.ContactsDTO;
import kg.online.book.store.entity.Contacts;
import kg.online.book.store.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {
    @Autowired
    private ContactsService contactsService;

    @PostMapping
    public Contacts create(Principal principal, @RequestBody ContactsDTO contactsDTO){
        return contactsService.create(principal.getName(), contactsDTO);
    }

    @GetMapping
    public List<Contacts> getAll(){
        return contactsService.getAll();
    }

    @GetMapping("/{id}")
    public Contacts getById(@PathVariable Long id){
        return contactsService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Contacts deleteById(Principal principal, @PathVariable Long id){
        return contactsService.deleteById(principal.getName(), id);
    }

    @GetMapping("/login")
    public Contacts getByUserLogin(@RequestBody String login){
        return contactsService.getByUserLogin(login);
    }

    @PutMapping
    public Contacts update(Principal principal, @RequestBody ContactsDTO contactsDTO){
        return contactsService.update(principal.getName(), contactsDTO);
    }
}
