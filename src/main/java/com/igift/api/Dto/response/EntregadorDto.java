package com.igift.api.Dto.response;

import com.igift.api.domain.Endereco;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EntregadorDto {
    private long id;
    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private String email;
}
