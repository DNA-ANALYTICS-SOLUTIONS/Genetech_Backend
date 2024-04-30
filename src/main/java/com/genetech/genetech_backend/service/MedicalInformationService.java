package com.genetech.genetech_backend.service;

import com.genetech.genetech_backend.Interfaces.MedicalInformationInterface;
import com.genetech.genetech_backend.dto.MedicalInformationDto;
import com.genetech.genetech_backend.model.MedicalInformation;
import com.genetech.genetech_backend.repository.MedicalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalInformationService implements MedicalInformationInterface {
    @Autowired
    private MedicalInformationRepository medicalInformationRepository;

    //Regitrar Información médica (US-11)
    public MedicalInformation Register (MedicalInformationDto miDto) {
        MedicalInformation medicalInformation = new MedicalInformation(miDto.getRegistration_date(), miDto.getDescription(),
                miDto.getAllergies(), miDto.getPrevious_surgeries(), miDto.getVaccinations(), miDto.getBlood_type(),
                miDto.getPatient()); //Ver si se puede cambiar a que solo reciba el ID
        return medicalInformationRepository.save(medicalInformation);
    }

    @Override
    public List<MedicalInformation> list(){ return medicalInformationRepository.findAll();
    }

    @Override
    public void delete(Long id) {medicalInformationRepository.deleteById(id); }

    @Override
    public void insert(MedicalInformation mI) {
        medicalInformationRepository.save(mI);
    }



}
