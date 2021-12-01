package com.igift.api.repository;

import com.igift.api.domain.Loja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LojaRepository extends CrudRepository<Loja, Long> {

    @Query(value = "Select * from loja loj where loj.id = ?1", nativeQuery = true)
    Loja retornarLoja (Long idLoja);

    @Query(value = "Select * from loja", nativeQuery = true)
    List<Loja> retornarLojas ();

}
