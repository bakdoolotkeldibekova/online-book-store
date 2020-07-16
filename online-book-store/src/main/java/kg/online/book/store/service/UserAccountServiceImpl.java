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
import java.util.Random;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    Random rand = new Random();
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CartService cartService;
    @Autowired
    private MailService mailService;

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
    public UserAccount isActive(String login, Boolean isActive) {
        UserAccount userAccount = getByLogin(login);
        userAccount.setActive(isActive);
        return userAccountRepository.save(userAccount);
    }

    @Override
    public String forgotMyPassword(String login) {
        UserAccount userAccount = getByLogin(login);
        if(userAccount == null) return "ne poluchilos'";

        final String TEXT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<4+rand.nextInt(6); i++){
            int character = (int)(Math.random()*TEXT.length());
            builder.append(TEXT.charAt(character));
        }
        String newPassword = builder.toString();

        userAccount.setPassword(encoder.encode(newPassword));
        userAccountRepository.save(userAccount);

        mailService.send(userAccount.getEmail(),
                "ONLINE BOOK STORE",
                "Dear " + userAccount.getName() + ", \nyour new password : "
                        + newPassword);
        return "success";
    }

}
