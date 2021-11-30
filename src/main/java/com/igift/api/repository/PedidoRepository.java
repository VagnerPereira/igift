package com.igift.api.repository;

import com.igift.api.domain.Item;
import com.igift.api.domain.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository  extends CrudRepository<Pedido, Long> {

    @Query(value = "Select * from pedido ped where ped.id = ?1", nativeQuery = true)
    Pedido retornarPedido (Long idPedido);

    @Query(value = "Select * from pedido ped where ped.id_entregador = ?1", nativeQuery = true)
    List<Pedido> listarPedidosEntregador (Long idEntregador);

    @Query(value = "Select * from pedido ped where ped.id_loja = ?1", nativeQuery = true)
    List<Pedido> listarPedidosLoja (Long idLoja);

    @Query(value = "Select * from pedido ped where ped.id_usuario = ?1", nativeQuery = true)
    List<Pedido> listarPedidosUsuario (Long idUsuario);

    @Query(value = "Update pedido ped set ped.saiu_para_entrega = true where ped.id = ?1", nativeQuery = true)
    List<Pedido> pedidoSaiuParaEntrega (Long idPedido);

    @Query(value = "Update pedido ped set ped.finalizado = true where ped.id = ?1", nativeQuery = true)
    List<Pedido> entregarPedido (Long idPedido);

    @Query(value = "Select * from item it inner join id_item idIt on idIt.lista_itens_id = it.id where idIt.pedido_id = ?1", nativeQuery = true)
    List<Item> listarItensPedido (Long idPedido);

    @Query(value = "insert into id_item (pedido_id, lista_itens_id) values (?1, ?2)", nativeQuery = true)
    void adicionarItemPedido (Long idPedido, Long idITem);

}
