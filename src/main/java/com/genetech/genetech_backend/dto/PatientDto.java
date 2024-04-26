package com.genetech.genetech_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private Long id;
    private String name;
    private String lastname;
    private LocalDate birth_date;
    private String number;
    private String address;
    private String city;
    private Boolean gender;
}
