package kg.online.book.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
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


//    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinTable(name = "product_genre",
//            joinColumns = {
//            @JoinColumn(name = "product_id")
//    },
//    inverseJoinColumns = {
//            @JoinColumn(name = "genre_id")
//    })
//    private List<Genre> genreList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "product_genre", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genreSet;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Min(0)
    @Max(100)
    @Column(name = "discount")
    private Integer discount=0;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

}