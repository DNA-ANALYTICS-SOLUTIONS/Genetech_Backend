package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.AppointmentDto;
import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    //US-01: Crear cita
    @PostMapping("/CreateAppointment")
    public ResponseEntity<Appointment> Create (@RequestBody AppointmentDto aDto){
        return new ResponseEntity<>(appointmentService.Create(aDto), HttpStatus.CREATED);
    }

    @GetMapping("/List/Appointment")
    public List<AppointmentDto> listar() {
        List<Appointment> appointments = appointmentService.list();
        return appointments.stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, AppointmentDto.class);
        }).collect(Collectors.toList());
    }

}
