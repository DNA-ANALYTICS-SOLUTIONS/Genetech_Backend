package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.DoctorDto;
import com.genetech.genetech_backend.model.Doctor;
import com.genetech.genetech_backend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    //Registrar doctor
    @PostMapping("/DoctorRegistration")
    public ResponseEntity<Doctor> Register(@RequestBody DoctorDto dDto){
        return new ResponseEntity<>(doctorService.Register(dDto), HttpStatus.CREATED);
    }
}
