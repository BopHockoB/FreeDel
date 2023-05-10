package ua.nure.freedel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restorant_category")
public class RestorantCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restorant_category_id", nullable = false)
    private Integer id;

    @Column(name = "category_name", nullable = false, length = 45)
    private String categoryName;

}