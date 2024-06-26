package com.genetech.genetech_backend.dto;

import com.genetech.genetech_backend.model.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticDto {
    private Long id;
    private String description;
    private String appointment;

}
