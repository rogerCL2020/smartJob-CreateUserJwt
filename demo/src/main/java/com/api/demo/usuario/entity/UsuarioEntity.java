package com.api.demo.usuario.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class UsuarioEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    protected LocalDate fechaAlta;

    @Temporal(TemporalType.DATE)
    private LocalDate fechaModificacion;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fechaUltimoIngreso;

    @Column(columnDefinition = "TEXT")
    private String token;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "usuario")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<TelefonoEntity> telefonos = new HashSet<>(0);

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}