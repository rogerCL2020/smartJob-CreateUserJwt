package com.api.demo.usuario.service.dto;

import com.api.demo.common.validation.ValueRequired;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "El formato del correo no es válido")
    private String email;

    @ValueRequired
    private String password;

    private Set<TelefonoDto> phones = new HashSet<>();

}
