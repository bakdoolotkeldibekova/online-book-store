package kg.online.book.store.repository;

import kg.online.book.store.entity.Stars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarsRepository extends JpaRepository<Stars, Long> {
    List<Stars> findAllByProduct_Id(Long id);
}
