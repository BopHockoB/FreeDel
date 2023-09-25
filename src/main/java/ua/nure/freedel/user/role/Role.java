package ua.nure.freedel.user.role;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.yaml.snakeyaml.events.Event;
import ua.nure.freedel.user.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NaturalId
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    public Role(String name) {
        this.name = name;
    }

    public SimpleGrantedAuthority getAuthority(){
        return new SimpleGrantedAuthority(getName());
    }

    public void removeUserFromRole(User user){
        user.getRoles().remove(this);
        this.getUsers().remove(user);
    }

    public void assignUserToRole(User user){
        user.getRoles().add(this);
        this.getUsers().add(user);
    }

    public void removeAllUsersFromRole(){
        if (this.getUsers() == null)
            return;
        List<User> usersWithRole = this.getUsers().stream().toList();
        usersWithRole.forEach(this::removeUserFromRole);
    }
}
