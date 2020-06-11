package kg.online.book.store.service;

import kg.online.book.store.entity.UserAccount;
import kg.online.book.store.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccount create(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount deleteById(Long id) {
        UserAccount userAccount = getById(id);
        userAccountRepository.deleteById(id);
        return userAccount;
    }

    @Override
    public List<UserAccount> getAll() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount getById(Long id) {
        return userAccountRepository.findById(id).orElse(null);
    }
}
