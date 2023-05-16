//package ua.nure.freedel.entities;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "basket")
//public class Basket {
//    @EmbeddedId
//    private BasketId id;
//
//    @MapsId("productId")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "product_id", nullable = false)
//    private Product product;
//
//    @MapsId("orderId")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "order_id", nullable = false)
//    private Order order;
//
//    @Column(name = "amount", nullable = false)
//    private Integer amount;
//
//}