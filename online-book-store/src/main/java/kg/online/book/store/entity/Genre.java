package kg.online.book.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "genre")
public class Genre extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

//    @ManyToMany(mappedBy = "genres", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
//    private List<Product> productList = new ArrayList<>();

    @ManyToMany(mappedBy = "genres")
    Set<Product> productSet;
//    public Genre(String name){
//        this.name = name;
//    }
}
