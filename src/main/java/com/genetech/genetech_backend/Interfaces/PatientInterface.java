package com.genetech.genetech_backend.Interfaces;

import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.MedicalInformation;
import com.genetech.genetech_backend.model.Patient;

import java.util.List;

public interface PatientInterface {
    void insert(Patient patient);
    List<Appointment>list();
}
