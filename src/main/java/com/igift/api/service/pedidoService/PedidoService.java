package com.igift.api.service.pedidoService;

import com.igift.api.Dto.request.AdicionarItemPedidoRequest;
import com.igift.api.Dto.request.PedidoRequestDto;
import com.igift.api.Dto.response.PedidoResponseDto;
import com.igift.api.domain.Item;

import java.util.List;

public interface PedidoService {

    void salvarPedido (PedidoRequestDto requestDto);

    PedidoResponseDto retornarPedido (Long idPedido);

    List<PedidoResponseDto> listarPedidosLoja (Long idLoja);

    List<PedidoResponseDto> listarPedidosUsuario (Long usuario);

    void pedidoSaiuParaEntrega (Long idPedido);

    void entregarPedido (Long idPedido);

    List<Item> listarItensPedido (Long idPedido);

    void adicionarItemPedido (AdicionarItemPedidoRequest adicionarItemPedidoRequest);

}
