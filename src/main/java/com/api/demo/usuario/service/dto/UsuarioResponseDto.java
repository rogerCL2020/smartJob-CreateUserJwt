package com.api.demo.usuario.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class UsuarioResponseDto {

    private UsuarioDto usuario;

    private UUID id;

    private LocalDate created;

    private LocalDate modified;

    private LocalDate lastLogin;

    private String token;

    private Boolean active;

}
