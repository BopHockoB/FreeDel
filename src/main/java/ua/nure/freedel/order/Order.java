package ua.nure.freedel.order;

import jakarta.persistence.*;
import lombok.*;
import ua.nure.freedel.courier.Courier;
import ua.nure.freedel.order.orderItem.OrderItem;
import ua.nure.freedel.user.User;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "_order")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String address;
    private double total;
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    {
        this.status = OrderStatus.CREATED;
    }




}
