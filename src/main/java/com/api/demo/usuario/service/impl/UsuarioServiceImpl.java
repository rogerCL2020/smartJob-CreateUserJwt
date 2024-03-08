package com.api.demo.usuario.service.impl;

import com.api.demo.common.CustomException;
import com.api.demo.common.security.JwtUtil;
import com.api.demo.usuario.entity.TelefonoEntity;
import com.api.demo.usuario.entity.UsuarioEntity;
import com.api.demo.usuario.repository.UsuarioRepository;
import com.api.demo.usuario.service.UsuarioService;
import com.api.demo.usuario.service.dto.UsuarioDto;
import com.api.demo.usuario.service.dto.UsuarioResponseDto;
import com.api.demo.usuario.service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    UsuarioMapper usuarioMapper;

    @Value("${message.usuario.existe.guardado}")
    private String messageUsuario;

    @Override
    public UsuarioResponseDto crearUsuarioConToken(UsuarioDto usuarioDto) {

        if (usuarioRepository.existsByEmail(usuarioDto.getEmail())) {
            throw new CustomException(messageUsuario, HttpStatus.UNAUTHORIZED);
        }

        LocalDate now = LocalDate.now();

        try{

            UsuarioEntity usuarioEntity = new UsuarioEntity();
            usuarioEntity.setId(UUID.randomUUID());
            usuarioEntity.setName(usuarioDto.getName());
            usuarioEntity.setEmail(usuarioDto.getEmail());
            usuarioEntity.setPassword(usuarioDto.getPassword());

            Set<TelefonoEntity> telefonosEntity = new HashSet<>();

            usuarioDto.getPhones().forEach(tel -> telefonosEntity.add(new TelefonoEntity(0L,tel.getNumber(),tel.getCitycode(),tel.getContrycode(),usuarioEntity)));

            usuarioEntity.setTelefonos(telefonosEntity);
            usuarioEntity.setFechaAlta(now);
            usuarioEntity.setFechaUltimoIngreso(now);

            usuarioEntity.setToken(jwtUtil.generateToken(usuarioEntity));
            usuarioEntity.setActive(true);

            var usuarioCreated = usuarioRepository.save(usuarioEntity);

            return usuarioMapper.usuarioEntityToUsuarioResponseDto(usuarioCreated);

        }catch (Exception e){

                throw new CustomException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
