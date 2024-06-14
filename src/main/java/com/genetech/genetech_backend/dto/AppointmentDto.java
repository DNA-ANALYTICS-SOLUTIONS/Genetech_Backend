package com.genetech.genetech_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.genetech.genetech_backend.model.User;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private Long id;
    private User doctor;
    private String reason;
    private LocalDate date;
    private LocalTime time;
    private User patient;
}
