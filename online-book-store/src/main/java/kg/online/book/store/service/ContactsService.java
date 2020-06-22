package kg.online.book.store.service;

import kg.online.book.store.dto.ContactsDTO;
import kg.online.book.store.entity.Contacts;

import java.util.List;

public interface ContactsService {
    Contacts create(String login, ContactsDTO contactsDTO);
    Contacts update(String login, ContactsDTO contactsDTO);
    Contacts deleteById(String login, Long id);
    Contacts getById(Long id);
    List<Contacts> getAll();

    Contacts getByUserLogin(String login);
}
