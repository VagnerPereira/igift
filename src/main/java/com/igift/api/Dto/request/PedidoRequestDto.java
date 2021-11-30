package com.igift.api.Dto.request;

import com.igift.api.domain.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PedidoRequestDto {
    private Long idUsuario;
    private Long idLoja;
    private Endereco endereco;
    private List<Item> listaItens;
    private Double valorTotal;
    private Double valorItens;
    private Double valorFrete;
    private Long entregadorId;
    private boolean saiuParaEntrega;
    private boolean finalizado;
    private Cartao cartao;
}
