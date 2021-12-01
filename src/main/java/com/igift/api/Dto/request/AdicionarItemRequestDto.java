package com.igift.api.Dto.request;

import com.igift.api.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AdicionarItemRequestDto {

    private Long idLoja;

    private String nome;

    private double valorUnitario;

    private Categoria categoria;
}
