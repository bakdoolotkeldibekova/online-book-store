package kg.online.book.store.service;

import kg.online.book.store.dto.CommentsDTO;
import kg.online.book.store.entity.Comments;

import java.util.List;

public interface CommentsService {
    Comments create(String login, CommentsDTO commentsDTO);
    List<Comments> getAll();
    Comments deleteById(Long id);

    List<Comments> getAllByProductId(Long id);
}
