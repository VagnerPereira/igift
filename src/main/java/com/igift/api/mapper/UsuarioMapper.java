package com.igift.api.mapper;

import com.igift.api.Dto.response.UsuarioDto;
import com.igift.api.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public static UsuarioDto toDomainFromDto (Usuario usuario) {
        return UsuarioDto.builder()
                .dataNascimento(usuario.getDataNascimento())
                .email(usuario.getEmail())
                .endereco(usuario.getEndereco())
                .isAdministrador(usuario.isAdministrador())
                .nome(usuario.getNome())
                .idUsuario(usuario.getId())
                .build();
    }

}
