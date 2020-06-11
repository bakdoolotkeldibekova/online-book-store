package kg.online.book.store.dto;

import kg.online.book.store.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    private String name;
    private Double price;
    private String description;
    private boolean available = true;
    private Set<Genre> genreSet = new HashSet<>();
    private Long authorId;
}
