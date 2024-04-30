package com.genetech.genetech_backend.Interfaces;

import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.Doctor;
import com.genetech.genetech_backend.model.MedicalInformation;

import java.time.LocalDate;
import java.util.List;

public interface DoctorInterface {
    List<Doctor> list();
    List<Appointment> listAppointment();

    void insert (Doctor doctor);
    List<Doctor> BuscarDoctoresporEspecialidad(String especialidad);
}
