package com.genetech.genetech_backend.service;

import com.genetech.genetech_backend.dto.MedicalInformationDto;
import com.genetech.genetech_backend.model.MedicalInformation;
import com.genetech.genetech_backend.repository.MedicalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalInformationService {
    @Autowired
    private MedicalInformationRepository medicalInformationRepository;

    //Regitrar Información médica (US-11)
    public MedicalInformation Register (MedicalInformationDto miDto) {
        MedicalInformation medicalInformation = new MedicalInformation(miDto.getRegistration_date(), miDto.getDescription(),
                miDto.getAllergies(), miDto.getPrevious_surgeries(), miDto.getVaccinations(), miDto.getBlood_type(),
                miDto.getPatient()); //Ver si se puede cambiar a que solo reciba el ID
        return medicalInformationRepository.save(medicalInformation);
    }
}
