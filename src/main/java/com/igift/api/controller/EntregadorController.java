package com.igift.api.controller;

import com.igift.api.Dto.response.EntregadorDto;
import com.igift.api.Dto.response.PedidoResponseDto;
import com.igift.api.domain.Entregador;
import com.igift.api.domain.UserLogin;
import com.igift.api.service.entregadorService.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("entregador")
public class EntregadorController {

    @Autowired
    EntregadorService entregadorService;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.OK)
    public void salvarEntregador (@RequestBody Entregador entregador) {
        entregadorService.salvarEntregador(entregador);
    }

    @GetMapping("/{idEntregador}")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoResponseDto> listarPedidosEntregador (@PathVariable String idEntregador) {
        return entregadorService.listarPedidosEntregador(Long.getLong(idEntregador));
    }

    @GetMapping("/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public EntregadorDto retornarEntregador (@PathVariable String idEntregador) {
        return entregadorService.retornarEntregador(Long.getLong(idEntregador));
    }

    @PostMapping("/logar")
    @ResponseStatus(HttpStatus.OK)
    public EntregadorDto logar(@RequestBody UserLogin userLogin) {
        return entregadorService.logar(userLogin);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<EntregadorDto> listarEntregadores () {
        return entregadorService.listarEntregadores();
    }

}
