package com.api.demo.usuario.service.mapper;
import com.api.demo.usuario.entity.UsuarioEntity;
import com.api.demo.usuario.service.dto.UsuarioResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "created", source = "fechaAlta")
    @Mapping(target = "modified", source = "fechaModificacion")
    @Mapping(target = "lastLogin", source = "fechaUltimoIngreso")
    @Mapping(target = "token", source = "token")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "usuario.name", source = "name")
    @Mapping(target = "usuario.email", source = "email")
    @Mapping(target = "usuario.password", source = "password")
    @Mapping(target = "usuario.phones", source = "telefonos")
    UsuarioResponseDto usuarioEntityToUsuarioResponseDto(UsuarioEntity usuarioEntity);

}
