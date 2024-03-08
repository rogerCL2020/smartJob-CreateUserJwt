package com.api.demo.usuario.service;

import com.api.demo.usuario.service.dto.UsuarioDto;
import com.api.demo.usuario.service.dto.UsuarioResponseDto;

public interface UsuarioService {

    UsuarioResponseDto crearUsuarioConToken(UsuarioDto usuarioDto);

}
