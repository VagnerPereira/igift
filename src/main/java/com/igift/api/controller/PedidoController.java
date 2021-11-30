package com.igift.api.controller;

import com.igift.api.Dto.request.PedidoRequestDto;
import com.igift.api.Dto.response.PedidoResponseDto;
import com.igift.api.service.pedidoService.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.OK)
    public void salvarPedido (@RequestBody PedidoRequestDto requestDto) {
        pedidoService.salvarPedido(requestDto);
    }

    @GetMapping("/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public void retornarPedido (@PathVariable String idPedido) {
        pedidoService.retornarPedido(Long.getLong(idPedido));
    }

    @GetMapping("/{idLoja}")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoResponseDto> listarPedidosLoja (@PathVariable String idLoja) {
        return pedidoService.listarPedidosLoja(Long.getLong(idLoja));
    }

    @GetMapping("/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoResponseDto> listarPedidosUsuario (@PathVariable String idUsuario) {
        return pedidoService.listarPedidosUsuario(Long.getLong(idUsuario));
    }

    @PutMapping("/sairParaEntrega")
    @ResponseStatus(HttpStatus.OK)
    public void mudarStatusSaiuParaEntrega (@RequestBody String idPedido) {
        pedidoService.pedidoSaiuParaEntrega(Long.getLong(idPedido));
    }

    @PutMapping("/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public void entregarPedido (@RequestBody String idPedido) {
        pedidoService.entregarPedido(Long.getLong(idPedido));
    }

    @GetMapping("/listarItens/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public void listarItensPedido (@PathVariable String idPedido) {
        pedidoService.listarItensPedido(Long.getLong(idPedido));
    }

}
