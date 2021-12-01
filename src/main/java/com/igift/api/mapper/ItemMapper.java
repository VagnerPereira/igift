package com.igift.api.mapper;


import com.igift.api.Dto.request.AdicionarItemRequestDto;
import com.igift.api.domain.Item;
import com.igift.api.domain.Loja;

public class ItemMapper {

    public static Item fromRequestToDomain (AdicionarItemRequestDto adicionarItemRequestDto, Loja loja) {
        return Item.builder()
                .valorUnitario(adicionarItemRequestDto.getValorUnitario())
                .categoria(adicionarItemRequestDto.getCategoria())
                .loja(loja)
                .nome(adicionarItemRequestDto.getNome())
                .build();
    }

}
