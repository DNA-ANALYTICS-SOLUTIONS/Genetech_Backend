package com.genetech.genetech_backend.service;

import com.genetech.genetech_backend.Interfaces.PatientInterface;
import com.genetech.genetech_backend.dto.PatientDto;
import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.Patient;
import com.genetech.genetech_backend.repository.AppointmentRepository;
import com.genetech.genetech_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements PatientInterface {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;
    
    //Registrar paciente
    public Patient Register(PatientDto pDto){
        Patient patient = new Patient(pDto.getName(), pDto.getLastname(),
                pDto.getBirth_date(), pDto.getNumber(), pDto.getAddress(), pDto.getCity(), pDto.getGender());
        return patientRepository.save(patient);
    }


    @Override
    public void insert(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public List<Appointment> list() {
        return appointmentRepository.findAll();
    }
}
