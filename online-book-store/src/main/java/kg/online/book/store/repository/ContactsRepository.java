package kg.online.book.store.repository;

import kg.online.book.store.entity.Contacts;
import kg.online.book.store.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Long> {
    Contacts findByUserAccount(UserAccount userAccount);
}
