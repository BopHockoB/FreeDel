package ua.nure.freedel.courier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import ua.nure.freedel.order.Order;
import ua.nure.freedel.user.role.Role;

import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courier  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @NaturalId(mutable = true)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;
    private String phoneNumber;
    private boolean isBusy;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "courier_id")
    private List<Order> orders;
    @ManyToOne
    @JoinColumn(name = "transport_type_id")
    private TransportType transportType;

       public Courier(String firstName,
                   String lastName,
                   String email,
                   List<Role> roles,
                   String phoneNumber,
                   TransportType transportType) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.roles = roles;
       this.phoneNumber = phoneNumber;
       this.transportType = transportType;
    }
}
