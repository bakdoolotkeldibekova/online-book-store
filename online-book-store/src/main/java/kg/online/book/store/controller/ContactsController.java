package kg.online.book.store.controller;

import kg.online.book.store.dto.ContactsDTO;
import kg.online.book.store.entity.Contacts;
import kg.online.book.store.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {
    @Autowired
    private ContactsService contactsService;

    @PostMapping
    public Contacts create(@RequestBody ContactsDTO contactsDTO){
        return contactsService.create(contactsDTO);
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
    public Contacts deleteById(@PathVariable Long id){
        return contactsService.deleteById(id);
    }

}
