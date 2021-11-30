package com.igift.api.repository;

import com.igift.api.domain.Entregador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntregadorRepository extends CrudRepository<Entregador, Long> {

    @Query(value = "Select * from entregador ent where ent.id = ?1", nativeQuery = true)
    Entregador retornaEntregador (Long idEntregador);

    @Query(value = "Select * from entregador ent where ent.email = ?1 and ent.senha = ?2", nativeQuery = true)
    Entregador logar (String email, String senha);

    @Query(value = "Select * from entregador ", nativeQuery = true)
    List<Entregador> listarEntregadores ();

}
