package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.AppointmentDto;
import com.genetech.genetech_backend.dto.MedicalInformationDto;
import com.genetech.genetech_backend.dto.PatientDto;
import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.MedicalInformation;
import com.genetech.genetech_backend.model.Patient;
import com.genetech.genetech_backend.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PatientController {
    private PatientService patientService;

    //HU05
    @PostMapping("/Register Patient")
    public ResponseEntity<Patient> Register(@RequestBody PatientDto pDto){
        return new ResponseEntity<>(patientService.Register(pDto), HttpStatus.CREATED);
    }
    //HU09
    @PutMapping("/patient/Modify Patient")
    public void modificar(@RequestBody PatientDto dto) {
        ModelMapper m = new ModelMapper();
        Patient patient = m.map(dto, Patient.class);
        patientService.insert(patient);
    }
    //HU18
    @GetMapping("/patient/List Appointment Patient")
    public List<AppointmentDto> listAppointment()  {
        List<Appointment> appointments = patientService.list();
        return appointments.stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, AppointmentDto.class);
        }).collect(Collectors.toList());
    }

}
