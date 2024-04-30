package com.genetech.genetech_backend.Interfaces;

import com.genetech.genetech_backend.model.MedicalInformation;

import java.util.List;

public interface MedicalInformationInterface {
List<MedicalInformation>list();

    void delete(Long id);

    void insert(MedicalInformation mi);
}
