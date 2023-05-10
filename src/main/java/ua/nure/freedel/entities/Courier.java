package ua.nure.freedel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "courier")
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courier_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Column(name = "courier_image", nullable = false)
    private String courierImage;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 13)
    private String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    private TransportType transportType;

    @OneToMany(mappedBy = "courier")
    private Set<Order> orders = new LinkedHashSet<>();

}