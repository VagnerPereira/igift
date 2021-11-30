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
public class Cartao {

    @Id
    private Long id;

    private String nmDestinatario;

    private String nmRemetente;

    private String mensagem;

}
