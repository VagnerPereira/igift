package com.igift.api.service.lojaService;

import com.igift.api.Dto.request.AdicionarItemRequestDto;
import com.igift.api.Dto.response.LojaDto;
import com.igift.api.domain.Item;
import com.igift.api.domain.Loja;

import java.util.List;

public interface LojaService {

    void salvarLoja (Loja loja);

    LojaDto retornarLoja (Long idLoja);

    List<LojaDto> retornarListaLojas ();

    List<Item> retornarItensLoja (Long idLoja);

    void adicionarItem (AdicionarItemRequestDto itemRequest);

}
