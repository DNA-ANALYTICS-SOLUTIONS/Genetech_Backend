package com.genetech.genetech_backend.repository;

import com.genetech.genetech_backend.model.Appointment;
import com.genetech.genetech_backend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    //Buscar doctores por especialidad
    @Query("SELECT d FROM Doctor d WHERE d.speciality = :especialidad")
    List<Doctor> findBySpeciality(@Param("especialidad") String especialidad);
}

