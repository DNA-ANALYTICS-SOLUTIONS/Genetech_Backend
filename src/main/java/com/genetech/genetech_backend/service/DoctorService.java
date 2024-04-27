package com.genetech.genetech_backend.service;

import com.genetech.genetech_backend.dto.DoctorDto;
import com.genetech.genetech_backend.model.Doctor;
import com.genetech.genetech_backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    //Registrar doctor
    public Doctor Register(DoctorDto dDto){
        Doctor doctor = new Doctor(dDto.getName(), dDto.getLastname(), dDto.getSpeciality(),
                dDto.getBirth_date(), dDto.getNumber(), dDto.getAddress(), dDto.getCity(), dDto.getGender());
        return doctorRepository.save(doctor);
    }
    //HU-13 Buscar medicos por especialidad
    public List<Doctor> listDoctorsBySpeciality(String speciality) {
        return doctorRepository.findBySpeciality(speciality);
    }
    //HU16: Modificar perfil del médico
    public Doctor updateDoctor(DoctorDto doctorDto) {
        Doctor existingDoctor = doctorRepository.findById(doctorDto.getId()).orElseThrow();

        existingDoctor.setName(doctorDto.getName());
        existingDoctor.setLastname(doctorDto.getLastname());
        existingDoctor.setSpeciality(doctorDto.getSpeciality());
        existingDoctor.setBirth_date(doctorDto.getBirth_date());
        existingDoctor.setNumber(doctorDto.getNumber());
        existingDoctor.setAddress(doctorDto.getAddress());
        existingDoctor.setCity(doctorDto.getCity());
        existingDoctor.setGender(doctorDto.getGender());

        return doctorRepository.save(existingDoctor);
    }
}
