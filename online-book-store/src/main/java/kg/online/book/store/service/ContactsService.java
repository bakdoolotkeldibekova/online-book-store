package kg.online.book.store.service;

import kg.online.book.store.dto.ContactsDTO;
import kg.online.book.store.entity.Contacts;

import java.util.List;

public interface ContactsService {
    Contacts create(ContactsDTO contactsDTO);
    Contacts deleteById(Long id);
    Contacts getById(Long id);
    List<Contacts> getAll();
}
