package com.genetech.genetech_backend.controller;

import com.genetech.genetech_backend.Interfaces.IRoleService;
import com.genetech.genetech_backend.dto.RoleDTO;
import com.genetech.genetech_backend.model.Role;
import com.genetech.genetech_backend.model.User;
import com.genetech.genetech_backend.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RoleController {
    @Autowired
    private IRoleService rS;

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/user/role")
    public void registrar(@RequestBody RoleDTO dto) {
        User user = userRepository.findByUsername(dto.getUsername());
        if(user != null){
            Role r = new Role();
            r.setRol(dto.getRol());
            r.setUser(user);
            rS.insert(r);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    @PutMapping
    public void modificar(@RequestBody RoleDTO dto) {
        Role existingRole = rS.listarId(dto.getId());
        if (existingRole != null) {
            User user = userRepository.findByUsername(dto.getUsername());
            if (user != null) {
                existingRole.setRol(dto.getRol());
                existingRole.setUser(user);
                rS.insert(existingRole);
            } else {
                throw new RuntimeException("Usuario no encontrado");
            }
        } else {
            throw new RuntimeException("Rol no encontrado");
        }
    }

    @DeleteMapping("/role/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        rS.delete(id);
    }

    @GetMapping("/role/{id}")
    public RoleDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        RoleDTO dto = m.map(rS.listarId(id), RoleDTO.class);
        return dto;
    }

    @GetMapping("/role")
    public List<RoleDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }

}