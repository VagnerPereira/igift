package com.igift.api.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido", allocationSize = 1)
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_loja")
    private Loja loja;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ManyToMany
    @JoinTable(name = "id_item")
    private List<Item> listaItens;

    private Double valorTotal;

    private Double valorItens;

    private Double valorFrete;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_entregador")
    private Entregador entregador;

    private boolean saiuParaEntrega;

    private boolean finalizado;

    @OneToOne
    @JoinColumn(name = "id_cartao")
    private Cartao cartao;
}
