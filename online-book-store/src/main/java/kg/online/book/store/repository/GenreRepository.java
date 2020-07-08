package kg.online.book.store.repository;

import kg.online.book.store.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByNameContainingIgnoringCase(String name);
}
