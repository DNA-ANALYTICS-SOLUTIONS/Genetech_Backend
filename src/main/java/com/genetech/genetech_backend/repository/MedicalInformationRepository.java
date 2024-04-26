package com.genetech.genetech_backend.repository;

import com.genetech.genetech_backend.model.MedicalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalInformationRepository extends JpaRepository<MedicalInformation, Long> {
}
