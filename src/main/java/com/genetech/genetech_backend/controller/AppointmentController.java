package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.AppointmentDto;
import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    //US-01: Crear cita
    @PostMapping("/CreateAppointment")
    public ResponseEntity<Appointment> Create (@RequestBody AppointmentDto aDto){
        return new ResponseEntity<>(appointmentService.Create(aDto), HttpStatus.CREATED);
    }
}
