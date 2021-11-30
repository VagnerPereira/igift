package com.igift.api.repository;

import com.igift.api.domain.Item;
import com.igift.api.domain.Loja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LojaRepository extends CrudRepository<Loja, Long> {

    @Query(value = "Select * from loja lo where lo.id = ?1", nativeQuery = true)
    Loja retornarLoja (Long idLoja);

    @Query(value = "Select * from loja", nativeQuery = true)
    List<Loja> retornarLojas ();

    @Query(value = "Select * from item it inner join loja loj on it.id_loja = loja.id and loj.id = ?1", nativeQuery = true)
    List<Item> retornarItensLoja (Long lojaId);

}
