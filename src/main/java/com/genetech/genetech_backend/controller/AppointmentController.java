package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.AppointmentDto;
import com.genetech.genetech_backend.dto.MedicalInformationDto;
import com.genetech.genetech_backend.dto.UserDTO;
import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.MedicalInformation;
import com.genetech.genetech_backend.model.User;
import com.genetech.genetech_backend.repository.IUserRepository;
import com.genetech.genetech_backend.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private IUserRepository userRepository;

    //HU-01: Crear cita
    /*
    @PostMapping("/patient/Create Appointment")
    public ResponseEntity<Appointment> Create (@RequestBody AppointmentDto aDto){
        return new ResponseEntity<>(appointmentService.Create(aDto), HttpStatus.CREATED);
    }
    */

    //HU-03
    @PostMapping("/createappointment")
    public void registrar(@RequestBody AppointmentDto dto) {
        User doctor = userRepository.findByUsername(dto.getDoctor());
        User patient = userRepository.findByUsername(dto.getPatient());

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setReason(dto.getReason());
        appointment.setDate(dto.getDate());
        appointment.setTime(dto.getTime());
        appointment.setPatient(patient);

        appointmentService.Create(appointment);
    }

    @GetMapping("/listarappointment")
    public List<AppointmentDto> listar() {
        List<Appointment> medicalinformations =  appointmentService.list();
        return medicalinformations.stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, AppointmentDto.class);
        }).collect(Collectors.toList());
    }
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
