package ua.nure.freedel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public enum ProductCategory {
    PIZZA,
    SUSHI,
    BURGERS,
    PASTA,
    CHINESE,
    THAI,
    MEXICAN,
    INDIAN,
    FAST_FOOD,
    STEAKS
}