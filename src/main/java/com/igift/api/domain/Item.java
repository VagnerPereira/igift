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
@SequenceGenerator(name = "swq_item", sequenceName = "swq_item", allocationSize = 1)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "swq_item")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_loja")
    private Loja loja;

    private String nome;

    private double valorUnitario;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
