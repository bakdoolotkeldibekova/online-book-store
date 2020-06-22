package kg.online.book.store.service;

import kg.online.book.store.dto.UserAccountDTO;
import kg.online.book.store.entity.UserAccount;

import java.util.List;

public interface UserAccountService {
    UserAccount create(UserAccountDTO userAccountDTO);
    UserAccount create(UserAccount userAccount);
    UserAccount deleteById(Long id);
    List<UserAccount> getAll();
    UserAccount getById(Long id);

    UserAccount getByLogin(String login);
}
