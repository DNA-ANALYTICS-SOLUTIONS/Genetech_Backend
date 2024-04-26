package com.genetech.genetech_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private LocalDate birth_date;
    private String number;
    private String address;
    private String city;
    private Boolean gender;

    public Patient(String name, String lastname, LocalDate birth_date, String number, String address, String city, Boolean gender) {
        this.name = name;
        this.lastname = lastname;
        this.birth_date = birth_date;
        this.number = number;
        this.address = address;
        this.city = city;
        this.gender = gender;
    }
}
