package com.igift.api.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@SequenceGenerator(name = "seq_cartao", sequenceName = "seq_cartao", allocationSize = 1)
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cartao")
    private Long id;

    private String nmDestinatario;

    private String nmRemetente;

    private String mensagem;

}
