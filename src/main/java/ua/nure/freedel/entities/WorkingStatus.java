package ua.nure.freedel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public enum WorkingStatus {
    OPEN,
    CLOSED,
    DELIVERY_ONLY,
    DINE_IN_ONLY,
    TEMPORARILY_CLOSED
}