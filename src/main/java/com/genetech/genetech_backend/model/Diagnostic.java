package com.genetech.genetech_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Diagnostic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    public Diagnostic(String description, Appointment appointment) {
        this.description = description;
        this.appointment = appointment;
    }
}
