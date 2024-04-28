package com.genetech.genetech_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MedicalInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate registration_date;
    private String description;
    private String allergies;
    private String previous_surgeries;
    private String vaccinations;
    private String blood_type;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    //segundo commit para Brenda
    public MedicalInformation(LocalDate registration_date, String description, String allergies, String previous_surgeries, String vaccinations, String blood_type, Patient patient) {
        this.registration_date = registration_date;
        this.description = description;
        this.allergies = allergies;
        this.previous_surgeries = previous_surgeries;
        this.vaccinations = vaccinations;
        this.blood_type = blood_type;
        this.patient = patient;
    }
}
