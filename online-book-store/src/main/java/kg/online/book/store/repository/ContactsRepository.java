package kg.online.book.store.repository;

import kg.online.book.store.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Long> {
}
