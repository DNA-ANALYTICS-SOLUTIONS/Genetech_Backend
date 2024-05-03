package com.genetech.genetech_backend.service;

import com.genetech.genetech_backend.Interfaces.DoctorInterface;
import com.genetech.genetech_backend.dto.DoctorDto;
import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.Doctor;
import com.genetech.genetech_backend.model.Patient;
import com.genetech.genetech_backend.repository.AppointmentRepository;
import com.genetech.genetech_backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DoctorService implements DoctorInterface {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    //Registrar doctor
    public Doctor Register(DoctorDto dDto){
        Doctor doctor = new Doctor(dDto.getName(), dDto.getLastname(), dDto.getSpeciality(),
                dDto.getBirth_date(), dDto.getNumber(), dDto.getAddress(), dDto.getCity(), dDto.getGender());
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> list(){ return doctorRepository.findAll();
    }

    @Override
    public List<Appointment> listAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public void insert(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> BuscarDoctoresporEspecialidad(String especialidad) {
        return doctorRepository.findBySpeciality(especialidad);
    }



}
