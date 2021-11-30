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
public class Item {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_lojab")
    private Loja loja;

    private String nome;

    private String valorUnitario;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
