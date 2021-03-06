package com.igift.api.service.lojaService;

import com.igift.api.Dto.request.AdicionarItemRequestDto;
import com.igift.api.Dto.response.LojaDto;
import com.igift.api.domain.Item;
import com.igift.api.domain.Loja;
import com.igift.api.mapper.ItemMapper;
import com.igift.api.mapper.LojaMapper;
import com.igift.api.repository.EnderecoRepository;
import com.igift.api.repository.ItemRepository;
import com.igift.api.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LojaServiceImpl implements LojaService {

    @Autowired
    LojaRepository repository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void salvarLoja(Loja loja) {
        enderecoRepository.save(loja.getEndereco());
        repository.save(loja);
    }

    @Override
    public LojaDto retornarLoja(Long idLoja) {
        return LojaMapper.toResponseFromDomain(repository.retornarLoja(idLoja));
    }

    @Override
    public List<LojaDto> retornarListaLojas() {
        return repository.retornarLojas().stream().map(LojaMapper::toResponseFromDomain).collect(Collectors.toList());
    }

    @Override
    public List<Item> retornarItensLoja(Long idLoja) {
        return itemRepository.retornarItensLoja(idLoja);
    }

    @Override
    public void adicionarItem(AdicionarItemRequestDto itemRequest) {
        Loja loja = repository.retornarLoja(itemRequest.getIdLoja());
        itemRepository.save(ItemMapper.fromRequestToDomain(itemRequest, loja));
    }

}
