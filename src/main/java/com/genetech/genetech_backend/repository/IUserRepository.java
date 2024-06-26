package com.genetech.genetech_backend.repository;

import com.genetech.genetech_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username); //encontrar usuario por username

    @Query("SELECT u FROM User u JOIN u.roles r WHERE u.speciality = :speciality AND r.rol = 'DOCTOR'")
    List<User> findDoctorsBySpeciality(@Param("speciality") String speciality);


    //BUSCAR POR NOMBRE
    @Query("select  u from User u where u.username = :username")
    public User buscarUsername(@Param("username") String username);

    //Listar Doctores
    @Query("select u.id from User u where u.username = :username")
    public long findUserIdByUsername(@Param("username") String username);

    public User findByFullname(String fullname);
    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);


    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.rol = 'Doctor'")
    List<User> findDoctors();

}
