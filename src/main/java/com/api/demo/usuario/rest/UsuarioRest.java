package com.api.demo.usuario.rest;

import com.api.demo.usuario.service.UsuarioService;
import com.api.demo.usuario.service.dto.UsuarioDto;
import com.api.demo.usuario.service.dto.UsuarioResponseDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/usuario")
@Slf4j
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping(value = "",  produces="application/json",consumes = "application/json")
    public ResponseEntity<UsuarioResponseDto> crearUsuarioConToken(@RequestBody @Valid UsuarioDto usuarioDto) {

        UsuarioResponseDto result = usuarioService.crearUsuarioConToken(usuarioDto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
