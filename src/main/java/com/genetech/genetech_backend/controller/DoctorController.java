package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.AppointmentDto;
import com.genetech.genetech_backend.dto.DoctorDto;
import com.genetech.genetech_backend.dto.MedicalInformationDto;
import com.genetech.genetech_backend.dto.PatientDto;
import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.Doctor;
import com.genetech.genetech_backend.model.MedicalInformation;
import com.genetech.genetech_backend.model.Patient;
import com.genetech.genetech_backend.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    //Registrar doctor
    @PostMapping("/Doctor Registration")
    public ResponseEntity<Doctor> Register(@RequestBody DoctorDto dDto){
        return new ResponseEntity<>(doctorService.Register(dDto), HttpStatus.CREATED);
    }

    @GetMapping("/List Doctor")
    public List<DoctorDto> listar() {
        List<Doctor> doctor = doctorService.list();
        return doctor.stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, DoctorDto.class);
        }).collect(Collectors.toList());
    }


    @PutMapping("/Modify Doctor")
    public void modificar(@RequestBody DoctorDto dto) {
        ModelMapper m = new ModelMapper();
        Doctor doctor = m.map(dto, Doctor.class);
        doctorService.insert(doctor);
    }

    @GetMapping("/List Appointment Doctor")
    public List<AppointmentDto> listAppointment()  {
        List<Appointment> appointments = doctorService.listAppointment();
        return appointments.stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, AppointmentDto.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/Search Doctor by Speciality")
    public List<DoctorDto> buscar(@RequestBody String especialidad) {
        return doctorService.BuscarDoctoresporEspecialidad(especialidad).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DoctorDto.class);
        }).collect(Collectors.toList());
    }

}
