package kg.online.book.store.service;

import kg.online.book.store.dto.UserAccountDTO;
import kg.online.book.store.entity.Cart;
import kg.online.book.store.entity.Role;
import kg.online.book.store.entity.UserAccount;
import kg.online.book.store.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CartService cartService;

    @Override
    public UserAccount create(UserAccountDTO userAccountDTO) {
        UserAccount userAccount = new UserAccount();
        userAccount.setName(userAccountDTO.getName());
        userAccount.setEmail(userAccountDTO.getEmail());
        userAccount.setPassword(encoder.encode(userAccountDTO.getPassword()));
        userAccount.setLogin(userAccountDTO.getLogin());
        userAccount.setActive(true);
        Role role = roleService.getById(1L);
        userAccount.setRole(role);

        userAccountRepository.save(userAccount);

        Cart cart = new Cart();
        cart.setUserAccount(userAccount);
        cartService.create(cart);

        return userAccount;
    }

    @Override
    public UserAccount create(UserAccount userAccount) {
        userAccount.setPassword(encoder.encode(userAccount.getPassword()));
        userAccountRepository.save(userAccount);

        Cart cart = new Cart();
        cart.setUserAccount(userAccount);
        cartService.create(cart);

        return userAccount;
    }

    @Override
    public UserAccount deleteById(Long id) {
        UserAccount userAccount = getById(id);
        if(userAccount != null){
            Cart cart = cartService.getByUserAccount(userAccount);
            cartService.deleteById(cart.getId());
        }
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

    @Override
    public UserAccount getByLogin(String login) {
        return userAccountRepository.findByLogin(login);
    }

    @Override
    public UserAccount doAnActive(String login) {
        UserAccount userAccount = getByLogin(login);
        userAccount.setActive(false);
        return userAccountRepository.save(userAccount);
    }

}
