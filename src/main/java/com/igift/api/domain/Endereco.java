package com.igift.api.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Endereco {

    @Id
    private Long id;

    private String numero;

    private String cep;

    private String rua;

    private String complemento;
}
