package kg.online.book.store.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Entity
@Table(name = "role")
public class Role extends BaseEntity implements GrantedAuthority {

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

    @Override
    public String getAuthority() {
        return getRoleName();
    }

    //role_id=>1 - USER
    //role_id=>2 - ADMIN

}
