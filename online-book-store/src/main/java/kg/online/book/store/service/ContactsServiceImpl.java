package kg.online.book.store.service;

import kg.online.book.store.dto.ContactsDTO;
import kg.online.book.store.entity.Contacts;
import kg.online.book.store.entity.UserAccount;
import kg.online.book.store.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public Contacts create(String login, ContactsDTO contactsDTO) {
        UserAccount userAccount = userAccountService.getByLogin(login);
        if(userAccount == null) return null;

        Contacts contacts = new Contacts();
        contacts.setAddress(contactsDTO.getAddress());
        contacts.setCityAndRegion(contactsDTO.getCityAndRegion());
        contacts.setPhone(contactsDTO.getPhone());
        contacts.setUserAccount(userAccount);
        return contactsRepository.save(contacts);
    }

    @Override
    public Contacts update(String login, ContactsDTO contactsDTO) {
        Contacts contacts = getByUserLogin(login);
        contacts.setPhone(contactsDTO.getPhone());
        contacts.setAddress(contactsDTO.getAddress());
        contacts.setCityAndRegion(contactsDTO.getCityAndRegion());
        return contactsRepository.save(contacts);
    }

    @Override
    public Contacts deleteById(String login, Long id) {
        UserAccount userAccount = userAccountService.getByLogin(login);
        Contacts contacts = getById(id);
        if (!contacts.getUserAccount().equals(userAccount))
            return null;
        contactsRepository.deleteById(id);
        return contacts;
    }

    @Override
    public Contacts getById(Long id) {
        return contactsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contacts> getAll() {
        return contactsRepository.findAll();
    }

    @Override
    public Contacts getByUserLogin(String login) {
        UserAccount userAccount = userAccountService.getByLogin(login);
        if(userAccount == null) return null;

        return contactsRepository.findByUserAccount(userAccount);
    }
}
