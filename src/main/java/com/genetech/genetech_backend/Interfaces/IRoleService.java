package com.genetech.genetech_backend.Interfaces;

import com.genetech.genetech_backend.model.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role rol);

    public List<Role> list();

    public void delete(Long idRol);

    public Role listarId(Long idRol);
}
