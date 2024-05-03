package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.AppointmentDto;
import com.genetech.genetech_backend.dto.MedicalInformationDto;
import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.MedicalInformation;
import com.genetech.genetech_backend.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    //HU-01: Crear cita
    @PostMapping("/patient/Create Appointment")
    public ResponseEntity<Appointment> Create (@RequestBody AppointmentDto aDto){
        return new ResponseEntity<>(appointmentService.Create(aDto), HttpStatus.CREATED);
    }
    //HU-03
    @DeleteMapping("/patient/Delete Appointment/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        appointmentService.delete(id);
    }
    //HU-04
    @PutMapping("/patient/Modify Appointment")
    public void modificar(@RequestBody AppointmentDto dto) {
        ModelMapper m = new ModelMapper();
        Appointment ap = m.map(dto, Appointment.class);
        appointmentService.insert(ap);
    }
}
