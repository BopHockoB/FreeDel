//package ua.nure.freedel.entities;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.Hibernate;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//@Getter
//@Setter
//@Embeddable
//public class BasketId implements Serializable {
//    private static final long serialVersionUID = 3200336740992710134L;
//    @Column(name = "product_id", nullable = false)
//    private Integer productId;
//
//    @Column(name = "order_id", nullable = false)
//    private Integer orderId;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        BasketId entity = (BasketId) o;
//        return Objects.equals(this.productId, entity.productId) &&
//                Objects.equals(this.orderId, entity.orderId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(productId, orderId);
//    }
//
//}