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
public class Loja {

    @Id
    private Long id;

    private String senha;

    private String nome;

    private String numeroTelefone;

    private String email;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

}
