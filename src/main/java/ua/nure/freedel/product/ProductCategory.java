package ua.nure.freedel.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public ProductCategory(Long id, String name){
        ProductCategory category = new ProductCategory();
        category.id=id;
        category.name=name;
    }
}
