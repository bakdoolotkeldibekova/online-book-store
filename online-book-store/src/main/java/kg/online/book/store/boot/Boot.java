package kg.online.book.store.boot;

import kg.online.book.store.dto.ContactsDTO;
import kg.online.book.store.entity.*;
import kg.online.book.store.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Boot implements CommandLineRunner {
    @Autowired
    private UserAccountService userService;
    @Autowired
    private RoleService userRoleService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PaymentMethodService paymentMethodService;
    @Autowired
    private DeliveryMethodService deliveryMethodService;
    @Autowired
    private ContactsService contactsService;

    @Override
    public void run(String... args) throws Exception {
      //  //создание user_role
      //  userRoleService.create(Role.builder().roleName("ROLE_USER").build());
      //  userRoleService.create(Role.builder().roleName("ROLE_ADMIN").build());
      //  //создание user_account
      //  userService.create(new UserAccount("user", "bakdoolotkeldibekova@gmail.com", "user", "123", true, userRoleService.getById(1L)));
      //  userService.create(new UserAccount("admin", "dkeldibekova@gmail.com", "admin", "123", true, userRoleService.getById(2L)));
      //  // создание contacts
      //  contactsService.create("user", new ContactsDTO("+996101010", "Tynalieva 45A", "Bishkek Chui"));
      //  //создание genre
      //  genreService.create(new Genre("fantasy"));
      //  genreService.create(new Genre("historical"));
      //  genreService.create(new Genre("detective"));
      //  genreService.create(new Genre("romance"));
      //  genreService.create(new Genre("children's books"));
      //  genreService.create(new Genre("horrors"));
      //  //создание author
      //  authorService.create(new Author("Agatha Christie", "Dame Agatha Mary Clarissa Christie was an English writer known for her sixty-six detective novels and fourteen short story collections."));
      //  authorService.create(new Author("Ransom Riggs", "Ransom Riggs (born 1979) is an American writer and filmmaker best known for the book Miss Peregrine's Home for Peculiar Children."));
      //  authorService.create(new Author("Stephen King", "Stephen King, American novelist and short-story writer whose books were credited with reviving the genre of horror fiction in the late 20th century."));
      //  // создание payment_method
      //  paymentMethodService.create(new PaymentMethod("with card"));
      //  paymentMethodService.create(new PaymentMethod("in cash"));
      //  // создание delivery_method
      //  deliveryMethodService.create(new DeliveryMethod("Курьер по г. Бишкек (в течение дня)", 50));
      //  deliveryMethodService.create(new DeliveryMethod("Самовывоз", 0));
      //  deliveryMethodService.create(new DeliveryMethod("Курьерская служба по КР (2-15 дней)", 200));
      //  deliveryMethodService.create(new DeliveryMethod("Международная доставка (2-30 дней)", 500));

    }
}
