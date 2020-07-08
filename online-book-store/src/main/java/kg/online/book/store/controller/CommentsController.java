package kg.online.book.store.controller;

import kg.online.book.store.dto.CommentsDTO;
import kg.online.book.store.entity.Comments;
import kg.online.book.store.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @PostMapping
    public Comments create(Principal principal, @RequestBody CommentsDTO commentsDTO){
        return commentsService.create(principal.getName(), commentsDTO);
    }

    @GetMapping
    public List<Comments> getAll(){
        return commentsService.getAll();
    }

    @GetMapping("/{productId}")
    public List<Comments> getAllByProductId(@PathVariable Long productId){
        return commentsService.getAllByProductId(productId);
    }

    @DeleteMapping("/{id}")
    public Comments deleteById(@PathVariable Long id){
        return commentsService.deleteById(id);
    }
}
