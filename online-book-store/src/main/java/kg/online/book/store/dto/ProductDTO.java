package kg.online.book.store.dto;

import kg.online.book.store.entity.Genre;
import kg.online.book.store.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    private String name;
    private Double price;
    private String description;
    private boolean available = true;
    private Genre genre;
    private Long authorId;
    private Integer discount=0;
    private Image image;
}
