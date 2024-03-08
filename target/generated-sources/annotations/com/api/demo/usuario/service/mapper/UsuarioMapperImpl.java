package com.api.demo.usuario.service.mapper;

import com.api.demo.usuario.entity.TelefonoEntity;
import com.api.demo.usuario.entity.UsuarioEntity;
import com.api.demo.usuario.service.dto.TelefonoDto;
import com.api.demo.usuario.service.dto.UsuarioDto;
import com.api.demo.usuario.service.dto.UsuarioResponseDto;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-08T15:01:18-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioResponseDto usuarioEntityToUsuarioResponseDto(UsuarioEntity usuarioEntity) {
        if ( usuarioEntity == null ) {
            return null;
        }

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();

        usuarioResponseDto.setUsuario( usuarioEntityToUsuarioDto( usuarioEntity ) );
        usuarioResponseDto.setId( usuarioEntity.getId() );
        usuarioResponseDto.setCreated( usuarioEntity.getFechaAlta() );
        usuarioResponseDto.setModified( usuarioEntity.getFechaModificacion() );
        usuarioResponseDto.setLastLogin( usuarioEntity.getFechaUltimoIngreso() );
        usuarioResponseDto.setToken( usuarioEntity.getToken() );
        usuarioResponseDto.setActive( usuarioEntity.getActive() );

        return usuarioResponseDto;
    }

    protected TelefonoDto telefonoEntityToTelefonoDto(TelefonoEntity telefonoEntity) {
        if ( telefonoEntity == null ) {
            return null;
        }

        TelefonoDto telefonoDto = new TelefonoDto();

        telefonoDto.setNumber( telefonoEntity.getNumber() );
        telefonoDto.setCitycode( telefonoEntity.getCitycode() );
        telefonoDto.setContrycode( telefonoEntity.getContrycode() );

        return telefonoDto;
    }

    protected Set<TelefonoDto> telefonoEntitySetToTelefonoDtoSet(Set<TelefonoEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<TelefonoDto> set1 = new HashSet<TelefonoDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TelefonoEntity telefonoEntity : set ) {
            set1.add( telefonoEntityToTelefonoDto( telefonoEntity ) );
        }

        return set1;
    }

    protected UsuarioDto usuarioEntityToUsuarioDto(UsuarioEntity usuarioEntity) {
        if ( usuarioEntity == null ) {
            return null;
        }

        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setName( usuarioEntity.getName() );
        usuarioDto.setEmail( usuarioEntity.getEmail() );
        usuarioDto.setPassword( usuarioEntity.getPassword() );
        usuarioDto.setPhones( telefonoEntitySetToTelefonoDtoSet( usuarioEntity.getTelefonos() ) );

        return usuarioDto;
    }
}
