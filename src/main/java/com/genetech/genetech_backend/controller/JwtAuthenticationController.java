package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.security.JwtRequest;
import com.genetech.genetech_backend.security.JwtResponse;
import com.genetech.genetech_backend.security.JwtTokenUtil;
import com.genetech.genetech_backend.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    //Prueba
    @GetMapping("/cualquiera/prueba")
    public ResponseEntity<String> prueba2 () {
        return  ResponseEntity.ok("Respuesta desde un endpoint - Requiere autenticación");
    }
    @GetMapping("/doctor/prueba")
    public ResponseEntity<String> prueba3 () {
        return  ResponseEntity.ok("Respuesta desde un endpoint - Requiere autenticación y autorizacion: DOCTOR");
    }
    @GetMapping("/patient/prueba")
    public ResponseEntity<String> prueba4 () {
        return  ResponseEntity.ok("Respuesta desde un endpoit sin restriccion - Requiere autenticación y autorizacion: PATIENT");
    }
    //
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}


