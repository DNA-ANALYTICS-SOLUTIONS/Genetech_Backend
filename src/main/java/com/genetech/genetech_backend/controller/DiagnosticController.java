package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.AppointmentDto;
import com.genetech.genetech_backend.dto.DiagnosticDto;
import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.Diagnostic;
import com.genetech.genetech_backend.model.User;
import com.genetech.genetech_backend.repository.AppointmentRepository;
import com.genetech.genetech_backend.repository.IUserRepository;
import com.genetech.genetech_backend.service.DiagnosticService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
public class DiagnosticController {
    @Autowired
    private DiagnosticService diagnosticService;
    @Autowired
    private AppointmentRepository appoinmtments;
/*
    //Regitrar Diagnóstico (HU14)
    @PostMapping("/doctor/Register Diagnostic")
    public ResponseEntity<Diagnostic> Register(@RequestBody DiagnosticDto diDto){
        return new ResponseEntity<>(diagnosticService.Register(diDto), HttpStatus.CREATED);
    }
    */  @PostMapping("/creatediagnostic")
public void registrar(@RequestBody DiagnosticDto dto) {
    LocalDate date = LocalDate.parse(dto.getAppointment());
    Appointment doctor = appoinmtments.findByDate(date);
    Diagnostic nuevo=new Diagnostic();
    nuevo.setAppointment(doctor);
    nuevo.setDescription(dto.getDescription());
    diagnosticService.Create2(nuevo);
}


    //HU06 $$$$$$$ (agregar por id)
    @GetMapping("/patient/List Diagnostic")
    public List<DiagnosticDto> listar() {
        List<Diagnostic> diagnostic = diagnosticService.list();
        return diagnostic.stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, DiagnosticDto.class);
        }).collect(Collectors.toList());
    }
}
