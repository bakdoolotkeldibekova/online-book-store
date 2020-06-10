package kg.online.book.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "available", nullable = false)
    private boolean available = true;

    @ManyToMany
    @JoinColumn(name = "genre_id", nullable = false)
    private Set<Genre> genreSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

}