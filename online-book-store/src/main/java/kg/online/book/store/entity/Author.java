package kg.online.book.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "author")
public class Author extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "biography")
    private String biography;

}
