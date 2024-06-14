package com.genetech.genetech_backend.repository;

import com.genetech.genetech_backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByRol(String rol);
}
