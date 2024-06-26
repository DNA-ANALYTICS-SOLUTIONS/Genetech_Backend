package com.genetech.genetech_backend.repository;

import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    public Appointment findByDate(LocalDate fecha);

}
