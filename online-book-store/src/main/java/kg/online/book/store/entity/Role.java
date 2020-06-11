package kg.online.book.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount userAccount;

}
