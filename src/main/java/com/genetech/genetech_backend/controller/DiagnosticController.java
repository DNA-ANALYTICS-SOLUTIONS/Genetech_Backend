package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.dto.DiagnosticDto;
import com.genetech.genetech_backend.model.Diagnostic;
import com.genetech.genetech_backend.service.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiagnosticController {
    @Autowired
    private DiagnosticService diagnosticService;

    //Regitrar Diagnóstico (US-14)
    @PostMapping("/RegisterDiagnostic")
    public ResponseEntity<Diagnostic> Register(@RequestBody DiagnosticDto diDto){
        return new ResponseEntity<>(diagnosticService.Register(diDto), HttpStatus.CREATED);
    }
}
