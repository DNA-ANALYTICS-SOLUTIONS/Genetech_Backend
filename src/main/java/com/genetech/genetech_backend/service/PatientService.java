package com.genetech.genetech_backend.service;

import com.genetech.genetech_backend.dto.PatientDto;
import com.genetech.genetech_backend.model.Patient;
import com.genetech.genetech_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    
    //Registrar paciente
    public Patient Register(PatientDto pDto){
        Patient patient = new Patient(pDto.getName(), pDto.getLastname(),
                pDto.getBirth_date(), pDto.getNumber(), pDto.getAddress(), pDto.getCity(), pDto.getGender());
        return patientRepository.save(patient);
    }
}
