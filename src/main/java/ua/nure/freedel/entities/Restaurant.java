//package ua.nure.freedel.entities;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "restaurant")
//public class Restaurant {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "restaurant_id", nullable = false)
//    private Integer id;
//
//    @Column(name = "name", nullable = false, length = 45)
//    private String name;
//
//    @Column(name = "avg_prep_time", nullable = false, length = 45)
//    private String avgPrepTime;
//
//    @Column(name = "delivery_comission", nullable = false, precision = 2, scale = 2)
//    private BigDecimal deliveryComission;
//
//    @Column(name = "rating", nullable = false, precision = 2, scale = 1)
//    private BigDecimal rating;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "address_id", nullable = false)
//    private Address address;
//
//    @Enumerated(EnumType.ORDINAL)
//    private WorkingStatus workingStatus;
//
//    @Enumerated(EnumType.ORDINAL)
//    private RestaurantCategory restaurantCategory;
//
//    @ManyToMany
//    @JoinTable(name = "restaurant_has_order",
//            joinColumns = @JoinColumn(name = "restaurant_id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id"))
//    private Set<Order> orders = new LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "restaurant")
//    private Set<Product> products = new LinkedHashSet<>();
//
//}