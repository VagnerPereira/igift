package com.igift.api.service.entregadorService;

import com.igift.api.Dto.response.EntregadorDto;
import com.igift.api.Dto.response.PedidoResponseDto;
import com.igift.api.domain.Entregador;
import com.igift.api.domain.UserLogin;
import com.igift.api.mapper.EntregadorMapper;
import com.igift.api.mapper.PedidoMapper;
import com.igift.api.repository.EnderecoRepository;
import com.igift.api.repository.EntregadorRepository;
import com.igift.api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntregadorServiceImpl implements EntregadorService {

    @Autowired
    EntregadorRepository repository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public void salvarEntregador(Entregador entregador) {
        enderecoRepository.save(entregador.getEndereco());
        repository.save(entregador);
    }

    @Override
    public List<PedidoResponseDto> listarPedidosEntregador(Long idEntregador) {
        return pedidoRepository.listarPedidosEntregador(idEntregador).stream().map(PedidoMapper::toResponseFromDomain).collect(Collectors.toList());
    }

    @Override
    public EntregadorDto retornarEntregador(Long idEntregador) {
        return EntregadorMapper.FromDomainToDto(repository.retornaEntregador(idEntregador));
    }

    @Override
    public EntregadorDto logar(UserLogin userLogin) {
        return EntregadorMapper.FromDomainToDto(repository.logar(userLogin.getLogin(), userLogin.getSenha()));
    }

    @Override
    public List<EntregadorDto> listarEntregadores() {
        return repository.listarEntregadores().stream().map(EntregadorMapper::FromDomainToDto).collect(Collectors.toList());
    }
}
