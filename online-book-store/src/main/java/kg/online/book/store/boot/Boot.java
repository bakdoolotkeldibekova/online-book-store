package kg.online.book.store.boot;

import kg.online.book.store.entity.Role;
import kg.online.book.store.entity.UserAccount;
import kg.online.book.store.service.RoleService;
import kg.online.book.store.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Boot implements CommandLineRunner {
    @Autowired
    private UserAccountService userService;
    @Autowired
    private RoleService userRoleService;

    @Override
    public void run(String... args) throws Exception {
//        userRoleService.create(Role.builder().roleName("ROLE_USER").build());
//        userRoleService.create(Role.builder().roleName("ROLE_ADMIN").build());
//        userService.create(new UserAccount("user", "bakdoolotkeldibekova@gmail.com", "user", "123", true, userRoleService.getById(1L)));
//        userService.create(new UserAccount("admin", "dkeldibekova@gmail.com", "admin", "123", true, userRoleService.getById(2L)));

    }
}
