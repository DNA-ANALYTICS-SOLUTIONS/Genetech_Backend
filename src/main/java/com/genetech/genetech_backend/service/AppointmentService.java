package com.genetech.genetech_backend.service;


import com.genetech.genetech_backend.dto.AppointmentDto;
import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    //US-01: Crear cita
    public Appointment Create (AppointmentDto apDto){
        Appointment appointment = new Appointment(apDto.getDoctor(), apDto.getReason(), apDto.getDate(), apDto.getTime(),
                apDto.getPatient());
        return appointmentRepository.save(appointment);
    }
}
