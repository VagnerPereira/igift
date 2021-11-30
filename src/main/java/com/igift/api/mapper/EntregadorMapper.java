package com.igift.api.mapper;

import com.igift.api.Dto.response.EntregadorDto;
import com.igift.api.domain.Entregador;

public class EntregadorMapper {

    public static EntregadorDto FromDomainToDto (Entregador entregador) {
        return EntregadorDto.builder()
                .dataNascimento(entregador.getDataNascimento())
                .email(entregador.getEmail())
                .endereco(entregador.getEndereco())
                .nome(entregador.getNome())
                .id(entregador.getId())
                .build();
    }
}