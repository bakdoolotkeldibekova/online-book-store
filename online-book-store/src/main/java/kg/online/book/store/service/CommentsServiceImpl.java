package kg.online.book.store.service;

import kg.online.book.store.dto.CommentsDTO;
import kg.online.book.store.entity.Comments;
import kg.online.book.store.entity.Product;
import kg.online.book.store.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserAccountService userAccountService;

    @Override
    public Comments create(String login, CommentsDTO commentsDTO) {
        Comments comments = new Comments();
        comments.setComment(commentsDTO.getComment());

        Product product = productService.getById(commentsDTO.getProductId());
        if(product == null) return null;

        comments.setProduct(product);
        comments.setUserAccount(userAccountService.getByLogin(login));
        return commentsRepository.save(comments);
    }

    @Override
    public List<Comments> getAll() {
        return commentsRepository.findAll();
    }

    @Override
    public Comments deleteById(Long id) {
        Comments comments = commentsRepository.findById(id).orElse(null);
        commentsRepository.deleteById(id);
        return comments;
    }

    @Override
    public List<Comments> getAllByProductId(Long id) {
        return commentsRepository.findAllByProduct_id(id);
    }
}
