package com.genetech.genetech_backend.dto;

import com.genetech.genetech_backend.model.Doctor;
import com.genetech.genetech_backend.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private Long id;
    private Doctor doctor;
    private String reason;
    private LocalDate date;
    private LocalTime time;
    private Patient patient;
}
