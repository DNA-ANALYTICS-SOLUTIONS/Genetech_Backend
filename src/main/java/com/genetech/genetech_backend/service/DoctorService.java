package com.genetech.genetech_backend.service;

import com.genetech.genetech_backend.dto.DoctorDto;
import com.genetech.genetech_backend.model.Doctor;
import com.genetech.genetech_backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
