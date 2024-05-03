package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.DiagnosticDto;
import com.genetech.genetech_backend.dto.DoctorDto;
import com.genetech.genetech_backend.model.Diagnostic;
import com.genetech.genetech_backend.model.Doctor;
import com.genetech.genetech_backend.service.DiagnosticService;
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
public class DiagnosticController {
    @Autowired
    private DiagnosticService diagnosticService;

    //Regitrar Diagnóstico (HU14)
    @PostMapping("/doctor/Register Diagnostic")
    public ResponseEntity<Diagnostic> Register(@RequestBody DiagnosticDto diDto){
        return new ResponseEntity<>(diagnosticService.Register(diDto), HttpStatus.CREATED);
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
