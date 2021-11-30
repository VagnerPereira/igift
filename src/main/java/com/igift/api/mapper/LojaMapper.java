package com.igift.api.mapper;

import com.igift.api.Dto.response.LojaDto;
import com.igift.api.domain.Loja;

public class LojaMapper {

    public static LojaDto toResponseFromDomain (Loja loja) {
        return LojaDto.builder()
                .email(loja.getEmail())
                .endereco(loja.getEndereco())
                .nome(loja.getNome())
                .categoria(loja.getCategoria())
                .id(loja.getId())
                .numeroTelefone(loja.getNumeroTelefone())
                .build();
    }
}
