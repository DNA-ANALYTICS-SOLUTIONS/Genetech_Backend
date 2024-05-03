package com.genetech.genetech_backend.Interfaces;

import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.MedicalInformation;

import java.util.List;

public interface AppointmentInterface {
   void delete(Long id);
   void insert(Appointment appointment);
}
