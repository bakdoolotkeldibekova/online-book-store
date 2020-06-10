package kg.online.book.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @ManyToMany
    @JoinColumn(name = "user_account_id", nullable = false)
    private Set<UserAccount> userAccounts = new HashSet<>();

}
