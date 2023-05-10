package ua.nure.freedel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false, length = 45)
    private String price;

    @Column(name = "availability", nullable = false)
    private Byte availability;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "restorant_id", nullable = false)
    private Restorant restorant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_name_id", nullable = false)
    private ProductName productName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "additional_product_id", nullable = false)
    private Product additionalProduct;

    @OneToMany(mappedBy = "additionalProduct")
    private Set<Product> products = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<Basket> baskets = new LinkedHashSet<>();

}