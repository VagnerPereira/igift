package com.igift.api.domain;

import com.igift.api.enums.Categoria;
import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@SequenceGenerator(name = "seq_loja", sequenceName = "seq_loja", allocationSize = 1)
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_loja")
    private Long id;

    private String senha;

    private String nome;

    private String numeroTelefone;

    @Column(unique=true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

}
