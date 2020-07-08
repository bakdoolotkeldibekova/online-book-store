package kg.online.book.store.repository;

import kg.online.book.store.entity.Genre;
import kg.online.book.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByNameContainingIgnoringCase(String name);
    List<Product> findAllByAuthorNameContainingIgnoringCase(String authorName);
    List<Product> findAllByGenreListIgnoringCase(List<Genre> genreList);

}
