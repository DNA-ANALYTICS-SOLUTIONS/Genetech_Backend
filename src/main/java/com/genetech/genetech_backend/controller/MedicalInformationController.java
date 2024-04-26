package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.AppointmentDto;
import com.genetech.genetech_backend.dto.MedicalInformationDto;
import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.MedicalInformation;
import com.genetech.genetech_backend.service.MedicalInformationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MedicalInformationController {
    @Autowired
    private MedicalInformationService medicalInformationService;

    //Registrar Info Medica (US-11)
    @PostMapping("/RegisterMedicalInformation")
    public ResponseEntity<MedicalInformation> Register (MedicalInformationDto miDto){
        return new ResponseEntity<>(medicalInformationService.Register(miDto), HttpStatus.CREATED);
    }
    @PutMapping("/MedicalInformation")
    public void modificar(@RequestBody MedicalInformationDto dto) {
        ModelMapper m = new ModelMapper();
        MedicalInformation mI = m.map(dto, MedicalInformation.class);
        medicalInformationService.insert(mI);
    }
    @GetMapping("/List/MedicalInformation")
    public List<MedicalInformationDto> listar() {
        List<MedicalInformation> medicalinformations = medicalInformationService.list();
        return medicalinformations.stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, MedicalInformationDto.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/MedicalInformation/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        medicalInformationService.delete(id);
    }
}
