package ua.nure.freedel.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "working_status")
public class WorkingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "working_status_id", nullable = false)
    private Integer id;

    @Column(name = "status_name", nullable = false, length = 45)
    private String statusName;

}