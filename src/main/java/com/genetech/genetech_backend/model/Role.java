package com.genetech.genetech_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;
import org.springframework.security.core.GrantedAuthority;
@Entity
@Data
@Table(name = "Roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }

    public void setAuthority(String authority){
        this.role = role;
    }

    public Role(String role) {
        this.role = role;
    }
}
