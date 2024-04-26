package com.genetech.genetech_backend.service;

import com.genetech.genetech_backend.dto.DiagnosticDto;
import com.genetech.genetech_backend.model.Diagnostic;
import com.genetech.genetech_backend.repository.DiagnosticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticService {
    @Autowired
    private DiagnosticRepository diagnosticRepository;

    //Regitrar Diagnóstico(US-14)
    public Diagnostic Register(DiagnosticDto diDto){
        Diagnostic diagnostic = new Diagnostic(diDto.getDescription(), diDto.getAppointment());
        return diagnosticRepository.save(diagnostic);
    }

}
