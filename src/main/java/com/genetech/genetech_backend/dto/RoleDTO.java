package com.genetech.genetech_backend.dto;

import com.genetech.genetech_backend.model.User;

public class RoleDTO {
    private Long id;
    private String rol;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
