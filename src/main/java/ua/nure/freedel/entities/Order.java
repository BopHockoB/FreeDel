//package ua.nure.freedel.entities;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "order")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "order_id", nullable = false)
//    private Integer id;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "address_id", nullable = false)
//    private Address address;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "courier_id", nullable = false)
//    private Courier courier;
//
//    @ManyToMany
//    @JoinTable(name = "restaurant_has_order",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "restaurant_id"))
//    private Set<Restaurant> restaurants = new LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "order")
//    private Set<Basket> baskets = new LinkedHashSet<>();
//
//    @Enumerated(EnumType.ORDINAL)
//    private OrderStatus orderStatus;
//}