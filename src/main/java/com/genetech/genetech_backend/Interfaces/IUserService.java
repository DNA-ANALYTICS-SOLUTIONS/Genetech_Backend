package com.genetech.genetech_backend.Interfaces;

import com.genetech.genetech_backend.model.User;

import java.util.List;

public interface IUserService {
    public void insert(User usuario);

    public List<User> list();

    public void delete(Long idUsuario);

    public User listarId(Long idUsuario);
}
