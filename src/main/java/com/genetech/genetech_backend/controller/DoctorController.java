package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.DoctorDto;
import com.genetech.genetech_backend.model.Doctor;
import com.genetech.genetech_backend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    //Registrar doctor
    @PostMapping("/DoctorRegistration")
    public ResponseEntity<Doctor> Register(@RequestBody DoctorDto dDto){
        return new ResponseEntity<>(doctorService.Register(dDto), HttpStatus.CREATED);
    }
    //HU-13 Buscar medicos por especialidad
    @GetMapping("/doctors/speciality/{speciality}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpeciality(@PathVariable String speciality) {
        List<Doctor> doctors = doctorService.listDoctorsBySpeciality(speciality);
        return ResponseEntity.ok(doctors);
    }
//HU16: Modificar perfil del médico
    @PutMapping("/doctors/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable Long id, @RequestBody DoctorDto doctorDto) {
        Doctor updatedDoctor = doctorService.updateDoctor(doctorDto);
        DoctorDto updatedDoctorDto = new DoctorDto(updatedDoctor.getId(), updatedDoctor.getName(), updatedDoctor.getLastname(),
                updatedDoctor.getSpeciality(), updatedDoctor.getBirth_date(), updatedDoctor.getNumber(), updatedDoctor.getAddress(),
                updatedDoctor.getCity(), updatedDoctor.getGender());
        return new ResponseEntity<>(updatedDoctorDto, HttpStatus.OK);
    }
}
