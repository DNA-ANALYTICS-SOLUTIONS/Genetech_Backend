package com.genetech.genetech_backend.service;

import com.genetech.genetech_backend.Interfaces.IUserService;
import com.genetech.genetech_backend.model.User;
import com.genetech.genetech_backend.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public void insert(User usuario) {
        uR.save(usuario);
    }

    @Override
    public List<User> list() {
        return uR.findAll();
    }

    @Override
    public void delete(Long idUsuario) {
        uR.deleteById(idUsuario);
    }

    @Override
    public User listarId(Long idUsuario) {
        return uR.findById(idUsuario).orElse(new User());
    }
}
