package kg.online.book.store.service;

import kg.online.book.store.dto.ContactsDTO;
import kg.online.book.store.entity.Contacts;
import kg.online.book.store.entity.UserAccount;
import kg.online.book.store.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public Contacts create(ContactsDTO contactsDTO) {
        UserAccount userAccount = userAccountService.getById(contactsDTO.getUserAccountId());
        if(userAccount == null) return null;

        Contacts contacts = new Contacts();
        contacts.setAddress(contactsDTO.getAddress());
        contacts.setCityAndRegion(contactsDTO.getCityAndRegion());
        contacts.setPhone(contactsDTO.getPhone());
        contacts.setUserAccount(userAccount);
        return contactsRepository.save(contacts);
    }

    @Override
    public Contacts deleteById(Long id) {
        Contacts contacts = getById(id);
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
}
