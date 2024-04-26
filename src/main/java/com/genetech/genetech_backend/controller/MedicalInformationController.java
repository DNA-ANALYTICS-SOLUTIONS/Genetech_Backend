package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.MedicalInformationDto;
import com.genetech.genetech_backend.model.MedicalInformation;
import com.genetech.genetech_backend.service.MedicalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalInformationController {
    @Autowired
    private MedicalInformationService medicalInformationService;

    //Registrar Info Medica (US-11)
    @PostMapping("/RegisterMedicalInformation")
    public ResponseEntity<MedicalInformation> Register (MedicalInformationDto miDto){
        return new ResponseEntity<>(medicalInformationService.Register(miDto), HttpStatus.CREATED);
    }
}
