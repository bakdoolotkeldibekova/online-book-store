package kg.online.book.store.repository;

import kg.online.book.store.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByNameContainingIgnoringCase(String name);
    List<Author> findAllByBiographyContainingIgnoringCase(String biography);
}
