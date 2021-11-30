package com.igift.api.mapper;

import com.igift.api.Dto.response.PedidoResponseDto;
import com.igift.api.domain.Pedido;

public class PedidoMapper {

    public static PedidoResponseDto toResponseFromDomain (Pedido pedido) {
        return PedidoResponseDto.builder()
                .cartao(pedido.getCartao())
                .endereco(pedido.getEndereco())
                .entregadorDto(EntregadorMapper.FromDomainToDto(pedido.getEntregador()))
                .id(pedido.getId())
                .finalizado(pedido.isFinalizado())
                .listaItens(pedido.getListaItens())
                .lojaDto(LojaMapper.toResponseFromDomain(pedido.getLoja()))
                .saiuParaEntrega(pedido.isSaiuParaEntrega())
                .usuarioDto(UsuarioMapper.toDomainFromDto(pedido.getUsuario()))
                .build();
    }

}
