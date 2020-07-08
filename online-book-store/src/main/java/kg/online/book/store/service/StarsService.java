package kg.online.book.store.service;

import kg.online.book.store.dto.StarsDTO;
import kg.online.book.store.entity.Stars;

import java.util.List;

public interface StarsService {
    Stars create(String login, StarsDTO starsDTO);
    Stars deleteById(Long id);

    List<Stars> getAllByProductId(Long id);
    Integer getAverage(Long productId);
}
