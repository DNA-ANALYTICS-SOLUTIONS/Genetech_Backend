package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.AppointmentDto;
import com.genetech.genetech_backend.dto.MedicalInformationDto;
import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.MedicalInformation;
import com.genetech.genetech_backend.model.User;
import com.genetech.genetech_backend.repository.IUserRepository;
import com.genetech.genetech_backend.service.MedicalInformationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
@RequestMapping("/medical")
public class MedicalInformationController {
    @Autowired
    private MedicalInformationService medicalInformationService;

    @Autowired
    private IUserRepository userRepository;

    //HU11
    @PostMapping("/registra")
    public void Register (@RequestBody MedicalInformationDto miDto) {
        User user = userRepository.findByUsername(miDto.getPatient());

            //Ver si se puede cambiar a que solo reciba el ID
            MedicalInformation medicalInformation = new MedicalInformation();
            medicalInformation.setRegistration_date(miDto.getRegistration_date());
            medicalInformation.setDescription(miDto.getDescription());
            medicalInformation.setAllergies(miDto.getAllergies());
            medicalInformation.setPrevious_surgeries(miDto.getPrevious_surgeries());
            medicalInformation.setVaccinations(miDto.getVaccinations());
            medicalInformation.setBlood_type(miDto.getBlood_type());
            medicalInformation.setPatient(user);
            medicalInformationService.Register(medicalInformation);


    }
    /*
        @PostMapping("/registera")
    public void registrar(@RequestBody RoleDTO dto) {
        User user = userRepository.findByUsername(dto.getUsername());
        if(user != null){
            Role r = new Role();
            r.setRol(dto.getRol());
            r.setUser(user);
            rS.insert(r);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }
    */

    //HU17
    @PutMapping("/patient/Modify Medical Information")
    public void modificar(@RequestBody MedicalInformationDto dto) {
        ModelMapper m = new ModelMapper();
        MedicalInformation mI = m.map(dto, MedicalInformation.class);
        medicalInformationService.insert(mI);
    }
    //HU10 $$$$$$$$ (pacientes por atender)  PENDIENTE MOVER
    @GetMapping("/doctor/List Medical Information")
    public List<MedicalInformationDto> listar() {
        List<MedicalInformation> medicalinformations = medicalInformationService.list();
        return medicalinformations.stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, MedicalInformationDto.class);
        }).collect(Collectors.toList());
    }
    //HU12
    @DeleteMapping("/patient/Delete Medical Information/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        medicalInformationService.delete(id);
    }
}
