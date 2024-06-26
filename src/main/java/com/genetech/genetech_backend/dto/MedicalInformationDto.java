package com.genetech.genetech_backend.dto;
import com.genetech.genetech_backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalInformationDto {
    private Long id;
    private LocalDate registration_date;
    private String description;
    private String allergies;
    private String previous_surgeries;
    private String vaccinations;
    private String blood_type;
    private String patient;

}
