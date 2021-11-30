package com.igift.api.Dto.response;

import com.igift.api.domain.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PedidoResponseDto {
    private Long id;
    private UsuarioDto usuarioDto;
    private LojaDto lojaDto;
    private Endereco endereco;
    private List<Item> listaItens;
    private Double valorTotal;
    private Double valorItens;
    private Double valorFrete;
    private EntregadorDto entregadorDto;
    private boolean saiuParaEntrega;
    private boolean finalizado;
    private Cartao cartao;
}
