package com.igift.api.service.pedidoService;

import com.igift.api.Dto.request.AdicionarItemPedidoRequest;
import com.igift.api.Dto.request.PedidoRequestDto;
import com.igift.api.Dto.response.PedidoResponseDto;
import com.igift.api.domain.*;
import com.igift.api.mapper.PedidoMapper;
import com.igift.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    PedidoRepository repository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    LojaRepository lojaRepository;

    @Autowired
    EntregadorRepository entregadorRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void salvarPedido(PedidoRequestDto requestDto) {
        Entregador entregador = entregadorRepository.retornaEntregador(requestDto.getEntregadorId());
        Usuario usuario = usuarioRepository.retornarUsuario(requestDto.getIdUsuario());
        Loja loja = lojaRepository.retornarLoja(requestDto.getIdLoja());
        enderecoRepository.save(requestDto.getEndereco());
        cartaoRepository.save(requestDto.getCartao());
        Pedido pedido = Pedido.builder()
                .cartao(requestDto.getCartao())
                .endereco(requestDto.getEndereco())
                .entregador(entregador)
                .finalizado(false)
                .listaItens(carregaItens(requestDto.getListaItensId()))
                .saiuParaEntrega(false)
                .loja(loja)
                .usuario(usuario)
                .valorFrete(requestDto.getValorFrete())
                .valorItens(requestDto.getValorItens())
                .valorTotal(requestDto.getValorTotal())
                .build();
        repository.save(pedido);
    }

    @Override
    public PedidoResponseDto retornarPedido(Long idPedido) {
        return PedidoMapper.toResponseFromDomain(repository.retornarPedido(idPedido));
    }

    @Override
    public List<PedidoResponseDto> listarPedidosLoja(Long idLoja) {
        return repository.listarPedidosLoja(idLoja).stream().map(PedidoMapper::toResponseFromDomain).collect(Collectors.toList());
    }

    @Override
    public List<PedidoResponseDto> listarPedidosUsuario(Long idUsuario) {
        return repository.listarPedidosUsuario(idUsuario).stream().map(PedidoMapper::toResponseFromDomain).collect(Collectors.toList());
    }

    @Override
    public void pedidoSaiuParaEntrega(Long idPedido) {
        repository.pedidoSaiuParaEntrega(idPedido);
    }

    @Override
    public void entregarPedido(Long idPedido) {
        repository.entregarPedido(idPedido);
    }

    @Override
    public List<Item> listarItensPedido(Long idPedido) {
        return repository.listarItensPedido(idPedido);
    }

    @Override
    public void adicionarItemPedido(AdicionarItemPedidoRequest adicionarItemPedidoRequest) {
        repository.adicionarItemPedido(adicionarItemPedidoRequest.getIdPedido(), adicionarItemPedidoRequest.getIdItem());
    }

    private List<Item> carregaItens (List<Long> itensId) {
        List<Item> itens = new ArrayList<>();
        itensId.forEach(itemId -> itens.add(itemRepository.retornarItem(itemId)));
        return itens;
    }
}
