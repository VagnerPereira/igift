package com.igift.api.Dto.response;

import com.igift.api.domain.Endereco;
import com.igift.api.enums.Categoria;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LojaDto {
    private Long id;
    private String nome;
    private String numeroTelefone;
    private String email;
    private Categoria categoria;
    private Endereco endereco;
}
