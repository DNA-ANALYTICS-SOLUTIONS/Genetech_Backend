package com.genetech.genetech_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private String reason;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Appointment(Doctor doctor, String reason, LocalDate date, LocalTime time, Patient patient) {
        this.doctor = doctor;
        this.reason = reason;
        this.date = date;
        this.time = time;
        this.patient = patient;
    }
}
