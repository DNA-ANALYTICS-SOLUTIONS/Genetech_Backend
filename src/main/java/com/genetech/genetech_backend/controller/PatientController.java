package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.PatientDto;
import com.genetech.genetech_backend.model.Patient;
import com.genetech.genetech_backend.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    private PatientService patientService;

    //Registrar paciente
    @PostMapping("/RegisterPatient")
    public ResponseEntity<Patient> Register(@RequestBody PatientDto pDto){
        return new ResponseEntity<>(patientService.Register(pDto), HttpStatus.CREATED);
    }
}
