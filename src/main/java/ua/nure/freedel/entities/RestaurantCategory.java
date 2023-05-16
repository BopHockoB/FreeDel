package ua.nure.freedel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public enum RestaurantCategory {
    ITALIAN,
    FRENCH,
    AMERICAN,
    CHINESE,
    MEXICAN,
    THAI,
    INDIAN,
    JAPANESE,
    STEAKHOUSE,
    SEAFOOD
}