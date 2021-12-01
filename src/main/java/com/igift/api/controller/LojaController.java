package com.igift.api.controller;

import com.igift.api.Dto.request.AdicionarItemRequestDto;
import com.igift.api.Dto.response.LojaDto;
import com.igift.api.domain.Item;
import com.igift.api.domain.Loja;
import com.igift.api.service.lojaService.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loja")
public class LojaController {

    @Autowired
    LojaService lojaService;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.OK)
    public void salvarLoja (@RequestBody Loja loja) {
        lojaService.salvarLoja(loja);
    }

    @GetMapping("/{idLoja}")
    @ResponseStatus(HttpStatus.OK)
    public LojaDto retornarLoja (@PathVariable String idLoja) {
        return lojaService.retornarLoja(Long.parseLong(idLoja));
    }

    @GetMapping("/listarLojas")
    @ResponseStatus(HttpStatus.OK)
    public List<LojaDto> listarLojas () {
        return lojaService.retornarListaLojas();
    }

    @GetMapping("/retornarItensLoja/{idLoja}")
    @ResponseStatus(HttpStatus.OK)
    public List<Item> listarItensLoja (@PathVariable String idLoja) {
        return lojaService.retornarItensLoja(Long.parseLong(idLoja));
    }

    @PostMapping("/item/adicionar")
    @ResponseStatus(HttpStatus.OK)
    public void adicionarItem (@RequestBody AdicionarItemRequestDto itemRequest) {
        lojaService.adicionarItem(itemRequest);
    }

}
