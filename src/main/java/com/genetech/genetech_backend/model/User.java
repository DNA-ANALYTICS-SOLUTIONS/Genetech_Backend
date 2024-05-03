package com.genetech.genetech_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Setter
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Role> roles;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        //para que no expire
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //Para que no se bloquee la cuenta
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Para que expire las credenciales
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
